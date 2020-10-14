package com.ericknavarro.restaurantapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ericknavarro.restaurantapp.R
import com.ericknavarro.restaurantapp.adapter.RecyclerAdapter
import com.ericknavarro.restaurantapp.model.Card

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = root.findViewById(R.id.recycler_view)
        adapter = RecyclerAdapter(root.context)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(root.context)

        /*val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/

        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val card = Card("Shizen Restaurant & Bar", R.drawable.burger)
        val card2 = Card("Beef 'n' Pepper", R.drawable.hotcakes)
        val card1 = Card("Soul Kitchen", R.drawable.hotdog)
        val card3 = Card("Enoteka Warszawsky", R.drawable.pizza)

        adapter.setCards(arrayListOf(card, card2, card1, card3))
        /*homeViewModel.allNotes.observe(viewLifecycleOwner, Observer { card ->
            card?.let { adapter.setCards(card) }
        })*/



    }
}