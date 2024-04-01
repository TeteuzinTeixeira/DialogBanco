package banco;

public class Banco {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void deposito(double saldo) {
        this.saldo += saldo;
    }

    public void saque(double saldo) {
        this.saldo -= saldo;
    }
}
