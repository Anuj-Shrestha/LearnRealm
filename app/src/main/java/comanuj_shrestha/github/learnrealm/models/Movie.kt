package comanuj_shrestha.github.learnrealm.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by anuj on 8/4/17.
 */
open class Movie: RealmObject() {
    @PrimaryKey
    var id: String = ""
    var title: String = ""
    var genre: String = ""
    var description: String = ""
}