/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import estructuras.Arbol;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.*;

import estructuras.Nodo;
import gestores.GestorMaterial;
import static interfaces.Inicial.panelprincipal;
import java.awt.BorderLayout;
import modelo.productos.MaterialCapacitacion;
import modelo.productos.TipoNodo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author juliansanchez
 */
public class generarArbol extends javax.swing.JPanel {

    private String titulo;
    private String tipo;
    private Arbol arbol;
    private Nodo seleccionado;
    /**
     * Creates new form generarArbol
     */
    public generarArbol(String tipo, String titulo, Integer id) {
        initComponents();
        this.tipo = tipo;
        this.titulo = titulo;


        MaterialCapacitacion material = GestorMaterial.biblioteca.buscarPorId(id);
        if(material.getArbol() == null){
            arbol = new Arbol(TipoNodo.TITULO,titulo);
            material.setArbol(arbol);
        }
        else arbol = material.getArbol();
        
        arbolTree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
        arbolTree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) arbolTree.getLastSelectedPathComponent();;
                /* if nothing is selected */
                if (node == null) return;

                /* retrieve the node that was selected */
                Object nodeInfo = node.getUserObject();

                /* React to the node selection. */

                agregarButton.setEnabled(true);
                tipoCombo.setEnabled(true);
                contenidoText.setEnabled(true);

                //arbolTree.setModel(new DefaultTreeModel(node));
                //for(Object obj:node.getUserObjectPath()) System.out.println(obj.toString());

                seleccionado =obtenerNodo(arbol,new ArrayList<>(Arrays.asList(node.getUserObjectPath())));
                tipoCombo.setModel(new DefaultComboBoxModel(seleccionado.getPosiblesHijos().toArray()));
                detallesText.setText(seleccionado.toString()+"\nContenido: "+seleccionado.getValor());

            }
        });
        imprimirArbol();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        tipoCombo = new javax.swing.JComboBox<>();
        agregarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        arbolTree = new javax.swing.JTree();
        jScrollPane5 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        contenidoText = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        detallesText = new javax.swing.JTextArea();
        Salir = new javax.swing.JButton();

        agregarButton.setText("Agregar");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Crear Arbol de Contenido");

        jLabel2.setText("Tipo de Nodo");

        jLabel3.setText("Contenido");

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        arbolTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane1.setViewportView(arbolTree);

        jScrollPane4.setViewportView(jScrollPane1);

        contenidoText.setColumns(20);
        contenidoText.setRows(5);
        jScrollPane2.setViewportView(contenidoText);

        jScrollPane5.setViewportView(jScrollPane2);

        detallesText.setEditable(false);
        detallesText.setColumns(20);
        detallesText.setRows(5);
        jScrollPane3.setViewportView(detallesText);

        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(agregarButton)
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Salir))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(tipoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(Salir))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tipoCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(agregarButton))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarButtonActionPerformed
        // TODO add your handling code here:
        if(seleccionado != null) seleccionado.agregarHijo(new Arbol(TipoNodo.valueOf(tipoCombo.getSelectedItem().toString()),contenidoText.getText()));
        imprimirArbol();
    }//GEN-LAST:event_agregarButtonActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        // TODO add your handling code here:
        buscar b = new buscar();
        b.setSize(800, 400);
        b.setLocation(5, 5);
        
        panelprincipal.removeAll();
        panelprincipal.add(b, BorderLayout.CENTER);
        panelprincipal.revalidate();
        panelprincipal.repaint();
    }//GEN-LAST:event_SalirActionPerformed

    private void imprimirArbol(){
        agregarButton.setEnabled(false);
        tipoCombo.setEnabled(false);
        contenidoText.setEnabled(false);
        contenidoText.setText("");

        arbolTree.setModel(new DefaultTreeModel(generarModeloArbol(arbol)));


    }
    
    private DefaultMutableTreeNode generarModeloArbol(Arbol arbol){
        DefaultMutableTreeNode modelo = new DefaultMutableTreeNode(arbol.raiz.toString());

        arbol.raiz.getHijos().forEach((subArbol) -> {
            modelo.add(generarModeloArbol(subArbol));
        });
        return modelo;
    }

    private Nodo obtenerNodo(Arbol a,ArrayList<Object> paths){

        if(a.raiz.toString().equals(paths.get(0))){
            if(paths.size()==1) return a.raiz;
            else {
                paths.remove(0);
                for(Arbol hijo:a.raiz.getHijos()){
                    Nodo nodo = obtenerNodo(hijo, (ArrayList<Object>) paths.clone());
                    if(nodo!=null) return nodo;
                }
            }
        }
        return null;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Salir;
    private javax.swing.JButton agregarButton;
    private javax.swing.JTree arbolTree;
    private javax.swing.JTextArea contenidoText;
    private javax.swing.JTextArea detallesText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JComboBox<String> tipoCombo;
    // End of variables declaration//GEN-END:variables
}
