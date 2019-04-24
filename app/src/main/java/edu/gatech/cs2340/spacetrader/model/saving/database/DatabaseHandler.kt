package edu.gatech.cs2340.spacetrader.model.saving.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import edu.gatech.cs2340.spacetrader.entity.*
import edu.gatech.cs2340.spacetrader.entity.inventory.PlanetInventory
import edu.gatech.cs2340.spacetrader.entity.inventory.PlayerInventory
import edu.gatech.cs2340.spacetrader.generators.PlanetGenerator
import edu.gatech.cs2340.spacetrader.generators.UniverseGen
import edu.gatech.cs2340.spacetrader.model.*
import edu.gatech.cs2340.spacetrader.util.Coordinate
import edu.gatech.cs2340.spacetrader.util.Size

class DatabaseHandler(private val context: Context): SQLiteOpenHelper(context, "saveData", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val playerCreationStatement = "create table if not exists players(" +
                " name text primary key, credits integer not null," +
                " pilotPoints integer not null," +
                " traderPoints integer not null," +
                " fighterPoints integer not null," +
                " engineerPoints integer not null," +
                " difficulty integer not null," +
                " health real not null," +
                " shipType integer not null," +
                " fuelLevel real not null," +
                " width integer," +
                " height integer);"
        db?.execSQL(playerCreationStatement)

        val solarSystemCreationStatement = "create table if not exists systems(color integer primary key, player text, foreign key (player) references players(name));"
        db?.execSQL(solarSystemCreationStatement)

        val planetCreationStatement = "create table if not exists planets(name text primary key, xCoord integer, yCoord integer, resourceType integer, techLevel integer, currentPlanet integer, system integer, foreign key(system) references systems(color));"
        db?.execSQL(planetCreationStatement)

        val itemsCreationStatement = "create table if not exists items(itemId integer primary key autoincrement, name integer, amount integer, player text, planet text, foreign key(player) references players(name), foreign key(planet) references planets(name))"
        db?.execSQL(itemsCreationStatement)

    } //onCreate

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun updatePlayer(player: Player, difficulty:GameDifficulty, size: Size){
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("name", player.name)
        cv.put("credits", player.credits)
        cv.put("pilotPoints", player.skills.skillsMap[Skill.PILOT])
        cv.put("traderPoints", player.skills.skillsMap[Skill.TRADER])
        cv.put("fighterPoints", player.skills.skillsMap[Skill.FIGHTER])
        cv.put("engineerPoints", player.skills.skillsMap[Skill.ENGINEER])
        cv.put("difficulty", difficulty.ordinal)
        cv.put("health", player.ship.health)
        cv.put("shipType", player.ship.type.ordinal)
        cv.put("fuelLevel", player.ship.fuel)
        cv.put("width", size.width)
        cv.put("height", size.height)
        val i = db.insert("players", null, cv)
        if(i == -1L) {
            db.update("players", cv, "name = ?", arrayOf(player.name))
        } //if error



        player.ship.inventory.inv.forEach {
            val invCv = ContentValues()
            invCv.put("player", player.name)
            invCv.put("name", it.key.ordinal)
            invCv.put("amount", it.value)
            val returnv = db.insert("items", null, invCv)
            if(returnv == -1L) {
                db.update("items", invCv, "player = ?", arrayOf(player.name))
            }
        }
        db.close()
    } //writePlayer

    fun updateUniverse(universe: Universe, player: Player, planet: Planet) {
        val db = this.writableDatabase
        universe.systems.forEach{
            val cv = ContentValues()
            cv.put("color", it.color)
            cv.put("player", player.name)
            val color = it.color
            val i = db.insertWithOnConflict("systems", null, cv, SQLiteDatabase.CONFLICT_IGNORE)
            if(i == -1L) {
                db.update("systems", cv, "name = ?", arrayOf(player.name))
            } //if error

            it.planets.forEach{
                val planCV = ContentValues()
                planCV.put("name", it.value.name)
                planCV.put("xCoord", it.value.coordinate.x)
                planCV.put("yCoord", it.value.coordinate.y)
                planCV.put("resourceType", it.value.resource.ordinal)
                planCV.put("techLevel", it.value.techLevel.ordinal)
                planCV.put("system", color)
                if(planet == it.value){
                    planCV.put("currentPlanet", 1)
                } else {
                    planCV.put("currentPlanet", 0)
                }
                val iE = db.insertWithOnConflict("planets", null, planCV, SQLiteDatabase.CONFLICT_IGNORE)
                if(iE == -1L) {
                    db.update("planets", planCV, "name = ?", arrayOf(it.value.name))
                }
                val name = it.value.name


                it.value.inventory.inv.forEach {
                    val invCv = ContentValues()
                    invCv.put("planet", name)
                    invCv.put("name", it.key.ordinal)
                    invCv.put("amount", it.value)
                    val returnv = db.insertWithOnConflict("items", null, invCv, SQLiteDatabase.CONFLICT_IGNORE)
                    if(returnv == -1L) {
                        db.update("items", invCv, "player = ?", arrayOf(name))
                    }
                }
            } //for each planet
        } //for each system
        db.close()
    } //writeUniverse

    fun readGame(name:String): GameManager{
        val db = this.writableDatabase
        val universe = Universe(UniverseGen())

        //builds the universe via a query
        val systemsQuery = "select * from systems where player='$name'"
        val systems = db.rawQuery(systemsQuery, null)
        val universeSet = HashSet<SolarSystem>()
        var currPlanet:Planet? = null
        universe.systems = universeSet
        if(systems.moveToFirst()) {
            do {
                val color = systems.getInt(systems.getColumnIndex("color"))
                val planetsQuery = "select * from planets where system=$color"
                val planets = db.rawQuery(planetsQuery, null)
                val systemMap = HashMap<Coordinate, Planet>()
                val system = SolarSystem()
                system.planets = systemMap

                if(planets.moveToFirst()) {
                    do {
                        val pName = planets.getString(planets.getColumnIndex("name"))
                        val pX = planets.getInt(planets.getColumnIndex("xCoord"))
                        val pY = planets.getInt(planets.getColumnIndex("yCoord"))
                        val pCoord = Coordinate(pX, pY)
                        val pResource = PlanetResource.values()[planets.getInt(planets.getColumnIndex("resourceType"))]
                        val pTech = TechLevel.values()[planets.getInt(planets.getColumnIndex("techLevel"))]
                        val planet = Planet(pName, pCoord, pResource, pTech)
                        if (planets.getInt(planets.getColumnIndex("currentPlanet")) == 1) {
                            currPlanet = planet
                            Log.d("sq null", "hello")
                        }
                        systemMap[pCoord] = planet

                        val planetInvQuery = "select * from items where planet='$pName'"
                        val planetIvnData = db.rawQuery(planetInvQuery, null)
                        val planetInv = PlanetInventory(planet)
                        if(planetIvnData.moveToFirst()) {
                            do{
                                val good = planetIvnData.getInt(planetIvnData.getColumnIndex("name"))
                                val amount = planetIvnData.getInt(planetIvnData.getColumnIndex("amount"))
                                Log.d("planinv", amount.toString())
                                planetInv.addToInv(Good.values()[good], amount)
                            } while (planetIvnData.moveToNext())
                        }
                        //planet.inventory = planetInv

                    } while(planets.moveToNext())
                } //for j 0 to planets.count
                planets.close()
                universeSet.add(system)
            } while(systems.moveToNext())
        } //for i 0 to systems.count

        //querys and parses the player
        val playerQuery = "select * from players where name='$name'"
        val playerData = db.rawQuery(playerQuery, null)
        var player = Player("", 0, SkillsData(HashMap()), Ship())
        var difficulty = GameDifficulty.EASY
        if(playerData.moveToFirst()) {
            do {
                val playerName = playerData.getString(playerData.getColumnIndex("name"))
                val playerCredits = playerData.getInt(playerData.getColumnIndex("credits"))
                val shipType = ShipType.values()[playerData.getInt(playerData.getColumnIndex("shipType"))]
                val ship = Ship(shipType)
                ship.health = playerData.getDouble(playerData.getColumnIndex("health"))
                ship.fuel = playerData.getDouble(playerData.getColumnIndex("fuelLevel"))
                val skillMap = HashMap<Skill, Int>()
                skillMap[Skill.PILOT] = playerData.getInt(playerData.getColumnIndex("pilotPoints"))
                skillMap[Skill.TRADER] = playerData.getInt(playerData.getColumnIndex("traderPoints"))
                skillMap[Skill.ENGINEER] = playerData.getInt(playerData.getColumnIndex("engineerPoints"))
                skillMap[Skill.FIGHTER] = playerData.getInt(playerData.getColumnIndex("fighterPoints"))
                val skillsData = SkillsData(skillMap)
                player = Player(playerName, playerCredits, skillsData, ship)
                difficulty = GameDifficulty.values()[playerData.getInt(playerData.getColumnIndex("difficulty"))]
            } while(playerData.moveToNext())
        }

        val playerInvQuery = "select * from items where player='$name'"
        val playerIvnData = db.rawQuery(playerInvQuery, null)
        val playerInv = PlayerInventory(15)
        if(playerIvnData.moveToFirst()) {
            do{
                val good = playerIvnData.getInt(playerIvnData.getColumnIndex("name"))
                val amount = playerIvnData.getInt(playerIvnData.getColumnIndex("amount"))
                playerInv.addToInv(Good.values()[good], amount)
            } while (playerIvnData.moveToNext())
        }
        player.ship.inventory = playerInv

        systems.close()
        playerData.close()
        db.close()
        val manager = GameManager(player, difficulty)
        manager.currentPlanet = currPlanet!!
        Log.d("sqnull", currPlanet.name)
        return manager
    } //readGame

    fun readSize(name: String): Size{
        val db = this.writableDatabase

        val playerQuery = "select * from players where name='$name'"
        val playerData = db.rawQuery(playerQuery, null)
        var height = 0
        var width = 0
        if(playerData.moveToFirst()) {
            do {
                height = playerData.getInt(playerData.getColumnIndex("height"))
                width = playerData.getInt(playerData.getColumnIndex("width"))
            } while (playerData.moveToNext())
        }

        playerData.close()
        db.close()
        return Size(width, height)
    } //readSize

} //DatabaseHandler