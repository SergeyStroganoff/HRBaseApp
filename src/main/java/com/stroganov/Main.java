package com.stroganov;

import UIX.MainFrame;
import config.MainConfig;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	// write your code here


        try {
            MainConfig.initConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(() -> new MainFrame().setVisible(true));






     //   MainFrame mainFrame = new MainFrame();
     //   mainFrame.initFrame();
    /*
        ConnectionManager connectionManager = new ConnectionManager();
        ParamRequest paramRequest = new ParamRequest(20);

        try {
            List<Employee> employeeList =  connectionManager.findEntity(paramRequest);
            employeeList.get(0).setSurname("Свердлов");

            connectionManager.updateEntity(employeeList.get(0));
           // connectionManager.deleteEntity(employeeList.get(0).getID());
        } catch (ContactBusinessException e) {
            e.printStackTrace();
        }

     */

    }
}
