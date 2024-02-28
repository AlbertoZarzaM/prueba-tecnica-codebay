package com.codebay.goldeneye;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.codebay.goldeneye.domain.entity.Email;
import com.codebay.goldeneye.domain.valueObject.Department;
import com.codebay.goldeneye.domain.valueObject.Name;
import com.codebay.goldeneye.domain.valueObject.Office;
import com.codebay.goldeneye.domain.valueObject.Surname;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.codebay.goldeneye.domain.valueObject.Surname;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class WebApplicationTests {



	@Test
	public void testValidSurname() {
		String validSurname = "Smith";
		Surname surname = new Surname(validSurname);
		assertEquals(validSurname, surname.getSurname());
	}

	@Test
	public void testNullSurname() {
		String nullSurname = null;
		assertThrows(IllegalArgumentException.class, () -> new Surname(nullSurname));
	}

	@Test
	public void testEmptySurname() {
		String emptySurname = "";
		assertThrows(IllegalArgumentException.class, () -> new Surname(emptySurname));
	}

	@Test
	public void testInvalidCharactersInSurname() {
		String invalidSurname = "John@Doe";
		assertThrows(IllegalArgumentException.class, () -> new Surname(invalidSurname));
	}

	@Test
	public void testValidMultiPartSurname() {
		String validMultiPartSurname = "Von Neumann";
		Surname surname = new Surname(validMultiPartSurname);
		assertEquals(validMultiPartSurname, surname.getSurname());
	}
	@Test
	public void testValidName() {
			String validName = "John";
			Name name = new Name(validName);
			assertEquals(validName, name.getName());
	}

	@Test
	public void testNullName() {
		String nullName = null;
		assertThrows(IllegalArgumentException.class, () -> new Name(nullName));
	}

	@Test
	public void testEmptyName() {
		String emptyName = "";
		assertThrows(IllegalArgumentException.class, () -> new Name(emptyName));
	}


	@Test
	public void testInvalidCharactersInName() {
		String invalidName = "John@Doe";
		assertThrows(IllegalArgumentException.class, () -> new Name(invalidName));
	}

	@Test
	public void testValidMultiPartName() {
		String validMultiPartName = "John Doe";
		Name name = new Name(validMultiPartName);
		assertEquals(validMultiPartName, name.getName());
	}


	@Test
  public void testValidEmail() {
      Name name = new Name("John");
      Surname surname = new Surname("Doe");
      Office office = new Office("Milan", new Department("Design"));
      Email email = new Email(name, surname, office);
      assertEquals("jdoe.design@milan.goldeneye.com", email.getEmail());
  }

  @Test
  public void testValidMultiPartNameAndSurname() {
      Name name = new Name("James Bond");
      Surname surname = new Surname("Bond");
      Office office = new Office("Spain", new Department("Business"));
      Email email = new Email(name, surname, office);
    	assertEquals("jbond.business@spain.goldeneye.com", email.getEmail());
  }

	@Test
	public void testValidOfficeAndDepartment() {
			Department department = new Department("Design");
			Office office = new Office("Milan", department);
			assertEquals("Milan", office.getOffice());
			assertEquals(department, office.getOfficeDepa());
	}

	@Test
	public void testInvalidOffice() {
		Department department = new Department("Design");
		assertThrows(IllegalArgumentException.class, () -> new Office("InvalidOffice", department));
	}

	@Test
	public void testNullDepartment() {
		assertThrows(NullPointerException.class, () -> new Office("Milan", null));
	}
}

