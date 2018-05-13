package studentenadmin;

/**
 * Klasse verantwoordelijk voor het beheer van een reguliere opleiding
 * @author Steven Minken
 */

public class ReguliereOpleiding extends Opleiding {
  
  /**
   * Attribuut voor het vastleggen van het totaal aantal modules voor een CPP
   */
  private double totaalStudiepunten = 0.0;
  
  /**
   * Constructor voor het aanmaken van een nieuwe opleiding
   * @param naam naam van de opleiding
   * @param aantalStudiepunten totaal aantal studiepunten van de opleiding
   */
  
  public ReguliereOpleiding(String naamOpleiding, double totaalAantalStudiepunten) throws StudentAdminException {
    super(naamOpleiding);
    if(totaalAantalStudiepunten > 0)  {
      totaalStudiepunten = totaalAantalStudiepunten;
    } else {
      throw new StudentAdminException("De studiepunten dienen groter dan nul te zijn.");
    }
  }
  
  /**
   * Retourneert het totaal te behalen studiepunten
   * @return double aantal studiepunten
   */
  
  protected double getAantalStudiepunten()  {
    return totaalStudiepunten;
  }
  
  /**
   * Geeft een Stringweergave van deze opleiding van de naam en het aantal studiepunten
   * @return String String van de opleiding
   */
  @Override
  public String toString()  {
    return  "Opleiding: " + getNaamOpleiding() + ", totaal studiepunten: " + totaalStudiepunten;
  }

}
