package site.dongik.koffee.experiment

object KoffeeModel{
    data class Drink(override val id:String,val name:String): KoffeeContent.KoffeeItem
    data class Device(override val id:String,val name:String): KoffeeContent.KoffeeItem
    data class Order(override val id:String,val name:String): KoffeeContent.KoffeeItem
    data class Sim(override val id:String,val name:String): KoffeeContent.KoffeeItem
    data class User(override val id:String,val name:String): KoffeeContent.KoffeeItem
}