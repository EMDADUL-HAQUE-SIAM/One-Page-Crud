package com.simec.mealmanager

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView


class ProductAdapter(
    private var list: List<Product>,
    private var onItemClickListener: OnItemClickListener
): RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = list[position]
        holder.bindItem(item)
        holder.itemView.setOnClickListener {
            onItemClickListener.onClick(item, position)
        }
        holder.itemView.findViewById<Button>(R.id.delete).setOnClickListener {
            onItemClickListener.onDelete(item, position)
        }
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickListener {
        fun onClick(item: Product, position: Int)
        fun onDelete(item: Product, position: Int)
    }

}