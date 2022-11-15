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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import content.customButton;
import dao.LoaiDichVu_DAO;
import dao.NhaCungCap_DAO;
import entity.LoaiDichVu;
import entity.NhaCungCap;

public class formNhapDichVu extends JPanel implements ActionListener {

	public JTextField tfMaDV;
	public JTextField tfTenDV;
	public JTextField tfGiaDV;
	public JTextField tfMoTaDV;
	public customComBoBox comboLoaiDV;
	public customComBoBox comboNCC;
	public customButton btnThem;
	public customButton btnXoa;
	public customButton btnSua;
	public customButton btnIn;
	public customButton btnTim;
	public customButton btnTaiTrang;
	private LoaiDichVu_DAO LoaiDichVu_DAO;
	private NhaCungCap_DAO nhaCungCap_dao;
    public ArrayList<LoaiDichVu> dsLDV;
    public ArrayList<NhaCungCap> dsNCC;
    public customButton btnXoaTrang;
	public JTextField tfAnh;
	public JTextField tfSoLuongTon;
	public JButton btnBrowser;
	private File selectedImageFile;
	public formNhapDichVu (String type) {
	    LoaiDichVu_DAO=new LoaiDichVu_DAO();
	    nhaCungCap_dao=new NhaCungCap_DAO();
		Font fontLable = new Font("Arial", 0, 19);
		Font fontBtn = new Font("Arial", 0 , 17);
		setPreferredSize(new Dimension(300, 300));
		setLayout(getLayout());
		Box boxTotal = Box.createVerticalBox();
		add(boxTotal);
		Box boxText = Box.createHorizontalBox();
		boxTotal.add(Box.createRigidArea(new Dimension(0, 20)));
		boxTotal.add(boxText);
		Box boxBtn = Box.createHorizontalBox();
		boxTotal.add(Box.createRigidArea(new Dimension(0, 25)));
		boxTotal.add(boxBtn);
		Box boxText1 = Box.createVerticalBox();
		Box boxText1_1 = Box.createHorizontalBox();
		Box boxText1_2 = Box.createHorizontalBox();
		Box boxText1_3 = Box.createHorizontalBox();
		Box boxText1_4 = Box.createHorizontalBox();
		Box boxText2 = Box.createVerticalBox();
		Box boxText2_1 = Box.createHorizontalBox();
		Box boxText2_2 = Box.createHorizontalBox();
		Box boxText2_3 = Box.createHorizontalBox();
		Box boxText2_4 = Box.createHorizontalBox();
		boxText.add(boxText1);
		boxText.add(Box.createRigidArea(new Dimension(60, 0)));
		boxText.add(boxText2);
		boxText1.add(boxText1_1);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText1_2);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText1_3);
		boxText1.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText1.add(boxText1_4);
		
		boxText2.add(boxText2_1);
		boxText2.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText2.add(boxText2_2);
		boxText2.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText2.add(boxText2_3);
		boxText2.add(Box.createRigidArea(new Dimension(0, 15)));
		boxText2.add(boxText2_4);

		tfMaDV = new JTextField();
		tfMaDV.setPreferredSize(new Dimension(300, 30));
		tfMaDV.setSize(100, 40);
		tfMaDV.setBackground(null);
		tfMaDV.setOpaque(false);
		tfMaDV.setFont(fontLable);
		tfMaDV.setForeground(Color.white);
		tfMaDV.setBorder(new MatteBorder(0, 0, 3, 0, new Color(175, 188, 196)));
		tfMaDV.setEnabled(false);
        tfMaDV.setText("Hệ Thống Tự Động Thêm");
		JLabel lblMaDV = new JLabel("Mã Dịch Vụ : ");
		lblMaDV.setFont(fontLable);
		lblMaDV.setForeground(Color.white);
		lblMaDV.setPreferredSize(new Dimension(150, 35));
		boxText1_1.add(lblMaDV);
		boxText1_1.add(tfMaDV);

		tfTenDV = new JTextField();
		tfTenDV.setPreferredSize(new Dimension(300, 30));
		tfTenDV.setSize(100, 40);
		tfTenDV.setBackground(null);
		tfTenDV.setOpaque(false);
		tfTenDV.setFont(fontLable);
		tfTenDV.setForeground(Color.white);
		tfTenDV.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblTenDV = new JLabel("Tên Dịch Vụ : ");
		lblTenDV.setFont(fontLable);
		lblTenDV.setForeground(Color.white);
		lblTenDV.setPreferredSize(new Dimension(150, 35));
		boxText1_2.add(lblTenDV);
		boxText1_2.add(tfTenDV);

		tfGiaDV = new JTextField();
		tfGiaDV.setPreferredSize(new Dimension(300, 30));
		tfGiaDV.setSize(100, 40);
		tfGiaDV.setBackground(null);
		tfGiaDV.setOpaque(false);
		tfGiaDV.setFont(fontLable);
		tfGiaDV.setForeground(Color.white);
		tfGiaDV.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblGiaDV = new JLabel("Giá Dịch Vụ : ");
		lblGiaDV.setFont(fontLable);
		lblGiaDV.setForeground(Color.white);
		lblGiaDV.setPreferredSize(new Dimension(150, 35));
		boxText1_3.add(lblGiaDV);
		boxText1_3.add(tfGiaDV);
		
		tfSoLuongTon = new JTextField();
		tfSoLuongTon.setPreferredSize(new Dimension(300, 30));
		tfSoLuongTon.setSize(100, 40);
		tfSoLuongTon.setBackground(null);
		tfSoLuongTon.setOpaque(false);
		tfSoLuongTon.setFont(fontLable);
		tfSoLuongTon.setForeground(Color.white);
		tfSoLuongTon.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblSoLuongTon = new JLabel("Số Lượng Tồn : ");
		lblSoLuongTon.setFont(fontLable);
		lblSoLuongTon.setForeground(Color.white);
		lblSoLuongTon.setPreferredSize(new Dimension(150, 35));
		boxText1_4.add(lblSoLuongTon);
		boxText1_4.add(tfSoLuongTon);
		
		

		tfMoTaDV = new JTextField();
		tfMoTaDV.setPreferredSize(new Dimension(300, 30));
		tfMoTaDV.setSize(100, 40);
		tfMoTaDV.setBackground(null);
		tfMoTaDV.setOpaque(false);
		tfMoTaDV.setFont(fontLable);
		tfMoTaDV.setForeground(Color.white);
		tfMoTaDV.setBorder(new MatteBorder(0, 0, 3, 0, Color.white));
		JLabel lblMoTaDV = new JLabel("Mô Tả Dịch Vụ : ");
		lblMoTaDV.setFont(fontLable);
		lblMoTaDV.setForeground(Color.white);
		lblMoTaDV.setPreferredSize(new Dimension(150, 35));
		boxText2_1.add(lblMoTaDV);
		boxText2_1.add(tfMoTaDV);

		comboLoaiDV = new customComBoBox();
		comboLoaiDV.setFont(fontLable);
		comboLoaiDV.addItem("Không");
		JLabel lblLoaiDV = new JLabel("Loại Dịch Vụ : ");
		lblLoaiDV.setFont(fontLable);
		lblLoaiDV.setForeground(Color.white);
		lblLoaiDV.setPreferredSize(new Dimension(150, 35));
		boxText2_2.add(lblLoaiDV);
		boxText2_2.add(comboLoaiDV);

		comboNCC = new customComBoBox();
		comboNCC.setFont(fontLable);
		comboNCC.addItem("Không");
		JLabel lblNCC = new JLabel("Nhà Cung Cấp : ");
		lblNCC.setFont(fontLable);
		lblNCC.setForeground(Color.white);
		lblNCC.setPreferredSize(new Dimension(150, 35));
		boxText2_3.add(lblNCC);
		boxText2_3.add(comboNCC);
		
		tfAnh = new JTextField();
		tfAnh.setPreferredSize(new Dimension(250, 30));
		tfAnh.setSize(100, 40);
		tfAnh.setBackground(null);
		tfAnh.setOpaque(false);
		tfAnh.setFont(fontLable);
		tfAnh.setForeground(Color.white);
		tfAnh.setBorder(new MatteBorder(0, 0, 3, 0, new Color(175, 188, 196)));
		tfAnh.setEnabled(false);
        tfAnh.setText("Đường Dẫn Của Ảnh");
		JLabel lblAnh = new JLabel("Ảnh : ");
		lblAnh.setFont(fontLable);
		lblAnh.setForeground(Color.white);
		lblAnh.setPreferredSize(new Dimension(150, 35));
		
		btnBrowser = new JButton("Browser");
		btnBrowser.setFont(new Font("", 0, 18));
		btnBrowser.setBackground(Color.white);
		boxText2_4.add(lblAnh);
		boxText2_4.add(tfAnh);
		boxText2_4.add(Box.createRigidArea(new Dimension(10, 0)));
		boxText2_4.add(btnBrowser);


		String color3 = "#6dd5ed", color4 = "#2193b0";
		
		btnThem = new customButton("Thêm Dịch Vụ",fontBtn,"hinh/button/btn_Them.png" , 
				color3, color4);
		btnXoa = new customButton("Xóa Dịch Vụ",fontBtn,"hinh/button/btn_Xoa.png" , 
				color3, color4);
		btnSua = new customButton("Sửa Dịch Vụ",fontBtn,"hinh/button/btn_Sua.png" , 
				color3, color4);
		btnIn = new customButton("In Danh Sách",fontBtn,"hinh/button/btn_In.png" , 
				color3, color4);
		btnTim = new customButton("Tìm Dịch Vụ",fontBtn,"hinh/button/btn_Tim.png" , 
				color3, color4);
		btnTaiTrang = new customButton("Tải Dữ Liệu",fontBtn,"hinh/button/btn_TaiTrang.png" , 
				color3, color4);
		btnXoaTrang = new customButton("Xóa Trắng",fontBtn,"hinh/button/btn_Xoa.png" , 
                color3, color4);
		if (type.equals("QLDV")) {
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
			btnBrowser.setEnabled(false);
			boxBtn.add(btnTim);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
			boxBtn.add(btnTaiTrang);
			boxBtn.add(Box.createRigidArea(new Dimension(20, 0)));
            boxBtn.add(btnXoaTrang);
		}
		LoadDataVaoComBoLoaiDichVu();
		LoadDataVaoComboNCC();
		btnBrowser.addActionListener(this);
		
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
	
	public void LoadDataVaoComBoLoaiDichVu () {
	     dsLDV=LoaiDichVu_DAO.getAllLoaiDichVu();
        for (LoaiDichVu ldv : dsLDV) {
            comboLoaiDV.addItem(ldv.getTenLoaiDichVu());
        }
	}
	public void LoadDataVaoComboNCC () {
	     dsNCC=nhaCungCap_dao.getAllNhaCungCap();
        for (NhaCungCap ncc: dsNCC) {
            comboNCC.addItem(ncc.getTenNhaCungCap());
        }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser browseImageFile = new JFileChooser();
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
       browseImageFile.setPreferredSize(new Dimension(700, 600));
        browseImageFile.addChoosableFileFilter(fnef);
        int showOpenDialogue = browseImageFile.showOpenDialog(null);
         
        if (showOpenDialogue == JFileChooser.APPROVE_OPTION) {
            selectedImageFile = browseImageFile.getSelectedFile();
            String selectedImagePath = selectedImageFile.getAbsolutePath();
            tfAnh.setText(selectedImagePath);
        }
		
	}
}
