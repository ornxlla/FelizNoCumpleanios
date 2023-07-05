package feliznocumpleaños;

import java.util.Collections;
import java.util.LinkedList;

public class Personaje {

	private Double altura;
	private Double peso;
	private String nombre;
	private Integer edad;
	private Double dineroParaComprar;
	private LinkedList <Alimento> alimentos = new LinkedList<Alimento>();

	public Personaje(Double altura, Double peso, String nombre, Integer edad, Double dineroParaComprar) {
		this.altura = altura;
		this.peso = peso;
		this.nombre = nombre;
		this.edad = edad;
		this.dineroParaComprar = dineroParaComprar;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Double getDineroParaComprar() {
		return dineroParaComprar;
	}

	public void setDineroParaComprar(Double dineroParaComprar) {
		this.dineroParaComprar = dineroParaComprar;
	}

	public void comprar(Alimento alimento) {
		this.alimentos.add(alimento);
		this.dineroParaComprar = this.dineroParaComprar - alimento.getPrecio();
		
	}

	public LinkedList<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(LinkedList<Alimento> alimentos) {
		this.alimentos = alimentos;
	}


	public Boolean consumir (Alimento alimento) throws NoSePuedeConsumir {
		if(alimento.agranda == true && this.alimentos.contains(alimento)) {
			if(this.getAltura() < alimento.limite) {
				this.setAltura(this.getAltura() + alimento.cantidadQueModifica);
				this.alimentos.remove(alimento);
				return true;
				
			}	throw new NoSePuedeConsumir("No puedo agrandar mas");
			
		} else if (alimento.agranda == false && this.alimentos.contains(alimento)) {
			if(this.getAltura() > alimento.limite) {
				this.setAltura(this.getAltura() - alimento.cantidadQueModifica);
				this.alimentos.remove(alimento);
				return true;
				
			} throw new NoSePuedeConsumir("No puedo encogerme mas");
		}
		return false;
	} 
	
	public LinkedList<Alimento> ordenarAlimentosPorNombre() {
		Collections.sort(this.alimentos);
		return this.alimentos;
	}
}
