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
 * TODO: Fix line2 nullability
 *
 */
class MainActivity : AppCompatActivity() {

    val address = Address("100 Main St", /*null*/ "Apt # 10A", "Dallas", "TX", "75000")
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
        line1_text.text = address.line1!!
        line2_text.text = address.line2
        city_text.text = address.city
        state_text.text = address.state
        zipcode_text.text = address.zipcode

        // TODO do this so that it does not crash
        val ctx: Context? = this

        ctx?.let { abc ->
            Log.d(TAG, "initializing recycler view")
            recycler_view.layoutManager = LinearLayoutManager(abc!!, RecyclerView.VERTICAL, false)
            recycler_view.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
            adapter = setupRecyclerAdapter()
            recycler_view.adapter = adapter
        } ?: throw Exception("null context")
    }

    private fun setupRecyclerAdapter(): AddressAdapter {
        adapter = AddressAdapter()
        val addresses = mutableListOf<Address>()
        // TODO fix crash here. HINT: It is not a (NPE) null pointer exception.
        // TODO This was done to illustrate that Kotlin helps with NPEs, but we still have to handle other exceptions.
        (1..100).forEach { i ->
            val copyAddress = address.copy(
                    line1 = address.line1.replace("100", (i+100).toString()),
                    zipcode = address.zipcode.replace("75000", (i+75000).toString())
            )
            addresses.add(copyAddress)
        }

        adapter.swapData(addresses)
        return adapter
    }

    override fun onResume() {
        super.onResume()
        edit_button.setOnClickListener {  }
    }

    companion object {
        // TODO fix the compiler warning
        val TAG = MainActivity::class.java.simpleName
    }
}

