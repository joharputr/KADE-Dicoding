package com.example.ankolayout.Favorite.AnkoSqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.example.ankolayout.Helper.Constant
import com.example.ankolayout.Helper.Constant.TABLE_FAV_NEXT
import com.example.ankolayout.Helper.Constant.TABLE_FAV_PREV
import org.jetbrains.anko.db.*

class SqlLiteOpenHelper(context: Context) :
    ManagedSQLiteOpenHelper(context, "FavoriteMatch.db", null, 1) {

    companion object {
        private var instance: SqlLiteOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): SqlLiteOpenHelper {
            if (instance == null) {
                instance = SqlLiteOpenHelper(ctx.applicationContext)
            }
            return instance as SqlLiteOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {

        val queryNext =
            "CREATE TABLE IF NOT EXISTS ${TABLE_FAV_NEXT} (${Constant.ID} INTEGER PRIMARY KEY AUTOINCREMENT,${Constant.EVENT_ID} TEXT,${Constant.HOME_TEAM_NAME} TEXT,${Constant.AWAY_TEAM_NAME} TEXT,${Constant.HOME_SCORE} TEXT,${Constant.AWAY_SCORE} TEXT)"
        val queryPrev =
            "CREATE TABLE IF NOT EXISTS ${TABLE_FAV_PREV} (${Constant.ID} INTEGER PRIMARY KEY AUTOINCREMENT,${Constant.EVENT_ID} TEXT,${Constant.HOME_TEAM_NAME} TEXT,${Constant.AWAY_TEAM_NAME} TEXT,${Constant.HOME_SCORE} TEXT,${Constant.AWAY_SCORE} TEXT)"


        val dbNext = db?.createTable(
            TABLE_FAV_NEXT, true,
            Constant.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            Constant.EVENT_ID to TEXT + UNIQUE,
            Constant.HOME_TEAM_NAME to TEXT,
            Constant.AWAY_TEAM_NAME to TEXT,
            Constant.HOME_SCORE to TEXT,
            Constant.AWAY_SCORE to TEXT
        )

        db?.execSQL(queryNext)
        db?.execSQL(queryPrev)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        //    db?.dropTable(TABLE_FAV_NEXT, true)
        val deleteNext = "DROP TABLE IF EXISTS $TABLE_FAV_NEXT"
        val deletePrev = "DROP TABLE IF EXISTS $TABLE_FAV_PREV"
        db?.execSQL(deleteNext)
        db?.execSQL(deletePrev)
        onCreate(db)
    }


}

val Context.db: SqlLiteOpenHelper get() = SqlLiteOpenHelper.getInstance(applicationContext)

