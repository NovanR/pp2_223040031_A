package view;

import javax.swing.*;
import java.awt.*;

public class UserView extends JFrame {
    private JTextField txtName = new JTextField(15);
    private JTextField txtEmail = new JTextField(15);
    private JTextField txtPhone = new JTextField(15);
    private JTextField txtAddress = new JTextField(15);
    private JTextField txtAge = new JTextField(5);
    private JButton btnAdd = new JButton("Add User");
    private JButton btnUpdate = new JButton("Update User");
    private JButton btnDelete = new JButton("Delete User");
    private JButton btnRefresh = new JButton("Refresh");
    private JTable userTable = new JTable();
    private JScrollPane tableScrollPane = new JScrollPane(userTable);

    public UserView() {
        setTitle("User Management");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(BorderFactory.createTitledBorder("User Information"));

        inputPanel.add(createInputField("Name:", txtName));
        inputPanel.add(createInputField("Email:", txtEmail));
        inputPanel.add(createInputField("Phone:", txtPhone));
        inputPanel.add(createInputField("Address:", txtAddress));
        inputPanel.add(createInputField("Age:", txtAge));

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnRefresh);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(tableScrollPane, BorderLayout.SOUTH);

        setMinimumSize(new Dimension(700, 700));

    }

    private JPanel createInputField(String label, JTextField textField) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(new JLabel(label));
        panel.add(textField);
        return panel;
    }

    public String getNameInput() {
        return txtName.getText();
    }

    public String getEmailInput() {
        return txtEmail.getText();
    }

    public JTable getUserTable() {
        return userTable;
    }

    public JButton getAddButton() {
        return btnAdd;
    }

    public JButton getUpdateButton() {
        return btnUpdate;
    }

    public JButton getDeleteButton() {
        return btnDelete;
    }

    public JButton getRefreshButton() {
        return btnRefresh;
    }

    public String getPhoneInput() {
        return txtPhone.getText();
    }

    public String getAddressInput() {
        return txtAddress.getText();
    }

    public int getAgeInput() {
        return Integer.parseInt(txtAge.getText());
    }

    public void setNameInput(String value) {
        txtName.setText(value);
    }

    public void setEmailInput(String value) {
        txtEmail.setText(value);
    }

    public void setPhoneInput(String value) {
        txtPhone.setText(value);
    }

    public void setAddressInput(String value) {
        txtAddress.setText(value);
    }

    public void setAgeInput(String value) {
        txtAge.setText(value);
    }
}
