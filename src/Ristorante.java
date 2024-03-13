import java.util.ArrayList;
import java.util.List;

/**
 * The type Ristorante.
 */
public class Ristorante {
    private String nome;
    private String indirizzo;
    private Boolean michelinGuide;
    private List<Menu>  listaMenu;

    /**
     * Instantiates a new Ristorante.
     *
     * @param nome             the nome
     * @param indirizzo        the indirizzo
     * @param MichelinGuide the its michelin guide
     */
    public Ristorante(String nome, String indirizzo, boolean MichelinGuide) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.michelinGuide = MichelinGuide;
        this.listaMenu = new ArrayList<>();
    }

    /**
     * Gets nome.
     *
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Sets nome.
     *
     * @param nome the nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Gets indirizzo.
     *
     * @return the indirizzo
     */
    public String getIndirizzo() {
        return indirizzo;
    }

    /**
     * Sets indirizzo.
     *
     * @param indirizzo the indirizzo
     */
    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * Is its michelin guide boolean.
     *
     * @return the boolean
     */
    public Boolean isMichelinGuide() {
        return michelinGuide;
    }

    /**
     * Sets its michelin guide.
     *
     * @param michelinGuide the its michelin guide
     */
    public void setMichelinGuide(Boolean michelinGuide) {
        this.michelinGuide = michelinGuide;
    }

    /**
     * Add menu.
     *
     * @param menu the menu
     */
    public void addMenu(Menu menu){
        this.listaMenu.add(menu);
    }

    /**
     * Print info.
     */
    public void printInfo(){
        System.out.println("Ristorante : " + this.nome + "\nIndirizzo : " + this.indirizzo  +
                (michelinGuide ? "\nQuesto ristorante è presente sulla guida Michelin" : "\nQuesto ristorante non è presente sulla guida Michelin"));
        for (Menu menu : listaMenu) {
            System.out.println("Chef  : "+ menu.getChef());
            System.out.println();
            menu.printMenu();
        }
    }
}
