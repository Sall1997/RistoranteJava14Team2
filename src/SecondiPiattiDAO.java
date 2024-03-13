import java.sql.*;
public class SecondiPiattiDAO {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ristorante";
    private static final String USER = "root";
    private static final String PASS = "java14";

    public void createTable() throws SQLException {

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();


        String createTable = ""
                + "CREATE TABLE secondi_piatti ( "
                + "secondi_piatti_id int NOT NULL AUTO_INCREMENT, "
                + "PRIMARY KEY (secondi_piatti_id), "
                + "menu_id int DEFAULT NULL, "
                + "nome varchar(100) NOT NULL, "
                + "prezzo double NOT NULL, "
                + "origine varchar(100) DEFAULT NULL, "
                + "tempo_di_preparazione int DEFAULT NULL, "
                + "tipo_menu varchar(255) NOT NULL, "
                + "KEY secondi_piatti_FK (menu_id), "
                + "CONSTRAINT secondi_piatti_FK FOREIGN KEY (menu_id) REFERENCES menu (menu_id));";

        statement.executeUpdate(createTable);
        conn.close();
        System.out.println("Tabella secondi_piatti creata");
    }

    public void insertSecondoPiatto(SecondiPiatti secondoPiatto) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String insertQuery = "INSERT INTO secondi_piatti (menu_id, nome, prezzo, origine, tempo_di_preparazione, tipo_menu) VALUES ("
                + secondoPiatto.getMenuId() + ", '" + secondoPiatto.getNome() + "', " + secondoPiatto.getPrezzo()
                + ", '" + secondoPiatto.getOrigine() + "', " + secondoPiatto.getTempoDiPreparazione() + ", '"
                + secondoPiatto.getTipoDieta() + "')";

        statement.executeUpdate(insertQuery);
        conn.close();
        System.out.println("Tabella popolata");

    }

    public void insertAllSecondiPiatti(Menu menu) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        for (Portata portataPrimiPiatti : menu.getListaPortate()) {
            if (portataPrimiPiatti instanceof SecondiPiatti) {
                String insertQuery = "INSERT INTO secondi_piatti "
                        + "(menu_id, nome, prezzo, origine, tempo_di_preparazione, tipo_menu) VALUES ("
                        + ((SecondiPiatti) portataPrimiPiatti).getMenuId()
                        + ", '" + portataPrimiPiatti.getNome()
                        + "', " + portataPrimiPiatti.getPrezzo()
                        + ", '" + ((SecondiPiatti) portataPrimiPiatti).getOrigine()
                        + "', " + ((SecondiPiatti) portataPrimiPiatti).getTempoDiPreparazione()
                        + ", '" + portataPrimiPiatti.getTipoDieta() + "')";
                statement.executeUpdate(insertQuery);
            }
        }
        conn.close();
        System.out.println("Tabella popolata con tutte le portate di secondi piatti");
    }

    public void printSeondiPiatti() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String printQuery = " SELECT * from secondi_piatti;\n ";

        ResultSet resultSet = statement.executeQuery(printQuery);
        int i = 0;
        while (resultSet.next()) {
            i = i + 1;
            System.out.println(" - nome " + resultSet.getString("nome") + i);
            System.out.println(" - menu id " + resultSet.getString("menu_id") + i);
            System.out.println(" - prezzo " + resultSet.getString("prezzo") + i);
            System.out.println(" - origine " + resultSet.getString("origine") + i);
            System.out.println(" - tempo di preparazione " + resultSet.getString("tempo_di_preparazione") + i);
            System.out.println(" - tipo dieta " + resultSet.getString("tipo_dieta") + i);
        }
        conn.close();
    }

    public void updateSecondoPiatto(SecondiPiatti updateSecondoPiatto, Integer secondiPiattiId) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String updatequery = "UPDATE secondi_piatti "
                + "SET menu_id=" + updateSecondoPiatto.getMenuId()
                + ", nome='" + updateSecondoPiatto.getNome()
                + "', prezzo=" + updateSecondoPiatto.getPrezzo()
                + ", origine='" + updateSecondoPiatto.getOrigine()
                + "', tempo_di_preparazione='" + updateSecondoPiatto.getTempoDiPreparazione()
                + "' WHERE secondi_piatti_id='" + secondiPiattiId + "'";

        statement.executeUpdate(updatequery);
        conn.close();
        System.out.println("Secondo Piatto con id " + secondiPiattiId + " aggiornato");
    }

    public void deleteSecondoPiatto(Integer secondiPiattiId) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();
        String deleteQuery = "delete from secondi_piatti " + "where secondi_piatti_id =" + secondiPiattiId;

        statement.executeUpdate(deleteQuery);
        conn.close();
        System.out.println("tabella con id " + secondiPiattiId + " eliminata!");
    }
    public void deleteAllSecondiPiatti() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();
        String truncateQuery = "truncate secondi_piatti";

        statement.executeUpdate(truncateQuery);
        conn.close();
        System.out.println("tabella pulita completamente");
    }
}
