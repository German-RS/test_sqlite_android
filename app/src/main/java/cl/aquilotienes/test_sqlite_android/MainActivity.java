package cl.aquilotienes.test_sqlite_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnRegistrarUsuario, btnConsultarUsuario, btnConsultarUsuarioSpinner,
            btnConsultarUsuarioList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegistrarUsuario = (Button) findViewById(R.id.btnRegistrarUsuario);
        btnConsultarUsuario = (Button) findViewById(R.id.btnConsultarUsuario);
        btnConsultarUsuarioSpinner = (Button) findViewById(R.id.btnConsultarUsuarioSpinner);
        btnConsultarUsuarioList = (Button) findViewById(R.id.btnConsultarUsuarioList);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_usuarios",
                null, 1);

    }

    public void onClick(View view){

        Intent miIntent = null;

        switch (view.getId()){

            case R.id.btnRegistrarUsuario:
            miIntent = new Intent(MainActivity.this, RegistroUsuarioActivity.class);
            break;

            case R.id.btnConsultarUsuario:
                miIntent = new Intent(MainActivity.this, ConsultarUsuariosActivity.class);
                break;


        }
        if(miIntent != null){
            startActivity(miIntent);
        }


    }// fin método.


}//fin clase.
