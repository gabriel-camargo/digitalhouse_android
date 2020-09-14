fun main() {
    val cliente1 = Cliente("Juvenal", "Tibúrcio")
    val cliente2 = Cliente("Claudete", "Gomes")

    val conta1 = Conta(123456, cliente1, 256.00)
    val conta2 = Conta(654321, cliente2, 9999.50)

    conta1.sacar(100.00)
    conta1.depositar(1500.00)

    conta2.sacar(9999.49)
    conta2.depositar(100.00)
}