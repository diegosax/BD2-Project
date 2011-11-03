/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package negocio;

import java.util.Calendar;

/**
 *
 * @author aluno
 */
public class Meeting {

    private int id;
    private Calendar scheduledDate;
    private Calendar attendedDate;
    private Client client;
    private Doctor doctor;
    private Service service;
    private String notes;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Calendar scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Calendar getAttendedDate() {
        return attendedDate;
    }

    public void setAttendedDate(Calendar attendedDate) {
        this.attendedDate = attendedDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

}
