package entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "alunos")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String matricula;
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    private String email;
    @OneToMany(mappedBy = "aluno", targetEntity = Telefone.class, cascade = CascadeType.ALL)
    private List<Telefone> telefones;
    @OneToMany(mappedBy = "aluno", targetEntity = Endereco.class, cascade = CascadeType.ALL)
    private List<Endereco> enderecos;
    @ManyToMany
    @JoinTable(name = "cursos_alunos", joinColumns = @JoinColumn(name = "id_aluno", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_curso", referencedColumnName = "id"))
    private List<Curso> cursos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }
}
