package view.jenismember;

import java.awt.event.*;
import java.util.UUID;
import model.JenisMember;
import dao.JenisMemberDao;

public class JenisMemberButtonSimpanActionListener implements ActionListener {
    private JenisMemberFrame jenisMemberFrame;
    private JenisMemberDao jenisMemberDao;

    public JenisMemberButtonSimpanActionListener(JenisMemberFrame jenisMemberFrame, JenisMemberDao jenisMemberDao) {
        this.jenisMemberFrame = jenisMemberFrame;
        this.jenisMemberDao = jenisMemberDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Mengambil nama dari JenisMemberFrame
        String nama = this.jenisMemberFrame.getNama();

        // Membuat objek JenisMember baru dan mengatur ID serta nama
        JenisMember jenisMember = new JenisMember();
        jenisMember.setId(UUID.randomUUID().toString()); // Menggunakan UUID sebagai ID unik
        jenisMember.setNama(nama);

        // Menambahkan JenisMember ke frame dan menyimpan ke database
        this.jenisMemberFrame.addJenisMember(jenisMember);
        this.jenisMemberDao.insert(jenisMember);
    }
}
