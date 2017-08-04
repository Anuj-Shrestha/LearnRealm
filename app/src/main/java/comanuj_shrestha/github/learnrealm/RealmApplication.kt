package comanuj_shrestha.github.learnrealm

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by anuj on 8/4/17.
 */
class RealmApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        //Configure Realm for the application
        val realmConfiguration = RealmConfiguration.Builder()
                .name("example.realm")
                .build()

        // Realm.deleteRealm(realmConfiguration) // Use this to delete realm

        // Make this default realm configuration
        Realm.setDefaultConfiguration(realmConfiguration)

    }
}