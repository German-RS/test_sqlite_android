package cl.aquilotienes.test_sqlite_android;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cl.aquilotienes.test_sqlite_android.utilidades.Utilidades;

public class ConsultarUsuariosActivity extends AppCompatActivity {

    EditText campoDocumento, campoVerNombre, campoVerTelefono;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuarios);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "db_usuarios",
                null, 1);

        campoDocumento = (EditText) findViewById(R.id.campoDocumento);
        campoVerNombre = (EditText) findViewById(R.id.campoVerNombre);
        campoVerTelefono = (EditText) findViewById(R.id.campoVerTelefono);
    }

    public void onClick(View view){

        switch (view.getId()){

            case R.id.btnBuscar:
                //consultar();
                consultarSQL();
                break;
            case R.id.btnActualizar:
                break;
            case R.id.btnEliminar:
                break;

        }

    }

    private void consultarSQL() {

        SQLiteDatabase db =  conn.getReadableDatabase();
        String[] parametros = {campoDocumento.getText().toString()};

        try {
            //SELECT nombre, telefono from usuario where codigo=?

            Cursor cursor = db.rawQuery(" SELECT " + Utilidades.CAMPO_NOMBRE + ", "
                    + Utilidades.CAMPO_TELEFONO + " FROM " + Utilidades.TABLA_USUARIO +
                    " WHERE " + Utilidades.CAMPO_ID + "=?", parametros);

            cursor.moveToFirst();
            campoVerNombre.setText(cursor.getString(0));
            campoVerTelefono.setText(cursor.getString(1));
            cursor.close();
            db.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(),
                    Toast.LENGTH_SHORT).show();
            limpiar();
        }

    }

    private void consultar() {

        SQLiteDatabase db =  conn.getReadableDatabase();

        String[] parametros = {campoDocumento.getText().toString()};
        String[] campos ={Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_TELEFONO};

        Cursor cursor = db.query(Utilidades.TABLA_USUARIO, campos, Utilidades.CAMPO_ID
                + "=?", parametros, null, null, null);

        try{
            cursor.moveToFirst();
            campoVerNombre.setText(cursor.getString(0));
            campoVerTelefono.setText(cursor.getString(1));
            cursor.close();
            db.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error: " + e.getMessage(),
                    Toast.LENGTH_SHORT).show();
            limpiar();
        }



    }//fin método

    private void limpiar() {

        campoDocumento.setText("");
        campoVerNombre.setText("");
        campoVerTelefono.setText("");
    }

    //v.56

}//.
