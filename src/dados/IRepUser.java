/*
* Grupo: Miguel Amaral
 *        Ethan Rafael
 *        Diego Henrique
 *        Davyson Costa
 */
package dados;

import exception.AcessoRepositorioException;
import negocio.User;

/**
 *
 * @author miguel
 */
public interface IRepUser {
    
    public void insert(User user) throws AcessoRepositorioException;
    
    /*
    public void remove(User user) throws AcessoRepositorioException;
    
    public void update(User user) throws AcessoRepositorioException;
    
    public User get(int id) throws AcessoRepositorioException;
    
    public List<User>getAll() throws AcessoRepositorioException;
    */
}
