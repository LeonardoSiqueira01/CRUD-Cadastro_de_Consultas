package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import conexaoJdbc.ConexaoBanco;
import db.DBException;
import modelo.dao.ConsultaDao;
import modelo.dao.DaoFactory;
import modelo.dao.PacienteDao;
import modelo.entidade.Consulta;
import modelo.entidade.Paciente;

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

		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("UPDATE consulta SET dataConsulta =? , horarioConsulta =? , valorConsulta = ? "
					+ " WHERE idConsulta = ? ");
			st.setDate(1, new java.sql.Date(obj.getDataConsulta().getTime()));
			st.setDate(2, new java.sql.Date(obj.getHorarioConsulta().getTime()));
			st.setDouble(3, obj.getValorConsulta());
			st.setInt(4, obj.getIdConsulta());
			st.execute();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoBanco.fecharStatment(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Consulta findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT consulta.*, paciente.idPaciente  " + "	FROM consulta INNER JOIN paciente "
							+ "	ON consulta.idPaciente = paciente.idPaciente " + " WHERE consulta.idConsulta = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				PacienteDao pdao = DaoFactory.criarPacienteDao();
				Paciente pc = new Paciente();
				Consulta obj = new Consulta();
				pc.setIdPaciente(rs.getInt("idPaciente"));
				pc = pdao.findById(pc.getIdPaciente());
				obj.setIdConsulta(rs.getInt("idConsulta"));
				obj.setDataConsulta(rs.getDate("dataConsulta"));
				obj.setHorarioConsulta(rs.getDate("horarioConsulta"));
				obj.setValorConsulta(rs.getDouble("valorConsulta"));
				obj.setPacienteObj(pc);
				return obj;

			}
			return null;

		} catch (SQLException e) {
			throw new DBException(e.getMessage());
		} finally {
			ConexaoBanco.fecharResultSet(rs);
			ConexaoBanco.fecharStatment(st);
		}
	}

	@Override
	public List<Consulta> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
