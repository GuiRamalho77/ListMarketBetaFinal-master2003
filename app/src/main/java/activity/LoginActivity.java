package activity;

/**
 * Created by Bruno - PC on 14/03/2015.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import classes.classes.DAO.DAO;
import classes.classes.DAO.cidades;
import classes.classes.DAO.listascompras;
import classes.classes.DAO.usuarios;

import com.listmarketbeta.R;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends  Activity implements AdapterView.OnItemSelectedListener {

    public EditText edtemailL, edtsenhaL;
    public static DAO user;


    Spinner spinner;
    TextView spinerselec;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        user = new DAO();
        setContentView(R.layout.login);

        getActionBar().setLogo(R.drawable.ic_launcher);
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayUseLogoEnabled(true);



        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);

        TextView registerScreen = (TextView) findViewById(R.id.link_to_register);

        // Listening to register new account link
        registerScreen.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
            }
        });
                             //-------Login----------//

                  Button btnlogin = (Button) findViewById(R.id.btnLogin);

                 btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   edtemailL = (EditText) findViewById(R.id.edtemail);
                   edtsenhaL = (EditText) findViewById(R.id.edtsenha);


                if(user.validarUsuario(edtemailL.getText().toString(), edtsenhaL.getText().toString()) == equals(null)){
                    Toast.makeText(LoginActivity.this, "Login ou Senha incorretos", Toast.LENGTH_LONG).show();
                }else{
                    enviaParametro();
                    Toast.makeText(LoginActivity.this, "Bem-Vindo! "+edtemailL.getText().toString(), Toast.LENGTH_LONG).show();

                }
     }
        });

        //CIDADE DO USUARIO QUE LOGAR
        spinner = (Spinner) findViewById(R.id.spinercidadeusuario);
        spinner.setOnItemSelectedListener(this);
        DAO dao = new DAO();
        List<cidades> sipnercidades = dao.listarcidades();
        ArrayAdapter<cidades> adaptercidades = new ArrayAdapter<cidades>(this, android.R.layout.simple_list_item_1, sipnercidades);
        adaptercidades.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adaptercidades);

        spinerselec = (TextView) findViewById(R.id.cidadeselecionada);
        spinerselec.setVisibility(View.INVISIBLE);

    }


    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {
        spinner.setSelection(position);
        String escolha = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Você esta em: " + escolha, Toast.LENGTH_LONG).show();
        spinerselec.setText(escolha);


    }
     @Override
     public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    //INTENT PARA PASSAGEM DE PARAMETRSO DA CIDADE





    //INTENT PARA PASSAGEM DE PARAMETROS
    public void enviaParametro(){
        Intent intent = new Intent(this, LitagemListasActivity.class);
        Bundle params = new Bundle();
        params.putString("cidades", spinerselec.getText().toString());
        params.putString("edtemailL", edtemailL.getText().toString());
        intent.putExtras(params);
        startActivity(intent);
     }








}
