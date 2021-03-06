package com.ray.mitiendita.Vistas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.ray.mitiendita.Modelos.Usuarios;
import com.ray.mitiendita.Modelos.Usuarios_Table;
import com.ray.mitiendita.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Login extends AppCompatActivity {

    @BindView(R.id.btnAcceder)
    MaterialButton btnAcceder;
    @BindView(R.id.User)
    TextInputEditText User;
    @BindView(R.id.Pass)
    TextInputEditText Pass;
    @BindView(R.id.textError)
    TextView textError;

    private Usuarios usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btnAcceder)
    public void onViewClickedLogin() {

        String usuario = User.getText().toString().trim();
        String contraseña = Pass.getText().toString().trim();

        if (usuario.isEmpty()) {
            textError.setText("Debe agregar el usuario");
        }

        if (contraseña.isEmpty()) {
           textError.setText("Debe agregar la contraseña");
        }

        if (usuario.isEmpty() && contraseña.isEmpty()){
            textError.setText("Debe agregar el usuario y contraseña");
        }

        if(!usuario.isEmpty() && !contraseña.isEmpty()){
            Ingreso(usuario, contraseña);
        }
    }

    private void Ingreso(String NombreUsuario, String Password){
        usuarios = SQLite
                .select()
                .from(Usuarios.class)
                .where(Usuarios_Table.id_Usuario.is(1))
                .querySingle();

            if (usuarios.getNombreUsuario().equals(NombreUsuario)
                    && usuarios.getContraseña().equals(Password) ) {

                usuarios.setActivo(1);
                usuarios.update();

                Intent intent = new Intent(this, OnBoardingScreen.class);
                startActivity(intent);
                finish();
            } else {
                textError.setText("Datos incorrectos");
            }
    }
}

