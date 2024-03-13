/**
 * The type Primi piatti.
 */
public class PrimiPiatti extends Portata {

    private Integer menuId;
    private Integer calorie;
    private String origine;

    public PrimiPiatti(String nome, Double prezzo, Tipo tipoDietaEnum, Integer calorie, String origine)
    {
        super(nome, prezzo, tipoDietaEnum);
        this.calorie = calorie;
        this.origine = origine;
    }

    @Override
    public void printPortata() {
        super.printPortata();
        System.out.println("\nCalorie: " + calorie + " Kcal " +
                "\nPasto Origine: " + origine);

    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getCalorie() {
        return calorie;
    }

    public void setCalorie(Integer calorie) {
        this.calorie = calorie;
    }

    public String getOrigine() {
        return origine;
    }

    public void setOrigine(String origine) {
        this.origine = origine;
    }
}