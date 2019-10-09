/*
 * Classe que defineix un projecte. Un projecte es defineix per un codi, NIF del
 * del client que ha encarregat el projecte, si està finalitzat o no, el pressupost 
 * i el dissenyador encarregat en desenvolupar-lo. A més, contindrà un vector de 
 * jardiners encarregats d'implementar el projecte.
 */
package principal;

import components.Dissenyador;
import components.Jardiner;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class Projecte {
    private final static Scanner DADES = new Scanner(System.in);


    private int codi;
    private static int properCodi = 1; //El proper codi a assignar
    private String nifClient;
    private boolean finalitzat;
    private double pressupost;
    private Dissenyador dissenyador;
    private Jardiner[] jardiners = new Jardiner[40];
    private static int posicioJardiners = 0; //Priemra posició buida del vector jardiners
    
     /*
     TODO
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys el vector, el
     codi i finalitzat.
     Accions:
     - Assignar als atributs corresponents els valors passats com a paràmetres
     - Assignar a l'atribut codi el valor de l'atribut properCodi i actualitzar
     properCodi amb el següent codi a assignar.
     - Quan es crea un projecte aquest mai està finalitzat, per tant, assignarem
     fals a l'atribut finalitzat.
     - Quan es crea un projecte no té cap dissenyador assignat.
     */

    public Projecte(String nif, double pressupost) { // Vamos a pasar 1 diseñador y (x) jardineros
        this.nifClient  = nif;
        this.pressupost = pressupost;
        this.codi = properCodi;
        properCodi++;
    }
    /*
     TODO Mètodes accessors    
     */

    public void setJardineros(Jardiner jardinero[]) {
        for(int i = 0; i <= jardinero.length; i++) {
            this.jardiners[i] = jardinero[i];
        }
    }

    public Jardiner getJardineros() {
        for(int i = 0; i <= jardiners.length; i++) {
            return(this.jardiners[i] = jardiners[i]);
        }
        return(this.jardiners[jardiners.length]);
    }

    public boolean isFinalitzat() {
        return this.finalitzat;
    }

    public void setFinalitzat(boolean finalitzat) {
        this.finalitzat = finalitzat;
    }

    public double getPressupost() {
        return pressupost;
    }

    public void setPressupost(double pressupost) {
        this.pressupost = pressupost;
    }

    public String getNifClient() {
        return this.nifClient;
    }

    public void setNifClient(String nifClient) {
        this.nifClient = nifClient;
    }

    public void setDisenyador(Dissenyador diseñador) {
        this.dissenyador = diseñador;
    }

    public Dissenyador getDiseñador() {
        return(this.dissenyador);
    }

    public void setCodigo(int codigo) {
        this.codi = codigo;
    }

    public int getCodigo() {
        return this.codi;
    }

     /*
     TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou projecte. Les dades
     a demanar són les que passem per paràmetre en el constructor.
     Retorn: El nou projecte creat.
     */
    public static Projecte addProjecte() {
    // Dissenyador diseñador, Jardiner[] jardiners, String nif
        System.out.println("Introdueix el NIF");
        String nif = DADES.next();
        System.out.println("Introdueix el pressupost");
        double pressupost = DADES.nextDouble();

        return new Projecte(nif,pressupost);

    }
    
    /*
    TODO
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte. En aquest cas
     només es pot modificar el NIF del client, si està finalitzat o no i el pressupost.
     - En el cas de finalitzat o no, li heu de demanar a l'usuari que si el projecte està  
     finalitzat, introdueixi 1 i en cas contrari 0.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte actual, 
     abans de modificar-los. En el cas de l'atribut finalitzat, li heu de mostrar
     el missatge: "\nEl projecte està finalitzat", si el projecte s'ha finalitzat,
     i en cas contrari, el missatge "\nEl projecte no està finalitzat".
     Retorn: cap
     */
    public void updateProjecte() {

        this.showProjecte();

        System.out.println("Introdueix el nif: ");
        String nif = DADES.nextLine();
        this.setNifClient(nif);
        System.out.println("Introdueix el pressupost: ");
        double pressupost = DADES.nextDouble();
        this.setPressupost(pressupost);

    }

    /*
     TODO
     Paràmetres: jardiner o jardinera a afegir
     Accions:
     - afegeix al vector jardiners del projecte actual el jardiner o jardinera
     passat/ada per paràmetre.
     - actualitza la posició del vector jardiners.
     Retorn: cap
     */
    public void addJardiner(Jardiner jardiner) {
     jardiners[this.posicioJardiners] = jardiner;
     posicioJardiners++;

    }

    public void addDissenyador(Dissenyador dissenyador) {
        this.dissenyador = dissenyador;

    }

    public void showProjecte() {
        System.out.println("\nLes dades del projecte amb codi " + this.codi + " són:");
        System.out.println("\nNIF client: " + this.nifClient);
        System.out.println("\nPressupost: " + this.pressupost);
        this.dissenyador.showDissenyador();
        
        if(finalitzat){
            System.out.println("\nEl projecte està finalitzat");
        }else{
            System.out.println("\nEl projecte no està finalitzat");
        }

        for (int i = 0; i < posicioJardiners; i++) {
            this.jardiners[i].showJardiner();
        }
    }
    
}
