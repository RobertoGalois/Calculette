import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelEcran extends JPanel
{
	/**************************
	 * VARIABLES D'INSTANCE
	 **************************/
	private JLabel labelChiffres = new JLabel("0");		//Label pour afficher les chiffres de l'écran
	
	/**************************
	 * METHODES CONSTRUCTEUR
	 **************************/
	public PanelEcran()
	{
		/************************
		 * PARAMETRAGE DU PANEL
		 ************************/
		this.setBounds(10, 11, 374, 61);							//définition de la taille et de la position du panel
		this.setLayout(null);										//on ne met pas de layout afin de pouvoir placer les composants de façon absolue
		this.setBackground(new Color(239, 244, 249));				//On met une couleur de fond d'écran dans les teints bleutés
		this.setBorder(new LineBorder(new Color(0, 0, 0)));			//on entoure le panel d'un bord noir
		
		/************************
		 * PARAMETRAGE DU LABEL
		 ************************/
		this.labelChiffres.setBounds(10, 0, 344, 60);						//Definition de la position et de la taille du label
		this.labelChiffres.setFont(new Font("Arial", Font.PLAIN, 30));		//Definition de la police, de la taille et du style du texte dans le label
		this.labelChiffres.setHorizontalAlignment(SwingConstants.RIGHT);	//Alignement du texte à droite 
		this.add(this.labelChiffres);
	}
	
	/*************
	 * GETTERS
	 *************/
	public JLabel getLabelChiffre(){
		return this.labelChiffres;
	}
}

