import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sistema
{
    private List<Produto> produtos = new ArrayList<>();
    private int id = 1;
    Scanner scanner = new Scanner(System.in);

    public void exibirMenu()
    {
        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("\n|-----------< Menu >-------------|");
            System.out.println("|1 - Inserir Produto ->          |");
            System.out.println("|2 - Consultar Produto ->        |");
            System.out.println("|3 - Alterar Produto ->          |");
            System.out.println("|4 - Remover Produto ->          |");
            System.out.println("|5 - Mostrar todos os Produtos ->|");

            System.out.print("\nEscolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao)
            {
                case 1:
                    inserirProduto();
                    break;

                case 2:
                    consultarProduto();
                    break;

                case 3:
                    alterarProduto();
                    break;

                case 4:
                    removerProduto();
                    break;
                // sistema em camadas
                case 5:
                    consultarTodosProdutos();
                    break;
                default:
                    System.out.println("Opção inválida, favor inserir opção válida.");
            }
        }
    }

    private void inserirProduto()
    {
        System.out.println("\n--------< Inserir Produto >--------\n");
        System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        float preco = scanner.nextFloat();

        // limpar buffer
        scanner.nextLine();

        // solid
        Banco banco = new Banco();
        banco.inserirBanco(nome, preco);

        System.out.println("\nProduto adicionado com sucesso.");
    }

    private void consultarProduto()
    {
        System.out.println("\n--------< Consulta por ID >--------\n");
        System.out.print("Digite o ID do produto a ser consultado: ");
        int id = scanner.nextInt();

        Banco banco = new Banco();
        banco.consultarBanco(id);
    }

    private void alterarProduto()
    {
        System.out.println("\n--------< Menu >--------\n");
        System.out.print("Digite o ID do produto a ser alterado: ");
        int id = scanner.nextInt();

        // limpar buffer
        scanner.nextLine();

        // System.out.println("Nome atual: " + produto.getName()); FAZER ISSO
        System.out.print("Novo nome: ");
        String name = scanner.nextLine();

        // System.out.println("Preco atual: " + produto.getPrice()); FAZER ISSO
        System.out.print("Novo preço: ");
        float preco = scanner.nextFloat();

        scanner.nextLine();

        // solid
        Banco banco = new Banco();
        banco.alterarBanco(id, name, preco);
    }

    private void removerProduto()
    {
        System.out.println("\n--------< Menu >--------\n");
        System.out.print("Digite o ID do produto a ser removido: ");
        int id = scanner.nextInt();

        // limpar buffer
        scanner.nextLine();

        // principios solid
        Banco banco = new Banco();
        banco.removerBanco(id);
    }

    // sistema em camadas
    private void consultarTodosProdutos()
    {
        Banco banco = new Banco();

        for (int i = 0; i < produtos.size(); i++)
        {
            banco.consultarBanco(i);
        }
    }
}