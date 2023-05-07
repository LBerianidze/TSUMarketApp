package com.example.tsumarketapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tsumarketapp.data.Product
import com.example.tsumarketapp.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment : Fragment() {

    private lateinit var binding: FragmentProductDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemName: String = requireArguments().getString("itemName").toString()
        val itemDescription: String = requireArguments().getString("itemDescription").toString()
        val itemPrice: Double = requireArguments().getDouble("itemPrice")

        binding.itemName.text = itemName
        binding.itemDescription.text = itemDescription
        binding.itemPrice.text = "${itemPrice} ₾"

        binding.buyButton.setOnClickListener {
            Toast.makeText(requireContext(), "Item bought", Toast.LENGTH_LONG).show();
        }
    }
}