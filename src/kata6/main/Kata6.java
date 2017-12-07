package kata6.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.FileMailListReader;

public class Kata6 {

    public static void main(String[] args) throws IOException {
        Kata6 kata6 = new Kata6();
        kata6.execute();
    }
    
    private List<Mail> mailList;
    private HistogramDisplay histoDisplay;
    private HistogramDisplay histoDisplay2;
    private HistogramBuilder<Mail> builder;
    private Histogram<String> domains;
    private Histogram<Character> letters;
    
    public void execute () throws FileNotFoundException, IOException{
      input();
      process();
      output();
    }
     
     private void input() throws FileNotFoundException, IOException{
        String filename = "C:\\Users\\pcbibinf\\Documents\\NetBeansProjects\\Kata4\\src\\emails.txt";
        mailList = FileMailListReader.read(filename);
    }
     
    private void output(){
         histoDisplay = new HistogramDisplay(domains, "Dominios");
         histoDisplay.execute();
         histoDisplay2 = new HistogramDisplay(letters, "Primer Caracter");
         histoDisplay2.execute();
    }
    
    private void process(){
        builder = new HistogramBuilder<>(mailList);
        domains = builder.build(new Attribute<Mail, String>(){
                @Override
                public String get(Mail item){
                    return item.getMail().split("@")[1];
                }
        });
        
        letters = builder.build(new Attribute<Mail, Character>(){
                @Override
                public Character get(Mail item){
                    return item.getMail().charAt(0);
                }
        });
    }
}
