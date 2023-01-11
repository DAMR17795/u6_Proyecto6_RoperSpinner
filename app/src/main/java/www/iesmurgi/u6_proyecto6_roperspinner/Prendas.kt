package www.iesmurgi.u6_proyecto6_roperspinner

import android.content.res.Resources


data class Prendas(val id: Int, val nombre: String, val numPrenda: String, val descripcion:String, val imagen:Int, val precio:Double, var cantidad:Int) {
    companion object {
        val prendasSource = mutableListOf(
            Prendas(0,"Gorra", "", "Gorra marron", imagen = R.drawable.gorra, 9.99 , 0)
            ,Prendas(1,"Gorra", "1", "Gorra naranja", imagen = R.drawable.gorra1, 8.99, 0)
            ,Prendas(2,"Gorra", "2", "Gorra roja", imagen = R.drawable.gorra2, 7.99, 0)
            ,Prendas(3, "Camiseta", "", "Camiseta amarilla", imagen = R.drawable.camiseta, 12.99, 0)
            ,Prendas(4,"Camiseta", "2", "Camiseta verde", imagen = R.drawable.camiseta2, 11.99,0)
            ,Prendas(5,"Camiseta", "3", "Camiseta azul", imagen = R.drawable.camiseta3, 14.99, 0)
            ,Prendas(6,"Camiseta", "4", "Camiseta rosa", imagen = R.drawable.camiseta4, 10.55, 0)
            ,Prendas(7,"Sudadera", "", "Sudadera comoda roja", imagen = R.drawable.sudadera, 21.00, 0)
            ,Prendas(8,"Sudadera", "1", "Sudadera comoda blanca", imagen = R.drawable.sudadera1, 20.00,0)
            ,Prendas(9,"Sudadera", "2", "Sudadera comoda verde", imagen = R.drawable.sudadera2, 22.00, 0)
            ,Prendas(10,"Sudadera", "3", "Sudadera comoda azul", imagen = R.drawable.sudadera3, 23.00, 0)
            ,Prendas(11,"Pantalon", "", "Pantalones comodos grises", imagen = R.drawable.pantalon, 20.00, 0)
            ,Prendas(12,"Pantalon", "1", "Pantalones comodos amarillos", imagen = R.drawable.pantalon1, 21.00, 0)
            ,Prendas(13,"Pantalon", "2", "Pantalones comodos azules", imagen = R.drawable.pantalon2, 15.00, 0)
            ,Prendas(14,"Calcetin", "","Calcetines rojos comodos", imagen = R.drawable.calcetin, 4.00, 0)
            ,Prendas(15,"Calcetin", "1", "Calcetines grises comodos", imagen = R.drawable.calcetin1, 7.00, 0)
            ,Prendas(16,"Calcetin", "2", "Calcetines grises comodos", imagen = R.drawable.calcetin2, 6.50, 0)
            ,Prendas(17,"Calcetin", "3","Calcetines azules comodos", imagen = R.drawable.calcetin3, 5.99, 0)
            ,Prendas(18,"Calcetin", "4", "Calcetines multicolor comodos", imagen = R.drawable.calcetin4, 3.00, 0)
            ,Prendas(19,"Vestido", "", "Vestido verde comodo", imagen = R.drawable.vestido, 25.00, 0)
            ,Prendas(20,"Vestido", "1", "Vestido rojo comodo", imagen = R.drawable.vestido1, 26.00, 0)
            ,Prendas(21,"Vestido", "2", "Vestido precioso", imagen = R.drawable.vestido2, 30.00, 0)
            ,Prendas(22,"Legging", "","Legging azul", imagen = R.drawable.legging, 19.00, 0)
            ,Prendas(23,"Legging", "1", "Legging negro", imagen = R.drawable.legging1, 17.00, 0)

        )

        val prendasCogidas= mutableListOf<Prendas>()

    }
    override fun toString(): String {
        return nombre
    }

}
