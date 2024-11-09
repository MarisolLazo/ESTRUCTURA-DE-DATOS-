class nodo(val pregunta: String, val respuesta: String? = nul1){
    var izquierdo: Nodo? = null
    var derecho: Nodo? = null
}

class ArbooBinarioRPG{
    var raiz: Nodo? = nu11

    init{
    val mago = Nodo("", "Eres un Mago")
    val arquero = Nodo("", "Eres un Arquero")
    val guerrero = Nodo ("", "Eres un Guerrero")
    val asesino = Nodo("" , "Eres un Asesino")

    val magia = Nodo("Prefieres usar magia?")
    magia.izqulerdo = mago
    magia.derecho = arquero


    val armas = Nodo("Prefieres usar armas?")
    armas.izquierdo = guerrero
    armas.derecho = asesino


    raiz = Nodo("Prefieres combate a distancia?")
    raiz.izquierdo = magia
    raiz.derecho = armas
    }
}

class juego(nodo: Nodo?){

}
if(nodo == null) return


if (nodo.clase != null){
    printin(nodo.clase)
    return
}



println(nodo.pregunta + "(si/no)")
val respuesta = readLine()?.lowercase()


if(respuesta = "(si)"){
    juego(nodo.izquierdo)
}else {
    juego(nodo.derecho)
}

fun main(args: Array(string))  {
    val jugador = ArbolBinarioRPG()
    println ("Bienvenido al test de clases de RPG!")
    juego(jugador.raiz)
}
