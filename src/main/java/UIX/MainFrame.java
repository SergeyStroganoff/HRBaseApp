/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIX;

import Manager.ConnectionManager;
import dao.ParamRequest;
import entities.Employee;
import exception.ContactBusinessException;
import org.apache.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainFrame extends javax.swing.JFrame {


    private static final Logger logger = Logger.getLogger(MainFrame.class);
    private final ConnectionManager connectionManager = new ConnectionManager();
    private javax.swing.JButton findButton;
    private javax.swing.JButton addButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTable employeeTable;
    private javax.swing.JTextField jTextField1;
    private ParamRequest paramRequest;

    public MainFrame() {
        initComponents();
    }

    protected static ParamRequest prepareParamRequest(String searchText) {

        ParamRequest paramRequest = null;

        if (searchText.matches("^\\d{1,6}$")) {
            paramRequest = new ParamRequest(Integer.parseInt(searchText));
        } else if (searchText.matches("^[а-яА-я]+$")) {
            paramRequest = new ParamRequest(searchText);
        } else if (searchText.matches("\\b[а-яА-я]+\\b\\s\\b[а-яА-я]+\\b")) {

            String[] stringBuf = searchText.split(" ");
            paramRequest = new ParamRequest(stringBuf[0].trim(), stringBuf[1].trim());
        }

        return paramRequest;
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ScrollPane = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        findButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        employeeTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        employeeTable.setShowGrid(true);
        Font f2 = new Font(Font.SANS_SERIF, Font.PLAIN, 14);
        employeeTable.setFont(f2);

        ScrollPane.setViewportView(employeeTable);

        findButton.setText("Поиск сотрудника");
        findButton.setActionCommand("Find");
        findButton.addActionListener(evt -> actionFind(evt));

        addButton.setText("Добавить сотрудника");
        addButton.addActionListener(actionEvent -> actionAddEmployee(actionEvent));

        deleteButton.setText("Удалить сотрудника");
        deleteButton.addActionListener(actionEvent -> actionDelete(actionEvent));

        editButton.setText("Редактировать запись");
        editButton.addActionListener(actionEvent -> actionEditContact(actionEvent));

        jTextField1.setText("Введите данные");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(ScrollPane, GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jTextField1, GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(findButton, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(addButton, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(6, 6, 6)))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(editButton, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 156, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(ScrollPane, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                                .addGap(19, 19, 19)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(findButton)
                                        .addComponent(addButton)
                                        .addComponent(deleteButton)
                                        .addComponent(editButton))
                                .addGap(20, 20, 20))
        );

        jMenu1.setText("Настройки");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("О программе");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
        this.setLocationRelativeTo(null);
        this.setSize(1600, 800);
    }// </editor-fold>/

    private void actionEditContact(ActionEvent actionEvent) {
        // Получаем выделенную строку
        int sr = employeeTable.getSelectedRow();
        // если строка выделена - можно ее редактировать
        if (sr != -1) {
            // Получаем ID объекта
            int id = Integer.parseInt(employeeTable.getModel().getValueAt(sr, 0).toString());
            // получаем данные объекта по его ID
            ParamRequest paramRequest = new ParamRequest(id);
            Employee employee = null;
            try {

                employee = connectionManager.findEntity(paramRequest).get(0);
                // Создаем диалог для ввода данных и передаем туда объект
                AddUpdateDialogFrame ecd = new AddUpdateDialogFrame(employee, connectionManager);
                // Обрабатываем закрытие диалога
                saveContact(ecd);

            } catch (ContactBusinessException e) {
                logger.error("Ошибка при редактировании", e);
                JOptionPane.showMessageDialog(this, "Ошибка при редактировании" + e.getMessage());
            }


        } else {
            // Если строка не выделена - сообщаем об этом
            JOptionPane.showMessageDialog(this, "Вы должны выделить строку для редактирования");
        }
    }

    private void actionAddEmployee(ActionEvent evt) {

        // Создаем диалог для ввода данных
        AddUpdateDialogFrame ecd = new AddUpdateDialogFrame(connectionManager);
        // Обрабатываем закрытие диалога
        try {
            saveContact(ecd);
        } catch (ContactBusinessException e) {
            logger.error("Ошибка при добавлении", e);
        }
    }

    private void actionDelete(ActionEvent evt) {

        // Получаем выделенную строку
        int sr = employeeTable.getSelectedRow();
        if (sr != -1) {
            // Получаем ID
            int id = Integer.parseInt(employeeTable.getModel().getValueAt(sr, 0).toString());

            try {
                // Удаляем объект и перегружаем если список был более 1.
                connectionManager.deleteEntity(id);
                // перегружаем список
                if (paramRequest != null) {
                    loadContact(paramRequest);
                }

            } catch (ContactBusinessException e) {
                logger.error("Возникла ошибка при удалении записи", e);
                JOptionPane.showMessageDialog(this, "Возникла ошибка при удалении записи " + e.getMessage());
            }

        } else {
            JOptionPane.showMessageDialog(this, "Вы должны выделить строку для удаления");
        }
    }

    private void actionFind(ActionEvent evt) {
        paramRequest = prepareParamRequest(jTextField1.getText().trim());
        if (paramRequest != null) {
            try {
                loadContact(paramRequest);
            } catch (ContactBusinessException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                logger.error("Ошибка поиска сотрудника" + e.getMessage(), e);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Запрос введен в неверном формате \n" +
                    "Введите табельный номер, либо Фамилию, либо Фамилию Имя");
        }
    }

    // Загрузить список
    private void loadContact(ParamRequest paramRequest) throws ContactBusinessException {

        //ParamRequest paramRequest = new ParamRequest(employeeString);
        List<Employee> employeeList = connectionManager.findEntity(paramRequest);
        // Создаем модель, которой передаем полученный список
        // Collections.sort(employeeList); // возможность сортировки списка при запросе //TODO
        if (!employeeList.isEmpty()) {
            TableModel tableModel = new TableModel(employeeList);
            // Передаем модель таблице
            employeeTable.setModel(tableModel);
        } else {
            JOptionPane.showMessageDialog(this, "Сотрудник с такими данными не найден");
        }
    }

    private void saveContact(AddUpdateDialogFrame ecd) throws ContactBusinessException { //todo
        // Если мы нажали кнопку SAVE
        if (ecd.isSave()) {
            // Получаем объект из диалогового окна
            Employee employee = ecd.getEmployee();
            if (employee.getID() != 0) {
                // Если ID у объекта есть, то мы его обновляем
                connectionManager.updateEntity(employee);
                if (paramRequest != null) loadContact(paramRequest);
            } else {
                // Если у объекта нет ID - значит он новый и мы его добавляем
                connectionManager.addEntity(employee);
                paramRequest = new ParamRequest(employee.getSurname(), employee.getFirstName());
            }

        }
    }

}
