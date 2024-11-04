package view.member;

import java.awt.event.*;
import java.util.UUID;
import model.Member;
import model.JenisMember;
import dao.MemberDao;

public class MemberButtonSimpanActionListener implements ActionListener {
    private MemberFrame memberFrame;
    private MemberDao memberDao;

    public MemberButtonSimpanActionListener(MemberFrame memberFrame, MemberDao memberDao) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Mengambil nama dari MemberFrame
        String nama = this.memberFrame.getNama();

        // Validasi jika nama kosong
        if (nama.isEmpty()) {
            this.memberFrame.showAlert("Nama tidak boleh kosong");
        } else {
            // Mengambil jenis member yang dipilih dari MemberFrame
            JenisMember jenisMember = this.memberFrame.getJenisMember();

            // Membuat objek Member baru dan mengatur ID, nama, dan jenis member
            Member member = new Member();
            member.setId(UUID.randomUUID().toString()); // Menggunakan UUID sebagai ID unik
            member.setNama(nama);
            member.setJenisMember(jenisMember);

            // Menambahkan Member ke tampilan dan menyimpan ke database
            this.memberFrame.addMember(member);
            this.memberDao.insert(member);
        }
    }
}
