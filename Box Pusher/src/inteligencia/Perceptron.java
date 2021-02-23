package inteligencia;

import java.util.Random;

public class Perceptron {
	
	private double[] entradas;
	private double[] pesos;
	private double bias = 1;
	private double somatorio;
	
	// método construtor
	public Perceptron(double[] entradas) {
		this.entradas = entradas;
		pesos = new double[entradas.length];
		Random r = new Random();
		for (int i = 0; i < entradas.length; i++) {
			pesos[i] = (r.nextInt(10000 + 10000) - 10000)/10000.0;
		}
	}

	// método que calcula os valores de entrada junto com os pesos
	public double adivinhaValor() {
		for (int i = 0; i < entradas.length; i++) {
			somatorio += pesos[i] * entradas[i];
		}
		return funcaoAtivacao(bias + somatorio);
	}
	
	// função de ativação
	private double funcaoAtivacao(double somatorio) {
		return somatorio >= 0 ? 1 : -1;
	}
}
