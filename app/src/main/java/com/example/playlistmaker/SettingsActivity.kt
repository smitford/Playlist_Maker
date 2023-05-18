package com.example.playlistmaker

import android.annotation.SuppressLint
import android.app.Application
import android.app.SearchManager
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.ShareCompat.IntentBuilder
import com.google.android.material.switchmaterial.SwitchMaterial



class SettingsActivity : AppCompatActivity() {


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)


        val shearButton = findViewById<ImageView>(R.id.shear_button)

        shearButton.setOnClickListener {
            val shearIntent = Intent(Intent.ACTION_SEND)
            shearIntent.data = Uri.parse("")
            shearIntent.type = "text/html"
            shearIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.shear_app))
            startActivity(shearIntent)

        }

        val supportButton = findViewById<ImageView>(R.id.support_button)
        supportButton.setOnClickListener {
            val supportIntent = Intent(Intent.ACTION_SEND)
            supportIntent.data = Uri.parse("mailto:")
            supportIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.student_mail)))
            supportIntent.putExtra(Intent.EXTRA_TITLE, getString(R.string.title_of_sup_mail))
            supportIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.text_of_sup_mail))
            startActivity(supportIntent)

        }
        val termsOfUseButton = findViewById<ImageView>(R.id.terms_of_use_button)
        termsOfUseButton.setOnClickListener {

            val termsOfUseIntent = Intent(Intent.ACTION_WEB_SEARCH)
            termsOfUseIntent.putExtra(SearchManager.QUERY, getString(R.string.term_of_use_web))
            startActivity(termsOfUseIntent)
        }
        val backButton = findViewById<Button>(R.id.back_button)
        backButton.setOnClickListener {
            this.finish()
        }

        val themeSwitcher = findViewById<SwitchMaterial>(R.id.themeSwitcher)

        themeSwitcher.isChecked = darkTheme


        themeSwitcher.setOnCheckedChangeListener { switcher, checked ->
            (applicationContext as App).switchTheme(checked)

        }


    }

}
