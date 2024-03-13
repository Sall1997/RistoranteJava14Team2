/**
 * The type Dessert.
 */
public class Dessert extends Portata {
    private Integer id;
    private Integer menuId;
    private  Double  amountOfCalories;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Double getAmountOfCalories() {
        return amountOfCalories;
    }

    public void setAmountOfCalories(Double amountOfCalories) {
        this.amountOfCalories = amountOfCalories;
    }

    public Dessert(String nome, Double prezzo, Tipo tipoDietaEnum,Integer id,Integer menuId, Double amountOfCalories) {
        super(nome, prezzo, tipoDietaEnum);
        this.amountOfCalories = amountOfCalories;
        this.menuId = menuId;
        this.id = id;
    }
    @Override
    public void printPortata() {
        super.printPortata();
        System.out.println( "Calorie = "+ this.amountOfCalories );
    }
}