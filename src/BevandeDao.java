import java.sql.*;

public class BevandeDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/localhost";
    private static final String USER = "root";
    private static final String PASS = "Gaspare1";

    public void createTable() throws SQLException {

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        Statement statement = conn.createStatement();


        String createQuery = ""
           + "CREATE TABLE bevande ( "
+ "  bevande_id int NOT NULL AUTO_INCREMENT, "
+ "  Nome varchar(100) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL, "
+ "  Prezzo double NOT NULL, "
+ "  grado_alcolico double NOT NULL, "
+ "  is_cold tinyint(1) NOT NULL, "
+ "  menu_id int DEFAULT NULL, "
+ "  PRIMARY KEY (bevande_id), "
+ "  KEY bevande_FK (menu_id), "
+ "  CONSTRAINT bevande_FK FOREIGN KEY (menu_id) REFERENCES menu (menu_id)";


        statement.executeUpdate(createQuery);

        conn.close();

        System.out.println("Tabella Bevande creata");
    }

    public void insertBevande(Bevande bevande) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String insertQuery = "INSERT INTO bevande (nome, prezzo, grado_alcolico, is_cold, ) VALUES ('" + bevande.getNome()+ "', '" + bevande.getPrezzo() + "', '" + bevande.getGradoAlcolico() + "', '" + bevande.getCold()+ "');";

        statement.executeUpdate(insertQuery);

        conn.close();

        System.out.println("Tabella popolata");

    }

    public void printAllBevande() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String printQuery = " SELECT * from ristorante.bevande; \n";

        ResultSet resultSet = statement.executeQuery(printQuery);

        int i = 0;

        while (resultSet.next()) {
            i = i +1;
            System.out.println(" Nome " + resultSet.getString("nome") + i);
            System.out.println(" - Prezzo " + resultSet.getString("prezzo") + i);
            System.out.println(" - Grado alcolico " + resultSet.getString("grado_alcolico") + i);
            System.out.println(" - is cold " + resultSet.getString("is_cold") + i);

        }

        conn.close();
    }

    public void updateBevande(Bevande updateBevande, Integer BevandeId) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String updatequery = "UPDATE secondi_piatti "
                + "SET menu_id=" + updateBevande.getId()
                + ", nome='" + updateBevande.getNome()
                + "', prezzo=" + updateBevande.getPrezzo()
                + ", grado_alcolico='" + updateBevande.getGradoAlcolico()
                + "', is_cold='" + updateBevande.getCold()
                + "' WHERE bevande_id='" + BevandeId + "'";

        statement.executeUpdate(updatequery);
        conn.close();
        System.out.println("Bevande con id " + BevandeId + " aggiornato");
    }

    public void deleteBevande(Integer bevandeId) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();
        String deleteQuery = "delete from Bevande " + "where Bevande_id =" + bevandeId;

        statement.executeUpdate(deleteQuery);
        conn.close();
        System.out.println("tabella con id " + bevandeId + " eliminata!");
    }
    public void deleteAllBevande() throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();
        String truncateQuery = "truncate bevande";

        statement.executeUpdate(truncateQuery);
        conn.close();
        System.out.println("tabella pulita completamente");
    }
}
