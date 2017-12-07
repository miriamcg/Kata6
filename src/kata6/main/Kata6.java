package kata6.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.view.HistogramDisplay;
import kata6.view.MailHistogramBuilder;
import kata6.view.MailListBuilder;

public class Kata6 {

    public static void main(String[] args) throws IOException {
        Kata6 kata4 = new Kata6();
        kata4.execute();
    }
    
    private List<String> mailList;
    private HistogramDisplay histoDisplay;
    private Histogram<String> histogram;
    
    public void execute () throws FileNotFoundException, IOException{
      input();
      process();
      output();
    }
     
     private void input() throws FileNotFoundException, IOException{
        String filename = "C:\\Users\\pcbibinf\\Documents\\NetBeansProjects\\Kata4\\src\\emails.txt";
        mailList = MailListBuilder.read(filename);
    }
     
    private void output(){
        histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
    
    private void process(){
        histogram = MailHistogramBuilder.build(mailList); 
    }
}
