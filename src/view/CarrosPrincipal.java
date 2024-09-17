package view;

import java.util.concurrent.Semaphore;
import controller.CarrosController;

public class CarrosPrincipal {

	public static void main(String[] args) {
		int carros = 10;
		Semaphore cruzamento = new Semaphore(1);
		
		for(int i = 0; i < carros; i++) {
			CarrosController carCon = new CarrosController(cruzamento);
			carCon.run();
		}

	}

}
