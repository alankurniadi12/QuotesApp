package com.alankurniadi.quotesappapi.ui.list.bosnia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alankurniadi.quotesappapi.R
import kotlinx.android.synthetic.main.fragment_list_bos.*

class ListBosFragment : Fragment() {

    private lateinit var bosAdapter: BosAdapter
    private lateinit var listBosViewModel: ListBosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_bos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bosAdapter = BosAdapter()
        listBosViewModel = ListBosViewModel()
        progress_bos.visibility = View.VISIBLE
        listBosViewModel.setListBosQuotes()
        listBosViewModel.data.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                progress_bos.visibility = View.GONE
                bosAdapter.setData(it)
                rv_bos.layoutManager = LinearLayoutManager(context)
                rv_bos.adapter = bosAdapter
            }
        })


    }
}