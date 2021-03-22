package UIX;


import Manager.ConnectionManager;
import entities.Department;
import entities.Employee;
import entities.Position;
import exception.ContactBusinessException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static Service.DataConverter.dataToString;
import static Service.DataConverter.getDateFromString;

public class AddUpdateDialogFrame extends javax.swing.JDialog implements ActionListener {

    private static final String SAVE = "SAVE";
    private static final String CANCEL = "CANCEL";
    ConnectionManager connectionManager;
    List<Department> departmentList = null;
    List<Position> positionList = null;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // Если это новый Id == null
    private Integer contactId = null;
    // Надо ли записывать изменения после закрытия диалога
    private boolean save = false;

    public AddUpdateDialogFrame(ConnectionManager connectionManager) {
        this(null, connectionManager);
    }

    public AddUpdateDialogFrame(Employee employee, ConnectionManager connectionManager) {

        initComponents();
        // Если  передали объект - заполняем поля формы
        initComboBoxes(connectionManager);
        initFields(employee);
        setModal(true);
        // Запрещаем изменение размеров
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Табельный номер");
        jLabel2.setText("Фамилия");
        jLabel3.setText("Имя");
        jLabel4.setText("Отчество");
        jLabel5.setText("Дата рождения");
        jLabel6.setText("Доступ к коммерческой тайне");
        jLabel7.setText("Должность");
        jLabel8.setText("Департамент (отдел)");

        jButton1.setText("Сохранить");
        jButton1.setActionCommand(SAVE);
        jButton1.addActionListener(this);

        jButton2.setText("Отменить");
        jButton2.setActionCommand(CANCEL);
        jButton2.addActionListener(this);

        jTextField1.setEditable(false);
        jTextField1.setText("0");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel7)
                                                        .addComponent(jLabel8))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                                                        .addComponent(jTextField3)
                                                        .addComponent(jTextField2)
                                                        .addComponent(jTextField1)
                                                        .addComponent(jTextField4)
                                                        .addComponent(jTextField6)
                                                        .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 115, Short.MAX_VALUE)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(194, 194, 194))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>

    protected void initComboBoxes(ConnectionManager connectionManager) {


        try {
            departmentList = connectionManager.getDepartmentList(null);
            positionList = connectionManager.getPositionList(null);

        } catch (ContactBusinessException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Ошибка при запросе списка департаментов и должностей" + e.getMessage());
        }

        for (Department nextDepartment : departmentList) {
            jComboBox2.addItem(nextDepartment.getDepartmentName());
        }
        for (Position nextPosition : positionList) {
            jComboBox1.addItem(nextPosition.getNamePosition());
        }
    }

    //  заполняем поля от объекта
    private void initFields(Employee employee) {
        if (employee != null) {
            contactId = employee.getID();
            jTextField1.setText(contactId.toString());
            jTextField2.setText(employee.getSurname());
            jTextField3.setText(employee.getFirstName());
            jTextField4.setText(employee.getSecondName());
            jTextField5.setText(dataToString(employee.getBirthDate()));

            String access = employee.getAccessSecret() ? "Оформлен" : "Не оформлен";
            jTextField6.setText(access);
            jComboBox1.setSelectedItem(employee.getPosition().getNamePosition());
            jComboBox2.setSelectedItem(employee.getDepartment().getDepartmentName());

        }
    }

    @Override
    // Обработка нажатий кнопок
    public void actionPerformed(ActionEvent ae) {
        String action = ae.getActionCommand();
        // Если нажали кнопку SAVE (сохранить изменения) - запоминаем этой
        save = SAVE.equals(action);
        // Закрываем форму
        if (save) {
            if (chekFields()) {
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Ошибка при вводе данных сотрудника");
            }
        } else setVisible(false);
    }

    // Надо ли сохранять изменения
    public boolean isSave() {
        return save;
    }

    // Создаем объект из заполненных полей,
    public Employee getEmployee() {

        String currentPositionName = (String) jComboBox1.getSelectedItem();
        String currentDepartmentName = (String) jComboBox2.getSelectedItem();
        Position position = null;
        Department department = null;

        for (Position p : positionList) {
            if (p.getNamePosition().equals(currentPositionName)) {
                position = p;
            }
        }
        for (Department dep : departmentList) {
            if (dep.getDepartmentName().equals(currentDepartmentName)) {
                department = dep;
            }
        }

        Boolean access = true;
        if (jTextField6.getText().contains("не")) {
            access = false;
        }

        return new Employee(
                Integer.parseInt(jTextField1.getText()),
                jTextField2.getText(),
                jTextField3.getText(),
                jTextField4.getText(),
                getDateFromString(jTextField5.getText()),
                position, department,
                access);
    }

    private boolean chekFields() {

       final String fioCheck = "^[А-яа-я]+$";

        if (!jTextField2.getText().matches(fioCheck)) return false;
        if (!jTextField3.getText().matches(fioCheck)) return false;
        if (!jTextField4.getText().matches(fioCheck)) return false;
        if (!jTextField5.getText().matches("^(0[1-9]|[12][0-9]|3[01]).(0[1-9]|1[1-2]).(19|20)\\d\\d$")) return false;

        return true;
    }




}

