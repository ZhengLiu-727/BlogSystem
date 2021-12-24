package site.liuzheng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.liuzheng.service.LoginService;
import site.liuzheng.vo.Result;
import site.liuzheng.vo.params.LoginParams;

/**
 * @author liuzheng
 */
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    public Result login(@RequestBody LoginParams loginParams){
        return loginService.login(loginParams);
    }
}
