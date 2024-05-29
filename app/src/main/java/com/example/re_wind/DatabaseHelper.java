package com.example.re_wind;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "todo_database";
    private static final int DATABASE_VERSION = 1;

    // Todo 테이블 생성 쿼리
    private static final String CREATE_TODO_TABLE =
            "CREATE TABLE Todo (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "task TEXT," +
                    "due_date DATE," +
                    "is_completed INTEGER" +
                    ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 데이터베이스가 처음 생성될 때 호출되는 메서드
        db.execSQL(CREATE_TODO_TABLE); // Todo 테이블 생성
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 데이터베이스 버전이 변경될 때 호출되는 메서드
        // SQLiteOpenHelper 를 상속받았기에 구현해야 함
        // 여기서는 간단하게 데이터를 삭제하고 다시 생성하지만, 실제로는 데이터 이관 등의 작업을 수행할 수 있다
        db.execSQL("DROP TABLE IF EXISTS Todo");
        onCreate(db);
    }
}
