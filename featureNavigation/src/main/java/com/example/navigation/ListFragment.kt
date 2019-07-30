package com.example.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.navigation.model.UserData
import kotlinx.android.synthetic.main.fragment_list.*


/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailButton.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToDetailFragment(UserData("Ritesh", 25, "ritesh@gmail.com"))

            Navigation
                .findNavController(activity!!, R.id.my_nav_host_fragment)
                .navigate(action)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }
}
