package WMS;

import android.graphics.Canvas;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Projection;
 
public class MapUtils {
     
    public static double longitude(GeoPoint point){
        return (double) (point.getLongitudeE6()/1e6);
    }
     
    public static double latitude(GeoPoint point){
        return (double) (point.getLatitudeE6()/1e6);
    }
     
    public static  GeoPoint[] getCornerCoordinates(Projection projection,Canvas canvas, MapView mapView){
        GeoPoint[] geoPoint = new GeoPoint[2];
        geoPoint[0]= projection.fromPixels(0, 0);
        geoPoint[1]= projection.fromPixels(mapView.getWidth() - 1, mapView.getHeight() - 1);
        return geoPoint;
         
    }
 
}