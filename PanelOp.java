import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOp extends JPanel
{
	/**************************
	 * VARIABLES D'INSTANCE
	 **************************/
	private JButton bC = new JButton("C");			//bouton qui remet à 0 l'écran et la suite de calcul
	private JButton bPlus = new JButton("+");		//bouton +
	private JButton bMoins = new JButton("-");		//bouton -
	private JButton bFois = new JButton("x");		//bouton *
	private JButton bDiv = new JButton("/");		//bouton /
	
	/**************************
	 * METHODES CONSTRUCTEUR
	 **************************/
	public PanelOp()
	{
		/************************
		 * PARAMETRAGE DU PANEL
		 ************************/
		this.setBackground(Color.white);			//Fond blanc pour le panel
		this.setBounds(284, 83, 100, 377);			//definition de la position absolue du panel dans son conteneur, ainsi que de ses dimension
		this.setLayout(new GridLayout(5, 1, 5, 5));	//definition d'un gridLayout pour placer les différents boutons
		
		/**************************
		 * PARAMETRAGE DES BOUTONS
		 **************************/
		
		//determination des setActionCommand
		this.bC.setActionCommand("bC");
		this.bPlus.setActionCommand("bPlus");
		this.bMoins.setActionCommand("bMoins");
		this.bFois.setActionCommand("bFois");
		this.bDiv.setActionCommand("bDiv");
		
		//Eliminer l'action de focus
		this.bC.setFocusPainted(false);
		this.bPlus.setFocusPainted(false);
		this.bMoins.setFocusPainted(false);
		this.bFois.setFocusPainted(false);
		this.bDiv.setFocusPainted(false);
		
		/************************
		 * AJOUT DES COMPOSANTS 
		 * DANS LE CONTENEUR
		 ************************/
		this.add(this.bC);
		this.add(this.bPlus);
		this.add(this.bMoins);
		this.add(this.bFois);
		this.add(this.bDiv);
	}
	
	/*************
	 * GETTERS
	 *************/
	public JButton getbC(){
		return this.bC;
	}
	
	public JButton getbPlus(){
		return this.bPlus;
	}
	
	public JButton getbMoins(){
		return this.bMoins;
	}
	
	public JButton getbFois(){
		return this.bFois;
	}
	
	public JButton getbDiv(){
		return this.bDiv;
	}
	
	
	
	
	
	
	
}
