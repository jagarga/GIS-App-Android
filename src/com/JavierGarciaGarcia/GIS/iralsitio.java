package com.JavierGarciaGarcia.GIS;



import com.JavierGarciaGarcia.GIS.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;


public class iralsitio extends GIS {
	
	private EditText et1,et2;
	private TextView textView1;
	
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ira2);
        
        et1=(EditText)findViewById(R.id.editText1);
        et2=(EditText)findViewById(R.id.editText2);
              
        
    }
    
    
    
    public void ok (View view) {
        
        String valor1=et1.getText().toString();
        String valor2=et2.getText().toString();
        
        Intent i = new Intent( iralsitio.this, iralsitio.class );
        i.putExtra("latitud", valor1);
        i.putExtra("longitud", valor2);
        setResult( GIS.RESULT_OK, i );
        iralsitio.this.finish();
              
        
    }
    
    
    public void cancel (View view) {
    	
        Intent i = new Intent( iralsitio.this, iralsitio.class );
        setResult( GIS.RESULT_CANCELED, i );
        iralsitio.this.finish();
    	
    	
    	
    }
    

}
