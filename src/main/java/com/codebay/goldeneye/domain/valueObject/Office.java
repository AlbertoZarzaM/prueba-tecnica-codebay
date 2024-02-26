package com.codebay.goldeneye.domain.valueObject;

public class Office {

  private String office;
  private Department department;


  private String[] Milan = {"Desing", "Business", "Advertising"};
  private String[] Spain = {"Research & development", "Business"};
  private String[] NewYork = {"Business", "Advertising"};

  public static final String NOT_NULL = "Office can't be null.";


  public Office(String office, Department department) {

    if (office.equals("Milan")) {
      // Comprobar si el departamento existe
      for (String depa : Milan) {
        if (depa.equals(department.getDepartment())) {
          this.department = department;
        }
      }
    } else if (office.equals("Spain")) {
      for (String depa : Spain) {
        if (depa.equals(department.getDepartment())) {
          this.department = department;
        }
      }
    } else if (office.equals("NewYork")) {
      for (String depa : NewYork) {
        if (depa.equals(department.getDepartment())) {
          this.department = department;
        }
      }
    }
    if (this.department == null) {
      throw new IllegalArgumentException("The department doesn't exist in the office.");
    }
    this.isValid(office);
    this.office = office;
  }

  private void isValid(String office) {
    if (office == null) {
      throw new IllegalArgumentException(NOT_NULL);
    }
  }

  public String getOffice() {
    return office;
  }

  public Department getOfficeDepa() {
    return department;
  }
  
}