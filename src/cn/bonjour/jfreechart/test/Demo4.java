package cn.bonjour.jfreechart.test;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.imageio.ImageIO;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

public class Demo4 {
	/**
	 * 封装主题
	 */
	private static StandardChartTheme chartTheme;
	static {
		chartTheme = new StandardChartTheme("cn");
		// 图标标题
		chartTheme.setExtraLargeFont(new Font("华文行楷", Font.PLAIN, 20));
		// 子标题、坐标轴
		chartTheme.setLargeFont(new Font("楷体", Font.ITALIC, 16));
		// 图例、坐标轴
		chartTheme.setRegularFont(new Font("隶书", Font.BOLD, 14));
		ChartFactory.setChartTheme(chartTheme);
	}

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put(null, null);
		map.put(null, null);
		Set<Entry<String, String>> entrySet = map.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		while (iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			System.out.println(next.getKey() + next.getValue());
		}
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.setValue(10, "壹", "博士");
		dataset.setValue(20, "贰", "硕士");
		dataset.setValue(30, "叁", "学士");
		dataset.setValue(50, "肆", "其他");
		JFreeChart barChart3D = ChartFactory.createBarChart3D("学历统计", "水平", "人数", dataset);
		TextTitle title = barChart3D.getTitle();
		title.setText("2016年全民学历水平统计");
		Plot plot = barChart3D.getPlot();
		try {
			plot.setBackgroundImage(ImageIO.read(new File("img/bg.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		JFreeChart lineChart = ChartFactory.createLineChart("学历统计", "aa", "bb", dataset);
		try {
			lineChart.getPlot().setBackgroundImage(ImageIO.read(new File("img/bg.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		ChartFrame frame = new ChartFrame("First", barChart3D);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(new File("img/" + System.currentTimeMillis() + ".png"));
			ChartUtilities.writeChartAsPNG(out, barChart3D, 1024, 1024);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		frame.pack();
		frame.setLocation(300, 300);
		frame.setVisible(true);
	}
}
