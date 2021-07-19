package ussrfantom.com.example.bullinventorybyscanner.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import ussrfantom.com.example.bullinventorybyscanner.authorization.Authorization;

public class Register extends AppCompatActivity {

    private EditText editTextLogin;
    private EditText editTextPassword;
    private Button buttonRegister;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editTextLogin = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        buttonRegister = findViewById(R.id.register);
        mAuth = FirebaseAuth.getInstance();

        //нАжатие на кнопку регистрация начало
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editTextLogin.getText().toString().isEmpty() || editTextPassword.getText().toString().isEmpty()){ //првоерка на аход
                    Toast.makeText(Register.this, "Не заполнены поля", Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.createUserWithEmailAndPassword(editTextLogin.getText().toString(), editTextPassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()){
                                        Toast.makeText(Register.this, "Успешно, перенаправляем", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(Register.this, "Ошибка входа", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                }
            }
        });
        //нажатие на кнопку регистрация конец
    }
}