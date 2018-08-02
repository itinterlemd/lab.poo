package co.edu.itl.labjpa;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the inscripciones database table.
 * 
 */
@Entity
@Table(name="inscripciones")
@NamedQuery(name="Inscripcion.findAll", query="SELECT i FROM Inscripcion i")
public class Inscripcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private InscripcionPK id;

	@Column(name="fecha_incripcion")
	private Timestamp fechaIncripcion;

	@Column(length=200)
	private String observacion;

	//uni-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona", nullable=false, insertable=false, updatable=false)
	private Persona persona;

	//bi-directional many-to-one association to Programa
	@ManyToOne
	@JoinColumn(name="id_programa", nullable=false, insertable=false, updatable=false)
	private Programa programa;

	public Inscripcion() {
	}

	public InscripcionPK getId() {
		return this.id;
	}

	public void setId(InscripcionPK id) {
		this.id = id;
	}

	public Timestamp getFechaIncripcion() {
		return this.fechaIncripcion;
	}

	public void setFechaIncripcion(Timestamp fechaIncripcion) {
		this.fechaIncripcion = fechaIncripcion;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Programa getPrograma() {
		return this.programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

}