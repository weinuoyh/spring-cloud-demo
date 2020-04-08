package com.jwt.controller;

import com.jwt.entity.JsonData;
import com.jwt.entity.SysUser;
import com.jwt.jwtUtils.JwtUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @GetMapping(value = "/login")
    @ResponseBody
    public JsonData login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //这个步骤就是获取user的全部信息不重要，直接忽略
//        SysUser sysUser = sysUserService.findByKeyword(username);
//        sysUser.setPassword(null);
//        String token = createPayLoad(sysUser.getId());
        SysUser sysUser = new SysUser();
        sysUser.setUsername(username);
        sysUser.setPassword(password);
        String token = createPayLoad(sysUser);
        return JsonData.success(token);
    }

    /**
     * JWT的组成：Header + payload + signature
     * Payload(载荷)的组成信息，私有声明(标准中注册的声明和公共的声明并未使用)
     * @param
     * @return token
     */
    private String createPayLoad(SysUser user) {
        Map<String, Object> payload = new HashMap<>();
        Date date = new Date();
        // 用户id
        payload.put("username", user.getUsername());
        payload.put("password", user.getPassword());
        // 生成时间:当前
        payload.put("iat", date.getTime());
        // 过期时间10分钟(单位毫秒)
        payload.put("ext", date.getTime() + 1000*60*10);
        return JwtUtil.createToken(payload);
    }
    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request){
        System.out.println("跳转页面喽");
        return "index";
    }

}
