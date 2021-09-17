package com.cool.ldp.kotlin

import ldp.Main.println
import java.io.BufferedReader
import java.io.File
import java.io.FileReader

object KotlinTest {

    @JvmStatic
    fun main(args: Array<String>) {

        val iterator = args.iterator()
        if (iterator.hasNext())
            println(iterator.next())


        /**
         * ------------------------------- map ------------------------------------
         * -- map 操作符 对当前集合 中的 每一个元素 进行转换,返回转换后的 List<*>-------
         * ------------------------------------------------------------------------
         */
        val ints = arrayOf(1, 2, 3, 4, 5, 6)
        val newInts = ints.map { it * 10 }

        printArray("ints old ", ints) // ints old   :   1  2  3  4  5  6
        printArray("ints new ", newInts) // ints new   :   10  20  30  40  50  60

        val strs = arrayOf("text1", "text2", "text3")
        val newStrs = strs.map { "$it+新加一个东西" }
        printArray("strs old ", strs) // strs old   :   text1  text2  text3
        printArray("strs new ", newStrs) // strs new   :   text1+新加一个东西  text2+新加一个东西  text3+新加一个东西
        /**
         * -------------------------------map----------------------------------------
         */


        /**
         * ------------------------------- flatMap ------------------------------------------------
         * -- flatMap 是一种支持二维集合映射的高阶函数  将多个集合进行处理 处理的对象是集合，不是元素------
         * ----------------------------------------------------------------------------------------
         */
        val ints2 = arrayOf(1, 3, 5, 7, 9)
        val ints3 = arrayOf(10, 30, 50, 70, 90)
        val ints4 = arrayOf(100, 300, 500, 700, 900)
        val ints5 = arrayOf(6, 7, 8, 9, 10)

        val intAll = arrayListOf(ints2, ints3, ints4, ints5)

        val flatMapList = intAll.flatMap { flatMapIt ->
            flatMapIt.map { i -> i }
        }

        printArray("flatMapList", flatMapList)
        // flatMapList  :   1  3  5  7  9  10  30  50  70  90  100  300  500  700  900  6  7  8  9  10


        /**
         * ------------------------------- filter --------------------------
         * -- filter 操作符 对集合里的元素做过滤操作,返回转换后的 List<*>-------
         * -----------------------------------------------------------------
         */
        val ints6 = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val filterList = ints6.filter { it > 5 }
        printArray("filterList", filterList)// filterList  :   6  7  8  9  10


        /**
         * ------------------------------- takeWhile --------------------------
         * -- takeWhile 操作符 对集合里的元素做过滤操作,返回转换后的 List<*>-------
         * ----区别于 filter 只要一个不满足 就直接结束遍历 我的眼里揉不得沙子系列---
         * -----------------------------------------------------------------
         */
        val ints7 = arrayOf(10, 2, 6, 7, 8, 9, 90)
        val takeWhileList = ints7.takeWhile { it > 5 }
        printArray("takeWhileList", takeWhileList)// takeWhileList  :   10


        /**
         * -------------------------------take/takeLast--------------------------
         * --------take/takeLast 取一个集合 前几个/后几个元素-----------------------
         * ----------------------------------------------------------------------
         */
        val ints8 = ints7.clone()// copy  ints7 = arrayOf(10,2,6,7,8,9,90)
        val take3List = ints8.take(3)
        val takeLast3List = ints8.takeLast(3)
        printArray("take3List", take3List) // take3List  :   10  2  6
        printArray("takeLast3List", takeLast3List)// takeLast3List  :   8  9  90


        /**
         * ---------------------------fold-----------------------------------------------------------
         * ---fold- 就是 先设置一个初始值作为 sum 然后 依次对 集合中的每一个元素进行自定义的运算 累加等等---
         * ------------------------------------------------------------------------------------------
         */
        val ints9 = arrayOf(1, 2, 3, 4)
        val fold = ints9.fold(2, { acc: Int, i: Int ->
            acc * i//2*1=2,2*2=4,4*3=12,12*4=48
        })
        println(fold)// 48

        // 以上代码 等价于 下面的 代码
        var sum = 2
        for (i in ints9) {
            sum *= i // sum = sum*i
        }
        println(sum)//48


        /**
         * ---------------------------reduce---------------------------------------------------------
         * ---reduce- 类似fold 不过没有初始值，默认把第一个当做初始值，作用等同于 fold------------------
         * ------------------------------------------------------------------------------------------
         */
        val ints10 = arrayOf(1, 2, 3, 4)
        val reduce = ints10.reduce({ acc: Int, i: Int ->
            acc * i//1*2=2,2*3=6,6*4=24
        })
        println(reduce)// 24


        /**
         * ---------------------------------------let--------------------------------------------------------
         * ----let---可用于在调用链的结果上调用一个或多个函数。 上下文对象可用作参数（it）。返回值是lambda结果。--
         * ------------ 说白了就是 把.号之前的对象变成了 it 然后在 let 里面调用--------------------------------
         * -------------------------------------------------------------------------------------------------
         */
        val numbers = mutableListOf("one", "two", "three", "four", "five")
        val resultList = numbers.map { it.length }.filter { it > 3 }
        println(resultList) // [5, 4, 4]

        resultList.let {
            println(it)
            println(it.size)
            if (it.isNullOrEmpty()) {
                //...
            }
            // and more function calls if needed
        }


        /**
         * --------------------------------------apply----------------------------------------------------
         * ----apply--上下文对象可用作接收者（this）。返回值是对象本身。说白了和let相似，只是省略了it 更简单了-
         * --使用apply代码块没有返回值，主要是操作上的接收器对象的成员。常见的情况apply是对象配置。-----------
         * --------------------此类调用可以理解为“将以下分配应用于对象”。-----------------------------------
         * ----------------------------------------------------------------------------------------------
         */
        val str = "我是一串字符串"
        str.apply {
            plus("加一段字符串")
            replace("一", "替换")
            compareTo("333")

            var strL = length
        }
        // 以上代码 等价于 下面的代码
        str.plus("加一段字符串")
        str.replace("一", "替换")
        str.compareTo("333")
        var strL = str.length

        /**
         * ------------------------with-------------------------------------------------
         * ---with--with可以让用户省略点号之前的对象引用，with内部的所有操作都是针对with对象--
         * -----------------------------------------------------------------------------
         */
        val test = Test()
        with(test) {
            testFile = ""// Test类的变量
            test()// test 方法
        }

        /**
         * ----------------------------------------------run---------------------------------------------------------------
         * --------适用于let,with函数任何场景。因为run函数是let,with两个函数结合体，------------------------------------------
         * ----准确来说它弥补了let函数在函数体内必须使用it参数替代对象，在run函数中可以像with函数一样可以省略，-----------------
         * -----直接访问实例的公有属性和方法，另一方面它弥补了with函数传入对象判空问题，在run函数中可以像let函数一样做判空处理---
         * ----------------------------------------------------------------------------------------------------------------
         */
        val service = Test()

        val result = service.run {
            testFile = "8080"
            test()
        }

        // the same code written with let() function:
        val letResult = service.let {
            it.testFile = "8080"
            it.test()
        }

        // the same code written with with() function:
        with(service){
            testFile= "8080"
            test()
        }


        /**
         * -------------------------use-----------------------------------------------------------
         * ---use-- 针对  实现Closeable接口的对象  如果发生了异常会记录并抛出异常，--------------------
         * -----finally中不管有没有出异常都会自动做关闭操作，避免了IO处理的try..catch..finally样板代码--
         * ---------------------------------------------------------------------------------------
         */
        val file = File("文件名")
        val bufferedReader = BufferedReader(FileReader(file))

        bufferedReader.use {
            it.readLine()
        }

    }

    private fun printArray(tag: String, array: Array<*>) {
        val iterator = array.iterator()
        val str = StringBuilder()
        while (iterator.hasNext())
            str.append("${iterator.next()}  ")

        println("$tag  :   $str")
    }

    private fun printArray(tag: String, array: List<*>) {
        val iterator = array.iterator()
        val str = StringBuilder()
        while (iterator.hasNext())
            str.append("${iterator.next()}  ")

        println("$tag  :   $str")
    }

    class Test {

        var testFile = "test111"

        fun test() {
            println("test")
        }
    }
}