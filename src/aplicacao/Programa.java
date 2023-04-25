package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import modelo.dao.ConsultaDao;
import modelo.dao.DaoFactory;
import modelo.dao.PacienteDao;
import modelo.entidade.Consulta;
import modelo.entidade.Paciente;

public class Programa {

	public static void main(String[] args) throws ParseException {
		menuPrincipal();
	}

	private static void menuPrincipal() throws ParseException {
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------- MENU PRINCIPAL -----------------------");
		System.out.println(" 1 - Acessar Paciente");
		System.out.println(" 2 - Acessar Consultas");
		System.out.println(" 3 - Finalizar o Programa ");
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			menuPaciente();
		case 2:
			menuConsulta();
		case 3:
			System.out.println("Programa Finalizado!");
			System.exit(0);
		default:
			System.out.println("Opção Invalida");
			menuPrincipal();
		}
		sc.close();
	}

	private static void menuPaciente() throws ParseException {
		PacienteDao pacientedao = DaoFactory.criarPacienteDao();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------------- MENU PACIENTE -----------------------");
		System.out.println(" 1 - Cadastrar ");
		System.out.println(" 2 - Atualizar ");
		System.out.println(" 3 - Deletar ");
		System.out.println(" 4 - Listar Todos ");
		System.out.println(" 5 - Voltar para menu Principal");
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			Paciente obj = new Paciente();
			System.out.println("Nome: ");
			String nome = sc.next();
			System.out.println("Data de Nascimento(dd/MM/yyyy):");
			String dataNasc = sc.next();
			java.util.Date data = sdf.parse(dataNasc);
			java.util.Date dtt = new java.sql.Date(data.getTime());
			System.out.println("Sexo do paciente:");
			String sexo = sc.next();
			obj.setNomePaciente(nome);
			obj.setDataNascPaciente(dtt);
			obj.setSexoPaciente(sexo);
			pacientedao.insert(obj);
			System.out.println("Novo paciente. Id do paciente = " + obj.getIdPaciente());
			break;

		case 2:
			Paciente pc = new Paciente();
			System.out.println("Informe o id do paciente que irá ser atualizado:");
			int id = sc.nextInt();
			System.out.println("informe o nome:");
			nome = sc.next();
			System.out.println("Data de Nascimento(dd/MM/yyyy):");
			dataNasc = sc.next();
			data = sdf.parse(dataNasc);
			dtt = new java.sql.Date(data.getTime());
			System.out.println("Sexo do paciente:");
			sexo = sc.next();
			pc = pacientedao.findById(id);
			pc.setNomePaciente(nome);
			pc.setDataNascPaciente(dtt);
			pc.setSexoPaciente(sexo);
			pacientedao.update(pc);
			break;


		case 3:
			System.out.println("Informe o Id do paciente que será deletado:");
			id = sc.nextInt();
			pacientedao.deleteById(id);
			break;

		case 4:
			List<Paciente> listpac = pacientedao.findAll();
			for (Paciente paciente : listpac) {
				System.out.println(paciente);
			}
			break;
		case 5:
			menuPrincipal();
		default:
			System.out.println("Opção invalida!");
			menuPaciente();
		}
		menuPaciente();
	}

	private static void menuConsulta() throws ParseException {
		PacienteDao pcdao = DaoFactory.criarPacienteDao();
		ConsultaDao consultadao = DaoFactory.criarNovaConsultaDao();
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfm = new SimpleDateFormat("HH:mm:ss");
		System.out.println("----------------------- MENU CONSULTAS -----------------------");
		System.out.println(" 1 - Cadastrar ");
		System.out.println(" 2 - Atualizar ");
		System.out.println(" 3 - Deletar ");
		System.out.println(" 4 - Listar Todos ");
		System.out.println(" 5 - Voltar para o menu principal");

		int opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			Consulta obj = new Consulta();
			Paciente pc = new Paciente();
			System.out.println("Informe o Id do paciente que irá ser consultado:");
			int idpc = sc.nextInt();
			obj.setPacienteObj(pcdao.findById(idpc));
			pc = obj.getPacienteObj();
			System.out.println("Data (dd/MM/yyyy):");
			String data = sc.next();
			System.out.println("Horario (HH:mm:ss):");
			String minutos = sc.next();
			System.out.println("Valor da consulta: R$");
			double valor = sc.nextDouble();
			java.util.Date dataa = sdf.parse(data);
			java.util.Date dtt = new java.sql.Date(dataa.getTime());
			java.util.Date hora = sdfm.parse(minutos);
			java.util.Date hr = new java.sql.Date(hora.getTime());
			obj.setDataConsulta(dtt);
			obj.setHorarioConsulta(hr);
			obj.setValorConsulta(valor);
			consultadao.insert(obj);
			System.out.println("Nova consulta. Id da Consulta = " + obj.getIdConsulta());
			break;
		case 2:
			Consulta cs = new Consulta();
			System.out.println("Informe o id da consulta que irá ser atualizada:");
			int id = sc.nextInt();
			cs = consultadao.findById(id);
			System.out.println("Data (dd/MM/yyyy):");
			data = sc.next();
			System.out.println("Horario (HH:mm:ss):");
			minutos = sc.next();
			System.out.println("Valor da consulta: R$");
			valor = sc.nextDouble();
			dataa = sdf.parse(data);
			dtt = new java.sql.Date(dataa.getTime());
			hora = sdfm.parse(minutos);
			hr = new java.sql.Date(hora.getTime());
			cs.setDataConsulta(dtt);
			cs.setHorarioConsulta(hr);
			cs.setValorConsulta(valor);
			consultadao.update(cs);
			break;
		case 3:
			System.out.println("Informe o Id da consulta que será deletada:");
			id = sc.nextInt();
			consultadao.deleteById(id);
			break;
		case 4:
			List<Consulta> listcons = consultadao.findAll();
			for (Consulta consulta : listcons) {
				System.out.println(consulta);
			}
			break;

		case 5:
			menuPrincipal();

		default:
			System.out.println("Opção invalida!");
			menuConsulta();
		}
		menuConsulta();
	}
}
