package com.dat17v2.loginopg.UILayer;

import com.dat17v2.loginopg.AppLayer.User;

import java.util.Scanner;

public class UI {

    public UI(){

        System.out.println("Velkommen!");
    }

    public User getLogin(){

        Scanner input = new Scanner(System.in);

        System.out.print("Login: ");
        String login = input.next();

        System.out.print("Kodeord: ");
        String password = input.next();
        System.out.println();

        return new User(login, password);
    }

    public void granted(){

        System.out.println("Adgang opnået!");
    }

    public void denied(){

        System.out.println("Adgang nægtet!");
        System.out.println("Prøv igen");
    }
}
