package fr.benguiza.fizzbuzz.app

import android.app.Application
import fr.benguiza.commons.tools.Logger
import fr.benguiza.fizzbuzz.BuildConfig
import fr.benguiza.fizzbuzz.di.DaggerTAppComponent
import fr.benguiza.fizzbuzz.di.modules.UseCasesModule
import fr.benguiza.fizzbuzz.di.modules.ViewModelsModule
import fr.benguiza.fizzbuzz.tools.LoggerDelegate
import fr.benguiza.presentationlayer.di.AppComponent
import timber.log.Timber

class FizzBuzzApplication : Application(), AppComponent {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initLogger()
        initDaggerGraph()
    }

    /* ------------------------------------- */
    /*             AppComponent              */
    /* ------------------------------------- */

    override fun fragmentsComponent() = appComponent.fragmentsComponent()
    override fun activitiesComponent() = appComponent.activitiesComponent()


    private fun initDaggerGraph() {
        appComponent = DaggerTAppComponent.builder().
        viewModelsModule(ViewModelsModule())
            .useCasesModule(UseCasesModule())
            .build()
    }

    private fun initLogger() {
        if (BuildConfig.LOG_ENABLE) {
            Timber.plant(Timber.DebugTree())
        }
        Logger.use(LoggerDelegate())
    }

}