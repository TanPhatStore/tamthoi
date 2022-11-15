package content.NhanVien;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import content.customButton;
import content.table;
import content.form.formNhapNhanVien;
import content.menuPage.menuPage;
import dao.ChucVu_DAO;
import dao.NhanVien_DAO;
import entity.ChucVu;
import entity.NhanVien;

public class trangQLNV implements MouseListener {
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private table pane;
	private JFrame frame;
	private formNhapNhanVien panel;
	private menuPage menuPage;
	private NhanVien_DAO nhanVien_dao;
	private ChucVu_DAO chucVu_dao;
    private String cv;
    private String cv1;
    private ArrayList<NhanVien> dsNV;
	public void RenderUIQuanLi (Box totalBox, Font fontBtn) {
	    nhanVien_dao =new NhanVien_DAO();
	    chucVu_dao=new ChucVu_DAO();
		 panel = new formNhapNhanVien("QLNV");
		totalBox.add(panel);
		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Nhân Viên", "Tên Nhân Viên", "Địa Chỉ", "Số Điện Thoại", "Chức Vụ"} ;
		pane = new table(header);
		totalBox.add(pane);
		
		panel.btnThem.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
		pane.table.addMouseListener(this);
		
		docDuLieuBangNhanVien ();
		docDuLieuComboChucVu();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnThem)) {
		    if (panel.comboCVNV.getSelectedItem().toString() != "Không") {
		        String maNV=panel.tfMaNV.getText();
                String tenNV=panel.tfTenNV.getText();
                String diaChi=panel.tfDiaChiNV.getText();
                String sdt=panel.tfSDTNV.getText();
                
                ArrayList<ChucVu> dsCV=chucVu_dao.getAllDSChucVu();
                for (ChucVu cv : dsCV) {
                    if (cv.getTenChucVu().equals(panel.comboCVNV.getSelectedItem().toString())) {
                        cv1= cv.getMaChucVu();
                    }
                }
               
                ChucVu cvb=new ChucVu(cv1);
                NhanVien nv=new NhanVien(maNV, tenNV,diaChi, sdt,0, 0,  cvb);
                if(nhanVien_dao.create(nv, dsNV.size() + 1)) {
                    pane.removeAll();
                    docDuLieuBangNhanVien();
                    dsNV = nhanVien_dao.getAllNhanVien();
                    XoaTrang();
                }
		    } else {
		        JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Chức Vụ");
		    }
    		    
		}
		if (obj.equals(panel.btnSua)) {
			LuuDuLieuSua();
			XoaTrang();
			
		}
		if (obj.equals(panel.btnXoa)) {
			if (pane.getSelectedRow() >= 0) {
			    int r=pane.getSelectedRow();
	            String ma=pane.table.getValueAt(r, 0).toString();
	            NhanVien nv=new NhanVien(ma);
	            nhanVien_dao.delete(nv);
	            pane.removeRow(r);
	            dsNV = nhanVien_dao.getAllNhanVien();
	            XoaTrang();
			} else {
				JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Dòng Dữ Liệu Để Xóa");
			}
		}
		if (obj.equals(pane.table)) {
		    SuaDuLieu();
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

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void SuaDuLieu() {
		panel.tfMaNV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0));
		panel.tfTenNV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 1));
		panel.tfDiaChiNV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 2));
		panel.tfSDTNV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 3));
		panel.comboCVNV.setSelectedItem((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 4));
	}
	public void LuuDuLieuSua () {
	    if (panel.comboCVNV.getSelectedItem().toString() != "Không") {
    	    int row = pane.getSelectedRow();
            String maNV=panel.tfMaNV.getText();
            String tenNV=panel.tfTenNV.getText();
            String diaChi=panel.tfDiaChiNV.getText();
            String sdt=panel.tfSDTNV.getText();
            String ma = null;
            ArrayList<ChucVu> dsCV=chucVu_dao.getAllDSChucVu();
            for (ChucVu cv : dsCV) {
                if (cv.getTenChucVu().equals(panel.comboCVNV.getSelectedItem().toString())) {
                    ma = cv.getMaChucVu();
                }
            }
            ChucVu cvb=new ChucVu(ma);
            int soDon = 0, TongTien = 0;
            ArrayList<NhanVien> dsNV = nhanVien_dao.getAllNhanVien();
            for (NhanVien nv : dsNV) {
                if (nv.getMaNhanVien().equals(maNV)) {
                    soDon = nv.getSoHoaDonLap();
                    TongTien = nv.getTongTienHoaDon();
                }
            }
            
            NhanVien nv=new NhanVien(maNV, tenNV, diaChi, sdt,soDon, TongTien, cvb);
            if(nhanVien_dao.update(nv)) {
                pane.removeAll();
                docDuLieuBangNhanVien();
            }
	    } else {
	        JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Chức Vụ");
	    }
	}
	public void docDuLieuComboChucVu() {
        ArrayList<ChucVu> dsCV=chucVu_dao.getAllDSChucVu();
        for (ChucVu cv : dsCV) {
            panel.comboCVNV.addItem(cv.getTenChucVu());
        }
    }
	public void docDuLieuBangNhanVien () {
	    dsNV = nhanVien_dao.getAllNhanVien();
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
