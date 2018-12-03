package service;

import java.util.Calendar;

public class Formacao {

	public Formacao() {
	}

	public Formacao(Integer id, String nome, Calendar data_inicio, Calendar data_fim, String escola,
			Integer idCurriculo) {

		this.id = id;
		this.nome = nome;
		this.escola = escola;
		this.idCurriculo = idCurriculo;
	}

	private Integer id;
	private String nome; //esse é o nome do curso!
	private Long data_inicio;
	private Long data_fim;
	private String escola;
	private Integer idCurriculo;

	public String getEscola() {
		return escola;
	}

	public void setEscola(String escola) {
		this.escola = escola;
	}

	

	public Integer getIdCurriculo() {
		return idCurriculo;
	}

	public void setIdCurriculo(Integer idCurriculo) {
		this.idCurriculo = idCurriculo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Long data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Long getData_fim() {
		return data_fim;
	}

	public void setData_fim(Long data_fim) {
		this.data_fim = data_fim;
	}

}
