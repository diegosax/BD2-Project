/*
 * Grupo: Miguel Amaral Ethan Rafael Diego Henrique Davyson Costa
 */
package util;

import java.sql.*;

/**
 *
 * @author miguel
 */
public class JDBCUtil {

    private static Connection connection;
    private static String driver = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://localhost:5432/doctor";
    private static String user = "postgres";
    private static String password = "postgres";

    static {
        try {
            System.out.println("static metodo");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
    
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, user, password);
        }
        return connection;
    }
    
    public static Statement getStatement() throws SQLException {
        getConnection();
        return connection.createStatement();
    }

    public static PreparedStatement getStatement(String sql) throws SQLException {
        getConnection();
        return connection.prepareStatement(sql);
    }

    public static void createTransaction() throws SQLException {
        getConnection();
        connection.setAutoCommit(false);
    }

    public static void commitTransaction() throws SQLException {
        getConnection();
        connection.commit();
        connection.setAutoCommit(true);
    }

    public static void rollbackTransaction() throws SQLException {
        getConnection();
        connection.rollback();
        connection.setAutoCommit(true);
    }

    public static void fechaRecursos(PreparedStatement ps, ResultSet rs) {

        try {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (connection != null){
                connection.close();
            }
        } catch (Exception e) {
        }
    }

}
