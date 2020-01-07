package com.syygl.test.study.validationTest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by sunyy on 2019/12/24.
 */
@Controller
@RequestMapping("login")
public class LoginController {
    public String login(@Valid LoginForm loginForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError objectError : bindingResult.getAllErrors()) {
                objectError.getDefaultMessage();
            }
        }
        return "";
    }
}
