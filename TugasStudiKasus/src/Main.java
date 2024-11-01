import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private DefaultTableModel tableModel;

    public Main() {
        setTitle("Ayam Potong");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem menuDataPelanggan = new JMenuItem("Data Pelanggan");
        JMenuItem menuExit = new JMenuItem("Exit");

        menu.add(menuDataPelanggan);
        menu.add(menuExit);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // Panel deskripsi aplikasi (tampilan awal)
        JPanel homePanel = new JPanel(new BorderLayout());
        JLabel desk = new JLabel(
                "<html><h2>Ayam Potong</h2><p>Sebuah program untuk mengelola pendataan pelanggan</p></html>");
        desk.setHorizontalAlignment(SwingConstants.CENTER);
        homePanel.add(desk, BorderLayout.CENTER);

        // Panel data pelanggan
        JPanel pelangganPanel = createDataPelangganPanel();

        mainPanel.add(homePanel, "Home");
        mainPanel.add(pelangganPanel, "Data Pelanggan");

        this.add(mainPanel);

        // ActionListener untuk menu Data Pelanggan
        menuDataPelanggan.addActionListener(e -> cardLayout.show(mainPanel, "Data Pelanggan"));

        // ActionListener untuk menu Exit
        menuExit.addActionListener(e -> System.exit(0));

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createDataPelangganPanel() {
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding dalam form

        // Input nama
        JLabel labelNama = new JLabel("Nama:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(labelNama, gbc);

        JTextField textFieldNama = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(textFieldNama, gbc);

        // Input alamat
        JLabel labelAlamat = new JLabel("Alamat:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(labelAlamat, gbc);

        JTextArea textAreaAlamat = new JTextArea(3, 15);
        textAreaAlamat.setLineWrap(true);
        textAreaAlamat.setWrapStyleWord(true);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(textAreaAlamat, gbc);

        // Label Jenis Kelamin
        JLabel labelJK = new JLabel("Jenis Kelamin:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        mainPanel.add(labelJK, gbc);

        // Radio Button JK
        JPanel genderPanel = new JPanel();
        JRadioButton radioButton1 = new JRadioButton("Laki-Laki", true);
        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        genderPanel.add(radioButton1);
        genderPanel.add(radioButton2);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(genderPanel, gbc);

        // Checkbox Notifikasi
        JCheckBox checkBoxNotifikasi = new JCheckBox("Ingin menerima notifikasi atau promo");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        mainPanel.add(checkBoxNotifikasi, gbc);

        // Tombol Simpan
        JButton btnSimpan = new JButton("Simpan");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(btnSimpan, gbc);

        // Model dan JTable untuk menampilkan data
        tableModel = new DefaultTableModel(new Object[] { "Nama", "Alamat", "Jenis Kelamin", "Notifikasi" }, 0);
        JTable table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));
        JScrollPane scrollPane = new JScrollPane(table);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        mainPanel.add(scrollPane, gbc);

        // Event Listener untuk tombol Simpan
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String alamat = textAreaAlamat.getText();
                String jenisKelamin = radioButton1.isSelected() ? "Laki-Laki" : "Perempuan";
                String notifikasi = checkBoxNotifikasi.isSelected() ? "Ya" : "Tidak";

                tableModel.addRow(new Object[] { nama, alamat, jenisKelamin, notifikasi });

                textFieldNama.setText("");
                textAreaAlamat.setText("");
                checkBoxNotifikasi.setSelected(false);
                radioButton1.setSelected(true);
            }
        });

        return mainPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}
