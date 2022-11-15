package content.DatPhong;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;

import content.form.customComBoBox;

public class titleDatPhong extends JPanel {
    
 
	public JTextField tfMaKH;
	public JTextField tfTenKH;
	public JTextField tfSDT;
	public JTextField tfDiaChi;
	public customComBoBox comboGioDat;
	public customComBoBox comboPhongDat;
	private String ma;
	private String diaChi;
	private String time;
	private String phong;
	public String name;
	private String sdt;
	public Object title;
    
    public titleDatPhong (String ma, String name, String diaChi,String sdt, String time,String phong) {
    	this.ma = ma;
        this.name = name;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.time = time;
        this.phong = phong;
    	

        Font fontLable = new Font("Arial", 0, 19);
		Font fontBtn = new Font("Arial", 0 , 17);
        setPreferredSize(new Dimension(650, 320));
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
		Box boxText2_1 = Box.createHorizontalBox();
		Box boxText2_2 = Box.createHorizontalBox();
		Box boxText2_3 = Box.createHorizontalBox();
		boxText.add(boxText1);
		boxText.add(Box.createRigidArea(new Dimension(60, 0)));
		
		boxText1.add(boxText1_1);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText1_2);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText1_3);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText2_1);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText2_2);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText2_3);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));

		tfMaKH = new JTextField();
		tfMaKH.setPreferredSize(new Dimension(300, 30));
		tfMaKH.setSize(100, 40);
		tfMaKH.setBackground(null);
		tfMaKH.setOpaque(false);
		tfMaKH.setFont(fontLable);
		tfMaKH.setForeground(Color.white);
		tfMaKH.setText(ma);
		tfMaKH.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblMaKH = new JLabel("Mã Khách Hàng : ");
		lblMaKH.setFont(fontLable);
		lblMaKH.setForeground(Color.white);
		lblMaKH.setPreferredSize(new Dimension(155, 30));
		boxText1_1.add(lblMaKH);
		boxText1_1.add(tfMaKH);
       
		tfTenKH = new JTextField();
		tfTenKH.setPreferredSize(new Dimension(300, 30));
		tfTenKH.setSize(100, 40);
		tfTenKH.setBackground(null);
		tfTenKH.setOpaque(false);
		tfTenKH.setFont(fontLable);
		tfTenKH.setForeground(Color.white);
		tfTenKH.setText(name);
		tfTenKH.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblTenKH = new JLabel("Tên Khách Hàng: ");
		lblTenKH.setFont(fontLable);
		lblTenKH.setForeground(Color.white);
		lblTenKH.setPreferredSize(new Dimension(155, 30));
		boxText1_2.add(lblTenKH);
		boxText1_2.add(tfTenKH);

		tfSDT = new JTextField();
		tfSDT.setPreferredSize(new Dimension(300, 30));
		tfSDT.setSize(100, 40);
		tfSDT.setBackground(null);
		tfSDT.setOpaque(false);
		tfSDT.setFont(fontLable);
		tfSDT.setText(sdt);
		tfSDT.setForeground(Color.white);
		tfSDT.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblSDT = new JLabel("Số Điện Thoại    : ");
		lblSDT.setFont(fontLable);
		lblSDT.setForeground(Color.white);
		lblSDT.setPreferredSize(new Dimension(155, 30));
		boxText1_3.add(lblSDT);
		boxText1_3.add(tfSDT);
		
		tfDiaChi = new JTextField();
		tfDiaChi.setPreferredSize(new Dimension(300, 30));
		tfDiaChi.setSize(100, 40);
		tfDiaChi.setBackground(null);
		tfDiaChi.setOpaque(false);
		tfDiaChi.setFont(fontLable);
		tfDiaChi.setText(diaChi);
		tfDiaChi.setForeground(Color.white);
		tfDiaChi.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblDiaChi = new JLabel("Địa Chỉ                : ");
		lblDiaChi.setFont(fontLable);
		lblDiaChi.setForeground(Color.white);
		lblDiaChi.setPreferredSize(new Dimension(155, 30));
		boxText2_1.add(lblDiaChi);
		boxText2_1.add(tfDiaChi);
		
		comboGioDat = new customComBoBox();
		comboGioDat.setFont(fontLable);
		comboGioDat.addItem("Khong");
		JLabel lblGioDat = new JLabel("Giờ Đặt               : ");
		lblGioDat.setFont(fontLable);
		comboGioDat.setSelectedItem(time);
		lblGioDat.setForeground(Color.white);
		lblGioDat.setPreferredSize(new Dimension(170, 30));
		boxText2_2.add(lblGioDat);
		boxText2_2.add(comboGioDat);

		comboPhongDat = new customComBoBox();
		comboPhongDat.setFont(fontLable);
		comboPhongDat.addItem("Khong");
		JLabel lblPhongDat = new JLabel("Phòng Đặt          : ");
		lblPhongDat.setFont(fontLable);
		lblPhongDat.setForeground(Color.white);
		comboGioDat.setSelectedItem(phong);
		lblPhongDat.setPreferredSize(new Dimension(170, 30));
		boxText2_3.add(lblPhongDat);
		boxText2_3.add(comboPhongDat);

       



    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#12c2e9"), w, h, Color.decode("#c471ed"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,15,15);
    }
}
