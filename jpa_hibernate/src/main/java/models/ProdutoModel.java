package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class ProdutoModel extends BaseModel {
    public ProdutoModel(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    public void create(Produto p) {
        this.generateEntityManager();

        try {
            this.beginTransaction();
            this.entityManager.persist(p);
            this.entityManager.flush();
            this.commitTransaction();

            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            this.closeEntityManager();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto p) {
        this.generateEntityManager();

        try {
            Produto produtoSalvo = findById(p, false);

            this.beginTransaction();
            this.entityManager.merge(produtoSalvo);
            this.entityManager.flush();
            this.commitTransaction();
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o produto !!!" + e.getMessage());
            e.printStackTrace();
        } finally {
            this.closeEntityManager();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Produto p) {
        this.generateEntityManager();

        try {
            Produto produtoSalvo = findById(p, false);

            this.beginTransaction();
            this.entityManager.remove(produtoSalvo);
            this.entityManager.flush();
            this.commitTransaction();
        } catch (Exception e) {
            System.err.println("Erro ao remover o produto !!!" + e.getMessage());
        } finally {
            this.closeEntityManager();
            System.out.println("Finalizando a transação");
        }
    }

    public Produto findById(Produto p, boolean closeEm) {
        this.generateEntityManager();
        Produto produtoSalvo = null;

        try {
            produtoSalvo = this.entityManager.find(Produto.class, p.getId());
        } catch (Exception e) {
            System.err.println("Erro ao buscar o produto !!!" + e.getMessage());
        } finally {
            if (closeEm) {
                this.closeEntityManager();
            }

            System.out.println("Finalizando a transação");
        }

        return produtoSalvo;
    }

    public List<Produto> findAll() {
        this.generateEntityManager();
        List<Produto> produtos = null;

        try {
            produtos = this.entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao listar os produtos !!!" + e.getMessage());
        } finally {
            this.closeEntityManager();
            System.out.println("Finalizando a transação");
        }

        return produtos;
    }
}
