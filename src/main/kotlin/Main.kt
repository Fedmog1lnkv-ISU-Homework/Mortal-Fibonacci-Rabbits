import java.util.*

fun calculateTotalRabbits(n: Int, m: Int): Long {
    val F = LongArray(n + 1)
    val rabbit = LongArray(m)

    rabbit[0] = 1
    F[1] = 1

    for (i in 2..n) {
        val next = LongArray(m)

        for (j in 1 until m) {
            next[j] = rabbit[j - 1]
            next[0] += rabbit[j]
        }

        for (k in 0 until m) {
            rabbit[k] = next[k]
            F[i] += rabbit[k]
        }
    }

    return F[n]
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

