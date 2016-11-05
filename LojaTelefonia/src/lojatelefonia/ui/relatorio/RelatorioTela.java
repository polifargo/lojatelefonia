package lojatelefonia.ui.relatorio;

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
import lojatelefonia.ui.atributos.Relatorio;

public class RelatorioTela extends javax.swing.JInternalFrame {

    public RelatorioTela() {
        initComponents();
        mostrarListaRelatorio();
    }

    public ArrayList<Relatorio> getListaRelatorio() {
        ArrayList<Relatorio> listaRelatorio = new ArrayList<Relatorio>();
        Connection connection = null;
        connection = ConnectionUtils.getConnection();

        String query = "SELECT * FROM relatorio";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Relatorio relatorio;
            while (rs.next()) {
                relatorio = new Relatorio(rs.getInt("id_venda"), rs.getDouble("valor_total"), rs.getInt("qtd_items"),
                        rs.getString("cliente"));
                listaRelatorio.add(relatorio);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaRelatorio;
    }

    //Mostrar dados na tabela
    public void mostrarListaRelatorio() {
        ArrayList<Relatorio> lista = getListaRelatorio();
        DefaultTableModel model = (DefaultTableModel) jTableRelatorio.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < lista.size(); i++) {
            row[0] = lista.get(i).getIdvenda();
            row[1] = lista.get(i).getValorfinal();
            row[2] = lista.get(i).getQtd();
            row[3] = lista.get(i).getCliente();
            model.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRelatorio = new javax.swing.JTable();
        buttonDelete = new javax.swing.JButton();
        txtRelatorioID = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Relatório de Vendas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jTableRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Venda", "Valor Total", "Quantidade de Items", "Cliente"
            }
        ));
        jTableRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRelatorioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRelatorio);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );

        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatelefonia/ui/image/remove-icon-png-252.png"))); // NOI18N
        buttonDelete.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        txtRelatorioID.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("ID:");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lojatelefonia/ui/image/lupa_Vector_Clipart.png"))); // NOI18N
        jLabel1.setText("Filtro:");

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRelatorioID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonDelete)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonDelete)
                    .addComponent(txtRelatorioID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        if (jTableRelatorio.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum cliente selecionado.",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String query = "DELETE FROM relatorio WHERE id = " + txtRelatorioID.getText();
            executarQuery(query, "Deletado");
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed

    private void jTableRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRelatorioMouseClicked
        int i = jTableRelatorio.getSelectedRow();
        TableModel model = jTableRelatorio.getModel();
        txtRelatorioID.setText(model.getValueAt(i, 0).toString());
    }//GEN-LAST:event_jTableRelatorioMouseClicked

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        TableRowSorter sorter = null;
        DefaultTableModel model = (DefaultTableModel) jTableRelatorio.getModel();
        sorter = new TableRowSorter<TableModel>(model);
        jTableRelatorio.setRowSorter(sorter);
        String text = txtPesquisa.getText();
        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
        }
    }//GEN-LAST:event_txtPesquisaKeyReleased

    public void executarQuery(String query, String message) {
        Connection connection = null;
        connection = ConnectionUtils.getConnection();
        Statement st;
        try {
            st = connection.createStatement();
            if (st.executeUpdate(query) == 1) {
                //refresh
                DefaultTableModel model = (DefaultTableModel) jTableRelatorio.getModel();
                model.setRowCount(0);
                mostrarListaRelatorio();

                JOptionPane.showMessageDialog(null, "Data " + message + " sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Data " + message + " falhou!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRelatorio;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JLabel txtRelatorioID;
    // End of variables declaration//GEN-END:variables
}
