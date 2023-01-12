package www.iesmurgi.u6_proyecto6_roperspinner

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class CarritoAdapter (context: Context, prendas:List<Prendas>):ArrayAdapter<Prendas>(context, 0, prendas) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val vista = convertView?: LayoutInflater.from(context).inflate(R.layout.esqueleto_carrito, parent, false)
        getItem(position)?.let { armario ->
            vista.findViewById<TextView>(R.id.nombrePrenda).apply {
                text= armario.nombre + armario.numPrenda}

            vista.findViewById<TextView>(R.id.precioPrenda).apply {
                text= context.resources.getString(R.string.precio) + " " + armario.precio.toString() + " €"
            }

            vista.findViewById<TextView>(R.id.lblCantidad).apply {
                text=armario.cantidad.toString()
            }

            vista.findViewById<ImageView>(R.id.imagenPrenda).apply {
                setImageResource(armario.imagen)
            }

            var btCerrar:Button = vista.findViewById<Button>(R.id.btEliminar)
            btCerrar.setOnClickListener {
                Prendas.prendasSource.filter { it.id == armario.id}.forEach { it.cantidad = 0}
                Prendas.prendasCogidas.removeAt(position)
                //No Borrar importante
                //Prendas.prendasCogidas.clear()
                if (Prendas.prendasCogidas.size > 0) {
                    Prendas.prendasCogidas.clear()
                    val enviar = Intent (context, Carrito::class.java)
                    context.startActivity(enviar)
                    (context as Activity).finish()
                } else {
                    val enviar = Intent (context, MainActivity::class.java)
                    context.startActivity(enviar)
                    (context as Activity).finish()
                }

            }

            var btMas:Button = vista.findViewById<Button>(R.id.btMas)
            var btMenos:Button = vista.findViewById<Button>(R.id.btMenos)
            var precio =0.0
            var precioMostrar = armario.precio * vista.findViewById<TextView>(R.id.lblCantidad).getText().toString().toInt()
            var contador= vista.findViewById<TextView>(R.id.lblCantidad).getText().toString().toInt()
            btMas.setOnClickListener{
                precio=0.0
                for (i in Prendas.prendasCogidas) {
                    precio += i.cantidad * i.precio
                    println("Precio Final: " + precio)
                }
                if (vista.findViewById<TextView>(R.id.lblCantidad) != null) {
                    contador +=1
                    vista.findViewById<TextView>(R.id.lblCantidad).setText(contador.toString())
                    var precio = armario.precio * contador
                    vista.findViewById<TextView>(R.id.precioPrenda).setText(context.resources.getString(R.string.precio) + " " + precio.toFloat().toString() + " €")
                    Prendas.prendasSource.filter { it.id == armario.id.toString().toInt()}.forEach { it.cantidad = contador}
                    val enviar = Intent (context, Carrito::class.java)
                    context.startActivity(enviar)
                    //Importante
                    Prendas.prendasCogidas.clear()
                    (context as Activity).finish()
                }


                println("Resultado: " + precio)
                /*vista.findViewById<TextView>(R.id.precioFinal).apply {
                    text= precio.toString() + ""
                }*/
            }

            btMenos.setOnClickListener{
                precio=0.0
                for (i in Prendas.prendasCogidas) {
                    precio += i.cantidad * i.precio
                    println("Precio Final: " + precio)
                }
                if (vista.findViewById<TextView>(R.id.lblCantidad) != null) {
                    if (contador > 1) {
                        contador -=1
                        vista.findViewById<TextView>(R.id.lblCantidad).setText(contador.toString())
                        var precio = armario.precio * contador
                        vista.findViewById<TextView>(R.id.precioPrenda).setText(context.resources.getString(R.string.precio) + " " + precio.toFloat().toString() + " €")
                        Prendas.prendasSource.filter { it.id == armario.id.toString().toInt()}.forEach { it.cantidad = contador}
                        val enviar = Intent (context, Carrito::class.java)
                        context.startActivity(enviar)
                        //Importante
                        Prendas.prendasCogidas.clear()
                        (context as Activity).finish()
                    }
                }
                println("Resultado: " + precio)
                /*vista.findViewById<TextView>(R.id.precioFinal).apply {
                    text= precio.toString() + ""
                }*/
            }

            vista.findViewById<TextView>(R.id.precioPrenda).setText(context.resources.getString(R.string.precio) + " " + precioMostrar.toFloat().toString() + " €")

        }
        return vista
    }

}

