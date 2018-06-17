import junit.framework.Assert
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import org.litote.kmongo.KMongo
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection
import org.litote.kmongo.insertOne
import site.dongik.koffee.MongoTest
import site.dongik.koffee.model.*
class IncertSampleData {

    val client = KMongo.createClient()
    val database = client.getDatabase("test")
    val col = database.getCollection<Drink>()

    @Test
    fun incertSims() = runBlocking {
        col.insertOne(Drink("Jase", 1000))


        val drink = col.find() ?: throw AssertionError("Value must not null!")
        println(drink)
//        Assert.assertEquals("Jase", drink.name)
    }
    @Test
    fun incertDrinks() = runBlocking {
        col.insertOne(Drink("Jase", 1000))
        val drink = col.findOne("{name:'Jase'}") ?: throw AssertionError("Value must not null!")
        println(drink)
        Assert.assertEquals("Jase", drink.name)
    }

    @Test
    fun incertUsers() = runBlocking {
        col.insertOne(Drink("Jase", 1000))
        val drink = col.findOne("{name:'Jase'}") ?: throw AssertionError("Value must not null!")
        println(drink)
        Assert.assertEquals("Jase", drink.name)
    }


    @Test
    fun incertOrders() = runBlocking {
        col.insertOne(Drink("Jase", 1000))
        val drink = col.findOne("{name:'Jase'}") ?: throw AssertionError("Value must not null!")
        println(drink)
        Assert.assertEquals("Jase", drink.name)
    }





}