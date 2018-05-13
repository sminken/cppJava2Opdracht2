package studentenadmin;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse verantwoordelijk voor het beheer van de verschillende soorten studenten 
 * en voor het beheer van de diverse opleidingstrajecten
 * OpiJ2-Opdracht 2
 * @author Steven Minken
 */
public class StudentenAdmin {
  
  private List<Student> studentenLijst = null;
  private List<Opleiding> opleidingLijst = null;

  /**
   * Constructor voor het aanmaken van een studentenadministratie.
   * creert lege lijsten voor studenten en opleidingen, vult deze met 2 opleidingen en 3 CPP's
   */
  public StudentenAdmin() {
    studentenLijst = new ArrayList<Student>();
    opleidingLijst = new ArrayList<Opleiding>();
    
    try {
      maakOpleiding("Informatica", 200);
      maakOpleiding("Wiskunde", 160);
    
      maakCpp("Cpp Java", 6);
      maakCpp("Cpp Softwarearchitect", 4);
      maakCpp("Cpp Systeemontwikkelaar", 3);  
    }
    catch (StudentAdminException e) {
      System.out.println(e.getMessage());
    }
  }
  
  /**
   * Maakt een nieuwe reguliere student aan en voegt deze toe aan
   * de studentenLijst.
   * @param naamStudent naam van de reguliere student
   * @param naamOpleiding naam van de opleiding
   */
  public void nieuweReguliereStudent(String naamStudent, String naamOpleiding) throws StudentAdminException  {
//  Verwijder spaties
    String naamStudentZonderSpaties = naamStudent.trim();
    String naamStudentMetHoofdletter = naamStudentZonderSpaties.substring(0, 1).toUpperCase() + naamStudentZonderSpaties.substring(1).toLowerCase();

    controleerDubbeleStudent(naamStudentMetHoofdletter);
    if(getOpleiding(naamOpleiding) instanceof ReguliereOpleiding)  {
      studentenLijst.add(new ReguliereStudent(naamStudentMetHoofdletter, getOpleiding(naamOpleiding)));
    } else  {
      throw new StudentAdminException("Dit is geen reguliere opleiding");
    }
   }
  
  
  /**
   * Maakt een nieuwe scholer aan en voegt deze toe aan
   * de studentenLijst.
   * @param naam naam van de scholer
   * @param naamCpp naam van het CPP
   */
  public void nieuweScholer(String naamScholer, String naamCpp) throws StudentAdminException  {
    String naamScholerZonderSpaties = naamScholer.trim();
    String naamMetHoofdletter = naamScholerZonderSpaties.substring(0, 1).toUpperCase() + naamScholerZonderSpaties.substring(1).toLowerCase();

    controleerDubbeleStudent(naamMetHoofdletter);
    if(getOpleiding(naamCpp) instanceof Cpp)  {
    studentenLijst.add(new Scholer(naamMetHoofdletter, getOpleiding(naamCpp)));
    } else  {
      throw new StudentAdminException("Dit is geen CPP");
    }
  }
  
  /**
   * Maakt een nieuwe opleiding aan en voegt deze toe aan
   * de opleidingLijst.
   * @param naamOpleiding naam van de opleiding
   * @param double totaal van de te behalen studiepunten
   */
  public void maakOpleiding (String naamOpleiding, double totaalAantalStudiepunten) throws StudentAdminException {
    String naamOpleidingZonderSpaties = naamOpleiding.trim();
    String naamOpleidingMetHoofdletter = naamOpleidingZonderSpaties.substring(0, 1).toUpperCase() + naamOpleidingZonderSpaties.substring(1).toLowerCase();
    controleerOfOpleidingBestaat(naamOpleidingMetHoofdletter);
    ReguliereOpleiding reguliereOpleiding = new ReguliereOpleiding (naamOpleidingMetHoofdletter, totaalAantalStudiepunten);
    opleidingLijst.add(reguliereOpleiding);
  }
  
  /**
   * Maakt een nieuw cpp aan en voegt deze toe aan
   * de opleidingLijst.
   * @param naamCpp naam van het Cpp
   * @param int totaal te behalen modules
   */
  public void maakCpp (String naamCpp, int totaalAantalModules) throws StudentAdminException {
    String naamCppZonderSpaties = naamCpp.trim();
    String naamCppMetHoofdletter = naamCppZonderSpaties.substring(0, 1).toUpperCase() + naamCppZonderSpaties.substring(1).toLowerCase();
    controleerOfOpleidingBestaat(naamCppMetHoofdletter);
    Cpp cpp = new Cpp (naamCppMetHoofdletter, totaalAantalModules);
    opleidingLijst.add(cpp);
  }
  
  /**
   * Zoekt student bij gegeven naam.
   * @param naam naam van de student
   * @return Student student, null als student niet bestaat
   */
  private Student getStudent(String naam) throws StudentAdminException {
    for (Student student : studentenLijst) {
      if (studentenLijst != null && student.getNaam().equals(naam)) {
        return student;
      }
    }
    throw new StudentAdminException("Deze student is niet bekend.");
  }
  
