package com.example.clean.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.clean.BR
import com.example.clean.base.BaseFragment
import com.example.clean.binding.FragmentDataBindingComponent
import com.example.clean.databinding.FragmentMainBinding
import com.example.clean.util.autoCleared
import org.koin.android.ext.android.inject
import com.example.clean.R

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {
    companion object {
        fun newInstance() = MainFragment()
    }

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_main

    override val viewModel: MainViewModel by inject()

    private var mainAdapter by autoCleared<MainAdapter>()
    private var bindingComponent = FragmentDataBindingComponent(this)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewDataBinding.run {
            search.setOnClickListener {
                showSoftKeyboard(activity?.currentFocus?.windowToken, false)
                viewModel?.searchRepo()
            }
        }

        subscribeUI()
    }

    private fun subscribeUI() {
        val adapter = MainAdapter(bindingComponent) { item ->
            Toast.makeText(activity, item.name, Toast.LENGTH_SHORT).show()
        }

        this.mainAdapter = adapter

        viewDataBinding.listRepo.adapter = mainAdapter

        viewModel.data.observe(this, Observer {
            adapter.submitList(it)
        })


        viewModel.loading.observe(this, Observer { loading ->
            viewDataBinding.loading.visibility = if (loading) View.VISIBLE else View.GONE
        })
    }
}
