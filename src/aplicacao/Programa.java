package aplicacao;

import java.util.Date;

import modelo.dao.DaoFactory;
import modelo.dao.PacienteDao;
import modelo.entidade.Paciente;
public class Programa {
public static void main(String[] args) {
	PacienteDao pacienteDao = DaoFactory.criarPacienteDao();
	
	System.out.println("-----INSERIR PACIENTE-----");
	Paciente paciente = new Paciente(null, "Leonardo", new Date(),"masculino" );
	pacienteDao.insert(paciente);
	System.out.println("Novo paciente inserido! Id= "+paciente.getIdPaciente() );
	System.out.println(paciente.toString());
}
}
