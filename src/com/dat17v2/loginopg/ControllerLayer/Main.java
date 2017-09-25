package com.dat17v2.loginopg.ControllerLayer;

import com.dat17v2.loginopg.DataLayer.Verification;
import com.dat17v2.loginopg.UILayer.UI;

public class Main {

    public static void main(String[] args){

        LoginController lc = new LoginController(new UI(), new Verification());
        lc.login();

    }
}
