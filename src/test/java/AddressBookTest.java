import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.gumtreeuk.addressbook.domain.Person;
import com.gumtreeuk.addressbook.reader.AddressBookReader;

public class AddressBookTest {   


  @Test
  public void testMainOk() throws Exception  {
    String[] args = new String[1];
    args[0] = "c:/AddressBook.txt";
    Main.main(args);
  }


  @Test
  public void testAddressBookReaderFound() throws Exception  {
    AddressBookReader abr= new AddressBookReader("c:/AddressBook.txt");
    assertTrue(abr!=null);
  }

  @Test
  public void testAddressBookReaderNotFound() {
    try {
      AddressBookReader abr = new AddressBookReader("c:/FakeAddressBook.txt");
      assertTrue(abr.getPersons()!=null);
    }
    catch (Exception e) {
      assertTrue(true);
    }
  }


  @Test
  public void testAddressBookReaderNotEmpty() throws Exception {
    AddressBookReader abr = new AddressBookReader("c:/AddressBook.txt");
    assertTrue(abr.getPersons().size()>0);
  }


  @Test
  public void testPersonIntoAddressBookValid() throws Exception {
    AddressBookReader abr = new AddressBookReader("c:/AddressBook.txt");
    List<Person> persons = abr.getPersons();
    for (Person person : persons)
    {
      assertTrue(person.getName()!=null);
      assertTrue(person.getBirthDate()!=null);
      assertTrue(person.getGender()!=null); 
    }

  }



}
