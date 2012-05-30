package com.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ErrorGobbler extends Thread {
    InputStream is;
    String type;
	
	ErrorGobbler(InputStream is, String type)
    {
        this.is = is;
        this.type = type;
        
    }
    
    public void run()
    {
        try
        {
            InputStreamReader isr = new InputStreamReader(is);
            StringBuffer buf = new StringBuffer();
            int ch=0;
            while((ch = isr.read()) > -1){
            	buf.append((char)ch);
            	System.out.print(buf.toString());
                    }   
            } catch (IOException ioe)
              {
                ioe.printStackTrace();  
              }
    }
}
