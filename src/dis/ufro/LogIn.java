package dis.ufro;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.ksoap2.transport.HttpTransportSE;
import net.patrickpollet.moodlewsold.core.CourseRecord;
import net.patrickpollet.moodlewsold.core.GetCoursesReturn;
import net.patrickpollet.moodlewsold.core.LoginReturn;
import net.patrickpollet.moodlewsold.core.MoodleWSBindingStub;

public class LogIn extends Activity {
	
	private Button btn_Login;
	private EditText et_usr;
	private EditText et_pwd;
	private TextView tv_info;
	//login
	private final String MOODLE_URL = "http://10.0.2.2/moodle/";
	private final String LOGIN = "admin";
	private final String PWD = "123456Asd#";
	private final boolean WS_DEBUG = false;
	private final String NAMESPACE = MOODLE_URL + "wspp/wsdl/";
	private final String TAG = "moodlews@android";
	private final String URL = MOODLE_URL + "wspp/service_pp.php";
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
               
        et_usr = (EditText)findViewById(R.id.et_usr);
        et_pwd = (EditText)findViewById(R.id.et_pwd);
        tv_info =(TextView)findViewById(R.id.tv_info);
        
        btn_Login = (Button) findViewById(R.id.btn_login);
        btn_Login.setOnClickListener(new OnClickListener() {
		
			public void onClick(View v) {
				//LOGIN = et_usr.getText().toString();
				//PWD = et_pwd.getText().toString();
				
				tv_info.setText("usr: "+LOGIN+" pass: "+PWD);

				autentificar(LOGIN, PWD);
				
				//la siguiente linea es solo de prueba
				//setContentView(R.layout.principal);
			}
		});		
    }
 /**
  *    
  * @param login
  * @param pwd
  * @return
  */
    private void autentificar(String login, String pwd){
    	MoodleWSBindingStub moodle=new MoodleWSBindingStub(this.URL,this.NAMESPACE,this.WS_DEBUG);
    	LoginReturn lr = moodle.login(LOGIN, PWD);
    	tv_info.setText(URL+"\n"+NAMESPACE+"\n usr: "+LOGIN+" pass: "+PWD+" lr: "+lr);
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