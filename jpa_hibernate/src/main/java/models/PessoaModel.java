package models;

import entities.Pessoa;
import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class PessoaModel extends BaseModel {
    public PessoaModel(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    public void create(Pessoa p) {
        this.generateEntityManager();

        try {
            this.beginTransaction();
            this.entityManager.persist(p);
            this.entityManager.flush();
            this.commitTransaction();

            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            System.err.println("Erro ao criar a pessoa !!!" + e.getMessage());
        } finally {
            closeEntityManager();
            System.out.println("Finalizando a transação");
        }
    }

    public Pessoa findById(Pessoa p, boolean closeEm) {
        generateEntityManager();
        Pessoa pessoaSalva = null;

        try {
            pessoaSalva = this.entityManager.find(Pessoa.class, p.getId());
        } catch (Exception e) {
            System.err.println("Erro ao buscar a pessoa !!!" + e.getMessage());
        } finally {
            if (closeEm) {
                closeEntityManager();
            }

            System.out.println("Finalizando a transação");
        }

        return pessoaSalva;
    }

    public List<Pessoa> findAll() {generateEntityManager();
        List<Pessoa> pessoas = null;

        try {
            pessoas = this.entityManager.createQuery("select p from Pessoa p", Pessoa.class).getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao listar as pessoas !!!" + e.getMessage());
        } finally {
            closeEntityManager();
            System.out.println("Finalizando a transação");
        }

        return pessoas;
    }

    public void update(Pessoa p) {generateEntityManager();
        try {
            Pessoa pessoaSalvo = findById(p, false);

            beginTransaction();
            this.entityManager.merge(pessoaSalvo);
            this.entityManager.flush();
            commitTransaction();
        } catch (Exception e) {
            System.err.println("Erro ao atualizar a pessoa !!!" + e.getMessage());
            e.printStackTrace();
        } finally {
            closeEntityManager();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Pessoa p) {this.generateEntityManager();

        try {
            Pessoa pessoaSalvo = findById(p, false);

            this.beginTransaction();
            this.entityManager.remove(pessoaSalvo);
            this.entityManager.flush();
            this.commitTransaction();
        } catch (Exception e) {
            System.err.println("Erro ao remover a pessoa !!!" + e.getMessage());
        } finally {
            this.closeEntityManager();
            System.out.println("Finalizando a transação");
        }
    }
}
