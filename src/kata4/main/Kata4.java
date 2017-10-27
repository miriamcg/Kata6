package kata4.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListBuilder;

public class Kata4 {

    public static void main(String[] args) throws IOException {
        Kata4 kata4 = new Kata4();
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
        String filename = "C:\\Users\\usuario\\Documents\\Kata3-master\\Kata3-master\\src\\kata4\\emails.txt";
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
