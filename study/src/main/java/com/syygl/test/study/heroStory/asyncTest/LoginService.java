package com.syygl.test.study.heroStory.asyncTest;

import com.syygl.test.study.heroStory.processor.AsyncOperationProcessor;
import com.syygl.test.study.heroStory.processor.IAsyncOperation;

import java.util.function.Function;

/**
 * Created by sunyy on 2020/3/29.
 */
public class LoginService {
    /**
     * 单例对象
     */
    static private final LoginService _instance = new LoginService();

    /**
     * 私有化类默认构造器
     */
    private LoginService() {
    }

    /**
     * 获取单例对象
     *
     * @return 单例对象
     */
    static public LoginService getInstance() {
        return _instance;
    }




    /**
     * 用户登陆
     *
     * @param userName 用户名称
     * @param password 密码
     * @param callback 回调函数
     */
    public void userLogin(String userName, String password, Function<UserEntity, Void> callback) {

        // 创建异步操纵
        AsyncGetUserByName asyncOp = new AsyncGetUserByName(userName, password) {
            /**
             * 创建异步操作是重写doFinish方法，doFinish方法调用了回调函数
             */
            @Override
            public void doFinish() {
                if (null != callback) {
                    // 执行回调函数
                    callback.apply(this.getUserEntity());
                }
            }
        };

        // 执行异步操纵
        AsyncOperationProcessor.getInstance().process(asyncOp);
    }


    /**
     * 异步方式获取用户
     */
    private class AsyncGetUserByName implements IAsyncOperation {
        /**
         * 用户名称
         */
        private final String _userName;

        /**
         * 密码
         */
        private final String _password;

        /**
         * 用户实体
         */
        private UserEntity _userEntity = null;

        /**
         * 类参数构造器
         *
         * @param userName 用户名称
         * @param password 密码
         * @throws IllegalArgumentException if null == userName || null == password
         */
        AsyncGetUserByName(String userName, String password) {
            _userName = userName;
            _password = password;
        }

        /**
         * 获取用户实体
         *
         * @return 用户实体
         */
        public UserEntity getUserEntity() {
            return _userEntity;
        }

        @Override
        public int getBindId() {
            return _userName.charAt(_userName.length() - 1);
        }

        @Override
        public void doAsync() {
            //执行异步操作，获取userEntity
            UserEntity userEntity = new UserEntity();
            this._userEntity = userEntity;
        }
    }
}
