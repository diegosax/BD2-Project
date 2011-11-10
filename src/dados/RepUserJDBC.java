/*
 * Grupo: Miguel Amaral, Ethan Rafael, Diego Henrique, Davyson Costa
 */
package dados;

import exception.AcessoRepositorioException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import negocio.*;
import util.JDBCUtil;

/**
 *
 * @author miguel
 */
public class RepUserJDBC implements IRepUser {

    private static final String insert = "INSERT INTO users (\"name\", email, \"password\", "
            + "crm, \"type\") VALUES ( ?, ?, ?, ?, ?)";
    private static final String getAll = "SELECT * FROM users ORDER BY lower(name)";
    private static final int CLIENT = 0;
    private static final int DOCTOR = 1;

    public void insert(User user) throws AcessoRepositorioException {
        PreparedStatement stmt = null;

        try {
            stmt = JDBCUtil.getStatement(insert);

            JDBCUtil.createTransaction();

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, "biscoito");
            stmt.setString(4, ((user instanceof Doctor) ? ((Doctor) user).getCrm() : ""));
            stmt.setInt(5, ((user instanceof Doctor) ? DOCTOR : CLIENT));
            
            System.out.println(insert);

            stmt.executeUpdate();
            JDBCUtil.commitTransaction();

            if (user instanceof Doctor) {
                Doctor d = (Doctor) user;
                Statement stmt2 = null;
                String insertService = "INSERT INTO services_doctor "
                        + "VALUES ";
                
                ResultSet rs = JDBCUtil.getStatement().executeQuery("SELECT U.id FROM users U "
                        + "WHERE U.email = '" + d.getEmail() + "'");
                if (rs.next()){
                    d.setId(rs.getInt("id"));
                }
                try {
                    stmt2 = JDBCUtil.getStatement();
                    JDBCUtil.createTransaction();

                    int i = 0;
                    for (Service s : d.getServices()) {
                        insertService += "( " + d.getId() + ", " + s.getId() + " )";
                        if (++i < d.getServices().size()) {
                            insertService += ", ";
                        }
                    }
                    System.out.println(insertService);
                    stmt2.executeUpdate(insertService);
                    JDBCUtil.commitTransaction();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    throw new AcessoRepositorioException(ex.getMessage());
                } finally {
                    stmt2.close();
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            throw new AcessoRepositorioException(ex.getMessage());
        } finally {
            JDBCUtil.fechaRecursos(stmt, null);
        }
    }

    public List<User> getAll() throws AcessoRepositorioException {
        List<User> services = new ArrayList<User>();

        Statement stmt = null;
        ResultSet rs = null;
        try {
            User u;
            stmt = JDBCUtil.getStatement();
            rs = stmt.executeQuery(getAll);
            int op = -1;
            while (rs.next()) {
                op = rs.getInt("type");
                if (op == DOCTOR){
                    u = new Doctor();
                } else {
                    u = new Client();
                }

                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password").toCharArray());
                
                if (op == DOCTOR){
                    ((Doctor)u).setCrm(rs.getString("crm"));
                    ((Doctor)u).setServices(Fachada.getFachada().get((Doctor)u));
                }
                
                services.add(u);
            }
            
            return services;
            
        } catch (SQLException e) {
            throw new AcessoRepositorioException(e.getMessage());
        } finally {
            try {
                stmt.close();
                JDBCUtil.fechaRecursos(null, rs);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
