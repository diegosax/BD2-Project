/*
 * Grupo: Miguel Amaral
 *        Ethan Rafael
 *        Diego Henrique
 *        Davyson Costa
 */
package negocio;

import dados.IRepMeeting;
import exception.AcessoRepositorioException;

/**
 *
 * @author miguel
 */
public class MeetingController {
    
    private IRepMeeting meetings;
    
    public MeetingController(IRepMeeting meetings){
        this.meetings = meetings;
    }
    
    public void insert (Meeting meeting) throws AcessoRepositorioException{
        this.meetings.insert(meeting);
    }
    
}
