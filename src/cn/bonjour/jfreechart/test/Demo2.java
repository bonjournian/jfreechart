package cn.bonjour.jfreechart.test;

import java.awt.Font;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

@SuppressWarnings("serial")
public class Demo2 extends ApplicationFrame {

	private static StandardChartTheme chartTheme;
	static {
		chartTheme = new StandardChartTheme("bonjour");
		// 图标标题
		chartTheme.setExtraLargeFont(new Font("华文行楷", Font.PLAIN, 20));
		// 子标题、坐标轴
		chartTheme.setLargeFont(new Font("楷体", Font.ITALIC, 16));
		// 图例、坐标轴
		chartTheme.setRegularFont(new Font("隶书", Font.BOLD, 14));
		ChartFactory.setChartTheme(chartTheme);
	}
	public Demo2(String title) {
		super(title);
		this.setContentPane(createPanel()); // 构造函数中自动创建Java的panel面板
	}

	public static CategoryDataset createDataset() // 创建柱状图数据集
	{
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// （1）柱高 （2）图例说明文字 （3）列名
		dataset.setValue(10, "壹", "管理人员");
		dataset.setValue(20, "贰", "市场人员");
		dataset.setValue(40, "叁", "开发人员");
		dataset.setValue(15, "肆", "其他人员");
		return dataset;
	}

	public static JFreeChart createChart(CategoryDataset dataset) // 用数据集创建一个图表
	{
		//指定了标题、横坐标、纵坐标、数据集、柱状图方向、图例、
		JFreeChart chart = ChartFactory.createBarChart("hi", "人员分布", "人员数量", dataset, PlotOrientation.VERTICAL, true,
				false, false); // 创建一个JFreeChart
		chart.setTitle("某公司组织结构图");// 可以重新设置标题，替换“hi”标题
		CategoryPlot plot = (CategoryPlot) chart.getPlot();// 获得图标中间部分，即plot
		CategoryAxis categoryAxis = plot.getDomainAxis();// 获得横坐标
		// chart包括三部分：title、plot、legend
		//categoryAxis.setLabelFont(new Font("微软雅黑", Font.BOLD, 12));// 设置横坐标字体
		return chart;
	}

	public static JPanel createPanel() {
		JFreeChart chart = createChart(createDataset());
		return new ChartPanel(chart); // 将chart对象放入Panel面板中去，ChartPanel类已继承Jpanel
	}

	public static void main(String[] args) {
		Demo2 chart = new Demo2("某公司组织结构图");
		chart.pack();// 以合适的大小显示
		chart.setVisible(true);

	}
}