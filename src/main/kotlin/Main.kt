import java.util.*

fun calculateTotalRabbits(n: Int, m: Int): Long {
    val lifetime = LongArray(m + 1) { 0 }
    lifetime[0] = 1

    for (month in 1 until n) {
        lifetime.copyInto(destination = lifetime, destinationOffset = 1, startIndex = 0, endIndex = m)
        lifetime[0] = lifetime.slice(2 until lifetime.size).sum()
    }

    return lifetime.slice(0 until lifetime.size - 1).sum()
}

fun main() {
    val sc = Scanner(System.`in`)

    print("Enter the number of months: ")
    val N: Int = sc.nextInt()

    print("Enter the value of how long rabbits live: ")
    val M: Int = sc.nextInt()

    val result = calculateTotalRabbits(N, M)
    println("There is a $result rabbit on the $N-th month.")
}

