package studentenadmin;

/**
 * Klasse verantwoordelijk voor het beheer van de diverse opleidingstrajecten
 * @author Steven Minken
 */

public abstract class Opleiding {
  
  private String naamOpleiding = null;
  
  /**
   * Initialiseert de naam van dit opleidingstraject
   * @param naamOpleiding de naam van de opleiding
   */
  protected Opleiding(String naamOpleiding) throws StudentAdminException  {
    controleerGeldigheidNaam(naamOpleiding);
    this.naamOpleiding = naamOpleiding;
  }
  
  /**
   * Retourneert de naam van de opleiding
   * @return String naam van de opleiding
   */
  protected String getNaamOpleiding()  {
    return naamOpleiding;
  }
  
  /**
   * Gooit een exception op als de naam van de nieuwe opleiding niet voldoet aan de voorwaarden
   * @param naamOpleiding de naam van de opleiding
   */
  protected static void controleerGeldigheidNaam(String naamOpleiding) throws StudentAdminException {

    if (naamOpleiding.matches(".*\\d.*"))  {
      throw new StudentAdminException("De naam kan niet uit cijfers bestaan.");
    } 
    
  }
  
  /**
   * Verwacht wordt dat opleidingstrajecten een methode implementeren om diverse 
   * informatie weer te geven als String
   */
  @Override
  public abstract String toString();


}
