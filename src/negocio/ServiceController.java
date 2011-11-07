/*
 * Grupo: Miguel Amaral
 *        Ethan Rafael
 *        Diego Henrique
 *        Davyson Costa
 */
package negocio;

import dados.IRepService;
import exception.AcessoRepositorioException;
import java.util.List;

/**
 *
 * @author miguel
 */
public class ServiceController {
    
    private IRepService services;
    
    public ServiceController (IRepService services){
        this.services = services;
    }
    
    public void insert(Service service) throws AcessoRepositorioException{
        this.services.insert(service);
    }
    
    public List<Service> getAll() throws AcessoRepositorioException{
        return this.services.getAll();
    }
    
}
