package dis.ufro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

public class VerRecursos extends Activity{
	
	private Spinner sp_curso;
	private ListView lv_recursos;
	private Button btn_verRecursos;
	private Button btn_volver;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_alumno);
        
        sp_curso = (Spinner) findViewById(R.id.sp_verRecursos_curso);
        lv_recursos = (ListView) findViewById(R.id.lv_verRecursos_recursos);
        btn_volver = (Button) findViewById(R.id.btn_verRecursos_volver);
        btn_verRecursos = (Button) findViewById(R.id.btn_verRecursos_verRecursos);
        
        btn_volver.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.principal);
			}
		});
        btn_verRecursos.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
