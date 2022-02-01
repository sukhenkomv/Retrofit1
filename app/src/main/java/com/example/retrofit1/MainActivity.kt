package com.example.retrofit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit1.Adapter.MyChannelAdapter
import com.example.retrofit1.Common.Common
import com.example.retrofit1.Interface.MyRetrofitServices
import com.example.retrofit1.Model.MReply

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class MainActivity : AppCompatActivity() {

    lateinit var mService: MyRetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: MyChannelAdapter
    lateinit var dialog: AlertDialog
    lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recyclerChannelList)

        mService = Common.myRetrofitService
        recycler.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recycler.layoutManager = layoutManager

//        var builder = AlertDialog.Builder(this)
//        builder.

        getChannelsList()
    }

    private fun getChannelsList() {
//        dialog.show()
        mService.getChannels().enqueue(object : Callback<MReply> {
            override fun onResponse(call: Call<MReply>, response: Response<MReply>) {
                adapter = MyChannelAdapter(baseContext, (response.body() as MReply).channels!!)
                adapter.notifyDataSetChanged()
                recycler.adapter = adapter
////                dialog.dismiss()
            }

            override fun onFailure(call: Call<MReply>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

}