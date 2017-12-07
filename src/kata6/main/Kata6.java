package kata6.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import kata6.model.Histogram;
import kata6.model.Mail;
import kata6.model.Person;
import kata6.view.DataBaseList;
import kata6.view.HistogramDisplay;
import kata6.view.HistogramBuilder;
import kata6.view.FileMailListReader;

public class Kata6 {

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        Kata6 kata6 = new Kata6();
        kata6.execute();
    }
    
    private List<Mail> mailList;
    private List<Person> people;
    private HistogramDisplay histoDisplay;
    private HistogramDisplay histoDisplay2;
    private HistogramDisplay histoDisplayPersonG;
    private HistogramDisplay histoDisplayPersonW;
    private HistogramBuilder<Mail> builder;
    private HistogramBuilder<Person> builderPerson;
    private Histogram<String> domains;
    private Histogram<Character> letters;
    private Histogram<Character> gender;
    private Histogram<Float> weight;
    
    public void execute () throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
      input();
      process();
      output();
    }
     
     private void input() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException{
        String filename = "C:\\Users\\pcbibinf\\Documents\\NetBeansProjects\\Kata4\\src\\emails.txt";
        mailList = FileMailListReader.read(filename);
        people = DataBaseList.read();
    }
     
    private void output(){
         histoDisplay = new HistogramDisplay(domains, "Dominios");
         histoDisplay.execute();
         histoDisplay2 = new HistogramDisplay(letters, "Primer Caracter");
         histoDisplay2.execute();
         histoDisplayPersonG = new HistogramDisplay(gender, "Gender");
         histoDisplayPersonG.execute();
         histoDisplayPersonW = new HistogramDisplay(weight, "Weight");
         histoDisplayPersonW.execute();
    }
    
    private void process(){
        builder = new HistogramBuilder<>(mailList);
        builderPerson = new HistogramBuilder<>(people);
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
        
        gender = builderPerson.build(new Attribute<Person, Character>(){
                @Override
                public Character get(Person item){
                    return item.getGender();
                }
        });
        
        weight = builderPerson.build(new Attribute<Person, Float>(){
                @Override
                public Float get(Person item){
                    return item.getWeight();
                }
        });
        
        
    }
}
