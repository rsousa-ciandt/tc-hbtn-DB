package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sigla;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_material")
    private MaterialCurso material;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_professor")
    private Professor professor;
    @ManyToMany(mappedBy = "cursos")
    private List<Aluno> alunos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public MaterialCurso getMaterial() {
        return material;
    }

    public void setMaterial(MaterialCurso material) {
        this.material = material;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}
