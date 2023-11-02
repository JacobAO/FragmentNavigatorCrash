package com.example.fragmentnavigatorcrash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setContent {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Column {
                    Text(
                        "Main Fragment",
                        style = MaterialTheme.typography.headlineLarge
                    )
                    TextButton(
                        onClick = {
                            findNavController().navigate(MainFragmentDirections.toOtherFragment())
                        },
                        modifier = Modifier.padding(top = 20.dp)
                    ) {
                        Text("Navigate to OtherFragment")
                    }
                }
            }
        }
    }
}