package com.styleru.coursework

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DataBaseHelper(context:Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "students_db"

        const val TABLE_PERSON_TABLE_NAME = "persons"
        const val TABLE_PERSON_ID = "id"
        const val TABLE_PERSON_FIO = "fio"
        const val TABLE_PERSON_ADDRESS = "address"
        const val TABLE_PERSON_TYPE = "type"
        const val TABLE_PERSON_EMAIL = "email"
        private const val TABLE_PERSON_CREATE_TABLE = "create table $TABLE_PERSON_TABLE_NAME " +
                "($TABLE_PERSON_ID integer primary key autoincrement," +
                "$TABLE_PERSON_FIO text," +
                "$TABLE_PERSON_ADDRESS text," +
                "$TABLE_PERSON_TYPE text," +
                "$TABLE_PERSON_EMAIL text);"

        const val TABLE_TARIFF_TABLE_NAME = "tariffs"
        const val TABLE_TARIFF_ID = "id"
        const val TABLE_TARIFF_NAME= "name"
        const val TABLE_TARIFF_PRICE = "price"
        const val TABLE_TARIFF_BONUS = "bonus"
        private const val TABLE_TARIFF_CREATE_TABLE = "create table $TABLE_TARIFF_TABLE_NAME " +
                "($TABLE_TARIFF_ID integer primary key autoincrement," +
                "$TABLE_TARIFF_NAME text," +
                "$TABLE_TARIFF_PRICE text," +
                "$TABLE_TARIFF_BONUS text," +
                "$TABLE_PERSON_EMAIL text);"

        const val TABLE_ACCOUNT_TABLE_NAME = "accounts"
        const val TABLE_ACCOUNT_ID = "id"
        const val TABLE_ACCOUNT_NUMBER= "number"
        const val TABLE_ACCOUNT_BALANCE = "balance"
        const val TABLE_ACCOUNT_PAY_DATE = "pay_date"
        private const val TABLE_ACCOUNT_CREATE_TABLE = "create table $TABLE_ACCOUNT_TABLE_NAME " +
                "($TABLE_ACCOUNT_ID integer primary key autoincrement," +
                "$TABLE_ACCOUNT_NUMBER text," +
                "$TABLE_ACCOUNT_BALANCE text," +
                "$TABLE_ACCOUNT_PAY_DATE text);"

        const val TABLE_USER_TABLE_NAME = "users"
        const val TABLE_USER_ID = "id"
        const val TABLE_USER_ACCOUNT_ID = "id_account"
        const val TABLE_USER_TARIFF_ID = "id_tariff"
        const val TABLE_USER_PERSON_ID = "id_user"
        const val TABLE_USER_DATE = "date"
        const val TABLE_USER_TIME = "time"
        private const val TABLE_USER_CREATE_TABLE = "create table $TABLE_USER_TABLE_NAME " +
                "($TABLE_USER_ID integer primary key autoincrement," +
                "$TABLE_USER_ACCOUNT_ID integer, foreign key ($TABLE_USER_ACCOUNT_ID) references $TABLE_ACCOUNT_TABLE_NAME($TABLE_ACCOUNT_ID)" +
                "$TABLE_USER_TARIFF_ID integer, foreign key ($TABLE_USER_TARIFF_ID) references $TABLE_TARIFF_TABLE_NAME($TABLE_TARIFF_ID)" +
                "$TABLE_USER_PERSON_ID integer, foreign key ($TABLE_USER_PERSON_ID) references $TABLE_PERSON_TABLE_NAME($TABLE_PERSON_ID)" +
                "$TABLE_USER_DATE text," +
                "$TABLE_USER_TIME text);"


    }

    override fun onCreate(db: SQLiteDatabase?) {
        Log.d("myLogs", "DB created")
        db!!.execSQL(TABLE_PERSON_CREATE_TABLE)
        db.execSQL(TABLE_TARIFF_CREATE_TABLE)
        db.execSQL(TABLE_ACCOUNT_CREATE_TABLE)
        db.execSQL(TABLE_USER_CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}