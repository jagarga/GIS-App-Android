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
 
public class WMSLoaderCATASTRO {
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
	  
	 /* url = new URL(String.format("http://www.01.cartociudad.es/wms/CARTOCIUDAD/CARTOCIUDAD?REQUEST=GetMap&VERSION=1.1.1&SERVICE=WMS&SRS=EPSG:4326&LAYERS=DivisionTerritorial,FondoUrbano,Vial,Portal,Toponimo,SeccionCensal,CodigoPostal&STYLES=&FORMAT=image/png" + "" +
	             "&BBOX=" + resu+","+ resu2+","+ resu3+","+ resu4 + "&WIDTH=%d&HEIGHT=%d"
	             , width, height));    //FUNCIONA   */
	  
	/*  url = new URL(String.format("http://www.idee.es/wms/PNOA/PNOA?REQUEST=GetMap&VERSION=1.1.1&SERVICE=WMS&SRS=EPSG:4326&LAYERS=pnoa&STYLES=&FORMAT=image/png" + "" +
			  "&BBOX=" + resu+","+ resu2+","+ resu3+","+ resu4 + "&WIDTH=%d&HEIGHT=%d"
                 , width, height));      //FUNCIONA */
	  
	  
	  url = new URL(String.format("http://ovc.catastro.meh.es/Cartografia/WMS/ServidorWMS.aspx?SERVICE=WMS&SRS=EPSG:4326&REQUEST=GETMAP&format=PNG&transparent=off&layers=catastro" + "" +
			  "&BBOX=" + resu+","+ resu2+","+ resu3+","+ resu4 + "&WIDTH=%d&HEIGHT=%d"
                 , width, height));      //FUNCIONA

	  

	  
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