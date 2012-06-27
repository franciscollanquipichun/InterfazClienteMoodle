package dis.ufro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class VerCursos extends Activity{
	
	private Spinner sp_alumno;
	private ListView lv_cursos;
	private Button btn_verCursos;
	private Button btn_volver;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrar_alumno);
        
        sp_alumno = (Spinner) findViewById(R.id.sp_verCursos_alumno);
        lv_cursos = (ListView) findViewById(R.id.lv_verCursos_cursos);
        btn_verCursos=(Button) findViewById(R.id.btn_verCursos_verCursos);
        btn_volver = (Button) findViewById(R.id.btn_verCursos_volver);
        
        btn_volver.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setContentView(R.layout.principal);
			}
		});
        btn_verCursos.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
