package cn.bonjour.jfreechart.test;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.junit.Test;

public class Demo1 {
	public static StandardChartTheme chartTheme;
	static {
		chartTheme = new StandardChartTheme("CN");
		// 设置标题字体
		chartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20));
		// 设置图例的字体
		chartTheme.setRegularFont(new Font("宋书", Font.PLAIN, 15));
		// 设置轴向的字体
		chartTheme.setLargeFont(new Font("宋书", Font.PLAIN, 15));
		// 应用主题样式
		ChartFactory.setChartTheme(chartTheme);
	}

	public static void main(String[] args) {
		drawPie();
	}

	public static void drawPie() {

		DefaultPieDataset dpd = new DefaultPieDataset(); // 饼形数据集
		//（1）图例说明   （2）所占比重
		dpd.setValue("管理人员", 25); // 输入数据
		dpd.setValue("市场人员", 25);
		dpd.setValue("开发人员", 45);
		dpd.setValue("其他人员", 10);
		// 可以查具体的API文档,第一个参数是标题，第二个参数是一个数据集，第三个参数表示是否显示Legend(图例)，第四个参数表示是否显示提示，第五个参数表示图中是否存在URL
		JFreeChart chart = ChartFactory.createPieChart("饼形图", dpd, true, true, false);

		// chart要放在Java容器组件中，ChartFrame继承自java的Jframe类。该第一个参数窗口标题，不是数据集的标题。
		ChartFrame chartFrame = new ChartFrame("某公司人员组织数据图", chart);
		chartFrame.pack(); // 以合适的大小展现图形
		chartFrame.setVisible(true);// 图形是否可见

	}

	@Test
	public static void drawCategory() {
		DefaultCategoryDataset dcd = new DefaultCategoryDataset();

	}
}
