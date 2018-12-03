package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import config.ConnectionDB;
import entity.Curriculo;
import service.ClasseGenerica;
import service.Experiencia;
import service.Formacao;

public class FiltroDAO {

	Connection conn;

	public FiltroDAO() {

		try {
			conn = ConnectionDB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// falar sobre o ajax nao suportado tem q ver o ONHIDE

	public boolean inserirCurriculo(Curriculo c) {

		String sql = "INSERT INTO curriculo (nome_aluno, idade, nivelIngles, nivelEspanhol, estado, cidade, curso, "
				+ "semestre, sexo, deficiencia, email, telefone) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

		try {

			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, c.getNomeDoAluno());
			ps.setLong(2, c.getIdade()); // VER SOBRE O LONG VER SE NAO VAI DA erro PQ NO BD ESTA VARCHAR
			ps.setInt(3, c.getNivel_ingles());
			ps.setInt(4, c.getNivel_espanhol());
			ps.setString(5, c.getEstado());
			ps.setString(6, c.getCidade());
			ps.setString(7, c.getCurso());
			ps.setInt(8, c.getSemestre());
			ps.setInt(9, c.getSexo());
			ps.setInt(10, c.getDeficiencia());
			ps.setString(11, c.getEmail());
			ps.setString(12, c.getTelefone());

			if (ps.executeUpdate() == 1) {

				ResultSet rs = ps.getGeneratedKeys();

				int idCur = rs.getInt(1); // perguntar do id

				for (Experiencia e : c.getExperiencia()) { // perguntar sobre o experiencia e pq eu n entendi
					inserirExperiencia(e, idCur);
				}
				for (Formacao fo : c.getFormação()) { // AQUI ESTAMOS COLOCANDO NA LISTA FORMAÇÃO E EXPERIENCIA AS
														// FORMAÇÕES E EXPERIENCIAS
					inserirFormacao(fo, idCur);
				}

				System.out.println("Curriculo cadastrado ");
			} else {
				System.out.println("Problemas ao cadastrar Curriculo");
				return false;
			}
			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// FICAR ATENTO AO TIPO DE VARIAVEIS
		return false;
	}

	// ---------------------------------------------------------------------------------------------------

	public boolean inserirExperiencia(Experiencia ex, int cod) {

		String sql = "INSERT INTO experiencia(nomeDaEmpresa, data_inicio, data_fim, funçao, cargo, idCurriculo) VALUES(?, ?, ?, ?, ?, ?) ";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, ex.getEmpresa());
			ps.setLong(2, ex.getData_inicio());
			ps.setLong(3, ex.getData_fim());
			ps.setString(4, ex.getFuncoes());
			ps.setString(5, ex.getCargo());
			ps.setInt(6, ex.getIdCurriculo());
			// colocar o IDCORRUCILO

			if (ps.executeUpdate() == 1) {
				System.out.println("Experiencia cadastrada ");
			} else {
				System.out.println("Problemas ao cadastrar experiencia");
				return false;
			}
			return true;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;

	}

	public boolean inserirFormacao(Formacao fo, int cod) {

		String sql = "INSERT INTO formacao(nomeDoCurso, data_inicio, data_fim, escola, idCurriculo) VALUES(?, ?, ?, ?, ?)";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, fo.getNome());
			ps.setLong(2, fo.getData_inicio());
			ps.setLong(3, fo.getData_fim());
			ps.setString(4, fo.getEscola());
			ps.setInt(5, fo.getIdCurriculo());

			if (ps.executeUpdate() == 1) {
				System.out.println("Formação cadastrada ");
			} else {
				System.out.println("Problemas ao cadastrar Formação");
				return false;
			}
			return true;

		} catch (Exception e) {
			// TODO: handle exception
		}

		return false;
	}

}
