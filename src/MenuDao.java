import java.sql.*;

public class MenuDao {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ristorante";
    private static final String USER = "root";
    private static final String PASS = "Totti10totti";

    public void createTable() throws SQLException {

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        Statement statement = conn.createStatement();

        String createQuery = ""
                + "CREATE TABLE `menu` ( "
                + "  `menu_id` int NOT NULL AUTO_INCREMENT, "
                + "  `nome` varchar(100) NOT NULL, "
                + "  `chef` varchar(100) NOT NULL, "
                + "  `tipo_menu` varchar(100) NOT NULL, "
                + "  `ristorante_id` int DEFAULT NULL, "
                + "  PRIMARY KEY (`menu_id`), "
                + "  KEY `menu_FK` (`ristorante_id`), "
                + "  CONSTRAINT `menu_FK` FOREIGN KEY (`ristorante_id`) REFERENCES `ristorante` (`ristorante_id`) "
                + ")";

        statement.executeUpdate(createQuery);
        conn.close();

        System.out.println("Tabella menu creata");
    }

    public Integer insertMenu(Menu menu) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER,PASS );
        Statement statement = conn.createStatement();

        String menu1 = ""
                + "INSERT INTO ristorante.menu "
                + "(nome, chef, tipo_menu) "
                + "VALUES('"+ menu.getNomeMenu() +"', '"+ menu.getChef() +"', '"+ menu.getTipoMenu() +"');";

        PreparedStatement ps = conn.prepareStatement(menu1, Statement.RETURN_GENERATED_KEYS);
        ps.execute();

        ResultSet rs = ps.getGeneratedKeys();
        int generatedKey = 0;
        if (rs.next()) {
            generatedKey = rs.getInt(1);
        }
        conn.close();
        return generatedKey;
    }
}
