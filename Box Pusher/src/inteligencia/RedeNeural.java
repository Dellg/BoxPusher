package inteligencia;

import com.sun.glass.events.KeyEvent;

import objetos.Spot;

public class RedeNeural {
	private HiddenLayer[] hiddenLayers;

	// método construtor
	public RedeNeural(Spot[][] inputLayer, int quantiaHiddenLayers) {
		// verifica as entradas (1 = personagem, 2 = caixa, 0 = null, x.5 = objetivo)
		double[] entradas = new double[inputLayer.length * inputLayer[0].length];
		for (int i = 0; i < inputLayer.length; i++) {
			for (int j = 0; j < inputLayer[i].length; j++) {
				if (inputLayer[i][j].getDado() != null)
					if (inputLayer[i][j].getDado().toString().contains("Personagem"))
						entradas[j * i] = 1;
					else if (inputLayer[i][j].getDado().toString().contains("Caixa"))
						entradas[j * i] = 2;
				else
					entradas[j * i] = 0;
				
				if (inputLayer[i][j].isObjetivo())
					entradas[j * i] = 0.5;
			}
		}
		
		// cria as hidden layers com seus perceptrons
		hiddenLayers = new HiddenLayer[quantiaHiddenLayers];
		for (int i = 0; i < quantiaHiddenLayers; i++) {
			if (i > 0)
				entradas = hiddenLayers[i - 1].calculaResultado();
			
			int quantiaPerceptronPerLayer = 10;
			Perceptron[] nodes = new Perceptron[quantiaPerceptronPerLayer];
			for (int j = 0; j < quantiaPerceptronPerLayer; j++) {
				nodes[j] = new Perceptron(entradas);
			}
			hiddenLayers[i] = new HiddenLayer(nodes);
		}
	}
	
	// retorna a saída
	public int retornaSaida() {
		double somatorio = 0;
		for (double d: hiddenLayers[hiddenLayers.length - 1].calculaResultado()) {
			somatorio += d;
		}
		
		if (somatorio >= -10 && somatorio < -5)
			return KeyEvent.VK_UP;
		else if (somatorio >= -5 && somatorio < 0)
			return KeyEvent.VK_RIGHT;
		else if (somatorio >= 0 && somatorio < 5)
			return KeyEvent.VK_DOWN;
		else
			return KeyEvent.VK_LEFT;
	}
}
