import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPad extends JPanel
{	
	/**************************
	 * VARIABLES D'INSTANCE
	 **************************/
	JButton b0 = new JButton("0");				//Bouton 0 
	JButton b1 = new JButton("1");				//Bouton 1
	JButton b2 = new JButton("2");				//Bouton 2
	JButton b3 = new JButton("3");				//Bouton 3
	JButton b4 = new JButton("4");				//Bouton 4
	JButton b5 = new JButton("5");				//Bouton 5
	JButton b6 = new JButton("6");				//Bouton 6			
	JButton b7 = new JButton("7");				//Bouton 7
	JButton b8 = new JButton("8");				//Bouton 8
	JButton b9 = new JButton("9");				//Bouton 9
	JButton bPoint = new JButton(".");			//Bouton virgule
	JButton bEgal = new JButton("=");			//Bouton égal
	
	/**************************
	 * METHODES CONSTRUCTEUR
	 **************************/
	public PanelPad()
	{
		/************************
		 * PARAMETRAGE DU PANEL
		 ************************/
		this.setBackground(Color.WHITE);			//Couleur de fond blanche 
		this.setBounds(10, 83, 264, 377);			//definition de la position absolue dans le conteneur et de la taille du panel
		this.setLayout(new GridLayout(4, 3, 5, 5));	//Gridlayout du panel pour positionner les différents boutons
	
		/**************************
		 * PARAMETRAGE DES BOUTONS
		 **************************/
		
		//Determination des setActionCommand
		this.b0.setActionCommand("b0");
		this.b1.setActionCommand("b1");
		this.b2.setActionCommand("b2");
		this.b3.setActionCommand("b3");
		this.b4.setActionCommand("b4");
		this.b5.setActionCommand("b5");
		this.b6.setActionCommand("b6");
		this.b7.setActionCommand("b7");
		this.b8.setActionCommand("b8");
		this.b9.setActionCommand("b9");
		this.bPoint.setActionCommand("bPoint");
		this.bEgal.setActionCommand("bEgal");
		
		//Elimination de l'effet focus
		this.b0.setFocusPainted(false);
		this.b1.setFocusPainted(false);
		this.b2.setFocusPainted(false);
		this.b3.setFocusPainted(false);
		this.b4.setFocusPainted(false);
		this.b5.setFocusPainted(false);
		this.b6.setFocusPainted(false);
		this.b7.setFocusPainted(false);
		this.b8.setFocusPainted(false);
		this.b9.setFocusPainted(false);
		this.bPoint.setFocusPainted(false);
		this.bEgal.setFocusPainted(false);
		
		/************************
		 * AJOUT DES COMPOSANTS
		 * DANS LE PANEL
		 ************************/
		this.add(this.b1);
		this.add(this.b2);
		this.add(this.b3);
		
		this.add(this.b4);
		this.add(this.b5);
		this.add(this.b6);
		
		this.add(this.b7);
		this.add(this.b8);
		this.add(this.b9);
		
		this.add(this.b0);
		this.add(this.bPoint);
		this.add(this.bEgal);		
	}
	
	/*************
	 * GETTERS
	 *************/
	public JButton getb0(){
		return this.b0;
	}
	
	public JButton getb1(){
		return this.b1;
	}

	public JButton getb2(){
		return this.b2;
	}
	
	public JButton getb3(){
		return this.b3;
	}
	
	public JButton getb4(){
		return this.b4;
	}
	
	public JButton getb5(){
		return this.b5;
	}
	
	public JButton getb6(){
		return this.b6;
	}
	
	public JButton getb7(){
		return this.b7;
	}
	
	public JButton getb8(){
		return this.b8;
	}
	
	public JButton getb9(){
		return this.b9;
	}
	
	public JButton getbPoint(){
		return this.bPoint;
	}
	
	public JButton getbEgal(){
		return this.bEgal;
	}
	
}

