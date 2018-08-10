/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import gestores.GestorMaterial;
import modelo.BibliotecaList;
import modelo.Usuario;
import modelo.productos.MaterialCapacitacion;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import static interfaces.Inicial.panelprincipal;
import java.awt.BorderLayout;

/**
 *
 * @author Alexis Mandracchia
 */
public class wishList extends javax.swing.JPanel {

    /**
     * Creates new form crear
     */
    public wishList() {
        initComponents();

        Object[] row = new Object[5];
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        Object[] materialArray = Usuario.getWishList().toArray();

        for(Object material:materialArray){

            row[0] = ((MaterialCapacitacion) material).getTitulo();
            row[1] = ((MaterialCapacitacion) material).getCalificacion();
            row[2] = ((MaterialCapacitacion) material).precio();
            row[3] = ((MaterialCapacitacion) material).getFecha_publicacion();
            row[4] = ((MaterialCapacitacion) material).getRelevancia();

            modelo.addRow(row);
        }

        jTable1.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtonAsignar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(800, 400));
        setPreferredSize(new java.awt.Dimension(800, 400));
        setSize(new java.awt.Dimension(800, 400));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Título", "Calificación", "Precio", "Fecha de publicación", "Relevancia"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButtonAsignar.setText("Salir");
        jButtonAsignar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAsignarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAsignar)
                .addGap(70, 70, 70))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAsignar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAsignarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAsignarActionPerformed
        // TODO add your handling code here:
        menu m = new menu();
        m.setSize(800, 400);
        m.setLocation(5, 5);
        
        panelprincipal.removeAll();
        panelprincipal.add(m, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_jButtonAsignarActionPerformed

    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAsignar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
