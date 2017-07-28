package com.example.kotlinnullability.ui

import android.support.v7.widget.*
import android.view.*
import com.example.kotlinnullability.*
import com.example.kotlinnullability.model.*
import kotlinx.android.synthetic.main.activity_main.view.*

/**
 * Adapter to show addresses
 */
class AddressAdapter: RecyclerView.Adapter<AddressViewHolder>() {

    var list: List<Address> = listOf()

    fun swapData(addresses: List<Address>) {
        list = addresses
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AddressViewHolder?, position: Int) {
        val address = list[position]
        holder?.bind(address)
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AddressViewHolder {
        // TODO fix this compile error
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_address, parent, false)
        return AddressViewHolder(itemView)
    }

}

class AddressViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(address: Address) {
        itemView.line1_text.text = address.line1
        itemView.line2_text.text = address.line2
        itemView.city_text.text = address.city
        itemView.state_text.text = address.state
        itemView.zipcode_text.text = address.zipcode
    }

}