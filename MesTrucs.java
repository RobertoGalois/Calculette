import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MesTrucs 
{
	public static void sleep()
	{
		try
		{
		 Thread.sleep(500);
		}catch(InterruptedException e){e.printStackTrace();}
	}
	
	public static void sleep(int pTime)
	{
		try
		{
		 Thread.sleep(pTime);
		}catch(InterruptedException e){e.printStackTrace();}
	}
	
	public static void changePanel(JFrame pFenetre, JPanel pPanel)
	{
		pFenetre.setContentPane(pPanel);
		pFenetre.setVisible(true);
	}
	
	public static void setWindowsLook() {
		try{UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");}
		catch(ClassNotFoundException e){}
		catch(UnsupportedLookAndFeelException e){}
		catch(InstantiationException e){}
		catch(IllegalAccessException e){}
	}
}
