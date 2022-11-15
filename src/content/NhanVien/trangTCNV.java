package content.NhanVien;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

import content.customButton;
import content.table;
import content.form.formNhapNhanVien;
import dao.ChucVu_DAO;
import dao.NhanVien_DAO;
import entity.ChucVu;
import entity.NhanVien;

public class trangTCNV implements ActionListener {
	private table pane;
	private customButton btnTim;
	private customButton btnTaiTrang;
	private JFrame frame;
	private ArrayList<Object[]> ds;
	private formNhapNhanVien panel;
    private NhanVien_DAO nhanVien_dao;
    private ChucVu_DAO chucVu_dao;
	public void RenderUITraCuu (Box totalBox, Font fontBtn) {
	    nhanVien_dao =new NhanVien_DAO();
        chucVu_dao=new ChucVu_DAO();
		panel = new formNhapNhanVien("TCNV");
		totalBox.add(panel);
		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Nhân Viên", "Tên Nhân Viên", "Địa Chỉ", "Số Điện Thoại", "Chức Vụ"} ;
		pane = new table(header);
		totalBox.add(pane);
		
		panel.btnTim.addActionListener(this);
		panel.btnXoaTrang.addActionListener(this);
		docDuLieuBangNhanVien();
		docDuLieuComboChucVu();
		if (panel.btnTaiTrang.getActionListeners().length == 0) {
			panel.btnTaiTrang.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					docDuLieuBangNhanVien();
				}
			});
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnTim)) {
			docDuLieuBangNhanVien();
			int row = pane.getRowCount();
			ds = new ArrayList<Object[]>();
			int amount = 0;
			for (int i = 0; i< row; i ++) {
				int x = 0, y = 0;
				if (panel.tfTenNV.getText().length() != 0) {
					x++;
					if (panel.tfTenNV.getText().trim().equals(pane.table.getValueAt(i,1).toString().trim())) {
						y ++;
					}
				}
				if (panel.tfDiaChiNV.getText().length() != 0) {
					x++;
					if (panel.tfDiaChiNV.getText().trim().equals(pane.table.getValueAt(i,2).toString().trim())) {
						y ++;
					}
				}
				if (panel.tfSDTNV.getText().length() != 0) {
					x++;

					if (panel.tfSDTNV.getText().trim().equals(pane.table.getValueAt(i,3).toString().trim())) {
						y ++;
					}
				}
				if (panel.comboCVNV.getSelectedItem() != "Không") {
					x ++;
					if (panel.comboCVNV.getSelectedItem().equals(pane.table.getValueAt(i,4).toString())) {
						y++;
					}
				}
				if (x == y) {
					ds.add(new Object[] {pane.table.getValueAt(i, 0),pane.table.getValueAt(i,1), pane.table.getValueAt(i,2), pane.table.getValueAt(i,3)
							, pane.table.getValueAt(i, 4)});
							amount ++;
				}
			}
			TableRemoveAll();
			for (Object[] x : ds) {
				pane.addRow(x);
			}
		}
		if (obj.equals(panel.btnXoaTrang)) {
            XoaTrang();

        }
        
	}
	private void XoaTrang() {
		panel.tfMaNV.setText("Hệ Thống Tự Động Thêm");
		panel.tfTenNV.setText("");
		panel.tfDiaChiNV.setText("");
		panel.tfSDTNV.setText("");
		panel.comboCVNV.setSelectedIndex(0);
		
	}
	public void TableRemoveAll () {
		DefaultTableModel dm = (DefaultTableModel) pane.table.getModel();
		int rowCount = pane.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
		    dm.removeRow(i);
		}
	}
	public void docDuLieuComboChucVu() {
        ArrayList<ChucVu> dsCV=chucVu_dao.getAllDSChucVu();
        for (ChucVu cv : dsCV) {
            panel.comboCVNV.addItem(cv.getTenChucVu());
        }
    }
    public void docDuLieuBangNhanVien () {
        ArrayList<NhanVien> dsNV = nhanVien_dao.getAllNhanVien();
        pane.removeAll();
        for (NhanVien nv : dsNV) {
            String ma = null;
            ArrayList<ChucVu> dsCV=chucVu_dao.getAllDSChucVu();
            for (ChucVu cv : dsCV) {
                if (cv.getMaChucVu().equals(nv.getChucVu().getMaChucVu())) {
                    ma = cv.getTenChucVu();
                }
            }
            pane.addRow(new Object[] {nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getDiaChi(), 
                    nv.getSoDienThoai(), ma});
        }
    }
}
