package www.iesmurgi.u6_proyecto6_roperspinner


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import www.iesmurgi.u6_proyecto6_roperspinner.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var miLista: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Asigno variable miLista
        miLista = binding.miLista

        //PrendasAdapter para asignar al listview
        PrendasAdapter(this, Prendas.prendasSource).also {
                adaptador -> miLista.setAdapter(adaptador)}

    }

    //Options menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menucarrito, menu)
        return true
    }

    //Options item
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Op -> {
                var variable=0
                for (i in Prendas.prendasCogidas) {
                    if (i.cantidad != 0) {
                        variable++
                    }
                }
                if (variable != 0) {
                    val enviar = Intent (this, Carrito::class.java)
                    startActivity(enviar)
                } else {
                    Toast.makeText(this, getString(R.string.carrito), Toast.LENGTH_SHORT).show()
                }
                true
            }
            R.id.MnOp1 -> {
                Toast.makeText(this, getString(R.string.creacion), Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }



}