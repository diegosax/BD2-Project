/*
 * Grupo: Miguel Amaral
 *        Ethan Rafael
 *        Diego Henrique
 *        Davyson Costa
 */

package negocio;

/**
 *
 * @author aluno
 */
public class User {

    private int id;
    private String name;
    private String email;
    private char[] password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

}
