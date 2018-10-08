package com.styleru.coursework

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: DataBaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DataBaseHelper(this)
        connectToDB()
    }

    private fun connectToDB(){
        val db = dbHelper.writableDatabase
        val c = db.query(DataBaseHelper.TABLE_PERSON_TABLE_NAME, null, null, null, null, null, null)
        c.close()
    }
}
