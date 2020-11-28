package com.example.proyectofinalandroid.ui.categorias;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.proyectofinalandroid.R;
import com.example.proyectofinalandroid.Dtos.Categorias;
import com.example.proyectofinalandroid.Dtos.VolleySingleton;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConsultarCategorias extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //private OnFragmentInteractionListener mListener;

    //Instancia de los campos y botones
    EditText idCategoria;
    TextView tvNombre, tvEstado;
    Button btnConsultarCat;
    ProgressDialog progreso;

    //RequestQueue requestQueue;
    JsonObjectRequest jsonObjectRequest;

    public ConsultarCategorias() {
        // Required empty public constructor
    }

    public static ConsultarCategorias newInstance(String param1, String param2) {
        ConsultarCategorias fragment = new ConsultarCategorias();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_consultar_categorias, container, false);

        idCategoria = (EditText) vista.findViewById(R.id.idCategoria);
        tvNombre = (TextView) vista.findViewById(R.id.tvNombre);
        tvEstado = (TextView) vista.findViewById(R.id.tvEstado);
        btnConsultarCat = (Button) vista.findViewById(R.id.btnConsultarCat);

        //requestQueue = Volley.newRequestQueue(getContext());

        btnConsultarCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cargarWebService();
            }
        });

        return vista;
    }

    private void cargarWebService(){
        progreso = new ProgressDialog(getContext());
        progreso.setMessage("Consultando");
        progreso.show();

        String url = "http://192.168.42.230/service2020/buscar_categoria1.php?id_categoria="
                +idCategoria.getText().toString();
        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url, (String) null,this,this);
        //requestQueue.add(jsonObjectRequest);
        VolleySingleton.getIntanciaVolley(getContext()).addToRequestQueue(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        progreso.hide();
        Toast.makeText(getContext(),"No se puede consultar "+error.toString(),
                Toast.LENGTH_SHORT).show();
        Log.i("Error",error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        progreso.hide();
        // Toast.makeText(getContext(),"Mensaje "+response,Toast.LENGTH_SHORT).show();

        Categorias cat = new Categorias();

        JSONArray json = response.optJSONArray("categorias");
        JSONObject jsonObject = null;

        try {
            jsonObject=json.getJSONObject(0);
            cat.setNom_categoria(jsonObject.optString("nom_categoria"));
            cat.setEstado_categoria(jsonObject.optInt("estado_categoria"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        tvNombre.setText("Nombre: "+cat.getNom_categoria());
        tvEstado.setText("Estado categoria: "+cat.getEstado_categoria());

    }
}
