package com.andan.recyclerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andan.recyclerdemo.databinding.ActivityUserDetailBinding

class UserDetail : AppCompatActivity() {
    private lateinit var binding: ActivityUserDetailBinding
    companion object {
        const val EXTRA_USER = "EXTRA_USER"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setTitle("Profile")

        val user = intent.getParcelableExtra<UserData>(EXTRA_USER) as UserData
        binding.tvName.text = user.name
        binding.tvCompany.text = user.company
        binding.tvFollower.text = user.follower
        binding.tvFollowing.text = user.following
        binding.tvUsername.text = user.username
        binding.tvLocation.text = user.location
        binding.imgAvatar.setImageResource(user.photo)
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}