package content.ThongKe;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JOptionPane;

import Function.functionNecessary;
import content.table;
import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.PhieuNhapHang_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.PhieuNhapHang;

public class trangTKHD implements ActionListener {

	private table pane;
	private nodeThongKe nodeLeft;
	private nodeTongCong nodeRight;
	private HoaDon_DAO hoaDon_dao;
	private ChiTietHoaDon_DAO ctHoaDon_dao;
	private ArrayList<HoaDon> dsHoaDon;
	private ArrayList<ChiTietHoaDon> dsCTHoaDon;
	private table pane1;
	private table pane2;
	private PhieuNhapHang_DAO phieuNhapHang_dao;
	private ArrayList<PhieuNhapHang> dsPhieuNhapHang;
	private functionNecessary d;

	void RenderUITKHD (Box totalBox) {
		Box boxNode = Box.createHorizontalBox();
		totalBox.add(Box.createRigidArea(new Dimension(0, 8)));
		totalBox.add(boxNode);
		
		totalBox.add(Box.createRigidArea(new Dimension(0, 13)));
		
		nodeLeft = new nodeThongKe("#FC5C7D", "#6A82FB", "Hoa Don");
		nodeRight = new nodeTongCong("#FC5C7D", "#6A82FB", "Doanh Thu", "Hoa Don");
		boxNode.add(Box.createRigidArea(new Dimension(20, 0)));
		boxNode.add(nodeLeft);
		boxNode.add(Box.createRigidArea(new Dimension(10, 0)));
		boxNode.add(nodeRight);
		boxNode.add(Box.createRigidArea(new Dimension(20, 0)));
		
		// add table
		String[] header1 = {"Mã Hóa Đơn", "Thời Gian", "Khách Hàng", "Phòng", "Số Lượng", "Thành Tiền"} ;
		pane1 = new table(header1);
		pane1.setPreferredSize(new Dimension(1200, 500));
		
		
		String[] header2 = {"Mã Phiếu Nhập", "Thời Gian","Nhà Cung Cấp", "Số Lượng", "Thành Tiền"} ;
		pane2 = new table(header2);
		pane2.setPreferredSize(new Dimension(1200, 500));
		
		
		totalBox.add(pane1);
		ReadDataOfOrderAndOrderDetail();
		ReadDataOfTicketCreateService ();
		d = new functionNecessary();
		nodeRight.DoanhThu = nodeRight.KhoangThu - nodeRight.KhoangChi;
		nodeRight.lbl3 = "Tổng Doanh Thu   : " + d.formatMoney(nodeRight.DoanhThu);
		nodeRight.label3.setText(nodeRight.lbl3);
		
		
		if (nodeLeft.btnXemThongKe.getActionListeners().length == 0) {
			nodeLeft.btnXemThongKe.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) { 
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
					if (nodeLeft.comboLeft1.getSelectedItem().equals("Thống Kê Khoảng Thu")) {
						try {
							Date date1 = df.parse(nodeLeft.txtdate1.getText());
							Date date2 = df.parse(nodeLeft.txtdate2.getText());
							int a = date1.compareTo(date2);
							if (a == -1 || a == 0) {
								RenderRowDate ();
								totalBox.remove(3);
								totalBox.add(pane1);
								totalBox.repaint();
							} else {
								JOptionPane.showMessageDialog(null, "Ngày Kết Thúc Phải Sau Ngày Bắt Đầu");
							}
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
						
					} else {
						try {
							Date date1 = df.parse(nodeLeft.txtdate1.getText());
							Date date2 = df.parse(nodeLeft.txtdate2.getText());
							int a = date1.compareTo(date2);
							if (a == -1 || a == 0) {
								RenderRowDate ();
								totalBox.remove(3);
								totalBox.add(pane2);
								totalBox.repaint();
							} else {
								JOptionPane.showMessageDialog(null, "Ngày Kết Thúc Phải Sau Ngày Bắt Đầu");
							}
						} catch (ParseException e1) {
							e1.printStackTrace();
						}
					}
				}
			});
		}
		
		nodeLeft.btnTaiLai.addActionListener(this);
		
	}
	
	public void RenderRowDate () throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date date1 = df.parse(nodeLeft.txtdate1.getText());
		Date date2 = df.parse(nodeLeft.txtdate2.getText());
		pane2.removeAll();
		nodeRight.KhoangChi = 0;
		for (PhieuNhapHang x : dsPhieuNhapHang) {
			Date date3 = df.parse(x.getThoiGian().toString().substring(10, 21));
			if (date3.compareTo(date1) == 1 || date3.compareTo(date1) == 0) {
				if (date3.compareTo(date2) == -1 || date3.compareTo(date2) == 0) {
					
					nodeRight.KhoangChi += Integer.parseInt( d.formatString(x.getTongTien()));
					
					pane2.addRow(new Object[] {x.getMaPhieu(), x.getThoiGian(), x.getNhaCungCap().getTenNhaCungCap(),
							x.getSoLuong(), x.getTongTien()});
				}
			}
		}
		nodeRight.KhoangThu = 0;
		pane1.removeAll();
		for (HoaDon x : dsHoaDon) {
			Date date3 = df.parse(d.formatTimeForAnalysis(x.getNgayLapHoaDon()).toString().substring(0, 11));
			if (date3.compareTo(date1) == 1 || date3.compareTo(date1) == 0 ) {
				if (date3.compareTo(date2) == -1 || date3.compareTo(date2) == 0) {
					int soLuong  = 0;
					for (ChiTietHoaDon y : dsCTHoaDon) {
						if (y.getHoaDon().getMaHoaDon().equals(x.getMaHoaDon())) {
							soLuong ++;
						}
					}
					nodeRight.KhoangThu += Integer.parseInt( d.formatString(x.getTongTien()));
					
					pane1.addRow(new Object[] {x.getMaHoaDon(), d.formatTimeForAnalysis(x.getNgayLapHoaDon()), x.getKhachHang().getTenKhachHang()
							, x.getPhong().getTenPhong(), soLuong , x.getTongTien()});
				}
			}
		}
		nodeRight.lbl2 = "Tổng Khoảng Chi   : " + d.formatMoney(nodeRight.KhoangChi);
		nodeRight.label2.setText(nodeRight.lbl2);
		nodeRight.lbl1 = "Tổng Khoảng Thu   : " + d.formatMoney(nodeRight.KhoangThu);
		nodeRight.label1.setText(nodeRight.lbl1);
		nodeRight.DoanhThu = nodeRight.KhoangThu - nodeRight.KhoangChi;
		nodeRight.lbl3 = "Tổng Doanh Thu   : " + d.formatMoney(nodeRight.DoanhThu);
		nodeRight.label3.setText(nodeRight.lbl3);
	}

	
	public void ReadDataOfOrderAndOrderDetail () {
		hoaDon_dao = new HoaDon_DAO();
		ctHoaDon_dao = new ChiTietHoaDon_DAO();
		dsHoaDon = hoaDon_dao.getAllHoaDon();
		dsCTHoaDon = ctHoaDon_dao.getAllChiTietHoaDon();
		functionNecessary d = new functionNecessary();
		for (HoaDon x : dsHoaDon) {
			int soLuong  = 0;
			for (ChiTietHoaDon y : dsCTHoaDon) {
				if (y.getHoaDon().getMaHoaDon().equals(x.getMaHoaDon())) {
					soLuong += y.getSoLuong();
				}
			}
			nodeRight.KhoangThu += Integer.parseInt( d.formatString(x.getTongTien()));
			nodeRight.lbl1 = "Tổng Khoảng Thu   : " + d.formatMoney(nodeRight.KhoangThu);
			nodeRight.label1.setText(nodeRight.lbl1);
			pane1.addRow(new Object[] {x.getMaHoaDon(), d.formatTimeForAnalysis(x.getNgayLapHoaDon()), x.getKhachHang().getTenKhachHang()
					, x.getPhong().getTenPhong(), soLuong , x.getTongTien()});
		}
		
	}
	public void ReadDataOfTicketCreateService () {
		functionNecessary d = new functionNecessary();
		phieuNhapHang_dao = new PhieuNhapHang_DAO();
		dsPhieuNhapHang = phieuNhapHang_dao.getAllPhieuNhapHang();
		for (PhieuNhapHang x : dsPhieuNhapHang) {
			nodeRight.KhoangChi += Integer.parseInt( d.formatString(x.getTongTien()));
			nodeRight.lbl2 = "Tổng Khoảng Chi   : " + d.formatMoney(nodeRight.KhoangChi);
			nodeRight.label2.setText(nodeRight.lbl2);
			pane2.addRow(new Object[] {x.getMaPhieu(), x.getThoiGian(), x.getNhaCungCap().getTenNhaCungCap(),
					x.getSoLuong(), x.getTongTien()});
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(nodeLeft.btnXemThongKe)) {
			if (nodeLeft.comboLeft1.equals("Thống Kê Khoảng Thu"))  {
				
			} else if (nodeLeft.comboLeft1.equals("Thống Kê Khoảng Chi"))  {
				
			} else if (nodeLeft.comboLeft1.equals("Thống Kê Doanh Thu"))  {
				
			}
		}
		if (obj.equals(nodeLeft.btnTaiLai)) {
			ReadDataOfOrderAndOrderDetail ();
		}
	}
}
