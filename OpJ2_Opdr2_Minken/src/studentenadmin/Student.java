package studentenadmin;

/**
 * Klasse verantwoordelijk voor het beheer van de diverse soorten studenten
 * @author Steven Minken
 */

public abstract class Student {
  
  /**
   * attribuut voor het bijhouden van de namen van de studenten of scholers
   */
  private String naam = null;

  /**
   * initialiseert de naam van de student
   * @param naam naam van de student
   */
  protected Student(String naam) throws StudentAdminException  {
    controleerGeldigheidNaam(naam);
    this.naam = naam;
  }
   
  /**
   * Gooit een exception op als de naam van de nieuwe student of scholer niet voldoet aan de voorwaarden
   * @param naamStudent de naam van de student
   */
  protected static void controleerGeldigheidNaam(String naamStudent) throws StudentAdminException {

    if (naamStudent.length() < 2)  {
      throw new StudentAdminException("De naam dient uit minimaal twee karakters te bestaan.");
    }
    if (naamStudent.matches(".*\\d.*"))  {
      throw new StudentAdminException("De naam kan niet uit cijfers bestaan.");
    } 
    
  }
  
  /**
   * Retourneert de naam van de reguliere student of scholer
   * @return String naam van de student
   */
  protected String getNaam() {
    return naam;
  }
  
  /**
   * Verwacht wordt dat de diverse studerenden een methode implementeren om diverse 
   * informatie weer te geven als String
   */
  @Override
  public abstract String toString();
  
}
