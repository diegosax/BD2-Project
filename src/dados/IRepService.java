/*
 * Grupo: Miguel Amaral
 *        Ethan Rafael
 *        Diego Henrique
 *        Davyson Costa
 */
package dados;

import exception.AcessoRepositorioException;
import java.util.List;
import negocio.Doctor;
import negocio.Service;

/**
 *
 * @author miguel
 */
public interface IRepService {
    
    public void insert(Service service) throws AcessoRepositorioException;
    
    /*
    public void remove(Service service) throws AcessoRepositorioException;
    
    public void update(Service service) throws AcessoRepositorioException;
    
    public Service get(int id) throws AcessoRepositorioException;
    
    *
    */
    public List<Service>getAll() throws AcessoRepositorioException;
    
    public List<Service>get(Doctor d) throws AcessoRepositorioException;
    
}
