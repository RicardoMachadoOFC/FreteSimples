// Classe Motorista também herda de Pessoa e adiciona o campo cnh
public class Motorista extends Pessoa {
    private String cnh;

    public Motorista(String nome, String cpf, String telefone, String cnh) {
        super(nome, cpf, telefone);
        this.cnh = cnh;
    }


    @Override
    public void exibirInformacoes() {
        System.out.println("Motorista: " + getNome() + ", CPF: " + getCpf() + ", Telefone: " + getTelefone() + ", CNH: " + cnh);
    }
}
