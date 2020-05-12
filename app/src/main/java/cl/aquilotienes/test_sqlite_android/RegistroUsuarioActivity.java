package cl.aquilotienes.test_sqlite_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cl.aquilotienes.test_sqlite_android.utilidades.Utilidades;

public class RegistroUsuarioActivity extends AppCompatActivity {

    EditText etId, etNombre, etTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);

        etId = (EditText) findViewById(R.id.etId);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etTelefono = (EditText) findViewById(R.id.etTelefono);

    }

    public void onClick(View view){
        registrarUsuarios();
    }

    private void registrarUsuarios() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "db_usuarios",
                null, 1);

        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID, etId.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE, etNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, etTelefono.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);

        Toast.makeText(getApplicationContext(), "Id Registro: " + idResultante,
                Toast.LENGTH_LONG).show();

        db.close();

    }

    //https://www.youtube.com/watch?v=SmrpCjz-QlA
}//.
