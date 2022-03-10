import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;

public class LineChartCreator extends JFrame {


    public LineChartCreator(ResultSet resultSet, String url) throws SQLException, IOException {
        initUI(resultSet, url);
    }

    private void initUI(ResultSet resultSet, String url) throws SQLException, IOException {

        XYDataset dataset = createDataset(resultSet);
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);

        add(chartPanel);

        pack();
        setTitle("Gráfica Temperatura vs Humedad vs Presion");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChartUtils.saveChartAsPNG(new File(url+"/GRAFICA.png"), chart, 450, 400);
    }

    private XYDataset createDataset(ResultSet resultSet) throws SQLException {

        var temp = new XYSeries("Temperature");
        temp.add(resultSet.getLong("ts"),resultSet.getDouble("temp"));

        var hum = new XYSeries("Humedad");
        hum.add(resultSet.getLong("ts"),resultSet.getDouble("humidity"));

        var press = new XYSeries("Presion");
        press.add(resultSet.getLong("ts"),resultSet.getDouble("pressure"));

        var dataset = new XYSeriesCollection();


        while (resultSet.next()) {
            long ts = resultSet.getLong("ts");
            Date date = new Date(ts);
            double temperature= resultSet.getDouble("temp");
            double pressure = resultSet.getDouble("pressure");
            double humidity = resultSet.getDouble("humidity");

            temp.add(date.getTime(), temperature);
            press.add(date.getTime(), pressure);
            hum.add(date.getTime(), humidity);
        }

        dataset.addSeries(temp);
        dataset.addSeries(hum);
        dataset.addSeries(press);

        return dataset;
    }

    private JFreeChart createChart(final XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Comparativa entre Temperatura, Humedad y Presion",
                "Tiempo (EpochMillis)",
                "T(ºc) vs H(%) vs P(hPa)",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        var renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));
        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));
        renderer.setSeriesPaint(2, Color.GREEN);
        renderer.setSeriesStroke(2, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);
        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Comparativa",
                        new Font("Serif", Font.BOLD, 18)
                )
        );
        return chart;
    }
}