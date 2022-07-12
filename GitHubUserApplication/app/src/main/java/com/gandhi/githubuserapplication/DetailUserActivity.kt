package com.gandhi.githubuserapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.gandhi.githubuserapplication.databinding.ActivityDetailUserBinding
import com.gandhi.githubuserapplication.databinding.ActivityMainBinding

class DetailUserActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDetailUserBinding

    companion object {
        const val EXTRA_USER = "extra_user"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userData = intent.getParcelableExtra<User>(EXTRA_USER)

        Glide.with(this).load(userData?.Avatar).circleCrop().into(binding.imgUserDetail)
        binding.tvNameDetail.text = userData?.name
        binding.tvUsernameDetail.text = userData?.username
        binding.tvRepository.text = userData?.repository.toString()
        binding.tvFollower.text = userData?.follower.toString()
        binding.tvFollowing.text = userData?.following.toString()
        binding.tvCompanyDetail.text = userData?.company
        binding.tvLocationDetail.text = userData?.location

    }
}