package com.isaac.views;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.sql.SQLException;
import java.util.List;
import com.isaac.data.MovimentacaoDAO;
import com.isaac.data.ProdutoDAO;
import com.isaac.models.Movimentacao;
import com.isaac.models.Produto;

public class TelaMovimentacao extends javax.swing.JFrame {

    public TelaMovimentacao() throws SQLException {
        initComponents();

        MovimentacaoDAO mov = new MovimentacaoDAO();
        List<Movimentacao> movimentacoes = mov.getAll();
        ProdutoDAO produtoDAO = new ProdutoDAO();

        DefaultTableModel modelo = (DefaultTableModel) jTMovimentacoes.getModel();
        for (Movimentacao movs : movimentacoes) {
            Produto produto = produtoDAO.getProdutoById(movs.getIdProduto().getIdProduto());
            Object[] dados = {
                movs.getIdMovimentacao(),
                movs.getTipo(),
                produto.getNome(),
                movs.getQuantidade(),
                movs.getData()
            };
            modelo.addRow(dados);
        }

        jTMovimentacoes.setRowSorter(new TableRowSorter<>(modelo));
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTMovimentacoes = new javax.swing.JTable();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestão De Estoque - Movimentação");

        jTMovimentacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object[][]{},
            new String[]{
                "ID", "TIPO", "PRODUTO", "QUANTIDADE", "DATA"
            }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        jScrollPane1.setViewportView(jTMovimentacoes);

        jMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/preco-baixo.png")));
        jMenu.setText("Movimentações");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/produtos (1).png")));
        jMenuItem1.setText("Produtos");
        jMenu.add(jMenuItem1);
        jMenuItem1.addActionListener(e -> {
            try {
                TelaPrincipal telaPrincipal = new TelaPrincipal();
                telaPrincipal.setVisible(true);
                dispose();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/truck.png")));
        jMenuItem2.setText("Fornecedores");
        jMenu.add(jMenuItem2);
        jMenuItem2.addActionListener(e -> {
            try {
                TelaFornecedores telaFornecedores = new TelaFornecedores();
                telaFornecedores.setVisible(true);
                dispose();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        });

        jMenuBar.add(jMenu);
        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }

    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTMovimentacoes;
}
