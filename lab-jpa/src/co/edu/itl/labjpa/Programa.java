package co.edu.itl.labjpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the programas database table.
 * 
 */
@Entity
@Table(name="programas")
@NamedQuery(name="Programa.findAll", query="SELECT p FROM Programa p")
public class Programa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_programa", unique=true, nullable=false)
	private Integer idPrograma;

	private Integer codigo;

	@Column(length=1)
	private String estado;

	@Column(nullable=false, length=100)
	private String nombre;

	@Column(name="tipo_programa")
	private Integer tipoPrograma;

	//bi-directional many-to-one association to Inscripcion
	@OneToMany(mappedBy="programa")
	private List<Inscripcion> inscripciones;

	//bi-directional many-to-one association to Institucion
	@ManyToOne
	@JoinColumn(name="id_institucion")
	private Institucion institucion;

	public Programa() {
	}

	public Integer getIdPrograma() {
		return this.idPrograma;
	}

	public void setIdPrograma(Integer idPrograma) {
		this.idPrograma = idPrograma;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getTipoPrograma() {
		return this.tipoPrograma;
	}

	public void setTipoPrograma(Integer tipoPrograma) {
		this.tipoPrograma = tipoPrograma;
	}

	public List<Inscripcion> getInscripciones() {
		return this.inscripciones;
	}

	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	public Inscripcion addInscripcione(Inscripcion inscripcione) {
		getInscripciones().add(inscripcione);
		inscripcione.setPrograma(this);

		return inscripcione;
	}

	public Inscripcion removeInscripcione(Inscripcion inscripcione) {
		getInscripciones().remove(inscripcione);
		inscripcione.setPrograma(null);

		return inscripcione;
	}

	public Institucion getInstitucion() {
		return this.institucion;
	}

	public void setInstitucion(Institucion institucion) {
		this.institucion = institucion;
	}

}