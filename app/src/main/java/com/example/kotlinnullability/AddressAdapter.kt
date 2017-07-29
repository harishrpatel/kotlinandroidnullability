package com.example.kotlinnullability.ui

import android.support.v7.widget.*
import android.view.*
import com.example.kotlinnullability.*
import com.example.kotlinnullability.model.*
import kotlinx.android.synthetic.main.activity_main.view.*

/**
 * Adapter to show addresses
 */
// FIXME Setup onItemSelected() (which is a higher order function) to be nullable.
// FIXME In case we don't care about click events. Note: This may be a trick question.
// FIXME Higher order functions make it easy with null checks because it forces caller to set lambda expression.
class AddressAdapter(val onItemSelected: (item: Address) -> Unit): RecyclerView.Adapter<AddressViewHolder>() {

    var list: List<Address> = listOf()

    fun swapData(addresses: List<Address>) {
        list = addresses
        notifyDataSetChanged()
    }

    // FIXME onBindViewHolder()'s holder is nullable, so we need to handle null check
    override fun onBindViewHolder(holder: AddressViewHolder?, position: Int) {
        val address = list[position]
        holder?.let {
            it.bind(address)
            it.itemView.setOnClickListener { onItemSelected(address) }
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): AddressViewHolder {
        // FIXME fix any compile errors as well as potential issues
        val itemView = LayoutInflater.from(parent?.context).inflate(R.layout.list_item_address, parent, false)
        return AddressViewHolder(itemView)
    }

}

class AddressViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(address: Address) {
        itemView.line1_text.text = address.line1
        with(itemView.line2_text) {
            // FIXME Write condition to hide line2_text field if data is null or empty
            text = address.line2
            visibility = if (address.line2?.isEmpty() ?: true) View.GONE else View.VISIBLE
        }
        itemView.city_text.text = address.city
        itemView.state_text.text = address.state
        itemView.zipcode_text.text = address.zipcode
    }

}