package dis.ufro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class InscribirAlumno extends Activity{
	
	private Spinner sp_alumno;
	private Spinner sp_curso;
	private Button btn_inscribir;
	private Button btn_volver;
	private TextView info;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_alumno);
        
        info = (TextView) findViewById(R.id.inscribir_alumno_info);
        sp_alumno = (Spinner) findViewById(R.id.inscribir_alumno_sp_alumno);
        sp_curso = (Spinner) findViewById(R.id.inscribir_alumno_sp_curso);
        btn_inscribir = (Button) findViewById(R.id.inscribir_alumno_btn_inscribir);
        btn_volver = (Button) findViewById(R.id.inscribir_alumno_btn_volver);
        
        btn_volver.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.principal);	
			}
		});
        btn_inscribir.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				info.setText("El alumno se ha inscrito correctamente");
			}
		});
	}
}
