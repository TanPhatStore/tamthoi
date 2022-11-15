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
import content.form.formNhapChucVu;
import content.form.formNhapNhanVien;
import dao.ChucVu_DAO;
import entity.ChucVu;

public class trangCV implements ActionListener, MouseListener{
	private table pane;
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private JFrame frame;
	private formNhapChucVu panel;
	private ChucVu_DAO chucVu_dao;
    private ArrayList<ChucVu> dsCV;

	public void RenderUILoaiDichVu (Box totalBox, Font fontBtn) {
	    chucVu_dao=new ChucVu_DAO();
		panel = new formNhapChucVu();
		totalBox.add(panel);
		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Chức Vụ", "Tên Chức Vụ", "Mô Tả"} ;
		pane = new table(header);
		totalBox.add(pane);
		
		
		// add List Button
		Box boxBtn = Box.createHorizontalBox();
		totalBox.add(Box.createRigidArea(new Dimension(0, 30)));
		totalBox.add(boxBtn);

		
		panel.btnThem.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
		panel.btnIn.addMouseListener(this);
		pane.table.addMouseListener(this);
		docDuLieuChucVu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnThem)) {
		    String maCV=panel.tfMaCV.getText();
            String tenCV=panel.tfTenCV.getText();
            String mota=panel.tfMoTaCV.getText();
            ChucVu cv=new ChucVu(maCV, tenCV, mota);
            if(chucVu_dao.create(cv, dsCV.size() + 1)) {
                pane.removeAll();
                docDuLieuChucVu();
                dsCV=chucVu_dao.getAllDSChucVu();
                XoaTrang();
                
            }
			
		}
		if (obj.equals(panel.btnXoa)) {
			if (pane.getSelectedRow() >= 0) {
			    int r=pane.getSelectedRow();
	            String ma=pane.table.getValueAt(r, 0).toString();
	            ChucVu cv=new ChucVu(ma);
	            chucVu_dao.delete(cv);
	            pane.removeRow(r);
	            dsCV=chucVu_dao.getAllDSChucVu();
	            XoaTrang();
			} else {
				JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Dòng Dữ Liệu Để Xóa");
			}
		}
		
		if (obj.equals(panel.btnSua)) {
			LuuDuLieuSua();
			XoaTrang();
			
		}
		if (obj.equals(pane.table)) {
			SuaDuLieu();
		}
		if (obj.equals(panel.btnXoaTrang)) {
            XoaTrang();

        }
		
	}

	private void XoaTrang() {
		panel.tfMaCV.setText("Hệ Thống Tự Động Thêm");
		panel.tfTenCV.setText("");
		panel.tfMoTaCV.setText("");
		
		
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
		panel.tfMaCV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0));
		panel.tfTenCV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 1));
		panel.tfMoTaCV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 2));
	}
	public void LuuDuLieuSua () {
	    int row = pane.getSelectedRow();
        String maCV=panel.tfMaCV.getText();
        String tenCV=panel.tfTenCV.getText();
        String mota=panel.tfMoTaCV.getText();
        ChucVu cv=new ChucVu(maCV, tenCV, mota);
        if(chucVu_dao.update(cv)) {
            pane.removeAll();
            docDuLieuChucVu();
            
        }
	}
	public void docDuLieuChucVu() {
        dsCV=chucVu_dao.getAllDSChucVu();
        for (ChucVu cv : dsCV) {
            pane.addRow(new Object[] {cv.getMaChucVu(),cv.getTenChucVu(),cv.getMoTa()});
        }
    }
}
