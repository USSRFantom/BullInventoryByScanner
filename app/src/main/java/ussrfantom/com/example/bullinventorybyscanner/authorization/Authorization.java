package ussrfantom.com.example.bullinventorybyscanner.authorization;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import ussrfantom.com.example.bullinventorybyscanner.R;
import ussrfantom.com.example.bullinventorybyscanner.register.Register;
import ussrfantom.com.example.bullinventorybyscanner.selectionmenu.SelectionMenu;

public class Authorization extends AppCompatActivity {
    private EditText editTextLogin;
    private EditText editTextPassword;
    private Button buttonEntrance;
    private Button buttonRegister;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        editTextLogin = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonEntrance = findViewById(R.id.entrance);
        buttonRegister = findViewById(R.id.register);
        mAuth = FirebaseAuth.getInstance();

        //Нажатие на кнопку регистрация начало
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Authorization.this, Register.class);
                startActivity(intent);
                finish();
            }
        });
        //Нажатие на кнопку регистрация конец

        //Нажатие на кнопку вход начало
        buttonEntrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextLogin.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty()){ //првоерка на аход
                    Toast.makeText(Authorization.this, "Не заполнены поля", Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.signInWithEmailAndPassword(editTextLogin.getText().toString(), editTextPassword.getText().toString())   //отправляем логин и пароль
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(Authorization.this, "Успешно, перенаправляем в главное меню", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(Authorization.this, SelectionMenu.class);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(Authorization.this, "Ошибка входа", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        //Нажатие на кнопку вход конец

    }
}