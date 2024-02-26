package com.codebay.goldeneye.domain.valueObject;

public class Department {

  /**
   * Atributos de la clase
   * Departamento de la empresa al que pertenece el empleado
   */
  private String department;

  // Mensaje de error
  private static final String NOT_NULL = "Department can't be null.";

  /**
   * Constructor
   * @param department
   */
  public Department (String department) {
    this.isValid(department);
    this.department = department;
  }

  /**
   * Comprobar si el departamento es nulo
   * @param department
   */
  private void isValid(String department) {
    if (department == null) {
      throw new IllegalArgumentException(NOT_NULL);
    }
  }

  /**
   * Obtener el departamento
   * @return department
   */
  public String getDepartment() {
    return department;
  }
  
  
}
