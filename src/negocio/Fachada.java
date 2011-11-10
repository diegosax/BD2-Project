/*
 * Grupo: Miguel Amaral
 *        Ethan Rafael
 *        Diego Henrique
 *        Davyson Costa
 */
package negocio;

import dados.*;
import exception.AcessoRepositorioException;
import java.util.List;

/**
 *
 * @author miguel
 */
public class Fachada {
    
    private static Fachada fachada;
    
    private MeetingController meetings;
    private ServiceController services;
    private UserController users;
    
    private Fachada(){
        //JDBCUtil.abreConn();
        
        IRepUser repUsers = new RepUserJDBC();
        IRepMeeting repMeetings = new RepMeetingJDBC();
        IRepService repServices = new RepServiceJDBC();
        
        this.meetings = new MeetingController(repMeetings);
        this.users = new UserController(repUsers);
        this.services = new ServiceController(repServices);
    }
    
    public static Fachada getFachada(){
        if (fachada == null){
            fachada = new Fachada();
        }
        return fachada;
    }
    
    /********* USERS ***********/
    
    public void insert(User user) throws AcessoRepositorioException{
        this.users.insert(user);
    }
    /*
    public void remove (User user) throws AcessoRepositorioException{
        this.users.remove(user);
    }
    
    public void update (User user) throws AcessoRepositorioException{
        this.users.update(user);
    }
    
    public User getUser(int id) throws AcessoRepositorioException{
        return this.users.get(id);
    }
    */
    
    public List<User> getAllUsers() throws AcessoRepositorioException{
        return this.users.getAll();
    }
    /********* MEETINGS ***********/
    
    public void insert(Meeting meeting) throws AcessoRepositorioException, AcessoRepositorioException, AcessoRepositorioException, AcessoRepositorioException{
        this.meetings.insert(meeting);
    }
    /*
    public void remove (Meeting meeting) throws AcessoRepositorioException{
        this.meetings.remove(meeting);
    }
    
    public void update (Meeting meeting) throws AcessoRepositorioException{
        this.meetings.update(meeting);
    }
    
    public Meeting getMeeting(int id) throws AcessoRepositorioException{
        return this.meetings.get(id);
    }
    
    public List<Meeting> getAllMeetings() throws AcessoRepositorioException{
        return this.meetings.getAll();
    }
    * 
    */
    
    /********* SERVICES ***********/
    
    public void insert (Service service) throws AcessoRepositorioException{
        this.services.insert(service);
    }
    
    public List<Service> getAllServices() throws AcessoRepositorioException{
        return this.services.getAll();
    }
    
    public List<Service> get(Doctor d) throws AcessoRepositorioException{
        return this.services.get(d);
    }
            
    
}
