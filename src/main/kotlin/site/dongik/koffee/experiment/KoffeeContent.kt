package site.dongik.koffee.experiment

import java.util.ArrayList
import java.util.HashMap

class KoffeeContent<T: KoffeeContent.KoffeeItem>(val objectName:String) {
    val ITEMS: MutableList<T> = ArrayList()
    val ITEM_MAP: MutableMap<String, T> = HashMap()
    interface KoffeeItem{
        val id:String
    }
//
////    val class = T()
    val PATH_ID = "/$objectName/:id"
    val PATH_ALL = "/$objectName"
//

    fun findAll():List<T> = ITEMS
    fun findById(id:String):T? = ITEM_MAP[id]
    fun create(item:T){
        ITEMS.add(item)
        ITEM_MAP.put(item.id, item)
    }
    fun delete(id:String){
        val item = ITEM_MAP[id]
        ITEM_MAP.remove(id)
        ITEMS.remove(item)
    }
    fun update(id: String,item : T){
        ITEM_MAP[id] = item
    }
}
