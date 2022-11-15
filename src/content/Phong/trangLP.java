package content.Phong;

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
import content.form.formNhapLoaiPhong;
import dao.LoaiPhong_DAO;
import entity.LoaiPhong;

public class trangLP implements ActionListener, MouseListener{
	private table pane;
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private formNhapLoaiPhong panel;
	private JFrame frame;
	private LoaiPhong_DAO loaiPhong_dao;
    private ArrayList<LoaiPhong> dsLP;
	public void RenderUILoaiDichVu (Box totalBox, Font fontBtn) {
		panel = new formNhapLoaiPhong();
		totalBox.add(panel);
		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Loại Phòng", "Tên Loại Phòng", "Mô Tả"} ;
		pane = new table(header);
		totalBox.add(pane);
		loaiPhong_dao=new LoaiPhong_DAO();
		
		// add List Button
		Box boxBtn = Box.createHorizontalBox();
		totalBox.add(Box.createRigidArea(new Dimension(0, 30)));
		totalBox.add(boxBtn);
		
		docDuLieuLoaiPhong();
		
		String color3 = "#6dd5ed", color4 = "#2193b0";
		panel.btnThem.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
		panel.btnIn.addMouseListener(this);
		pane.table.addMouseListener(this);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnThem)) {
		    String maLP=panel.tfMaLP.getText();
            String tenLP=panel.tfTenLP.getText();
            String mota=panel.tfMoTaLP.getText();
            LoaiPhong lp=new LoaiPhong(maLP, tenLP, mota);
            if(loaiPhong_dao.create(lp, dsLP.size() + 1)) {
                pane.removeAll();
                docDuLieuLoaiPhong();
                dsLP=loaiPhong_dao.getAllLoaiPhong();
                XoaTrang();
            }
			
		}
		if (obj.equals(panel.btnXoa)) {
			if (pane.getSelectedRow() >= 0) {
			    int r=pane.getSelectedRow();
	            String ma=pane.table.getValueAt(r, 0).toString();
	            LoaiPhong lp=new LoaiPhong(ma);
	            loaiPhong_dao.delete(lp);
	            pane.removeRow(r);
	            dsLP=loaiPhong_dao.getAllLoaiPhong();
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
	private void SuaDuLieu() {
		panel.tfMaLP.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0));
		panel.tfTenLP.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 1));
		panel.tfMoTaLP.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 2));
		
	}
	private void LuuDuLieuSua() {
	    int row = pane.getSelectedRow();
        String maLP=panel.tfMaLP.getText();
        String tenLP=panel.tfTenLP.getText();
        String mota=panel.tfMoTaLP.getText();
        LoaiPhong lp=new LoaiPhong(maLP, tenLP, mota);
        if(loaiPhong_dao.update(lp)) {
            pane.removeAll();
            docDuLieuLoaiPhong();
            XoaTrang();
        }
		
	}
	private void XoaTrang() {
		panel.tfMaLP.setText("Hệ Thống Tự Động Thêm");
		panel.tfTenLP.setText("");
		panel.tfMoTaLP.setText("");
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void docDuLieuLoaiPhong() {
        dsLP=loaiPhong_dao.getAllLoaiPhong();
        for (LoaiPhong lp : dsLP) {
            pane.addRow(new Object[] {lp.getMaLoaiPhong(),lp.getTenLoaiPhong(),lp.getMoTa()});
        }
    }
}
