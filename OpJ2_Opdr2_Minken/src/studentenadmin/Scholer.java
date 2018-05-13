package studentenadmin;

/**
 * Klasse verantwoordelijk voor het beheer van de scholers van de CPP trajecten
 * @author Steven Minken
 */

public class Scholer extends Student {
  
  /**
   * Registreert het aantal behaalde studiepunten
   */
  private int behaaldeModules = 0;
  
  /**
   * Registreert het CPP
   */
  private Cpp cpp = null;
  
  /**
   * Constructor voor het aanmaken van een nieuwe Scholer
   */
  protected Scholer(String naamScholer, Opleiding naamCpp) throws StudentAdminException  {
      super(naamScholer);
      cpp = (Cpp)naamCpp;
    }

  /**
   * Verhoogt het aantal behaalde modules
   */
  protected void verhoogModules()  {
    
    behaaldeModules ++;
  }
  
  /**
   * Retourneert het aantal behaalde modules
   */
  protected double getBehaaldeModules()  {
    return behaaldeModules;
  }
  
  /**
   * Retourneert string of scholer geslaagd is
   * @return String stringweergave van geslaagd of niet geslaagd
   */
  private String getGeslaagd() {
    if (cpp.getAantalModules() == behaaldeModules)  {
      return "geslaagd";
    }  else 
      return "niet geslaagd";
  }
  
  /**
   * retourneert een string van de scholer
   * @return String stringweergave van de scholer
   */
  @Override
  public String toString()  {
    if(behaaldeModules != 1)  {
      return getNaam() + ", " + cpp.getNaamOpleiding() + ", " + behaaldeModules + " modules, " + getGeslaagd();
    }  else  {
      return getNaam() + ", " + cpp.getNaamOpleiding() + ", " + behaaldeModules + " module, " + getGeslaagd();
    }
  }
  
}
