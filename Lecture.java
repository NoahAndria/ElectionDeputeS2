package wr;
import java.io.*;
import java.util.*;

import data.*;

public class Lecture{
    public static Vector<String[]> Lire(String nomfichier)
    {
        Vector<String[]> alldata = new Vector<String[]>();
        try( BufferedReader reader = new BufferedReader(new FileReader(nomfichier))){
            String ligne;
            while((ligne = reader.readLine()) != null)
            {
                ligne = ligne.trim();
                String[] piecedata = ligne.split(";;");
                if(piecedata.length==6)
                {
                    alldata.add(piecedata);
                }
            }
            
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        return alldata;
    }
}