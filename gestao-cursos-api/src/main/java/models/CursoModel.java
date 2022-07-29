package models;

import entities.Curso;

import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CursoModel extends BaseModel {
    public CursoModel(EntityManagerFactory entityManagerFactory) {
        super(entityManagerFactory);
    }

    public List<Curso> findAll() {
        List<Curso> cursos = null;
        this.generateEntityManager();

        try {
            cursos = this.entityManager
                    .createQuery("select c from Curso c", Curso.class)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeEntityManager();
        }

        return cursos;
    }

    public Curso findById(Curso curso, boolean closeEm) {
        this.generateEntityManager();
        Curso cursoSalvo = null;

        try {
            cursoSalvo = this.entityManager.find(Curso.class, curso.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (closeEm) {
                this.closeEntityManager();
            }
        }

        return cursoSalvo;
    }

    public void create(Curso curso) {
        this.generateEntityManager();

        try {
            this.beginTransaction();
            this.entityManager.persist(curso);
            this.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeEntityManager();
        }
    }

    public void update(Curso curso) {
        this.generateEntityManager();

        try {
            Curso cursoSalvo = findById(curso, false);

            this.beginTransaction();
            this.entityManager.merge(curso);
            this.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeEntityManager();
        }

    }

    public void delete(Curso curso) {
        this.generateEntityManager();

        try {
            Curso cursoSalvo = findById(curso, false);

            this.beginTransaction();
            this.entityManager.remove(cursoSalvo);
            this.commitTransaction();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeEntityManager();
        }

    }
}
