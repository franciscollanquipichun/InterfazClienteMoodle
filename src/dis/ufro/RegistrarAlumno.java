package dis.ufro;

import java.util.Arrays;

import net.patrickpollet.moodlews.core.*;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistrarAlumno extends Activity{
	
	private EditText et_rut;
	private EditText et_nombre;
	private EditText et_apellido;
	private EditText et_email;
	private Button btn_inscribirAlumno;
	
    private String rut = null;
    private String nombre = null;
    private String apellido = null;
    private String email = null;
    private String contraseña = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_alumno);
        
        et_rut = (EditText) findViewById(R.id.et_registrarAlumno_rut);
        et_nombre = (EditText) findViewById(R.id.et_registrarAlumno_nombre);
        et_apellido = (EditText) findViewById(R.id.et_registrarAlumno_apellido);
        et_email = (EditText) findViewById(R.id.et_registrarAlumno_email);
        btn_inscribirAlumno = (Button) findViewById(R.id.btn_registrarAlumno_inscribirAlumno);
        
        btn_inscribirAlumno.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rut=et_rut.getText().toString();
				nombre=et_nombre.getText().toString();
				apellido=et_apellido.getText().toString();
				email=et_email.getText().toString();
				generaContraseña();
				nuevoUsuario();
			}
		});
	}
/**
 * Agrega un nuevo Usuario
 */
	private void nuevoUsuario(){
		if(validarUsuario()==true){
			
			UserDatum newU=new UserDatum(Constantes.NAMESPACE);
			newU.setUsername(rut);
			newU.setIdnumber(rut);
			newU.setFirstname(nombre);
			newU.setLastname(apellido);
			newU.setEmail(email);
			newU.setPassword(contraseña);
			newU.setCity("Temuco");
			newU.setCountry("CL");
			newU.setPolicyagreed(1);
			
			Mdl_soapserverBindingStub moodle = new Mdl_soapserverBindingStub(Constantes.URL,Constantes.NAMESPACE,Constantes.WS_DEBUG);
			LoginReturn lr = moodle.login(Constantes.LOGIN, Constantes.PWD);
			UserRecord[] userRecord = moodle.add_user(lr.getClient(),lr.getSessionkey(),newU);

			if (userRecord != null) {
				if (!userRecord[0].getError().equals("")) {
					Toast.makeText(getApplicationContext(),	"Error al ingresar Usuario",Toast.LENGTH_SHORT).show();
				} else{
					Toast.makeText(getApplicationContext(),"Usuario ingresado Correctamente",Toast.LENGTH_LONG).show();
					limpiar();
				}
			}
		}
		
	}
/**
 * valida los datos del nuevo usuario
 * @return boolean
 */
	private boolean validarUsuario(){
		if(rut==null||nombre==null||apellido==null||email==null||contraseña==null){
			Toast.makeText(getApplicationContext(), "Error: Campo nulo", Toast.LENGTH_LONG).show();
			return false;
		}else if(rut.length()==0||nombre.length()==0||apellido.length()==0||email.length()==0||contraseña.length()==0){
			Toast.makeText(getApplicationContext(), "Error: Campo vacio", Toast.LENGTH_LONG).show();
			return false;
		}else{
			if(email.matches("[a-zA-Z0-9.-]+@[a-z]+\\.[a-z]+")){
				return true;
			}else{
				Toast.makeText(getApplicationContext(), "Error de formato: correo", Toast.LENGTH_LONG).show();
				return false;
			}		
		}
	}
/**
 * genera la contraseña para el nuevo usuario
 */
	private void generaContraseña(){
		contraseña = rut+"Asd";
	}
/**
 * limpia el formulario
 */
	private void limpiar(){
		et_rut.setText("");
		et_nombre.setText("");
		et_apellido.setText("");
		et_email.setText("");
	}
}
