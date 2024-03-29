/*
 * Grupo: Miguel Amaral
 *        Ethan Rafael
 *        Diego Henrique
 *        Davyson Costa
 */

package negocio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Service {
    
    public Service(){
        this.doctors = new ArrayList<Doctor>();
    }

    private int id;
    private String name;
    private int duration;
    private List<Doctor> doctors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
