import java.util.ArrayList;


public class Banco{

    private String nome;
    private ArrayList<Pessoa> clientes;


    public Banco(String nome){
        this.nome = nome;
        clientes = new ArrayList<>(); //criando o ArrayList
    }

    public String cadastrarCliente(String nome, String cpf, 
                            int idade, double salario){
        
        Pessoa clienteExistente = buscarCliente(cpf);
        if(clienteExistente==null){
            Pessoa cliente = new Pessoa(cpf, nome, idade, salario);
            clientes.add(cliente);
            return "Cliente cadastrado!";
        }
        return "Cliente não cadastrado! CPF em uso!"; 
    }

    public Pessoa buscarCliente(String cpf){
        for(int i=0;i<clientes.size();i++){
            Pessoa cliente = clientes.get(i);

            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }

        return null;
    }

    public String gerarRelatorioClientes(){
        String relatorio="";

        for(int i=0;i<clientes.size();i++){
            Pessoa cliente = clientes.get(i);
            relatorio = relatorio + " Nome: "+cliente.getNome()+
                                   " Cpf:"+cliente.getCpf()+"\n";
        }
        return relatorio;
    }

}