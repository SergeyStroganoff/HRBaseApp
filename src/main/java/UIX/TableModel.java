package UIX;

import entities.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModel extends AbstractTableModel {
    private static final String MODEL = "model";
    // колонки таблицы
    private static final String[] HEADERS = {
            "ID", "Фамилия", "Имя", "Отчество", "Дата рождения",
            "Подразделение", "Должность", "Оклад", "Доступ", "Телефон", "EMAIL"
    };

    private final List<Employee> employeeList;

    public TableModel(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    // Получить количество строк в таблице - у нас это размер коллекции
    public int getRowCount() {
        return employeeList.size();
    }

    @Override
    // Получить количество столбцов
    public int getColumnCount() {
        return 11;
    }

    @Override
    // Вернуть заголовок колонки - мы его берем из массива headers
    public String getColumnName(int col) {
        return HEADERS[col];
    }

    @Override
    // Получить объект для отображения в конкретной ячейке таблицы String  !

    public Object getValueAt(int row, int col) {
        Employee employee = employeeList.get(row);
        TableViewEmployee tableViewE = new TableViewEmployee(employee);

        // В зависимости от номера колонки возвращаем то или иное поле
        switch (col) {
            case 0:
                return tableViewE.getID();
            case 1:
                return tableViewE.getSurname();
            case 2:
                return tableViewE.getFirstName();
            case 3:
                return tableViewE.getSecondName();
            case 4:
                return tableViewE.getBirthDate();
            case 5:
                return tableViewE.getDepartmentName();
            case 6:
                return tableViewE.getNamePosition();
            case 7:
                return tableViewE.getSalary();
            case 8:
                return tableViewE.getAccessSecret();
            case 10:
                return tableViewE.getPhoneNumber();
            case 9:
                return tableViewE.getEmail();

            default:
                return "";
        }
    }
}

