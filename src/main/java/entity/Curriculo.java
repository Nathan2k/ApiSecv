package entity;

import java.util.List;

import service.Experiencia;
import service.Formacao;

public class Curriculo {

// RECEBO ESSE CARA
	private Integer id;
	private String nomeDoAluno;
	private Integer semestre;
	private String curso;
	private String email;
	private String estado;
	private String cidade;
	private List<Experiencia> experiencia; //
	private List<Formacao> formação;
	private Integer sexo;
	private Integer deficiencia;
	private Integer nivel_ingles;
	private Integer nivel_espanhol;
	private String telefone;
	private Long idade; // COLOCAR EM M CALENDAR PRA PODER PEGAR A IDADE

	public Integer getId() {
		return id;
	}

	public List<Formacao> getFormação() {
		return formação;
	}

	public void setFormação(List<Formacao> formação) {
		this.formação = formação;
	}

	public String getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getNomeDoAluno() {
		return nomeDoAluno;
	}

	public void setNomeDoAluno(String nomeDoAluno) {
		this.nomeDoAluno = nomeDoAluno;
	}

	public List<Experiencia> getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(List<Experiencia> experiencia) {
		this.experiencia = experiencia;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}

	public Integer getDeficiencia() {
		return deficiencia;
	}

	public void setDeficiencia(Integer deficiencia) {
		this.deficiencia = deficiencia;
	}

	public Integer getNivel_ingles() {
		return nivel_ingles;
	}

	public void setNivel_ingles(Integer nivel_ingles) {
		this.nivel_ingles = nivel_ingles;
	}

	public Integer getNivel_espanhol() {
		return nivel_espanhol;
	}

	public void setNivel_espanhol(Integer nivel_espanhol) {
		this.nivel_espanhol = nivel_espanhol;
	}

	public Long getIdade() {
		return idade;
	}

	public void setIdade(Long idade) {
		this.idade = idade;
	}

}
