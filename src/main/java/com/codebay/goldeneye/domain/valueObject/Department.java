package com.codebay.goldeneye.domain.valueObject;

public class Department {


  private String department;

  private static final String NOT_NULL = "Department can't be null.";

  public Department (String department) {
    this.isValid(department);
    this.department = department;
  }

  private void isValid(String department) {
    if (department == null) {
      throw new IllegalArgumentException(NOT_NULL);
    }
  }

  public String getDepartment() {
    return department;
  }
  
  
}
