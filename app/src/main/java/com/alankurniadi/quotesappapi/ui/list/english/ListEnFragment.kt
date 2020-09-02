package com.alankurniadi.quotesappapi.ui.list.english

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.alankurniadi.quotesappapi.R
import com.alankurniadi.quotesappapi.model.ListEnglish
import com.alankurniadi.quotesappapi.ui.detail.DetailEngFragment
import com.alankurniadi.quotesappapi.ui.detail.DetailFragment
import kotlinx.android.synthetic.main.fragment_list__en_.*


class ListEnFragment : Fragment() {

    private lateinit var listEngViewModel: ListEngViewModel
    private lateinit var engAdapter: EngAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list__en_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        engAdapter = EngAdapter()
        listEngViewModel = ListEngViewModel()
        progress_en.visibility = View.VISIBLE
        listEngViewModel.setListEngQuotes()
        listEngViewModel.data.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                progress_en.visibility = View.GONE
                engAdapter.setData(it)

                showRecyclerView()
            }
        })

    }

    private fun showRecyclerView() {
        rv_eng.layoutManager = LinearLayoutManager(context)
        rv_eng.adapter = engAdapter

        engAdapter.setOnItemClickCallback(object : EngAdapter.OnItemClickCallback {
            override fun onItemClicked(data: ListEnglish) {
                val mDetailFragment = DetailEngFragment()
                val bundle = Bundle()
                bundle.putString(DetailEngFragment.EXTRA_ID_ENG, data.id)
                mDetailFragment.arguments = bundle

                val mFragmentManager = fragmentManager
                mFragmentManager?.beginTransaction()?.apply {
                    replace(R.id.frame_container, mDetailFragment, DetailEngFragment::class.java.simpleName)
                    addToBackStack(null)
                    commit()
                }
            }

        })
    }
}