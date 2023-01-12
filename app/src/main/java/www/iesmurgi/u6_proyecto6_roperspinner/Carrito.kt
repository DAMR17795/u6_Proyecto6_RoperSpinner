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
        mostrarArrray()
        CarritoAdapter(this, Prendas.prendasCogidas).also {
                adaptador -> lista.setAdapter(adaptador)}

    }

    fun cargar() {
        //Bucle for y añadimos a la lista vacia
        //las prendas que tengan cantidad mayor a 0
        var contador = 0
        var contador2 = 0

        var prendasActualizadas= mutableListOf<Prendas>()
        var prendasAniadidas = mutableListOf<Prendas>()
        var prendasFinales = mutableListOf<Prendas>()


        for (i in Prendas.prendasSource) {
            if(i.cantidad > 0 && !Prendas.prendasCogidas.contains(Prendas.prendasSource.get(contador))) {
                var prenda: Prendas=Prendas(i.id, i.nombre, i.numPrenda,i.descripcion, i.imagen, i.precio,i.cantidad, i.talla)
                Prendas.prendasCogidas.add(prenda)
                prendasAniadidas.add(prenda)
                contador++
            }
            for (j in Prendas.prendasCogidas) {
                if (i.id == j.id && i.cantidad != j.cantidad) {
                    //prendasActualizadas.add(Prendas.prendasCogidas.get(contador2))
                    prendasActualizadas.add(i)
                    contador2++
                }
                contador2++
            }
            contador2=0
        }

        contador=0

        for (i in prendasAniadidas) {
            if (prendasActualizadas.contains(prendasAniadidas.get(contador))) {
                prendasAniadidas.removeAt(contador)
                contador++
            }
        }

        println("************************FIN******************************")
        for (i in Prendas.prendasCogidas) {
            println("Prendas dentro de array: " + i.descripcion)
            println("Cantidad: " + i.cantidad)
        }
        Prendas.prendasCogidas.clear()
        Prendas.prendasCogidas.addAll(prendasAniadidas)

        //prendasActualizadas.clear()
        //prendasAniadidas.clear()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        Prendas.prendasCogidas.clear()
        finish()
    }

    fun mostrarArrray() {
        for (i in Prendas.prendasCogidas) {
            println("^^^^^^^^^^^^^METODO A FUERA^^^^^^^^^^^^^^^^^^")
            println("Prendas dentro de array: " + i.descripcion)
            println("Cantidad: " + i.cantidad)
        }
    }
}