package com.example.kotlintest

object Utils {

    // To run all the functions in Utils.kt
    fun runAllFunc() {

        // Control Flow
        ifOperations()
        forLoopOperations()
        whenOperations(10)
        doWhileOperations()

        // Collections - List, Map, Set
        arrayListOperations()
        hashMapOperations()

        arrayOperations()

        // Return type functions
        funcWithReturnTypeInt(5, 5)
        funcWithReturnTypeBool(null)
        funWithReturnTypeInt("1234567890")
    }


    // if-else operations
    private fun ifOperations() {

        printStartAndEndofFunc(true, "if-else")

        val num1 = (10 * 10) / 2
        val num2 = 10 + 10
        var islarge = false

        if ((num1) > num2) islarge = true
        println("Is num1 $num1 greater than $num2 : " + islarge)

        val maxNum = if (num1 > num2) {
            num1
        } else {
            num2
        }
        println("Max number between $num1 and $num2 : " + maxNum)

        printStartAndEndofFunc(false, "if-else")
    }

    // For loop operations
    private fun forLoopOperations() {

        printStartAndEndofFunc(true, "for")

        // i < 10, i++
        print("i<10 value : ")
        for (i in 0..9) print(" $i ")
        println()

        // i <= 10, i++
        print("\ni<=10 value : ")
        for (i in 0..10) print(" $i ")
        println()

        // i <= 10, i++ with step $val
        // eg: step=2, then i = 2,4,6,8,10
        // eg: step=3, then i = 0,3,6, 9
        print("\ni<=10, step value : ")
        for (i in 0..10 step 2) print(" $i ")
        println()

        // i > 0, i--
        print("\ni>0 value : ")
        for (i in 10 downTo 1) print(" $i")
        println()


        // i >= 0, i--
        print("\ni>=0 value : ")
        for (i in 10 downTo 0) print(" $i ")
        println()

        // exclude 10
        print("i = 0 until 10 : ")
        for (i in 0 until 10) print(" $i ")
        println()

        printStartAndEndofFunc(false, "for")
    }

    // when operation (equivalent to switch case in java)
    private fun whenOperations(number: Int) {

        printStartAndEndofFunc(true, "when")

        // regular when block ()
        when (number) {
            in 1..5 -> println("When case : to far") // 'in' between range of values
            in 6..9 -> println("When case : close") // 'in' between range of values
            10 -> println("When case : matched")
            else -> println("When case : out of range")
        }

        // result of when assigned to a variable
        val result = when (number) {
            in 1..5 -> "to far" // 'in' between range of values
            in 6..9 -> "close" // 'in' between range of values
            10 -> "matched"
            else -> "out of range"
        }
        println("When case result : ${result}")


        // Smart casting
        val x: Any = "123"
        when (x) {
            is Int -> println("When case value is Int")
            is String -> println("When case value is String")
            else -> println("unknown dataType")
        }

        printStartAndEndofFunc(false, "when")
    }

    // while / do-while operations
    private fun doWhileOperations() {

        printStartAndEndofFunc(true, "do-while")

        var x = 10

        // while loop, it will run till the x > 0
        print("while ")
        while (x > 0) {
            x--
            print("$x ")
        }

        // do-while -> do block will run first time without checking the first condition
        // then from the 2nd iteration onwards it will consider the while expression
        // and continue to run until the while expression is false
        println()
        print("do-while ")
        do {
            x++
            print("$x ")
        } while (x < 15)

        println()
        printStartAndEndofFunc(false, "do-while")
    }

    // Array operations
    private fun arrayOperations() {
        val strArr = arrayOf("a", "b", "c")

        // Prints an IntRange of the valid indices (op: 0..2)
        println("Arr indices ${strArr.indices}")

        // Prints the size of an array
        println("Arr size ${strArr.size}")
    }

    // ArrayList operations
    private fun arrayListOperations() {

        printStartAndEndofFunc(true, "arrList")

        val strArrList = ArrayList<String>()

        strArrList.add("a")
        strArrList.addAll(listOf("b", "c", "d"))

        // prints the size of the list
        println("ArrList size ${strArrList.size}")

        // prints the list
        println("ArrList ${strArrList}")

        // removes the element 'b'
        strArrList.remove("b")

        // prints the list after removing b
        println("ArrList: removed b : ${strArrList}")

        // removes the element at index 0
        strArrList.removeAt(0)

        // prints the list after removing element at index 0
        println("ArrList: removed element at index 0 : ${strArrList}")

        // prints the element a specific index
        println("ArrList: element at index 0 : ${strArrList[0]}")

        // printls he list indices
        println("ArrList indices : ${strArrList.indices}")

        // prints only listitems
        for (listItem in strArrList) println("ArrList value: ${listItem}")

        // prints index and list items
        for (i in strArrList.indices) println("ArrList index and val ${i} , ${strArrList[i]}")

        printStartAndEndofFunc(false, "arrList")

    }

    // HashMap operations
    private fun hashMapOperations() {

        printStartAndEndofFunc(true, "HashMap")

        val hashMap: HashMap<Int, String> = HashMap()
        hashMap.put(1, "Tom")
        hashMap.put(2, "John")
        hashMap.put(3, "Mike")
        hashMap.put(4, "Harry")

        println("HashMap keys : $hashMap.keys")
        println("HashMap values : ${hashMap.values}")


        println("HashMap sorted keys : ${hashMap.toSortedMap().keys}") // Sorting keys using toSortedMap().keys
        println("HashMap sorted values : ${hashMap.toSortedMap().values}") // Sorting values toSortedMap().values

        for (key in hashMap.keys)
            println("HashMap using for loop Element at : key $key = ${hashMap[key]}")

        hashMap.put(2, "Neil") // John will be replaced by Neil

        // Iterating hashmap using for-each loop
        hashMap.forEach { (key, value) -> println("Iterating hashmap using forEach $key = $value") }


        printStartAndEndofFunc(false, "HashMap")
    }

    // Function to add two integer and return the sum
    private fun funcWithReturnTypeInt(num1: Int, num2: Int) = num1 + num2

    // Function to check if email ends with gmail and return boolean result
    private fun funcWithReturnTypeBool(email: String?) =
        (!email.isNullOrBlank() && email.endsWith("@gmail.com"))

    // Funtion to check if phone number length is 10 digits and return code
    private fun funWithReturnTypeInt(phoneNo: String?): Int {
        if (phoneNo.isNullOrBlank()) return 101
        else if (phoneNo.length > 10) return 102
        else if (phoneNo.length < 10) return 103
        else if (phoneNo.length == 10) return 200 // Success

        return 0
    }

    // Print start and end of function
    private fun printStartAndEndofFunc(isStart: Boolean, message: String) {
        if (isStart) println("####### Start of ${message} operations ############")
        else println("####### End of ${message} operations ############")
    }
}