package Pantallas;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import src.ClientePref;
import javax.swing.table.DefaultTableModel;

// @author Jhony_Angulo
public class P_Clientes extends javax.swing.JFrame {

    public P_Clientes() {
        initComponents();
        setLocationRelativeTo(null);
        //super.setSize(768, 655);

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
        panel_CP = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_Nombre = new javax.swing.JTextField();
        Doc = new javax.swing.JLabel();
        txt_cc = new javax.swing.JTextField();
        Tel = new javax.swing.JLabel();
        txt_tel = new javax.swing.JTextField();
        btn_Guardar = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        Email = new javax.swing.JLabel();
        txt_mail = new javax.swing.JTextField();
        tipoDoc = new javax.swing.JLabel();
        txt_tipo = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        gridClientes = new javax.swing.JTable();
        buscar = new javax.swing.JLabel();
        txt_buscar = new javax.swing.JTextField();
        btn_Buscar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CLIENTES PREFERENCIALES");

        panel_CP.setBackground(new java.awt.Color(51, 51, 51));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 0)));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("CLIENTES PREFERENCIALES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(229, 229, 229)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("Nombre: *");

        txt_Nombre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        Doc.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Doc.setForeground(new java.awt.Color(255, 204, 0));
        Doc.setText("Documento: *");

        txt_cc.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        Tel.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Tel.setForeground(new java.awt.Color(255, 204, 0));
        Tel.setText("Teléfono: *");

        txt_tel.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btn_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantallas/Images/Btn_Guardar.png"))); // NOI18N
        btn_Guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Guardar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_GuardarMouseMoved(evt);
            }
        });
        btn_Guardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_GuardarMouseExited(evt);
            }
        });
        btn_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_GuardarActionPerformed(evt);
            }
        });

        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantallas/Images/Btn_Cancelar.png"))); // NOI18N
        btn_Cancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Cancelar.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                btn_CancelarHierarchyChanged(evt);
            }
        });
        btn_Cancelar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_CancelarMouseMoved(evt);
            }
        });
        btn_Cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_CancelarMouseExited(evt);
            }
        });
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });

        Email.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        Email.setForeground(new java.awt.Color(255, 204, 0));
        Email.setText("Email:");

        txt_mail.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        tipoDoc.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        tipoDoc.setForeground(new java.awt.Color(255, 204, 0));
        tipoDoc.setText("Tipo: *");

        txt_tipo.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        txt_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Cédula Ciudadanía", "Cédula Extranjería", "Pasaporte" }));

        gridClientes.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        gridClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Tipo Documento", "N° Documento", "Teléfono", "Email", "Hospedajes"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(gridClientes);

        buscar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        buscar.setForeground(new java.awt.Color(255, 204, 0));
        buscar.setText("Documento");

        txt_buscar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantallas/Images/Btn_Buscar.png"))); // NOI18N
        btn_Buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Buscar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btn_BuscarMouseMoved(evt);
            }
        });
        btn_Buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_BuscarMouseExited(evt);
            }
        });
        btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_BuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_CPLayout = new javax.swing.GroupLayout(panel_CP);
        panel_CP.setLayout(panel_CPLayout);
        panel_CPLayout.setHorizontalGroup(
            panel_CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel_CPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(btn_Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(191, 191, 191))
            .addGroup(panel_CPLayout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addGroup(panel_CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_CPLayout.createSequentialGroup()
                        .addGroup(panel_CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Tel, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(panel_CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Doc, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_cc, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panel_CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel_CPLayout.createSequentialGroup()
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        panel_CPLayout.setVerticalGroup(
            panel_CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_CPLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Doc, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_cc))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panel_CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel_CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(panel_CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panel_CPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Guardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Cancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_CP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_CP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_GuardarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GuardarMouseMoved
        btn_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantallas/Images/Btn_Guardar2.png")));
    }//GEN-LAST:event_btn_GuardarMouseMoved

    private void btn_GuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_GuardarMouseExited
        btn_Guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantallas/Images/Btn_Guardar.png")));
    }//GEN-LAST:event_btn_GuardarMouseExited

    private void btn_CancelarHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_btn_CancelarHierarchyChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_CancelarHierarchyChanged

    private void btn_CancelarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CancelarMouseMoved
        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantallas/Images/Btn_Cancelar2.png")));
    }//GEN-LAST:event_btn_CancelarMouseMoved

    private void btn_CancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_CancelarMouseExited
        btn_Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantallas/Images/Btn_Cancelar.png")));
    }//GEN-LAST:event_btn_CancelarMouseExited

    private void btn_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_GuardarActionPerformed
        if (txt_cc.getText().length() == 0 || txt_Nombre.getText().length() == 0 || txt_tel.getText().length() == 0 || txt_tipo.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Hay campos obligatorios vacíos, por favor verifique antes de guardar", "ALERTA", 0);
        } else {
            ClientePref cf = new ClientePref();
            boolean insertar = cf.validarExistencia(txt_cc.getText());
            if (insertar == true) {
                int opc = cf.crearClientePref(txt_Nombre.getText(), txt_tipo.getSelectedIndex(), txt_cc.getText(), Integer.parseInt(txt_tel.getText()), txt_mail.getText());
                if (opc == 0) {
                    limpiarCampos();
                    mostrarClientes();
                } else {
                    this.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Ya existe un cliente con el documento " + txt_cc.getText() + " por favor verifique", "ALERTA", 0);
            }

            /*if (txt_mail.getText().length() != 0) {
            if (txt_mail.getText().indexOf("@") == -1) {
                ClientePref cf = new ClientePref();
                cf.crearClientePref(txt_Nombre.getText(), txt_tipo.getSelectedIndex(), Integer.parseInt(txt_cc.getText()), Integer.parseInt(txt_tel.getText()), txt_mail.getText());
            } else {
                JOptionPane.showMessageDialog(null, "El campo Email no tiene una estructura adecuada, verifique", "ALERTA", 0);
            }*/
        }
    }//GEN-LAST:event_btn_GuardarActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed
        if (txt_cc.getText().length() != 0 || txt_Nombre.getText().length() != 0 || txt_tel.getText().length() != 0 || txt_tipo.getSelectedIndex() != 0 || txt_mail.getText().length() != 0) {
            int opc = JOptionPane.showConfirmDialog(null, "Si continúa perderá los datos \n¿Está seguro que desea continuar?", "ALERTA", 0, 2);
            if (opc == 0) {
                this.dispose();
            }
        } else {
            this.dispose();
        }
    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_BuscarMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BuscarMouseMoved
        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantallas/Images/Btn_Buscar2.png")));
    }//GEN-LAST:event_btn_BuscarMouseMoved

    private void btn_BuscarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_BuscarMouseExited
        btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pantallas/Images/Btn_Buscar.png")));
    }//GEN-LAST:event_btn_BuscarMouseExited

    private void btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_BuscarActionPerformed
        buscarClientes();
    }//GEN-LAST:event_btn_BuscarActionPerformed

    public void limpiarCampos() {
        JPanel panel = this.panel_CP;
        for (int i = 0; panel.getComponents().length > i; i++) {
            if (panel.getComponents()[i] instanceof JTextField) {
                ((JTextField) panel.getComponents()[i]).setText(null);
            } else if (panel.getComponents()[i] instanceof JComboBox) {
                ((JComboBox) panel.getComponents()[i]).setSelectedIndex(0);
            }
        }
    }

    public void mostrarClientes() {
        DefaultTableModel modelo = new DefaultTableModel();
        ClientePref cp = new ClientePref();
        modelo = cp.mostrarClientes();
        gridClientes.setModel(modelo);
        gridClientes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        gridClientes.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    }

    public void buscarClientes() {
        DefaultTableModel modelo = new DefaultTableModel();
        ClientePref cp = new ClientePref();
        int cc = Integer.parseInt(txt_cc.getText());
        modelo = cp.buscarCliente(123);
        gridClientes.setModel(modelo);
        gridClientes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        gridClientes.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Doc;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Tel;
    private javax.swing.JButton btn_Buscar;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_Guardar;
    private javax.swing.JLabel buscar;
    private javax.swing.JTable gridClientes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    public javax.swing.JPanel panel_CP;
    private javax.swing.JLabel tipoDoc;
    private javax.swing.JTextField txt_Nombre;
    private javax.swing.JTextField txt_buscar;
    private javax.swing.JTextField txt_cc;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_tel;
    private javax.swing.JComboBox<String> txt_tipo;
    // End of variables declaration//GEN-END:variables
}
