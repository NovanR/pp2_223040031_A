package view;

import dao.PersonDao;
import model.Person;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PersonFrame extends JFrame {
    private JTextField namaField;
    private JTextField alamatField;
    private JTextField umurField;
    private PersonDao personDao;

    public PersonFrame() {
        personDao = new PersonDao();

        setTitle("Input Biodata");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menggunakan GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Label Nama
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.3;
        add(new JLabel("Nama:"), gbc);

        // Field Nama
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.7;
        namaField = new JTextField(20);
        add(namaField, gbc);

        // Label Alamat
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.3;
        add(new JLabel("Alamat:"), gbc);

        // Field Alamat
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.7;
        alamatField = new JTextField(20);
        add(alamatField, gbc);

        // Label Umur
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.3;
        add(new JLabel("Umur:"), gbc);

        // Field Umur
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.7;
        umurField = new JTextField(20);
        add(umurField, gbc);

        // Tombol Simpan
        JButton simpanButton = new JButton("Simpan");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(simpanButton, gbc);

        // Aksi tombol simpan
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Membuat objek Person dari input
                Person person = new Person();
                person.setNama(namaField.getText());
                person.setAlamat(alamatField.getText());
                try {
                    person.setUmur(Integer.parseInt(umurField.getText()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Umur harus berupa angka.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Menyimpan ke database
                personDao.insert(person);
                JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");

                // Membersihkan field setelah disimpan
                namaField.setText("");
                alamatField.setText("");
                umurField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PersonFrame().setVisible(true);
        });
    }
}
