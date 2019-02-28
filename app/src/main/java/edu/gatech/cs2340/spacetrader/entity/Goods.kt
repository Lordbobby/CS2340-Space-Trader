package edu.gatech.cs2340.spacetrader.entity

enum class Goods(val MTLP: Int, val MTLU: Int, val TTP: Int, val basePrice: Int,
                 val IPL: Int, val Var: Int, val IE: String, val CR: String,
                 val ER: String, val MTL: Int, val MTH: Int) {
    Water(0, 0, 2, 30, 3, 4, "DROUGHT", "LOTSOFWATER", "DESERT", 30, 50),
    Furs(0, 0, 0, 250, 10, 10, "COLD", "RICHFAUNA", "LIFELESS", 230, 280),
    Food(1, 0, 1, 100, 5, 5, "CROPFAIL", "RICHSOIL", "POORSOIL", 90, 160),
    Ore(2, 2, 3, 350, 20, 10, "WAR", "MINERALRICH", "MINERALPOOR", 350, 420),
    Games(3, 1, 6, 250, -10, 5, "BOREDOM", "ARTISTIC", "Never", 160, 270),
    Firearms(3, 1, 5, 1250, -75, 100, "WAR", "WARLIKE", "Never", 600, 1100),
    Medicine(4, 1, 6, 650, -20, 10, "PLAGUE", "LOTSOFHERBS", "Never", 400, 700),
    Machines(4, 3, 5, 900, -30, 5, "LACKOFWORKERS", "Never", "Never", 600, 800),
    Narcotics(5, 0, 5, 3500, -125, 150, "BOREDOM", "WEIRDMUSHROOMS", "Never", 2000, 3000),
    Robots (6, 4, 7, 5000, -150, 100, "LACKOFWORKERS", "Never", "Never", 3500, 3500);
}