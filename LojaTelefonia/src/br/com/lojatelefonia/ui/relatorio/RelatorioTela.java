package br.com.lojatelefonia.ui.relatorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import br.com.lojatelefonia.db.utils.ConnectionUtils;
import br.com.lojatelefonia.modelo.Relatorio;

public class RelatorioTela extends javax.swing.JInternalFrame {

    SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy");
    GregorianCalendar gc = new GregorianCalendar();

    public RelatorioTela() {
        initComponents();
        String data = formatarDate.format(gc.getTime());
        dataRelatorio.setText(data);
        mostrarListaRelatorio();
    }

    public ArrayList<Relatorio> getListaRelatorio() {
        ArrayList<Relatorio> listaRelatorio = new ArrayList<Relatorio>();
        Connection connection = null;
        connection = ConnectionUtils.getConnection();

        String query = "SELECT * FROM RELATORIO "
                + "WHERE DATA_VENDA = '" + dataRelatorio.getText() + "'";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            Relatorio relatorio;
            while (rs.next()) {
                relatorio = new Relatorio(rs.getInt("id_venda"), rs.getDouble("valor_total"), rs.getInt("qtd_items"),
                        rs.getString("cliente"), rs.getString("data_venda"));
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
        Object[] row = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            row[0] = lista.get(i).getIdvenda();
            row[1] = lista.get(i).getValorfinal();
            row[2] = lista.get(i).getQtd();
            row[3] = lista.get(i).getCliente();
            row[4] = lista.get(i).getDataVenda();
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
        buttonVoltar = new javax.swing.JButton();
        buttonAvancar = new javax.swing.JButton();
        dataRelatorio = new javax.swing.JLabel();
        buttonInfo = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Relatório Mensal");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), "Relatório de Vendas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jTableRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Venda", "Valor Total", "Quantidade de Items", "Cliente", "Data da Venda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
        );

        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/excluir.png"))); // NOI18N
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
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/filtroBuscar.png"))); // NOI18N
        jLabel1.setText("Filtro:");

        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });

        buttonVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/backwardsArrow.png"))); // NOI18N
        buttonVoltar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVoltarActionPerformed(evt);
            }
        });

        buttonAvancar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/image/forwardArrow.png"))); // NOI18N
        buttonAvancar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonAvancar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAvancarActionPerformed(evt);
            }
        });

        dataRelatorio.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        buttonInfo.setText("Informações");
        buttonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRelatorioID, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dataRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buttonAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(buttonDelete))
                            .addComponent(buttonInfo))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buttonAvancar, buttonVoltar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRelatorioID, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(buttonVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(dataRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(buttonDelete, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(buttonAvancar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonInfo)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonAvancar, buttonVoltar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        if (jTableRelatorio.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum relatório selecionado.",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            String query = "DELETE FROM relatorio WHERE id_venda = " + txtRelatorioID.getText();
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

    private void buttonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonVoltarActionPerformed
        gc.add(gc.DAY_OF_MONTH, -1);
        String data = formatarDate.format(gc.getTime());
        dataRelatorio.setText(data);
        //refresh
        DefaultTableModel model = (DefaultTableModel) jTableRelatorio.getModel();
        model.setRowCount(0);
        mostrarListaRelatorio();
    }//GEN-LAST:event_buttonVoltarActionPerformed

    private void buttonAvancarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAvancarActionPerformed
        gc.add(gc.DAY_OF_MONTH, 1);
        String data = formatarDate.format(gc.getTime());
        dataRelatorio.setText(data);
        //refreshs
        DefaultTableModel model = (DefaultTableModel) jTableRelatorio.getModel();
        model.setRowCount(0);
        mostrarListaRelatorio();
    }//GEN-LAST:event_buttonAvancarActionPerformed

    private void buttonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInfoActionPerformed
        int i = jTableRelatorio.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(this,
                    "Nenhum relatório selecionado.",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            RelatorioInfoTela frame = new RelatorioInfoTela();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }
    }//GEN-LAST:event_buttonInfoActionPerformed

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

                JOptionPane.showMessageDialog(null, "Relatório " + message + " com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Relatório não pode ser deletado!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAvancar;
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonInfo;
    private javax.swing.JButton buttonVoltar;
    private javax.swing.JLabel dataRelatorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRelatorio;
    private javax.swing.JTextField txtPesquisa;
    private javax.swing.JLabel txtRelatorioID;
    // End of variables declaration//GEN-END:variables
}
