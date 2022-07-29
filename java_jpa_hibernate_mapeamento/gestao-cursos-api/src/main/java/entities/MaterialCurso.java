package entities;

import javax.persistence.*;

@Entity
@Table(name = "materiais_cursos")
public class MaterialCurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    @OneToOne(mappedBy = "material")
    private Curso curso;

    public MaterialCurso() {
    }

    public MaterialCurso(String url, Curso curso) {
        this.url = url;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
