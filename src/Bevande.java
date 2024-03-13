/**
 * The type Bevande.
 */
public class Bevande extends Portata {



    //TODO tutte le classi figli di portate devono avere almeno due campi in più
    private Integer gradoAlcolico;
    private Boolean isCold;
    private Integer Id;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Bevande(String nome, Double prezzo, Integer gradoAlcolico, Boolean isCold, Tipo tipoDietaEnum) {
        super(nome, prezzo, tipoDietaEnum);
        this.gradoAlcolico = gradoAlcolico;
        this.isCold = isCold;
        this.Id = Id;
    }

    public Integer getGradoAlcolico() {
        return gradoAlcolico;
    }

    public void setGradoAlcolico(Integer gradoAlcolico) {
        this.gradoAlcolico = gradoAlcolico;
    }

    public Boolean getCold() {
        return isCold;
    }

    public void setCold(Boolean cold) {
        isCold = cold;
    }

    @Override
    public void printPortata() {
        super.printPortata();
        if(this.gradoAlcolico == 0){
        } else {
            System.out.println("Grado alcolico: " + this.gradoAlcolico + "%");
        }
        if(isCold) {
            System.out.print("Bevanda ghiacciata\n\n");

        }
        else {
            System.out.print("Temperatura ambiente\n\n");
        }
    }
}
