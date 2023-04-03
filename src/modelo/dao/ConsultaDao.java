package modelo.dao;

import java.util.List;

import modelo.entidade.Consulta;

public interface ConsultaDao {
	void insert(Consulta obj);

	void update(Consulta obj);

	void deleteById(Integer id);

	Consulta findById(Integer id);

	List<Consulta> findAll();
}
