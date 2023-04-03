package modelo.dao;

import java.util.List;

import modelo.entidade.Paciente;

public interface PacienteDao {
	void insert(Paciente obj);
		void update(Paciente obj);
		void deleteById(Integer id);
		Paciente findById(Integer id);
		List<Paciente> findAll();
}
