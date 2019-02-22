package edu.gatech.cs2340.spacetrader.generators

interface GenerationProvider<T> {
    fun provideGenerator(): Generator<T>
}