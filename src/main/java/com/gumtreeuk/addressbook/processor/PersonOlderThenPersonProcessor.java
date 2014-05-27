package com.gumtreeuk.addressbook.processor;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

import com.gumtreeuk.addressbook.domain.Person;

public class PersonOlderThenPersonProcessor 
{

  private static final Logger LOG = Logger.getLogger(OldestPersonProcessor.class.getName());

  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy", Locale.ENGLISH);

  public long getResults(List<Person> persons, String name1, String name2) throws Exception {
    
    Person pers1 = null;
    
    Person pers2 = null;
    
    LOG.info("Retriving persons to compare by name");
    
    for (Person person : persons)
    {
      if (person.getName().contains(name1))
        pers1 = person;
      if (person.getName().contains(name2))
        pers2 = person;
    }
    
    if (pers1!=null && pers2!=null) {
    
    LOG.info("Compare older between two persons.");

    long diff = (sdf.parse(pers2.getBirthDate()).getTime() - sdf.parse(pers1.getBirthDate()).getTime()) / (1000*60*60*24); 

    if (diff > 0) 
      return diff; 
    else 
      return 0;
    }
    else 
      throw new PersonException("There aren't person with name: " + name1 + " and " + name2);
  }
}
