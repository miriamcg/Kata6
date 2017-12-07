package kata6.view;

import java.awt.Dimension;
import javax.swing.JPanel;
import kata6.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay <T> extends ApplicationFrame{

    private final Histogram<T> histo;
    private final String nameEjeX;
    
    public HistogramDisplay(Histogram<T> histo, String nameEjeX) {
        super("Histograma");
        this.histo = histo;
        this.nameEjeX = nameEjeX;
        setContentPane(createPanel());
        pack();
    }
    
    public void execute(){
        setVisible(true);
    }

    private ChartPanel createPanel() {
        ChartPanel cp = new ChartPanel (createChart(createDataset()));
        setPreferredSize(new Dimension(500,400));
        return cp;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart3D("Histograma JFreeChart", nameEjeX, "Nº de emails", dataSet, PlotOrientation.VERTICAL, false, true, true);
        return chart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (T key : histo.keySet()) {
            dataSet.addValue(histo.getMap(key),"", (Comparable)key);
        }
        return dataSet;
    }
}
