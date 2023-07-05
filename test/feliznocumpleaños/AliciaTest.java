package feliznocumpleaños;

import static org.junit.Assert.*;

import org.junit.Test;

public class AliciaTest {

	@Test
	public void queAlComprarSeDescuenteDinero() {
		Personaje alicia = new Personaje(180.0, 55.5, "Alicia", 15, 1000.0);
		Alimento caramelo = new AlimentoQueAgranda("sugus", 150.0);
		alicia.comprar(caramelo);
		assertEquals((Double)850.0, alicia.getDineroParaComprar());
	}
	
	@Test
	public void verificarQueSeAgrande() throws NoSePuedeConsumir {
		Personaje alicia = new Personaje(180.0, 55.5, "Alicia", 15, 1000.0);
		Alimento caramelo = new AlimentoQueAgranda("sugus",150.0);
		alicia.comprar(caramelo);
		alicia.consumir(caramelo);
		assertEquals((Double)220.0, alicia.getAltura());
	}

	@Test
	public void verificarQueSeEncoja() throws NoSePuedeConsumir {
		Personaje alicia = new Personaje(180.0, 55.5, "Alicia", 15, 1000.0);
		Alimento alfajor = new AlimentoQueAchica("oreo", 150.0);
		alicia.comprar(alfajor);
		alicia.consumir(alfajor);
		assertEquals((Double)130.0, alicia.getAltura());
	}
	
	@Test
	public void siSeConsumeTieneQueEliminarse() throws NoSePuedeConsumir {
		Personaje alicia = new Personaje(180.0, 55.5, "Alicia", 15, 1000.0);
		Alimento alfajor = new AlimentoQueAchica("oreo", 150.0);
		Alimento caramelo = new AlimentoQueAgranda("sugus",150.0);
		alicia.comprar(alfajor);
		alicia.comprar(caramelo);
		alicia.consumir(alfajor);
		Integer valorObtenido = alicia.getAlimentos().size();
		assertEquals((Integer)1, valorObtenido);
	}
	
	
	@Test  (expected = NoSePuedeConsumir.class)
	public void queNoPuedaAgrandarse() throws NoSePuedeConsumir {
		Personaje alicia = new Personaje(180.0, 55.5, "Alicia", 15, 1000.0);
		Alimento chocolate = new AlimentoQueAgranda("milka",150.0);
		Alimento caramelo = new AlimentoQueAgranda("sugus",150.0);
		Alimento gomita = new AlimentoQueAgranda("jimmy", 150.0);
		alicia.comprar(gomita);
		alicia.comprar(caramelo);
		alicia.comprar(chocolate);
		assertTrue(alicia.consumir(gomita));
		assertTrue(alicia.consumir(caramelo));
		assertFalse(alicia.consumir(chocolate));
	}
	
	@Test (expected = NoSePuedeConsumir.class)
	public void queNoPuedaEncogerse() throws NoSePuedeConsumir {
		Personaje alicia = new Personaje(180.0, 55.5, "Alicia", 15, 1000.0);
		Alimento alfajor = new AlimentoQueAchica("oreo", 150.0);
		Alimento bagel = new AlimentoQueAchica("dona", 150.0);
		Alimento masita = new AlimentoQueAchica("tortita negra", 150.0);
		alicia.comprar(masita);
		alicia.comprar(bagel);
		alicia.comprar(alfajor);
		assertTrue(alicia.consumir(masita));
		assertTrue(alicia.consumir(bagel));
		assertFalse(alicia.consumir(alfajor));
	}
	
	@Test
	public void queSeOrdenenLosAlimentos() {
		Personaje alicia = new Personaje(180.0, 55.5, "Alicia", 15, 1000.0);
		Alimento alfajor = new AlimentoQueAchica("oreo", 10.0);
		Alimento bagel = new AlimentoQueAchica("dona", 10.0);
		Alimento masita = new AlimentoQueAchica("tortita negra", 10.0);
		Alimento chocolate = new AlimentoQueAgranda("milka",10.0);
		Alimento caramelo = new AlimentoQueAgranda("sugus",50.0);
		Alimento gomita = new AlimentoQueAgranda("jimmy", 50.0);
		
		alicia.comprar(alfajor);
		alicia.comprar(bagel);
		alicia.comprar(masita);
		alicia.comprar(chocolate);
		alicia.comprar(caramelo);
		alicia.comprar(gomita);
		
		assertTrue(bagel.equals(alicia.ordenarAlimentosPorNombre().get(0)));
		assertTrue(gomita.equals(alicia.ordenarAlimentosPorNombre().get(1)));
		assertTrue(chocolate.equals(alicia.ordenarAlimentosPorNombre().get(2)));
		assertTrue(alfajor.equals(alicia.ordenarAlimentosPorNombre().get(3)));
		assertTrue(caramelo.equals(alicia.ordenarAlimentosPorNombre().get(4)));
		assertTrue(masita.equals(alicia.ordenarAlimentosPorNombre().get(5)));
	}
}
