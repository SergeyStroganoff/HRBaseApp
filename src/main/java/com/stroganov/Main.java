package com.stroganov;

import UIX.MainFrame;
import config.MainConfig;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            MainConfig.initConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
        
    }
}
