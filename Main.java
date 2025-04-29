import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Cliente> clientes = new ArrayList<>();
    static ArrayList<Motorista> motoristas = new ArrayList<>();
    static ArrayList<Veiculo> veiculos = new ArrayList<>();
    static ArrayList<Entrega> entregas = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("--- Menu ---");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Cadastrar Motorista");
            System.out.println("3 - Cadastrar Veículo");
            System.out.println("4 - Cadastrar Entrega");
            System.out.println("5 - Listar Entregas");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = Integer.parseInt(input.nextLine());

            switch (opcao) {
                case 1:
                    clientes.add(cadastrarCliente());
                    break;
                case 2:
                    motoristas.add(cadastrarMotorista());
                    break;
                case 3:
                    veiculos.add(cadastrarVeiculo());
                    break;
                case 4:
                    cadastrarEntrega();
                    break;
                case 5:
                    listarEntregas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static Cliente cadastrarCliente() {
        System.out.print("Nome do cliente: ");
        String nome = input.nextLine();
        System.out.print("CPF do cliente: ");
        String cpf = input.nextLine();
        System.out.print("Telefone do cliente: ");
        String telefone = input.nextLine();
        System.out.print("Endereço do cliente: ");
        String endereco = input.nextLine();
        return new Cliente(nome, cpf, telefone, endereco);
    }

    private static Motorista cadastrarMotorista() {
        System.out.print("Nome do motorista: ");
        String nome = input.nextLine();
        System.out.print("CPF do motorista: ");
        String cpf = input.nextLine();
        System.out.print("Telefone do motorista: ");
        String telefone = input.nextLine();
        System.out.print("CNH do motorista: ");
        String cnh = input.nextLine();
        return new Motorista(nome, cpf, telefone, cnh);
    }

    private static Veiculo cadastrarVeiculo() {
        System.out.print("Modelo do veículo: ");
        String modelo = input.nextLine();
        System.out.print("Placa do veículo: ");
        String placa = input.nextLine();
        System.out.print("Capacidade de carga (kg): ");
        double capacidadeCarga = Double.parseDouble(input.nextLine());
        return new Veiculo(modelo, placa, capacidadeCarga);
    }
    // Cadastra uma entrega com seleção de itens relacionados
    private static void cadastrarEntrega() {
        if (clientes.isEmpty() || motoristas.isEmpty() || veiculos.isEmpty()) {
            System.out.println("Precisa ter pelo menos um cliente, motorista e veículo cadastrados.");
            return;
        }

        try {
            System.out.println("Escolha o cliente (número):");
            for (int i = 0; i < clientes.size(); i++) {
                System.out.println((i + 1) + " - " + clientes.get(i).getNome());
            }
            int numeroCliente = Integer.parseInt(input.nextLine()) - 1;

            System.out.println("Escolha o motorista (número):");
            for (int i = 0; i < motoristas.size(); i++) {
                System.out.println((i + 1) + " - " + motoristas.get(i).getNome());
            }
            int numeroMotorista = Integer.parseInt(input.nextLine()) - 1;

            System.out.println("Escolha o veículo (número):");
            for (int i = 0; i < veiculos.size(); i++) {
                System.out.println((i + 1) + " - " + veiculos.get(i).getModelo());
            }
            int numeroVeiculo = Integer.parseInt(input.nextLine()) - 1;

            System.out.print("Distância (km): ");
            double distanciaKm = Double.parseDouble(input.nextLine());
            System.out.print("Valor por km (R$): ");
            double valorPorKm = Double.parseDouble(input.nextLine());

            Entrega entrega = new Entrega(clientes.get(numeroCliente), motoristas.get(numeroMotorista), veiculos.get(numeroVeiculo), distanciaKm, valorPorKm);
            entregas.add(entrega);
            System.out.println("Valor da entrega: R$ " + entrega.calcularValor());

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar entrega. Verifique os dados inseridos.");
        }
    }

    private static void listarEntregas() {
        if (entregas.isEmpty()) {
            System.out.println("Nenhuma entrega cadastrada.");
        } else {
            for (Entrega entrega : entregas) {
                System.out.println("--- Entrega ---");
                System.out.println("Cliente: " + entrega.getCliente().getNome());
                System.out.println("Motorista: " + entrega.getMotorista().getNome());
                System.out.println("Veículo: " + entrega.getVeiculo().getModelo());
                System.out.println("Distância: " + entrega.getDistanciaKm() + " km");
                System.out.println("Valor: R$ " + entrega.calcularValor());
            }
        }
    }
}
