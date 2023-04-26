public class ContaBancaria {

    // atributos
    private String numero;
    private String agencia;
    private String nomeCliente;
    private double saldo;


    public ContaBancaria(String numero, 
                         String agencia, 
                         String nomeCliente, 
                         double saldo){
        System.out.println("Chamou contrutor completo...");
        this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        this.saldo = saldo;
    }

    public ContaBancaria(String numero, 
                         String agencia, 
                         String nomeCliente){
        
        this(numero,agencia,nomeCliente,0.0);
        /*this.numero = numero;
        this.agencia = agencia;
        this.nomeCliente = nomeCliente;
        saldo = 0.0;*/
        System.out.println("Chamou construtor simples");
        
    }



    public void setNumero(String novoValor){
        numero = novoValor;
    }

    public void setAgencia(String novoValor){
        agencia = novoValor;
    }

    public void setNomeCliente(String novoValor){
        nomeCliente = novoValor;
    }

    /*
    public void setSaldo(double novoValor){
        saldo = novoValor;
    }*/

    public String getAgencia(){
        return agencia;
    }

    public String getNumero(){
        return numero;
    }

    public String getNomeCliente(){
        return nomeCliente;
    }

    public double getSaldo(){
        return saldo;
    }

    // metodos
    String depositar(double valor) {
        if(valor < 0){
            saldo = saldo + valor;
            return "Depósito realizado!!";
        }
        return "Valor inválido!!";
        
    }

    String sacar(double valor) {
        if (valor > 0) {
            if (valor <= saldo) {
                saldo = saldo - valor;
                return "Saque realizado!!!";
            }else{
                return "Saldo insuficiente!!";
            }
        }else{
            return "Valor inválido!!!";
        }

    }

    String verExtrato() {
        String str = "";

        str = "\nAgência: " + agencia +
                "\n Número: " + numero +
                "\n Cliente: " + nomeCliente +
                "\n Saldo R$:" + saldo;

        return str;
    }

}