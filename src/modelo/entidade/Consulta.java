package modelo.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idConsulta;
	private Date dataConsulta;
	private Date horarioConsulta;
	private Double valorConsulta;
	Paciente pacienteObj = new Paciente();

	public Consulta() {
	};

	public Consulta(Integer idConsulta, Date dataConsulta, Date horarioConsulta, Double valorConsulta,
			Paciente pacienteObj) {
		this.idConsulta = idConsulta;
		this.dataConsulta = dataConsulta;
		this.horarioConsulta = horarioConsulta;
		this.valorConsulta = valorConsulta;
		this.pacienteObj = pacienteObj;
	}

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Date getHorarioConsulta() {
		return horarioConsulta;
	}

	public void setHorarioConsulta(Date horarioConsulta) {
		this.horarioConsulta = horarioConsulta;
	}

	public Double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(Double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public Paciente getPacienteObj() {
		return pacienteObj;
	}

	public void setPacienteObj(Paciente pacienteObj) {
		this.pacienteObj = pacienteObj;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idConsulta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		return Objects.equals(idConsulta, other.idConsulta);
	}

	@Override
	public String toString() {
		return "Consulta"
				+ " [id da Consulta=" + idConsulta + ", Data da Consulta=" + dataConsulta + ", Horario da Consulta="
				+ horarioConsulta + ", Valor da Consulta=" + valorConsulta + ", Paciente=" + pacienteObj + "]";
	}

}
