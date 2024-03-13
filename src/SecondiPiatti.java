/**
 * The type Secondi piatti.
 */
public class SecondiPiatti extends Portata {
    private  Integer menuId;
    private String origine;
    private Integer tempoDiPreparazione;

    public SecondiPiatti(Integer menuId, String nome, Double prezzo,Integer tempoDiPreparazione, String origine, Tipo tipoDietaEnum) {
        super(nome, prezzo, tipoDietaEnum);
        this.menuId = menuId;
        this.origine = origine;
        this.tempoDiPreparazione = tempoDiPreparazione;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }

    public Integer getTempoDiPreparazione() {
        return tempoDiPreparazione;
    }

    public void setTempoDiPreparazione(Integer tempoDiPreparazione) {
        this.tempoDiPreparazione = tempoDiPreparazione;
    }

    @Override
    public void printPortata() {
        super.printPortata();
        System.out.println("Tempo di preparazione: " + tempoDiPreparazione + " (min)");
        System.out.println("Origine Piatto: " + origine + "\n");
    }
}
