package com.JavierGarciaGarcia.GIS;

import android.location.Location;
import android.location.LocationManager;

import com.google.android.maps.GeoPoint;


public class miubicacion {
	
	
	
	public static GeoPoint gps()
	{
	    LocationManager locationManager = null;
		double lat, lon;
	    GeoPoint p;
		Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
		

		lat= location.getLatitude();
		lon= location.getLongitude();
		
	
        p= new GeoPoint( (int) (lat*1E6), (int) (lon*1E6));
        
        return p;

	}

}
