package com.JavierGarciaGarcia.GIS;





import com.JavierGarciaGarcia.GIS.R;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AziDist extends GIS {
	
	private EditText et1,EditText01,EditText02,et21;
	private TextView textView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azi_dist);
        
        et1=(EditText)findViewById(R.id.et1);
        EditText01=(EditText)findViewById(R.id.EditText01);
        EditText02=(EditText)findViewById(R.id.EditText02);
        et21=(EditText)findViewById(R.id.et21);
        textView1=(TextView)findViewById(R.id.textView1);
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void calcula (View view) {
        
        String valor1=et1.getText().toString();
        String valor2=EditText01.getText().toString();
        String valor3=EditText02.getText().toString();
        String valor4=et21.getText().toString();
        
        double x1=Integer.parseInt(valor1);
        double y1=Integer.parseInt(valor2);
        double x2=Integer.parseInt(valor3);
        double y2=Integer.parseInt(valor4);
        
        double ax = x2 - x1;
        double ay = y2 - y1;
        
        double distancia= Math.sqrt(((ax * ax) + (ay * ay)));
        double azi=0;
        
        if (x1 < x2 && y1 < y2)
        {
        	
        	double alfa = Math.atan((ax / ay));
        	azi = alfa;        	
        }
        
        if (x1 < x2 && y1 > y2)
        {
        	double alfa = Math.atan((ax / ay));
        	azi = 180 - alfa;
        }
	
        if (x1 > x2 && y1 > y2)
        {
        	
        	double alfa = Math.atan((ax / ay));
        	azi = 180 + alfa;
        }
        
        if (x1 > x2 && y1 < y2)
        {
        	
        	double alfa = Math.atan((ax / ay));
        	azi = 360 - alfa;
        }
        
    	azi= redondeo.redondea(azi,4);
    	distancia= redondeo.redondea(distancia,4);
        String resu=String.valueOf(azi);
        String resu2=String.valueOf(distancia);
        textView1.setText("El acimut es " +resu + "\n" + "La distancia es " + resu2);
        
        
    }
}
