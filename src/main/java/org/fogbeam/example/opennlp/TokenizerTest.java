
package org.fogbeam.example.opennlp;

import java.io.FileInputStream;
import java.io.InputStream;
import org.junit.Test;
import static org.junit.Assert.*;


public class TokenizerTest
{
	@Test
	public void ficheroVacio() throws Exception
	{
		//Si el fichero no está vacio
		String cadenaFichero=TokenizerMain.fichero_a_cadena("ficheroEN");
		boolean same=false;

    	//Si no esta vacio el fichero
		if(!cadenaFichero.isEmpty())
			same=true;
		
		assertTrue(same == true);
	}
	
	@Test
	public void mismaCadena() throws Exception
	{
		//Si la funcion fichero a cadena funciona
		String cadenaFichero=TokenizerMain.fichero_a_cadena("ficheroEN");
		boolean same=false;


		String cadenaCompare="Tributes have poured in from across the world for boxing legend Muhammad Ali, who has died at the age of 74.<<Muhammad Ali shook up the world. And the world is better for it,>> said US President Barack Obama.";

    	//Si las cadenas son las mismas
		if(cadenaFichero.equals(cadenaCompare))
			same=true;
		
		assertTrue(same == true);
	}
	
	
}
