package controller;

import model.*;
import view.UserView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class UserController {
    private UserView view;
    private UserMapper mapper;

    public UserController(UserView view, UserMapper mapper) {
        this.view = view;
        this.mapper = mapper;

        loadUserData();

        this.view.getAddButton().addActionListener(new AddUserListener());
        this.view.getAddButton().addActionListener(e -> loadUserData());
        view.getRefreshButton().addActionListener(e -> loadUserData());
        view.getUpdateButton().addActionListener(new UpdateUserListener());
        view.getDeleteButton().addActionListener(new DeleteUserListener());

        view.getUserTable().addMouseListener(new TableMouseListener());
    }

    private void loadUserData() {
        new SwingWorker<List<User>, Void>() {
            @Override
            protected List<User> doInBackground() throws Exception {
                return mapper.getAllUsers(); // Ambil data dari database
            }

            @Override
            protected void done() {
                try {
                    List<User> users = get();
                    String[] columnNames = { "ID", "Name", "Email", "Phone", "Address", "Age" };
                    DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

                    for (User user : users) {
                        Object[] row = {
                                user.getId(),
                                user.getName(),
                                user.getEmail(),
                                user.getPhone(),
                                user.getAddress(),
                                user.getAge() };
                        tableModel.addRow(row);
                    }

                    view.getUserTable().setModel(tableModel); // Perbarui tabel di view
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(view, "Error loading data: " + e.getMessage(), "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        }.execute(); // Jalankan SwingWorker
    }

    class AddUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String name = view.getNameInput();
            String email = view.getEmailInput();
            String phone = view.getPhoneInput();
            String address = view.getAddressInput();
            int age = view.getAgeInput();

            if (!name.isEmpty() && !email.isEmpty() && !phone.isEmpty() && !address.isEmpty()) {
                User user = new User();
                user.setName(name);
                user.setEmail(email);
                user.setPhone(phone);
                user.setAddress(address);
                user.setAge(age);

                mapper.insertUser(user);
                JOptionPane.showMessageDialog(view, "User added successfully!");
            } else {
                JOptionPane.showMessageDialog(view, "Please fill in all fields.");
            }
        }
    }

    class UpdateUserListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedRow = view.getUserTable().getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) view.getUserTable().getValueAt(selectedRow, 0);

                User user = new User();
                user.setId(id);
                user.setName(view.getNameInput());
                user.setEmail(view.getEmailInput());
                user.setPhone(view.getPhoneInput());
                user.setAddress(view.getAddressInput());
                user.setAge(view.getAgeInput());

                mapper.updateUser(user);
                JOptionPane.showMessageDialog(view, "User updated successfully!");
                loadUserData();
            } else {
                JOptionPane.showMessageDialog(view, "Please select a user to update.");
            }
        }
    }

    class DeleteUserListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int selectedRow = view.getUserTable().getSelectedRow();
            if (selectedRow != -1) {
                int id = (int) view.getUserTable().getValueAt(selectedRow, 0);
                int confirm = JOptionPane.showConfirmDialog(view, "Are you sure?", "Delete User",
                        JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    mapper.deleteUser(id);
                    JOptionPane.showMessageDialog(view, "User deleted successfully!");
                    loadUserData();
                }
            } else {
                JOptionPane.showMessageDialog(view, "Please select a user to delete.");
            }
        }
    }

    class TableMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int selectedRow = view.getUserTable().getSelectedRow();
            if (selectedRow != -1) {
                view.setNameInput(view.getUserTable().getValueAt(selectedRow, 1).toString());
                view.setEmailInput(view.getUserTable().getValueAt(selectedRow, 2).toString());
                view.setPhoneInput(view.getUserTable().getValueAt(selectedRow, 3).toString());
                view.setAddressInput(view.getUserTable().getValueAt(selectedRow, 4).toString());
                view.setAgeInput(view.getUserTable().getValueAt(selectedRow, 5).toString());
            }
        }
    }
}
