package site.dongik.koffee

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import com.mongodb.client.MongoCollection
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.experimental.runBlocking
import org.bson.conversions.Bson
import org.junit.Before
import org.junit.Test
import org.litote.kmongo.*

class MongoTest {
    data class Drink(val name: String, val price: Int)
    val client  = KMongo.createClient()
    val database = client.getDatabase("test")
    val col = database.getCollection<Drink>()

    @Before
    fun setUp(){
//        col.deleteMany("{}")
//        println("deleted")
    }

    @Test
    fun canFindOne() = runBlocking {
        col.insertOne(Drink("Jase", 1000))
        val drink = col.findOne("{name:'Jase'}") ?: throw AssertionError("Value must not null!")
        println(drink)
        assertEquals("Jase", drink.name)
    }


    @Test
    fun canFindbyBson() = runBlocking {
        col.insertOne(Drink("John", 1000))
        col.insertOne(Drink("Dongik", 2000))
        val drinks = col.find("{name:'Dongik'}") ?: throw AssertionError("Value must not null!")
//        drinks.toList()
        println(drinks.toList())
        assertEquals("Dongik", drinks.toList()[0].name)
    }

    @Test
    fun canFindAll() = runBlocking {
        col.insertOne(Drink("americano", 1000))
        val all = col.find()
        println(all.toList())
    }
}