/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojatelefonia.ui.relatorio;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import lojatelefonia.db.utils.ConnectionUtils;
import lojatelefonia.ui.atributos.RelatorioInfo;

/**
 *
 * @author matheus.esanto1
 */
public class RelatorioInfoTela extends javax.swing.JInternalFrame {

    public RelatorioInfoTela() {
        initComponents();
        mostrarListaRelatorio();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableInfoRelatorio = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        idVenda = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Informações da Venda");

        jTableInfoRelatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Produto", "Quantidade", "Valor Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableInfoRelatorio);

        jLabel1.setText("ID Venda:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(idVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public ArrayList<RelatorioInfo> getListaRelatorio() {
        ArrayList<RelatorioInfo> listaRelatorio = new ArrayList<RelatorioInfo>();
        Connection connection = null;
        connection = ConnectionUtils.getConnection();

        String query = "SELECT * FROM INFORELATORIO WHERE ID_VENDA = " + Integer.parseInt(idVenda.getText());
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);
            RelatorioInfo relatorioinfo;
            while (rs.next()) {
                relatorioinfo = new RelatorioInfo(rs.getInt("id_venda"), rs.getString("produto"), rs.getInt("qtd_items"),
                        rs.getDouble("valor_total"));
                listaRelatorio.add(relatorioinfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaRelatorio;
    }

    //Mostrar dados na tabela
    public void mostrarListaRelatorio() {
        ArrayList<RelatorioInfo> lista = getListaRelatorio();
        DefaultTableModel model = (DefaultTableModel) jTableInfoRelatorio.getModel();
        Object[] row = new Object[3];
        for (int i = 0; i < lista.size(); i++) {
            row[0] = lista.get(i).getProduto();
            row[1] = lista.get(i).getQtd();
            row[2] = lista.get(i).getValor();
            model.addRow(row);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel idVenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableInfoRelatorio;
    // End of variables declaration//GEN-END:variables
}
