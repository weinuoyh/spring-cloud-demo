package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("redis")
public class RedisController {
    /**
     * session测试
     * @param request
     * @return
     */
    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public Map<String, String> addSession (HttpServletRequest request){
        String sessionId = request.getSession().getId();
        String requestURI = request.getRequestURI() + ":"  +  request.getServerPort();
        // 向session中保存用户信息 key规则： user + "_" + uid
        request.getSession().setAttribute("user_1", "{uid:1,username:11@qq.com}");


        Map<String, String> sessionInfoMap = new HashMap<>(2);
        sessionInfoMap.put("sessionId", sessionId);
        sessionInfoMap.put("requestURI", requestURI);
        return sessionInfoMap;
    }

    /**
     * session测试
     * @param request
     * @return
     */
    @RequestMapping(value = "/getSession", method = RequestMethod.GET)
    public Map<String, String> getSession (HttpServletRequest request){
        String sessionId = request.getSession().getId();
        String requestURI = request.getRequestURI() + ":"  +  request.getServerPort();

        Map<String, String> sessionInfoMap = new HashMap<>(2);
        // 获取session中uid为1的用户的信息
        String user_1 = (String) request.getSession().getAttribute("user_1");

        sessionInfoMap.put("sessionId", sessionId);
        sessionInfoMap.put("requestURI", requestURI);
        sessionInfoMap.put("user_1", user_1);
        return sessionInfoMap;
    }


    /**
     * 注销登录
     * @param session
     * @return
     */
    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.invalidate();//使Session变成无效，及用户退出
        return "logout";
    }

    /**
     * 判断用户的session是否有效（在同一个浏览器中，同一个域中，每次Request请求，都会带上Session）
     * @param request
     * @return
     */
    @RequestMapping(value = "isValid",method = RequestMethod.GET)
    public String isSessionValid(HttpServletRequest request){
        //简化if-else表达式（其实很多地方可以简化的，这里为了方便新手朋友可以看得顺畅点，我尽量不简化）
        return request.isRequestedSessionIdValid() ? "ok":"no";
    }
    public static void main(String[] args) {

    }
}