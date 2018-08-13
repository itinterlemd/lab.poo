package co.edu.itl.labjpa;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the detalle_recibos database table.
 * 
 */
@Entity
@Table(name="detalle_recibos")
@NamedQuery(name="DetalleRecibo.findAll", query="SELECT d FROM DetalleRecibo d")
public class DetalleRecibo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_det_recibo", unique=true, nullable=false)
	private Long idDetRecibo;

	private Integer cantidad;

	@Column(name="valor_debe")
	private double valorDebe;

	@Column(name="valor_haber")
	private double valorHaber;

	@Column(name="valor_unitario")
	private double valorUnitario;

	//uni-directional many-to-one association to ConceptoPago
	@ManyToOne
	@JoinColumn(name="id_concepto_pago")
	private ConceptoPago conceptosPago;

	//bi-directional many-to-one association to Recibo
	@ManyToOne
	@JoinColumn(name="id_recibo")
	private Recibo recibo;

	public DetalleRecibo() {
	}

	public Long getIdDetRecibo() {
		return this.idDetRecibo;
	}

	public void setIdDetRecibo(Long idDetRecibo) {
		this.idDetRecibo = idDetRecibo;
	}

	public Integer getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public double getValorDebe() {
		return this.valorDebe;
	}

	public void setValorDebe(double valorDebe) {
		this.valorDebe = valorDebe;
	}

	public double getValorHaber() {
		return this.valorHaber;
	}

	public void setValorHaber(double valorHaber) {
		this.valorHaber = valorHaber;
	}

	public double getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public ConceptoPago getConceptosPago() {
		return this.conceptosPago;
	}

	public void setConceptosPago(ConceptoPago conceptosPago) {
		this.conceptosPago = conceptosPago;
	}

	public Recibo getRecibo() {
		return this.recibo;
	}

	public void setRecibo(Recibo recibo) {
		this.recibo = recibo;
	}

}