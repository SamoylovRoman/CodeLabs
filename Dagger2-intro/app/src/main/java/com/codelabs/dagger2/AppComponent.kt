package com.codelabs.dagger2

import dagger.Component
import dagger.Module
import dagger.Provides


// create Dagger  component
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(activity: MainActivity)

    fun computer(): Computer
}

// create Dagger module
@Module
object AppModule {

    @Provides
    fun provideComputer(
        processor: Processor,
        motherboard: Motherboard,
        ram: RAM
    ): Computer {
        return Computer(
            processor = processor,
            motherboard=  motherboard,
            ram = ram
        )
    }

    @Provides
    fun provideProcessor(): Processor {
        return Processor()
    }

    @Provides
    fun provideMotherboard(): Motherboard {
        return Motherboard()
    }

    @Provides
    fun provideRam(): RAM {
        return RAM()
    }
}