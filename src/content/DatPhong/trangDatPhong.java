package content.DatPhong;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.PageAttributes.ColorType;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;
import javax.swing.table.DefaultTableModel;

import content.table;
import content.trangKhongMenu;
import content.form.formNhapDichVu;
import content.hoa_don.buttonListDichVu;
import content.hoa_don.titleHoaDon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class trangDatPhong  extends trangKhongMenu implements ActionListener, MouseListener{
	
	
	private JPanel area3;
	private JScrollBar sb;
	private JScrollBar sb_width;
	private listDatPhong listDatPhong;
	private buttonListDatPhong btnDatPhong;
	
	private table table;	
	
	private JPanel panelList2;
	private JScrollPane js1;
	private JScrollPane js2;
	private panelDatPhong panelDatPhong;
	private titleDatPhong panel;
	public trangDatPhong() {

	
		panelDatPhong = new panelDatPhong();

		listDatPhong = new listDatPhong();
		js1 =new JScrollPane(listDatPhong,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		js1.setPreferredSize(new Dimension(550, 720));
		js1.setBorder(BorderFactory.createEmptyBorder());
		js1.getVerticalScrollBar().setUnitIncrement(6);
		js1.setBackground(Color.white);

		


		Box boxLeft = Box.createVerticalBox();
		Box boxRight = Box.createVerticalBox();
		Box boxTotal = Box.createHorizontalBox();
		boxLeft.add(Box.createRigidArea(new Dimension(0, 20)));

		JPanel panelList1 = new JPanel();
		panelList1.setLayout(new GridLayout(1, 0));
		panelList1.setBackground(Color.white);
		btnDatPhong = new buttonListDatPhong(  "","Khách Hàng", "","","","");
		
		btnDatPhong.setPreferredSize(new Dimension(60, 40));
		panelList1.add(btnDatPhong);
		
		panelList1.add(Box.createRigidArea(new Dimension(40, 0)));

		panelList2 = new JPanel();
		panelList2.add(js1);

		boxLeft.add(panelList1);
		boxLeft.add(Box.createRigidArea(new Dimension(0, 10)));
		boxLeft.add(panelList2);
		boxLeft.add(Box.createRigidArea(new Dimension(50, 0)));

		boxRight.add(panelDatPhong);


		add(boxTotal);
		boxTotal.add(boxLeft);
		boxTotal.add(Box.createRigidArea(new Dimension(15,0)));
		boxTotal.add(boxRight);

		
	
		
		

		for (buttonListDatPhong x : listDatPhong.listDatPhong) {
			x.addActionListener(this);
			
		}
		panelDatPhong.getBtnDatPhong().addMouseListener(this);
		panelDatPhong.getBtnXoa().addMouseListener(this);
		panelDatPhong.getBtnSuaDatPhong().addMouseListener(this);
		panelDatPhong.getBtnXoaTrang().addMouseListener(this);
		panelDatPhong.table.table.addMouseListener(this);
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object obj = arg0.getSource();
		if (obj.equals(btnDatPhong)) {
			panelList2.removeAll();
			panelList2.add(js1);
			invalidate();
        	validate();
        	repaint();
		}
		panelDatPhong.title.tfMaKH.setText(((buttonListDatPhong) obj).getMa());
		panelDatPhong.title.tfTenKH.setText(((buttonListDatPhong) obj).getName());
		panelDatPhong.title.tfSDT.setText(((buttonListDatPhong) obj).getSdt());
		panelDatPhong.title.tfDiaChi.setText(((buttonListDatPhong) obj).getDiaChi());
		panelDatPhong.title.comboGioDat.getSelectedItem().toString();
		panelDatPhong.title.comboPhongDat.getSelectedItem().toString();
		panelDatPhong.box.invalidate();
		panelDatPhong.box.validate();
		panelDatPhong.box.repaint();
		
		

		
		for (buttonListDatPhong x : listDatPhong.listDatPhong) {
			
					x.setColor1("#12c2e9");
					x.setColor2("#c471ed");
					repaint();
				
			
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		Object obj = arg0.getSource();
		if (obj.equals(panelDatPhong.getBtnDatPhong())) {
			panelDatPhong.table.addRow(new Object[] {
			
			panelDatPhong.title.tfTenKH.getText(),
			panelDatPhong.title.tfSDT.getText(),
			panelDatPhong.title.tfDiaChi.getText(),
			panelDatPhong.title.comboGioDat.getSelectedItem().toString(),
			panelDatPhong.title.comboPhongDat.getSelectedItem().toString()});
			XoaTrang();
		}
		if (obj.equals(panelDatPhong.table.table)) {
		panelDatPhong.title.tfTenKH.setText((String) panelDatPhong.table.table.getModel().getValueAt(panelDatPhong.table.getSelectedRow(), 0));
		panelDatPhong.title.tfSDT.setText((String)panelDatPhong.table.table.getModel().getValueAt(panelDatPhong.table.getSelectedRow(), 1));
		panelDatPhong.title.tfDiaChi.setText((String) panelDatPhong.table.table.getModel().getValueAt(panelDatPhong.table.getSelectedRow(), 2));
		panelDatPhong.title.comboGioDat.setSelectedItem((String) panelDatPhong.table.table.getModel().getValueAt(panelDatPhong.table.getSelectedRow(), 3));
		panelDatPhong.title.comboPhongDat.setSelectedItem((String) panelDatPhong.table.table.getModel().getValueAt(panelDatPhong.table.getSelectedRow(), 4));
		}
		if (obj.equals(panelDatPhong.btnSuaDatPhong)) {

			LuuDuLieuSua();
			XoaTrang();
		}
		if (obj.equals(panelDatPhong.getBtnXoaTrang())) {
			XoaTrang();
		}
		if (obj.equals(panelDatPhong.getBtnXoa())) {
			if (panelDatPhong.table.getSelectedRow() >= 0) {
				panelDatPhong.table.removeRow(panelDatPhong.table.getSelectedRow());
				for (buttonListDatPhong x : listDatPhong.listDatPhong) {
					
						x.setColor1("#12c2e9");
						x.setColor2("#c471ed");
						repaint();
					
				}
			} else {
				JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Dòng Dữ Liệu Để Xóa");
			}

			
		}
		if (obj.equals(panelDatPhong.table)) {
			panelDatPhong.title.tfMaKH.setText(((buttonListDatPhong) obj).getMa());
			panelDatPhong.title.tfTenKH.setText(((buttonListDatPhong) obj).getName());
			panelDatPhong.title.tfSDT.setText(((buttonListDatPhong) obj).getSdt());
			panelDatPhong.title.tfDiaChi.setText(((buttonListDatPhong) obj).getDiaChi());
			panelDatPhong.title.comboGioDat.getSelectedItem().toString();
			panelDatPhong.title.comboPhongDat.getSelectedItem().toString();
		}
	
		
			
		
	}
	
	private void LuuDuLieuSua() {
		int row = panelDatPhong.table.getSelectedRow();
		

		panelDatPhong.table.table.getModel().setValueAt(panelDatPhong.title.comboGioDat.getSelectedItem().toString(), row, 3);
		panelDatPhong.table.table.getModel().setValueAt(panelDatPhong.title.comboPhongDat.getSelectedItem().toString(), row, 4);
	}
	private void XoaTrang() {
		panelDatPhong.title.tfMaKH.setText("");
		panelDatPhong.title.tfTenKH.setText("");
		panelDatPhong.title.tfSDT.setText("");
		panelDatPhong.title.tfDiaChi.setText("");
		panelDatPhong.title.comboGioDat.setSelectedItem("Không");
		panelDatPhong.title.comboPhongDat.setSelectedItem("Không");
		
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
