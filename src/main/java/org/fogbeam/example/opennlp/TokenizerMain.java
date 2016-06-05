
package org.fogbeam.example.opennlp;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileReader;
import java.io.BufferedReader;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;





public class TokenizerMain
{
	//Aquí se lee el fichero y se almacena en string
	public static String fichero_a_cadena(String nombreArchivo) throws IOException{
		String cadena,aux;
        StringBuilder cadenaBuilder = new StringBuilder();
		FileReader f = new FileReader(nombreArchivo);
        BufferedReader buffer = new BufferedReader(f);
        while((aux = buffer.readLine())!=null) {
        	cadenaBuilder.append(aux);	
        }
        cadena=cadenaBuilder.toString();

		
		return cadena;
	}
	
	public static String[] hacerToken(String cadena,InputStream modelIn) throws InvalidFormatException, IOException{
		
		//Aquí se convierte en token
		TokenizerModel model = new TokenizerModel( modelIn );
		Tokenizer tokenizer = new TokenizerME(model);
		

    	String[] tokens = tokenizer.tokenize(  cadena );		
		return tokens;
	}
	

	
	public static void main( String[] args ) throws Exception
	{
		
		// the provided model
		// InputStream modelIn = new FileInputStream( "models/en-token.bin" );

		// the model we trained
		InputStream modelIn = new FileInputStream( "models/en-token.model" );
		InputStream modelIn1 = new FileInputStream( "models/en-token.model" );

        //Leemos fichero y transformamos a cadena
        String cadena;
        cadena=fichero_a_cadena("ficheroEN");
        
		try
		{
        	String[] tokens = hacerToken(cadena,modelIn);

		    for( String token : tokens )
			{
				System.out.println( token );
			}

		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		finally
		{
			if( modelIn != null )
			{
				try
				{
					modelIn.close();
				}
				catch( IOException e )
				{
				}
			}
		}
		System.out.println( "\n-----\ndone" );
	}
	
	
}
