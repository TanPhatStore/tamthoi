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
public class formNhapLoaiPhong extends JPanel{
    public customButton btnThem;
	public customButton btnXoa;
	public customButton btnSua;
	public customButton btnIn;
    public JTextField tfMaLP;
    public JTextField tfTenLP;
    public JTextField tfMoTaLP;
	public customButton btnXoaTrang;
    public formNhapLoaiPhong()
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

		tfMaLP = new JTextField();
		tfMaLP.setPreferredSize(new Dimension(300, 30));
		tfMaLP.setSize(100, 40);
		tfMaLP.setBackground(null);
		tfMaLP.setOpaque(false);
		tfMaLP.setFont(fontLable);
		tfMaLP.setForeground(Color.white);
		tfMaLP.setBorder(new MatteBorder(0, 0, 3, 0, new Color(175, 188, 196)));
        tfMaLP.setEnabled(false);
        tfMaLP.setText("H??? Th???ng T??? ?????ng Th??m");
		JLabel lblMaLP = new JLabel("M?? Lo???i Ph??ng : ");
		lblMaLP.setFont(fontLable);
		lblMaLP.setForeground(Color.white);
		lblMaLP.setPreferredSize(new Dimension(150, 35));
		boxText1_1.add(lblMaLP);
		boxText1_1.add(tfMaLP);

		tfTenLP = new JTextField();
		tfTenLP.setPreferredSize(new Dimension(300, 30));
		tfTenLP.setSize(100, 40);
		tfTenLP.setBackground(null);
		tfTenLP.setOpaque(false);
		tfTenLP.setFont(fontLable);
		tfTenLP.setForeground(Color.white);
		tfTenLP.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblTenLP = new JLabel("T??n Lo???i Ph??ng: ");
		lblTenLP.setFont(fontLable);
		lblTenLP.setForeground(Color.white);
		lblTenLP.setPreferredSize(new Dimension(150, 35));
		boxText1_2.add(lblTenLP);
		boxText1_2.add(tfTenLP);

		tfMoTaLP = new JTextField();
		tfMoTaLP.setPreferredSize(new Dimension(300, 30));
		tfMoTaLP.setSize(100, 40);
		tfMoTaLP.setBackground(null);
		tfMoTaLP.setOpaque(false);
		tfMoTaLP.setFont(fontLable);
		tfMoTaLP.setForeground(Color.white);
		tfMoTaLP.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblMoTaLP = new JLabel("M?? T??? : ");
		lblMoTaLP.setFont(fontLable);
		lblMoTaLP.setForeground(Color.white);
		lblMoTaLP.setPreferredSize(new Dimension(150, 35));
		boxText2_1.add(lblMoTaLP);
		boxText2_1.add(tfMoTaLP);

		boxText2_2.add(Box.createRigidArea(new Dimension(0, 35)));


		


		String color3 = "#6dd5ed", color4 = "#2193b0";
		
		btnThem = new customButton("Th??m Lo???i Ph??ng",fontBtn,"hinh/button/btn_Them.png" , 
				color3, color4);
		btnXoa = new customButton("X??a Lo???i Ph??ng",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnSua = new customButton("S???a Lo???i Ph??ng",fontBtn,"hinh/button/btn_Sua.png" , 
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
