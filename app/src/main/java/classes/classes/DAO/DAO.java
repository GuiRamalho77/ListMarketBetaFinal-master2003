package classes.classes.DAO;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * Created by bruno on 11/03/15.
 */
public class DAO implements Serializable {

    private static final String URL = "http://10.0.2.2:8080/WebServiceListMarket/services/DAO?wsdl";
    private static final String NAMESPACE = "http://wslistmarket.com.br";


    private static final String INSERIRPPRODUTO = "inserirProduto";
    private static final String INSERIRLISTAS = "inserirListasCompras";
    private static final String BUSCARCIDADES = "listarcidades";
    private static final String VALIDAR = "validar";
    private static final String BURCARLISTAS = "buscarListas";
    private static final String BURCARLPRODCIDADE = "buscarProdCidade";


    public boolean inserirListas(listascompras listascompras) {

        SoapObject inserirListasCompras = new SoapObject(NAMESPACE, INSERIRLISTAS);

        SoapObject user = new SoapObject(NAMESPACE, "listascompras");
         user.addProperty("idlista", listascompras.getIdlista());
         user.addProperty("nomelista", listascompras.getNomelista());
        user.addProperty("emailista", listascompras.getEmailista());



        inserirListasCompras.addSoapObject(user);



        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.setOutputSoapObject(inserirListasCompras);
        envelope.setOutputSoapObject(inserirListasCompras);

        envelope.implicitTypes = true;


        HttpTransportSE http = new HttpTransportSE(URL);

        try {
            http.call("urn:" + INSERIRLISTAS, envelope);
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            return Boolean.parseBoolean(response.toString());

        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }



    public ArrayList<cidades> listarcidades() {
        ArrayList<cidades> lista = new ArrayList<cidades>();

        SoapObject buscarCidades = new SoapObject(NAMESPACE, BUSCARCIDADES);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.setOutputSoapObject(buscarCidades);
        envelope.implicitTypes = true;

        HttpTransportSE http = new HttpTransportSE(URL);

        try {
            http.call("urn:" + BUSCARCIDADES, envelope);

            Vector<SoapObject> resposta = (Vector<SoapObject>) envelope.getResponse();

            for (SoapObject soapObject : resposta) {
                cidades cidades = new cidades();
                cidades.setIdcidade(Integer.parseInt(soapObject.getProperty("idcidade").toString()));
                cidades.setNomecidade(soapObject.getProperty("nomecidade").toString());

                lista.add(cidades);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }


        return lista;

    }

    //listarcidade



    public boolean validarUsuario(String email, String senha) {


        SoapObject validar = new SoapObject(NAMESPACE, VALIDAR);
        validar.addProperty("email", email);
        validar.addProperty("senha", senha);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(validar);

        try {

            HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
            androidHttpTransport.call(VALIDAR, envelope);
            SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
            return Boolean.parseBoolean(result.toString());
        } catch (Exception e) {
            e.getMessage();
            return false;

        }

    }








    public ArrayList<listascompras> buscarListasUsuario(String email) {
        ArrayList<listascompras> lista = new ArrayList<listascompras>();

        SoapObject buscarListas = new SoapObject(NAMESPACE, BURCARLISTAS);
        buscarListas.addProperty("email", email);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(buscarListas);

        try {
            HttpTransportSE http = new HttpTransportSE(URL);
            http.call("urn:" + BURCARLISTAS, envelope);
           // SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
          //  result.toString();
            Vector<SoapObject> resposta = (Vector<SoapObject>) envelope.getResponse();

            for (SoapObject soapObject : resposta) {
                listascompras listasc = new listascompras();
                listasc.setNomelista(soapObject.getProperty("nomelista").toString());
               // listasc.usuarios.setEmail(soapObject.getProperty("email").toString());

                lista.add(listasc);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }


        return lista;

    }





    public ArrayList<produtos> buscarProdPorCidade(String nomecidade) {
        ArrayList<produtos> lista = new ArrayList<produtos>();

        SoapObject buscarListas = new SoapObject(NAMESPACE, BURCARLPRODCIDADE);
        buscarListas.addProperty("nomecidade", nomecidade);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setOutputSoapObject(buscarListas);

        try {
            HttpTransportSE http = new HttpTransportSE(URL);
            http.call("urn:" + BURCARLPRODCIDADE, envelope);
            // SoapPrimitive result = (SoapPrimitive) envelope.getResponse();
            //  result.toString();
            Vector<SoapObject> resposta = (Vector<SoapObject>) envelope.getResponse();

            for (SoapObject soapObject : resposta) {

                produtos prod = new produtos();
                prod.setDescricao(soapObject.getProperty("descricao").toString());
                prod.setPreco(Double.parseDouble(soapObject.getProperty("preco").toString()));
                prod.setMercado(soapObject.getProperty("mercado").toString());
                lista.add(prod);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }


        return lista;

    }






}










