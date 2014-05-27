package com.gumtreeuk.addressbook.processor;

import java.util.List;

import com.gumtreeuk.addressbook.domain.Person;

public class GenderCounterPersonProcessor
{
 
  
  public enum Gender {

    MALE("Male"),

    FEMALE("Female");

    private String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}


  
  public String getResult(List<Person> persons, Gender genderType) {
    int counter = 0;
    
    for (Person person : persons)
    {
      if (person.getGender().contains(genderType.getName()))
        counter++;
    }
    return "Number of " + genderType.getName() + ": " + counter;
  }

}


