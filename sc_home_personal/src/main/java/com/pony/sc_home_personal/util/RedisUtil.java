package com.pony.sc_home_personal.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * redis缓存工具
 */
@Component
public class RedisUtil {

    private static String redisNodes;
    private static String master;
    private static JedisSentinelPool jedisSentinelPool = null;

    @Value("${spring.redis.sentinel.nodes}")
    public void setRedisNodes(String redisNodes) {
        RedisUtil.redisNodes = redisNodes;
    }

    @Value("${spring.redis.sentinel.master}")
    public void setMaster(String master) {
        RedisUtil.master = master;
    }

    /**
     * 初始化
     *
     * @author chujialin
     * @date 2020/12/29 14:55
     **/
    private void init() {
        Set<String> sentinels = new HashSet<>();
        String[] host = redisNodes.split(",");
        for (String redisHost : host) {
            String[] item = redisHost.split(":");
            String ip = item[0];
            int port = Integer.parseInt(item[1]);
            sentinels.add(new HostAndPort(ip, port).toString());
        }
        jedisSentinelPool = new JedisSentinelPool(master, sentinels);
    }

    /**
     * 保存
     *
     * @author chujialin
     * @date 2020/12/29 14:57
     **/
    public void save(String key, Map<String, String> value, int expire) {
        if (jedisSentinelPool == null) {
            this.init();
        }

        Jedis jedis = jedisSentinelPool.getResource();
        jedis.hmset(key, value);
        jedis.expire(key, expire);

        jedis.close();
    }

    /**
     * 查询
     *
     * @author chujialin
     * @date 2020/12/29 14:59
     **/
    public Map<String, String> get(String key) {
        if (jedisSentinelPool == null) {
            this.init();
        }

        Jedis jedis = jedisSentinelPool.getResource();
        Map<String, String> map = jedis.hgetAll(key);

        jedis.close();
        return map;
    }

    /**
     * 删除
     *
     * @author chujialin
     * @date 2020/12/29 14:59
     **/
    public boolean delete(String key) {
        if (jedisSentinelPool == null) {
            this.init();
        }

        Jedis jedis = jedisSentinelPool.getResource();
        if (jedis.exists(key)) {
            jedis.del(key);
            jedis.close();
            return true;
        } else {
            jedis.close();
            return false;
        }
    }
}

