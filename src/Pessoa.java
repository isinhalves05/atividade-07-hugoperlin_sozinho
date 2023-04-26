public class Pessoa {

    private String cpf;
    private String nome;
    private int idade;
    private double salario;


    public Pessoa(String cpf, String nome, int idade, double salario) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public double getSalario() {
        return salario;
    }

    public int getIdade() {
        return idade;
    }
    
    public String getCpf(){
        return cpf;
    }

    public String getNome(){
        return nome;
    }

}
