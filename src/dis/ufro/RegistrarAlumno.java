package dis.ufro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrarAlumno extends Activity{
	
	private EditText et_nombre;
	private EditText et_rut;
	private Button btn_inscribirAlumno;
	private Button btn_volver;
	private TextView info;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_alumno);
        
        et_nombre = (EditText) findViewById(R.id.et_registrarAlumno_nombre);
        et_rut = (EditText) findViewById(R.id.et_registrarAlumno_rut);
        
        btn_inscribirAlumno = (Button) findViewById(R.id.btn_registrarAlumno_inscribirAlumno);
        btn_volver = (Button) findViewById(R.id.btn_registrarAlumno_volver);
        
        btn_inscribirAlumno.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
        btn_volver.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.principal);	
			}
		});
	}

}
