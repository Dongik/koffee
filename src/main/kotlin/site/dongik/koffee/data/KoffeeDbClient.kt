package site.dongik.koffee.data

import org.litote.kmongo.KMongo

object KoffeeDbClient{
    init{
        val client = KMongo.createClient()
        val database = client.getDatabase("test")
    }



}