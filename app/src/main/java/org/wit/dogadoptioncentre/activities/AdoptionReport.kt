package org.wit.dogadoptioncentre.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import org.wit.dogadoptioncentre.R
import org.wit.dogadoptioncentre.adapters.AdoptionAdapters
import org.wit.dogadoptioncentre.databinding.ActivityAdoptionReportBinding
import org.wit.dogadoptioncentre.main.AdoptionXApp

class AdoptionReport : AppCompatActivity() {

    lateinit var app:   AdoptionXApp
    lateinit var reportLayout: ActivityAdoptionReportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       /* setContentView(R.layout.activity_adoption_report)*/
reportLayout = ActivityAdoptionReportBinding.inflate(layoutInflater)

setContentView(reportLayout.root)
        app = this.application as AdoptionXApp

        reportLayout.recyclerView.layoutManager = LinearLayoutManager(this)
        reportLayout.recyclerView.adapter = AdoptionAdapters(app.adoptionStore.findAll())





    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_report, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_adoption -> { startActivity(
                Intent(this,
                    DogAdoption::class.java)
            )
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }









}