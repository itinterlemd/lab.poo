package co.edu.itl.labjpa;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the conceptos_pago database table.
 * 
 */
@Entity
@Table(name="conceptos_pago")
@NamedQuery(name="ConceptoPago.findAll", query="SELECT c FROM ConceptoPago c")
public class ConceptoPago implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_concepto_pago", unique=true, nullable=false)
	private Long idConceptoPago;

	@Column(length=20)
	private String codigo;

	@Column(length=100)
	private String nombre;

	@Column(name="tipo_cuenta", precision=1)
	private BigDecimal tipoCuenta;

	private double valor;

	public ConceptoPago() {
	}

	public Long getIdConceptoPago() {
		return this.idConceptoPago;
	}

	public void setIdConceptoPago(Long idConceptoPago) {
		this.idConceptoPago = idConceptoPago;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getTipoCuenta() {
		return this.tipoCuenta;
	}

	public void setTipoCuenta(BigDecimal tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}