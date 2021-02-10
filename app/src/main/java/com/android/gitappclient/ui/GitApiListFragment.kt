package com.android.gitappclient.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.gitappclient.R
import com.android.gitappclient.api.Result
import com.android.gitappclient.databinding.FragmentGitApiBinding
import com.android.gitappclient.utility.exhaustive
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GitApiListFragment : Fragment(R.layout.fragment_git_api) {
    private val viewModel: GitApiVm by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentGitApiBinding.bind(view)
        val adapter = GitApiListAdapter()
        binding.apply {
            recyclerViewGitApi.adapter = adapter
            recyclerViewGitApi.layoutManager = LinearLayoutManager(requireContext())
        }
        viewModel.getRepositoriesList().observe(viewLifecycleOwner) {
            when (it) {
                is Result.Loading -> {
                }
                is Result.Success -> {
                    val repositoriesModel = it.data
                    adapter.submitList(repositoriesModel)

                }
                is Result.Fail -> {
                    println("===Fail")

                }
                is Result.Exception -> {
                    println("===Exception")

                }
            }.exhaustive
        }
    }
}