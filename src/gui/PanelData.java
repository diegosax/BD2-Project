/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelData.java
 *
 * Created on 15/02/2011, 05:40:32
 */
package gui;

import java.awt.BorderLayout;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.jdesktop.swingx.JXDatePicker;

/**
 *
 * @author Miguel
 */
public class PanelData extends javax.swing.JPanel {

    private JXDatePicker datePicker;

    /** Creates new form PanelData */
    public PanelData() {
        datePicker = new JXDatePicker(new Date());
        initComponents();
        panel.setLayout(new BorderLayout());
        panel.add(datePicker, BorderLayout.CENTER);
        this.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 192, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the datePicker
     */
    public JXDatePicker getDatePicker() {
        return datePicker;
    }

    public Date getData (){
        return getDatePicker().getDate();
    }

    /**
     * @param datePicker the datePicker to set
     */
    public void setDatePicker(JXDatePicker datePicker) {
        this.datePicker = datePicker;
    }

    /**
     * @return the panel
     */
    public javax.swing.JPanel getPanel() {
        return panel;
    }

    /**
     * @param panel the panel to set
     */
    public void setPanel(javax.swing.JPanel panel) {
        this.panel = panel;
    }

    public Calendar getCalendar(){
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(this.getData());
        return gc;
    }
}