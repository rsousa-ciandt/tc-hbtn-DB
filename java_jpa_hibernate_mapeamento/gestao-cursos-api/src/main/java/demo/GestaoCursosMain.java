package demo;

import entities.*;
import models.AlunoModel;
import models.CursoModel;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GestaoCursosMain {
    private static Aluno aluno;
    private static Curso curso;

    public static void main(String[] args) {
        aluno = new Aluno();
        curso = new Curso();

        criarEntidades();
        testeDasModels();
    }

    private static void testeDasModels() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

        AlunoModel alunoModel = new AlunoModel(entityManagerFactory);
        CursoModel cursoModel = new CursoModel(entityManagerFactory);

        // 1 salva o aluno
        System.out.println("\n1 salva o aluno");
        alunoModel.create(aluno);

        // 2 busca o aluno salvo
        System.out.println("\n2 busca o aluno salvo");
        Aluno alunoSalvo = alunoModel.findById(aluno, true);
        System.out.println(alunoSalvo.getNomeCompleto());

        // 3 atualiza o aluno
        System.out.println("\n3 atualiza o aluno");
        aluno.setNomeCompleto("Joaozinho");
        alunoModel.update(aluno);

        alunoSalvo  = alunoModel.findById(aluno, true);
        System.out.println(alunoSalvo.getNomeCompleto());

        // 4 lista os alunos
        System.out.println("\n4 lista os alunos");
        for (Aluno aluno: alunoModel.findAll()) {
            System.out.println(aluno.getId() + aluno.getNomeCompleto());
        }

        // ==================

        // 1 salva o curso
        System.out.println("\n1 salva o curso");
        cursoModel.create(curso);

        // 2 salva o curso
        System.out.println("\n2 busca o curso salvo");
        Curso cursoSalvo = cursoModel.findById(curso, true);
        System.out.println(cursoSalvo.getNome());

        // 3 atualiza o aluno
        System.out.println("\n3 atualiza o curos");
        curso.setNome("Java Persistence API - Course");
        cursoModel.update(curso);

        cursoSalvo = cursoModel.findById(curso, true);
        System.out.println(cursoSalvo.getNome());

        // 4 atualiza o curso
        System.out.println("\n4 lista os curso");
        for (Curso c: cursoModel.findAll()) {
            System.out.println(c.getId() + c.getNome());
        }

        // ==================

        // 5 relaciona os alunos e os curos
        System.out.println("\n5 relaciona os alunos e os curos");

        curso.setAlunos(List.of(aluno));
        cursoModel.update(curso);


        // 6 apaga tudo
        System.out.println("\n6 relaciona os alunos e os curos");
        cursoModel.delete(curso);
        alunoModel.delete(aluno);
    }

    private static void criarEntidades() {
        // Aluno
        aluno.setNomeCompleto("João Victor");
        aluno.setMatricula("2353");
        aluno.setNascimento(new Date("01/01/2000"));
        aluno.setEmail("jvictor@email.com");
        aluno.setTelefones(new ArrayList<>());
        aluno.setEnderecos(new ArrayList<>());

        aluno.getTelefones().add(new Telefone("45", "99998765", aluno));
        aluno.getTelefones().add(new Telefone("11", "98881234", aluno));

        //end
        aluno.getEnderecos().add(new Endereco(
                "Avenida",
                "TechCamps",
                "123",
                "CI&T",
                "Campinas",
                "São Paulo",
                12355,
                aluno
        ));

        //prof
        Professor professor = new Professor("Eliabe Vieira", "123", "eliabe@kahoot.it");

        // Curso
        curso.setNome("Ciência da Computação");
        curso.setSigla("CC");
        curso.setMaterial(new MaterialCurso("url", curso));
        professor.getCursos().add(curso);
        curso.setProfessor(professor);
    }
}
