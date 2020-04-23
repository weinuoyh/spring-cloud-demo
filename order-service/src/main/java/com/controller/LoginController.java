package com.controller;

import com.entity.User;
import com.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("login")
public class LoginController {
    @Autowired
    IUserService iUserService;
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @RequestMapping("/login")
    public Map<String, String> login(HttpServletRequest request, @RequestParam(value = "name") String name, @RequestParam(value = "password") String password){
        User user = iUserService.getByName(name);
        Map<String, String> sessionInfoMap = new HashMap<>(2);
        if(user!=null){
            String sessionId = request.getSession().getId();
            String requestURI = request.getRequestURI() + ":"  +  request.getServerPort();
            // 向session中保存用户信息 key规则： user + "_" + uid
            request.getSession().setAttribute(name, name);



            sessionInfoMap.put("sessionId", sessionId);
            sessionInfoMap.put("requestURI", requestURI);
            sessionInfoMap.put("result","成功");
            logger.info("成功");
        }else {
            logger.info("失败");
            sessionInfoMap.put("result","失败");
        }


        return sessionInfoMap;
    }
}
