package feliznocumpleaños;

public class AlimentoQueAchica extends Alimento {
	
	public AlimentoQueAchica(String nombre, Double precio) {
		super(nombre, precio);
		this.agranda = false;
		this.cantidadQueModifica = 50.0;
		this.limite = 80.0;
		
	}

}
