package com.codebay.goldeneye.domain.entity;

import com.codebay.goldeneye.domain.valueObject.Name;
import com.codebay.goldeneye.domain.valueObject.Office;
import com.codebay.goldeneye.domain.valueObject.Surname;

public class Email {

  // Atributos
  private String email;

  /**
   * Constructor
   * @param name
   * @param surname
   * @param office
   * 
   * Generar el email del empleado
   * 
   */
  public Email(Name name, Surname surname, Office office) {

    // Primera letra del nombre
    String firstLetterName = name.getName().substring(0, 1);

    // Primer apellido
    String firstSurname = surname.getSurname();

    // Departamento
    String departmentName = office.getOfficeDepa().getDepartment();

    // Oficina
    String officeName = office.getOffice();

    // Email
    this.email = firstLetterName.toLowerCase() + firstSurname.toLowerCase() + "." + 
    departmentName.toLowerCase().replaceAll(" ", "") +"@"  + officeName.toLowerCase().replaceAll(" ", "") + ".goldeneye.com";
    
  }

  /**
   * Obtener el email
   * @return email
   */
  public String getEmail() {
    return email;
  }
  
}
