package feliznocumpleaños;

public class AlimentoQueAgranda extends Alimento {
	
	public AlimentoQueAgranda(String nombre,Double precio) {
		super(nombre, precio);
		this.agranda = true;
		this.cantidadQueModifica = 40.0;
		this.limite = 260.0;
	
	}

	

}
