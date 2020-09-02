package com.alankurniadi.quotesappapi.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.alankurniadi.quotesappapi.R
import kotlinx.android.synthetic.main.fragment_detail_eng.*

class DetailEngFragment : Fragment() {

    companion object {
        const val EXTRA_ID_ENG = "extra_id_eng"
    }
    private lateinit var detailViewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_eng, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailViewModel = DetailViewModel()
        if (arguments != null) {
            val id = arguments?.getString(EXTRA_ID_ENG)
            if (id != null) {
                progress_detail_eng.visibility = View.VISIBLE
                detailViewModel.setDetailQuotes(id)
                detailViewModel.data.observe(viewLifecycleOwner, Observer {
                    progress_detail_eng.visibility = View.GONE
                    if (it != null) {
                        tv_quotes_detail_eng.text = it.en
                        tv_author_detail_eng.text = it.author
                    }else {
                        tv_quotes_detail_eng.text = getString(R.string.data_kosong)
                        tv_author_detail_eng.text = getString(R.string.data_kosong)
                    }
                })
            }
        }
    }

}