package chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;

public class LineChart extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LineChart(XYDataset dts) {

        initUI(dts);
    }

    private void initUI(XYDataset dataset) {
        JFreeChart chart = createChart(dataset);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel);

        pack();
        setTitle("Line chart");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    

    private JFreeChart createChart(XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Function",
                "X",
                "Y",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesPaint(0, Color.GREEN);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f, 0, 0, 10.0f, null, 0.0f));
        
        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);
        
        plot.setDomainZeroBaselineVisible(true);
        plot.setRangeZeroBaselineVisible(true);
        
        
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setDomainGridlinesVisible(true);
        plot.setDomainGridlinePaint(Color.BLACK);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Function",
                        new Font("Serif", java.awt.Font.BOLD, 18)
                )
        );

        return chart;
    }

    
    }