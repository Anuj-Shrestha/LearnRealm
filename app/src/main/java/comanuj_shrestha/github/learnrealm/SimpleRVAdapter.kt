package comanuj_shrestha.github.learnrealm

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater



/**
 * Created by anuj on 8/7/17.
 */
class SimpleRVAdapter: RecyclerView.Adapter<SimpleViewHolder>() {
    private val movies = arrayOf("1", "2", "3")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.view_recyclerview_row, parent, false)
        return SimpleViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        holder.bindData(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}