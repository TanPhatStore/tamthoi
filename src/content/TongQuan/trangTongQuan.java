package content.TongQuan;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

import content.trangKhongMenu;
import content.menuPage.menuPage;



public class trangTongQuan extends trangKhongMenu{

	private nodeTongQuan node1;
	private nodeTongQuan node2;
	private nodeTongQuan node3;
	private nodeTongQuan node4;
	private chart chart;
	private nodeTongQuan node5;
	private nodeTongQuan node6;
	private nodeTongQuan node7;
	private nodeTongQuan node8;



	public trangTongQuan () {
		setBackground(Color.white);
		Box totalBox = Box.createVerticalBox();
		Box rowNode1 = Box.createHorizontalBox();
		Box rowNode2 = Box.createHorizontalBox();
		Box rowChart = Box.createHorizontalBox();
		add(totalBox);
		Font fontNode = new Font("Arial", Font.BOLD , 19);
		
		
		node1 = new nodeTongQuan("Đơn Hàng", "64", "hinh/node/node_DonHang.png",
				"#642B73", "#ff00cc", fontNode);
		node2 = new nodeTongQuan("Doanh Thu", "32.000.000 VND", "hinh/node/node_DoanhThu.png",
				"#2980B9", "#6DD5FA", fontNode);
		node3 = new nodeTongQuan("Phòng Sử Dụng", "18/32", "hinh/node/node_Phong.png",
				"#F37335", "#FDC830", fontNode);
		node4 = new nodeTongQuan("Đóng Góp Ý Kiến", "132", "hinh/node/node_YKien.png",
				"#1D976C", "#93F9B9", fontNode);
		node5 = new nodeTongQuan("Phòng Đã Đặt", "6", "hinh/node/node_PhongDaDat.png",
				"#544a7d", "#ffd452", fontNode);
		node6 = new nodeTongQuan("Số Dịch Vụ", "55", "hinh/node/node_DichVu.png",
				"#CF8BF3", "#FDB99B", fontNode);
		node7 = new nodeTongQuan("Số Khách Hàng", "164", "hinh/node/node_KhachHang.png",
				"#3494E6", "#EC6EAD", fontNode);
		node8 = new nodeTongQuan("Số Nhân Viên", "18", "hinh/node/node_NhanVien.png",
				"#304352", "#d7d2cc", fontNode);
		
		totalBox.add(Box.createRigidArea(new Dimension(0, 5)));
		totalBox.add(rowNode1);
		rowNode1.add(node1);
		rowNode1.add(Box.createRigidArea(new Dimension(20, 0)));
		rowNode1.add(node2);
		rowNode1.add(Box.createRigidArea(new Dimension(20, 0)));
		rowNode1.add(node3);
		rowNode1.add(Box.createRigidArea(new Dimension(20, 0)));
		rowNode1.add(node4);
		
		
		totalBox.add(Box.createRigidArea(new Dimension(0, 7)));
		totalBox.add(rowNode2);
		rowNode2.add(node5);
		rowNode2.add(Box.createRigidArea(new Dimension(20, 0)));
		rowNode2.add(node6);
		rowNode2.add(Box.createRigidArea(new Dimension(20, 0)));
		rowNode2.add(node7);
		rowNode2.add(Box.createRigidArea(new Dimension(20, 0)));
		rowNode2.add(node8);
		
		
		totalBox.add(Box.createRigidArea(new Dimension(0, 15)));
		totalBox.add(rowChart); 
		rowChart.add(new chart());
	}
}
