package controllers;

import entities.Produto;
import repositories.ProdutoRepository;

import java.util.Scanner;

public class ProdutoController {

    //metodo para capturar os dados do produto para cadastro
    public static void cadastrarProduto() {

        System.out.println("\nCADASTRO DE PRODUTO\n");

        try (var scanner = new Scanner(System.in)) {

            //criando um objeto da classe produto
            var produto = new Produto();

            System.out.print("Informe o nome do produto....: ");
            produto.setNome(scanner.nextLine());

            System.out.print("Informe o preço..............: ");
            produto.setPreco(Double.parseDouble(scanner.nextLine()));

            System.out.print("Informe a quantidade.........: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

            //criando um objeto da classe produto repository
            var produtoRepository = new ProdutoRepository();
            var id = produtoRepository.create(produto);

            System.out.println("\nProduto cadastrado com sucesso!");
            System.out.println("ID do produto: " + id);
        }
        catch(Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

    //metodo para capturar os dados do produto para cadastro
    public static void atualizarProduto() {

        System.out.println("\nATUALIZAÇÃO DE PRODUTO\n");

        try (var scanner = new Scanner(System.in)) {

            //criando um objeto da classe produto
            var produto = new Produto();

            System.out.println("Informe o id do produto....:");
            produto.setId(Integer.parseInt(scanner.nextLine()));

            System.out.print("Informe o nome do produto....: ");
            produto.setNome(scanner.nextLine());

            System.out.print("Informe o preço..............: ");
            produto.setPreco(Double.parseDouble(scanner.nextLine()));

            System.out.print("Informe a quantidade.........: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

            //criando um objeto da classe produto repository
            var produtoRepository = new ProdutoRepository();

            if(produtoRepository.update(produto)) {
                System.out.println("\nProduto cadastrado com sucesso!");
            }
            else {
                System.out.println("\nProduto não encontrado para edição. Verifique o id informado.");
            }
        }
        catch(Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

    //metodo para capturar os dados para exclusao
    public static void excluirProduto() {

        System.out.println("\nEXCLUSÃO DE PRODUTO\n");

        try(var scanner = new Scanner(System.in)) {

            System.out.println("Informe o id do produto....: ");
            var id = Integer.parseInt(scanner.nextLine());

            var produtoRepository = new ProdutoRepository();
            if(produtoRepository.delete(id)) {
                System.out.println("\nProduto excluído com sucesso.");
            }
            else {
                System.out.println("Produto não encontrado para exclusão. Verifique o id informado.");
            }

        }
        catch(Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }

    //metodo para consultar todos os produtos
    public static void consultarProdutos() {

        System.out.println("\nCONSULTA DE PRODUTO\n");

        try {
            var produtoRepository = new ProdutoRepository();
            produtoRepository.findAll();
        }
        catch(Exception e) {
            System.out.println("\nErro: " + e.getMessage());
        }
    }
}