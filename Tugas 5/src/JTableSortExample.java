import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableSortExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable Sorting Example");

        String[] columnNames = { "ID", "Name", "Age" };
        Object[][] data = {
                { 1, "John", 25 },
                { 3, "Mike", 35 },
                { 2, "Anna", 30 },
        };
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        // Mengaktifkan pengurutan otomatis
        table.setAutoCreateRowSorter(true);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}