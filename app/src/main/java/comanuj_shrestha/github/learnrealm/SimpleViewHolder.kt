package comanuj_shrestha.github.learnrealm

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * Created by anuj on 8/7/17.
 */
class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var textView: TextView

    init {
        textView = itemView.findViewById<View>(R.id.textview_item) as TextView
    }

    fun  bindData(movie: String) {
        textView.text = movie
    }

}

//internal class SimpleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//
//    var textView: TextView
//
//    init {
//        textView = itemView.findViewById<View>(R.id.textView) as TextView
//    }
//
//    fun bindData(data: String) {
//        textView.text = data
//    }
//}