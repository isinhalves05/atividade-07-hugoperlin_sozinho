import java.util.ArrayList;
import java.util.Collection;

public class Banco {

    private String nome;
    private ArrayList<Pessoa> clientes;
    private ArrayList<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        // Inicializando as listas
        clientes = new ArrayList<>();
        contas = new ArrayList<>();
    }

    public String cadastrarConta(String numero, String agencia, Pessoa cliente) {
        // Procurando o cliente a partir do CPF
        Pessoa clienteEncontrado = null;
        for (Pessoa c : clientes) {
            if (c.getCpf().equals(cliente.getCpf())) {
                clienteEncontrado = c;
                break;
            }
        }
        if (clienteEncontrado == null) {
            System.out.println("Cliente não encontrado.");
            return null;
        }
        // Procurando a conta a partir do número e agência
        for (Conta c : contas) {
            if (c.getNumero().equals(numero) && c.getAgencia().equals(agencia)) {
                System.out.println("Já existe uma conta com esse número e agência.");
                return null;
            }
        }
        // Criando e adicionando nova conta
        Conta novaConta = new Conta(numero, agencia, clienteEncontrado);
        contas.add(novaConta);
        System.out.println("Conta cadastrada com sucesso!");
        return novaConta.getNumero();
    }

    public Conta buscarConta(String numero, String agencia) {
        for (Conta c : contas) {
            if (c.getNumero().equals(numero) && c.getAgencia().equals(agencia)) {
                return c;
            }
        }
        return null;
    }

    public String sacar(String numero, String agencia, double valor) {
        Conta conta = buscarConta(numero, agencia);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return null;
        }
        if (conta.getSaldo() < valor) {
            System.out.println("Saldo insuficiente.");
            return null;
        }
        conta.setSaldo(conta.getSaldo() - valor);
        System.out.println("Saque realizado com sucesso. Novo saldo:" + conta.getSaldo());
        return agencia;
    }

    public void depositar(String numero, String agencia, double valor) {
        Conta conta = buscarConta(numero, agencia);
        if (conta == null) {
            System.out.println("Conta não encontrada.");
            return;
        }
        conta.setSaldo(conta.getSaldo() + valor);
        System.out.println("Depósito realizado com sucesso. Novo saldo:" + conta.getSaldo());
    }

    public String gerarRelatorioContas() {
        String relatorio = "";
        for (Conta conta : contas) {
            relatorio += "Conta " + conta.getNumero() + " Agência " + conta.getAgencia() + " Saldo " + conta.getSaldo()
                    + "\n";
        }
        return relatorio;
    }

    public String cadastrarCliente(String nome, String cpf, int idade, double salario) {
        Pessoa clienteExistente = buscarCliente(cpf);
        if (clienteExistente == null) {
            Pessoa cliente = new Pessoa(cpf, nome, idade, salario);
            clientes.add(cliente);
            return "Cliente cadastrado!";
        }
        return "Cliente não cadastrado! CPF em uso!";
    }

    public Pessoa buscarCliente(String cpf) {
        for (Pessoa cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    public String gerarRelatorioClientes() {
        String relatorio = "";
        for (Pessoa cliente : clientes) {
            relatorio += "Nome: " + cliente.getNome() + " Cpf: " + cliente.getCpf() + "\n";
        }
        return relatorio;
    }
}