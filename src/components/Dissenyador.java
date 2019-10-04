/*
 * Classe que defineix un dissenyador o dissenyadora. Un dissenyador o dissenyadora
 * es defineix pel seu nif, nom i estat, és a dir, actiu si està treballant o no 
 * actiu si està de baixa o vacances.
 */
package components;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Dissenyador {

    private final static Scanner DADES = new Scanner(System.in);

    private String nif;
    private String nom;
    private boolean actiu;


    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys l'atribut actiu
     Accions:
     - Assignar als atributs els valors passats com a paràmetres, menys a actiu,
     ja que quan es crea un nou dissenyador o dissenyadora, el seu estat sempre es
     actiu, per tant li assignem verdader.
     */

    public void Dissenyador() {
        this.nom = "no";
        this.nif    = null;
        this.actiu = true;
    }

    public Dissenyador(String nombre, String NIF) {
        this.nom = nombre;
        this.nif    = NIF;
        this.actiu = true;
    }


    /*
     TODO Mètodes accessors    
     */
    public void setActivo(boolean activo) {
        this.actiu = activo;
    }

    public void setNombre(String nombre) {
        this.nom = nombre;
    }

    public void setNIF(String NIF) {
        this.nif = NIF;
    }

    public boolean getActivo() {
        return this.actiu;
    }

    public String getNombre() {
        return this.nom;
    }

    public String getNIF() {
        return this.nif;
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou dissenyador o nova
     dissenyadora. Les dades a demanar són les que passem per paràmetre en el constructor.
     - També heu de tenir en compte que tant el nom pot ser una frase, per exemple, 
     Francesc Xavier.
     Retorn: El nou dissenyador o nova dissenyadora creat/da.
     */
    public static Dissenyador addDissenyador() {
        System.out.println("NIF:");
        String nif = DADES.nextLine();
        System.out.println("Nom:");
        String nom = DADES.nextLine();
        boolean actiu = true;

        return new Dissenyador(nif,nom);
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - En el cas de l'atribut actiu, li heu de demanar que si el dissenyador o dissenyadora està en 
     actiu introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     En el cas de l'atribut actiu, li heu de mostrar el missatge: "\nEl dissenyador
     o dissenyadora està en actiu", si el dissenyador o dissenyadora està en actiu,
     i en cas contrari, el misaatge "\nEl dissenyador o dissenyadora no està en actiu".
     Retorn: cap
     */
    public void updateDissenyador() {
        this.showDissenyador();

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

    public void showDissenyador() {
        System.out.println("\nLes dades del dissenyador o dissenyadora amb nif " + nif + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nL'estat és: ");
        
        if(actiu == true){
            System.out.print("Actiu");
        }else{
            System.out.print("No actiu");
        }
    }
}
