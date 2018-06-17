package site.dongik.koffee.controller

import io.javalin.Context
import java.util.*
import kotlin.collections.HashMap

object OrderController {

    private data class Order(val title: String, val number: Int,val user:String)

    private val orders = HashMap<String,Int>()
    private val userOrder = HashMap<String,String>()

    fun getAllOrders(ctx: Context){
        ctx.json(orders.values)
    }

    fun putOrder(ctx: Context) {
        val order = ctx.bodyAsClass(Order::class.java)
        orders[order.title] = order.number
        userOrder[order.user] = order.title
    }

    fun getOrders(ctx: Context) {
//        val group = ctx.param(":group")
//        group function will be implemented
        ctx.json(orders)
    }

    fun getUserOrders(ctx: Context){
        ctx.json(userOrder)
    }


}