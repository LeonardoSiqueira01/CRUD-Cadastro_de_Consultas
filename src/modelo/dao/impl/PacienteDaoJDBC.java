package modelo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import conexaoJdbc.ConexaoBanco;
import modelo.dao.PacienteDao;
import modelo.entidade.Paciente;

public class PacienteDaoJDBC implements PacienteDao {
	private Connection conn;

	public PacienteDaoJDBC(Connection fazerConexao) {
		this.conn = fazerConexao;
	}

	@Override
	public void insert(Paciente obj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO paciente (nomePaciente, dataNascPaciente, sexoPaciente) " + "VALUES (?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			st.setString(1, obj.getNomePaciente());
			st.setDate(2, new java.sql.Date(obj.getDataNascPaciente().getTime()));
			st.setString(3, obj.getSexoPaciente());

			int linhasAfetadas = st.executeUpdate();
			if (linhasAfetadas > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					obj.setIdPaciente(id);
				}
				ConexaoBanco.fecharResultSet(rs);
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoBanco.fecharStatment(st);
		}
	}

	@Override
	public void update(Paciente obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Paciente id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Paciente findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Paciente> findAll() {
		List<Paciente> list = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("SELECT * FROM paciente");
			rs = st.executeQuery();
			while (rs.next()) {
				Paciente paciente = new Paciente(rs.getInt("idPaciente"), rs.getString("NomePaciente"),
						rs.getDate("dataNascPaciente"), rs.getString("sexoPaciente"));
				list.add(paciente);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConexaoBanco.fecharResultSet(rs);
			ConexaoBanco.fecharStatment(st);
		}

		return list;
	}

}
