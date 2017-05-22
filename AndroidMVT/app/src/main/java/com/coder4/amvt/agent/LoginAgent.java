package com.coder4.amvt.agent;

/**
 * Created by coder4 on 2017/5/22.
 */

public class LoginAgent {

    public static LoginAgent shared = new LoginAgent();

    private boolean isLogin = false;

    private LoginAgent() {

    }

    public void login() {
        isLogin = true;
    }

    public void logout() {
        isLogin = false;
    }

    public boolean isLogin() {
        return isLogin;
    }
}
