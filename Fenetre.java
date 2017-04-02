import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame
{
	/**************************
	 * VARIABLES D'INSTANCE
	 **************************/
	
	private int largeur = 400;				//Largeur de la fenetre
	private int hauteur = 500;				//Hauteur de la fenetre
	private JPanel contentPane;				//Conteneur global de la fen�tre
	private PanelEcran panelEcran;			//Panel ecran qui affiche les chiffres
	private PanelOp panelOp;				//Panel qui contient les 4 op�rateurs + - * / ainsi que la remise � z�ro
	private PanelPad panelPad;				//Panel qui contient les boutons avec les chiffres 0-9 ainsi que . et =

	private Listener listener;				//Listener qui va �couter le fait d'appuyer sur les boutons de la fenetre et effectuer une action en cons�quence
	/**************************
	 * METHODES CONSTRUCTEUR
	 **************************/
	public Fenetre()
	{
		/******************************************
		 * INITIALISATION DES VARIABLES D'INSTANCE
		 ******************************************/
		this.panelEcran = new PanelEcran();
		this.panelOp = new PanelOp();
		this.panelPad = new PanelPad();
		this.contentPane = new JPanel();
		this.listener = new Listener(this);						//On �coute la fen�tre avec un objet Listener qu'on instancie ici, en lui filant un pointeur vers la fen�tre en question.	
		/****************************
		 * PARAMETRAGE DE LA FENETRE
		 ****************************/
		//MesTrucs.setWindowsLook();							//on donne un style windows � l'interface
		this.setTitle("Calculatrice");							//Titre de la fenetre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//ferme le programme lors de la fermeture de la fenetre
		this.setSize(this.largeur, this.hauteur);				//d�termination de la taille de la fenetre
		this.setLocationRelativeTo(null);						//lors de son affichage, l'afficher au centre de l'ecran
		this.setResizable(false);								//fenetre non redimensionnable
		
		/***********************************
		 * PARAMETRAGE DU CONTENEUR GLOBAL
		 * DE LA FENETRE
		 ************************************/
		this.contentPane.setBackground(Color.WHITE);				//mettre du blanc en fond de la fenetre
		this.contentPane.setLayout(null);							//pas de layout pour pouvoir placer les composants de fa�on absolue
		
		//ajout des sous-panels dans le panel global 
		this.contentPane.add(this.panelEcran);
		this.contentPane.add(this.panelPad);
		this.contentPane.add(this.panelOp);
		
		//affichage du panel gobal dans la fenetre
		this.setContentPane(this.contentPane);
		
		/**************************
		 * AFFICHAGE DE LA FENETRE
		 **************************/
		this.setVisible(true);
		
		
		/**************************
		 * AJOUT DES EVENEMENTS SUR
		 * LES BOUTONS DU PAD
		 **************************/
		this.getPanelPad().getb0().addActionListener(this.listener);
		this.getPanelPad().getb1().addActionListener(this.listener);
		this.getPanelPad().getb2().addActionListener(this.listener);
		this.getPanelPad().getb3().addActionListener(this.listener);
		this.getPanelPad().getb4().addActionListener(this.listener);
		this.getPanelPad().getb5().addActionListener(this.listener);
		this.getPanelPad().getb6().addActionListener(this.listener);
		this.getPanelPad().getb7().addActionListener(this.listener);
		this.getPanelPad().getb8().addActionListener(this.listener);
		this.getPanelPad().getb9().addActionListener(this.listener);
		this.getPanelPad().getbPoint().addActionListener(this.listener);
		this.getPanelPad().getbEgal().addActionListener(this.listener);
		
		/**************************
		 * AJOUT DES EVENEMENTS SUR
		 * LES BOUTONS OPERATEUR
		 **************************/
		this.getPanelOp().getbC().addActionListener(this.listener);
		this.getPanelOp().getbPlus().addActionListener(this.listener);
		this.getPanelOp().getbMoins().addActionListener(this.listener);
		this.getPanelOp().getbFois().addActionListener(this.listener);
		this.getPanelOp().getbDiv().addActionListener(this.listener);
	}

	/*************
	 * GETTERS
	 *************/
	public PanelEcran getPanelEcran(){
		return this.panelEcran;
	}
	
	public PanelOp getPanelOp(){
		return this.panelOp;
	}
	
	public PanelPad getPanelPad(){
		return this.panelPad;
	}
	

}
