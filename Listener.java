import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.UIManager;

public class Listener implements ActionListener
{
	/**************************
	 * VARIABLES D'INSTANCE
	 **************************/
	private Fenetre fenetreListened; 					//fenêtre qui est écoutée par le listener
	private boolean operationDefined; 					//est-ce que l'on a cliqué sur au moins un chiffre après avoir cliqué sur un opérateur
	private TypeOperateur operateur;					//type d'opérateur qui a été cliqué en dernier
	private byte compteurChiffresEcran;					//nombre de chiffres qui ont été tapés à l'écran
	private double termeGauche;							//nombre à gauche de l'opération
	private double termeDroite;							//nombre à droite de l'opération

	//Variables interrupteurs
	private boolean yaOperateurFirst;					//Un opérateur a été cliqué au moins une fois.
	private boolean yaOperateurLast;					//un opérateur a été choisi pour faire une opération = un nombre a été tapé, un opérateur a été cliqué (yaOperateurFirst true) et au moins un chiffre a été tapé.
	private boolean yaPoint;							//est-ce que le point a été cliqué au moins une fois
	
	/**************************
	 * METHODES CONSTRUCTEUR
	 **************************/
	public Listener(Fenetre pFenetre)
	{
		this.fenetreListened = pFenetre;
		this.yaPoint = false;
		this.operationDefined = false;
		this.operateur = null;
		this.compteurChiffresEcran = 0;
		this.yaOperateurFirst = false;
		this.yaOperateurLast = false;
		this.termeGauche = 0d;
		this.termeDroite = 0d;
	}

	/********************
	 * METHODE LISTENER
	 ********************/
	public void actionPerformed(ActionEvent e)
	{
		//String qu'on va retourner pour afficher dans l'ecran de la calculette, elle est initialisée avec le contenu de l'écran de la calculette avant actualisation
		String retour = this.fenetreListened.getPanelEcran().getLabelChiffre().getText();
		
		//debogage
		System.out.println(this.termeGauche + " [" + this.operateur  + "] " + this.termeDroite);
		
		/**********************
		 * SWITCH CASE BOUTON
		 **********************/
		switch(e.getActionCommand())  //on verifie quel bouton a été appuyé et on fait ce qu'il faut en conséquence
		{	
			//0
			case "b0":
				retour = this.addChiffre("0", retour);	//Si ya pas de chiffre entré, on change rien, sinon, on ajoute un 0 à la chaine
			break;
			
			//1
			case "b1":
				retour = this.addChiffre("1", retour);
			break;
		
			//2
			case "b2":
				retour = this.addChiffre("2", retour);
			break;
			
			//3
			case "b3":
				retour = this.addChiffre("3", retour);
			break;
							
			//4
			case "b4":
				retour = this.addChiffre("4", retour);
			break;
				
			//5
			case "b5":
				retour = this.addChiffre("5", retour);
			break;
			
			//6
			case "b6":
				retour = this.addChiffre("6", retour);
			break;
				
			//7
			case "b7":
				retour = this.addChiffre("7", retour);
			break;
			
			//8
			case "b8":
				retour = this.addChiffre("8", retour);
			break;
				
			//9
			case "b9":
				retour = this.addChiffre("9", retour);
			break;
				
			//.
			case "bPoint":
				retour += this.opPoint();
			break;
					
			//=
			case "bEgal":
				retour = this.opEgal();
			break;
			
			//+
			case "bPlus":
				this.opPlus();
			break;
			
			//-
			case "bMoins":
				this.opMoins();
			break;
			
			//*
			case "bFois":
				this.opFois();
			break;
			
			//./.
			case "bDiv":
				this.opDiv();
			break;
			
			//C
			case "bC":
				retour = this.opC();
			break;
		}
		
		//on actualise le contenu du label de l'écran 
		this.fenetreListened.getPanelEcran().getLabelChiffre().setText(retour);
		//debogage
		System.out.println(this.termeGauche + " [" + this.operateur  + "] " + this.termeDroite+"\n");
	}//fin méthode listener

	
	/**************************
	 * SI ON APPUIE SUR C
	 **************************/
	private String opC()
	{
		//reinitialisation du compteur de chiffre d'écran
		this.compteurChiffresEcran = 0;
		//reinitialisation des operateurs
		this.reInitOps();
		//afficher 0 dans le label ecran
		return "0";
	}

	/**************************
	 * SI ON APPUIE SUR UN 
	 * OPERATEUR QUELCONQUE
	 **************************/
	private void opGen(TypeOperateur pTypeOp)
	{	
		//si c'est la première fois qu'on clique sur un opérateur
		if(this.yaOperateurFirst == false)
		{
			//on dit qu'un opérateur a été choisi au moins une fois,
			this.yaOperateurFirst = true;
			//on dit que cet opérateur choisi, c'est pTypeOp
			this.operateur = pTypeOp;
			//on change l'apparence du bouton Correspondant au pTypeOp
			this.OpToButton(pTypeOp).setBackground(new Color(106, 91, 242));
		}
		
		//sinon
		else
		{	
			//si le type opérateur dejà choisi est différent de celui qu'on choisi là, on fait des trucs, sinon on ne fait rien
			if(this.operateur != pTypeOp)
			{
				//on remet le précédent bouton en apparence par défaut 
				this.OpToButton(this.operateur).setBackground(UIManager.getColor("Button.background"));
				//on change l'apparence du bouton Nouvellement cliqué
				this.OpToButton(pTypeOp).setBackground(new Color(106, 91, 242));
				//on dit que l'opérateur choisi est désormais pTypeOp 
				this.operateur = pTypeOp;
			}
		}
	}
	
	
	/**************************
	 * SI ON APPUIE SUR +
	 **************************/
	private void opPlus()
	{
		this.opGen(TypeOperateur.PLUS);
	}
	
