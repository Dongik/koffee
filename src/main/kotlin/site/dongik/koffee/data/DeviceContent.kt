package site.dongik.goffee.data

import java.util.ArrayList
import java.util.HashMap

object DeviceContent {

    val ITEMS: MutableList<DeviceItem> = ArrayList()

    val ITEM_MAP: MutableMap<String, DeviceItem> = HashMap()
    private val COUNT = 25

    init {
        // Add some sample items.
//        for (i in 1..COUNT) {
//            addItem(createDummyItem(i))
//        }

        addItem(DeviceItem("STAR","123120310","dongik","dongjin"))
    }

    fun update(serialNumber: String,device : DeviceItem){
        ITEM_MAP.put(device.serialNumber,device)
        //it can be accelerated
        var i :Int
        for(item in ITEMS){
            if(item.serialNumber.equals(serialNumber)){
                item != device
                break
            }
        }
    }

    fun delete(serialNumber: String){
        ITEM_MAP.remove(serialNumber)
        for(items in ITEMS){
            for(item in ITEMS){
                if(item.serialNumber.equals(serialNumber)){
                    ITEMS.remove(item)
                    break
                }
            }
        }
    }

    fun addItem(item: DeviceItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.serialNumber, item)
    }
//
//    private fun createDummyItem(position: Int): OrderItem {
//        return OrderItem(position.toString(), "Order " + position, makeDetails(position))
//    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A dummy item representing a piece of content.
     */
    data class DeviceItem(val name: String, val serialNumber: String,val owner:String,val holder: String) {
        override fun toString(): String = "$name $serialNumber owner:$owner holder:$holder"
    }
}
