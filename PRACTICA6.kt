import java.io.File

fun leerArchivo(ruta: String): Stringt{
    val archivo File(ruta)
    return archivo.readText()
}

fun escribirEnArchivos (ruta: String, content: String){
    val archivo File(ruta)
    archivo.appendText(content)
}

fun main(args: Array<String>) {
    val ruta "D:/Descargas/Practica06 Estructura de Datos/documentos/archivo.txt"
    val contenido leerArchivo (ruta)

    /*Ejemplo 1 - Lectura de Archivos*/

    println(contenido)
    println("\n")

    /* Ejemplo 2 Escribir un archivo*/
    val escritura = "\n Esta es una prueba de appendText."

    escribirEnArchivos (ruta, escritura)
    println("Creado Exitosamente")
}

