package com.JavierGarciaGarcia.GIS;

import java.util.List;

import WMS.WMSOverlayCARTOCIUDAD;
import WMS.WMSOverlayCATASTRO;
import WMS.WMSOverlayOSMMDT;
import WMS.WMSOverlayPNOA;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;



import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;







public class GIS extends MapActivity {
	 
	private static final int REQUEST_TEXT = 0; //SE USA LUEGO PARA DEVOLVER PARAMETROS DE UNA SUBACTIVIDAD A ESTA PRINCIPAL
    protected MapView mapa = null;
    MapController mc;
    GeoPoint p;
    protected LocationManager locationManager;

 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        
        setContentView(R.layout.activity_main);
 
        //Obtenemos una referencia al control MapView
        mapa = (MapView)findViewById(R.id.mapa);
        
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
 
        //Mostramos los controles de zoom sobre el mapa
        mapa.setBuiltInZoomControls(true);
        mapa.setSatellite(false);
        mapa.setTraffic(false);
        mapa.setStreetView(false);

        

        
        mc= mapa.getController();
        String coordenadas[] = {"40.4333", "-3.6833"};    //coordenadas de Madrid
        double lat = Double.parseDouble(coordenadas[0]);
        double lon = Double.parseDouble(coordenadas[1]);
                
        p= new GeoPoint( (int) (lat*1E6), (int) (lon*1E6));
        
        mc.animateTo(p);
        mc.setZoom(4);
        mapa.invalidate();
        
        
		//Añadimos la capa de marcas
/*		List<Overlay> capas = mapa.getOverlays();
		OverlayMapa om = new OverlayMapa();
		capas.add(om);
		mapa.postInvalidate();            */



        
        
    }
    

 
    @Override
    protected boolean isRouteDisplayed() {
        return false;
    }
    
	public boolean onCreateOptionsMenu(Menu menu) {

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
   
    protected void muestracoordenadas() {

		Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

		if (location != null) {
					
			
			String message = String.format(
					"Datos GPS \n Longitud: %1$s \n Latitud: %2$s \n Altitud: %3$s \n Tiempo TUC: %4$s \n Precision: %5$s",
					location.getLongitude(), location.getLatitude(), location.getAltitude(), location.getTime(), location.getAccuracy()
			);
			Toast.makeText(GIS.this, message,
					Toast.LENGTH_LONG).show();
		}
		else {
			
			Toast.makeText(GIS.this, "El dispositivo GPS esta desactivado o no hay señal GPS",
					Toast.LENGTH_LONG).show();
			
		}

	}
    
    //metodo recibe cordenadas de ubicacion gps y las envia al mapa para que actualize la vista
    public void miubicacion() {
    	
		Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		
		double lat= 40.4333;
		double lon= -3.6833;

		if (location != null) {
			
			lat= location.getLatitude();
			lon= location.getLongitude();
			
		
	        p= new GeoPoint( (int) (lat*1E6), (int) (lon*1E6));
	        
	        mc.animateTo(p);
	        mc.setZoom(15);
	        mapa.invalidate();
	        
	        
			//Añadimos la capa de marcas
			List<Overlay> capas = mapa.getOverlays();
			OverlayMapa om = new OverlayMapa();
			capas.add(om);
			mapa.postInvalidate();
	        
	        
	        
	        
	        
		}
		else {
			
			Toast.makeText(GIS.this, "El dispositivo GPS esta desactivado o no hay señal GPS",
					Toast.LENGTH_LONG).show();
		
	        
		}
    	
    	
    }
    
    
    //clase que devuelve los datos de las subactividades
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if ( requestCode == REQUEST_TEXT ){
             if ( resultCode == Activity.RESULT_OK ){
                  String longitud= data.getExtras().get("longitud").toString();
                  String latitud= data.getExtras().get("latitud").toString();
                  
                  int lat= (int) (Double.parseDouble(latitud)*1E06);
                  int lon= (int) (Double.parseDouble(longitud)*1E06);
                  
      	        p= new GeoPoint(lat,lon);
    	        
    	        mc.animateTo(p);
    	        mc.setZoom(15);
    	        mapa.invalidate();
                  
             }
        }

   }
    
	
	//menu de la aplicacion
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {

		case R.id.acercaDe:

	        Intent i = new Intent(this, AcercaDe.class );
	        startActivity(i);
	        
			break;
			
		case R.id.azidist:

	        Intent j = new Intent(this, AziDist.class );
	        startActivity(j);
	        
			break;
			
		
		case R.id.gps:

            muestracoordenadas();
            miubicacion();
            

			
			break;
			
			
		case R.id.irallugar:


	        Intent k = new Intent(this, iralsitio.class );
	        GIS.this.startActivityForResult(k, REQUEST_TEXT);
	        
	        
			
			break;
			
			
		case R.id.WMS:
			
            //llama a los ids del submenu de abajo
			
			break;
			
	   
		case R.id.catastro:
			
			mapa.clearAnimation();
			
	        List<Overlay> overlays = mapa.getOverlays();
	        WMSOverlayCATASTRO myOverlay = new WMSOverlayCATASTRO();

	        overlays.add(myOverlay);

	        mapa.postInvalidate();
			
			break;
			
			
		case R.id.cartociudad:
			
			mapa.clearAnimation();
			
	        List<Overlay> overlays2 = mapa.getOverlays();
	        WMSOverlayCARTOCIUDAD myOverlay2 = new WMSOverlayCARTOCIUDAD();

	        overlays2.add(myOverlay2);

	        mapa.postInvalidate();
			
			break;
			
			
		case R.id.pnoa:
			
			mapa.clearAnimation();
			
	        List<Overlay> overlays3 = mapa.getOverlays();
	        WMSOverlayPNOA myOverlay3 = new WMSOverlayPNOA();

	        overlays3.add(myOverlay3);

	        mapa.postInvalidate();
			
			break;
			
			
		case R.id.mdt:
			
			mapa.clearAnimation();
			
	        List<Overlay> overlays4 = mapa.getOverlays();
	        WMSOverlayOSMMDT myOverlay4 = new WMSOverlayOSMMDT();

	        overlays4.add(myOverlay4);

	        mapa.postInvalidate();
			
			break;
			
			
		
		case R.id.opciones:

            //llama a los ids del submenu de abajo
			
			break;
			
			
		case R.id.mapa:
			
			mapa.clearAnimation();

	        mapa.setBuiltInZoomControls(true);
	        mapa.setSatellite(false);
	        mapa.setTraffic(false);
	        mapa.setStreetView(false);
			
			break;
			
			
		case R.id.satelite:

	        mapa.setBuiltInZoomControls(false);
	        mapa.setSatellite(true);
	        mapa.setTraffic(false);
	        mapa.setStreetView(false);
			
			break;
			
			
		case R.id.trafico:

	        mapa.setBuiltInZoomControls(false);
	        mapa.setSatellite(false);
	        mapa.setTraffic(true);
	        mapa.setStreetView(false);
			
			break;
			
			
		case R.id.streetview:

	        mapa.setBuiltInZoomControls(false);
	        mapa.setSatellite(false);
	        mapa.setTraffic(false);
	        mapa.setStreetView(true);
			
			break;
			
		case R.id.osm:

	        Intent l = new Intent(this, OSM.class );
	        startActivity(l);
			
			
			break;
			
		}
		
		
		return true;
		}
	
	
	

}