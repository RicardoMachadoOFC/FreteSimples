// Classe Cliente herda da classe Pessoa e adiciona o campo endereco
public class Cliente extends Pessoa {
    private String endereco;

    public Cliente(String nome, String cpf, String telefone, String endereco) {
        super(nome, cpf, telefone);
        this.endereco = endereco;
    }


    @Override
    public void exibirInformacoes() {
        System.out.println("Cliente: " + getNome() + ", CPF: " + getCpf() + ", Telefone: " + getTelefone() + ", Endereço: " + endereco);
    }
}
