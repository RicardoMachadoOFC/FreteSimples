public class Veiculo {
    private String modelo;
    private String placa;
    private double capacidadeCarga;

    public Veiculo(String modelo, String placa, double capacidadeCarga) {
        this.modelo = modelo;
        this.placa = placa;
        this.capacidadeCarga = capacidadeCarga;
    }
    // proibe a carga de ser negativa
    public void setCapacidadeCarga(double capacidadeCarga) {
        if (capacidadeCarga <= 0) {
            throw new IllegalArgumentException("A capacidade de carga deve ser maior que zero.");
        }
        this.capacidadeCarga = capacidadeCarga;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public double getCapacidadeCarga() {
        return capacidadeCarga;
    }
}
