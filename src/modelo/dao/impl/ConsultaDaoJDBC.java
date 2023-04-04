package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import conexaoJdbc.ConexaoBanco;
import modelo.dao.ConsultaDao;
import modelo.entidade.Consulta;

public class ConsultaDaoJDBC implements ConsultaDao {
	private Connection conn;

	public ConsultaDaoJDBC(Connection fazerConexao) {
		this.conn = fazerConexao;
	}

	@Override
	public void insert(Consulta obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("INSERT INTO consulta "
					+ "(dataConsulta, horarioConsulta, valorConsulta , idPaciente )" + " VALUES (?, ?, ?, ? )",
					Statement.RETURN_GENERATED_KEYS);
			st.setDate(1, new java.sql.Date(obj.getDataConsulta().getTime()));
			st.setDate(2, new java.sql.Date(obj.getHorarioConsulta().getTime()));
			st.setDouble(3, obj.getValorConsulta());
			st.setInt(4, obj.getPacienteObj().getIdPaciente());
			
			int rowsAffected = st.executeUpdate();
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setIdConsulta(id);
				}
				ConexaoBanco.fecharResultSet(rs);
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoBanco.fecharStatment(st);
		}

	}

	@Override
	public void update(Consulta obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Consulta findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consulta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
