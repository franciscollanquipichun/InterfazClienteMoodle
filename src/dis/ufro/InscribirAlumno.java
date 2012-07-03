package dis.ufro;

import net.patrickpollet.moodlews.core.LoginReturn;
import net.patrickpollet.moodlews.core.Mdl_soapserverBindingStub;
import net.patrickpollet.moodlews.core.UserDatum;
import net.patrickpollet.moodlews.core.UserRecord;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class InscribirAlumno extends Activity{
	
	private Spinner sp_alumno;
	private Spinner sp_curso;
	private Button btn_inscribir;
	private TextView info;
	@Override
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inscribir_alumno);
        
        info = (TextView) findViewById(R.id.inscribir_alumno_info);
        sp_alumno = (Spinner) findViewById(R.id.inscribir_alumno_sp_alumno);
        sp_curso = (Spinner) findViewById(R.id.inscribir_alumno_sp_curso);
        btn_inscribir = (Button) findViewById(R.id.inscribir_alumno_btn_inscribir);

        btn_inscribir.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				listarUsuarios();
				info.setText("El alumno se ha inscrito correctamente");
			}
		});
	}
	private void listarUsuarios(){
		UserDatum[] usr= new UserDatum[2];
		for (int i=0; i<10; i++) {
			usr[i]=new UserDatum(Constantes.NAMESPACE);
			usr[i].setId(i);
			usr[i].setAction("get");
			
		}
		Mdl_soapserverBindingStub moodle = new Mdl_soapserverBindingStub(Constantes.URL,Constantes.NAMESPACE,Constantes.WS_DEBUG);
		LoginReturn lr = moodle.login(Constantes.LOGIN, Constantes.PWD);
		UserRecord[] users3=moodle.edit_users(lr.getClient(), lr.getSessionkey(), usr);
		for (UserRecord u : users3)
			Toast.makeText(getApplicationContext(), u.toString(), Toast.LENGTH_LONG).show();
		
	}
	private void listarCursos(){
		
	}
}
