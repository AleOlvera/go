package mecalogik.com.prueba;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PasswordActivity extends AppCompatActivity {

    EditText editTextpassword;
    Button acceder;
    String mundo;
    String password;
    //public  static final int SIGN_IN_CODE = 12345;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        editTextpassword =(EditText) findViewById(R.id.editTextpass);
        acceder = (Button) findViewById(R.id.btnacceder);


        SharedPreferences settings = getSharedPreferences("PREFS",0);
        //SharedPreferences.Editor editor = settings.edit();
        //editor.putString("password",mundo);
        //editor.apply();
        password = settings.getString("password", "holamundo");

        acceder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editTextpassword.getText().toString();

                if(text.equals(password)){
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(PasswordActivity.this, "Contraseña Incorrecta",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
