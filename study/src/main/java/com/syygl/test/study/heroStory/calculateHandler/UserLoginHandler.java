package com.syygl.test.study.heroStory.calculateHandler;

import com.syygl.test.study.heroStory.asyncTest.LoginService;

/**
 * Created by sunyy on 2020/3/29.
 */
public class UserLoginHandler {

    public void handle() {

        String userName = "";
        String password = "";

        // 执行用户登陆
        LoginService.getInstance().userLogin(
                userName,
                password,
                (userEntity) -> {
                    //回调函数的具体处理逻辑
                    //就是异步查询到用户信息后处理用户信息
                    if (null == userEntity) {
                        return null;
                    }

                    return null;
                });
    }


}
