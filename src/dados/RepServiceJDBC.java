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
import negocio.Doctor;
import negocio.Service;
import util.JDBCUtil;

/**
 *
 * @author miguel
 */
public class RepServiceJDBC implements IRepService {

    private static final String insert = "INSERT INTO services(name) VALUES (?)";
    private static final String getAll = "SELECT * FROM services ORDER BY lower(name)";

    public void insert(Service service) throws AcessoRepositorioException {
        PreparedStatement stmt = null;

        try {
            stmt = JDBCUtil.getStatement(insert);

            JDBCUtil.createTransaction();

            stmt.setString(1, service.getName());

            stmt.executeUpdate();
            JDBCUtil.commitTransaction();

        } catch (SQLException ex) {
            throw new AcessoRepositorioException(ex.getMessage());
        } finally {
            JDBCUtil.fechaRecursos(stmt, null);
        }
    }

    public List<Service> getAll() throws AcessoRepositorioException {
        List<Service> services = new ArrayList<Service>();

        Statement stmt = null;
        ResultSet rs = null;
        try {
            Service s;
            stmt = JDBCUtil.getStatement();
            rs = stmt.executeQuery(getAll);
            
            while (rs.next()) {
                s = new Service();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                
                services.add(s);
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

    public List<Service> get(Doctor d) throws AcessoRepositorioException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
