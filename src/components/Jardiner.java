/*
 * Classe que defineix un jardiner o jardinera. Un jardiner o jardinera es defineix 
 * pel seu NIF, nom, torn de feina i estat, és a dir, actiu si està treballant o no actiu si està 
 * de baixa o vacances.
 */
package components;
import java.util.Scanner;
/**
 *
 * @author root
 */
public class Jardiner {
    private final static Scanner DADES = new Scanner(System.in);
    
    private String nif;
    private String nom;
    private Torn torn;
    private boolean actiu;

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys l'atribut actiu
     Accions:
     - Assignar als atributs els valors passats com a paràmetres, menys a actiu,
     ja que quan es crea un nou jardiner o jardinera, el seu estat sempre és
     actiu, per tant li assignem verdader. I torn, ja que quan es crea un nou
     jardiner o jardinera aquest encara no té assignat cap torn, per tant li assignarem
     null.
     */

    public void Jardiner () {
        this.nom = "no";
        this.nif = "no";
        this.actiu = true;
    }

    public Jardiner(String nombre, String NIF) {
        this.nom = nombre;
        this.nif    = NIF;
        this.actiu = true;
    }
    /*
     TODO Mètodes accessors    
     */
    public void setNombre(String nombre) {
        this.nom = nombre;
    }

    public String getNombre() {
        return(this.nom);
    }

    public void setNIF(String NIF) {
        this.nif = NIF;
    }

    public String getNIF() {
        return(this.nif);
    }

    public void setActivo(boolean activo) {
        this.actiu = activo;
    }

    public boolean getActivo() {
        return(this.actiu);
    }

    public void setTorn(Torn torn) {
        this.torn = Torn.addTorn();
    }

    /*
         TODO
         Paràmetres: cap
         Accions:
         - Demanar a l'usuari les dades per consola per crear un nou jardiner o nova
         jardinera. Les dades a demanar són les que passem per paràmetre en el constructor.
         - També heu de tenir en compte que tant el nom pot ser una frase, per exemple,
         Francesc Xavier.
         Retorn: El nou jardiner o nova jardinera creat/da.
         */
    public static Jardiner addJardiner() {

        System.out.println("Introduceix el NIF");
        String nif = DADES.nextLine();
        System.out.println("Introduceix el nom");
        String nom = DADES.nextLine();

        return new Jardiner(nif,nom);
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte, menys de l'atribut torn.
     - En el cas de l'atribut actiu, li heu de demanar que si el jardiner o jardinera està en 
     actiu introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     En el cas de l'atribut actiu, li heu de mostrar el missatge: "\nEl jardiner o jardinera
     està en actiu", si el jardiner o jardinera està en actiu, i en cas contrari, el missatge 
     "\nEl jardiner o jardinera no està en actiu".
     Retorn: cap
     */
    public void updateJardiner() {
        this.showJardiner();

        System.out.println("Introduceix el nou NIF");
        String nif = DADES.nextLine();
        this.setNIF(nif);
        System.out.println("Introduceix el nou nom");
        String nom = DADES.nextLine();
        this.setNombre(nom);
        System.out.println("Introduceix el nou actiu (Si está actiu 1, si no 0.");
        String actiu = DADES.nextLine();
        if(actiu == "1") {
            this.setActivo(true);
        } else {
            this.setActivo(false);
        }
    }

    public void showJardiner() {
        System.out.println("\nLes dades del jardiner o jardinera amb nif " + nif + " són:");
        System.out.println("\nNom: " + nom);
        torn.showTorn();
        System.out.println("\nL'estat és: ");
        
        if(actiu){
            System.out.print("Actiu");
        }else{
            System.out.print("No actiu");
        }
    }
}
