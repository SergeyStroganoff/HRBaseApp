package com.stroganov;

import Manager.EntityManager;
import config.MainConfig;
import exception.ContactBusinessException;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here



        try {
            MainConfig.initConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EntityManager entityManager = new EntityManager();
        try {
            System.out.println( entityManager.findEntity("Род"));
        } catch (ContactBusinessException e) {
            e.printStackTrace();

        }


    }
}
