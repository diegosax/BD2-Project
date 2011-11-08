/*
 * Grupo: Miguel Amaral, Ethan Rafael, Diego Henrique, Davyson Costa
 */
package dados;

import exception.AcessoRepositorioException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import negocio.Doctor;
import negocio.User;
import util.JDBCUtil;

/**
 *
 * @author miguel
 */
public class RepUserJDBC implements IRepUser {
    
    private static final String insert = "INSERT INTO User(name, email, password, "
            + "crm, type) VALUES ( ?, ?, ?, ?, ?)";
    private static final int CLIENT = 0;
    private static final int DOCTOR = 1;

    public void insert(User user) throws AcessoRepositorioException {
        PreparedStatement stmt = null;
        
        try {
            stmt = JDBCUtil.getStatement(insert);

            JDBCUtil.createTransaction();
            
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, Arrays.toString(user.getPassword()));
            stmt.setString(4, ((user instanceof Doctor) ? ((Doctor)user).getCrm() : null));
            stmt.setInt(5, ((user instanceof Doctor) ? DOCTOR : CLIENT));
            
            stmt.executeUpdate();
            JDBCUtil.commitTransaction();
            
        } catch (SQLException ex) {
            throw new AcessoRepositorioException(ex.getMessage());
        } finally {
            JDBCUtil.fechaRecursos(stmt, null);
        }
    }
    
}
