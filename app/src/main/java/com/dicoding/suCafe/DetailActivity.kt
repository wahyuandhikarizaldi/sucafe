package com.dicoding.sucafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailActivity : AppCompatActivity() {
        private lateinit var tvName: TextView
        private lateinit var tvDescription: TextView
        private lateinit var imgPhoto: ImageView
        private lateinit var tvAddress: TextView
        private lateinit var tvPrice: TextView
        private lateinit var tvHour: TextView
        private lateinit var btShare: Button

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                        android.R.id.home -> {
                                onBackPressed()
                                return true
                        }
                }
                return super.onOptionsItemSelected(item)
        }

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_detail)

                supportActionBar?.setDisplayHomeAsUpEnabled(true)

                tvName = findViewById(R.id.tv_item_name)
                tvDescription = findViewById(R.id.tv_item_description)
                imgPhoto = findViewById(R.id.img_item_photo)
                tvAddress = findViewById(R.id.tv_item_address)
                tvPrice = findViewById(R.id.tv_item_price)
                tvHour = findViewById(R.id.tv_item_hour)
                btShare = findViewById(R.id.action_share)

                val cafe = intent.getParcelableExtra<Cafe>("DATA")

                cafe?.let {
                        tvName.text = it.name
                        tvDescription.text = it.description
                        imgPhoto.setImageResource(it.photo)
                        tvAddress.text = it.address
                        tvPrice.text = it.price
                        tvHour.text = it.hour

                        btShare.setOnClickListener{
                                val intent = Intent(Intent.ACTION_SEND)
                                intent.type = "text/plain"
                                intent.putExtra(Intent.EXTRA_TEXT, cafe?.location)
                                val chooser = Intent.createChooser(intent, "Share to")
                                startActivity(chooser)
                        }
                }
        }
}