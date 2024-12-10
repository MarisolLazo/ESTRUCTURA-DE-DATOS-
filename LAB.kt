import kotlin.system.measureTimeMillis

fun main() {
    while (true) {
        println("\nSeleccione una opcion:")
        println("1. Ordenar una lista usando Bubble Sort")
        println("2. Ordenar una lista usando Quick Sort")
        println("3. Calcular el factorial de un numero")
        println("4. Resolver las Torres de Hanoi")
        println("5. Salir")
        
        print("Opcion: ")
        val opcion = readLine()?.toIntOrNull()
        
        when (opcion) {
            1 -> bubbleSortOption()
            2 -> quickSortOption()
            3 -> factorialOption()
            4 -> hanoiOption()
            5 -> {
                println("Saliendo del programa...")
                break
            }
            else -> println("Opcion no valida, intente de nuevo.")
        }
    }
}

//////////////////////////////////////////////////////////////
// Opción 1: Bubble Sort
//////////////////////////////////////////////////////////////

fun bubbleSort(arr: IntArray) { 
    val n = arr.size
    var swapped: Boolean  
    for (i in 0 until n - 1) {
        swapped = false
        for (j in 0 until n - 1 - i) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                swapped = true
            }
        }
        if (!swapped) break
    }
}

fun bubbleSortOption() {
    print("\nIngrese una lista de numeros separados por comas: ")
    val input = readLine()
    val list = input?.split(",")?.mapNotNull { it.trim().toIntOrNull() } ?: emptyList()
    
    if (list.isEmpty()) {
        println("Lista invalida. Intente de nuevo.")
        return
    }
    
    val array = list.toIntArray()
    println("Lista original: ${array.joinToString()}")
    
    val time = measureTimeMillis {
        bubbleSort(array)
    }
    
    println("Lista ordenada usando Bubble Sort: ${array.joinToString()}")
    println("Tiempo de ejecucion: ${time / 1000.0} segundos")
}

//////////////////////////////////////////////////////////////
// Opción 2: Quick Sort
//////////////////////////////////////////////////////////////

fun quickSort(arr: IntArray, low: Int, high: Int) { 
    if (low < high) {
        val pi = partition(arr, low, high)
        quickSort(arr, low, pi - 1)
        quickSort(arr, pi + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] <= pivot) {
            i++
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
        }
    }
    val temp = arr[i + 1]
    arr[i + 1] = arr[high]
    arr[high] = temp
    return i + 1
}

fun quickSortOption() {
    print("\nIngrese una lista de numeros separados por comas: ")
    val input = readLine()
    val list = input?.split(",")?.mapNotNull { it.trim().toIntOrNull() } ?: emptyList()
    
    if (list.isEmpty()) {
        println("Lista invalida. Intente de nuevo.")
        return
    }
    
    val array = list.toIntArray()
    println("Lista original: ${array.joinToString()}")
    
    val time = measureTimeMillis {
        quickSort(array, 0, array.size - 1)
    }
    
    println("Lista ordenada usando Quick Sort: ${array.joinToString()}")
    println("Tiempo de ejecucion: ${time / 1000.0} segundos")
}

//////////////////////////////////////////////////////////////
// Opción 3: Factorial
//////////////////////////////////////////////////////////////

fun factorial(n: Int): Int { 
    if (n == 0) return 1
    return n * factorial(n - 1)
}

fun factorialIterative(n: Int): Int {
    var result = 1
    for (i in 1..n) {
        result *= i
    }
    return result
}

fun factorialOption() {
    print("\nIngrese un numero: ")
    val input = readLine()?.toIntOrNull()
    
    if (input == null || input < 0) {
        println("Numero invalido. Ingrese un numero entero positivo.")
        return
    }
    
    val factorialResult: Int
    val time = measureTimeMillis {
        factorialResult = factorial(input)
    }
    println("El factorial de $input es: $factorialResult")
    println("Tiempo de ejecucion: ${time / 1000.0} segundos")
}

//////////////////////////////////////////////////////////////
// Opción 4: Torres de Hanoi
//////////////////////////////////////////////////////////////
var stepCounter = 0

fun hanoi(n: Int, source: String, target: String, auxiliary: String) { 
    if (n == 1) {
        stepCounter++ // Incrementar el contador
        println("Paso $stepCounter: Mover disco 1 de Torre $source a Torre $target")
        return
    }
    hanoi(n - 1, source, auxiliary, target) // Mover n-1 discos al auxiliar
    stepCounter++ // Incrementar el contador para el disco actual
    println("Paso $stepCounter: Mover disco $n de Torre $source a Torre $target") // Mover el disco más grande
    hanoi(n - 1, auxiliary, target, source) // Mover n-1 discos al destino
}

fun hanoiOption() { 
    print("\nIngrese el numero de discos: ")
    val n = readLine()?.toIntOrNull()
    
    if (n == null || n <= 0) {
        println("Numero invalido. Ingrese un numero entero positivo.")
        return
    }

    // Reiniciar el contador de pasos antes de cada ejecución
    stepCounter = 0
    println("\nMovimientos para resolver las Torres de Hanoi con $n discos:")
    hanoi(n, "A", "C", "B")
}
