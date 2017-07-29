package com.example.kotlinnullability

import android.content.*
import android.os.*
import android.support.v7.app.*
import android.support.v7.widget.*
import android.util.*
import com.example.kotlinnullability.model.*
import com.example.kotlinnullability.ui.*
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Shows 100 addresses in a list and allows user to select one and display it at top.
 */
class MainActivity : AppCompatActivity() {

    // FIXME make Address.line2 nullable assuming that some addresses will not provide it
    val address = Address("100 Main St", null, "Dallas", "TX", "75000")
    lateinit var adapter: AddressAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        populateViews()
    }

    private fun populateViews() {
        // address fields
        populateSelectedAddress(address)

        setupRecyclerView(this)
    }

    private fun populateSelectedAddress(address: Address) {
        // FIXME we don't need to handle nullability here
        line1_text.text = address.line1!!
        line2_text.text = address.line2
        city_text.text = address.city
        state_text.text = address.state
        zipcode_text.text = address.zipcode
    }

    private fun setupRecyclerView(context: Context?) {
        // FIXME To avoid potential lifecycle crashes:
        // FIXME Note that we are not checking context if its null.
        // FIXME These kinds of checks are needed especially when a Fragment tries to access Context by calling getActivity().
        // FIXME Wrap these next few lines in let { } block with null check.
        Log.d(TAG, "initializing recycler view")
        recycler_view.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        recycler_view.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        adapter = setupRecyclerAdapter()
        recycler_view.adapter = adapter
    }

    private fun setupRecyclerAdapter(): AddressAdapter {
        // FIXME Complete the constructor arguments so that it builds.
        // FIXME Basically when user clicks an item from the list, we want to call populateSelectedAddress(address) method.
        // FIXME Hint: Think Higher Order Functions / Lambda Expressions.
        adapter = AddressAdapter()
        val addresses = mutableListOf<Address>()
        // FIXME fix crash here. HINT: It is not a (NPE) null pointer exception.
        // FIXME This was done to illustrate that Kotlin helps with NPEs, but we still have to handle other exceptions.
        (1..100).forEach { i ->
            val copyAddress = address.copy(
                    line1 = address.line1.replace("100", (i+100).toString()),
                    zipcode = address.zipcode.replace("75000", (i+75000).toString())
            )
            addresses[i] = copyAddress
        }

        adapter.swapData(addresses)
        return adapter
    }

    override fun onResume() {
        super.onResume()
        edit_button.setOnClickListener {  }
    }

    companion object {
        // FIXME fix the compiler warning
        val TAG = MainActivity::class.java.simpleName
    }
}

