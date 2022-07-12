package com.gandhi.githubuserapplication

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gandhi.githubuserapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private  val list = ArrayList<User>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvList.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()

    }

    private val listUser: ArrayList<User>
    get() {
        val usernameData = resources.getStringArray(R.array.username)
        val nameData = resources.getStringArray(R.array.name)
        val avatarData = resources.obtainTypedArray(R.array.avatar)
        val followerData = resources.getStringArray(R.array.followers)
        val followingData = resources.getStringArray(R.array.following)
        val companyData = resources.getStringArray(R.array.company)
        val repositoryData = resources.getStringArray(R.array.repository)
        val locationData = resources.getStringArray(R.array.location)
        val listUser = ArrayList<User>()

        for (i in usernameData.indices) {
            val user = User(usernameData[i], nameData[i], avatarData.getResourceId(i , -1),
                followerData[i], followingData[i], companyData[i], repositoryData[i], locationData[i])
            listUser.add(user)
        }

        return listUser
    }

    private fun showRecyclerList() {
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rvList.layoutManager = GridLayoutManager(this , 2)
        } else {
            binding.rvList.layoutManager = LinearLayoutManager(this)
        }

        val listUserAdapter = UserListAdapter(list)
        binding.rvList.adapter = listUserAdapter

        listUserAdapter.setOnItemClickCallBack(object : UserListAdapter.OnItemClickCallback {
            override fun onItemClicked(data: User) {
                selectedUser(data)
            }
        })
    }

    private fun selectedUser( user : User) {
        val moveToDetail = Intent(this@MainActivity, DetailUserActivity::class.java)
        moveToDetail.putExtra(DetailUserActivity.EXTRA_USER, user)
        startActivity(moveToDetail)
    }


}