package com.example.trining1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.trining1.databinding.FragmentListBinding


class ListFragment : Fragment() {
    private lateinit var binding: FragmentListBinding
    private lateinit var userList: MutableList<User>
    private val adapterRv:AdapterRV by lazy {
        AdapterRV()
    }
    var name:String?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=FragmentListBinding.inflate(inflater,container,false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       name= arguments?.getString("userName")
        binding.RV.adapter=adapterRv
        Toast.makeText(context,name,Toast.LENGTH_LONG).show()
        binding.btnAdd.setOnClickListener {
            userList.add(
                User(name.toString(),
                    binding.etAddmassage.text.toString(),
                    R.drawable.imgelogin))
            adapterRv.setList(userList)
            binding.etAddmassage.text.clear()
        }


    }

    }
