package site.dongik.koffee.controller

import io.javalin.Context
import site.dongik.koffee.model.Sim
import java.util.*


object SimController {


    private val sims = hashMapOf(
            randomId() to Sim(name = "Alice", owner = "dongik", holder = "dongik2"),
            randomId() to Sim(name = "Bob",  owner = "dongik", holder = "dongik2"),
            randomId() to Sim(name = "Carol",owner = "dongik", holder = "dongik2"),
            randomId() to Sim(name = "Dave", owner = "dongik", holder = "dongik2")
    )

    fun getAllSimIds(ctx: Context) {
        ctx.json(sims.keys)
    }

    fun getSimsByHolderId(ctx: Context){
        val holder = ctx.param(":id")!!
    }

    fun getSimsByOwnerId(ctx: Context){
        ctx.param(":id")
    }

    fun getAllSims(ctx: Context) {
        ctx.json(sims.values)
    }

    fun createSim(ctx: Context) {
        sims[randomId()] = ctx.bodyAsClass(Sim::class.java)
    }

    fun getSim(ctx: Context) {
        ctx.json(sims[ctx.param(":id")!!]!!)
    }

    fun updateSim(ctx: Context) {
        sims[ctx.param(":id")!!] = ctx.bodyAsClass(Sim::class.java)
    }

    fun deleteSim(ctx: Context) {
        sims.remove(ctx.param(":id")!!)
    }

    private fun randomId() = UUID.randomUUID().toString()

}