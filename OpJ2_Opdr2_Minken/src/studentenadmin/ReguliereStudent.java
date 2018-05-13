package studentenadmin;

/**
 * Klasse verantwoordelijk voor het beheer van de reguliere studenten voor de reguliere opleidingen
 *
 */

public class ReguliereStudent  extends Student  {
  
  /**
   * Registreert het aantal behaalde studiepunten
   */
  private double behaaldeStudiepunten = 0.0;
  
  /**
   * Registreert de opleiding
   */
  private ReguliereOpleiding opleiding = null;
  
  /**
   * Constructor voor het aanmaken van een nieuwe reguliere student
   */
  protected ReguliereStudent(String naamStudent, Opleiding naamOpleiding) throws StudentAdminException  {
    super(naamStudent);
    opleiding = (ReguliereOpleiding)naamOpleiding;
  }
  
  /**
   * Verhoogt het aantal behaalde studiepunten
   */
  protected void verhoogBehaaldeStudiepunten(double studiepunten) throws StudentAdminException {
    if(studiepunten > 0)  {
    behaaldeStudiepunten += studiepunten;
    } else {
      throw new StudentAdminException("De studiepunten dienen groter dan nul te zijn.");
    }
  }
  
  /**
   * Retourneert het aantal behaalde studiepunten
   */
  protected double getBehaaldeStudiepunten()  {
    return behaaldeStudiepunten;
  }
  
  /**
   * stringweergave of de reguliere student geslaagd is
   * @return String geslaagd indien geslaagd, niet geslaagd indien niet geslaagd
   */
  private String getGeslaagd() {
    if (opleiding.getAantalStudiepunten() == behaaldeStudiepunten)  {
      return "geslaagd";
    }  else 
      return "niet geslaagd";
  }
  
  /**
   * retourneert een stringweergave van de reguliere student
   * @return String stringweergave van de student
   */
  @Override
  public String toString()  {
    if (behaaldeStudiepunten != 1) {
      return getNaam() + ", " + opleiding.getNaamOpleiding() + ", " + behaaldeStudiepunten + " studiepunten, " + getGeslaagd();
      }   else  {
      return getNaam() + ", " + opleiding.getNaamOpleiding() + ", " + behaaldeStudiepunten + " studiepunt, " + getGeslaagd();
      }
    }
  
}