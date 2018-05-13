package studentenadminTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import studentenadmin.StudentenAdmin;
import studentenadmin.StudentAdminException;

class StudentenAdminTest {
  
  public StudentenAdmin studentenAdmin = new StudentenAdmin();
  
  @BeforeAll
  static void setUpBeforeClass() throws Exception {

  }

  @Test
  void testNieuweReguliereStudent() {
    try {
    studentenAdmin.nieuweReguliereStudent("Daan", "Informatica");
    assertEquals("Daan, Informatica, 0.0 studiepunten, niet geslaagd", studentenAdmin.studentToString ("Daan"));
    }
  catch (StudentAdminException e) {
  } 
    try {
      studentenAdmin.nieuweReguliereStudent("Joris", "Python");
    }
    catch (StudentAdminException e) {
    assertEquals( "Deze opleiding bestaat niet.", e.getMessage() );
    } 
    try {
      studentenAdmin.nieuweReguliereStudent("Klaas", "Cpp java");
    }
    catch (StudentAdminException e) {
    assertEquals( "Dit is geen reguliere opleiding", e.getMessage() );
    } 
  }

  @Test
  void testNieuweScholer() {
    try {
    studentenAdmin.nieuweScholer("Katrien", "Cpp Java");
    assertEquals("Katrien, Cpp java, 0 modules, niet geslaagd", studentenAdmin.studentToString ("Katrien"));
    }
  catch (StudentAdminException e) {
  } 
    try {
      studentenAdmin.nieuweScholer("Karolien", "Python");
    }
    catch (StudentAdminException e) {
    assertEquals( "Deze opleiding bestaat niet.", e.getMessage() );
    } 
    try {
      studentenAdmin.nieuweScholer("Jaap", "Informatica");
    }
    catch (StudentAdminException e) {
    assertEquals( "Dit is geen CPP", e.getMessage() );
    } 
    
  }

  @Test
  void testMaakOpleiding() {
    try {
      studentenAdmin.maakOpleiding ("Geschiedenis", 20);
    }
    catch (StudentAdminException e)  {
      
    }
    try {
      studentenAdmin.maakOpleiding("Aardrijkskunde", -5);
    }
    catch (StudentAdminException e) {
      assertEquals( "De studiepunten dienen groter dan nul te zijn.", e.getMessage() );
    }
  }

  @Test
  void testMaakCpp() {
    try {
      studentenAdmin.maakCpp ("C#", 6);
    }
    catch (StudentAdminException e)  {
      
    }
    try {
      studentenAdmin.maakCpp("Html", -4);
    }
    catch (StudentAdminException e) {
      assertEquals( "Het aantal modules dient groter dan nul te zijn.", e.getMessage() );
    }
  }

  @Test
  void testStudentToString() {
    try {
    studentenAdmin.nieuweScholer("Katrien", "Cpp Java");
    assertEquals("Katrien, Cpp java, 0 modules, niet geslaagd", studentenAdmin.studentToString ("Katrien"));
    }
    catch (StudentAdminException e) {
    } 
  }

}
