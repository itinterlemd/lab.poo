package co.edu.itl.labjpa;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the recibos database table.
 * 
 */
@Entity
@Table(name="recibos")
@NamedQuery(name="Recibo.findAll", query="SELECT r FROM Recibo r")
public class Recibo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_recibo", unique=true, nullable=false)
	private Long idRecibo;

	@Column(length=100)
	private String descripcion;

	private Integer estado;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	@Column(name="valor_total")
	private double valorTotal;

	@Column(name="valor_total_debe")
	private double valorTotalDebe;

	@Column(name="valor_total_haber")
	private double valorTotalHaber;

	//bi-directional many-to-one association to DetalleRecibo
	@OneToMany(mappedBy="recibo")
	private List<DetalleRecibo> detalleRecibo;

	//uni-directional many-to-one association to Persona
	@ManyToOne
	@JoinColumn(name="id_persona")
	private Persona persona;

	public Recibo() {
	}

	public Long getIdRecibo() {
		return this.idRecibo;
	}

	public void setIdRecibo(Long idRecibo) {
		this.idRecibo = idRecibo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public double getValorTotalDebe() {
		return this.valorTotalDebe;
	}

	public void setValorTotalDebe(double valorTotalDebe) {
		this.valorTotalDebe = valorTotalDebe;
	}

	public double getValorTotalHaber() {
		return this.valorTotalHaber;
	}

	public void setValorTotalHaber(double valorTotalHaber) {
		this.valorTotalHaber = valorTotalHaber;
	}

	public List<DetalleRecibo> getDetalleRecibo() {
		return this.detalleRecibo;
	}

	public void setDetalleRecibo(List<DetalleRecibo> detalleRecibo) {
		this.detalleRecibo = detalleRecibo;
	}

	public DetalleRecibo addDetalleRecibo(DetalleRecibo detalleRecibo) {
		getDetalleRecibo().add(detalleRecibo);
		detalleRecibo.setRecibo(this);

		return detalleRecibo;
	}

	public DetalleRecibo removeDetalleRecibo(DetalleRecibo detalleRecibo) {
		getDetalleRecibo().remove(detalleRecibo);
		detalleRecibo.setRecibo(null);

		return detalleRecibo;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}