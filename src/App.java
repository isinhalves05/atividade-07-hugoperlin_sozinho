import java.util.Scanner;

public class App {

    static Scanner teclado = new Scanner(System.in);
    static ContaBancaria conta;
    static Banco banco = new Banco("IFBank");

    static String imprimirMenu(){
        String str="";
        str += "###----###\n";
        str += "1 - Cadastrar conta\n";
        str += "2 - Sacar\n";
        str += "3 - Depositar\n";
        str += "4 - Ver dados\n";
        str += "5 - Cadastrar Cliente\n";
        str = str + "6 - Listar Clientes\n";
        str += "0 - Sair\n";
        str += "Digite uma opção:";

        return str;
    }


    static void criarConta(){
        
        String numero;
        String agencia;
        String cpf;
        double saldoInicial;
        
        System.out.println("Digite o nome do cpf:");
        cpf = teclado.nextLine();
        System.out.println("Digite o número da conta:");
        numero = teclado.nextLine();
        System.out.println("Digite a agência da conta:");
        agencia = teclado.nextLine();
        
        //buscar cliente por cpf no banco
        //se o cliente existir, criar conta, passando o cliente encontrado
        //para a conta bancária

        //conta = new ContaBancaria(agencia,numero,nomeCliente);

        System.out.println("************");

    }

    static void sacar(){
        double valor;

        System.out.println("Digite um valor:");
        valor = teclado.nextDouble();
        String retorno = conta.sacar(valor);
        System.out.println(retorno);
        System.out.println("************");
    }

    static void depositar(){
        double valor;

        System.out.println("Digite um valor:");
        valor = teclado.nextDouble();
        String retorno = conta.depositar(valor);
        System.out.println(retorno);
        System.out.println("************");
    }

    static void mostrarDados(){
        System.out.println("Dados da conta");
        System.out.println(conta.verExtrato());
        System.out.println("************");
    }

    static void cadastrarCliente(){
        String nome;
        String cpf;
        int idade;
        double salario;

        System.out.println("Digite o nome do cliente:");
        nome = teclado.nextLine();
        System.out.println("Digite o cpf do cliente:");
        cpf = teclado.nextLine();
        System.out.println("Digite a idade do cliente:");
        idade = teclado.nextInt();
        System.out.println("Digite o salário do cliente R$:");
        salario = teclado.nextDouble();

        System.out.println(banco.cadastrarCliente(nome, cpf, idade, salario));
    }

    static void relatorioClientes(){
        System.out.println("####Relatório Clientes####");
        System.out.println(banco.gerarRelatorioClientes());
        System.out.println("######");
    }

    public static void main(String[] args) {

        int opcao=0;

        do{
            System.out.println(imprimirMenu());
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch(opcao){
                case 1:
                    criarConta();
                break;
                case 2:
                    sacar();
                    
                break;
                case 3:
                    depositar();
                break;
                case 4:
                    mostrarDados();
                break;
                case 5:
                    cadastrarCliente();
                break;
                case 6:
                    relatorioClientes();
                break;
                default:
                    if(opcao != 0){
                        System.out.println("Opção inválida!!");
                    }
            }
        }while(opcao != 0);
    }
}
