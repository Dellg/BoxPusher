package objetos;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Personagem {
	
	private int posicaoX, posicaoY;	
	private ImageIcon personagemIcon = new ImageIcon("resource/Personagem.png");
	
	// método construtor
	public Personagem(int posicaoX, int posicaoY){
		this.posicaoX = posicaoX;
		this.posicaoY = posicaoY;
	}
	
	// getters e setters
	public ImageIcon getPersonagem(){
		return personagemIcon;
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
	
	// método do personagem que movimenta
	public void movePersonagem(KeyEvent e, Spot[][] matriz, JPanel gamePainel) {
		Personagem personagemTemp = (Personagem) matriz[this.posicaoX][this.posicaoY].getDado();
		
		if (e.getKeyCode() == KeyEvent.VK_UP){
			if (this.posicaoX-1 >= 0){
				if (matriz[this.posicaoX-1][this.posicaoY].getDado() != null){
					if (this.posicaoX-2 >= 0 && matriz[this.posicaoX-2][this.posicaoY].getDado() == null){
						Caixa caixaTemp = (Caixa) matriz[this.posicaoX-1][this.posicaoY].getDado();
						matriz[this.posicaoX][this.posicaoY].setDado(null);
						JLabel aux = (JLabel) gamePainel.getComponent(this.posicaoY + this.posicaoX * matriz.length);
						matriz[this.posicaoX][this.posicaoY].draw(aux);
						this.posicaoX--;
						matriz[this.posicaoX][this.posicaoY].setDado(personagemTemp);
						matriz[this.posicaoX-1][this.posicaoY].setDado(caixaTemp);
						caixaTemp.setPosicaoX(posicaoX-1);
						
						JLabel labelTemp = (JLabel) gamePainel.getComponent(this.posicaoY + (this.posicaoX-1) * matriz.length);
						matriz[this.posicaoX-1][this.posicaoY].draw(labelTemp);
					}
				} else {
					matriz[this.posicaoX][this.posicaoY].setDado(null);
					JLabel aux = (JLabel) gamePainel.getComponent(this.posicaoY + this.posicaoX * matriz.length);
					matriz[this.posicaoX][this.posicaoY].draw(aux);
					this.posicaoX--;
					matriz[this.posicaoX][this.posicaoY].setDado(personagemTemp);
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			if (this.posicaoX+1 < matriz.length){
				if (matriz[this.posicaoX+1][this.posicaoY].getDado() != null){
					if (this.posicaoX+2 < matriz.length && matriz[this.posicaoX+2][this.posicaoY].getDado() == null){
						Caixa caixaTemp = (Caixa) matriz[this.posicaoX+1][this.posicaoY].getDado();
						matriz[this.posicaoX][this.posicaoY].setDado(null);
						JLabel aux = (JLabel) gamePainel.getComponent(this.posicaoY + this.posicaoX * matriz.length);
						matriz[this.posicaoX][this.posicaoY].draw(aux);
						this.posicaoX++;
						matriz[this.posicaoX][this.posicaoY].setDado(personagemTemp);
						matriz[this.posicaoX+1][this.posicaoY].setDado(caixaTemp);
						caixaTemp.setPosicaoX(posicaoX+1);
						
						JLabel labelTemp = (JLabel) gamePainel.getComponent(this.posicaoY + (this.posicaoX+1) * matriz.length);
						matriz[this.posicaoX+1][this.posicaoY].draw(labelTemp);
						
					}
				} else {
					matriz[this.posicaoX][this.posicaoY].setDado(null);
					JLabel aux = (JLabel) gamePainel.getComponent(this.posicaoY + this.posicaoX * matriz.length);
					matriz[this.posicaoX][this.posicaoY].draw(aux);
					this.posicaoX++;
					matriz[this.posicaoX][this.posicaoY].setDado(personagemTemp);
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			if (this.posicaoY-1 >= 0){
				if (matriz[this.posicaoX][this.posicaoY-1].getDado() != null){
					if (this.posicaoY-2 >= 0 && matriz[this.posicaoX][this.posicaoY-2].getDado() == null){
						Caixa caixaTemp = (Caixa) matriz[this.posicaoX][this.posicaoY-1].getDado();
						matriz[this.posicaoX][this.posicaoY].setDado(null);
						JLabel aux = (JLabel) gamePainel.getComponent(this.posicaoY + this.posicaoX * matriz.length);
						matriz[this.posicaoX][this.posicaoY].draw(aux);
						this.posicaoY--;
						matriz[this.posicaoX][this.posicaoY].setDado(personagemTemp);
						matriz[this.posicaoX][this.posicaoY-1].setDado(caixaTemp);
						caixaTemp.setPosicaoY(posicaoY-1);
						
						JLabel labelTemp = (JLabel) gamePainel.getComponent(this.posicaoY-1 + this.posicaoX * matriz.length);
						matriz[this.posicaoX][this.posicaoY-1].draw(labelTemp);
					}
				} else {
					matriz[this.posicaoX][this.posicaoY].setDado(null);
					JLabel aux = (JLabel) gamePainel.getComponent(this.posicaoY + this.posicaoX * matriz.length);
					matriz[this.posicaoX][this.posicaoY].draw(aux);
					this.posicaoY--;
					matriz[this.posicaoX][this.posicaoY].setDado(personagemTemp);
				}
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			if (this.posicaoY+1 < matriz.length){
				if (matriz[this.posicaoX][this.posicaoY+1].getDado() != null){
					if (this.posicaoY+2 < matriz.length && matriz[this.posicaoX][this.posicaoY+2].getDado() == null){
						Caixa caixaTemp = (Caixa) matriz[this.posicaoX][this.posicaoY+1].getDado();
						matriz[this.posicaoX][this.posicaoY].setDado(null);
						JLabel aux = (JLabel) gamePainel.getComponent(this.posicaoY + this.posicaoX * matriz.length);
						matriz[this.posicaoX][this.posicaoY].draw(aux);
						this.posicaoY++;
						matriz[this.posicaoX][this.posicaoY].setDado(personagemTemp);
						matriz[this.posicaoX][this.posicaoY+1].setDado(caixaTemp);
						caixaTemp.setPosicaoY(posicaoY+1);
						
						JLabel labelTemp = (JLabel) gamePainel.getComponent(this.posicaoY+1 + this.posicaoX * matriz.length);
						matriz[this.posicaoX][this.posicaoY+1].draw(labelTemp);
					}				
				} else {
					matriz[this.posicaoX][this.posicaoY].setDado(null);
					JLabel aux = (JLabel) gamePainel.getComponent(this.posicaoY + this.posicaoX * matriz.length);
					matriz[this.posicaoX][this.posicaoY].draw(aux);
					this.posicaoY++;
					matriz[this.posicaoX][this.posicaoY].setDado(personagemTemp);
				}
			}
		}

		JLabel temp = (JLabel) gamePainel.getComponent(this.posicaoY + this.posicaoX * matriz.length);
		matriz[this.posicaoX][this.posicaoY].draw(temp);
	}
	
}
