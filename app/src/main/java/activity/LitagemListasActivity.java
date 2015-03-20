package activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.listmarketbeta.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

import classes.classes.DAO.DAO;
import classes.classes.DAO.listascompras;

/**
 * Created by Bruno - PC on 17/03/2015.
 */
public class LitagemListasActivity extends Activity{

 public TextView emailView;
 public TextView txtcidade;

    @Override
                 protected void onResume() {
                 super.onResume();

            setContentView(R.layout.listagemlistascompras);


        getActionBar().setLogo(R.drawable.ic_launcher);
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayUseLogoEnabled(true);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);


            //INTENT PARA PEGAR O PARAMETRO
            Intent intent = getIntent();

            if(intent != null){
                Bundle params = intent.getExtras();
                if(params != null){
                    String edtemailL = params.getString("edtemailL");
                    String cidades = params.getString("cidades");

                    txtcidade = (TextView) findViewById(R.id.txtcidade);
                    txtcidade.setText(cidades);

                    emailView = (TextView) findViewById(R.id.emailtext);
                    emailView.setText(edtemailL);


                   DAO dao = new DAO();
                   ListView listView = (ListView) findViewById(R.id.listViewlistagemlistas);
                   ArrayList<listascompras> lista = dao.buscarListasUsuario(emailView.getText().toString());
                   ArrayAdapter<listascompras> adpterLista = new ArrayAdapter<listascompras>(this, android.R.layout.simple_list_item_1, lista);
                   listView.setAdapter(adpterLista);
                   Log.d("Teste", lista.toString());
                }



            }


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void enviaParametro1(){
        Intent intent2 = new Intent(this, FormularioListasCompras.class);
        Bundle params = new Bundle();
        params.putString("edtemailusuario", emailView.getText().toString());
        intent2.putExtras(params);
        startActivity(intent2);
  }

    public void enviaParametroCadProduto(){
        Intent intent = new Intent(this, FormularioProdutos.class);
        Bundle params = new Bundle();
        params.putString("edtemailusuario", emailView.getText().toString());
        params.putString("edtcidadeusuario", txtcidade.getText().toString());
        intent.putExtras(params);
        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemClicado = item.getItemId();

        switch (itemClicado){
            case R.id.novalista:
                enviaParametro1();
              //  Intent IrCadastroListas = new Intent(this, FormularioListasCompras.class);
              // startActivity(IrCadastroListas);
                   break;

            case R.id.novoprod:
                enviaParametroCadProduto();
               // Intent IrCadastroProd = new Intent(this, FormularioProdutos.class);
                //startActivity(IrCadastroProd);
                break;


        }

        return super.onOptionsItemSelected(item);
    }


}




