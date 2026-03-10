package repositories;

import entities.Produto;
import factories.ConnectionFactory;

public class ProdutoRepository {

    //Metodo para inserir um produto no banco de dados
    public void create(Produto produto) throws Exception {

        //Abrir conexao com o banco de dados
        try(var connection = ConnectionFactory.getConnection()) {

            //escrevendo uma sentença  SQL para inserir um produto na  tabela do banco de dados
            var statement = connection.prepareStatement( "INSERT INTO produtos(nome, preco, quantidade) VALUES(?,?,?)");
        //passando os parametros da query para gravar o produto no banco
        statement.setString(1, produto.getNome());
        statement.setDouble(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());

        //executando a sentença SQL no baco de dados
            statement.execute();

        }
    }
}
