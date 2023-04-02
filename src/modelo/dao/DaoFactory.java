package modelo.dao;

import conexaoJdbc.ConexaoBanco;
import modelo.dao.impl.ConsultaDaoJDBC;
import modelo.dao.impl.PacienteDaoJDBC;

public class DaoFactory {

	public static ConsultaDao criarNovaConsultaDao() {
		return new ConsultaDaoJDBC(ConexaoBanco.fazerConexao());
	}

	public static PacienteDao criarPacienteDao() {
		return new PacienteDaoJDBC(ConexaoBanco.fazerConexao());
	}
}
