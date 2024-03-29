package com.codebay.goldeneye.domain.valueObject;

import java.util.regex.Pattern;

public class Name {

  //atributos de la clase
  private String name;

  // Mensajes de error
  public static final int MAX_LENGTH = 2000;
  public static final String REGULAR_EXPRESSION = "^[A-Za-z]+(?:[ ][A-Za-z]+)*$";
  public static final String ERROR_NOT_DEFINED = "Name of the employee is not defined";
  public static final String ERROR_EMPTY = " Name of the employee cannot be empty";
  public static final String ERROR_MAX_LENGTH = "Name of the employee cannot exceed " + MAX_LENGTH + " characters";
  public static final String ERROR_WRONG_FORMAT = "Name of the employee has wrong format";


  //constructor
  public Name(String name) {
    this.isValid(name);
    this.name = name;
  }

  /**
   * Comprobar si el nombre es válido
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
   * Obtener el nombre
   * @return name
   */
  public String getName() {
    return name;
  }  
}
