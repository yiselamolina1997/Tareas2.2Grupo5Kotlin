package com.example.tarea2p2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.tarea2p2.Config.RestApiMethods
import org.json.JSONException

class ActivityPlaceHolder : AppCompatActivity() {
    private val requestQueue: RequestQueue? = null

    private var listView: ListView? = null
    private var adapter: ArrayAdapter<String>? = null
    private var Arreglo: MutableList<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_holder)

        setContentView(R.layout.activity_place_holder)

        listView = findViewById(R.id.listplace)
        Arreglo = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            Arreglo as ArrayList<String>
        )
        with(listView) { this?.setAdapter(adapter) }

        GetData()
    }

    private fun GetData() {
        val requestQueue = Volley.newRequestQueue(this)


        val request = JsonArrayRequest(
            Request.Method.GET, RestApiMethods.Endpointplace, null,
            { response ->
                // Procesar la respuesta JSON
                try {
                    for (i in 0 until response.length()) {
                        val post = response.getJSONObject(i)

                        val id = post.getString("id")
                        val title = post.getString("title")
                        val body = post.getString("body")
                        val dato = "ID:$id\nTitulo: $title\nCuerpo: $body\n"

                        // Arreglo.add(id);
                        // Arreglo.add(title);
                        Arreglo!!.add(dato)
                    }
                    adapter!!.notifyDataSetChanged() // Notificar al adaptador que los datos han cambiado
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }, { error -> // Manejar el error de la solicitud
                error.printStackTrace()
            })

        // Agregar la solicitud a la cola de solicitudes
        requestQueue.add(request)
    } /*private void SendData()
    {
        requestQueue = Volley.newRequestQueue(this);

        StringRequest request = new StringRequest(Request.Method.GET,
                RestApiMethods.Endpointplace, new Response.Listener<String>() {
            @Override
            public void onResponse(String response)
            {
                String mensaje = response.toString();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(request);
    }*/
}