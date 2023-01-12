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

        for (i in Prendas.prendasSource) {
            if(i.cantidad > 0 && !Prendas.prendasCogidas.contains(Prendas.prendasSource.get(contador))) {
                var prenda: Prendas=Prendas(i.id, i.nombre, i.numPrenda,i.descripcion, i.imagen, i.precio,i.cantidad, i.talla)
                Prendas.prendasCogidas.add(prenda)
                prendasAniadidas.add(prenda)
                contador++
            }
            for (j in Prendas.prendasCogidas) {
                if (i.id == j.id && i.cantidad != j.cantidad) {
                    prendasActualizadas.add(Prendas.prendasCogidas.get(contador2))
                    contador2++
                }
                contador2++
            }
            contador2=0
        }

        contador=0
        contador2=0
        if (Prendas.prendasCogidas.size >0) {
            if (prendasActualizadas.size >0) {
                for (a in Prendas.prendasCogidas) {
                    if (a.id == prendasActualizadas.get(contador2).id && a.cantidad != prendasActualizadas.get(contador2).cantidad) {
                        a.cantidad = prendasActualizadas.get(contador2).cantidad

                        //Prendas.prendasCogidas.removeAt(contador2)
                        //Prendas.prendasCogidas.add(contador2, prendasActualizadas.get(contador))
                        contador++
                        contador2++
                    }
                    contador2++
                }
            }

        }

        /*println("Prendas Cogidas: " + Prendas.prendasCogidas)
        println("Prendas Aniadidas: " + prendasAniadidas)
        println("Prendas Actualizadas: " + prendasActualizadas)
        for (i in prendasAniadidas) {
            if (prendasActualizadas.contains(prendasAniadidas.get(contador))) {
                prendasAniadidas.removeAt(contador)
                contador++
            }
        }
        contador=0
        for (i in prendasActualizadas) {
            if (prendasAniadidas.contains(prendasActualizadas.get(contador))) {
                //la que cambie
                prendasActualizadas.removeAt(contador)
                contador++
            }
        }*/
        println("DESPUÉS DE BUCLES")
        println("Prendas Aniadidas: " + prendasAniadidas)
        println("Prendas Actualizadas: " + prendasActualizadas)

        //Prendas.prendasCogidas.clear()
        println("Prendas Cogidas: " + Prendas.prendasCogidas)
        //Prendas.prendasCogidas.addAll(prendasAniadidas)
        println("Prendas Cogidas: " + Prendas.prendasCogidas)
        //Prendas.prendasCogidas.addAll(prendasActualizadas)

        /*CarritoAdapter(this, Prendas.prendasCogidas).also {
                adaptador -> lista.setAdapter(adaptador)}*/

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}