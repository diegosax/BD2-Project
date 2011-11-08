/*
 * Grupo: Miguel Amaral, Ethan Rafael, Diego Henrique, Davyson Costa
 */
package dados;

import exception.AcessoRepositorioException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import negocio.Meeting;
import util.JDBCUtil;

/**
 *
 * @author miguel
 */
public class RepMeetingJDBC implements IRepMeeting {

    private static final String insert = "INSERT INTO meetings (notes, "
            + "scheduledDate, attendedDate, "
            + "doctor_id, client_id, service_id) "
            + "VALUES( ?, ?, ?, ?, ?, ?)";

    public void insert(Meeting meeting) throws AcessoRepositorioException {
        PreparedStatement stmt = null;
        
        try {
            stmt = JDBCUtil.getStatement(insert);

            JDBCUtil.createTransaction();
            
            stmt.setString(1, meeting.getNotes());
            stmt.setDate(2, new Date(meeting.getScheduledDate().getTimeInMillis()));
            stmt.setDate(3, new Date(meeting.getAttendedDate().getTimeInMillis()));
            stmt.setInt(4, meeting.getDoctor().getId());
            stmt.setInt(5, meeting.getClient().getId());
            stmt.setInt(6, meeting.getService().getId());
            
            stmt.executeUpdate();
            JDBCUtil.commitTransaction();
            
        } catch (SQLException ex) {
            throw new AcessoRepositorioException(ex.getMessage());
        } finally {
            JDBCUtil.fechaRecursos(stmt, null);
        }
    }

}
