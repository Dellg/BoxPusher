package principal;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import java.util.ArrayList;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import objetos.*;

@SuppressWarnings("serial")
public class InterfaceGrafica extends JFrame {
	
	int tamanho = 4, jogadorX = 3, jogadorY = 0;
	Spot matriz[][] = new Spot[tamanho][tamanho];
	JPanel gamePainel, solucaoPainel;

	public InterfaceGrafica() {
		setTitle("Box Pusher");
		
		/*
		 configuração do jogo:
			|.|x| |.|
			| |x| | |
			| |x| |.|
			|o| | | |
		  
		o = player
		x = caixa
		. = objetivo
		   
		*/
		
		gamePainel = new JPanel();
		getContentPane().add(gamePainel, BorderLayout.CENTER);
		gamePainel.setLayout(new GridLayout(tamanho, tamanho, 0, 0));

		solucaoPainel = new JPanel();
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		JMenuItem mntmReiniciar = new JMenuItem("Reiniciar");
		mntmReiniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new InterfaceGrafica();
			}
		});
		mnMenu.add(mntmReiniciar);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnMenu.add(mntmSair);

		// gera a matriz com as posições do jogador, das caixas e dos objetivos
		for (int linha = 0; linha < matriz.length; linha++){
			for (int coluna = 0; coluna < matriz.length; coluna++){
				
				if (linha == jogadorX && coluna == jogadorY)
					matriz[linha][coluna] = new Spot(linha,coluna,new Personagem(linha, coluna));
				else if (linha == 0 && coluna == 1 || linha == 1 && coluna == 1 || linha == 2 && coluna == 1)
					matriz[linha][coluna] = new Spot(linha,coluna,new Caixa(linha, coluna));
				else
					matriz[linha][coluna] = new Spot(linha,coluna,null);
				
				if (linha == 0 && coluna == 0 || linha == 0 && coluna == 3 || linha == 2 && coluna == 3)
					matriz[linha][coluna].setObjetivo(true);
				
				JLabel tempLabel = new JLabel();
				tempLabel.setBorder(new LineBorder(Color.BLACK));
				tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
				matriz[linha][coluna].draw(tempLabel);
				gamePainel.add(tempLabel);
			}
		}
		
		// verifica botão pressionado pelo jogador
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				Personagem personagem = (Personagem) matriz[jogadorX][jogadorY].getDado();
				personagem.movePersonagem(e, matriz, gamePainel);
				
				jogadorX = personagem.getPosicaoX();
				jogadorY = personagem.getPosicaoY();

				if (matriz[0][0].getDado() != null &&
						matriz[0][3].getDado() != null &&
						matriz[2][3].getDado() != null){
					if (matriz[0][0].getDado().toString().contains("Caixa") &&
							matriz[0][3].getDado().toString().contains("Caixa") &&
							matriz[2][3].getDado().toString().contains("Caixa")){
						Object[] options = { "Sim", "Não" };
						int i = JOptionPane.showOptionDialog(null, "Você venceu o jogo. Deseja jogar novamente?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
						if (i == 0){
							dispose();
							new InterfaceGrafica();
						} else{
							System.exit(0);}
					}
				}
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,800);
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
