package content.DichVu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import content.customButton;
import content.table;
import content.form.formNhapNhaCungCap;
import dao.NhaCungCap_DAO;
import entity.NhaCungCap;

public class trangNCC implements ActionListener, MouseListener {
	private table pane;
	private customButton btnThem;
	private customButton btnXoa;
	private customButton btnSua;
	private customButton btnIn;
	private JFrame frame;
	private formNhapNhaCungCap panel;
    private NhaCungCap_DAO nhaCungCap_dao;
    private ArrayList<NhaCungCap> dsNCC;

	public void RenderUINhaCungCap (Box totalBox, Font fontBtn) {

		panel = new formNhapNhaCungCap();
		totalBox.add(panel);

		totalBox.add(Box.createRigidArea(new Dimension(0, 20)));
		// add table
		String[] header = {"Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Địa Chỉ", "Số Điện Thoại"} ;
		pane = new table(header);
		totalBox.add(pane);
		// pane.table.getModel()
		nhaCungCap_dao=new NhaCungCap_DAO();
		docDuLieuNhaCungCap();
		
		
		// add List Button
		Box boxBtn = Box.createHorizontalBox();
		totalBox.add(Box.createRigidArea(new Dimension(0, 30)));
		totalBox.add(boxBtn);
		
		panel.btnThem.addMouseListener(this);
		panel.btnXoa.addMouseListener(this);
		panel.btnSua.addMouseListener(this);
		panel.btnIn.addMouseListener(this);
		pane.table.addMouseListener(this);
		panel.btnXoaTrang.addMouseListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if (obj.equals(panel.btnThem)) {
		    String maNcc=panel.tfMaNCC.getText();
            String tenNcc=panel.tfTenNCC.getText();
            String diaChi=panel.tfDiaChiNCC.getText();
            String sdt=panel.tfSDTNCC.getText();
            NhaCungCap ncc=new NhaCungCap(maNcc, tenNcc, diaChi, sdt);
            if(nhaCungCap_dao.create(ncc, dsNCC.size() + 1)) {
                pane.removeAll();
                docDuLieuNhaCungCap();
                dsNCC=nhaCungCap_dao.getAllNhaCungCap();
                XoaTrang();
            }
		}
		if (obj.equals(panel.btnSua)) {
			LuuDuLieuSua();
			XoaTrang();
		}
		if (obj.equals(panel.btnXoa)) {
			if (pane.getSelectedRow() >= 0) {
			    int r=pane.getSelectedRow();
	            String ma=pane.table.getValueAt(r, 0).toString();
	            NhaCungCap ncc=new NhaCungCap(ma);
	            nhaCungCap_dao.delete(ncc);
	            pane.removeRow(r);
	            dsNCC=nhaCungCap_dao.getAllNhaCungCap();
	            XoaTrang();
			} else {
				JOptionPane.showMessageDialog(null, "Bạn Chưa Chọn Dòng Dữ Liệu Để Xóa");
			}
		}
		if (obj.equals(pane.table)) {
			SuaDuLieu();
		}
		if (obj.equals(panel.btnXoaTrang)) {
            XoaTrang();

        }
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
	public void SuaDuLieu() {
		panel.tfMaNCC.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 0));
		panel.tfTenNCC.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 1));
		panel.tfDiaChiNCC.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 2));
		panel.tfSDTNCC.setText((String) pane.table.getModel().getValueAt(pane.getSelectedRow(), 3));
	}
	public void LuuDuLieuSua () {
	    int row=pane.getSelectedRow();
        String maNcc=panel.tfMaNCC.getText();
        String tenNcc=panel.tfTenNCC.getText();
        String diaChi=panel.tfDiaChiNCC.getText();
        String sdt=panel.tfSDTNCC.getText();
        NhaCungCap ncc=new NhaCungCap(maNcc, tenNcc, diaChi, sdt);
        if(nhaCungCap_dao.update(ncc)) {
            pane.removeAll();
            docDuLieuNhaCungCap();
        }
	}
	public void XoaTrang () {
		panel.tfMaNCC.setText("Hệ Thống Tự Động Thêm");
		panel.tfTenNCC.setText("");
		panel.tfDiaChiNCC.setText("");
		panel.tfSDTNCC.setText("");
	}
	public void docDuLieuNhaCungCap() {
	    dsNCC=nhaCungCap_dao.getAllNhaCungCap();
	        for (NhaCungCap ncc: dsNCC) {
	            pane.addRow(new Object[] {ncc.getMaNhaCungCap(),ncc.getTenNhaCungCap(),ncc.getDiaChi(),ncc.getSoDienThoai()});
            }
	    }
}
