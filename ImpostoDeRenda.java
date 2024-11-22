
abstract class Contribuinte {
    protected String nome;
    protected double rendaBruta;

    public Contribuinte(String nome, double rendaBruta) {
        this.nome = nome;
        this.rendaBruta = rendaBruta;
    }

    public abstract double calcularImposto();

    @Override
    public String toString() {
        return "Nome: " + nome + ", Renda Bruta: " + rendaBruta + ", Imposto: " + calcularImposto();
    }
}


class PessoaJuridica extends Contribuinte {

    public PessoaJuridica(String nome, double rendaBruta) {
        super(nome, rendaBruta);
    }

    @Override
    public double calcularImposto() {
        return rendaBruta * 0.10; 
    }
}


class PessoaFisica extends Contribuinte {

    public PessoaFisica(String nome, double rendaBruta) {
        super(nome, rendaBruta);
    }

    @Override
    public double calcularImposto() {
        if (rendaBruta <= 1400) {
            return 0;
        } else if (rendaBruta <= 2100) {
            return rendaBruta * 0.10 - 100;
        } else if (rendaBruta <= 2800) {
            return rendaBruta * 0.15 - 270;
        } else if (rendaBruta <= 3600) {
            return rendaBruta * 0.25 - 500;
        } else {
            return rendaBruta * 0.30 - 700;
        }
    }
}


public class ImpostoDeRenda {

    public static void main(String[] args) {
        Contribuinte[] contribuintes = new Contribuinte[6];

        
        contribuintes[0] = new PessoaJuridica("Empresa A", 50000);
        contribuintes[1] = new PessoaJuridica("Empresa B", 75000);
        contribuintes[2] = new PessoaJuridica("Empresa C", 100000);

        
        contribuintes[3] = new PessoaFisica("João", 1200);
        contribuintes[4] = new PessoaFisica("Maria", 2500);
        contribuintes[5] = new PessoaFisica("Carlos", 3800);

        for (Contribuinte contribuinte : contribuintes) {
            System.out.println(contribuinte);
        }
    }
}
