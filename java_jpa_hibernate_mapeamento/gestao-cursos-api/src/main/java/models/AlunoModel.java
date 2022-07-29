package models;

import entities.Aluno;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class AlunoModel extends BaseModel {
    public AlunoModel(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    public List<Aluno> findAll() {
        List<Aluno> alunos = null;
        this.generateEntityManager();

        try {
            alunos = this.entityManager
                    .createQuery("select a from Aluno a", Aluno.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeEntityManager();
        }

        return alunos;
    }

    public Aluno findById(Aluno aluno, boolean closeEm) {
        this.generateEntityManager();
        Aluno alunoSalvo = null;

        try {
            alunoSalvo = this.entityManager.find(Aluno.class, aluno.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (closeEm) {
                this.closeEntityManager();
            }
        }

        return alunoSalvo;
    }

    public void create(Aluno aluno) {
        this.generateEntityManager();

        try {
            this.beginTransaction();
            this.entityManager.persist(aluno);
            this.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeEntityManager();
        }
    }

    public void update(Aluno aluno) {
        this.generateEntityManager();

        try {
            Aluno alunoSalvo = findById(aluno, false);

            this.beginTransaction();
            this.entityManager.merge(aluno);
            this.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeEntityManager();
        }

    }

    public void delete(Aluno aluno) {
        this.generateEntityManager();

        try {
            Aluno alunoSalvo = findById(aluno, false);

            this.beginTransaction();
            this.entityManager.remove(alunoSalvo);
            this.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeEntityManager();
        }

    }
}
