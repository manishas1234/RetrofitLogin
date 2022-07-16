package com.example.retrofitlogin

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

class LoginAdd : Fragment() {
    private lateinit var viewModel: ViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_login_add, container, false)
        val text=view.findViewById<TextView>(R.id.textViewRegister)
        text.setOnClickListener{Navigation.findNavController(view).navigate(R.id.action_loginAdd_to_loginAdding)}
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        viewModel.getPosts()
        val email = "kiosk_app@yopmail.com"
        val pass =  "!1parklinq"
        viewModel.pushPosts(email,pass)
        viewModel.mypushresponse.observe(viewLifecycleOwner, Observer {
            response ->

            if (response.isSuccessful)
            {
                Log.d("response", response.code().toString())
                Log.d("response", response.body().toString())
                Log.d("response", response.message().toString())
               // Log.d("response", )



            }
            else
            {
                Log.d("response", response.code().toString())
                Log.d("response", response.message().toString())
                //Log.d("response", response.body().toString())



            }
        })



        return view
    }


}