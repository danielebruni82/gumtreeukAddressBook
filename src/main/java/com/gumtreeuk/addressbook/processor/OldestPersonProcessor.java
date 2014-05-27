package com.gumtreeuk.addressbook.processor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import com.gumtreeuk.addressbook.domain.Person;

public class OldestPersonProcessor 
{

  private static final Logger LOG = Logger.getLogger(OldestPersonProcessor.class.getName());

  public Person getOldest(List<Person> persons) throws ParseException {

    LOG.info("Start get oldest person.");
    
    Person oldest = null;

    boolean isFirst = true;
    
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);
    
    for (Person person : persons)
    {
      if (isFirst) {
        oldest = person;
        isFirst = false;
      }
      else {

        if (sdf.parse(oldest.getBirthDate()).after(sdf.parse(person.getBirthDate()))) {
          oldest = person;
        }
      }
    }

    LOG.info("End get oldest person.");

    return oldest;
  }
}
