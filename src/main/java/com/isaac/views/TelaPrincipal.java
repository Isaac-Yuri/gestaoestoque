package com.isaac.views;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import com.isaac.data.FornecedorDAO;
import com.isaac.data.ProdutoDAO;
import com.isaac.models.Fornecedor;
import com.isaac.models.Produto;

public class TelaPrincipal extends javax.swing.JFrame {

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public TelaPrincipal() throws SQLException {

        initComponents();

        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> produtos = dao.getAll();

        DefaultTableModel modelo = (DefaultTableModel) jTProdutos.getModel();
        for (Produto produto : produtos) {
            Object[] dados = {
                    produto.getIdProduto(),
                    produto.getNome(),
                    produto.getQuantidade(),
                    produto.getPreco(),
                    produto.getFornecedor().getNome(),
                    produto.getCategoria()
            };
            modelo.addRow(dados);
        }

        // Adicionar ordenação na tabela
        jTProdutos.setRowSorter(new TableRowSorter(modelo));
    }

    private void initComponents() throws SQLException {

        jMenuBar = new javax.swing.JMenuBar();
        jMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        txtNome = new javax.swing.JTextField();
        txtQtd = new javax.swing.JTextField();
        txtPreco = new javax.swing.JTextField();
        txtFornecedor = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTProdutos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setTitle("Gestão De Estoque - Produtos");

        jMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/produtos (1).png")));
        jMenu.setText("Produtos");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/preco-baixo.png")));
        jMenuItem1.setText("Movimentação");
        jMenu.add(jMenuItem1);
        
        jMenuItem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    TelaMovimentacao telaMovimentacao = new TelaMovimentacao();
                    telaMovimentacao.setVisible(true);

                    dispose();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/truck.png")));
        jMenuItem2.setText("Fornecedores");
        jMenu.add(jMenuItem2);

        jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    TelaFornecedores telaFornecedores = new TelaFornecedores();
                    telaFornecedores.setVisible(true);

                    dispose();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        jMenuBar.add(jMenu);

        setJMenuBar(jMenuBar);

        jLabel1.setText("Nome");
        jLabel2.setText("Quantidade");
        jLabel3.setText("Preço");
        jLabel4.setText("Fornecedor");
        jLabel5.setText("Categoria");

        jButton1.setText("Cadastrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    adicionarProduto(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        jButton2.setText("Excluir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    excluirProduto(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        jButton3.setText("Atualizar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    atualizarProduto(evt);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel2))
                                                .addGap(28, 28, 28)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel3)
                                                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(txtFornecedor,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 246,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel4))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5)
                                                        .addComponent(txtCategoria,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 181,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(21, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(31, 31, 31)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jButton3)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtQtd, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59,
                                        Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2)
                                        .addComponent(jButton3))
                                .addGap(39, 39, 39)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jTProdutos.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "DESCRIÇÃO", "QUANTIDADE", "PREÇO", "FORNECEDOR", "CATEGORIA"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        jScrollPane1.setViewportView(jTProdutos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 252,
                                        Short.MAX_VALUE)));

        layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }

    private void adicionarProduto(java.awt.event.ActionEvent evt) throws SQLException {
        if (txtNome.getText().isEmpty() || txtQtd.getText().isEmpty() || txtPreco.getText().isEmpty()
                || txtFornecedor.getText().isEmpty() || txtCategoria.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
            return;
        }

        try {
            Produto produto = new Produto();
            FornecedorDAO fornecedorDAO = new FornecedorDAO();

            produto.setNome(txtNome.getText());
            produto.setQuantidade(Integer.parseInt(txtQtd.getText()));
            produto.setPreco(Double.parseDouble(txtPreco.getText()));
            produto.setFornecedor(fornecedorDAO.getFornecedorByNome(txtFornecedor.getText()));
            produto.setCategoria(txtCategoria.getText());

            ProdutoDAO dao = new ProdutoDAO();
            dao.add(produto);
            produto = dao.getProdutoByNome(produto.getNome());

            DefaultTableModel dtmProdutos = (DefaultTableModel) jTProdutos.getModel();
            Object[] dados = {
                    produto.getIdProduto(),
                    produto.getNome(),
                    produto.getQuantidade(),
                    produto.getPreco(),
                    produto.getFornecedor().getNome(),
                    produto.getCategoria()
            };
            dtmProdutos.addRow(dados);

            limparCampos();

            JOptionPane.showMessageDialog(null, "Produto adicionado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Quantidade e preço devem ser valores numéricos.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar produto no banco de dados.");
        }
    }

    private void limparCampos() {
        txtNome.setText("");
        txtQtd.setText("");
        txtPreco.setText("");
        txtFornecedor.setText("");
        txtCategoria.setText("");
    }

    private void excluirProduto(java.awt.event.ActionEvent evt) throws SQLException {
        int selectedRow = jTProdutos.getSelectedRow();
        if (selectedRow != -1) {
            int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este produto?",
                    "Excluir Produto", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                ProdutoDAO produtoDAO = new ProdutoDAO();

                int idProduto = (int) jTProdutos.getValueAt(selectedRow, 0);
                Produto produto = produtoDAO.getProdutoById(idProduto);

                produtoDAO.delete(produto.getIdProduto());

                DefaultTableModel dtmProdutos = (DefaultTableModel) jTProdutos.getModel();
                dtmProdutos.removeRow(jTProdutos.getSelectedRow());

                limparCampos();
                JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para excluir.");
        }
    }

    private void atualizarProduto(ActionEvent evt) throws SQLException {
        int selectedRow = jTProdutos.getSelectedRow();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        if (selectedRow != -1) {
            int idProduto = Integer.parseInt(jTProdutos.getValueAt(selectedRow, 0).toString());
            Produto produtoExistente = produtoDAO.getProdutoById(idProduto);

            String novoNome = txtNome.getText().isEmpty() ? produtoExistente.getNome() : txtNome.getText();
            int novaQtd = txtQtd.getText().isEmpty() ? produtoExistente.getQuantidade()
                    : Integer.parseInt(txtQtd.getText());
            double novoPreco = txtPreco.getText().isEmpty() ? produtoExistente.getPreco()
                    : Double.parseDouble(txtPreco.getText());

            Fornecedor novoFornecedor = txtFornecedor.getText().isEmpty()
                    ? produtoExistente.getFornecedor()
                    : fornecedorDAO.getFornecedorByNome(txtFornecedor.getText());

            String novaCategoria = txtCategoria.getText().isEmpty() ? produtoExistente.getCategoria()
                    : txtCategoria.getText();

            produtoExistente.setNome(novoNome);
            produtoExistente.setQuantidade(novaQtd);
            produtoExistente.setPreco(novoPreco);
            produtoExistente.setFornecedor(novoFornecedor);
            produtoExistente.setCategoria(novaCategoria);

            produtoDAO.update(produtoExistente);

            DefaultTableModel dtmProdutos = (DefaultTableModel) jTProdutos.getModel();
            dtmProdutos.setValueAt(produtoExistente.getNome(), selectedRow, 1);
            dtmProdutos.setValueAt(produtoExistente.getQuantidade(), selectedRow, 2);
            dtmProdutos.setValueAt(produtoExistente.getPreco(), selectedRow, 3);
            dtmProdutos.setValueAt(produtoExistente.getFornecedor().getNome(), selectedRow, 4);
            dtmProdutos.setValueAt(produtoExistente.getCategoria(), selectedRow, 5);

            limparCampos();
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um produto para atualizar.");
        }
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTProdutos;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtQtd;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JMenu jMenu;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
}
