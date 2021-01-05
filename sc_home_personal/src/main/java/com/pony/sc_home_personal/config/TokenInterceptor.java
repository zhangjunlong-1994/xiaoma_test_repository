package com.pony.sc_home_personal.config;

import com.pony.sc_home_personal.util.TokenUtil;
import net.sf.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 自定义拦截器，拦截请求，验证token
 */
@Configuration
public class TokenInterceptor implements HandlerInterceptor {

//    @Resource
//    private PermissionFeign permissionFeign;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();


        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(CheckToken.class)) {
            CheckToken userToken = method.getAnnotation(CheckToken.class);
            if (userToken.required()) {
                // 执行认证
                if (token == null || token.length() == 0) {
                    httpServletResponse.reset();
                    httpServletResponse.setCharacterEncoding("utf-8");
                    httpServletResponse.setContentType("application/json");
                    httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
                    PrintWriter pw = httpServletResponse.getWriter();
                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("code", 30000);
                    jsonObject.put("message", "暂无token，请重新登录");
                    pw.print(jsonObject.toString());
                    pw.flush();
                    pw.close();
                    return false;
                } else {
                    // 验证token
                    Map<String, String> map = TokenUtil.getTokenInfo(token);
                    if (map.isEmpty()) {
                        httpServletResponse.reset();
                        httpServletResponse.setCharacterEncoding("utf-8");
                        httpServletResponse.setContentType("application/json");
                        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
                        PrintWriter pw = httpServletResponse.getWriter();
                        JSONObject jsonObject = new JSONObject();
                        jsonObject.put("code", 30000);
                        jsonObject.put("message", "token验证失败，请重新登录");
                        pw.print(jsonObject.toString());
                        pw.flush();
                        pw.close();
                        return false;
                    } else {
                        httpServletRequest.setAttribute("token", token);
                        httpServletRequest.setAttribute("userType", map.get("userType"));
                        httpServletRequest.setAttribute("userId", map.get("userId"));
                        httpServletRequest.setAttribute("companyId", map.get("companyId"));
                        httpServletRequest.setAttribute("departmentId", map.get("departmentId"));
                        httpServletRequest.setAttribute("positionId", map.get("positionId"));
                        httpServletRequest.setAttribute("professionId", map.get("professionId"));
                        httpServletRequest.setAttribute("modulesGroupId", map.get("modulesGroupId"));
                        httpServletRequest.setAttribute("manager", map.get("manager"));
//                        ViewBean<PermissionViewListBean> viewBean = permissionFeign.searchPermissionListByTypeAndPositionIdAndProfessionId
//                                (1, Long.parseLong(map.get("positionId")), 0);
//                        if (viewBean.getData().getPositionBeanList() != null && !viewBean.getData().getPositionBeanList().isEmpty()){
//                            List<PermissionViewBean> positionBeanList = viewBean.getData().getPositionBeanList();
//                            httpServletRequest.setAttribute("role", positionBeanList.get(0).getValue());
//                        }
                        return true;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
