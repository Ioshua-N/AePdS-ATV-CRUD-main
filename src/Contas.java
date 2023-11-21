import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Contas
{
    Scanner scanner = new Scanner(System.in);
    private String user = "admin";
    private String password = "admin";

    public void menuConta()
    {
        System.out.println("\n--------< Menu >--------\n");
        System.out.println("1 - Fazer login ->");
        System.out.println("2 - Cadastrar usuário ->");
        System.out.print("\nEscolha uma opção: ");

        int opcao = scanner.nextInt();

        switch (opcao)
        {
            case 1:
                login();
                break;
            case 2:
                cadastro();
                break;
            default:
                System.out.println("Opção inválida. Insira uma opção válida. ");
        }
    }

    private void cadastro()
    {
        System.out.println("\n--------< Menu de Login >--------\n");
        System.out.print("Insira o nome de usuário: ");
        String usuario = scanner.nextLine();

        System.out.print("Insira a senha: ");
        String senha = scanner.nextLine();

        // solid
        Banco banco = new Banco();
        banco.cadastroBanco(usuario, senha);

        menuConta();
    }

    public void login()
    {
        System.out.print("\nInsira o nome de usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Insira a senha: ");
        String senha = scanner.nextLine();

        boolean foundRecords = false;

        Banco banco = new Banco();
        banco.loginBanco(foundRecords, usuario, senha);

        if(usuario.equals(user) && senha.equals(password))
        {
            System.out.println("\nLogin sucedido!");

            Sistema sistema = new Sistema();
            sistema.exibirMenu();
        }
        else
        {
            System.out.println("\nFalha no login. Usuário ou senha inválidos.\n");
            menuConta();
        }
    }
}
