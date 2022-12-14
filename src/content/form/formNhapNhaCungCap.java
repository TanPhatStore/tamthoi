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

public class formNhapNhaCungCap extends JPanel {

	public JTextField tfMaNCC;
	public JTextField tfTenNCC;
	public JTextField tfGiaNCC;
	public JTextField tfDiaChiNCC;
	public customComBoBox comboLoaiNCC;
	public customComBoBox comboNCC;
	public customButton btnThem;
	public customButton btnXoa;
	public customButton btnSua;
	public customButton btnIn;
	public JTextField  tfSDTNCC;
	public customButton btnXoaTrang;
	public formNhapNhaCungCap () {
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

		tfMaNCC = new JTextField();
		tfMaNCC.setPreferredSize(new Dimension(300, 30));
		tfMaNCC.setSize(150, 40);
		tfMaNCC.setBackground(null);
		tfMaNCC.setOpaque(false);
		tfMaNCC.setFont(fontLable);
		tfMaNCC.setForeground(Color.white);
		tfMaNCC.setBorder(new MatteBorder(0, 0, 3, 0, new Color(175, 188, 196)));
        tfMaNCC.setEnabled(false);
        tfMaNCC.setText("H??? Th???ng T??? ?????ng Th??m");
		JLabel lblMaNCC = new JLabel("M?? NCC : ");
		lblMaNCC.setFont(fontLable);
		lblMaNCC.setForeground(Color.white);
		lblMaNCC.setPreferredSize(new Dimension(150, 35));
		boxText1_1.add(lblMaNCC);
		boxText1_1.add(tfMaNCC);

		tfTenNCC = new JTextField();
		tfTenNCC.setPreferredSize(new Dimension(300, 30));
		tfTenNCC.setSize(150, 40);
		tfTenNCC.setBackground(null);
		tfTenNCC.setOpaque(false);
		tfTenNCC.setFont(fontLable);
		tfTenNCC.setForeground(Color.white);
		tfTenNCC.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblTenNCC = new JLabel("T??n NCC : ");
		lblTenNCC.setFont(fontLable);
		lblTenNCC.setForeground(Color.white);
		lblTenNCC.setPreferredSize(new Dimension(150, 35));
		boxText1_2.add(lblTenNCC);
		boxText1_2.add(tfTenNCC);

		tfDiaChiNCC = new JTextField();
		tfDiaChiNCC.setPreferredSize(new Dimension(300, 30));
		tfDiaChiNCC.setSize(150, 40);
		tfDiaChiNCC.setBackground(null);
		tfDiaChiNCC.setOpaque(false);
		tfDiaChiNCC.setFont(fontLable);
		tfDiaChiNCC.setForeground(Color.white);
		tfDiaChiNCC.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblDiaChiNCC = new JLabel("?????a Ch??? : ");
		lblDiaChiNCC.setFont(fontLable);
		lblDiaChiNCC.setForeground(Color.white);
		lblDiaChiNCC.setPreferredSize(new Dimension(150, 35));
		boxText2_1.add(lblDiaChiNCC);
		boxText2_1.add(tfDiaChiNCC);

        tfSDTNCC = new JTextField();
		tfSDTNCC.setPreferredSize(new Dimension(300, 30));
		tfSDTNCC.setSize(150, 40);
		tfSDTNCC.setBackground(null);
		tfSDTNCC.setOpaque(false);
		tfSDTNCC.setFont(fontLable);
		tfSDTNCC.setForeground(Color.white);
		tfSDTNCC.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblSDTNCC = new JLabel("S??? ??i???n Tho???i : ");
		lblSDTNCC.setFont(fontLable);
		lblSDTNCC.setForeground(Color.white);
		lblSDTNCC.setPreferredSize(new Dimension(150, 35));
		boxText2_2.add(lblSDTNCC);
		boxText2_2.add(tfSDTNCC);



		String color3 = "#6dd5ed", color4 = "#2193b0";
		
		btnThem = new customButton("Th??m NCC",fontBtn,"hinh/button/btn_Them.png" , 
				color3, color4);
		btnXoa = new customButton("X??a NCC",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnSua = new customButton("S???a NCC",fontBtn,"hinh/button/btn_Sua.png" , 
				color3, color4);
		btnXoaTrang = new customButton("X??a Tr???ng",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnIn = new customButton("In Danh S??ch",fontBtn,"hinh/button/btn_In.png" , 
				color3, color4);

		boxBtn.add(btnThem);
		boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
		boxBtn.add(btnXoa);
		boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
		boxBtn.add(btnSua);
		boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
		boxBtn.add(btnXoaTrang);
		boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
		boxBtn.add(btnIn);
		
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
