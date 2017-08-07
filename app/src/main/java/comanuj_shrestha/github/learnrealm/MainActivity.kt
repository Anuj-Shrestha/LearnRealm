package comanuj_shrestha.github.learnrealm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import comanuj_shrestha.github.learnrealm.models.Movie
import io.realm.Realm
import java.util.UUID.randomUUID
import comanuj_shrestha.github.learnrealm.models.Task
import java.util.*
import io.realm.RealmResults
import android.util.Log
import android.widget.LinearLayout
import android.support.v7.widget.GridLayoutManager




class MainActivity : AppCompatActivity() {
    private var realm: Realm? = null
    private var recyclerView: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        realm = Realm.getDefaultInstance();

        realm!!.executeTransaction(Realm.Transaction { realm ->
            var t = realm.createObject(Task::class.java, randomUUID().toString())
            t.title = "Goodbye"
            t.description = "This is a description"
        })
        var movie = Movie()
        movie.id = "1"
        movie.title = "The Hulk"
        movie.genre = "Action"
        movie.description = "Hulk fights against bruce banner"
        realm!!.executeTransaction(Realm.Transaction { realm -> realm.insertOrUpdate(movie)
        })


        val movies = realm!!.where(Movie::class.java).findAll();

        for (m in movies) {
            Log.d("Realm movies id", m.id)
            Log.d("Realm movies", m.title)
        }

        recyclerView = findViewById(R.id.recyclerview_movies)
        recyclerView!!.setLayoutManager(LinearLayoutManager(this));
        recyclerView!!.setAdapter(SimpleRVAdapter())

    }

    override fun onDestroy() {
        super.onDestroy()
        realm?.close()
    }
}
