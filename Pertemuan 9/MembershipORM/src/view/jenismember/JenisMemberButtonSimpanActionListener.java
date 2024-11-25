package view.jenismember;

import dao.JenisMemberDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import model.JenisMember;

public class JenisMemberButtonSimpanActionListener implements ActionListener {

    private JenisMemberFrame jenisMemberFrame;
    private JenisMemberDao jenisMemberDao;

    public JenisMemberButtonSimpanActionListener(JenisMemberFrame jenisMemberFrame, JenisMemberDao jenisMemberDao) {
        this.jenisMemberFrame = jenisMemberFrame;
        this.jenisMemberDao = jenisMemberDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = this.jenisMemberFrame.getNama(); // Mendapatkan nama dari frame
        JenisMember jenisMember = new JenisMember(); // Membuat objek baru jenisMember
        jenisMember.setId(UUID.randomUUID().toString()); // Generate ID unik menggunakan UUID
        jenisMember.setNama(nama); // Mengatur nama pada objek jenisMember

        this.jenisMemberFrame.addJenisMember(jenisMember); // Menambahkan ke tabel frame
        this.jenisMemberDao.insert(jenisMember); // Menyimpan ke database
    }
}
