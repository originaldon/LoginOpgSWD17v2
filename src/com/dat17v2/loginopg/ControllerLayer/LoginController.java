package com.dat17v2.loginopg.ControllerLayer;

import com.dat17v2.loginopg.AppLayer.User;
import com.dat17v2.loginopg.DataLayer.Verification;
import com.dat17v2.loginopg.UILayer.UI;

public class LoginController {

    private UI ui;
    private Verification vf;

    public LoginController(UI ui, Verification vf){

        this.ui = ui;
        this.vf = vf;

    }

    public void login(){

        User user = ui.getLogin();
        if (vf.verify(user.getLogin(), user.getPassword())){

            ui.granted();
        } else {

            ui.denied();
            login();
        }
    }
}
