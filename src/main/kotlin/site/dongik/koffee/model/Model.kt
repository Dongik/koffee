package site.dongik.koffee.model

data class Drink(val name: String,val price: Int)
data class Order(var name :String,var type: String,var size: String)
data class Device(val name: String, val owner: String,val holder:String)
data class Sim(val name: String, val owner: String,val holder:String)