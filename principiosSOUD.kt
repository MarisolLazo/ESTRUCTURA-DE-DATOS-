//Principio Solid
/*
1.Single Responsability (SRP)-Principio de responsabilidad unica
 */

 //Ejemplo de no uso de SRP
 /*class factura(val items: List<Item>){
    fun calcularTotal(): Double{
        return items.sumOf (it.precio)
    }

    fun generarReporte():String{
        return "Reporte de la factura"
    }
 }
  */

  // 
  class factura(val items: List<Item>){
    fun calcularTotal(): Double{
        return items.sumOf (it.precio)
    }
  }
 
  class ReporteFactura {
    fun generar(factura: Factura): String{
        return "Reporte de la factura"
    }
  }

  /*
2. Open/Clodes Principle (OCP)-Principio Abierto/Cerrado
 */

 open class Empleado(val nombre: string, val horasTrabajadas: int, val precioHora: double){
    open fun calcularSalario():Double{
        return horasTrabajadas*precioHora
    }
 }

 class EmpleadoConBono (nombre: String, horasTrabajadas: Int, precioHora: Double, val bono: Double): Empleado(nombre,horasTrabajadas,precioHora){
    override fun calcularSalario(): Double{
        return super.calcularSalario + bono
    }
 }

 /*
3. Listow Substitution Principle (LSP)-Principio de sustitucion  Liskow
 */

 fun fun main(args: Array<String>) {
    fun imprimirSalario(empleado: Empleado){
        println("El salario de ${empleado.nombre} es de ${empleado.calcularSalario()}")
    }
    val empleado = Empleado("Daniel", 40, 12.0)
    val EmpleadoConBono = EmpleadoConBono("Fernanda", 40, 12.0, 70.0)

    imprimirSalario(empleado)
    imprimirSalario(EmpleadoConBono)

 }

 /*
 4. Interface Segregation Principle (ISP) - Principio de Segregacion de Interfaces
  */

iterface Trabajador{
    fun trabajar()
}

interface Asistente{
    fun asistir()
}

interface Reportero{
    fun generarReporte()
}

class Programador: Trabajador {Foverride fun trabajar(){
    println("El programador esta programando") 
  }
}

class Albanil: Trabajador{
    override fun trabajar(){
        //Agregar de trabajo
    }
}

/*
5.Dependency Inversion Principle (DIP)- Principio de Inversion de Dependencias
 */

 inteface Notificaciones{
    fun enviarNotificacion(mensaje: String)
 }

 class ServicioEmail:Notificaciones{
    override fun enviarNotificacion(mensaje: String){
        println{"Enviando Email: $mensaje"}
    }
 }

 class Notificacion(val servicio:Notificaciones){
    fun enviarUnaNotificacion(){
        \servicio.enviarNotificacion("Notificacion importante")
    }
 }