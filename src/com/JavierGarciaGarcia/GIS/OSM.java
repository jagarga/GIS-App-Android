package com.JavierGarciaGarcia.GIS;

import org.osmdroid.views.MapController;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.MinimapOverlay;
import org.osmdroid.util.GeoPoint;


 
import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Bundle;
 

public class OSM extends GIS {
	
	private MapView myOpenMapView;
	 private MapController   myMapController;
	 GeoPoint p;
	 
	    /** Called when the activity is first created. */
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	 
	        myOpenMapView = (MapView)findViewById(R.id.openmapview);
	        myOpenMapView.setBuiltInZoomControls(true);
	        myMapController = myOpenMapView.getController();
	        myMapController.setZoom(4);
	        p= new GeoPoint( (int) (40.4333*1E6), (int) (-3.6833*1E6));
	        myMapController.setCenter(p);
	        
	        MinimapOverlay miniMapOverlay = new MinimapOverlay(this, myOpenMapView.getTileRequestCompleteHandler());
	        miniMapOverlay.setZoomDifference(5);
	        miniMapOverlay.setHeight(200);
	        miniMapOverlay.setWidth(200);
	        myOpenMapView.getOverlays().add(miniMapOverlay);

   }
	    
	    public void onDestroy(GeoPoint q){
	    	
	    	super.onDestroy();
	    	
	        setContentView(R.layout.activity_main);
	        
	        //Obtenemos una referencia al control MapView
	        mapa = (com.google.android.maps.MapView)findViewById(R.id.mapa);
	        
	        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	 
	        //Mostramos los controles de zoom sobre el mapa
	        mapa.setBuiltInZoomControls(true);
	        mapa.setSatellite(false);
	        mapa.setTraffic(false);
	        mapa.setStreetView(false);

	        

	        
	        mc= mapa.getController();

	        mc.setZoom(4);
	        mapa.invalidate();
	    }
	    
}