  /**
   * Zoekt opleiding van student.
   * @param naamOpleiding naam van de opleiding
   * @return Opleiding (null als opleiding niet bestaat)
   */
  private Opleiding getOpleiding(String naamOpleiding) throws StudentAdminException  {
    for (Opleiding opleiding : opleidingLijst) {
      if (opleidingLijst != null && opleiding.getNaamOpleiding().equals(naamOpleiding)) {
        return opleiding;
      }
    }
    throw new StudentAdminException("Deze opleiding bestaat niet.");
  }
  
  /**
   * Verhoogt het aantal studiepunten van de reguliere student met een gegeven aantal
   */
  public void verhoogPunten(String naam, double punten) throws StudentAdminException  {
 
    String naamZonderSpaties = naam.trim();
    String naamMetHoofdletter = naamZonderSpaties.substring(0, 1).toUpperCase() + naamZonderSpaties.substring(1).toLowerCase();

    if (!(getStudent(naamMetHoofdletter) instanceof ReguliereStudent))  {
      throw new StudentAdminException("Deze persoon volgt geen reguliere opleiding");
    }
    else  {
    ReguliereStudent student = (ReguliereStudent) getStudent(naamMetHoofdletter);
    student.verhoogBehaaldeStudiepunten(punten);
    }
  }
  
  /**
   * Voeg 1 module toe voor een scholer CPP
   */
  public void voegModuleToe(String naam)  throws StudentAdminException  {

    String naamZonderSpaties = naam.trim();
    String naamMetHoofdletter = naamZonderSpaties.substring(0, 1).toUpperCase() + naamZonderSpaties.substring(1).toLowerCase();

    if (getStudent(naamMetHoofdletter) instanceof ReguliereStudent)  {
      throw new StudentAdminException("Deze persoon volgt geen CPP");
    }
    else  {
      Scholer scholer = (Scholer) getStudent(naamMetHoofdletter);
      scholer.verhoogModules();
    }
  }
  
  /**
   * Retourneert informatie van alle studenten
   * @return String String van informatie van studenten
   * 
   */
  public String toonAlleStudenten()  {
    StringBuilder studenten = new StringBuilder();
    for (Student s: studentenLijst)  {
      studenten.append(s.toString() + "\n");
    }
    return studenten.toString();
  }
  
  /**
   * Retourneert een array van de namen van alle beschikbare opleidingen.
   * @return String[] String[] van de namen van de opleidingen
   */
  public String[] getOpleidingen()  {
    ArrayList<String> opleidingen = new ArrayList<String>();
    for (Opleiding opleiding: opleidingLijst)  {
      if(opleiding instanceof ReguliereOpleiding)  {
        opleidingen.add(opleiding.getNaamOpleiding());
        }
      }
    String[] opleidingenArray = (String[]) opleidingen.toArray(new String[0]);
    return opleidingenArray;
  }
  
  /**
   * Retourneert een array van de namen van alle beschikbare CPP trajecten.
   * @return String[] String[] van de namen van de CPP trajecten
   */
  public String[] getCPP()  {
    ArrayList<String> Cpp = new ArrayList<String>();
    for (Opleiding opleiding: opleidingLijst)  {
      if(opleiding instanceof Cpp)  {
        Cpp.add(opleiding.getNaamOpleiding());
        }
      }
    String[] CppArray = (String[]) Cpp.toArray(new String[0]);
    return CppArray;
  }
  
  /**
   * Gooit een exception op wanneer de student al voorkomt in de administratie
   * @param naam naam van de student
   */
  private void controleerDubbeleStudent(String naam) throws StudentAdminException {
    String naamMetHoofdletter = naam.substring(0, 1).toUpperCase() + naam.substring(1);
    for (Student student: studentenLijst)  {
      if(student.getNaam().equals(naamMetHoofdletter))  {
        throw new StudentAdminException(naamMetHoofdletter + " komt al voor in de studentenadministratie");
      }
    }
  }
  
  /**
   * Gooit een exception op wanneer de opleiding niet voorkomt in de administratie
   * @param naamOpleiding naam van de opleiding
   */
  private void controleerOfOpleidingBestaat(String naamOpleiding) throws StudentAdminException {
    String naamOpleidingZonderSpaties = naamOpleiding.trim();
    String naamMetHoofdletter = naamOpleidingZonderSpaties.substring(0, 1).toUpperCase() + naamOpleidingZonderSpaties.substring(1).toLowerCase();
    for (Opleiding opleiding: opleidingLijst)  {
      if(opleiding.getNaamOpleiding().equals(naamMetHoofdletter))  {
        throw new StudentAdminException(naamMetHoofdletter + " komt al voor als opleiding in de administratie");
      }
    }
  }
    
  /**
   * Methode voor het weergeven van diverse informatie als String van een individuele student
   * @param naam naam van de student
   * @return String stringweergaven van de student
   */
  public String studentToString (String naam)  throws StudentAdminException  {
    String naamZonderSpaties = naam.trim();
    Student.controleerGeldigheidNaam(naamZonderSpaties);
    String naamMetHoofdletter = naamZonderSpaties.substring(0, 1).toUpperCase() + naamZonderSpaties.substring(1).toLowerCase();

    return getStudent(naamMetHoofdletter).toString();
  }
  
}