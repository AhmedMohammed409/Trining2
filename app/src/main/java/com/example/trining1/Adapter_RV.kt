package com.example.trining1

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter


class AdapterRV : Adapter<AdapterRV.ViewHolder>() {
    private var userList:MutableList<User> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(userList[position])

    }

    override fun getItemCount(): Int {
        return userList.size
    }


    class ViewHolder(itewView: View) : RecyclerView.ViewHolder(itewView) {
         private var imageView: ImageView = itewView.findViewById(R.id.img_item_userimage)
        private var textViewName: TextView = itewView.findViewById(R.id.txt_item_username)
        private var textviewMassage: TextView = itewView.findViewById(R.id.txt_item_massage)

        fun bind(itemOfData: User) {
            imageView.setImageResource(itemOfData.imageId)
            textViewName.text = itemOfData.name
            textviewMassage.text = itemOfData.massage
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(userList:MutableList<User>){
        this.userList= userList
        notifyDataSetChanged()

    }


}
/*//1-to action of itemRv

Implement interface //OnListItemclick				in Activity
addapter.onListItemClick=this	



var onListItemClick: OnListItemClick? = null //2-to action of itemRv
					in Adapter define at global


itemView.setOnClickListener {
    onListItemClick?.onItemclick(massage)	//3- to action of itemRv
															in fun bind at adapter	
}
			//4-add interface file to connection RV,Activity
interface OnListItemClick {
    fun onItemclick(massage: Massage)
}
*/