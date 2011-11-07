/*
 * Grupo: Miguel Amaral
 *        Ethan Rafael
 *        Diego Henrique
 *        Davyson Costa
 */

package negocio;

import java.util.List;

/**
 *
 * @author aluno
 */
public class Doctor extends User {

    private String crm;
    private List<Service> servico;

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public List<Service> getServico() {
        return servico;
    }

    public void setServico(List<Service> servico) {
        this.servico = servico;
    }

}
