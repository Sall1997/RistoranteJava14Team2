import entity.*;
import type.*;

public class Main {
    public static void main(String[] args) {
        Ristorante laSirenetta = new Ristorante("La Sirenetta", "Via Fantasia", true);
        Menu menu = new Menu("menu del giorno", "Alice" ,Tipo.VEGETARIANO);
        laSirenetta.addMenu(menu);

        menu.addPortata(new PrimiPiatti("Carpaccio Maguro", 18.50, Tipo.EMPTY, 120, "Giappone"));
        menu.addPortata(new PrimiPiatti("Tartarre di Salmone", 14.80, Tipo.EMPTY, 201, "Giappone"));
        menu.addPortata(new PrimiPiatti("Salmone marinato al genmaicha e al coriandolo", 22.90, Tipo.SENZA_GLUTINE, 230, "Giappone"));
        menu.addPortata(new PrimiPiatti("Ramen Vegano", 14.55, Tipo.VEGANO, 70, "Giappone"));
        menu.addPortata(new PrimiPiatti("Minestra di miso ai germogli", 16.75, Tipo.VEGETARIANO, 198, "Giappone"));

        menu.addPortata(new SecondiPiatti(1,"Insalata di Polpo e Patate", 18.80, 20, "Italia", Tipo.EMPTY));
        menu.addPortata(new SecondiPiatti(1,"Salmone Grigliato", 25.90, 7, "Italia",Tipo.EMPTY));
        menu.addPortata(new SecondiPiatti(1,"Seppie con Piselli", 16.40,5, "Italia", Tipo.EMPTY));
        menu.addPortata(new SecondiPiatti(1,"Sushi Vegano", 9.99,8, "Giappone", Tipo.VEGANO));
        menu.addPortata(new SecondiPiatti(1,"Tempura di verdure viola", 7.99,5, "Giappone", Tipo.VEGETARIANO));
        menu.addPortata(new SecondiPiatti(1,"Tofu dorato con cipollotti", 24.99,3, "Giappione", Tipo.SENZA_GLUTINE));

        menu.addPortata(new Bevande("Acqua Naturale", 2.50,0,true, Tipo.EMPTY));
        menu.addPortata(new Bevande("Coca cola", 3.00, 0,true, Tipo.EMPTY));
        menu.addPortata(new Bevande("Birra Peroni", 2.00,3,true, Tipo.EMPTY));
        menu.addPortata(new Bevande("Fanta", 3.00,0,true, Tipo.EMPTY));
        menu.addPortata(new Bevande("Vino Rosso Fazio", 6.50,15,false, Tipo.EMPTY));
        menu.addPortata(new Bevande("Vino Bianco Team1Java (Produzione propria) ", 14.50, 14,true, Tipo.EMPTY));
        menu.addPortata(new Bevande("Vino Ambrato Team1Java (Produzione propria) ", 16.50,13,false, Tipo.EMPTY));

        menu.addPortata(new Dessert("Tiramisù", 8.00, Tipo.VEGANO ,null,null, 450d));
        menu.addPortata(new Dessert("Tiramisù", 8.00, Tipo.VEGANO ,null,null, 450d));
        menu.addPortata(new Dessert("Tartufo di Pizzo", 8.40,Tipo.VEGETARIANO,null,null, 950d));
        menu.addPortata(new Dessert("Babà", 12.99, Tipo.SENZA_GLUTINE,null,null, 750d));
        menu.addPortata(new Dessert("Torta della nonna", 10.90,Tipo.VEGANO,null,null, 850d));
        menu.addPortata(new Dessert("Mazzamorra morada", 6.70,Tipo.VEGETARIANO, null,null, 650d));

        laSirenetta.printInfo();

        /*
        entity.Menu menu1 = new entity.Menu("menu spaziale", "Alice" ,type.Tipo.VEGETARIANO);
        Dao.MenuDao  menuDao = new Dao.MenuDao();
        try {
            Integer menuId = menuDao.insertMenu(menu1);
            entity.Dessert tiramisu = new entity.Dessert("Tiramisù", 8.00, type.Tipo.VEGANO ,null,menuId, 450d);
            entity.Dessert tartufo = new entity.Dessert("Tartufo di Pizzo", 8.40,type.Tipo.VEGETARIANO,null,menuId, 950d);
            entity.Dessert baba = new entity.Dessert("Babà", 12.99, type.Tipo.SENZA_GLUTINE,null,menuId, 750d);
            entity.Dessert tortaNonna = new entity.Dessert("Torta della nonna", 10.90,type.Tipo.VEGANO,null,menuId, 850d);
            entity.Dessert mazamorra = new entity.Dessert("Mazzamorra morada", 6.70,type.Tipo.VEGETARIANO, null,menuId, 650d);

            Dao.DessertDao dessertDao = new Dao.DessertDao();
            dessertDao.insertDessert(tiramisu);
            dessertDao.insertDessert(tartufo);
            dessertDao.insertDessert(baba);
            dessertDao.insertDessert(tortaNonna);
            dessertDao.insertDessert(mazamorra);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }                                                                                               */
    }
}