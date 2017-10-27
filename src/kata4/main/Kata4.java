package kata4.main;

import java.io.IOException;
import java.util.List;
import kata4.model.Histogram;
import kata4.view.HistogramDisplay;
import kata4.view.MailHistogramBuilder;
import kata4.view.MailListBuilder;

public class Kata4 {

    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\usuario\\Documents\\Kata3-master\\Kata3-master\\src\\kata4\\emails.txt";
        List<String> mailList = MailListBuilder.read(filename);
        Histogram<String> histogram = MailHistogramBuilder.build(mailList);
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
