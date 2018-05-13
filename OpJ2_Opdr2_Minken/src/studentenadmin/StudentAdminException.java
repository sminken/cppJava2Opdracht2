package studentenadmin;

public class StudentAdminException extends Exception  {
  
  /**
   * Klasse verantwoordelijk voor het beheer van StudentAdminExceptions
   */
  private static final long serialVersionUID = 1L;

  public StudentAdminException()  {
    super();
  }
  
  public StudentAdminException(String s)  {
    super(s);
  }
  
}
