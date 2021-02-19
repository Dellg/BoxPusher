package objetos;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Spot {
	
	private Object dado;
	private boolean objetivo = false;
	private int indexLinha, indexColuna;
	private boolean obstaculo;

	// método construtor
	public Spot(int indexLinha, int indexColuna, Object dado){
		this.indexLinha = indexLinha;
		this.indexColuna = indexColuna;
		this.dado = dado;
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

	public boolean isObstaculo() {
		return obstaculo;
	}

	public void setObstaculo(boolean obstaculo) {
		this.obstaculo = obstaculo;
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
	
	// método que desenha algo no spot, dependendo do que estiver lá
	public void draw(JLabel label){
		if (dado != null && dado.toString().contains("Personagem")){
			Personagem temp = (Personagem) dado;
			label.setIcon(temp.getPersonagem());
		} else if (dado != null && dado.toString().contains("Caixa")){
			if (objetivo){
				Caixa temp = (Caixa) dado;
				label.setIcon(temp.getCaixaT());
			} else {
				Caixa temp = (Caixa) dado;
				label.setIcon(temp.getCaixaF());
			}
		} else if (objetivo){
			label.setIcon(new ImageIcon("resource/Objetivo.png"));
		} else {
			label.setIcon(null);
		}
	}
}
