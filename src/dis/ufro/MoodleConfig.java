package dis.ufro;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MoodleConfig extends Activity{
	
	private Button btn_Modificar;
	private EditText et_URL;
	private EditText et_NAMESPACE;
	private EditText et_WSDL;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moodle_config);
        
        et_URL = (EditText) findViewById(R.id.et_moodle_config_url);
        et_NAMESPACE = (EditText) findViewById(R.id.et_moodle_config_namespace);
        et_WSDL = (EditText) findViewById(R.id.et_moodle_config_wsdl);
        btn_Modificar = (Button) findViewById(R.id.btn_modificar);
        
        et_URL.setText(Constantes.MOODLE_URL);
        et_NAMESPACE.setText(Constantes.NAMESPACE);
        et_WSDL.setText(Constantes.URL);
        
        btn_Modificar.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Constantes.MOODLE_URL=et_URL.getText().toString();
				Constantes.NAMESPACE=et_NAMESPACE.getText().toString();
				Constantes.URL=et_WSDL.getText().toString();
				
				Toast.makeText(getApplicationContext(), "Datos modificados correctamente", Toast.LENGTH_LONG).show();
			}
		});
	}

}
