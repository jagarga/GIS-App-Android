package WMS;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;


import com.google.android.maps.GeoPoint;
 
public class WMSLoaderOSMMDT {
 public static String TAG = "WMSLoader Exception";
  
 @SuppressLint("NewApi")
public Bitmap loadMap(int width, int height, GeoPoint ul, GeoPoint lr) {
  URL url = null;
 
  try {
       

	  
	  double p1= MapUtils.longitude(ul);
	  double p2= MapUtils.latitude(lr);
	  double p3= MapUtils.longitude(lr);
	  double p4= MapUtils.latitude(ul);

	  String resu=String.valueOf(p1);
	  String resu2=String.valueOf(p2);
	  String resu3=String.valueOf(p3);
	  String resu4=String.valueOf(p4); 
	  

	  
	  url = new URL(String.format("http://129.206.228.72/osm-proxy/service?SERVICE=WMS&VERSION=1.1.1&STYLES=&SRS=EPSG:4326&REQUEST=GetMap&Format=image/png&layers=europe_wms:hs_srtm_europa" + "" +
			  "&BBOX=" + resu+","+ resu2+","+ resu3+","+ resu4 + "&WIDTH=%d&HEIGHT=%d"
                 , width, height));      

	  //http://www.osm-wms.de/#info

	  
  } catch (MalformedURLException e) {
   Log.e(TAG, e.getMessage());
  }
  InputStream input = null;
  try {
   input = url.openStream();
  } catch (IOException e) {
   Log.wtf(TAG, "****************** Error al cargar WMS: " + e.getMessage());
  }
  return BitmapFactory.decodeStream(input);
 }
} 