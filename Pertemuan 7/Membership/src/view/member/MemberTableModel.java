package view.member;

import javax.swing.table.*;
import java.util.List;
import model.Member;

class MemberTableModel extends AbstractTableModel {
    private String[] columnNames = { "Nama", "Jenis Member" };
    private List<Member> data;

    public MemberTableModel(List<Member> data) {
        this.data = data;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        Member rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = rowItem.getNama(); // Mengambil nama Member
                break;
            case 1:
                value = rowItem.getJenisMember().getNama(); // Mengambil nama Jenis Member
                break;
        }
        return value;
    }

    public boolean isCellEditable(int row, int col) {
        return false;
    }

    public void add(Member value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

}
