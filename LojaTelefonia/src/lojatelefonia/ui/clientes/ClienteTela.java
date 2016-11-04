package lojatelefonia.ui.clientes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import lojatelefonia.db.utils.ConnectionUtils;
import lojatelefonia.ui.atributos.Cliente;

/**
 *
 * @author Matheus
 */
public class ClienteTela extends javax.swing.JInternalFrame {

    /**
     * Creates new form ClienteInfo
     */
    public ClienteTela() {
        initComponents();
        mostrarListaCliente();
    }

    //Testar conexao com o banco de dados
    //Pegar tabela de clientes
    public ArrayList<Cliente> getListaClientes() {
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
        Connection connection = null;
        connection = ConnectionUtils.getConnection();

        String query = "SELECT * FROM clientes";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Cliente cliente;
            while (rs.next()) {
                cliente = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("nascimento"),
                        rs.getString("telefone"), rs.getString("cpf"));
                listaClientes.add(cliente);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaClientes;
    }

    //Mostrar dados na tabela
    public void mostrarListaCliente() {
        ArrayList<Cliente> lista = getListaClientes();
        DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            row[0] = lista.get(i).getId();
            row[1] = lista.get(i).getNome();
            row[2] = lista.get(i).getNasc();
            row[3] = lista.get(i).getTelefone();
            row[4] = lista.get(i).getCpf();

            model.addRow(row);
        }
    }

    // EXECUTAR SQL QUERY
    public void executarQuery(String query, String message) {
        Connection connection = null;
        connection = ConnectionUtils.getConnection();
        Statement st;
        try {
            st = connection.createStatement();
            if (st.executeUpdate(query) == 1) {
                //refresh
                DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
                model.setRowCount(0);
                mostrarListaCliente();

                JOptionPane.showMessageDialog(null, "Data " + message + " sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Data " + message + " falhou!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        clienteTabela = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        buttonDelete = new javax.swing.JButton();
        txtPesquisa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        clienteInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonUpdate = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtClienteNasc = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        txtClienteID = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtClienteNome = new javax.swing.JTextField();
        fTxtClienteCPF = new javax.swing.JFormattedTextField();
        buttonInserir = new javax.swing.JButton();
        txtClienteTel = new javax.swing.JFormattedTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Sistema Loja Clientes");
        setPreferredSize(new java.awt.Dimension(900, 590));

        clienteTabela.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Tabela de Clientes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Data de Nascimento", "Telefone", "CPF"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableClientes);

        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatelefonia/ui/image/remove-icon-png-252.png"))); // NOI18N
        buttonDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatelefonia/ui/image/lupa_Vector_Clipart.png"))); // NOI18N
        jLabel6.setText("Filtro:");

        javax.swing.GroupLayout clienteTabelaLayout = new javax.swing.GroupLayout(clienteTabela);
        clienteTabela.setLayout(clienteTabelaLayout);
        clienteTabelaLayout.setHorizontalGroup(
            clienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clienteTabelaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(clienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(clienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, clienteTabelaLayout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtPesquisa))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        clienteTabelaLayout.setVerticalGroup(
            clienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clienteTabelaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(clienteTabelaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonDelete)
                .addGap(5, 5, 5))
        );

        clienteInfo.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Informações do Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("ID:");

        buttonUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatelefonia/ui/image/refresh-double-rounded-flat-200x200.png"))); // NOI18N
        buttonUpdate.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Data de Nascimento:");

        txtClienteNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("d/M/yyyy"))));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Telefone:");

        txtClienteID.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("CPF:");

        fTxtClienteCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        fTxtClienteCPF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fTxtClienteCPFKeyTyped(evt);
            }
        });

        buttonInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatelefonia/ui/image/Button-Add-icon2.png"))); // NOI18N
        buttonInserir.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInserirActionPerformed(evt);
            }
        });

        txtClienteTel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtClienteTelKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout clienteInfoLayout = new javax.swing.GroupLayout(clienteInfo);
        clienteInfo.setLayout(clienteInfoLayout);
        clienteInfoLayout.setHorizontalGroup(
            clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(clienteInfoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(clienteInfoLayout.createSequentialGroup()
                        .addComponent(txtClienteNome)
                        .addGap(15, 15, 15))
                    .addGroup(clienteInfoLayout.createSequentialGroup()
                        .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fTxtClienteCPF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtClienteNasc)
                            .addComponent(txtClienteID, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtClienteTel, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGap(0, 84, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clienteInfoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonInserir)
                .addGap(7, 7, 7)
                .addComponent(buttonUpdate)
                .addGap(14, 14, 14))
        );

        clienteInfoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonInserir, buttonUpdate});

        clienteInfoLayout.setVerticalGroup(
            clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, clienteInfoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtClienteID, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtClienteNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtClienteNasc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtClienteTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fTxtClienteCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(clienteInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonInserir)
                    .addComponent(buttonUpdate))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        clienteInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {fTxtClienteCPF, txtClienteNasc, txtClienteNome});

        clienteInfoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonInserir, buttonUpdate});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clienteInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clienteTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clienteTabela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clienteInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Pegar informacoes da tabela com o clique
    private void jTableClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClientesMouseClicked
        // Mostrar linha selecionada no JTextField
        int i = jTableClientes.getSelectedRow();
        TableModel model = jTableClientes.getModel();
        txtClienteID.setText(model.getValueAt(i, 0).toString());
        txtClienteNome.setText(model.getValueAt(i, 1).toString());
        txtClienteNasc.setText(model.getValueAt(i, 2).toString());
        txtClienteTel.setText(model.getValueAt(i, 3).toString());
        fTxtClienteCPF.setText(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_jTableClientesMouseClicked

    //Deletar item da tabela
    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        if (jTableClientes.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum cliente selecionado.",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String query = "DELETE FROM clientes WHERE id = " + txtClienteID.getText();
            executarQuery(query, "Deletado");
            txtClienteID.setText("");
            txtClienteNome.setText("");
            txtClienteNasc.setText("");
            txtClienteTel.setText("");
            fTxtClienteCPF.setText("");
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    //Pesquisar item na tabela
    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        // TODO add your handling code here:
        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) jTableClientes.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        jTableClientes.setRowSorter(sorter);
        String text = txtPesquisa.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

    //Inserir item na tabela
    private void buttonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInserirActionPerformed
        if (txtClienteNome.getText().equals("") || txtClienteNasc.getText().equals("")
                || txtClienteTel.getText().equals("") || fTxtClienteCPF.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Os campos não podem ficar em branco.",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String query = "INSERT INTO clientes(nome,nascimento,telefone,cpf) VALUES ('"
                    + txtClienteNome.getText() + "',"
                    + "'" + txtClienteNasc.getText() + "',"
                    + "'" + txtClienteTel.getText() + "',"
                    + "'" + fTxtClienteCPF.getText()
                    + "')";
            executarQuery(query, "Inserido");
        }
    }//GEN-LAST:event_buttonInserirActionPerformed

    //CPF apenas 11 caracteres
    private void fTxtClienteCPFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fTxtClienteCPFKeyTyped
        if (fTxtClienteCPF.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_fTxtClienteCPFKeyTyped

    //Atualizar item da tabela
    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        if (txtClienteNome.getText().equals("") || txtClienteNasc.getText().equals("")
                || txtClienteTel.getText().equals("") || fTxtClienteCPF.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Os campos não podem ficar em branco.",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        } else {
            String query = "UPDATE clientes SET nome = '" + txtClienteNome.getText() + "',"
                    + "nascimento = '" + txtClienteNasc.getText() + "',"
                    + "telefone = '" + txtClienteTel.getText() + "',"
                    + "cpf = '" + fTxtClienteCPF.getText() + "' WHERE id = " + txtClienteID.getText();
            executarQuery(query, "Atualizado");
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    //Telefone apenas 11 caracteres
    private void txtClienteTelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClienteTelKeyPressed
        // TODO add your handling code here:
        if (txtClienteTel.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_txtClienteTelKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonInserir;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JPanel clienteInfo;
    private javax.swing.JPanel clienteTabela;
    private javax.swing.JFormattedTextField fTxtClienteCPF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JLabel txtClienteID;
    private javax.swing.JFormattedTextField txtClienteNasc;
    private javax.swing.JTextField txtClienteNome;
    private javax.swing.JFormattedTextField txtClienteTel;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
