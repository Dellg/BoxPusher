package objetos;

import java.awt.event.KeyEvent;

public class Jogo {
	
	private int tamanho = 4;
	private Spot[][] config = new Spot[tamanho][tamanho];
	private Personagem player = new Personagem(0, 3);
	private Caixa caixa1 = new Caixa(1, 0), caixa2 = new Caixa(1, 1), caixa3 = new Caixa(1, 2);
	// no plano cartesiano -> coluna = x, linha = y
	
	/* método construtor que cria a matriz com a configuração:
		|.|x| |.|
		| |x| | |
		| |x| |.|
		|o| | | |
	  
		o = player
		x = caixa
		. = objetivo
	*/
	public Jogo() {
		for (int linha = 0; linha < tamanho; linha++) {
			for (int coluna = 0; coluna < tamanho; coluna++) {
				// adiciona objetivos
				if ((linha == 0 && coluna == 0) || (linha == 0 && coluna == 3) || (linha == 2 && coluna == 3))
					config[coluna][linha] = new Spot(linha, coluna, null, true);
				// adiciona spots vazios
				else
					config[coluna][linha] = new Spot(linha, coluna, null, false);
			}
		}
		
		// adiciona personagem e caixas à matriz
		config[0][3].setDado(player);
		config[1][0].setDado(caixa1);
		config[1][1].setDado(caixa2);
		config[1][2].setDado(caixa3);
	}
	
	// getters e setters
	public Personagem getPersonagem() {
		return player;
	}
	public void setPersonagem(Personagem personagem) {
		this.player = personagem;
	}

	public int getTamanho() {
		return tamanho;
	}
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public Spot[][] getConfiguracao() {
		return config;
	}
	public void setConfiguracao(Spot[][] matriz) {
		this.config = matriz;
	}
	
	// método que retorna se o jogo foi finalizado ou não
	public boolean jogoFinalizado() {
		try {
			return (config[0][0].getDado().toString().contains("Caixa") &&
					config[3][0].getDado().toString().contains("Caixa") &&
					config[3][2].getDado().toString().contains("Caixa")) ? true : false;
		} catch (Exception e) {
			return false;
		}
	}
	
	// método que movimenta o personagem dentro da matriz
	public void movimentaPersonagem(int e) {
		switch (e) {
		case KeyEvent.VK_UP:
			if (player.getPosicaoY() > 0)
				if (config[player.getPosicaoX()][player.getPosicaoY()-1] != null)
					// verifica se tem uma caixa e a possibilidade de movê-la
					if (config[player.getPosicaoX()][player.getPosicaoY()-1].getDado() != null)
						if (config[player.getPosicaoX()][player.getPosicaoY()-1].getDado().toString().contains("Caixa")
								&& config[player.getPosicaoX()][player.getPosicaoY()-2].getDado() == null)
							config[player.getPosicaoX()][player.getPosicaoY()-2].setDado(config[player.getPosicaoX()][player.getPosicaoY()-1].getDado());		
						else return;
					
					// move o personagem pra cima
					config[player.getPosicaoX()][player.getPosicaoY()].setDado(null);
					player.setPosicaoY(player.getPosicaoY()-1);
					config[player.getPosicaoX()][player.getPosicaoY()].setDado(player);
					player.aumentaMovimentos();
			break;
		case KeyEvent.VK_DOWN:
			if (player.getPosicaoY() < 3)
				if (config[player.getPosicaoX()][player.getPosicaoY()+1] != null)
					// verifica se tem uma caixa e a possibilidade de movê-la
					if (config[player.getPosicaoX()][player.getPosicaoY()+1].getDado() != null)
						if (config[player.getPosicaoX()][player.getPosicaoY()+1].getDado().toString().contains("Caixa")
								&& config[player.getPosicaoX()][player.getPosicaoY()+2].getDado() == null)
							config[player.getPosicaoX()][player.getPosicaoY()+2].setDado(config[player.getPosicaoX()][player.getPosicaoY()+1].getDado());		
						else return;
					
					// move o personagem pra baixo
					config[player.getPosicaoX()][player.getPosicaoY()].setDado(null);
					player.setPosicaoY(player.getPosicaoY()+1);
					config[player.getPosicaoX()][player.getPosicaoY()].setDado(player);
					player.aumentaMovimentos();
			break;
		case KeyEvent.VK_LEFT:
			if (player.getPosicaoX() > 0)
				if (config[player.getPosicaoX()-1][player.getPosicaoY()] != null)
					// verifica se tem uma caixa e a possibilidade de movê-la
					if (config[player.getPosicaoX()-1][player.getPosicaoY()].getDado() != null)
						if (config[player.getPosicaoX()-1][player.getPosicaoY()].getDado().toString().contains("Caixa")
								&& config[player.getPosicaoX()-2][player.getPosicaoY()].getDado() == null)
							config[player.getPosicaoX()-2][player.getPosicaoY()].setDado(config[player.getPosicaoX()-1][player.getPosicaoY()].getDado());		
						else return;
					
					// move o personagem pra esquerda
					config[player.getPosicaoX()][player.getPosicaoY()].setDado(null);
					player.setPosicaoX(player.getPosicaoX()-1);
					config[player.getPosicaoX()][player.getPosicaoY()].setDado(player);
					player.aumentaMovimentos();
			break;
		case KeyEvent.VK_RIGHT:
			if (player.getPosicaoX() < 3)
				if (config[player.getPosicaoX()+1][player.getPosicaoY()] != null)
					// verifica se tem uma caixa e a possibilidade de movê-la
					if (config[player.getPosicaoX()+1][player.getPosicaoY()].getDado() != null)
						if (config[player.getPosicaoX()+1][player.getPosicaoY()].getDado().toString().contains("Caixa")
								&& config[player.getPosicaoX()+2][player.getPosicaoY()].getDado() == null)
							config[player.getPosicaoX()+2][player.getPosicaoY()].setDado(config[player.getPosicaoX()+1][player.getPosicaoY()].getDado());		
						else return;
					
					// move o personagem pra direita
					config[player.getPosicaoX()][player.getPosicaoY()].setDado(null);
					player.setPosicaoX(player.getPosicaoX()+1);
					config[player.getPosicaoX()][player.getPosicaoY()].setDado(player);
					player.aumentaMovimentos();
			break;
		}
	}
}
