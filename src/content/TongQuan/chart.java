package content.TongQuan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import swing.BarChart;
import swing.ModelChart;

 
public class chart extends BarChart {
	public chart () { 
		setPreferredSize(new Dimension(0, 500));
		setTitle("\nThống Kê Tổng Quan");
		setTitleFont(new Font("", Font.BOLD, 20));
		setTitleColor(Color.black);
		addLegend("Đơn Hàng", Color.decode("#f5af19"), Color.decode("#f12711"));
		addLegend("Doanh Thu", Color.decode("#a044ff"), Color.decode("#6a3093"));
		addLegend("Đóng Góp Ý Kiến   ", Color.decode("#FFF94C"), Color.decode("#FFF94C"));
		
		
		addData(new ModelChart("Tháng 1", new double[]{500, 200, 400}));
		addData(new ModelChart("Tháng 2", new double[]{600, 750,400}));
		addData(new ModelChart("Tháng 3", new double[]{600, 750,400}));
		addData(new ModelChart("Tháng 4", new double[]{600, 750,400}));
		addData(new ModelChart("Tháng 5", new double[]{600, 750,400}));
		addData(new ModelChart("Tháng 6", new double[]{600, 750,400}));
		addData(new ModelChart("Tháng 7", new double[]{600, 750,400}));
		addData(new ModelChart("Tháng 8", new double[]{600, 750,400}));
		addData(new ModelChart("Tháng 9", new double[]{600, 750,400}));
		addData(new ModelChart("Tháng 10", new double[]{600, 750,400}));
		addData(new ModelChart("Tháng 11", new double[]{600, 750,400}));
		addData(new ModelChart("Tháng 12", new double[]{600, 750,400}));
		start(); 
	}
	@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth(), h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#74ebd5"), w, h, Color.decode("#ACB6E5"));
        g2d.setPaint(gp);
        g2d.fillRoundRect(0, 0, w, h,15,15);
    }
}
