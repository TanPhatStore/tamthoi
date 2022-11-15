package content.form;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import content.customButton;

public class formNhapNhanVien extends JPanel {

	public JTextField tfMaNV;
	public JTextField tfTenNV;
	
	public customComBoBox comboLoaiDV;
	public customComBoBox comboNCC;
	public customButton btnThem;
	public customButton btnXoa;
	public customButton btnSua;
	public customButton btnIn;
	public customButton btnTim;
	public customButton btnTaiTrang;
	public JTextField tfDiaChiNV;
	public JComponent tfChucVu;
	public JTextField tfSDTNV;
	public customComBoBox comboCVNV;
	public customButton btnXoaTrang;
	
	public formNhapNhanVien (String type) {
		Font fontLable = new Font("Arial", 0, 19);
		Font fontBtn = new Font("Arial", 0 , 17);
		setPreferredSize(new Dimension(300, 260));
		setLayout(getLayout());
		Box boxTotal = Box.createVerticalBox();
		add(boxTotal);
		Box boxText = Box.createHorizontalBox();
		boxTotal.add(Box.createRigidArea(new Dimension(0, 20)));
		boxTotal.add(boxText);
		Box boxBtn = Box.createHorizontalBox();
		boxTotal.add(Box.createRigidArea(new Dimension(0, 40)));
		boxTotal.add(boxBtn);
		Box boxText1 = Box.createVerticalBox();
		Box boxText1_1 = Box.createHorizontalBox();
		Box boxText1_2 = Box.createHorizontalBox();
		Box boxText1_3 = Box.createHorizontalBox();
		Box boxText2 = Box.createVerticalBox();
		Box boxText2_1 = Box.createHorizontalBox();
		Box boxText2_2 = Box.createHorizontalBox();
		Box boxText2_3 = Box.createHorizontalBox();
		boxText.add(boxText1);
		boxText.add(Box.createRigidArea(new Dimension(60, 0)));
		boxText.add(boxText2);
		boxText1.add(boxText1_1);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText1_2);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText1_3);
		boxText2.add(boxText2_1);
		boxText2.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText2.add(boxText2_2);
		boxText2.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText2.add(boxText2_3);

		tfMaNV = new JTextField();
		tfMaNV.setPreferredSize(new Dimension(300, 30));
		tfMaNV.setSize(100, 40);
		tfMaNV.setBackground(null);
		tfMaNV.setOpaque(false);
		tfMaNV.setFont(fontLable);
		tfMaNV.setForeground(Color.white);
		tfMaNV.setBorder(new MatteBorder(0, 0, 3, 0, new Color(175, 188, 196)));
		tfMaNV.setEnabled(false);
		tfMaNV.setText("Hệ Thống Tự Động Thêm");
		JLabel lblMaNV = new JLabel("Mã Nhân Viên : ");
		lblMaNV.setFont(fontLable);
		lblMaNV.setForeground(Color.white);
		lblMaNV.setPreferredSize(new Dimension(150, 35));
		boxText1_1.add(lblMaNV);
		boxText1_1.add(tfMaNV);

		tfTenNV = new JTextField();
		tfTenNV.setPreferredSize(new Dimension(300, 30));
		tfTenNV.setSize(100, 40);
		tfTenNV.setBackground(null);
		tfTenNV.setOpaque(false);
		tfTenNV.setFont(fontLable);
		tfTenNV.setForeground(Color.white);
		tfTenNV.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblTenNV = new JLabel("Tên Nhân Viên : ");
		lblTenNV.setFont(fontLable);
		lblTenNV.setForeground(Color.white);
		lblTenNV.setPreferredSize(new Dimension(150, 35));
		boxText1_2.add(lblTenNV);
		boxText1_2.add(tfTenNV);

		tfDiaChiNV = new JTextField();
		tfDiaChiNV.setPreferredSize(new Dimension(300, 30));
		tfDiaChiNV.setSize(100, 40);
		tfDiaChiNV.setBackground(null);
		tfDiaChiNV.setOpaque(false);
		tfDiaChiNV.setFont(fontLable);
		tfDiaChiNV.setForeground(Color.white);
		tfDiaChiNV.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblDiaChiNV = new JLabel("Địa chỉ : ");
		lblDiaChiNV.setFont(fontLable);
		lblDiaChiNV.setForeground(Color.white);
		lblDiaChiNV.setPreferredSize(new Dimension(150, 35));
		boxText1_3.add(lblDiaChiNV);
		boxText1_3.add(tfDiaChiNV);

		tfSDTNV = new JTextField();
		tfSDTNV.setPreferredSize(new Dimension(300, 30));
		tfSDTNV.setSize(100, 40);
		tfSDTNV.setBackground(null);
		tfSDTNV.setOpaque(false);
		tfSDTNV.setFont(fontLable);
		tfSDTNV.setForeground(Color.white);
		tfSDTNV.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblSDT = new JLabel("Số Điện Thoại : ");
		lblSDT.setFont(fontLable);
		lblSDT.setForeground(Color.white);
		lblSDT.setPreferredSize(new Dimension(150, 35));
		boxText2_1.add(lblSDT);
		boxText2_1.add(tfSDTNV);

		comboCVNV = new customComBoBox();
		comboCVNV.setFont(fontLable);
		comboCVNV.addItem("Không");
		JLabel lblCVNV = new JLabel("Chức Vụ : ");
		lblCVNV.setFont(fontLable);
		lblCVNV.setForeground(Color.white);
		lblCVNV.setPreferredSize(new Dimension(150, 35));
		boxText2_2.add(lblCVNV);
		boxText2_2.add(comboCVNV);

		boxText2_3.add(Box.createRigidArea(new Dimension(0, 35)));


		String color3 = "#6dd5ed", color4 = "#2193b0";
		
		btnThem = new customButton("Thêm Nhân Viên",fontBtn,"hinh/button/btn_Them.png" , 
				color3, color4);
		btnXoa = new customButton("Xóa Nhân Viên",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnSua = new customButton("Sửa Nhân Viên",fontBtn,"hinh/button/btn_Sua.png" , 
				color3, color4);
		btnXoaTrang = new customButton("Xóa Trắng",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnIn = new customButton("In Danh Sách",fontBtn,"hinh/button/btn_In.png" , 
				color3, color4);
		btnTim = new customButton("Tìm Nhân Viên",fontBtn,"hinh/button/btn_Tim.png" , 
				color3, color4);
		btnTaiTrang = new customButton("Tải Dữ Liệu",fontBtn,"hinh/button/btn_TaiTrang.png" , 
				color3, color4);
		
		btnThem.setPreferredSize(new Dimension(200, 50));
		btnXoa.setPreferredSize(new Dimension(200, 50));
		btnSua.setPreferredSize(new Dimension(200, 50));
		btnIn.setPreferredSize(new Dimension(200, 50));
		btnXoaTrang.setPreferredSize(new Dimension(200, 50));

		if (type.equals("QLNV")) {
			boxBtn.add(btnThem);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnXoa);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnSua);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnXoaTrang);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnIn);
		} else {
			boxBtn.add(btnTim);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnTaiTrang);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnXoaTrang);
		}
		
		
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#5B86E5"), w, h, Color.decode("#FC466B"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,15,15);
    }
}

