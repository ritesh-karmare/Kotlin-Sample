package com.example.featurearch.vm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.featurearch.R
import com.example.featurearch.databinding.ActivityVmdemoBinding


class VMDemoActivity : AppCompatActivity() {

    // Activity to demonstrate use of viewModel, dataBinding and liveData
    // ViewModel : ViewModelDemo.class

    lateinit var dataBinding: ActivityVmdemoBinding
    lateinit var viewModelDemo: ViewModelDemo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataBinding()
        setUpObserver()
    }

    private fun initDataBinding() {
        // Obtain the ViewModel component
        viewModelDemo = ViewModelProviders.of(this).get(ViewModelDemo::class.java)

        // Inflate view and obtain an instance of the binding class.
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_vmdemo)

        // Assign the component to a property in the binding class.
        dataBinding.viewModel = viewModelDemo

        // Specify the current activity as the lifecycle owner.
       dataBinding.lifecycleOwner = this
    }

    private fun setUpObserver() {
        // Set up the observer which updates the UI.
        viewModelDemo.getCounterValue().observe(this, Observer {
            // Update the UI, in this case, a TextView.
            dataBinding.tvCount.text = "${it}"
        })
    }

}
