package com.nayosx.lectura;

import java.io.*;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class LecturaArchivoActivity extends Activity {
    /** Called when the activity is first created. */
	TextView mostrar;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        inicializar();
    }
    void inicializar()
    {
    	mostrar = (TextView) findViewById(R.id.mostrar);
    	leerArchivo();
    }
	/**
     * 
     */
    private void leerArchivo() {
	    // TODO Auto-generated method stub
    	try {
    		InputStreamReader isr = new InputStreamReader(this.getResources().openRawResource(R.raw.lorem));
    		BufferedReader br = new BufferedReader(isr);
    		
    		String linea;
    		
    		StringBuilder texto = new StringBuilder();
    		
    		while((linea = br.readLine()) != null)
    		{
    			texto.append(linea);
    			texto.append("\n");
    		}
    		br.close();
    		isr.close();
    		mostrar.setText(texto.toString());
    		
    	} catch(IOException e)
    	{ e.printStackTrace(); }
    }
}