	/**************************
	 * SI ON APPUIE SUR -
	 **************************/
	private void opMoins()
	{
		this.opGen(TypeOperateur.MOINS);
	}
	
	/**************************
	 * SI ON APPUIE SUR *
	 **************************/
	private void opFois()
	{
		this.opGen(TypeOperateur.FOIS);
	}
	
	/**************************
	 * SI ON APPUIE SUR /
	 **************************/
	private void opDiv()
	{
		this.opGen(TypeOperateur.DIV);
	}
	
	/**************************
	 * SI ON APPUIE SUR =
	 **************************/
	private String opEgal()
	{
		//initialisation de la variable retour
		double resultat = 0d;
		//on considère le terme de droite comme complet, et on le récupère
		this.termeDroite = Double.parseDouble(this.fenetreListened.getPanelEcran().getLabelChiffre().getText());
		
		//on calcule le résultat, idéalement il faudrait une méthode spécifique mais j'ai envie de finir ce truc et passer à autre chose
		switch(this.operateur)
		{
			case PLUS:
				resultat = this.termeGauche + this.termeDroite;
			break;
			
			case MOINS:
				resultat = this.termeGauche - this.termeDroite;				
			break;
			
			case FOIS:
				resultat = this.termeGauche * this.termeDroite;
			break;
			
			case DIV:
				if(this.termeDroite == 0)
					resultat = 0;
				else
					resultat = this.termeGauche / this.termeDroite;
			break;
		}
		
		//on réinitialise les opérateurs
		this.reInitOps();
		//on affiche le résultat dans le label ecran 
		return Double.toString(resultat);
	}
	
	/**************************
	 * SI ON APPUIE SUR .
	 **************************/
	private String opPoint()
	{
		String tempRetour = new String("");
		
		//Si un point n'a pas déjà été inséré, on rajoute un point à la chaine, sinon, on ne rajoute rien. 
		if(this.yaPoint == false) {
			tempRetour += ".";
			this.compteurChiffresEcran++;
			this.yaPoint = true;
		}
		
		return tempRetour;
	}
	
	/**************************
	 * SI ON APPUIE SUR [0-9]
	 **************************/
	private String addChiffre(String pChiffre, String pRetour)
	{
		//si un opérateur a déjà été cliqué au moins une fois, on considère qu'il est désormais défini pour l'opération, et on stocke le terme de gauche
		if(this.yaOperateurFirst == true && this.yaOperateurLast == false)
		{
			//on considere l'opérateur choisi définitivement pour le calcul
			this.yaOperateurLast = true;
			//on récupère le chiffre qui a été tapé
			this.termeGauche = Double.parseDouble(this.fenetreListened.getPanelEcran().getLabelChiffre().getText());
			//on vide le contenu de l'écran pour y mettre le nouveau chiffre tapé
			pRetour = "";
		}
			
		//on incrémente le compteur quoi qu'il arrive
		this.compteurChiffresEcran++;
		
		//Si le compteur était à 0, on vide le label et on le remplace par notre nouveau chiffre, sinon on ajoute simplement notre chiffre à la suite des autres
		if(this.compteurChiffresEcran == 1)
		{
			pRetour = "";
			
			//si jamais on ajoute un 0 alors qu'on était déjà à 0, ça ne fait rien, cad qu'on réinitialise le compteur à 0
			if(pChiffre=="0")
				this.compteurChiffresEcran = 0;
		}
		
		return pRetour+pChiffre;
	}
	
	//retourne le bouton du panelOp  correspondant au type d'opérateur
	private JButton OpToButton(TypeOperateur pOp)
	{
		JButton tempButton;
		
		switch(pOp)
		{
			case PLUS:
				tempButton = this.fenetreListened.getPanelOp().getbPlus();
			break;
			
			case MOINS:
				tempButton = this.fenetreListened.getPanelOp().getbMoins();				
			break;
				
			case FOIS:
				tempButton = this.fenetreListened.getPanelOp().getbFois();
			break;	
			
			case DIV:
				tempButton = this.fenetreListened.getPanelOp().getbDiv();
			break;
			
			default: 
				tempButton = null;
		}
		return tempButton;
	}
	
	//reinitialisation des operateurs et des interrupteurs
	private void reInitOps()
	{
		this.operationDefined = false;
		this.yaOperateurFirst = false; 
		this.yaOperateurLast = false;
		this.termeGauche = 0d;
		this.termeDroite = 0d;
		this.OpToButton(TypeOperateur.PLUS).setBackground(UIManager.getColor("Button.background"));
		this.OpToButton(TypeOperateur.MOINS).setBackground(UIManager.getColor("Button.background"));
		this.OpToButton(TypeOperateur.FOIS).setBackground(UIManager.getColor("Button.background"));
		this.OpToButton(TypeOperateur.DIV).setBackground(UIManager.getColor("Button.background"));		
	}
	
	//la méthode pour calculer, non exploitée maintenant parce que bon j'ai la vaisselle à faire et ya Science4All qui a posté une vidéo sur le scrutin de Condorcet randomisé
	private double calcul(double pTermeGauche, double pTermeDroite)
	{
		double resultat = 0d;
		
		return resultat;
	}
}
