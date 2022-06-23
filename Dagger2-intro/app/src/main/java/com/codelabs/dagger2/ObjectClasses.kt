package com.codelabs.dagger2

class Processor {
    override fun toString() = "Intel i5-10400"
}

class Motherboard {
    override fun toString() = "X7 3000"
}

class RAM {
    override fun toString() = "16 GB"
}

data class Computer(
    val processor: Processor,
    val motherboard: Motherboard,
    val ram: RAM
)