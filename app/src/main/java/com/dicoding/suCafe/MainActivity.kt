package com.dicoding.sucafe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCafe: RecyclerView
    private val list = ArrayList<Cafe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvCafe = findViewById(R.id.rv_cafe)
        rvCafe.setHasFixedSize(true)

        list.addAll(getListCafe())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                startActivity(Intent(this, AboutActivity::class.java))
                true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListCafe(): ArrayList<Cafe> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataAddress = resources.getStringArray(R.array.data_address)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataHour = resources.getStringArray(R.array.data_hour)
        val dataLocation = resources.getStringArray(R.array.data_location)
        val listCafe = ArrayList<Cafe>()
        for (i in dataName.indices) {
            val cafe = Cafe(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataAddress[i], dataPrice[i], dataHour[i], dataLocation[i])
            listCafe.add(cafe)
        }
        return listCafe
    }

    private fun showRecyclerList() {
        rvCafe.layoutManager = LinearLayoutManager(this)
        val ListCafeAdapter = ListCafeAdapter(list)
        rvCafe.adapter = ListCafeAdapter

        ListCafeAdapter.setOnItemClickCallback(object : ListCafeAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Cafe) {
                val intentToDetail = Intent(this@MainActivity, DetailActivity::class.java)
                intentToDetail.putExtra("DATA", data)
                startActivity(intentToDetail)
            }
        })
    }
}