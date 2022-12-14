package content.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import content.customButton;

public class formNhapPhong extends JPanel{
	public JTextField tfMaP;
	public JTextField tfTenP;
	public JTextField tfGiaP;
	public customComBoBox comboLP;
	public customButton btnThem;
	public customButton btnXoa;
	public customButton btnSua;
	public customButton btnIn;
	public customButton btnTim;
	public customButton btnTaiTrang;
	public customButton btnXoaTrang;
	public formNhapPhong(String type)
	{
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

		tfMaP = new JTextField();
		tfMaP.setPreferredSize(new Dimension(300, 30));
		tfMaP.setSize(100, 40);
		tfMaP.setBackground(null);
		tfMaP.setOpaque(false);
		tfMaP.setFont(fontLable);
		tfMaP.setForeground(Color.white);
		tfMaP.setBorder(new MatteBorder(0, 0, 3, 0, new Color(175, 188, 196)));
		tfMaP.setText("H??? Th???ng T??? ?????ng Th??m");
		tfMaP.setEnabled(false);
		JLabel lblMaP = new JLabel("M?? Ph??ng : ");
		lblMaP.setFont(fontLable);
		lblMaP.setForeground(Color.white);
		lblMaP.setPreferredSize(new Dimension(150, 35));
		boxText1_1.add(lblMaP);
		boxText1_1.add(tfMaP);

		tfTenP = new JTextField();
		tfTenP.setPreferredSize(new Dimension(300, 30));
		tfTenP.setSize(100, 40);
		tfTenP.setBackground(null);
		tfTenP.setOpaque(false);
		tfTenP.setFont(fontLable);
		tfTenP.setForeground(Color.white);
		tfTenP.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblTenP = new JLabel("T??n Ph??ng: ");
		lblTenP.setFont(fontLable);
		lblTenP.setForeground(Color.white);
		lblTenP.setPreferredSize(new Dimension(150, 35));
		boxText1_2.add(lblTenP);
		boxText1_2.add(tfTenP);

		tfGiaP = new JTextField();
		tfGiaP.setPreferredSize(new Dimension(300, 30));
		tfGiaP.setSize(100, 40);
		tfGiaP.setBackground(null);
		tfGiaP.setOpaque(false);
		tfGiaP.setFont(fontLable);
		tfGiaP.setForeground(Color.white);
		tfGiaP.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblGiaP = new JLabel("Gi?? Ph??ng : ");
		lblGiaP.setFont(fontLable);
		lblGiaP.setForeground(Color.white);
		lblGiaP.setPreferredSize(new Dimension(150, 35));
		boxText2_1.add(lblGiaP);
		boxText2_1.add(tfGiaP);

		

		comboLP= new customComBoBox();
		comboLP.setFont(fontLable);
		comboLP.addItem("Kh??ng");
		JLabel lblLP = new JLabel("Lo???i Ph??ng : ");
		lblLP.setFont(fontLable);
		lblLP.setForeground(Color.white);
		lblLP.setPreferredSize(new Dimension(150, 35));
		boxText2_2.add(lblLP);
		boxText2_2.add(comboLP);

		


		String color3 = "#6dd5ed", color4 = "#2193b0";
		
		btnThem = new customButton("Th??m Ph??ng",fontBtn,"hinh/button/btn_Them.png" , 
				color3, color4);
		btnXoa = new customButton("X??a Ph??ng",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnSua = new customButton("S???a Ph??ng",fontBtn,"hinh/button/btn_Sua.png" , 
				color3, color4);
		btnXoaTrang = new customButton("X??a Tr???ng",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnIn = new customButton("In Danh S??ch",fontBtn,"hinh/button/btn_In.png" , 
				color3, color4);
		btnTim = new customButton("T??m Ph??ng",fontBtn,"hinh/button/btn_Tim.png" , 
				color3, color4);
		btnTaiTrang = new customButton("T???i D??? Li???u",fontBtn,"hinh/button/btn_TaiTrang.png" , 
				color3, color4);

		if (type.equals("QLP")) {
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


