import java.util.ArrayList;

//Representa uma entrega feita por um motorista, usando um veículo, para um cliente
public class Entrega implements Frete {
    private Cliente cliente;
    private Motorista motorista;
    private Veiculo veiculo;
    private double distanciaKm;
    private double valorPorKm;

    public Entrega(Cliente cliente, Motorista motorista, Veiculo veiculo, double distanciaKm, double valorPorKm) {
        this.cliente = cliente;
        this.motorista = motorista;
        this.veiculo = veiculo;
        this.distanciaKm = distanciaKm;
        this.valorPorKm = valorPorKm;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setDistanciaKm(double distanciaKm) {
        if (distanciaKm <= 0) {
            throw new IllegalArgumentException("A distância deve ser maior que zero.");
        }
        this.distanciaKm = distanciaKm;
    }

    public double getValorPorKm() {
        return valorPorKm;
    }

    public void setValorPorKm(double valorPorKm) {
        this.valorPorKm = valorPorKm;
    }
    // Cálculo do valor total da entrega basica, a ideia é que cada veiculo tenha um valor por km
    @Override
    public double calcularValor() {
        return distanciaKm * valorPorKm;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public double getDistanciaKm() {
        return distanciaKm;
    }
}
