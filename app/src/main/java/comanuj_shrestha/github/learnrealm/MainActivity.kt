package comanuj_shrestha.github.learnrealm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import comanuj_shrestha.github.learnrealm.models.Movie
import io.realm.Realm
import java.util.UUID.randomUUID
import comanuj_shrestha.github.learnrealm.models.Task
import java.util.*
import io.realm.RealmResults
import android.util.Log


class MainActivity : AppCompatActivity() {
    private var realm: Realm? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        realm = Realm.getDefaultInstance();

        realm!!.executeTransaction(Realm.Transaction { realm ->
            var t = realm.createObject(Task::class.java, UUID.randomUUID().toString())
            t.title = "Goodbye"
            t.description = "This is a description"
        })

        realm!!.executeTransaction(Realm.Transaction { realm ->
            var movie = realm.createObject(Movie::class.java, "1")
            movie.title = "The Hulk"
            movie.genre = "Action"
            movie.description = "Hulk fights against bruce banner"
        })

        val tasks = realm!!.where(Task::class.java)
                .contains("title", "Goodbye")
                .findAll()
        val movies = realm!!.where(Movie::class.java).findAll();

        for (t in tasks) {
            Log.d("Realm task id", t.id)
            Log.d("Realm task", t.title)
        }

        for (m in movies) {
            Log.d("Realm movies id", m.id)
            Log.d("Realm movies", m.title)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm?.close()
    }
}
