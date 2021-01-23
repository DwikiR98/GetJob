package com.example.getjob

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val list = ArrayList<Worker>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_Job.setHasFixedSize(true)

        list.addAll(getListWorker())
        showRecyclerList()
    }

    fun getListWorker(): ArrayList<Worker>{
        val dataName = resources.getStringArray(R.array.Data_Name)
        val dataTalent = resources.getStringArray(R.array.Data_Talent)
        val dataDescription = resources.getStringArray(R.array.Data_Description)
        val dataPhoto = resources.getStringArray(R.array.Photo)

        val listWorker = ArrayList<Worker>()
        for (position in dataTalent.indices){
            val worker = Worker(
                dataName[position],
                dataTalent[position],
                dataDescription[position],
                dataPhoto[position],
            )
            listWorker.add(worker)
        }
        return listWorker
    }

    private fun showRecyclerList(){
        rv_Job.layoutManager = LinearLayoutManager(this)
        val listWorkerAdapter = ListWorkerAdapter(list)
        rv_Job.adapter = listWorkerAdapter
    }

    fun logout(view: View?) {
        FirebaseAuth.getInstance().signOut()
        startActivity(Intent(applicationContext, Login::class.java))
        finish()
    }
}