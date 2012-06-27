package dis.ufro;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Principal extends Activity {
	
	private Button registrarAlumno;
	private Button inscribirAlumno;
	private Button verCursos;
	private Button verRecursos;
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        
        registrarAlumno = (Button) findViewById(R.id.btn_registrar_alumno);
        inscribirAlumno = (Button) findViewById(R.id.btn_inscribir_alumno);
        verCursos = (Button) findViewById(R.id.btn_ver_cursos);
        verRecursos = (Button) findViewById(R.id.btn_ver_recursos);
       
        registrarAlumno.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.registrar_alumno);
			}
		});
        inscribirAlumno.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.inscribir_alumno);
			}
		});
		verCursos.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.ver_cursos);
			}
		});
		verRecursos.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.ver_recursos);
			}
		});
    }


}