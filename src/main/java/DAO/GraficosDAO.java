package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnectionDB;

import entity.GraficoFiltro;

public class GraficosDAO {

	Connection conn;

	public GraficosDAO() {

		try {
			conn = ConnectionDB.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<GraficoFiltro> contarFiltro() {

		String sql = "SELECT COUNT(*) as qtd, DATE_FORMAT(data,'%m/%Y') as mes FROM filtro GROUP BY data;";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<GraficoFiltro> lista = new ArrayList<>();
			while (rs.next()) {
				GraficoFiltro fo = new GraficoFiltro();

				fo.setQtd(rs.getInt("qtd"));
				fo.setMes(rs.getString("mes"));

				lista.add(fo);
			}
			return lista;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
