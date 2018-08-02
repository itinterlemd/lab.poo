package co.edu.itl.labjpa;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the inscripciones database table.
 * 
 */
@Embeddable
public class InscripcionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_persona", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer idPersona;

	@Column(name="id_programa", insertable=false, updatable=false, unique=true, nullable=false)
	private Integer idPrograma;

	public InscripcionPK() {
	}
	public Integer getIdPersona() {
		return this.idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public Integer getIdPrograma() {
		return this.idPrograma;
	}
	public void setIdPrograma(Integer idPrograma) {
		this.idPrograma = idPrograma;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof InscripcionPK)) {
			return false;
		}
		InscripcionPK castOther = (InscripcionPK)other;
		return 
			this.idPersona.equals(castOther.idPersona)
			&& this.idPrograma.equals(castOther.idPrograma);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idPersona.hashCode();
		hash = hash * prime + this.idPrograma.hashCode();
		
		return hash;
	}
}