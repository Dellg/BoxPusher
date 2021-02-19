package principal;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import objetos.*;

@SuppressWarnings("serial")
public class InterfaceGrafica extends JFrame {

	private JPanel gamePainel;
	private Jogo jogo = new Jogo();

	public InterfaceGrafica() {
		setTitle("Box Pusher");
		
		gamePainel = new JPanel();
		getContentPane().add(gamePainel, BorderLayout.CENTER);
		gamePainel.setLayout(new GridLayout(jogo.getTamanho(), jogo.getTamanho(), 0, 0));

		new JPanel();
		
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

		atualizaGraficoMatriz();
		
		// verifica botão pressionado pelo jogador
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				jogo.movimentaPersonagem(e);

				atualizaGraficoMatriz();
				getContentPane().validate();
				getContentPane().repaint();

				// verifica se o jogo foi finalizado e dá a opção de jogar novamente ou sair
				if (jogo.jogoFinalizado()) {
					Object[] options = { "Sim", "Não" };
					int i = JOptionPane.showOptionDialog(null, "Você venceu o jogo. Deseja jogar novamente?", null, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
					if (i == 0){
						dispose();
						new InterfaceGrafica();
					} else System.exit(0);
				}
			}
		});
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800,800);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void atualizaGraficoMatriz() {
		gamePainel.removeAll();
		// gera a matriz com as posições do jogador, das caixas e dos objetivos
		for (int linha = 0; linha < jogo.getTamanho(); linha++){
			for (int coluna = 0; coluna < jogo.getTamanho(); coluna++){
				JLabel tempLabel = new JLabel();
				tempLabel.setBorder(new LineBorder(Color.BLACK));
				tempLabel.setHorizontalAlignment(SwingConstants.CENTER);
				tempLabel.setIcon(jogo.getConfiguracao()[coluna][linha].getImagem());
				gamePainel.add(tempLabel);
			}
		}
	}
}
