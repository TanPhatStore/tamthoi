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

public class formNhapLoaiDichVu extends JPanel {

	public JTextField tfMaLDV;
	public JTextField tfTenLDV;
	public JTextField tfGiaLDV;
	public JTextField tfMoTaLDV;
	public customComBoBox comboLoaiLDV;
	public customComBoBox comboNCC;
	public customButton btnThem;
	public customButton btnXoa;
	public customButton btnSua;
	public customButton btnIn;
	public customButton btnXoaTrang;
	public formNhapLoaiDichVu () {
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

		tfMaLDV = new JTextField();
		tfMaLDV.setPreferredSize(new Dimension(300, 30));
		tfMaLDV.setSize(100, 40);
		tfMaLDV.setBackground(null);
		tfMaLDV.setOpaque(false);
		tfMaLDV.setFont(fontLable);
		tfMaLDV.setForeground(Color.white);
		tfMaLDV.setBorder(new MatteBorder(0, 0, 3, 0,new Color(175, 188, 196)));
		JLabel lblMaLDV = new JLabel("M?? LDV : ");
		tfMaLDV.setEnabled(false);
        tfMaLDV.setText("H??? Th???ng T??? ?????ng Th??m");
		lblMaLDV.setFont(fontLable);
		lblMaLDV.setForeground(Color.white);
		lblMaLDV.setPreferredSize(new Dimension(100, 35));
		boxText1_1.add(lblMaLDV);
		boxText1_1.add(tfMaLDV);

		tfTenLDV = new JTextField();
		tfTenLDV.setPreferredSize(new Dimension(300, 30));
		tfTenLDV.setSize(100, 40);
		tfTenLDV.setBackground(null);
		tfTenLDV.setOpaque(false);
		tfTenLDV.setFont(fontLable);
		tfTenLDV.setForeground(Color.white);
		tfTenLDV.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblTenLDV = new JLabel("T??n LDV : ");
		lblTenLDV.setFont(fontLable);
		lblTenLDV.setForeground(Color.white);
		lblTenLDV.setPreferredSize(new Dimension(100, 35));
		boxText1_2.add(lblTenLDV);
		boxText1_2.add(tfTenLDV);

		tfMoTaLDV = new JTextField();
		tfMoTaLDV.setPreferredSize(new Dimension(300, 30));
		tfMoTaLDV.setSize(100, 40);
		tfMoTaLDV.setBackground(null);
		tfMoTaLDV.setOpaque(false);
		tfMoTaLDV.setFont(fontLable);
		tfMoTaLDV.setForeground(Color.white);
		tfMoTaLDV.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblMoTaLDV = new JLabel("M?? T??? : ");
		lblMoTaLDV.setFont(fontLable);
		lblMoTaLDV.setForeground(Color.white);
		lblMoTaLDV.setPreferredSize(new Dimension(100, 35));
		boxText2_1.add(lblMoTaLDV);
		boxText2_1.add(tfMoTaLDV);

        boxText2_2.add(Box.createRigidArea(new Dimension(0, 35)));



		String color3 = "#6dd5ed", color4 = "#2193b0";
		
		btnThem = new customButton("Th??m Lo???i D???ch V???",fontBtn,"hinh/button/btn_Them.png" , 
				color3, color4);
		btnXoa = new customButton("X??a Lo???i D???ch V???",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnSua = new customButton("S???a Lo???i D???ch V???",fontBtn,"hinh/button/btn_Sua.png" , 
				color3, color4);
		btnXoaTrang = new customButton("X??a Tr???ng",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnIn = new customButton("In Danh S??ch",fontBtn,"hinh/button/btn_In.png" , 
				color3, color4);
		btnThem.setPreferredSize(new Dimension(200, 50));
		btnXoa.setPreferredSize(new Dimension(200, 50));
		btnSua.setPreferredSize(new Dimension(200, 50));
		btnIn.setPreferredSize(new Dimension(200, 50));
		btnXoaTrang.setPreferredSize(new Dimension(200, 50));
		
		boxBtn.add(btnThem);
		boxBtn.add(Box.createRigidArea(new Dimension(15, 0)));
		boxBtn.add(btnXoa);
		boxBtn.add(Box.createRigidArea(new Dimension(15, 0)));
		boxBtn.add(btnSua);
		boxBtn.add(Box.createRigidArea(new Dimension(15, 0)));
		boxBtn.add(btnXoaTrang);
		boxBtn.add(Box.createRigidArea(new Dimension(15, 0)));
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
