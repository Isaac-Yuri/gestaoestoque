package com.isaac.views;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import com.isaac.data.FornecedorDAO;
import com.isaac.models.Fornecedor;

public class TelaFornecedores extends javax.swing.JFrame {

        @SuppressWarnings({ "unchecked", "rawtypes" })
        public TelaFornecedores() throws SQLException {

                initComponents();

                FornecedorDAO dao = new FornecedorDAO();
                List<Fornecedor> fornecedores = dao.getAll();

                DefaultTableModel modelo = (DefaultTableModel) jTFornecedores.getModel();
                for (Fornecedor fornecedor : fornecedores) {
                        Object[] dados = {
                                        fornecedor.getIdFornecedor(),
                                        fornecedor.getNome(),
                                        fornecedor.getContato(),
                                        fornecedor.getEndereco()
                        };
                        modelo.addRow(dados);
                }

                jTFornecedores.setRowSorter(new TableRowSorter(modelo));
        }

        private void initComponents() throws SQLException {

                jMenuBar = new javax.swing.JMenuBar();
                jMenu = new javax.swing.JMenu();
                jMenuItem1 = new javax.swing.JMenuItem();
                jMenuItem2 = new javax.swing.JMenuItem();
                jPanel1 = new javax.swing.JPanel();
                txtNome = new javax.swing.JTextField();
                txtContato = new javax.swing.JTextField();
                txtEndereco = new javax.swing.JTextField();
                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jButton1 = new javax.swing.JButton();
                jButton2 = new javax.swing.JButton();
                jButton3 = new javax.swing.JButton();
                jPanel2 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                jTFornecedores = new javax.swing.JTable();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                setTitle("Gestão De Estoque - Fornecedores");

                jMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/truck.png")));
                jMenu.setText("Fornecedores");

                jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/preco-baixo.png")));
                jMenuItem1.setText("Movimentação");
                jMenu.add(jMenuItem1);
                jMenuItem1.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                try {
                                        TelaMovimentacao telaMovimencao = new TelaMovimentacao();
                                        telaMovimencao.setVisible(true);

                                        dispose();
                                } catch (SQLException ex) {
                                        ex.printStackTrace();
                                }
                        }
                });

                jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("../images/produtos (1).png")));
                jMenuItem2.setText("Produtos");
                jMenu.add(jMenuItem2);
                jMenuItem2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                try {
                                        TelaPrincipal telaPrincipal = new TelaPrincipal();
                                        telaPrincipal.setVisible(true);
                                        dispose();
                                } catch (SQLException ex) {
                                        ex.printStackTrace();
                                }
                        }
                });

                jMenuBar.add(jMenu);

                setJMenuBar(jMenuBar);

                jLabel1.setText("Nome");
                jLabel2.setText("Contato");
                jLabel3.setText("Endereço");

                jButton1.setText("Cadastrar");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                try {
                                        adicionarFornecedor(evt);
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
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(txtNome,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                246,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel1))
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(txtContato,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                181,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jLabel2))
                                                                                                .addGap(28, 28, 28)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabel3)
                                                                                                                .addComponent(txtEndereco,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                218,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                .addContainerGap(21, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jButton1)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(jButton2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                82,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(31, 31, 31)
                                                                .addComponent(jButton3)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(47, 47, 47)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(jLabel3))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(txtNome,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtContato,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(txtEndereco,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jButton1)
                                                                                .addComponent(jButton2)
                                                                                .addComponent(jButton3)) // Removido a
                                                                                                         // seção de
                                                                                                         // labels 4 e 5
                                                                .addGap(39, 39, 39)));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jTFornecedores.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {},
                                new String[] { "ID", "FORNECEDOR", "CONTATO", "ENDEREÇO" }) {
                        boolean[] canEdit = new boolean[] { false, false, false, false };

                        public boolean isCellEditable(int rowIndex, int columnIndex) {
                                return canEdit[columnIndex];
                        }
                });

                jScrollPane1.setViewportView(jTFornecedores);

                javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane1));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                252, Short.MAX_VALUE)));

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
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel2,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)));

                pack();

        }

        private void adicionarFornecedor(java.awt.event.ActionEvent evt) throws SQLException {
                if (txtNome.getText().isEmpty() || txtContato.getText().isEmpty() || txtEndereco.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Todos os campos devem ser preenchidos.");
                        return;
                }

                try {
                        Fornecedor fornecedor = new Fornecedor();
                        fornecedor.setNome(txtNome.getText());
                        fornecedor.setContato(txtContato.getText());
                        fornecedor.setEndereco(txtEndereco.getText());

                        FornecedorDAO fornecedorDAO = new FornecedorDAO();
                        fornecedorDAO.add(fornecedor);

                        fornecedor = fornecedorDAO.getFornecedorByNome(fornecedor.getNome());

                        DefaultTableModel dtmFornecedores = (DefaultTableModel) jTFornecedores.getModel();
                        Object[] dados = {
                                        fornecedor.getIdFornecedor(),
                                        fornecedor.getNome(),
                                        fornecedor.getContato(),
                                        fornecedor.getEndereco()
                        };
                        dtmFornecedores.addRow(dados);

                        limparCampos();

                        JOptionPane.showMessageDialog(null, "Fornecedor adicionado com sucesso!");
                } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Erro ao adicionar fornecedor no banco de dados.");
                }
        }

        private void limparCampos() {
                txtNome.setText("");
                txtContato.setText("");
                txtEndereco.setText("");
        }

        private void excluirProduto(java.awt.event.ActionEvent evt) throws SQLException {
                int selectedRow = jTFornecedores.getSelectedRow();

                if (selectedRow != -1) {
                        int confirm = JOptionPane.showConfirmDialog(null,
                                        "Tem certeza que deseja excluir este Fornecedor?",
                                        "Excluir Fornecedor", JOptionPane.YES_NO_OPTION);
                        if (confirm == JOptionPane.YES_OPTION) {
                                FornecedorDAO fornecedorDAO = new FornecedorDAO();
                                int idFornecedor = (int) jTFornecedores.getValueAt(selectedRow, 0);
                                Fornecedor fornecedor = fornecedorDAO.getFornecedorById(idFornecedor);
                                fornecedorDAO.delete(fornecedor.getIdFornecedor());

                                DefaultTableModel dtmFornecedores = (DefaultTableModel) jTFornecedores.getModel();
                                dtmFornecedores.removeRow(jTFornecedores.getSelectedRow());

                                limparCampos();
                                JOptionPane.showMessageDialog(null, "Fornecedor excluído com sucesso!");
                        }
                } else {
                        JOptionPane.showMessageDialog(null, "Selecione um Fornecedor para excluir.");
                }
        }

        private void atualizarProduto(ActionEvent evt) throws SQLException {
                int selectedRow = jTFornecedores.getSelectedRow();
                FornecedorDAO fornecedorDAO = new FornecedorDAO();

                if (selectedRow != -1) {
                        int idFornecedor = Integer.parseInt(jTFornecedores.getValueAt(selectedRow, 0).toString());
                        Fornecedor fornecedorExistente = fornecedorDAO.getFornecedorById(idFornecedor);

                        String novoNome = txtNome.getText().isEmpty() ? fornecedorExistente.getNome()
                                        : txtNome.getText();
                        String novoContato = txtContato.getText().isEmpty() ? fornecedorExistente.getContato()
                                        : txtContato.getText();
                        String novoEndereco = txtEndereco.getText().isEmpty() ? fornecedorExistente.getEndereco()
                                        : txtEndereco.getText();

                        fornecedorExistente.setNome(novoNome);
                        fornecedorExistente.setContato(novoContato);
                        fornecedorExistente.setEndereco(novoEndereco);

                        fornecedorDAO.update(fornecedorExistente);

                        DefaultTableModel dtmFornecedores = (DefaultTableModel) jTFornecedores.getModel();
                        dtmFornecedores.setValueAt(fornecedorExistente.getNome(), selectedRow, 1);
                        dtmFornecedores.setValueAt(fornecedorExistente.getContato(), selectedRow, 2);
                        dtmFornecedores.setValueAt(fornecedorExistente.getEndereco(), selectedRow, 3);

                        limparCampos();
                        JOptionPane.showMessageDialog(null, "Fornecedor atualizado com sucesso!");
                } else {
                        JOptionPane.showMessageDialog(null, "Selecione um fornecedor para atualizar.");
                }
        }

        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton3;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JPanel jPanel2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable jTFornecedores;
        private javax.swing.JTextField txtNome;
        private javax.swing.JTextField txtEndereco;
        private javax.swing.JTextField txtContato;
        private javax.swing.JMenu jMenu;
        private javax.swing.JMenuBar jMenuBar;
        private javax.swing.JMenuItem jMenuItem1;
        private javax.swing.JMenuItem jMenuItem2;
}
