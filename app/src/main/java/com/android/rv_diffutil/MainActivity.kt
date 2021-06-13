package com.android.rv_diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.os.postDelayed
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var userList : ArrayList<Users>
    private lateinit var rv : RecyclerView
    private lateinit var mainRecyclerAdapter : MainRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv = findViewById(R.id.rv)

        userList = ArrayList()
        createList()

        // set up adapter with list
        mainRecyclerAdapter = MainRecyclerAdapter()
        mainRecyclerAdapter.submitList(userList)

        // set up recycler view with adapter
        rv.layoutManager = LinearLayoutManager(this)
        rv.adapter = mainRecyclerAdapter

        executeDelayToRemoveLastListItem()
    }

    // this will remove last item in the list after 10 seconds
    private fun executeDelayToRemoveLastListItem() {
        Handler().postDelayed(10000L) {
            userList.removeAt(15)
            mainRecyclerAdapter.submitList(userList) }
    }

    // this will create dummy list of items
    private fun createList() {
        userList.add(Users(1, "John", "Doe", "M"))
        userList.add(Users(2, "Jane", "Rocks", "F"))
        userList.add(Users(3, "Jenny", "William", "F"))
        userList.add(Users(4, "Johnson", "Wills", "M"))
        userList.add(Users(5, "John", "Wick", "M"))
        userList.add(Users(6, "John", "Doe", "M"))
        userList.add(Users(7, "Jane", "Rocks", "F"))
        userList.add(Users(8, "Jenny", "William", "F"))
        userList.add(Users(9, "Johnson", "Wills", "M"))
        userList.add(Users(10, "John", "Wick", "M"))
        userList.add(Users(11, "John", "Doe", "M"))
        userList.add(Users(12, "Jane", "Rocks", "F"))
        userList.add(Users(13, "Jenny", "William", "F"))
        userList.add(Users(14, "Johnson", "Wills", "M"))
        userList.add(Users(15, "John", "Wick", "M"))
        userList.add(Users(16, "John", "Doe", "M"))
    }
}