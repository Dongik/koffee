package site.dongik.koffee

import io.javalin.Javalin
import io.javalin.ApiBuilder.*
import site.dongik.goffee.data.DeviceContent
import site.dongik.koffee.controller.*
import site.dongik.koffee.experiment.KoffeeContent
import site.dongik.koffee.experiment.KoffeeModel
import org.litote.kmongo.*


fun main(args: Array<String>) {

    println("Hello, world!")

    val client = KMongo.createClient()
//    val database = client.getDatabase("test")
//    val map = Map<String,KoffeeContent<>>

    val app = Javalin.create().apply {
        port(8080)
        exception(Exception::class.java) { e, ctx -> e.printStackTrace() }
        error(404) { ctx -> ctx.json("not found") }
    }.start()
    
    app.routes {
        path("devices"){
            get(DeviceController::getAllDevice)
            post(DeviceController::createDevice)
            path("holder/:id"){get(SimController::getSimsByHolderId)}
            path("owner/:id"){get(SimController::getSimsByOwnerId)}
            path(":id"){
                get(DeviceController::getDevice)
                patch(DeviceController::updateDevice)
                delete(DeviceController::deleteDevice)
            }
        }
        
        path("sims"){
            get(SimController::getAllSims)
            post(SimController::createSim)
            path("holder/:id"){ get(SimController::getSimsByHolderId) }
            path("owner/:id"){ get(SimController::getSimsByOwnerId) }
            path(":id"){
                get(SimController::getSim)
                patch(SimController::updateSim)
                delete(SimController::deleteSim)
            }
        }
        
        path("drinks"){
            get(DrinkContoller::getAllDrinks)
            post(DrinkContoller::createDrink)
            path(":id"){
                get(DrinkContoller::getDrink)
                patch(DrinkContoller::updateDrink)
                delete(DrinkContoller::deleteDrink)
            }
        }
        
        path("orders"){
            get(OrderController::getAllOrders)
            put(OrderController::putOrder)
        }
        
        path("users"){
            get(UserController::getAllUserIds)
            post(UserController::createUser)
            path(":id"){
                get(UserController::getUser)
                patch(UserController::updateUser)
            }
        }
        
    }

}
