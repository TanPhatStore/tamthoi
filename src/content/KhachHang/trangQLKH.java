package content.KhachHang;

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
import content.form.formNhapKhachHang;
import content.hoa_don.buttonListPhong;
import content.hoa_don.trangHoaDon;
import dao.KhachHang_DAO;
import entity.KhachHang;


public class trangQLKH implements MouseListener{
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private table pane;
	private JFrame frame;
	private formNhapKhachHang panel;
	private KhachHang_DAO khachHang_dao;
    private ArrayList<KhachHang> dsKH;
    private trangHoaDon trangHoaDon;
	public void RenderUIQuanLi (Box totalBox, Font fontBtn, trangHoaDon trangHoaDon) {
		this.trangHoaDon = trangHoaDon;
		panel = new formNhapKhachHang("QLKH");
		totalBox.add(panel);

		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại"} ;
		pane = new table(header);
		totalBox.add(pane);
		
		panel.btnThem.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
		pane.table.addMouseListener(this);
		khachHang_dao=new KhachHang_DAO();
		docDuLieuLoaiDichVu();
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnThem)) {
		    String maKH=panel.tfMaKH.getText();
            String tenKH=panel.tfTenKH.getText();
            String diaChi=panel.tfDiaChiKH.getText();
            String sdt=panel.tfSDTKH.getText();
            KhachHang kh=new KhachHang(maKH, tenKH, sdt, diaChi, 0);
            if(khachHang_dao.create(kh, dsKH.size() + 1)) {
                pane.removeAll();
                docDuLieuLoaiDichVu();
                dsKH=khachHang_dao.getAllDSKhachHang();
                XoaTrang();
                
         
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
	            KhachHang kh=new KhachHang(ma);
	            khachHang_dao.delete(kh);
	            pane.removeRow(r);
	            dsKH=khachHang_dao.getAllDSKhachHang();
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
		panel.tfMaKH.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0));
		panel.tfTenKH.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 1));
		panel.tfDiaChiKH.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 2));
		panel.tfSDTKH.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 3));
	}
	public void LuuDuLieuSua () {
	    int row = pane.getSelectedRow();
        pane.removeRow(row);
        
        String maKH=panel.tfMaKH.getText();
        String tenKH=panel.tfTenKH.getText();
        String diaChi=panel.tfDiaChiKH.getText();
        String sdt=panel.tfSDTKH.getText();
        
        ArrayList<KhachHang> dsKH=khachHang_dao.getAllDSKhachHang();
        int tongtien = 0;
        for (KhachHang kh : dsKH) {
            if (kh.getMaKhachHang().equals(maKH)) {
                tongtien = kh.getTongTienHoaDon();
            }
        }
        
        KhachHang kh=new KhachHang(maKH, tenKH, sdt, diaChi, tongtien);
        if(khachHang_dao.update(kh)) {
            pane.removeAll();
            docDuLieuLoaiDichVu();
                XoaTrang();
        }
	}
	public void XoaTrang () {
		panel.tfMaKH.setText("Hệ Thống Tự Động Thêm");
		panel.tfTenKH.setText("");
		panel.tfDiaChiKH.setText("");
		panel.tfSDTKH.setText("");
	}
	public void docDuLieuLoaiDichVu() {
         dsKH=khachHang_dao.getAllDSKhachHang();
        for (KhachHang kh : dsKH) {
            pane.addRow(new Object[] {kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getDiaChi(),kh.getSoDienThoai()});
        }
        
    }
}

