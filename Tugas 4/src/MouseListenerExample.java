import javax.swing.*;
import java.awt.event.*;

public class MouseListenerExample {
    public static void main(String[] args) {
        // membuat jframe
        JFrame frame = new JFrame("MouseListener example");

        // membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Arahkan dan klik mouse pada area ini");
        label.setBounds(50,50,300,30);

        // menambahkan mouselistener ke label
        label.addMouseListener(new MouseListener() {
            public void mouseClicked(MouseEvent e) {
                label.setText("Mouse Clicked at: (" + e.getX() + "," + e.getY() +")");
            }

            // Dijalankan ketika mouse ditekan tanpa dilepaskan
            public void mousePressed(MouseEvent e) {
                label.setText("Mouse Pressed at: (" + e.getX() + "," + e.getY() + ")");
            }

            // Dijalankan ketika mouse dilepaskan setelah ditekan
            public void mouseReleased(MouseEvent e) {
                label.setText("Mouse Released at: ("+ e.getX() + "," + e.getY() + ")");
            }

            // Dijalankan ketika mouse masuk ke area komponen
            public void mouseEntered(MouseEvent e) {
                label.setText("Mouse Entered the area.");
            }

            // Dijalankan ketika mouse keluar dari area komponen
            public void mouseExited(MouseEvent e){
                label.setText("Mouse exited the area.");
            }
        });

        // menambahkan label ke frame
        frame.add(label);

        // setting frame
        frame.setSize(400,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
