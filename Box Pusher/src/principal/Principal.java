package principal;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Principal {

	public static void main(String[] args) {

		// muda a interface do java para Nimbus
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // se o nimbus não estiver disponível vai manter o lookandfeel padrão
		}
		
		new InterfaceGrafica();
	}
}
