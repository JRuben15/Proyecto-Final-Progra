/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

import java.awt.event.ActionListener;

/**
 *
 * @author Rubén Delgado C
 */
public class PanelBotones extends javax.swing.JPanel {

    /**
     * Creates new form PanelBotones
     */
    public PanelBotones() {
        initComponents();
    }
    
    public void escuchadorBotones(ActionListener manejador) {
        jBTNCrear.addActionListener(manejador);
        jBTNModificar.addActionListener(manejador);
        jBTNConsultar.addActionListener(manejador);
        jBTNEliminar.addActionListener(manejador);
        jBTNSalir.addActionListener(manejador);
    }
    
    /*
    public void activarBotones(boolean estado) {
        this.jBEditar.setEnabled(estado);
        this.jBEliminar.setEnabled(estado);
    }//Fin Metodo Activar Botones
    */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jBTNCrear = new javax.swing.JButton();
        jBTNConsultar = new javax.swing.JButton();
        jBTNModificar = new javax.swing.JButton();
        jBTNEliminar = new javax.swing.JButton();
        jBTNSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(204, 255, 204));

        jBTNCrear.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBTNCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/crear.png"))); // NOI18N
        jBTNCrear.setText("Crear");

        jBTNConsultar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBTNConsultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/consultar.png"))); // NOI18N
        jBTNConsultar.setText("Consultar");

        jBTNModificar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBTNModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/editar.png"))); // NOI18N
        jBTNModificar.setText("Modificar");

        jBTNEliminar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBTNEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eliminar.png"))); // NOI18N
        jBTNEliminar.setText("Eliminar");

        jBTNSalir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jBTNSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/salir.png"))); // NOI18N
        jBTNSalir.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBTNCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBTNModificar, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jBTNSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBTNConsultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBTNEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jBTNCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBTNConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBTNModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBTNEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jBTNSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTNConsultar;
    private javax.swing.JButton jBTNCrear;
    private javax.swing.JButton jBTNEliminar;
    private javax.swing.JButton jBTNModificar;
    private javax.swing.JButton jBTNSalir;
    // End of variables declaration//GEN-END:variables
}