package dis.ufro;

import java.util.Arrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.patrickpollet.moodlews.core.*;
import org.ksoap2.transport.HttpTransportSE;


public class LogIn extends Activity {
	
	private Button btn_Login;
	private EditText et_usr;
	private EditText et_pwd;
	private TextView tv_infoUrl;
	private String Sessionkey = null;
	private static final int REQUEST_CODE = 10;
	//login
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
               
        et_usr = (EditText)findViewById(R.id.et_usr);
        et_pwd = (EditText)findViewById(R.id.et_pwd);
        tv_infoUrl =(TextView)findViewById(R.id.tv_info);
        btn_Login = (Button) findViewById(R.id.btn_login);
        
        tv_infoUrl.setText(Constantes.MOODLE_URL);
        //Acción del boton de login btn_Login
        btn_Login.setOnClickListener(new OnClickListener() {			
			public void onClick(View v) {
				Constantes.LOGIN=et_usr.getText().toString(); 
				Constantes.PWD=et_pwd.getText().toString();
				if(validarLogin()==true){
					Toast.makeText(getApplicationContext(), "login correcto", Toast.LENGTH_LONG).show();
					
					Intent i = new Intent(LogIn.this, Principal.class);
					i.putExtra("SecionKey",Sessionkey);
					startActivity(i);
				}
				else{
					Toast.makeText(getApplicationContext(), "error de login", Toast.LENGTH_LONG).show();
				}
			}
		});
    }
/**
 *  crea menu configuracion de moodle   
 */
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater=getMenuInflater();
    	inflater.inflate(R.menu.loginmenu, menu);
    	return true;
    }    
/**
 * Valida el usuario y contraseña ingresados
 * @return boolean
 */
    private boolean validarLogin(){
    	Mdl_soapserverBindingStub moodle = new Mdl_soapserverBindingStub(Constantes.URL,Constantes.NAMESPACE,Constantes.WS_DEBUG);
		
		LoginReturn lr = moodle.login(Constantes.LOGIN, Constantes.PWD);
		if (lr != null) {
			Sessionkey = lr.getSessionkey();
			this.logInfo("get_my_id",""+Sessionkey);
			return true;
		}
		else{
			return false;
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
		if (Constantes.WS_DEBUG) {
			Log.e(Constantes.TAG, androidHttpTransport.requestDump.toString());
			Log.e(Constantes.TAG, "lng="
					+ (androidHttpTransport.requestDump.toString().length()));
			Log.e(Constantes.TAG, androidHttpTransport.responseDump.toString());
			Log.e(Constantes.TAG, "lng="
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
		if (Constantes.WS_DEBUG)
			Log.i(Constantes.TAG, "reponse " + method_name + " : " + ret.toString());
	}
}