package inteligencia;

public class HiddenLayer {
	
	private Perceptron[] nodes;
	
	// método construtor
	public HiddenLayer(Perceptron[] nodes) {
		this.nodes = nodes;	
	}
	
	// método que gera o resultado para passar pra próxima layer
	public double[] calculaResultado() {
		double[] resultado = new double[nodes.length];
		for (int i = 0; i < nodes.length; i++) {
			resultado[i] = nodes[i].adivinhaValor();
		}
		return resultado;
	}
}
