fun main() {
    println("Bem vindo ao Bytebank")
    val contaAlex = Conta("Alex", 1000)
    contaAlex.deposita(200.0)

    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    val contaFran = Conta("Fran", 1001)
    contaFran.deposita(300.0)

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println("Depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println(contaAlex.saldo)
    println("Depositando na conta da Fran")
    contaFran.deposita(70.0)
    println(contaFran.saldo)

    println("sacando na conta do alex")
    contaAlex.saca(250.0)
    println(contaAlex.saldo)

    println("sacando na conta da Fran")
    contaFran.saca(100.0)
    println(contaFran.saldo)

    println("Transferência da conta da Fran para o Alex")

    if (contaFran.transfere(300.0, contaAlex)) {
        println("Transferência suceidida")
    } else {
        println("Falha na transferência ")
    }
    println(contaAlex.saldo)
    println(contaFran.saldo)
}

class Conta(
    var titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }

}

fun testaLacos() {
    var i = 0
    while (i < 5) {
        val titular: String = "Alex"
        val numeroConta: Int = 1000 + i
        val saldo: Double = 0.0 + i
        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
        i++


    }
}

fun testaCondicoes(saldo: Double) {
    when {
        saldo > 0.0 -> println("Conta é Positiva")
        saldo == 0.0 -> println("Conta é Neutra")
        else -> println("conta é negativa")
    }
}