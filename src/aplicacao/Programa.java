package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.dao.DaoFactory;
import modelo.dao.PacienteDao;
import modelo.entidade.Paciente;


public class Programa {
	public static void main(String[] args) throws ParseException {
		PacienteDao pacienteDao = DaoFactory.criarPacienteDao();
		List<Paciente> lista = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		System.out.println("-----INSERIR PACIENTE-----");
		Paciente paciente = new Paciente(null, "Fernando", new Date(), "Masculino");
		pacienteDao.insert(paciente);
		System.out.println("Novo paciente inserido! Id= " + paciente.getIdPaciente());

		System.out.println("---------------LISTAR TODOS PACIENTES -------------------");
		lista = pacienteDao.findAll();
		for (Paciente list : lista) {
			System.out.println(list);
		}
		System.out.println("---------------- PROCURAR PACIENTE POR ID-------------------");
		Paciente novoPaciente = new Paciente();
		novoPaciente = pacienteDao.findById(11);
		System.out.println(novoPaciente);

		System.out.println("---------------- ATUALIZAR PACIENTE POR ID-------------------");
		Paciente p2 = new Paciente();
		p2 = pacienteDao.findById(22);
		p2.setNomePaciente("Patricia");
		p2.setDataNascPaciente(new java.sql.Date(sdf.parse("22/04/2000").getTime()));
		p2.setSexoPaciente("Feminino");
		pacienteDao.update(p2);
		System.out.println(p2);

		System.out.println("---------------- DELETAR PACIENTE POR ID-------------------");
		int nPaciente;
		pacienteDao.deleteById(nPaciente = 14);
		System.out.println("Paciente " + nPaciente + " deletado com sucesso!");

		
	}
}
