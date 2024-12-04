package br.edu.unisep.cadastrodefornecedores;

public class Fornecedor {
    private String nome;
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;

    public Fornecedor(String nome, String cnpj, String endereco, String telefone, String email) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", CNPJ: " + cnpj + ", Endereço: " + endereco +
                ", Telefone: " + telefone + ", Email: " + email;
    }
}
