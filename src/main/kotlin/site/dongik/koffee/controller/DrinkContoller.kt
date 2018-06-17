package site.dongik.koffee.controller

import io.javalin.Context
import org.litote.kmongo.*
import java.util.*


object DrinkContoller {

    data class Drink(val name: String, val price: Int)

    val client = KMongo.createClient() //get com.mongodb.MongoClient new instance
    val database = client.getDatabase("test") //normal java driver usage
    val col = database.getCollection<Drink>()


    fun getAllDrinkIds(ctx: Context) {
//        ctx.json(col.find("name"))
    }
    fun getAllDrinks(ctx:Context){
        ctx.json(col.find().toList())
//        ctx.json("Hello")
    }

    fun createDrink(ctx: Context) {
//        drinks[randomId()] = ctx.bodyAsClass(Drink::class.java)
        val drink = ctx.bodyAsClass(Drink::class.java)
        col.insertOne(drink)
    }


    fun getDrink(ctx: Context) {
        val id = ctx.param(":id")!!
//        val drink = col.findOneById(id)
//        ctx.json(drinks[ctx.param(":id")!!]!!)
    }

    fun updateDrink(ctx: Context) {
//        drinks[ctx.param(":id")!!] = ctx.bodyAsClass(Drink::class.java)
        val id = ctx.param(":id")!!
        val drink = ctx.bodyAsClass(Drink::class.java)
//        col.replaceOneById(id,drink)
    }

    fun deleteDrink(ctx: Context) {
        val id = ctx.param(":id")!!
//        col.deleteOneById(id)
    }

    private fun randomId() = UUID.randomUUID().toString()

}