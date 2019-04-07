package _step01

import io.reactivex.Observable

class _01_Observable_kotlin {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            // 2번
            val x = listOf(1, 2, 3)
            val y = arrayListOf(1, 2, 3)

            // 3번
            val l = 3
            when (l) {
                in 4..1 -> {
                    System.out.println("a")
                }
                !in 4..1 -> {
                    System.out.println("b")
                }
                in 4..1 -> {
                    System.out.println("c")
                }
            }

            // 4번
            System.out.println('0'.toInt() - "0".toInt() > 0)
            System.out.println('0'.toInt() - "0".toInt() == 0)
            System.out.println('0'.toInt() - "0".toInt() < 0)

//            // 5번
//            1?.let {
//                2?.apply {
//                    (3 as Int?).also {
//                        4.run {
//                            print(it + this)
//                        }
//                    }
//                }
//            }

            println(0 to (1 to 2 to 3) to 4 to (5 to 6))

            val dot = 1..10
            var rangeTo = 1.rangeTo(10)
            var downTo = 10 downTo 1
            var until = 1 until 10
            var intRange = IntRange(1, 10)
            // var range = Range(1, 10)

            val boxes : List<Box> = listOf(
                Box(text = "A"),
                Box(text = "B"),
                Box(text = "C"),
                Box(text = "D"),
                Box(text = "E"))

            boxes.filter{it.number != null}
                .minBy {it.number!!}
                .let {
                    println("${it}")
                }


        }
    }

    infix fun <A,B,C> Pair<A, B>.to(third:C) = Triple(first, second, third)

    data class Box(
        val number : Int? = null,
        val text : String? = null
    )
}