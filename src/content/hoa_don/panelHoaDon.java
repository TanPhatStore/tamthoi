package content.hoa_don;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

import com.raven.datechooser.DateChooser;
import com.raven.datechooser.SelectedDate;
import com.raven.datechooser.panelDate;

import Function.functionNecessary;
import content.customButton;
import content.table;
import dao.DichVu_Dao;
import entity.DichVu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Time;
import java.util.ArrayList;
public class panelHoaDon extends JPanel implements ActionListener, MouseListener{
    public titleHoaDon title;

    public table table1;
    public buttonTotal btnInHoaDon;
    public buttonTotal btnLapHoaDon;
    public buttonTotal btnChuyenBan;
    private buttonTotal btnTinhTien;
    public Box box;
    private buttonTotal btnXoa;
    public int tong;
    public int tongtam;
    public int soLan = 0;
    public JPanel boxButton1;
    private String type;
    public String name;

    private listDichVu listDichVu;

    private functionNecessary d;

    public content.hoa_don.listDichVu listDichVuMini;

    public JScrollPane js2;

	public listKhachHang listKhachhangMini;

	public JScrollPane js3;

	public buttonTotal btnTroVe;
	private String giaPhong;
	public listPhong listPhong;
	public String type1;
	public int thanhTien = 0;
	public buttonTotal btnDatPhong;

	public Timer t;

	private DichVu_Dao dichVu_dao;

	private ArrayList<DichVu> dvDV;
    public titleHoaDon getTitle() {
        return title;
    }

    public void setTitle(titleHoaDon title) {
        this.title = title;
    }
    public buttonTotal getBtnXoa() {
        return btnXoa;
    }

    public void setBtnXoa(buttonTotal btnXoa) {
        this.btnXoa = btnXoa;
    }

    public buttonTotal getBtnInHoaDon() {
        return btnInHoaDon;
    }

    public void setBtnInHoaDon(buttonTotal btnInHoaDon) {
        this.btnInHoaDon = btnInHoaDon;
    }

    public buttonTotal getBtnLapHoaDon() {
        return btnLapHoaDon;
    }

    public void setBtnLapHoaDon(buttonTotal btnLapHoaDon) {
        this.btnLapHoaDon = btnLapHoaDon;
    }

    public buttonTotal getBtnChuyenBan() {
        return btnChuyenBan;
    }

    public void setBtnChuyenBan(buttonTotal btnChuyenBan) {
        this.btnChuyenBan = btnChuyenBan;
    }

    public buttonTotal getBtnTinhTien() {
        return btnTinhTien;
    }

    public void setBtnTinhTien(buttonTotal btnTinhTien) {
        this.btnTinhTien = btnTinhTien;
    }

