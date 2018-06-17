package site.dongik.koffee.controller

import io.javalin.Context
import org.litote.kmongo.*
import java.util.*

object DeviceController {

    data class Device(val name: String, val sn: String)

//    val client = KMongo.createClient() //get com.mongodb.MongoClient new instance
//    val database = client.getDatabase("test") //normal java driver usage
//    val col = database.getCollection<Device>()


    private val devices = hashMapOf(
            randomId() to Device(name = "Alice", sn = "alice@alice.kt"),
            randomId() to Device(name = "Bob", sn = "bob@bob.kt"),
            randomId() to Device(name = "Carol", sn = "carol@carol.kt"),
            randomId() to Device(name = "Dave", sn = "dave@dave.kt")
    )

    fun getAllDeviceIds(ctx: Context) {
        ctx.json(devices.keys)
    }

    fun getDevicesByOwnerId(ctx: Context){
//        ctx.json(col.find())
    }

    fun getDevicesByHolderId(ctx: Context){

    }
    fun gerDeviceByBson(ctx:Context){

    }

    fun getAllDevice(ctx: Context){
//        ctx.json(devices.values)
//        ctx.json(col.find())
    }

    fun createDevice(ctx: Context) {
        val device = ctx.bodyAsClass(Device::class.java)
        devices[randomId()] = device
//        col.insertOne(device)
    }

    fun getDevice(ctx: Context) {
        val id = ctx.param(":id")!!
//        val device = col.findOneById(id ?: Any()) ?: throw AssertionError("Value must not null!")
//        ctx.json(device)
    }

    fun updateDevice(ctx: Context) {
        //replace
        val id = ctx.param(":id")
        val device = ctx.bodyAsClass(Device::class.java)
//        col.replaceOneById(id ?: Any(),device)
//        devices[ctx.param(":id")!!] =
    }

    fun deleteDevice(ctx: Context) {
        val id = ctx.param(":id")
//        col.deleteOneById(id!!)
    }

    private fun randomId() = UUID.randomUUID().toString()

}