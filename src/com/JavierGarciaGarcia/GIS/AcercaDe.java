package com.JavierGarciaGarcia.GIS;




import com.JavierGarciaGarcia.GIS.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class AcercaDe extends GIS {
	
	public TextView textViewacerca;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acercade);
        textViewacerca=(TextView)findViewById(R.id.textViewacerca);
        
        textViewacerca.setText("Javier Garcia Garcia \n\njavigarciavlc@gmail.com \n\n-Esta aplicación se ha desarrollado como objetivo de aprendizaje, disculpen los posibles errores que contenga. \n \n-Errores y sugerencias a gisandroidapp@gmail.com \n \n-Mencionar que el propietario de el WMS Catastro es la Dirección General del Catastro, del WMS Cartociudad y del PNOA es el Instituto Geografico Nacional y del WMS OSM-MDT es la Cátedra de Geoinformatics/GIScience de el departamento de geografía de la Universidad de Heidelberg, Alemania  ");
        
    }
	
}


