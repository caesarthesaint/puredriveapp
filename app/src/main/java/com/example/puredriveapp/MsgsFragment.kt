package com.example.puredriveapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MsgsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class MsgsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    //lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: MessageRecyclerAdapter
    lateinit var messageArrayList: ArrayList<Message>

    lateinit var title: Array<String>
    lateinit var detail: Array<String>
    lateinit var image: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_msgs, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MsgsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MsgsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializedata()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rvMessages)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MessageRecyclerAdapter(messageArrayList)
        recyclerView.adapter = adapter

    }

    private fun initializedata(){
        messageArrayList = arrayListOf<Message>()

        title =  arrayOf(
            "Eunice",
            "Yassi",
            "Brian",
            "Jam",
            "Jemma",
            "Geanne",
            "Fran",
            "Chanco",
            "Erika",
            "JV",
            "Chris",
            "James",
            "Jasper",
            "Stephen",
            "Helena"
        )

        detail = arrayOf(
            "Sample Message",
            "Sample Message",
            "Sample Message",
            "Sample Message",
            "Sample Message",
            "Sample Message",
            "Sample Message",
            "Sample Message",
            "Sample Message",
            "Sample Message",
            "Sample Message",
            "Sample Message",
            "Sample Message",
            "Sample Message",
            "Sample Message"
        )

        image = arrayOf(
            R.drawable.bitmap_ek1,
            R.drawable.bitmap_ek2,
            R.drawable.bitmap_ek3,
            R.drawable.bitmap_ek3,
            R.drawable.bitmap_ek3,
            R.drawable.bitmap_ek1,
            R.drawable.bitmap_ek2,
            R.drawable.bitmap_ek3,
            R.drawable.bitmap_ek3,
            R.drawable.bitmap_ek3,
            R.drawable.bitmap_ek1,
            R.drawable.bitmap_ek2,
            R.drawable.bitmap_ek3,
            R.drawable.bitmap_ek3,
            R.drawable.bitmap_ek3
        )

        for (i in title.indices){
            val messages = Message(title[i],detail[i],image[i])
            messageArrayList.add(messages)
        }
    }
}