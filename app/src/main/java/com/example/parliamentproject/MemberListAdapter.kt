package com.example.parliamentproject

import MemberOfParliament
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import java.util.Calendar.YEAR


/**
 * RecyclerView.Adapter subclass which is utilized in the RecyclerView of MemberListFragment.
 * It displays the found members of parliament in a clear and stylish list, containing their first and last name,
 * age, party and minister status.
 */
class MemberListAdapter(private val membersList: List<MemberOfParliament>):
    RecyclerView.Adapter<MemberListAdapter.MemberListViewHolder>() {

    /**
     * This function is called everytime a new row is created on the RecyclerView, and
     * is responsible for the creation of the RecyclerView rows.
      */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberListViewHolder {

        // Getting the View object from the parent ViewGroup, in this case MainActivity
        val view = LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)

        return MemberListViewHolder(view)
    }


    /**
     * This function is called repeatedly when scrolling or updating the RecyclerView with new data, and
     *  is essentially used for setting the correct data into the RecycleView rows.
     */
    override fun onBindViewHolder(holder: MemberListViewHolder, position: Int) {
        val currentItem = membersList[position]

      //  holder.image.setImageResource(currentItem.picture) // TODO: Add image of party logic
        holder.memberName.text = "${currentItem.first} ${currentItem.last}"
        holder.memberStatusInfo.text = "Age: ${Calendar.getInstance().get(YEAR) - currentItem.bornYear}, " +
                "${currentItem.party}, ${if (currentItem.minister) "minister" else ""}"


    }

    /**
     * This function is used for getting the size of the current list.
     */
    override fun getItemCount() = membersList.size


    // TODO: Create function which returns what party icon will be used based on the member's party.
    fun GetPartyIcon(member: MemberOfParliament) {
        // create when expression for selecting corresponding party icon.


    }


    class MemberListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.imageView)
        val memberName: TextView = view.findViewById(R.id.member_name)
        val memberStatusInfo: TextView = view.findViewById(R.id.member_statusInfo)
    }

}