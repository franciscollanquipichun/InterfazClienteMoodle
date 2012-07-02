package dis.ufro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Principal extends Activity {
	
	private String sk;
	private Button registrarAlumno;
	private Button inscribirAlumno;
	private Button verCursos;
	private Button verRecursos;
	private TextView tv_info;	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        
        Bundle extras = getIntent().getExtras();
		if (extras == null) {
			return;
		}
		sk=extras.getString("SecionKey");
		
        registrarAlumno = (Button) findViewById(R.id.btn_registrar_alumno);
        inscribirAlumno = (Button) findViewById(R.id.btn_inscribir_alumno);
        verCursos = (Button) findViewById(R.id.btn_ver_cursos);
        verRecursos = (Button) findViewById(R.id.btn_ver_recursos);
        tv_info = (TextView) findViewById(R.id.tv_info);
        
        registrarAlumno.setOnClickListener(new OnClickListener() {	
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Principal.this, RegistrarAlumno.class);
				i.putExtra("SecionKey",sk);
				startActivity(i);
			}
		});
        inscribirAlumno.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Principal.this, InscribirAlumno.class);
				i.putExtra("SecionKey",sk);
				startActivity(i);
			}
		});
		verCursos.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Principal.this, VerCursos.class);
				i.putExtra("SecionKey",sk);
				startActivity(i);
			}
		});
		verRecursos.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Principal.this, VerRecursos.class);
				i.putExtra("SecionKey",sk);
				startActivity(i);
			}
		});
    }


}