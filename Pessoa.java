// Classe abstrata que representa qualquer pessoa do sistema (cliente ou motorista).
abstract class Pessoa {
    protected String nome;
    protected String cpf;
    protected String telefone;


    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    // Construtor para inicializar uma pessoa com nome, CPF e telefone.
    public Pessoa(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    // quem implementar pessoa deve ter esse metodo
    public abstract void exibirInformacoes();
}
