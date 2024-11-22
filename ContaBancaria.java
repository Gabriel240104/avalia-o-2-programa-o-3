
class ContaBancaria {
    private String nomeCliente;
    private int numConta;
    protected double saldo;

    public ContaBancaria(String nomeCliente, int numConta, double saldoInicial) {
        this.nomeCliente = nomeCliente;
        this.numConta = numConta;
        this.saldo = saldoInicial;
    }

    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente para saque.");
        }
    }

    public void depositar(double valor) {
        saldo += valor;
        System.out.println("Depósito realizado com sucesso!");
    }

    public void mostrarDados() {
        System.out.println("Nome do Cliente: " + nomeCliente);
        System.out.println("Número da Conta: " + numConta);
        System.out.println("Saldo: R$ " + saldo);
    }
}


class ContaPoupanca extends ContaBancaria {
    private int diaRendimento;

    public ContaPoupanca(String nomeCliente, int numConta, double saldoInicial, int diaRendimento) {
        super(nomeCliente, numConta, saldoInicial);
        this.diaRendimento = diaRendimento;
    }

    public void calcularNovoSaldo(double taxaRendimento) {
        saldo += saldo * (taxaRendimento / 100);
        System.out.println("Novo saldo com rendimento aplicado: R$ " + saldo);
    }
}


class ContaEspecial extends ContaBancaria {
    private double limite;

    public ContaEspecial(String nomeCliente, int numConta, double saldoInicial, double limite) {
        super(nomeCliente, numConta, saldoInicial);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (saldo + limite >= valor) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");
        } else {
            System.out.println("Valor excede o limite disponível.");
        }
    }
}


public class Teste {
    public static void main(String[] args) {
        
        ContaBancaria contaComum = new ContaBancaria("Gabriel medeiros", 12345, 1000);
        ContaPoupanca contaPoupanca = new ContaPoupanca("Julia Santos", 54321, 2000, 5);
        ContaEspecial contaEspecial = new ContaEspecial("Carlos Pereira", 67890, 500, 1000);

        
        System.out.println("\n--- Conta Comum ---");
        contaComum.mostrarDados();
        contaComum.sacar(300);
        contaComum.depositar(200);
        contaComum.mostrarDados();

        System.out.println("\n--- Conta Poupança ---");
        contaPoupanca.mostrarDados();
        contaPoupanca.sacar(500);
        contaPoupanca.depositar(300);
        contaPoupanca.calcularNovoSaldo(2.5);
        contaPoupanca.mostrarDados();

        System.out.println("\n--- Conta Especial ---");
        contaEspecial.mostrarDados();
        contaEspecial.sacar(1200); 
        contaEspecial.depositar(700);
        contaEspecial.mostrarDados();
    }
}
