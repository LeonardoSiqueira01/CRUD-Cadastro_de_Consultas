package modelo.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idPaciente;
	private String nomePaciente;
	private Date dataNascPaciente;
	private String sexoPaciente;

	public Paciente() {
	}

	public Paciente(Integer idPaciente, String nomePaciente, Date dataNascPaciente, String sexoPaciente) {
		this.idPaciente = idPaciente;
		this.nomePaciente = nomePaciente;
		this.dataNascPaciente = dataNascPaciente;
		this.sexoPaciente = sexoPaciente;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public Date getDataNascPaciente() {
		return dataNascPaciente;
	}

	public void setDataNascPaciente(Date dataNascPaciente) {
		this.dataNascPaciente = dataNascPaciente;
	}

	public String getSexoPaciente() {
		return sexoPaciente;
	}

	public void setSexoPaciente(String sexoPaciente) {
		this.sexoPaciente = sexoPaciente;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idPaciente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(idPaciente, other.idPaciente);
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", nomePaciente=" + nomePaciente + ", dataNascPaciente="
				+ dataNascPaciente + ", sexoPaciente=" + sexoPaciente + "]";
	}

}
