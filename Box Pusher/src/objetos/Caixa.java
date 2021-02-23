package objetos;

import javax.swing.ImageIcon;

public class Caixa {
	
	private int posicaoX, posicaoY;
	private ImageIcon caixaFalseIcon = new ImageIcon("resource/CaixaF.png");
	private ImageIcon caixaTrueIcon = new ImageIcon("resource/CaixaT.png");
	
	// m�todo construtor
	public Caixa(int posicaoX, int posicaoY){
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}
	
	// getters e setters
	public ImageIcon getCaixaF(){
		return caixaFalseIcon;
	}
	public ImageIcon getCaixaT(){
		return caixaTrueIcon;
	}

	public int getPosicaoX() {
		return posicaoX;
	}
	public void setPosicaoX(int posicaoX) {
		this.posicaoX = posicaoX;
	}

	public int getPosicaoY() {
		return posicaoY;
	}
	public void setPosicaoY(int posicaoY) {
		this.posicaoY = posicaoY;
	}

}
