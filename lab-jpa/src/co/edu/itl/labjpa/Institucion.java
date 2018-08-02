package co.edu.itl.labjpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the instituciones database table.
 * 
 */
@Entity
@Table(name="instituciones")
@NamedQuery(name="Institucion.findAll", query="SELECT i FROM Institucion i")
public class Institucion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_institucion", unique=true, nullable=false)
	private Integer idInstitucion;

	@Column(nullable=false)
	private Integer nit;

	@Column(nullable=false, length=100)
	private String nombre;

	//bi-directional many-to-one association to Estudiante
	@OneToMany(mappedBy="institucion")
	private List<Estudiante> estudiantes;

	//bi-directional many-to-one association to Programa
	@OneToMany(mappedBy="institucion")
	private List<Programa> programas;

	public Institucion() {
	}

	public Integer getIdInstitucion() {
		return this.idInstitucion;
	}

	public void setIdInstitucion(Integer idInstitucion) {
		this.idInstitucion = idInstitucion;
	}

	public Integer getNit() {
		return this.nit;
	}

	public void setNit(Integer nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Estudiante> getEstudiantes() {
		return this.estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Estudiante addEstudiante(Estudiante estudiante) {
		getEstudiantes().add(estudiante);
		estudiante.setInstitucion(this);

		return estudiante;
	}

	public Estudiante removeEstudiante(Estudiante estudiante) {
		getEstudiantes().remove(estudiante);
		estudiante.setInstitucion(null);

		return estudiante;
	}

	public List<Programa> getProgramas() {
		return this.programas;
	}

	public void setProgramas(List<Programa> programas) {
		this.programas = programas;
	}

	public Programa addPrograma(Programa programa) {
		getProgramas().add(programa);
		programa.setInstitucion(this);

		return programa;
	}

	public Programa removePrograma(Programa programa) {
		getProgramas().remove(programa);
		programa.setInstitucion(null);

		return programa;
	}

}