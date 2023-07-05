package feliznocumpleaños;

import java.util.Objects;

public abstract class Alimento implements Comparable<Alimento> {
	
	private Double precio;
	private String nombre;
	protected Boolean agranda;
	protected Double cantidadQueModifica;
	protected Double limite;

	public Alimento(String nombre, Double precio) {
		this.precio = precio;
		this.nombre = nombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		return Objects.equals(nombre, other.nombre);
	}
	@Override
	public int compareTo(Alimento o) {
	return this.nombre.compareTo(o.nombre);
	}
	
}
