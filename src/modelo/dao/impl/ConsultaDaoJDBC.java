package modelo.dao.impl;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import modelo.dao.ConsultaDao;
import modelo.entidade.Consulta;

public class ConsultaDaoJDBC implements ConsultaDao {

	public ConsultaDaoJDBC(Connection fazerConexao) {
	}

	@Override
	public void insert(Consulta obj) {
		Statement st = null;

	}

	@Override
	public void update(Consulta obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Consulta id) {
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
