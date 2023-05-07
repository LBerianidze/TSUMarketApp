package com.example.tsumarketapp.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tsumarketapp.ProductDetailsFragment
import com.example.tsumarketapp.R
import com.example.tsumarketapp.data.Product

class ProductListAdapter(
    private val fragmentManager: FragmentManager,
    private val itemList: List<Product>
) :
    RecyclerView.Adapter<ProductListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.product_name)
        val priceTextView: TextView = itemView.findViewById(R.id.product_price)
        val viewProductButton: TextView = itemView.findViewById(R.id.view_product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.nameTextView.text = item.name
        holder.priceTextView.text = item.price.toString() + " ₾"
        holder.viewProductButton.setOnClickListener {
            val itemDetailsFragment = ProductDetailsFragment()

            val args = Bundle()
            args.putString("itemName", item.name)
            args.putString("itemDescription", item.description)
            args.putDouble("itemPrice", item.price)
            itemDetailsFragment.arguments = args

            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, itemDetailsFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }

    override fun getItemCount() = itemList.size
}