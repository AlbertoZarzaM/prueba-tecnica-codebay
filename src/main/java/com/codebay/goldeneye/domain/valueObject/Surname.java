package com.codebay.goldeneye.domain.valueObject;

import java.util.regex.Pattern;

public class Surname {

  /**
   * Apellido del empleado
   * 
   */
  private String surname;

  public static final int MAX_LENGTH = 2000;
  public static final String REGULAR_EXPRESSION = "^[A-Za-z]+(?:[ ][A-Za-z]+)*$";
  public static final String ERROR_NOT_DEFINED = "Surname of the employee is not defined";
  public static final String ERROR_EMPTY = " Surname of the employee cannot be empty";
  public static final String ERROR_MAX_LENGTH = "Surname of the employee cannot exceed " + MAX_LENGTH + " characters";
  public static final String ERROR_WRONG_FORMAT = "Surname of the employee has wrong format";

  /**
   * Constructor
   * @param surname
   */
  public Surname(String surname) {
    this.isValid(surname);
    this.surname = surname;
  }

  /**
   * Comprobar si el apellido es válido
   * @param name
   */
  private void isValid(String name) {
    if (name == null) {
      throw new IllegalArgumentException(ERROR_NOT_DEFINED);
    }
    if (name.isEmpty()) {
      throw new IllegalArgumentException(ERROR_EMPTY);
    }
    if (name.length() > MAX_LENGTH) {
      throw new IllegalArgumentException(ERROR_MAX_LENGTH);
    }
    if (!Pattern.matches(REGULAR_EXPRESSION, name)) {
      throw new IllegalArgumentException(ERROR_WRONG_FORMAT);
    }
  }

  /**
   * Obtener el apellido
   * @return surname
   */
  public String getSurname() {
    return surname;
  }
  
}
