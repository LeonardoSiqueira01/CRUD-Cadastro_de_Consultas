package aplicacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.dao.DaoFactory;
import modelo.dao.PacienteDao;
import modelo.entidade.Paciente;

public class Programa {
	public static void main(String[] args) {
		PacienteDao pacienteDao = DaoFactory.criarPacienteDao();
		List<Paciente> lista = new ArrayList<>();

		System.out.println("-----INSERIR PACIENTE-----");
		Paciente paciente = new Paciente(null, "Carol", new Date(), "Feminino");
		pacienteDao.insert(paciente);
		System.out.println("Novo paciente inserido! Id= " + paciente.getIdPaciente());

		System.out.println("---------------LISTAR TODOS PACIENTES -------------------");
		lista = pacienteDao.findAll();
		for (Paciente list : lista) {
			System.out.println(list);
		}
	}
}
