package com.ligacalculus.trufalse

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ligacalculus.trufalse.databinding.ListItemBinding

class MyAdapter(var context: Context): RecyclerView.Adapter<MyAdapter.Companion.MyHolder>() {

    var data = mutableListOf<String>()

    init {
        data = context.getSharedPreferences("prefs",Context.MODE_PRIVATE).getStringSet("ans",HashSet<String>())!!.toMutableList()
    }
    fun deleteAll() {
        data.clear()
        context.getSharedPreferences("prefs",Context.MODE_PRIVATE).edit().putStringSet("ans",HashSet<String>()).apply()
        notifyDataSetChanged()
    }

    companion object {
        class MyHolder(var binding:ListItemBinding): RecyclerView.ViewHolder(binding.root) {
            fun bind(s:String) {
                binding.textView5.text = s
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
       return MyHolder(ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
       holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}