package com.JavierGarciaGarcia.GIS;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.JavierGarciaGarcia.GIS.R;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.Projection;

public class OverlayMapa extends Overlay {

    private Double latitud = 40.4333*1E6;
    private Double longitud = -3.6833*1E6;
 
    public void draw(Canvas canvas, MapView mapView, boolean shadow){
    	
    	
        Projection projection = mapView.getProjection();
        GeoPoint punto =
                new GeoPoint(latitud.intValue(), longitud.intValue());

 
        if (shadow == false)
        {
            Point posicion = new Point();
            projection.toPixels(punto, posicion);
 
            //Definimos el pincel de dibujo
            Paint p = new Paint();
            p.setColor(Color.BLUE);
 
            //Marca Ejemplo 1: Círculo y Texto
            //canvas.drawCircle(posicion.x, posicion.y, 5, p);
            //canvas.drawText("Posicion", posicion.x+10, posicion.y+5, p);
            
            
			//Marca Ejemplo 2: Bitmap
			Bitmap bm = BitmapFactory.decodeResource(
					mapView.getResources(), 
					  R.drawable.marcador_google_maps);
			 
			canvas.drawBitmap(bm, posicion.x - bm.getWidth(),
			        posicion.y - bm.getHeight(), p);
        }
    }
	
}
