import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Banco
{
    public void loginBanco(boolean foundRecords, String usuario, String senha)
    {
        try
        {
            // make connection
            Connection connection = SQLConnection.open();
            Statement s = connection.createStatement();

            // make query
            ResultSet rs = s.executeQuery("select * from Logins");

            while (rs.next())
            {
                foundRecords = true;
                String usuarioRs = rs.getString("usuario");
                String senhaRs = rs.getString("senha");

                if (usuario.equals(usuarioRs) && senha.equals(senhaRs))
                {
                    Sistema sistema = new Sistema();
                    sistema.exibirMenu();
                }
            }

            if (!foundRecords)
            {
                System.out.println("Nenhum registro encontrado.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void cadastroBanco(String usuario, String senha)
    {
        try
        {
            // make connection
            Connection connection = SQLConnection.open();
            Statement s = connection.createStatement();

            // insert
            s.executeUpdate
                    (
                            "insert into Logins (usuario, senha) values ('" + usuario + "', '" + senha + "')"
                    );

            System.out.println("\nCadastro concluido com sucesso. ");

            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void inserirBanco(String nome, float preco)
    {
        try
        {
            // make connection
            Connection connection = SQLConnection.open();
            Statement s = connection.createStatement();

            // insert
            s.executeUpdate
                    (
                            "insert into Produto (nome, preco) values ('" + nome + "', '" + preco + "')"
                    );
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void consultarBanco(int id)
    {
        try
        {
            // make connection
            Connection connection = SQLConnection.open();
            Statement s = connection.createStatement();

            // make query
            ResultSet rs = s.executeQuery("select * from Produto where id = '" + id + "'");

            // check if the rs has a row
            if (rs.next())
            {
                // show query
                System.out.println("ID: " + rs.getInt("id") + "Name: " + rs.getString("nome") + "Balance: " + rs.getFloat("preco"));
            }
            else
            {
                System.out.println("Nenhum produto encontrado com esse ID: " + id);
            }

            // close resources
            rs.close();
            s.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void alterarBanco(int id, String name, float preco)
    {
        try
        {
            // make connection
            Connection connection = SQLConnection.open();
            Statement s = connection.createStatement();

            // Execute the query
            s.executeUpdate("update Produto set nome = '" + name + "', preco = '" + preco + "' where id = '" + id + "'");

            System.out.println("\nProduto alterado com sucesso.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void removerBanco(int id)
    {
        try
        {
            // make connection
            Connection connection = SQLConnection.open();
            Statement s = connection.createStatement();

            // remove account
            s.executeUpdate
                    (
                            "delete from Produto where id = '" + id + "'"
                    );

            System.out.println("\nProduto removido com sucesso.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void consultarTodosBanco()
    {
        try
        {
            // make connection
            Connection connection = SQLConnection.open();
            Statement s = connection.createStatement();

            // make query
            ResultSet rs = s.executeQuery("select * from Produto");

            // check if the rs has a row
            if (rs.next())
            {
                while(rs.next())
                {
                    //show query
                    System.out.println("ID: " + rs.getInt("id") + " | Nome: " + rs.getString("nome") + " | Preço: " + rs.getFloat("preco"));
                }
            }
            else
            {
                System.out.println("Nenhum produto encontrado.");
            }

            // close resources
            rs.close();
            s.close();
            connection.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}