package com.stroganov;

import Manager.ConnectionManager;
import config.MainConfig;
import dao.ParamRequest;
import entities.Employee;
import exception.ContactBusinessException;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here


        try {
            MainConfig.initConfig();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ConnectionManager connectionManager = new ConnectionManager();
        ParamRequest paramRequest = new ParamRequest(2);

        try {
            List<Employee> employeeList =  connectionManager.findEntity(paramRequest);
            employeeList.get(0).setSurname("main");
            connectionManager.addEntity(employeeList.get(0));
            connectionManager.deleteEntity(16);
        } catch (ContactBusinessException e) {
            e.printStackTrace();
        }

    }
}
