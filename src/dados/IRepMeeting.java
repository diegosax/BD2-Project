/*
* Grupo: Miguel Amaral
 *        Ethan Rafael
 *        Diego Henrique
 *        Davyson Costa
 */
package dados;

import exception.AcessoRepositorioException;
import java.util.List;
import negocio.Meeting;

/**
 *
 * @author miguel
 */
public interface IRepMeeting {
    
    public void insert(Meeting meeting) throws AcessoRepositorioException;
    
    public void remove(Meeting meeting) throws AcessoRepositorioException;
    
    public void update(Meeting meeting) throws AcessoRepositorioException;
    
    public Meeting get(int id) throws AcessoRepositorioException;
    
    public List<Meeting>getAll() throws AcessoRepositorioException;
    
}
