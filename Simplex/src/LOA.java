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
	
	private static double berechner(double element_Anpassung[])// [0]=a [1]=b [2]=c [3]=d
	{
		//berechnung: (a-((b*c)/d))
		double wert=(element_Anpassung[0]-((element_Anpassung[1]*element_Anpassung[2])/element_Anpassung[3]));
		
	
		return wert;
	}
	
	private static double[][] Tabellen_builder(int anzahl_BV,int anzahl_NBV) 
	{
		//inizialisieren der Tabelle
		
		double [][] Tabelle=new double [anzahl_NBV+1][anzahl_BV+1];//+1 wegen charakteristischen Zeile,Spalte 
		//TODO Werte einlesen aus datei
		FileReader f_loa;
		try {
			f_loa = new FileReader("LOA_Werte.dat");
		
	    BufferedReader r_loa = new BufferedReader(f_loa);

	    String zeile = "";

	    try {
			while( (zeile = r_loa.readLine()) != null )
			{
				//TODO Zeile entsprechend einfügen
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    try {
			f_loa.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    boolean optimal=false;
	    int[] information=new int[4];/*       0. Anzahl an NBV, 1.Anzahl BV,
	    									  2.Spalte des Pivotelements, Zeile des Pivotelements */
	    Tabelle= Tabellen_filler(information, Tabelle, optimal);
	    
		//Temporaer
		double[][]Return=new double[1][1];
		Return[0][0]=0;
		return Return;} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private static double [][]Tabellen_filler(int[] information,double [][] Tabelle,boolean optimal)
	{
		 boolean pivotelement_found=false;
	   
	    while(pivotelement_found==false)
	    {
	    	double charsp[]=new double[information[1]+1];
		
			// Pivotelement bestimmen
		    	for(int i=1;i<information[0];i++)
		    	{
		    		if(Tabelle[i][0]<=0&&pivotelement_found==false)//Suche Pivotelement
		    		{
		    			for(int j=1;j<information[1];j++)
		    			{
		    				if(Tabelle[i][j]>0)
			    			{
		    					if(Tabelle[0][j]>0)
			    				{
			    					pivotelement_found=true;
			    					information[2]=i;
			    					charsp[j]=Tabelle[0][j]/Tabelle[i][j];
			    				}
			    				else
			    				{
			    					//TODO Unlösbarkeit behandeln
			    					System.err.println("Tabelle ist nicht lösbar");
			    				} 
			    			}
			    			else
			    			{
			    				charsp[j]=-1;//Alle BV=0, sollen ignoriert werden, für Bestimmung des Pivotelements;
			    			}
			    	
			    		}
		    			charsp[0]=charsp[1];
		    			information[4]=1;
			    		for(int stelle=2;stelle<charsp.length;stelle++)//Kleinster Wert für Pivotzeile
			    		{
			    			if(charsp[i]<charsp[0])
			    			{
			    				information[4]=i;
			    				charsp[0]=charsp[i];
			    			}
			    		}
			    	}
		    	}
		    	
		   
	    }
	    //Pivot Element berechnen
	    Tabelle[information[3]][information[4]]=1/Tabelle[information[3]][information[4]];
		// Pivotzeile berechnen
	    for(int i=0;i<information[1];i++)
	    {
	    	if(Tabelle[information[3]][i]!=Tabelle[information[3]][information[4]])
	    	{
	    		Tabelle[information[3]][i]=Tabelle[information[3]][i]/Tabelle[information[3]][information[4]];
	    	}
	    }
	    // Pivotspalte berechen
	    for(int i=0;i<information[1];i++)
	    {
	    	if(Tabelle[i][information[4]]!=Tabelle[information[3]][information[4]])
	    	{
	    		Tabelle[i][information[4]]=(Tabelle[i][information[4]]/Tabelle[information[3]][information[4]])*-1;
	    	}
	    }
	    
		// Werte berechen und in die Tabelle schreiben
	    	double[]element_Anpassung={0,0,0,0};
	    	for( int i=0;i<information[0];i++)
	    	{
	    		for(int j=0;j<information[1];j++)
	    		{
	    			if(i!=information[3]||j!=information[4])
	    			{
	    				element_Anpassung[0]=Tabelle[i][j];
	    				element_Anpassung[1]=Tabelle[i][information[4]];
	    				element_Anpassung[2]=Tabelle[information[3]][j];
	    				element_Anpassung[3]=Tabelle[information[3]][information[4]];
	    				Tabelle[i][j]=berechner(element_Anpassung);
	    			}
	    		}
	    	}
	    	return Tabelle;
	    }

	
	
	public static void main(String[] args)
	{
		//beispiel Berechnung
		Tabellen_builder(2, 3);
	}

}
