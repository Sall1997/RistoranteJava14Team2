import java.sql.*;

public class DessertDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ristorante";
    private static final String USER = "root";
    private static final String PASS = "Totti10totti";

    public void createTable() throws SQLException {

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        Statement statement = conn.createStatement();

        String createQuery = ""
                + "CREATE TABLE IF NOT EXIST `dessert` ( "
                + "  `dessert_id` int NOT NULL AUTO_INCREMENT, "
                + "  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL, "
                + "  `price` double NOT NULL, "
                + "  `diet_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL, "
                + "  `calories` double NOT NULL, "
                + "  `alcoholic` tinyint(1) NOT NULL, "
                + "  `gluten_free` tinyint(1) NOT NULL, "
                + "  `menu_id` int DEFAULT NULL, "
                + "  PRIMARY KEY (`dessert_id`), "
                + "  KEY `dessert_FK` (`menu_id`), "
                + "  CONSTRAINT `dessert_FK` FOREIGN KEY (`menu_id`) REFERENCES `menu` (`menu_id`) "
                + ")";
        statement.executeUpdate(createQuery);

        conn.close();

        System.out.println("Tabella dessert creata");
    }

    /*public void insertDessert(Dessert dessert) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String insertQuery = ""
                + "INSERT INTO dessert "
                + "(nome,prezzo,tipo_dieta,calorie,menu_id )"
                + "VALUES ('" + dessert.getNome() + "', '" + dessert.getPrezzo() + "', '"+ dessert.getTipoDieta() + "', '"+dessert.getAmountOfCalories()+"' , '"+dessert.getMenuId() +"');";

        statement.executeUpdate(insertQuery);
        conn.close();

        System.out.println("Tabella popolata");
    }
    */
    public void insertDessert(Dessert dessert) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String insertQuery = ""
                + "INSERT INTO dessert "
                + "(nome,prezzo,tipo_dieta,calorie,menu_id )"
                + "VALUES ('" + dessert.getNome() + "', '" + dessert.getPrezzo() + "', '"+ dessert.getTipoDieta() + "', '"+dessert.getAmountOfCalories()+"' , '"   +  dessert.getMenuId() +  "');";

        statement.executeUpdate(insertQuery);
        conn.close();

        System.out.println("Tabella popolata");
    }

    public void printAllDessert() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String printQuery = " SELECT * from dessert ;\n";

        ResultSet resultSet = statement.executeQuery(printQuery);

        int i = 0;

        while (resultSet.next()) {
            i = i +1;
            System.out.println(" nome " + resultSet.getString("nome") + i);
            System.out.println(" - prezzo " + resultSet.getString("prezzo") + i);
            System.out.println(" - tipo dieta" + resultSet.getString("tipo_dieta") + i);
            System.out.println(" - calorie" + resultSet.getString("calorie") + i);
            System.out.println(" - alcolico" + resultSet.getString("alcolico") + i);
            System.out.println(" - gluten free" + resultSet.getString("gluten_free") + i);

        }
        conn.close();
    }

    public void updateDessert(Dessert newDessertToUpdate,Integer id) throws SQLException{
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String dessertDaCercare = ""
                + "SELECT  dessert_id , nome, prezzo, tipo_dieta, calorie, alcolico, gluten_free"
                + "FROM dessert"
                + "WHERE  dessert_id = '" +  id +"' ; ";

        ResultSet resultSet = statement.executeQuery(dessertDaCercare);
        Integer currentDessertId = null;

        while(resultSet.next()){
            currentDessertId = resultSet.getInt(id);
        }
        String updateDessert =
                         "UPDATE dessert " +
                        "SET nome = '" + newDessertToUpdate.getNome() + "', " +
                        "prezzo = '" + newDessertToUpdate.getPrezzo() + "', " +
                        "tipo_dieta = '" + newDessertToUpdate.getTipoDieta() + "', " +
                        "calorie = '" + newDessertToUpdate.getAmountOfCalories() + "' " +
                        "WHERE dessert_id = '" + currentDessertId + "',";

        statement.executeUpdate(updateDessert);
        System.out.println("dessert con " + id + "aggiornato");
        conn.close();
    }

    public void deleteDessert(Integer dessertId) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();
        String deleteQuery = "delete from dessert " + "where dessert_id =" + dessertId;

        statement.executeUpdate(deleteQuery);
        conn.close();
        System.out.println("dessert con id " + dessertId + " eliminato!");
    }

    public void deleteAllDessert() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();
        String truncateQuery = "truncate dessert";

        statement.executeUpdate(truncateQuery);
        conn.close();
        System.out.println("tabella pulita completamente");
    }
}
