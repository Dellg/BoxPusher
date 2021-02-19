package objetos;

import javax.swing.ImageIcon;

public class Personagem {
	
	private int posicaoX, posicaoY;	
	private ImageIcon personagemIcon = new ImageIcon("resource/Personagem.png");
	private int movimentos;
	
	// método construtor
	public Personagem(int posicaoX, int posicaoY){
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}
	
	// getters e setters
	public ImageIcon getPersonagem(){
		return personagemIcon;
	}

	public int getMovimentos() {
		return movimentos;
	}
	public void setMovimentos(int movimentos) {
		this.movimentos = movimentos;
	}
	public void aumentaMovimentos() {
		this.movimentos++;
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
