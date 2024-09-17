package controller;

import java.util.concurrent.Semaphore;

public class CarrosController extends Thread{

	Semaphore cruzamento;
	static int sentido;
	static int sentidoat = 0;
	static String direcao = "";
	int iD = (int) threadId();
	
	public CarrosController(Semaphore cruzamento) {
		this.cruzamento = cruzamento;
	}
	
	@Override
	public void run() {
		farol();
	}

	public void farol() {
		try {
			cruzamento.acquire();
			sentido = (int) ((Math.random() * 4) + 1);
			if (sentido == sentidoat) {
				System.out.println("O Carro #" + iD + " está passando pelo cruzamento agora no sentido " + direcao + ".");
				sleep(700);
			} else if (sentido == 1) {
				direcao = "Leste";
				System.out.println("O Carro #" + iD + " está passando pelo cruzamento agora no sentido " + direcao + ".");
				sentidoat = sentido;
				sleep(2000);
			} else if (sentido == 2) {
				direcao = "Sul";
				System.out.println("O Carro #" + iD + " está passando pelo cruzamento agora no sentido " + direcao + ".");
				sentidoat = sentido;
				sleep(3000);
			} else if (sentido == 3) {
				direcao = "Oeste";
				System.out.println("O Carro #" + iD + " está passando pelo cruzamento agora no sentido " + direcao + ".");
				sentidoat = sentido;
				sleep(3000);
			} else if (sentido == 4) {
				direcao = "Norte";
				System.out.println("O Carro #" + iD + " está passando pelo cruzamento agora no sentido " + direcao + ".");
				sentidoat = sentido;
				sleep(3000);
			}
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			cruzamento.release();
		}
	}
	
}
