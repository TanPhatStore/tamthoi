package content.DichVu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import Function.functionNecessary;
import content.customButton;
import content.table;
import content.form.formNhapDichVu;
import content.hoa_don.buttonListDichVu;
import content.hoa_don.buttonListPhong;
import content.hoa_don.trangHoaDon;
import content.menuPage.menuPage;
import dao.DichVu_Dao;
import dao.LoaiDichVu_DAO;
import entity.DichVu;
import entity.LoaiDichVu;
import entity.NhaCungCap;

public class trangQLDV implements MouseListener{
	public table pane;
	private JFrame frame;
	private Dimension dim;
	private Dimension screenSize;
	private menuPage menuPage;
	private formNhapDichVu panel;
	private DichVu_Dao dichVu_dao;
    private String ncc1; 
    private String ldv1;
    private LoaiDichVu_DAO LoaiDichVu_DAO;
    private ArrayList<DichVu> dvDV;
    private trangHoaDon trangHoaDon;
	public void RenderUIQuanLi (Box totalBox, Font fontBtn,String color1, String color2, trangHoaDon trangHoaDon, JFrame frame) {
		this.trangHoaDon =trangHoaDon;
		// add table
		panel = new formNhapDichVu("QLDV");
		totalBox.add(panel);
		
		String[] header = {"Mã Dịch Vụ", "Tên Dịch Vụ", "Giá Tiền", "Số Lượng Tồn", "Loại Dịch Vụ", "Nhà Cung Cấp", "Mô Tả"} ;
		pane = new table(header);
		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		totalBox.add(pane); 
		dichVu_dao =new DichVu_Dao();
		pane.setPreferredSize(new Dimension(1200, 400));
		docDuLieuDichVu();
		
		panel.btnThem.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnIn.addMouseListener(this);
		pane.table.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
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
	    for (DichVu dv : dvDV) { 
	    	if (dv.getMaDichVu().equals((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0))) {
	    		panel.tfMaDV.setText(dv.getMaDichVu());
	    		panel.tfTenDV.setText(dv.getTenDichVu());
	    		panel.tfGiaDV.setText(d.formatString(dv.getGia() + ""));
	    		panel.tfMoTaDV.setText(dv.getMoTa());
	    		
	    		String tenNCC = null, tenLDV = null;
				for (NhaCungCap ncc : panel.dsNCC) {
		            if (ncc.getMaNhaCungCap().equals(dv.getNhaCungCap().getMaNhaCungCap())) {
		                tenNCC = ncc.getTenNhaCungCap();
		            }
		        }
		        for (LoaiDichVu ldv : panel.dsLDV) {
		            if (ldv.getMaLoaiDichVu().equals(dv.getLoaiDichVu().getMaLoaiDichVu())) {
		                tenLDV = ldv.getTenLoaiDichVu();
		            }
		        }
		        
	    		panel.comboLoaiDV.setSelectedItem(tenLDV);
	    		panel.comboNCC.setSelectedItem(tenNCC);
	    		panel.tfSoLuongTon.setText(dv.getSoLuongTon()+ "");
	    		panel.tfAnh.setText(dv.getAnhDichVu());
	    		break;
	    	}
	    }
	
	}
	public void LuuDuLieuSua () {
	    if (panel.comboNCC.getSelectedItem().toString() != "Không" && panel.comboLoaiDV.getSelectedItem().toString() != "Không") {
    	    functionNecessary d = new functionNecessary();
            int row = pane.getSelectedRow();
            String maDV=panel.tfMaDV.getText();
            String tenDV=panel.tfTenDV.getText();
            int gia =Integer.parseInt(panel.tfGiaDV.getText());
            String mota=panel.tfMoTaDV.getText();
            for (NhaCungCap ncc : panel.dsNCC) {
                if (ncc.getTenNhaCungCap().equals(panel.comboNCC.getSelectedItem().toString())) {
                    ncc1= ncc.getMaNhaCungCap();
                }
            }
            for (LoaiDichVu ldv : panel.dsLDV) {
                if (ldv.getTenLoaiDichVu().equals(panel.comboLoaiDV.getSelectedItem().toString())) {
                    ldv1 = ldv.getMaLoaiDichVu();
                }
            }
            
            LoaiDichVu ldvB=new LoaiDichVu(ldv1);
            NhaCungCap nccB=new NhaCungCap(ncc1);
            int soLuongTon = Integer.parseInt(panel.tfSoLuongTon.getText());
            String imageLink = panel.tfAnh.getText();
            DichVu dv=new DichVu(maDV, tenDV, mota, ldvB, nccB,soLuongTon, gia, imageLink);
            if(dichVu_dao.update(dv)) {
            	for (buttonListPhong x : trangHoaDon.listPhong.listPhong) {
			    	for (buttonListDichVu y : x.panelHoaDon.listDichVuMini.listDichVu) {
			    		if (y.name.equals(pane.table.getValueAt(row, 1).toString())) {

			    			y.name = tenDV;
			    			y.price = gia + "";
			    			y.amount = soLuongTon;
			    			y.title.setText(y.name);
			    			y.Amount.setText("Còn : " + y.amount);
			    			y.Price.setText(d.formatMoney(Integer.parseInt(y.price)));
	                		y.image.setIcon(new ImageIcon(imageLink));
			    			break;
			    		}
			    	}
			    }
            	pane.removeRow(row);
                pane.removeAll();
                docDuLieuDichVu();
                XoaTrang();
            }
	    } else {
	        JOptionPane.showMessageDialog(null,"Vui Lòng Chọn Nhà Cung Cấp và Loại Dịch Vụ");
	    }
    }
	public void XoaTrang () {
		panel.tfMaDV.setText("Hệ Thống Tự Động Thêm");
		panel.tfTenDV.setText("");
		panel.tfGiaDV.setText("");
		panel.tfMoTaDV.setText("");
		panel.comboLoaiDV.setSelectedIndex(0);
		panel.comboNCC.setSelectedIndex(0);
		panel.tfAnh.setText("");
		panel.tfSoLuongTon.setText("");
	}
	public void docDuLieuDichVu() {
        dvDV=dichVu_dao.getAllDichVu();
        for (DichVu dv : dvDV) {
			functionNecessary d = new functionNecessary();
			String tenNCC = null, tenLDV = null;
			for (NhaCungCap ncc : panel.dsNCC) {
	            if (ncc.getMaNhaCungCap().equals(dv.getNhaCungCap().getMaNhaCungCap())) {
	                tenNCC = ncc.getTenNhaCungCap();
	            }
	        }
	        for (LoaiDichVu ldv : panel.dsLDV) {
	            if (ldv.getMaLoaiDichVu().equals(dv.getLoaiDichVu().getMaLoaiDichVu())) {
	                tenLDV = ldv.getTenLoaiDichVu();
	            }
	        }
            pane.addRow(new Object[] {dv.getMaDichVu(),dv.getTenDichVu(),d.formatMoney(dv.getGia()),dv.getSoLuongTon(),tenLDV,tenNCC, dv.getMoTa()});
        }
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj.equals(panel.btnThem)) {
            functionNecessary d = new functionNecessary();
            String maDV=panel.tfMaDV.getText();
            String tenDV=panel.tfTenDV.getText();
            int gia =Integer.parseInt(panel.tfGiaDV.getText());
            String mota=panel.tfMoTaDV.getText();
            for (NhaCungCap ncc : panel.dsNCC) {
                if (ncc.getTenNhaCungCap().equals(panel.comboNCC.getSelectedItem().toString())) {
                    ncc1= ncc.getMaNhaCungCap();
                }
            }
            for (LoaiDichVu ldv : panel.dsLDV) {
                if (ldv.getTenLoaiDichVu().equals(panel.comboLoaiDV.getSelectedItem().toString())) {
                    ldv1 = ldv.getMaLoaiDichVu();
                }
            }
            int soLuongTon = Integer.parseInt(panel.tfSoLuongTon.getText());
            String imageLink = panel.tfAnh.getText();
            LoaiDichVu ldvB=new LoaiDichVu(ldv1);
            NhaCungCap nccB=new NhaCungCap(ncc1);
            DichVu dv=new DichVu(maDV, tenDV, mota, ldvB, nccB,soLuongTon, gia, imageLink);
            if(dichVu_dao.create(dv)) {
                pane.removeAll();
                docDuLieuDichVu();
                dvDV=dichVu_dao.getAllDichVu();
                XoaTrang();
                buttonListDichVu btnNewDichVu = new buttonListDichVu("",tenDV,0 + "",gia + "");
                for (buttonListPhong x : trangHoaDon.listPhong.listPhong) {
                	x.panelHoaDon.listDichVuMini.removeAll();
                	x.panelHoaDon.listDichVuMini.listDichVu.removeAll(x.panelHoaDon.listDichVuMini.listDichVu);
                	x.panelHoaDon.listDichVuMini.docDuLieuDichVu();
                	x.panelHoaDon.listDichVuMini.RenderListDichVu();
                	x.panelHoaDon.listDichVuMini.repaint();
                	trangHoaDon.addEventBTNDichVu();
                	trangHoaDon.setHeightListObject();
                } 
            }
        }
        if (obj.equals(panel.btnSua)) {
            LuuDuLieuSua();
            XoaTrang();
        }
        if (obj.equals(panel.btnXoa)) {
            if (pane.getSelectedRow() >= 0) {
                int r=pane.getSelectedRow();
                for (buttonListPhong x : trangHoaDon.listPhong.listPhong) {
			    	for (buttonListDichVu y : x.panelHoaDon.listDichVuMini.listDichVu) {
			    		if (y.name.equals(pane.table.getValueAt(r, 1).toString())) {
			    			x.panelHoaDon.listDichVuMini.remove(y);
			    			x.panelHoaDon.listDichVuMini.listDichVu.remove(y);
			    			x.panelHoaDon.listDichVuMini.repaint();
			    			break;
			    		}
			    	}
			    }
                String ma=pane.table.getValueAt(r, 0).toString();
                DichVu dv=new DichVu(ma);
                dichVu_dao.delete(dv);
                pane.removeRow(r);
                dvDV=dichVu_dao.getAllDichVu();
                trangHoaDon.setHeightListObject();
                XoaTrang();
            } else {
                JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Dòng Dữ Liệu Để Xóa");
            }
        }
        if (obj.equals(pane.table)) {
            SuaDuLieu();
        }
        if (obj.equals(panel.btnIn)) {
            System.out.println("s1");

        }
        if (obj.equals(panel.btnXoaTrang)) {
            XoaTrang();

        }
        
    }
}
