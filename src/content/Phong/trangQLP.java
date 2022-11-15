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

import Function.functionNecessary;
import content.customButton;
import content.table;
import content.form.formNhapDichVu;
import content.form.formNhapPhong;
import content.hoa_don.buttonListPhong;
import content.hoa_don.titleHoaDon;
import content.hoa_don.trangHoaDon;
import dao.LoaiPhong_DAO;
import dao.Phong_DAO;
import entity.LoaiPhong;
import entity.Phong;

public class trangQLP implements MouseListener{
	private table pane;
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private JFrame frame;
	private formNhapPhong panel;
	private Phong_DAO phong_dao;
    private LoaiPhong_DAO loaiPhong_dao;
    private ArrayList<Phong> dsP;
    private trangHoaDon trangHoaDon;
	public void RenderUIQuanLi (Box totalBox, Font fontBtn, trangHoaDon trangHoaDon) {
		this.trangHoaDon = trangHoaDon;
		panel = new formNhapPhong("QLP");
		totalBox.add(panel);
		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Phòng", "Tên Phòng","Giá Phòng", "Loại Phòng"} ;
		pane = new table(header);
		totalBox.add(pane);
		phong_dao=new Phong_DAO();
		loaiPhong_dao=new LoaiPhong_DAO();
		
		
		// add List Button
		Box boxBtn = Box.createHorizontalBox();
		totalBox.add(Box.createRigidArea(new Dimension(0, 30)));
		totalBox.add(boxBtn);
		
		String color3 = "#6dd5ed", color4 = "#2193b0";
		
		panel.btnThem.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
		panel.btnIn.addMouseListener(this);
		pane.table.addMouseListener(this);
		
		docDuLieuLoaiPhong();
		docDuLieuPhong();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnThem)) {
		    if (panel.comboLP.getSelectedItem().toString() != "Không") {
		        String maP=panel.tfMaP.getText();
	            String tenP=panel.tfTenP.getText();
	            int giaP=Integer.parseInt(panel.tfGiaP.getText());
	            String lp=panel.comboLP.getSelectedItem().toString();
	            
	            String ma = null;
	            ArrayList<LoaiPhong> dsLP=loaiPhong_dao.getAllLoaiPhong();
	            for (LoaiPhong lp1 : dsLP) {
	                if (lp1.getTenLoaiPhong().equals(panel.comboLP.getSelectedItem().toString())) {
	                    ma = lp1.getMaLoaiPhong();
	                }
	            }
	            dsP=phong_dao.getAllPhong();
	            LoaiPhong lpB= new LoaiPhong(ma);
	            Phong p=new Phong(maP, tenP, lpB, giaP + "");
	            if(phong_dao.create(p, dsP.size() + 1)) {
	                pane.removeAll();
	                docDuLieuPhong();
	                dsP=phong_dao.getAllPhong();
	                XoaTrang();
	                buttonListPhong btnNewPhong = new buttonListPhong(tenP,"", lp,giaP + "", trangHoaDon.listKhachHang, trangHoaDon.listDichVu, trangHoaDon.listPhong);
	                trangHoaDon.listPhong.listPhong.add(btnNewPhong);
	                trangHoaDon.listPhong.add(btnNewPhong);
	                trangHoaDon.listPhong.repaint();
	                trangHoaDon.addEventBTNPhong();
	                trangHoaDon.listPhong.addEvent();
	                trangHoaDon.setHeightListObject ();
	            }
		    }
		    else {
		        JOptionPane.showMessageDialog(null, "Vui Lòng Chọn Loại Phòng");
		    }
			
		}
		if (obj.equals(panel.btnXoa)) {
			if (pane.getSelectedRow() >= 0) {
			    int r=pane.getSelectedRow();
		    	for (buttonListPhong x : trangHoaDon.listPhong.listPhong) {
	            	if (x.name.equals(pane.table.getValueAt(r, 1).toString())) {
	            		trangHoaDon.listPhong.remove(x);
			            trangHoaDon.listPhong.listPhong.remove(x);
	            		trangHoaDon.listPhong.repaint();
	            		break;
	            	}
	            }
	            String ma=pane.table.getValueAt(r, 0).toString();
	            Phong p=new Phong(ma);
	            phong_dao.delete(p);
	            pane.removeRow(r);
	            dsP=phong_dao.getAllPhong();
	            trangHoaDon.setHeightListObject ();
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
		panel.tfMaP.setText("Hệ Thống Tự Động Thêm");
		panel.tfTenP.setText("");
		panel.tfGiaP.setText("");
		panel.comboLP.setSelectedItem("Không");
		
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
	    functionNecessary d = new functionNecessary();
		panel.tfMaP.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0));
		panel.tfTenP.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 1));
		panel.tfGiaP.setText(d.formatString((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 2)));
		panel.comboLP.setSelectedItem((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 3));
	}
	public void LuuDuLieuSua () {
	    int row = pane.getSelectedRow();
        
        String maP=panel.tfMaP.getText();
        String tenP=panel.tfTenP.getText();
        int giaP=Integer.parseInt(panel.tfGiaP.getText());
        String lp=panel.comboLP.getSelectedItem().toString();
        
        String ma = null;
        ArrayList<LoaiPhong> dsLP=loaiPhong_dao.getAllLoaiPhong();
        for (LoaiPhong lp1 : dsLP) {
            if (lp1.getTenLoaiPhong().equals(panel.comboLP.getSelectedItem().toString())) {
                ma = lp1.getMaLoaiPhong();
            }
        }
        
        LoaiPhong lpB= new LoaiPhong(ma);
        Phong p=new Phong(maP, tenP, lpB, giaP+"");
        if(phong_dao.update(p)) {
     
            for (buttonListPhong x : trangHoaDon.listPhong.listPhong) {
            	if (x.name.equals(pane.table.getModel().getValueAt(pane.getSelectedRow(), 1).toString())) {
            		x.name = tenP;
            		x.type = lp;
            		x.label.setText("   " + x.name);
            		x.panelHoaDon.title.infoPhong.setText(x.name);
            		
            		if (x.type.equals("Phòng Thường")) {
            			x.panelHoaDon.title.infoPhong.setText(x.name + " - Phòng Thường");
                    } else if (x.type.equals("Phòng VIP")) {
                    	x.panelHoaDon.title.infoPhong.setText(x.name + " - Phòng VIP");
                    }
            		
            		trangHoaDon.listPhong.UpdatePhongDangSuDung();
            		break;
            	}
            }
            pane.removeRow(row);
            pane.removeAll();
            docDuLieuPhong();
            XoaTrang();
            
        }
	}
	
	public void docDuLieuLoaiPhong() {
        ArrayList<LoaiPhong> dsLP=loaiPhong_dao.getAllLoaiPhong();
        for (LoaiPhong lp : dsLP) {
            panel.comboLP.addItem(lp.getTenLoaiPhong());
        }
    }
	
	public void docDuLieuPhong() {
        dsP=phong_dao.getAllPhong();
        for (Phong p : dsP) {
            functionNecessary d = new functionNecessary();
            String ten = null;
            ArrayList<LoaiPhong> dsLP=loaiPhong_dao.getAllLoaiPhong();
            for (LoaiPhong lp : dsLP) {
                if (lp.getMaLoaiPhong().equals(p.getLoaiPhong().getMaLoaiPhong())) {
                    ten = lp.getTenLoaiPhong();
                }
            }
            pane.addRow(new Object[] {p.getMaPhong(),p.getTenPhong(),d.formatMoney(Integer.parseInt(p.getGiaPhong())),ten});
        }
    }
}
