package ru.lemaitre.result

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class SuccessFragment : Fragment() {

    val args by navArgs<SuccessFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.fragment_success, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val title = view.findViewById<TextView>(R.id.title)
        val description = view.findViewById<TextView>(R.id.descriptions)
        val button = view.findViewById<Button>(R.id.button)

        title.apply {
            args.title?.let { this.text = it }
        }

        description.apply {
            args.descriptions?.let { this.text = it }
        }

        button.apply {
            args.button?.let { this.text = it }
            setOnClickListener {
                if (args.isAutoClose) {
                    findNavController().popBackStack()
                }
                setFragmentResult(REQUEST, bundleOf())
            }
        }

    }

    companion object {
        const val REQUEST = "request"
    }
}