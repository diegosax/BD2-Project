/*
 * Grupo: Miguel Amaral
 *        Ethan Rafael
 *        Diego Henrique
 *        Davyson Costa
 */
package negocio;

import dados.IRepUser;
import exception.AcessoRepositorioException;
import java.util.List;

/**
 *
 * @author miguel
 */
public class UserController {
    
    private IRepUser users;
    
    public UserController (IRepUser users){
        this.users = users;
    }
    
    public void insert(User user) throws AcessoRepositorioException{
        this.users.insert(user);
    }
    
    public List<User> getAll() throws AcessoRepositorioException{
        return this.users.getAll();
    }
    
}
