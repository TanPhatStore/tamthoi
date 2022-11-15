package content.DichVu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import content.customButton;
import content.table;
import content.form.formNhapLoaiDichVu;
import dao.LoaiDichVu_DAO;
import entity.LoaiDichVu;
import entity.NhaCungCap;

public class trangLDV implements ActionListener, MouseListener {
	private table pane;
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private JFrame frame;
	private formNhapLoaiDichVu panel;
    private LoaiDichVu_DAO LoaiDichVu_DAO;
    private ArrayList<LoaiDichVu> dsLDV;

	public void RenderUILoaiDichVu (Box totalBox, Font fontBtn) {
		panel = new formNhapLoaiDichVu();
		totalBox.add(panel);

		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Loại Dịch Vụ", "Tên Loại Dịch Vụ", "Mô Tả"} ;
		pane = new table(header);
		totalBox.add(pane);
		LoaiDichVu_DAO=new LoaiDichVu_DAO();
		docDuLieuLoaiDichVu();
		panel.btnThem.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		pane.table.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	public void SuaDuLieu() {
		panel.tfMaLDV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0));
		panel.tfTenLDV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 1));
		panel.tfMoTaLDV.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 2));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnThem)) {
		    String maLdv=panel.tfMaLDV.getText();
            String tenLdv=panel.tfTenLDV.getText();
            String moTa=panel.tfMoTaLDV.getText();
            LoaiDichVu ldv=new LoaiDichVu(maLdv, tenLdv, moTa);
            if(LoaiDichVu_DAO.create(ldv, dsLDV.size()+1)) {
                pane.removeAll();
                docDuLieuLoaiDichVu();
                dsLDV=LoaiDichVu_DAO.getAllLoaiDichVu();
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
	            LoaiDichVu ldv=new LoaiDichVu(ma);
	            LoaiDichVu_DAO.delete(ldv);
	            pane.removeRow(r);
	            dsLDV=LoaiDichVu_DAO.getAllLoaiDichVu();
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
	public void LuuDuLieuSua () {
	    int row=pane.getSelectedRow();
        String maLdv=panel.tfMaLDV.getText();
        String tenLdv=panel.tfTenLDV.getText();
        String moTa=panel.tfMoTaLDV.getText();
        LoaiDichVu ldv=new LoaiDichVu(maLdv, tenLdv, moTa);
        if(LoaiDichVu_DAO.update(ldv)) {
            pane.removeAll();
            docDuLieuLoaiDichVu();
        }
	}
	public void XoaTrang () {
		panel.tfMaLDV.setText("Hệ Thống Tự Động Thêm");
		panel.tfTenLDV.setText("");
		panel.tfMoTaLDV.setText("");
	}
	public void docDuLieuLoaiDichVu() {
        dsLDV=LoaiDichVu_DAO.getAllLoaiDichVu();
        for (LoaiDichVu ldv : dsLDV) {
            pane.addRow(new Object[] {ldv.getMaLoaiDichVu(),ldv.getTenLoaiDichVu(),ldv.getMoTa()});
        }
	}
}
