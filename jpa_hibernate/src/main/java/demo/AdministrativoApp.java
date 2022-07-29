package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class AdministrativoApp {
    private static EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("admin-jpa");

    public static void testPessoaModel() {
        PessoaModel pessoaModel = new PessoaModel(emf);

        Pessoa p1 = new Pessoa();
        p1.setIdade(99999999);
        p1.setCpf("112.131.132-23");
        p1.setNome("Mago dos magos");
        p1.setEmail("mago@email.com");
        p1.setDataNascimento(LocalDate.now());

        // 1) Criando uma pessoa
        pessoaModel.create(p1);

        //2) Buscando todos as pessoas na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        System.out.println("\n2)Qtde de pessoas encontradas : " + pessoas.size());

        //3) Buscando uma pessoa em específico
        Pessoa pessoaSalva = pessoaModel.findById(p1, true);
        System.out.println("\n3)Pessoa salvo: " + pessoaSalva.getId() + " - Nome: " + pessoaSalva.getNome());

        //4) Atualizando a pessoaSalva
        pessoaSalva.setNome("TV - LG");
        pessoaModel.update(pessoaSalva);
        pessoaSalva = pessoaModel.findById(pessoaSalva, true);
        System.out.println("\n4)Pessoa salva: " + pessoaSalva.getId() + " - Nome: " + pessoaSalva.getNome());

//        //5) Apagando a pessoaSalva
        pessoaModel.delete(pessoaSalva);
        pessoaSalva = pessoaModel.findById(pessoaSalva, true);
        System.out.println("\n5)Pessoa salva: " + pessoaSalva);

    }

    public static void testProdutoModel() {
        ProdutoModel produtoModel = new ProdutoModel(emf);

        Produto p1 = new Produto();
        p1.setNome("TV");
        p1.setPreco(300.0);
        p1.setQuantidade(100);
        p1.setStatus(true);

        // 1) Criando um produto
        produtoModel.create(p1);

        //2) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        System.out.println("\n2)Qtde de produtos encontrados : " + produtos.size());

        //3) Buscando um produto em específico
        Produto produtoSalvo = produtoModel.findById(p1, true);
        System.out.println("\n3)Produto salvo: " + produtoSalvo.getId() + " - Nome: " + produtoSalvo.getNome());

        //4) Atualizando o produtoSalvo
        produtoSalvo.setNome("TV - LG");
        produtoModel.update(produtoSalvo);
        produtoSalvo = produtoModel.findById(produtoSalvo, true);
        System.out.println("\n4)Produto salvo: " + produtoSalvo.getId() + " - Nome: " + produtoSalvo.getNome());

//        //5) Apagando o produtoSalvo
        produtoModel.delete(produtoSalvo);
        produtoSalvo = produtoModel.findById(produtoSalvo, true);
        System.out.println("\n5)Produto salvo: " + produtoSalvo);

    }

    public static void main(String[] args) {
        testProdutoModel();
        testPessoaModel();
    }
}
