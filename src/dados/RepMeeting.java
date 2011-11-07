/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
package dados;

import exception.AcessoRepositorioException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import negocio.Meeting;

/**
 *
 * @author miguel
 */
public class RepMeeting implements IRepMeeting {

    public void insert(Meeting meeting) throws AcessoRepositorioException {
        try {
            Statement stmt = null; // TODO
            
            String sql = "INSERT INTO meeting(id, notes, scheduledDate, attendedDate, "
                    + "doctor_id, client_id, service_id) VALUES( "
                    + getId() + meeting.getNotes() +
                    this.getData(meeting.getScheduledDate()) +
                    this.getData(meeting.getAttendedDate()) +
                    meeting.getDoctor().getId() +
                    meeting.getClient().getId() + 
                    meeting.getService().getId() + " )";
            
            int r = stmt.executeUpdate(sql);
            
            if (r != 1){
                throw new AcessoRepositorioException("Erro ao inserir dados");
            }
            
        } catch (SQLException ex) {
            throw new AcessoRepositorioException(ex.getMessage());
        }
    }
    
    

    private String getId() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private String getData(Calendar scheduledDate) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
    
    
    
}
