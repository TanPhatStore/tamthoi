package content.ThongKe;

import java.awt.Dimension;

import javax.swing.Box;

import content.table;

public class trangYKKH {

	private table pane;
	private nodeThongKe nodeLeft;
	private nodeTongCong nodeRight;

	void RenderUIYKKH (Box totalBox) {
		Box boxNode = Box.createHorizontalBox();
		totalBox.add(Box.createRigidArea(new Dimension(0, 8)));
		totalBox.add(boxNode);
		
		totalBox.add(Box.createRigidArea(new Dimension(0, 13)));
		
		nodeLeft = new nodeThongKe("#FC5C7D", "#6A82FB", "Y Kien");
		nodeRight = new nodeTongCong("#FC5C7D", "#6A82FB", "", "Y Kien");
		boxNode.add(Box.createRigidArea(new Dimension(20, 0)));
		boxNode.add(nodeLeft);
		boxNode.add(Box.createRigidArea(new Dimension(10, 0)));
		boxNode.add(nodeRight);
		boxNode.add(Box.createRigidArea(new Dimension(20, 0)));
		
		// add table
		String[] header = {"Mã Nhân Viên", "Tên Nhân Viên", "Số Điện Thoại", "Địa Chỉ", "Số Hóa Đơn Đã Lập", "Tổng Tiền Hóa Đơn"} ;
		pane = new table(header);
		pane.setPreferredSize(new Dimension(1200, 500));
		totalBox.add(pane);
	}
}
