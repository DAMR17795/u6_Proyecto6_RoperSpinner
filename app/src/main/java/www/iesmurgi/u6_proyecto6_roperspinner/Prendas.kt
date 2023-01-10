package www.iesmurgi.u6_proyecto6_roperspinner

import android.content.res.Resources


data class Prendas(val nombre: String, val numPrenda: String, val descripcion:String, val imagen:Int, val precio:Double) {
    companion object {
        val prendasSource = listOf(
            Prendas("Gorra", "", "Gorra marron", imagen = R.drawable.gorra, 9.99)
            ,Prendas("Gorra", "1", "Gorra naranja", imagen = R.drawable.gorra1, 8.99)
            ,Prendas("Gorra", "2", "Gorra roja", imagen = R.drawable.gorra2, 7.99)
            ,Prendas("Camiseta", "", "Camiseta amarilla", imagen = R.drawable.camiseta, 12.99)
            ,Prendas("Camiseta", "2", "Camiseta verde", imagen = R.drawable.camiseta2, 11.99)
            ,Prendas("Camiseta", "3", "Camiseta azul", imagen = R.drawable.camiseta3, 14.99)
            ,Prendas("Camiseta", "4", "Camiseta rosa", imagen = R.drawable.camiseta4, 10.55)
            ,Prendas("Sudadera", "", "Sudadera comoda roja", imagen = R.drawable.sudadera, 21.00)
            ,Prendas("Sudadera", "1", "Sudadera comoda blanca", imagen = R.drawable.sudadera1, 20.00)
            ,Prendas("Sudadera", "2", "Sudadera comoda verde", imagen = R.drawable.sudadera2, 22.00)
            ,Prendas("Sudadera", "3", "Sudadera comoda azul", imagen = R.drawable.sudadera3, 23.00)
            ,Prendas("Pantalon", "", "Pantalones comodos grises", imagen = R.drawable.pantalon, 20.00)
            ,Prendas("Pantalon", "1", "Pantalones comodos amarillos", imagen = R.drawable.pantalon1, 21.00)
            ,Prendas("Pantalon", "2", "Pantalones comodos azules", imagen = R.drawable.pantalon2, 15.00)
            ,Prendas("Calcetin", "","Calcetines rojos comodos", imagen = R.drawable.calcetin, 4.00)
            ,Prendas("Calcetin", "1", "Calcetines grises comodos", imagen = R.drawable.calcetin1, 7.00)
            ,Prendas("Calcetin", "2", "Calcetines grises comodos", imagen = R.drawable.calcetin2, 6.50)
            ,Prendas("Calcetin", "3","Calcetines azules comodos", imagen = R.drawable.calcetin3, 5.99)
            ,Prendas("Calcetin", "4", "Calcetines multicolor comodos", imagen = R.drawable.calcetin4, 3.00)
            ,Prendas("Vestido", "", "Vestido verde comodo", imagen = R.drawable.vestido, 25.00)
            ,Prendas("Vestido", "1", "Vestido rojo comodo", imagen = R.drawable.vestido1, 26.00)
            ,Prendas("Vestido", "2", "Vestido precioso", imagen = R.drawable.vestido2, 30.00)
            ,Prendas("Legging", "","Legging azul", imagen = R.drawable.legging, 19.00)
            ,Prendas("Legging", "1", "Legging negro", imagen = R.drawable.legging1, 17.00)

        )


    }
    override fun toString(): String {
        return nombre
    }

}
