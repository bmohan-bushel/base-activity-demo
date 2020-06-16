package com.bushel.bmohan.baseactivitydemo.di

import android.app.Application
import com.bushel.bmohan.baseactivitydemo.BaseActivityDemoApp
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<BaseActivityDemoApp> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: BaseActivityDemoApp): Builder

        fun build(): AppComponent
    }

    override fun inject(instance: BaseActivityDemoApp)
}

@Module
abstract class AppModule {
    @Singleton
    @Binds
    abstract fun provideApp(app: BaseActivityDemoApp): Application
}