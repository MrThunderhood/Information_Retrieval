/**
 * 
 */

/**
 * @author Devin

 *
 */


import java.io.*;

public class LOA {

	/**
	 * @param args
	 */
	
	private static double berechner(double d_werte[])// [0]=a [1]=b [2]=c [3]=d
	{
		//berechnung: (a-((b*c)/d))
		double d_wert=(d_werte[0]-((d_werte[1]*d_werte[2])/d_werte[3]));
		
	
		return d_wert;
	}
	
	private static double[][] Tabellen_builder(int i_anzahl_BV,int i_anzahl_NBV) throws IOException
	{
		//inizialisieren der Tabelle
		int []Pivot_position={0,0};
		
		double [][] Tabelle=new double [i_anzahl_NBV][i_anzahl_BV]; 
		//TODO Werte einlesen aus datei
		FileReader f_loa = new FileReader("LOA_Werte.dat");
	    BufferedReader r_loa = new BufferedReader(f_loa);

	    String zeile = "";

	    while( (zeile = r_loa.readLine()) != null )
	    {
	    	//TODO Zeile entsprechend einfügen
	    	
	    }

	    f_loa.close();
	    boolean optimal=false;
	    while(optimal==false)
	    {
		
		//TODO Pivotelement bestimmen
	    	for(int i=1;i<i_anzahl_NBV;i++)
	    	{
		    	for(int j=1;j<i_anzahl_BV;j++)
		    	{
		    		if(Tabelle[i][0]>=0)//Suche Pivotelement
		    		{
		    			
		    	
		    		}
		    	}
	    	}
		//TODO Pivotzeile berechnen
	    //TODO Pivotspalte berechen
		//TODO Werte berechen und in die Tabelle schreiben
	    
	    }
		
		//Temporaer
		double[][]Return=new double[1][1];
		Return[0][0]=0;
		return Return;
	}
	
	public static void main(String[] args)
	{
		System.out.println("Test");
	}

}
