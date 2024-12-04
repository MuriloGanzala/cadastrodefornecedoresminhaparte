package br.edu.unisep.cadastrodefornecedores;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    private JFrame frame;
    private JTextField txtNome, txtCnpj, txtEndereco, txtTelefone, txtEmail;
    private List<Fornecedor> fornecedores;

    public Principal() {
        fornecedores = new ArrayList<>();
        inicializarTela();
    }

    private void inicializarTela() {
        frame = new JFrame("Cadastro de Fornecedores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JPanel painelFormulario = new JPanel(new GridLayout(6, 2, 5, 5));

        painelFormulario.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelFormulario.add(txtNome);

        painelFormulario.add(new JLabel("CNPJ:"));
        txtCnpj = new JTextField();
        painelFormulario.add(txtCnpj);

        painelFormulario.add(new JLabel("Endereço:"));
        txtEndereco = new JTextField();
        painelFormulario.add(txtEndereco);

        painelFormulario.add(new JLabel("Telefone:"));
        txtTelefone = new JTextField();
        painelFormulario.add(txtTelefone);

        painelFormulario.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        painelFormulario.add(txtEmail);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(e -> salvarFornecedor());
        painelFormulario.add(btnSalvar);

        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(e -> listarFornecedores());
        painelFormulario.add(btnListar);

        frame.add(painelFormulario, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private void salvarFornecedor() {
        String nome = txtNome.getText();
        String cnpj = txtCnpj.getText();
        String endereco = txtEndereco.getText();
        String telefone = txtTelefone.getText();
        String email = txtEmail.getText();

        if (nome.isEmpty() || cnpj.isEmpty() || endereco.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        fornecedores.add(new Fornecedor(nome, cnpj, endereco, telefone, email));
        JOptionPane.showMessageDialog(frame, "Fornecedor cadastrado com sucesso!");
        limparCampos();
    }

    private void listarFornecedores() {
        if (fornecedores.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Nenhum fornecedor cadastrado!", "Atenção", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder lista = new StringBuilder("Fornecedores cadastrados:\n");
        for (Fornecedor fornecedor : fornecedores) {
            lista.append(fornecedor.toString()).append("\n");
        }

        JOptionPane.showMessageDialog(frame, lista.toString(), "Lista de Fornecedores", JOptionPane.INFORMATION_MESSAGE);
    }

    private void limparCampos() {
        txtNome.setText("");
        txtCnpj.setText("");
        txtEndereco.setText("");
        txtTelefone.setText("");
        txtEmail.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Principal::new);
    }
}
