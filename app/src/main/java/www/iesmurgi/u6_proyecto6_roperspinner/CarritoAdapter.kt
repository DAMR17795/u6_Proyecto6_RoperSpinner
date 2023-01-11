package www.iesmurgi.u6_proyecto6_roperspinner

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get


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

        }

        return vista
    }


}