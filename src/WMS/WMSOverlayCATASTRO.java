package WMS;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
 
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
 
public class WMSOverlayCATASTRO extends Overlay {  
          @Override
          public void draw(Canvas canvas, MapView mapView, boolean shadow) {
               super.draw(canvas, mapView, shadow);
               WMSLoaderCATASTRO wmsclient = new WMSLoaderCATASTRO();
               GeoPoint[] cornerCoords = MapUtils.getCornerCoordinates(mapView.getProjection(), canvas, mapView);          
               Bitmap image = wmsclient.loadMap(canvas.getWidth(), canvas.getHeight(), cornerCoords[0], cornerCoords[1]);
               Paint semitransparent = new Paint();
               //semitransparent.setAlpha(0x888);
               canvas.drawBitmap(image, 0, 0, semitransparent);
          }      
}