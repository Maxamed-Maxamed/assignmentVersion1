package org.wit.dogadoptioncentre.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import org.wit.dogadoptioncentre.R
import org.wit.dogadoptioncentre.databinding.ActivityDogadoptioncentreBinding
import org.wit.dogadoptioncentre.main.AdoptionXApp
import org.wit.dogadoptioncentre.models.AdoptionModel
import timber.log.Timber

class DogAdoption : AppCompatActivity() {
        var adoption_models = AdoptionModel()
    lateinit var app : AdoptionXApp

    private lateinit var adoption_Layout : ActivityDogadoptioncentreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adoption_Layout = ActivityDogadoptioncentreBinding.inflate(layoutInflater)
        setContentView(adoption_Layout.root)
        app = this.application as AdoptionXApp

////        Timber.i("Total Adoption so far $adoption_Layout")
//
//        adoption_Layout.nameOfPet1.text.toString()
//        adoption_Layout.nameOfBreed2.text.toString()
//        adoption_Layout.nameOfLocation3.text.toString()

adoption_Layout.adoptionButton.setOnClickListener {

    adoption_models.dogName = adoption_Layout.nameOfPet1.text.toString()
    adoption_models.dogBreed = adoption_Layout.nameOfBreed2.text.toString()
   adoption_models.dogLocation = adoption_Layout.nameOfLocation3.text.toString()
    adoption_models.ratingbar = adoption_Layout.ratingBar.rating

    if (adoption_models.dogName.isEmpty()|| adoption_models.dogBreed.isEmpty() || adoption_models.dogLocation.isEmpty() || adoption_models.ratingbar.isInfinite() ) {
        Toast.makeText(applicationContext, R.string.text_field, Toast.LENGTH_SHORT).show()

    }

    else {
        adoption_models.dogName = adoption_Layout.nameOfPet1.text.toString()
        adoption_models.dogBreed = adoption_Layout.nameOfBreed2.text.toString()
        adoption_models.dogLocation = adoption_Layout.nameOfLocation3.text.toString()

        app.adoptionStore.create(AdoptionModel(id = adoption_models.id,dogName = adoption_models.dogName , dogBreed = adoption_models.dogBreed, dogLocation = adoption_models.dogLocation, ratingbar = adoption_models.ratingbar))
        Timber.i("it has been add up")

    }
}
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_adoption, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_ad_report -> { startActivity(Intent(this, AdoptionReport::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }





}