import java.security.MessageDigest;
import java.security.SecureRandom;
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
        //limpar buffer
        scanner.nextLine();

        System.out.println("\n--------< Menu de Cadastro >--------\n");
        System.out.print("Insira o nome de usuário: ");
        String usuario = scanner.nextLine();

        System.out.print("Insira a senha: ");
        String senha = scanner.nextLine();


         String senhaCifrada = cifrarSenha(senha);


        // solid
        Banco banco = new Banco();
        banco.cadastroBanco(usuario, senhaCifrada);

        menuConta();
    }

    public void login()
    {
        //limpar buffer
        scanner.nextLine();

        System.out.print("\nInsira o nome de usuário: ");
        String usuario = scanner.nextLine();
        System.out.print("Insira a senha: ");
        String senha = scanner.nextLine();

        boolean foundRecords = false;

        Banco banco = new Banco();
        banco.loginBanco(foundRecords, usuario, cifrarSenha(senha));

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

    private static String cifrarSenha(String senha)
    {
        try
        {
            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] senhaCifradaByte = md.digest(senha.getBytes());

            StringBuilder senhaCifrada = new StringBuilder();

            for(byte b: senhaCifradaByte){
                senhaCifrada.append(String.format("%02X", b));
            }

            return senhaCifrada.toString();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }



}