    public panelHoaDon (String name, String type,String giaPhong, listPhong listPhong) {
        this.type = type;
        this.name = name;
        this.listPhong = listPhong;
        this.giaPhong = giaPhong;
        listDichVuMini = new listDichVu();
        js2 =new JScrollPane(listDichVuMini, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        js2.setBorder(BorderFactory.createEmptyBorder());
        js2.getVerticalScrollBar().setUnitIncrement(6);
        js2.setBackground(Color.white);
        
        d = new functionNecessary(); 
        Font fontBtn = new Font("Arial", 0 , 17);
        String color3 = "#6dd5ed", color4 = "#2193b0";
        setPreferredSize(new Dimension(650, 750));
        setBackground(Color.white);
         
        setTitle();
        
        
        title.setPreferredSize(new Dimension(630, 120));
        box  = Box.createHorizontalBox();
        box.add(title);
        add(box);
        add(Box.createRigidArea(new Dimension(0, 20)));

        String[] header = {"#", "T??n D???ch V???", "S??? L?????ng", "Gi?? B??n", "Th??nh Ti???n"} ;
		table1 = new table(header);
        
		table1.setPreferredSize(new Dimension(630, 570));
		add(table1);
        add(Box.createRigidArea(new Dimension(0, 20)));

        boxButton1 = new JPanel();
        boxButton1.setBackground(null);
        add (boxButton1);

        btnLapHoaDon = new buttonTotal(" L???p H??a ????n", "hinh/button/btn_LapHoaDon.png");
        btnInHoaDon = new buttonTotal(" In H??a ????n", "hinh/button/btn_TinhTien.png");


        btnChuyenBan = new buttonTotal(" Chuy???n Ph??ng", "hinh/button/btn_ChuyenBan.png");
        btnTroVe = new buttonTotal(" Tr??? V???", "hinh/button/btn_TroVe.png");
        btnXoa = new buttonTotal(" X??a D???ch V???", "hinh/button/btn_Xoa.png");
        btnDatPhong = new buttonTotal(" ?????t Ph??ng", "hinh/button/btn_InHoaDon.png");
         
        btnXoa.setColor1("#EECDA3");
        btnXoa.setColor2("#EF629F");
        

      
        btnXoa.addActionListener(this);
        btnLapHoaDon.addActionListener(this);
        functionNecessary d = new functionNecessary();
        t = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thanhTien += d.moneyPerSecond(Integer.parseInt(giaPhong));
                table1.table.getModel().setValueAt(d.formatMoney(thanhTien), 0, 4);
            }
        });
        
        if (title.btnBamGio.getActionListeners().length == 1) {
        	title.btnBamGio.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (btnLapHoaDon.getLblname().getText() != " L???p H??a ????n") {
						String ten = "";
						if (type.equals("Ph??ng Th?????ng")) {
							ten  = "Gi??? H??t ( Th?????ng )";
						} else if (type.equals("Ph??ng VIP")) {
							ten  = "Gi??? H??t ( VIP )";
						}
						
						if (title.btnBamGio.getText().equals("T??nh Gi???")) {
							if (table1.getRowCount() > 0) {
								if (table1.table.getModel().getValueAt(0, 2) != "0") {
									table1.insertRow(0, new Object[] {table1.getRowCount() + 1, ten, "0", d.formatMoney(Integer.parseInt(giaPhong)), d.formatMoney(thanhTien)});	
								}
							} else {
								table1.insertRow(0, new Object[] {table1.getRowCount() + 1, ten, "0", d.formatMoney(Integer.parseInt(giaPhong)), d.formatMoney(thanhTien)});	
							}

							t.start();
						} else {
							t.stop();
						}
						
						reSetSTT();
					}
					
				}
			});
        }
    }
    public void setTitle () {
    	if (type.equals("Ph??ng Th?????ng")) {
            title = new titleHoaDon(name + " - Ph??ng Th?????ng", "---", tong, giaPhong);
        } else if (type.equals("Ph??ng VIP")) {
            title = new titleHoaDon(name + " - Ph??ng VIP", "---", tong, giaPhong);
        } else {
            title = new titleHoaDon("Ph??ng : Tr???ng", "---", tong, giaPhong);
        }
    }
    public void setButton () {
    	if (type1.equals("hoadon")) {
    		boxButton1.removeAll();
        	boxButton1.add(btnLapHoaDon);
            boxButton1.add(btnInHoaDon);
            boxButton1.add(btnDatPhong);
            boxButton1.add(btnChuyenBan);
            boxButton1.add(btnXoa);
        } else {
        	boxButton1.removeAll();
        	boxButton1.add(btnLapHoaDon);
            boxButton1.add(btnInHoaDon);
            boxButton1.add(btnDatPhong);
            boxButton1.add(btnTroVe);
            boxButton1.add(btnXoa);
        }
    }
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Object obj = arg0.getSource();
        if (obj.equals(getBtnXoa())) {
        	int zz ;
        	if (title.lblTime.getText().equals("00 : 00 : 00")) {
        		zz = 0;
        	} else {
        		zz = 1;
        	}
        	
            if (table1.getSelectedRow() >= zz) {
                String name = (String) table1.table.getModel().getValueAt(table1.getSelectedRow(),1);
                int soLuong = (int) table1.table.getModel().getValueAt(table1.getSelectedRow(),2);
                table1.removeRow(table1.getSelectedRow());
                for (buttonListDichVu x : listDichVuMini.listDichVu) {
                    if (x.getName().equals(name)) {
                        x.setAmount(0);
                        tong = title.priceTotal;
                        tong -= soLuong * Integer.parseInt(x.getPrice());
                        title.totalMoney.setText("T???ng C???ng : " + d.formatMoney(tong));
                        title.priceTotal = tong;
                        
                        dichVu_dao = new DichVu_Dao();
						dvDV=dichVu_dao.getAllDichVu();
				        for (DichVu dv : dvDV) {
				        	 if (dv.getTenDichVu().equals(name)) {
				        		 dv.setSoLuongTon(dv.getSoLuongTon() + soLuong);
				        		 if(dichVu_dao.update(dv)) {
						    			for (buttonListPhong z : listPhong.listPhong) {
									    	for (buttonListDichVu t : z.panelHoaDon.listDichVuMini.listDichVu) {
									    		if (dv.getTenDichVu().equals(t.name)) {
									    			t.amountTon = dv.getSoLuongTon();
									    			t.Amount.setText("C??n : " + t.amountTon);
									    			reSetSTT();
									    		}
									    	}
									    }
					        		}
				        	 }
				        }
                    }
                }
    
            } else {
                JOptionPane.showMessageDialog(null, "B???n Ch??a Ch???n D??ng D??? Li???u ????? X??a");
            }
        } 
        if (obj.equals(getBtnLapHoaDon())) {
        	if (title.customer.getText().equals("Kh??ch H??ng : ---") || title.customer.getText().equals("S??? ??i???n Tho???i Kh??ch H??ng : ")) {
        		JOptionPane.showMessageDialog(null, "Vui L??ng Ch???n Kh??ch H??ng S??? D???ng");
        	}
        	else {
        		if (btnLapHoaDon.getLblname().getText().equals(" L???p H??a ????n")) {
                    if (type != "R???ng") {
                        title.infoTime.setText("Gi??? H??t : " + d.getCurrentTime());
                        title.time = d.getCurrentTime();
                        btnLapHoaDon.getLblname().setText(" L??u H??a ????n");
                        btnLapHoaDon.setColor1("#EECDA3");
                        btnLapHoaDon.setColor2("#EF629F");
                        repaint();
                        listPhong.UpdatePhongDangSuDung();
                        JOptionPane.showMessageDialog(null, "L???p H??a ????n Th??nh C??ng !!!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Ch???n Ph??ng Tr?????c Khi L???p H??a ????n !!!");
                    }
                } else if (btnLapHoaDon.getLblname().getText().equals(" L??u H??a ????n")) {
                    // btnLapHoaDon.getLblname().setText(" L???p H??a ????n");
                    JOptionPane.showMessageDialog(null, "L??u H??a ????n Th??nh C??ng !!!!");
        	} 		
       }}
        
    }
    public void setTenPhong () {
    	if (type.equals("Ph??ng Th?????ng")) {
    		title.infoPhong.setText(name + " - Ph??ng Th?????ng");
        } else if (type.equals("Ph??ng VIP")) {
        	title.infoPhong.setText(name + " - Ph??ng VIP");
        }
    }
	public void reSetSTT () {
		for (int i =0; i < table1.getRowCount(); i++) {
			table1.table.getModel().setValueAt(i+1, i, 0);
		}
	}

    @Override
    public void mouseClicked(MouseEvent arg0) {
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
