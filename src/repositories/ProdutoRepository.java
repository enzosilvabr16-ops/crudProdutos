package repositories;

import entities.Produto;
import factories.ConnectionFactory;

import java.sql.Statement;

public class ProdutoRepository {

    //Metodo para inserir um produto no banco de dados
    public Integer create(Produto produto) throws Exception {

        //Abrir conexao com o banco de dados
        try(var connection = ConnectionFactory.getConnection()) {

            //escrevendo uma sentença  SQL para inserir um produto na  tabela do banco de dados
            var statement = connection.prepareStatement(
                    "INSERT INTO produtos(nome, preco, quantidade) VALUES(?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
        //passando os parametros da query para gravar o produto no banco
        statement.setString(1, produto.getNome());
        statement.setDouble(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());

        //executando a sentença SQL no baco de dados
            statement.execute();

            //obtendo o ID gerando no bd
            var keys = statement.getGeneratedKeys();
            if(keys.next()) {
                return keys.getInt(1); //retornar o ID gerado
            }
            return 0;
        }
    }

    //metodo para atualizar um produto no banco de dados
    public boolean update(Produto produto) throws Exception {

        //abrir conexao com o banco de dados
        try(var connection = ConnectionFactory.getConnection()) {

            //escrevendo a sentença SQL pra atualizar um produto no bd
            var statement = connection.prepareStatement("UPDATE produtos SET nome=?, preco=?, quantidade=? WHERE id=?");
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getQuantidade());
            statement.setInt(4, produto.getId());

            //executa o comando SQL e retorna true se algum registro foi atualizado
            return statement.executeUpdate() > 0;
        }
    }

    //metodo para excluir um produto no banco de dados
    public boolean delete(Integer id) throws Exception {

        //abrir conexao com banco de dados
        try (var connection = ConnectionFactory.getConnection()) {

            //excrevendo uma sentença SQL pra excluir um produto no banco de dados
            var statement = connection.prepareStatement("DELETE FROM produtos WHERE id=?");
            statement.setInt(1, id);

            //executa o comando SQL e retorna true se algum registro foi excluido
            return statement.executeUpdate() > 0;
        }
    }

    //metodo para consultar e exibir todos os produtos contidos na tabela do bd
    public void findAll() throws Exception {

        //abrir conexao com o banco de dados
        try (var connection = ConnectionFactory.getConnection()) {

            //Escrevendo a sentença SQL para consultar todos os produtos de tabela
            var statement = connection.prepareStatement("SELECT * FROM produtos ORDER BY id");

            //executa a consulta e retorna todos os registros obtidos
            var data = statement.executeQuery();

            //percorrer cada registro obtido no banco de dados
            while(data.next()) {
                System.out.println("Id.....................:" + data.getInt("id"));
                System.out.println("Nome...................:" + data.getString("nome"));
                System.out.println("Preço..................:" + data.getDouble("preco"));
                System.out.println("Data e hora............:" + data.getTimestamp("dataHoraCadastro"));
                System.out.println("...");
            }
        }

    }
}
