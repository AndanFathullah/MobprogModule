package com.andan.recyclerdemo

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.andan.recyclerdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataPhoto: TypedArray
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private var users = arrayListOf<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepare()
        addItem()
        initRecylerview()
        listAdapter.submitList(users)
    }

    private fun initRecylerview() {
        binding.listRecyclerView.layoutManager = LinearLayoutManager(this)
        listAdapter = ListAdapter()
        binding.listRecyclerView.adapter = listAdapter
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.name)
        dataUsername = resources.getStringArray(R.array.username)
        dataFollower = resources.getStringArray(R.array.followers)
        dataFollowing = resources.getStringArray(R.array.following)
        dataCompany = resources.getStringArray(R.array.company)
        dataLocation = resources.getStringArray(R.array.location)
        dataPhoto = resources.obtainTypedArray(R.array.avatar)
    }

    private fun addItem() {
        for (position in dataName.indices) {
            val user = UserData(
                dataPhoto.getResourceId(position, -1),
                dataUsername[position],
                dataName[position],
                dataCompany[position],
                dataLocation[position],
                dataFollower[position],
                dataFollowing[position]
            )
            users.add(user)
        }
    }
}