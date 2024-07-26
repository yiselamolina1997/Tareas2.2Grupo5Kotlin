package com.example.tarea2p2

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.tarea2p2.Config.RestApiMethods
import org.json.JSONException

class ActivityPlaceHolderBuscar : AppCompatActivity() {
    private val requestQueue: RequestQueue? = null

    private var listView: ListView? = null
    private var adapter: ArrayAdapter<String>? = null
    private var Arreglo: List<String>? = null

    private var editText: EditText? = null
    private var button: Button? = null
    private var textView2: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place_holder_buscar)

        listView = findViewById(R.id.listplace)
        Arreglo = ArrayList()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,
            Arreglo as ArrayList<String>
        )
        with(listView) { this?.setAdapter(adapter) }
        editText = findViewById<View>(R.id.editTextText) as EditText
        button = findViewById<View>(R.id.button) as Button
        textView2 = findViewById<View>(R.id.textView2) as TextView

        button!!.setOnClickListener {
            if (editText!!.text.toString().length == 0) {
                Toast.makeText(applicationContext, "ingrese un dato", Toast.LENGTH_LONG).show()
            } else {
                GetData()
            }
        }
    }

    private fun GetData() {
        val requestQueue = Volley.newRequestQueue(this)
        val n = editText!!.text.toString()
        val d = n.toInt()
        //Toast.makeText(getApplicationContext(), RestApiMethods.Endpointplace2+n, Toast.LENGTH_LONG).show();
        val url = RestApiMethods.Endpointplace2

        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                // Procesar la respuesta JSON
                try {
                    val post = response.getJSONObject(d - 1)

                    val id = post.getString("id")
                    val title = post.getString("title")
                    val body = post.getString("body")
                    val dato = "ID: $id\n\n Titulo:\n$title \n\n Cuerpo:\n$body"

                    // Arreglo.add(id);
                    // Arreglo.add(title);
                    textView2!!.text = dato
                    //Arreglo.add(dato);
                    //adapter.notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }, { error -> // Manejar el error de la solicitud
                error.printStackTrace()
            })

        // Agregar la solicitud a la cola de solicitudes
        requestQueue.add(request)
    }
}