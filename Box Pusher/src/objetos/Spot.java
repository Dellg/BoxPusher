package objetos;

import javax.swing.ImageIcon;

public class Spot {
	
	private Object dado;
	private boolean objetivo = false;
	private int indexLinha, indexColuna;

	// método construtor
	public Spot(int indexLinha, int indexColuna, Object dado, boolean objetivo){
		this.indexLinha = indexLinha;
		this.indexColuna = indexColuna;
		this.dado = dado;
		this.objetivo = objetivo;
	}
	
	// getters e setters
	public int getIndexLinha() {
		return indexLinha;
	}
	public void setIndexLinha(int indexLinha) {
		this.indexLinha = indexLinha;
	}

	public int getIndexColuna() {
		return indexColuna;
	}
	public void setIndexColuna(int indexColuna) {
		this.indexColuna = indexColuna;
	}

	public Object getDado() {
		return dado;
	}
	public void setDado(Object dado) {
		this.dado = dado;
	}

	public boolean isObjetivo() {
		return objetivo;
	}
	public void setObjetivo(boolean objetivo) {
		this.objetivo = objetivo;
	}
	
	// método que retorna a imagem para desenhar no spot
	public ImageIcon getImagem() {
		if (dado != null) {
			// retorna imagem do personagem
			if (dado.toString().contains("Personagem")) {
				return ((Personagem) dado).getPersonagem();
			// retorna imagem da caixa (caixaT se está no objetivo, caixaF se não está)
			} else if (dado.toString().contains("Caixa"))
				return (objetivo ? ((Caixa) dado).getCaixaT() : ((Caixa) dado).getCaixaF());
		// retorna imagem do objetivo
		} else if (objetivo)
				return new ImageIcon("resource/Objetivo.png");
		return null;
	}
}
