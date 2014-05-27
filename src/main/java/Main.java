import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import com.gumtreeuk.addressbook.domain.Person;
import com.gumtreeuk.addressbook.processor.GenderCounterPersonProcessor;
import com.gumtreeuk.addressbook.processor.GenderCounterPersonProcessor.Gender;
import com.gumtreeuk.addressbook.processor.OldestPersonProcessor;
import com.gumtreeuk.addressbook.processor.PersonOlderThenPersonProcessor;
import com.gumtreeuk.addressbook.reader.AddressBookReader;

public class Main
{
  public static void main(String[] args) throws Exception {

    Properties props =  new Properties();
    
    AddressBookReader addressReader; 
    
    String bookPath;
    
    try {
     
      InputStream input = Main.class.getClassLoader().getResourceAsStream("/resources/project.properties");

      props.load(new FileInputStream("src/main/resources/project.properties"));
      
      bookPath = props.getProperty("address.book.file.location");
      
      if ( args.length>0 && args[0]!=null) 
        bookPath = args[0];
      
      addressReader  = new AddressBookReader(bookPath);
    
      List<Person> persons = addressReader.getPersons();
    
      GenderCounterPersonProcessor gcp =  new GenderCounterPersonProcessor();
      System.out.println("How many males are in the address book?");
      System.out.println(gcp.getResult(persons, Gender.MALE));
      
      OldestPersonProcessor opp = new OldestPersonProcessor();
      System.out.println("Who is the oldest person in the address book?");
      System.out.println(opp.getOldest(persons).getName());
      
      PersonOlderThenPersonProcessor potpp = new PersonOlderThenPersonProcessor();
      System.out.println("How many days older is Bill than Paul?");
      System.out.println(potpp.getResults(persons, "Bill", "Paul") + " days");
      
    }
    catch(Exception e) {
      
      throw e;
      
    } 
  
 
    
  }
}
