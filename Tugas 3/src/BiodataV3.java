import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BiodataV3 extends JFrame {
    
    private JTextField fieldNama;
    private JTextField fieldHp;
    private JRadioButton ButtonLaki;
    private JRadioButton ButtonPerempuan;
    private JCheckBox wnaCheckBox;
    private JTextArea Output;

    public BiodataV3 () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setSize(500, 500);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nama: "), gbc);

        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        fieldNama = new JTextField(15);
        panel.add(fieldNama, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Nomor HP: "), gbc);

        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        fieldHp = new JTextField(15);
        panel.add(fieldHp, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(new JLabel("Jenis Kelamin: "), gbc);

        
        ButtonLaki = new JRadioButton("Laki laki");
        ButtonPerempuan = new JRadioButton("Perempuan");

        
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(ButtonLaki);
        genderGroup.add(ButtonPerempuan);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(ButtonLaki, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(ButtonPerempuan, gbc);

        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 4;
        wnaCheckBox = new JCheckBox("Warga Negara Asing");
        panel.add(wnaCheckBox, gbc);

        
        gbc.fill = GridBagConstraints.NONE;
        gbc.ipady = 20;
        gbc.gridx = 0;  
        gbc.gridy = 8;
        gbc.gridwidth = 3;  
        gbc.insets = new Insets(20, 0, 0, 0);  
        gbc.anchor = GridBagConstraints.CENTER;
        JButton simpanButton = new JButton("Simpan");
        panel.add(simpanButton, gbc);
        

        controlPanel.add(panel);

       
        Output = new JTextArea(5, 30);
        Output.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(Output);  
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 4;
        gbc.insets = new Insets(20, 0, 0, 0);
        panel.add(scrollPane, gbc);

        this.setLayout(new GridLayout(2,10));
        this.add(headerLabel);
        this.add(controlPanel);
        this.setSize(500, 500);

        
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tampilkanOutput();
            }
        });
    }

    private void tampilkanOutput() {
        
        String nama = fieldNama.getText();
        String nomorHP = fieldHp.getText();
        String jenisKelamin = ButtonLaki.isSelected() ? "Laki laki" : "Perempuan";
        boolean wna = wnaCheckBox.isSelected();

       
        String output = "Nama: " + nama + "\n"
                      + "Nomor HP: " + nomorHP + "\n"
                      + "Jenis Kelamin: " + jenisKelamin + "\n"
                      + (wna ? "WNA: Ya" : "WNA: Bukan");

        
        Output.setText(output);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataV3 b = new BiodataV3();
                b.setVisible(true);
            }
        });
    }
}
