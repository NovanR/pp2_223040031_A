import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BiodataV3 extends JFrame {
    public BiodataV3 () {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
    
        JPanel panel = new JPanel();
        // panel.setBackground(Color.PINK);
        panel.setSize(300, 300);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nama: "),gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JTextField(),gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Nomor HP: "),gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JTextField(),gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 0;
        panel.add(new JLabel("Jenis Kelamin: "),gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 2;
        panel.add(new JRadioButton("Laki laki "),gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 3;
        panel.add(new JRadioButton("Perempuan "),gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 4;
        panel.add(new JCheckBox("Warga Negara Asing "),gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 2;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        panel.add(new JButton("Simpan"),gbc);


        controlPanel.add(panel);

        this.setLayout(new GridLayout(2,10));
        this.add(headerLabel);
        this.add(controlPanel);
        this.setSize(400, 400);
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
