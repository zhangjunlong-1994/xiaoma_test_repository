package com.pony.sc_home_personal.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pony.sc_home_personal.bean.base.ManagerBean;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;

/**
 * token工具类
 */
@Component
public class TokenUtil {

    private static String tokenKey;

    @Value("${token.key}")
    private void setTokenKey(String key) {
        TokenUtil.tokenKey = key;
    }

    private static RedisUtil redisUtil;

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        TokenUtil.redisUtil = redisUtil;
    }

    /**
     * 生成token（多点登录，有效期24小时）
     */
    public static String createToken(int type, String id) {
        String token = JWT.create()
                .withClaim("createDate", LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli())
                .sign(Algorithm.HMAC256(tokenKey));
        //redis缓存保存token
        Map<String, String> map = new HashMap<>();
        map.put("expiresDate", String.valueOf(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("+8")).toEpochMilli()));
        map.put("userType", String.valueOf(type));
        map.put("userId", String.valueOf(id));

        redisUtil.save(token, map, 24 * 3600);
        return token;
    }

    /**
     * 验证token
     */
    public static boolean verifyToken(String token) {
        Map<String, String> map = redisUtil.get(token);
        if (map == null || map.isEmpty()) {
            return false;
        } else {
            LocalDateTime expiresDate = LocalDateTime.ofInstant(
                    Instant.ofEpochMilli(Long.parseLong(map.get("expiresDate"))), ZoneOffset.of("+8"));
            if (LocalDateTime.now().isAfter(expiresDate)) {
                return false;
            } else {
                map.put("expiresDate", String.valueOf(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("+8")).toEpochMilli()));
                redisUtil.save(token, map, 24 * 3600);
                return true;
            }
        }
    }

    /**
     * 删除token
     */
    public static boolean deleteToken(String token) {
        return redisUtil.delete(token);
    }

    /**
     * 获取token负荷信息
     */
    public static Map<String, String> getTokenInfo(String token) {
        Map<String, String> map = redisUtil.get(token);
        if (map == null || map.isEmpty()) {
            return new HashMap<>();
        } else {
            LocalDateTime expiresDate = LocalDateTime.ofInstant(
                    Instant.ofEpochMilli(Long.parseLong(map.get("expiresDate"))), ZoneOffset.of("+8"));
            if (LocalDateTime.now().isAfter(expiresDate)) {
                return new HashMap<>();
            } else {
                map.put("expiresDate", String.valueOf(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("+8")).toEpochMilli()));
                redisUtil.save(token, map, 24 * 3600);
                return map;
            }
        }
    }

    /**
     * 获取管理员token中的信息
     *
     * @author chujialin
     * @date 2020/12/30 14:06
     **/
    public static ManagerBean getManagerTokenInfo(String token) {
        //验证有效性并返回
        try {
            String managerStr = JWT.decode(token).getClaim("staffBean").asString();
            return (ManagerBean) JSONObject.toBean(JSONObject.fromObject(managerStr), ManagerBean.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 保存管理员token（管理员登录时使用）
     *
     * @author chujialin
     * @date 2020/12/30 14:01
     **/
    public static boolean saveMangerToken(String token) {
        ManagerBean managerBean = getManagerTokenInfo(token);
        if (managerBean == null) {
            return false;
        } else {
            Map<String, String> map = new HashMap<>();
            map.put("expiresDate", String.valueOf(LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("+8")).toEpochMilli()));
            map.put("userType", "1");
            map.put("userId", String.valueOf(managerBean.getId()));

            redisUtil.save(token, map, 24 * 3600);
            return true;
        }
    }
}
