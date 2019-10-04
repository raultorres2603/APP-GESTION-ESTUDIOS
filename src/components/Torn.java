/*
 * Classe que defineix un torn. Un torn es defineix pel seu codi, nom, hora d'inici
 * i hora d'acabament del torn.
 */
package components;
import java.util.Scanner;

/**
 *
 * @author root
 */
public class Torn {
    private final static Scanner DADES = new Scanner(System.in);


    private String codi;
    private String nom;
    private String horaInici;
    private String horaAcabament;
    private int propercodi = 1;

    /*
     TODO CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     */

    public void Turno() {
        this.horaInici = "0";
        this.horaAcabament  = "0";
        this.codi     = "0";
        this.nom        ="no";
    }

    public Torn(String horainicio, String horafinal, String codigo, String nom) {
        this.horaInici = horainicio;
        this.horaAcabament  = horafinal;
        this.codi     = codigo;
        this.nom        = nom;
        propercodi++;
    }


    /*
     TODO Mètodes accessors    
     */

    public void setHorainicio(String horainicio) {
        this.horaInici = horainicio;
    }

    public String getHorainicio() {
        return(this.horaInici);
    }

    public void setHorafinal(String horafinal) {
        this.horaAcabament = horafinal;
    }

    public String getHorafinal() {
        return(this.horaAcabament);
    }

    public void setCodigo(String codigo) {
        this.codi = codigo;
    }

    public String getCodigo() {
        return this.codi;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return(this.nom);
    }
    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou torn. Les dades 
     a demanar són les que passem per paràmetre en el constructor.
     - Per assignar les hores d'inici i acabamanet del torn, heu d'utilitzar el mètode
     escaient d'aquesta classe.
     Retorn: El nou torn creat.
     */
    public static Torn addTorn() {

        System.out.println("Introduceix el codi");
        String codi = DADES.nextLine();
        System.out.println("Introduceix el nom");
        String nom = DADES.nextLine();
        System.out.println("Introduceix l'hora d'inici");
        String horaInici = horesTorn();
        System.out.println("Introduceix l'hora d'acabament");
        String horaAcabament = horesTorn();



        return new Torn(codi,nom,horaInici,horaAcabament);
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte (Penseu com heu de
     modificar les hores d'inici i d'acabament del torn).
     - Li heu de mostrar a l'usuari els valors dels atributs abans de modificar-los.
     Retorn: cap
     */
    public void updateTorn() {
        this.showTorn();

        System.out.println("Introduceix el codi");
        String codi = DADES.nextLine();
        this.setCodigo(codi);
        System.out.println("Introduceix el nom");
        String nom = DADES.nextLine();
        this.setNom(nom);
        System.out.println("Introduceix l'hora d'inici");
        String horainici = horesTorn();
        this.setHorainicio(horainici);
        System.out.println("Introduceix l'hora d'acabament");
        String horaacabament = horesTorn();
        this.setHorafinal(horaacabament);

    }

    public void showTorn() {
        System.out.println("\nLes dades del torn amb codi " + codi + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nHora d'inici: "+horaInici);
        System.out.println("\nHora d'acabament: "+horaAcabament);
    }

    /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear les hores d'inici o acabament
     d'un torn.
     - Tant l'hora d'inici com la d'acabament, han de tenir el format "hh:mm", on
     hh és l'hora en format 24 hores i mm els minuts. Perquè es respecti el format,
     primer demanarem l'hora a l'usuari i després els minuts. El mateix mètode és
     el que haurà de crear el format correcte amb les dades introduïdes per l'usuari.
     - Heu de controlar que les hores i minuts introduïts siguin correctes. Si no 
     és així, se li tornaran a demanar a l'usuari fins que introdueixi unes dades correctes.
     Retorn: Les hores d'inici o acabament del torn.
     */
    public static String horesTorn() {
        System.out.println("Hora: ");
        String horas =  DADES.nextLine();
        System.out.println("Minuts: ");
        String minutos =  DADES.nextLine();

        return(horas + ":" + minutos);

    }
}
