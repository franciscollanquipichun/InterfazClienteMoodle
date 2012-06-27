package Test;



import org.ksoap2.transport.HttpTransportSE;


import net.patrickpollet.moodlewsold.core.CourseRecord;
import net.patrickpollet.moodlewsold.core.GetCoursesReturn;
import net.patrickpollet.moodlewsold.core.LoginReturn;
import net.patrickpollet.moodlewsold.core.MoodleWSBindingStub;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Coneccion extends Activity {
	/** Called when the activity is first created. */
	// the array is right now available
	// TESTING adjust to your site
	// do not use http://localhost/ if running under emulator ( connexion refused !) 
	private final String MOODLE_URL = "http://10.0.2.2/moodle/";
	private final String LOGIN = "admin";
	private final String PWD = "123456Asd#";
	private final boolean WS_DEBUG = false;
	// END TESTING

	// we use the simplified wsdl version
	private final String NAMESPACE = MOODLE_URL + "wspp/wsdl/";
	private final String TAG = "moodlews@android";
	private final String URL = MOODLE_URL + "/wspp/service_pp.php";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.main);
		// nothing is printed onscreen see DDMS Log
		MoodleWSBindingStub moodle=new MoodleWSBindingStub(this.URL,this.NAMESPACE,this.WS_DEBUG);
		
			LoginReturn lr = moodle.login(LOGIN, PWD);
			if (lr != null) {
				int me = moodle.get_my_id(lr.getClient(),lr.getSessionkey());
				this.logInfo("get_my_id",""+me);
				
				GetCoursesReturn crs=moodle.get_my_courses(lr.getClient(),lr.getSessionkey(),me,"");
				for (CourseRecord c : crs.getCourses())
					this.logInfo("get_my_courses",c);			
				moodle.logout(lr.getClient(),lr.getSessionkey());
			}
		}



	/**
	 * log detailed errors if WS_DEBUG is activated
	 * 
	 * @param androidHttpTransport
	 * @param e
	 */
	private void logError(HttpTransportSE androidHttpTransport, Exception e) {
		// give a null pointer exception if debug is off in transport
		if (WS_DEBUG) {
			Log.e(TAG, androidHttpTransport.requestDump.toString());
			Log.e(TAG, "lng="
					+ (androidHttpTransport.requestDump.toString().length()));
			Log.e(TAG, androidHttpTransport.responseDump.toString());
			Log.e(TAG, "lng="
					+ (androidHttpTransport.responseDump.toString().length()));
		}
		e.printStackTrace();

	}

	/**
	 * log successfull operation if WS_DEBUG is activated
	 * 
	 * @param method_name
	 * @param ret
	 */
	private void logInfo(String method_name, Object ret) {
		if (WS_DEBUG)
			Log.i(TAG, "reponse " + method_name + " : " + ret.toString());
	}

}