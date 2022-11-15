package content.ThongKe;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.Box;
import javax.swing.JOptionPane;

import Function.functionNecessary;
import content.table;
import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;

public class trangTKKH {

	private table pane;
	private nodeThongKe nodeLeft;
	private nodeTongCong nodeRight;
	private KhachHang_DAO khachHang_dao;
	private functionNecessary d;
	private HoaDon_DAO hoaDon_dao;
	private ArrayList<HoaDon> dsHoaDon;
	private ChiTietHoaDon_DAO ctHoaDon_dao;
	private ArrayList<ChiTietHoaDon> dsCTHoaDon;
	void RenderUITKHD (Box totalBox) {
		Box boxNode = Box.createHorizontalBox();
		totalBox.add(Box.createRigidArea(new Dimension(0, 8)));
		totalBox.add(boxNode);
		
		totalBox.add(Box.createRigidArea(new Dimension(0, 13)));
		
		nodeLeft = new nodeThongKe("#FC5C7D", "#6A82FB", "Khach Hang");
		nodeRight = new nodeTongCong("#FC5C7D", "#6A82FB", "Doanh Thu", "Khach Hang");
		boxNode.add(Box.createRigidArea(new Dimension(20, 0)));
		boxNode.add(nodeLeft);
		boxNode.add(Box.createRigidArea(new Dimension(10, 0)));
		boxNode.add(nodeRight);
		boxNode.add(Box.createRigidArea(new Dimension(20, 0)));
		
		// add table
		String[] header = {"Mã Khách Hàng", "Tên Khách Hàng", "Địa Chỉ", "Số Điện Thoại", "Tổng Tiền Hóa Đơn"} ;
		pane = new table(header);
		pane.setPreferredSize(new Dimension(1200, 500));
		totalBox.add(pane);
		khachHang_dao=new KhachHang_DAO();
        docDuLieuLoaiDichVu();
        
        if (nodeLeft.btnXemThongKe.getActionListeners().length == 0) {
        	nodeLeft.btnXemThongKe.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
						Date date1 = df.parse(nodeLeft.txtdate1.getText());
						Date date2 = df.parse(nodeLeft.txtdate2.getText());
						int a = date1.compareTo(date2);
						if (a == -1 || a == 0) {
							UpdateTongTienKhachHang ();
						} else {
							JOptionPane.showMessageDialog(null, "Ngày Kết Thúc Phải Sau Ngày Bắt Đầu");
						
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
        }
        
        
	}
	public void docDuLieuLoaiDichVu() {
        ArrayList<KhachHang> dsKH=khachHang_dao.getAllDSKhachHang();
        hoaDon_dao = new HoaDon_DAO();
		ctHoaDon_dao = new ChiTietHoaDon_DAO();
		dsHoaDon = hoaDon_dao.getAllHoaDon();
		dsCTHoaDon = ctHoaDon_dao.getAllChiTietHoaDon();
        d = new functionNecessary();
        for (KhachHang kh : dsKH) {
            pane.addRow(new Object[] {kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getDiaChi(),kh.getSoDienThoai(), d.formatMoney(kh.getTongTienHoaDon())});
        }
        
        for (int i = 0; i < pane.getRowCount() ; i++) {
			int tong = 0;
			for (HoaDon x : dsHoaDon) {
				if (x.getKhachHang().getMaKhachHang().equals(pane.table.getModel().getValueAt(i, 0))) {
					tong += Integer.parseInt(d.formatString(x.getTongTien()));
				}
			}
			pane.table.getModel().setValueAt(d.formatMoney(tong), i, 4);
		}
        int tong1 = 0;
        for (int i = 0; i < pane.getRowCount() ; i++) {
        	tong1 += Integer.parseInt(d.formatString((String) pane.table.getModel().getValueAt(i, 4)));
		}
        
        nodeRight.lbl1 = "Tổng Số Khách Hàng   : " + pane.getRowCount();
        nodeRight.label1.setText(nodeRight.lbl1);
        nodeRight.lbl2 = "Tổng Tiền Hóa Đơn      : " + d.formatMoney(tong1);
        nodeRight.label2.setText(nodeRight.lbl2);
        
    }
	public void UpdateTongTienKhachHang () throws ParseException {
		hoaDon_dao = new HoaDon_DAO();
		ctHoaDon_dao = new ChiTietHoaDon_DAO();
		dsHoaDon = hoaDon_dao.getAllHoaDon();
		dsCTHoaDon = ctHoaDon_dao.getAllChiTietHoaDon();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		d = new functionNecessary();
		Date date1 = df.parse(nodeLeft.txtdate1.getText());
		Date date2 = df.parse(nodeLeft.txtdate2.getText());
		
		for (int i = 0; i < pane.getRowCount() ; i++) {
			int tong = 0;
			for (HoaDon x : dsHoaDon) {
				if (x.getKhachHang().getMaKhachHang().equals(pane.table.getModel().getValueAt(i, 0))) {
					Date date3 = df.parse(d.formatTimeForAnalysis(x.getNgayLapHoaDon()).toString().substring(0, 11));
					if (date3.compareTo(date1) == 1 || date3.compareTo(date1) == 0) {
						if (date3.compareTo(date2) == -1 || date3.compareTo(date2) == 0) {
							tong += Integer.parseInt(d.formatString(x.getTongTien()));
						}
					}
				}
			}
			pane.table.getModel().setValueAt(d.formatMoney(tong), i, 4);
		}
		int tong1 = 0;
        for (int i = 0; i < pane.getRowCount() ; i++) {
        	tong1 += Integer.parseInt(d.formatString((String) pane.table.getModel().getValueAt(i, 4)));
		}
        nodeRight.lbl2 = "Tổng Tiền Hóa Đơn      : " + d.formatMoney(tong1);
        nodeRight.label2.setText(nodeRight.lbl2);
	}
}