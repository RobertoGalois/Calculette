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
	private Fenetre fenetreListened; 					//fen�tre qui est �cout�e par le listener
	private boolean operationDefined; 					//est-ce que l'on a cliqu� sur au moins un chiffre apr�s avoir cliqu� sur un op�rateur
	private TypeOperateur operateur;					//type d'op�rateur qui a �t� cliqu� en dernier
	private byte compteurChiffresEcran;					//nombre de chiffres qui ont �t� tap�s � l'�cran
	private double termeGauche;							//nombre � gauche de l'op�ration
	private double termeDroite;							//nombre � droite de l'op�ration

	//Variables interrupteurs
	private boolean yaOperateurFirst;					//Un op�rateur a �t� cliqu� au moins une fois.
	private boolean yaOperateurLast;					//un op�rateur a �t� choisi pour faire une op�ration = un nombre a �t� tap�, un op�rateur a �t� cliqu� (yaOperateurFirst true) et au moins un chiffre a �t� tap�.
	private boolean yaPoint;							//est-ce que le point a �t� cliqu� au moins une fois
	
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
		//String qu'on va retourner pour afficher dans l'ecran de la calculette, elle est initialis�e avec le contenu de l'�cran de la calculette avant actualisation
		String retour = this.fenetreListened.getPanelEcran().getLabelChiffre().getText();
		
		//debogage
		System.out.println(this.termeGauche + " [" + this.operateur  + "] " + this.termeDroite);
		
		/**********************
		 * SWITCH CASE BOUTON
		 **********************/
		switch(e.getActionCommand())  //on verifie quel bouton a �t� appuy� et on fait ce qu'il faut en cons�quence
		{	
			//0
			case "b0":
				retour = this.addChiffre("0", retour);	//Si ya pas de chiffre entr�, on change rien, sinon, on ajoute un 0 � la chaine
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
		
		//on actualise le contenu du label de l'�cran 
		this.fenetreListened.getPanelEcran().getLabelChiffre().setText(retour);
		//debogage
		System.out.println(this.termeGauche + " [" + this.operateur  + "] " + this.termeDroite+"\n");
	}//fin m�thode listener

	
	/**************************
	 * SI ON APPUIE SUR C
	 **************************/
	private String opC()
	{
		//reinitialisation du compteur de chiffre d'�cran
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
		//si c'est la premi�re fois qu'on clique sur un op�rateur
		if(this.yaOperateurFirst == false)
		{
			//on dit qu'un op�rateur a �t� choisi au moins une fois,
			this.yaOperateurFirst = true;
			//on dit que cet op�rateur choisi, c'est pTypeOp
			this.operateur = pTypeOp;
			//on change l'apparence du bouton Correspondant au pTypeOp
			this.OpToButton(pTypeOp).setBackground(new Color(106, 91, 242));
		}
		
		//sinon
		else
		{	
			//si le type op�rateur dej� choisi est diff�rent de celui qu'on choisi l�, on fait des trucs, sinon on ne fait rien
			if(this.operateur != pTypeOp)
			{
				//on remet le pr�c�dent bouton en apparence par d�faut 
				this.OpToButton(this.operateur).setBackground(UIManager.getColor("Button.background"));
				//on change l'apparence du bouton Nouvellement cliqu�
				this.OpToButton(pTypeOp).setBackground(new Color(106, 91, 242));
				//on dit que l'op�rateur choisi est d�sormais pTypeOp 
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
		//on consid�re le terme de droite comme complet, et on le r�cup�re
		this.termeDroite = Double.parseDouble(this.fenetreListened.getPanelEcran().getLabelChiffre().getText());
		
		//on calcule le r�sultat, id�alement il faudrait une m�thode sp�cifique mais j'ai envie de finir ce truc et passer � autre chose
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
		
		//on r�initialise les op�rateurs
		this.reInitOps();
		//on affiche le r�sultat dans le label ecran 
		return Double.toString(resultat);
	}
	
	/**************************
	 * SI ON APPUIE SUR .
	 **************************/
	private String opPoint()
	{
		String tempRetour = new String("");
		
		//Si un point n'a pas d�j� �t� ins�r�, on rajoute un point � la chaine, sinon, on ne rajoute rien. 
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
		//si un op�rateur a d�j� �t� cliqu� au moins une fois, on consid�re qu'il est d�sormais d�fini pour l'op�ration, et on stocke le terme de gauche
		if(this.yaOperateurFirst == true && this.yaOperateurLast == false)
		{
			//on considere l'op�rateur choisi d�finitivement pour le calcul
			this.yaOperateurLast = true;
			//on r�cup�re le chiffre qui a �t� tap�
			this.termeGauche = Double.parseDouble(this.fenetreListened.getPanelEcran().getLabelChiffre().getText());
			//on vide le contenu de l'�cran pour y mettre le nouveau chiffre tap�
			pRetour = "";
		}
			
		//on incr�mente le compteur quoi qu'il arrive
		this.compteurChiffresEcran++;
		
		//Si le compteur �tait � 0, on vide le label et on le remplace par notre nouveau chiffre, sinon on ajoute simplement notre chiffre � la suite des autres
		if(this.compteurChiffresEcran == 1)
		{
			pRetour = "";
			
			//si jamais on ajoute un 0 alors qu'on �tait d�j� � 0, �a ne fait rien, cad qu'on r�initialise le compteur � 0
			if(pChiffre=="0")
				this.compteurChiffresEcran = 0;
		}
		
		return pRetour+pChiffre;
	}
	
	//retourne le bouton du panelOp  correspondant au type d'op�rateur
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
	
	//la m�thode pour calculer, non exploit�e maintenant parce que bon j'ai la vaisselle � faire et ya Science4All qui a post� une vid�o sur le scrutin de Condorcet randomis�
	private double calcul(double pTermeGauche, double pTermeDroite)
	{
		double resultat = 0d;
		
		return resultat;
	}
}
