package com.gumtreeuk.addressbook.domain;

import com.googlecode.jcsv.annotations.MapToColumn;

public class Person {
  
  @MapToColumn(column=0)
  private String name;

  @MapToColumn(column=1)
  private String gender;

  @MapToColumn(column=2)
  private String birthDate;

  public String getName()
  {
    return name;
  }

  public String getGender()
  {
    return gender;
  }

  public String getBirthDate()
  {
    return birthDate;
  }
  
}
