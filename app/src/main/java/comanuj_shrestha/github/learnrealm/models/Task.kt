package comanuj_shrestha.github.learnrealm.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by anuj on 8/4/17.
 */
open class Task: RealmObject() {
    @PrimaryKey var id: String = "";
    var title: String = "";
    var description: String = "";
}