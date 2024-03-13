import java.sql.*;
public class PrimiPiattiDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ristorante";
    private static final String USER = "root";
    private static final String PASS = "java14";

    public void createTable() throws SQLException {

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();


        String createTable = ""
                + "CREATE TABLE primi_piatti ( "
                + "primi_piatti_id int NOT NULL AUTO_INCREMENT, "
                + "PRIMARY KEY (secondi_piatti_id), "
                + "menu_id int DEFAULT NULL, "
                + "nome varchar(100) NOT NULL, "
                + "prezzo double NOT NULL, "
                + "origine varchar(100) DEFAULT NULL, "
                + "calorie int DEFAULT NULL, "
                + "tipo_menu varchar(255) NOT NULL, "
                + "KEY secondi_piatti_FK (menu_id), "
                + "CONSTRAINT secondi_piatti_FK FOREIGN KEY (menu_id) REFERENCES menu (menu_id));";

        statement.executeUpdate(createTable);
        conn.close();
        System.out.println("Tabella primi_piatti creata");
    }

    public void insertPrimoPiatto(PrimiPiatti primoPiatto) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String insertQuery = "INSERT INTO primi_piatti (menu_id, nome, prezzo, origine, calorie, tipo_menu) VALUES ("
                + primoPiatto.getMenuId() + ", '" + primoPiatto.getNome() + "', " + primoPiatto.getPrezzo()
                + ", '" + primoPiatto.getOrigine() + "', " + primoPiatto.getCalorie() + ", '"
                + primoPiatto.getTipoDieta() + "')";

        statement.executeUpdate(insertQuery);
        conn.close();
        System.out.println("Tabella popolata");

    }

    public void insertAllPrimiPiatti(Menu menu) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        for (Portata portataPrimiPiatti : menu.getListaPortate()) {
            if (portataPrimiPiatti instanceof PrimiPiatti) {
                String insertQuery = "INSERT INTO primi_piatti "
                        + "(menu_id, nome, prezzo, origine, calorie, tipo_menu) VALUES ("
                        + ((PrimiPiatti) portataPrimiPiatti).getMenuId()
                        + ", '" + portataPrimiPiatti.getNome()
                        + "', " + portataPrimiPiatti.getPrezzo()
                        + ", '" + ((PrimiPiatti) portataPrimiPiatti).getOrigine()
                        + "', " + ((PrimiPiatti) portataPrimiPiatti).getCalorie()
                        + ", '" + portataPrimiPiatti.getTipoDieta() + "')";
                statement.executeUpdate(insertQuery);
            }
        }
        conn.close();
        System.out.println("Tabella popolata con tutte le portate di primi piatti");
    }

    public void printPrimiPiatti() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String printQuery = " SELECT * from primi_piatti;\n ";

        ResultSet resultSet = statement.executeQuery(printQuery);
        int i = 0;
        while (resultSet.next()) {
            i = i + 1;
            System.out.println(" - nome " + resultSet.getString("nome") + i);
            System.out.println(" - menu id " + resultSet.getString("menu_id") + i);
            System.out.println(" - prezzo " + resultSet.getString("prezzo") + i);
            System.out.println(" - origine " + resultSet.getString("origine") + i);
            System.out.println(" - calorie " + resultSet.getString("calorie") + i);
            System.out.println(" - tipo dieta " + resultSet.getString("tipo_dieta") + i);
        }
        conn.close();
    }

    public void updatePrimoPiatto(PrimiPiatti updatePrimoPiatto, Integer primoPiattiId) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String updatequery = "UPDATE primi_piatti "
                + "SET menu_id=" + updatePrimoPiatto.getMenuId()
                + ", nome='" + updatePrimoPiatto.getNome()
                + "', prezzo=" + updatePrimoPiatto.getPrezzo()
                + ", origine='" + updatePrimoPiatto.getOrigine()
                + "', calorie='" + updatePrimoPiatto.getCalorie()
                + "' WHERE primo_piatti_id='" + primoPiattiId + "'";

        statement.executeUpdate(updatequery);
        conn.close();
        System.out.println("Primo Piatto con id " + primoPiattiId + " aggiornato");
    }

    public void deletePrimoPiatto(Integer primiPiattiId) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();
        String deleteQuery = "delete from primi_piatti " + "where primi_piatti_id =" + primiPiattiId;

        statement.executeUpdate(deleteQuery);
        conn.close();
        System.out.println("tabella con id " + primiPiattiId + " eliminata!");
    }
    public void deleteAllPrimiPiatti() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();
        String truncateQuery = "truncate primi_piatti";

        statement.executeUpdate(truncateQuery);
        conn.close();
        System.out.println("tabella pulita completamente");
    }
}
