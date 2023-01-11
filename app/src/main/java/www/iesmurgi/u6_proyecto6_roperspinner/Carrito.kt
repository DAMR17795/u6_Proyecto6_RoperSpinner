package www.iesmurgi.u6_proyecto6_roperspinner

import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import www.iesmurgi.u6_proyecto6_roperspinner.databinding.CarritoBinding

class Carrito : AppCompatActivity() {
    private lateinit var binding:CarritoBinding
    private lateinit var lista:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CarritoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lista = binding.miListaCarrito
        cargar()


    }

    fun cargar() {
        for (i in Prendas.prendasSource) {
            if(i.cantidad >0) {
                var prenda: Prendas=Prendas(i.id, i.nombre, i.numPrenda,i.descripcion, i.imagen, i.precio,i.cantidad)
                Prendas.prendasCogidas.add(prenda)
            }
        }
        CarritoAdapter(this, Prendas.prendasCogidas).also {
                adaptador -> lista.setAdapter(adaptador)}
    }

    /*override fun onBackPressed() {
        super.onBackPressed()
        println(Prendas.prendasCogidas.get(0))
        Prendas.prendasCogidas.clear()
    }*/
}