package ru.samsung.final_project;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "userbase.db";
    private static String DATABASE_PATH;
    static final String TABLE = "users";
    private static final int SCHEMA = 1;
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_RES_SOFTWARE = "result_module_software";
    public static final String COLUMN_RES_HARDWARE = "result_module_hardware";
    public static final String COLUMN_RES_GENVERBS = "result_module_genverbs";
    public static final String COLUMN_RES_INTERNET = "result_module_internet";
    private Context MyContext;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
        this.MyContext = context;
        DATABASE_PATH = context.getFilesDir().getPath()+DATABASE_NAME;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*db.execSQL("CREATE TABLE " + TABLE + "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " + COLUMN_RES_SOFTWARE + " REAL, " + COLUMN_RES_HARDWARE +
                " REAL, " + COLUMN_RES_GENVERBS + " REAL, " + COLUMN_RES_INTERNET + " REAL);");

        db.execSQL("INSERT INTO " + TABLE + " (" + COLUMN_NAME + ", " + COLUMN_RES_SOFTWARE +
                ", " + COLUMN_RES_HARDWARE +", " + COLUMN_RES_GENVERBS + "," + COLUMN_RES_SOFTWARE + ") VALUES ('USER1', 0,0,0,0);");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     /* db.execSQL("DROP TABLE IF EXISTS "+ TABLE);
        onCreate(db);*/
    }

    void Create_db(){ // Для использования нашей готовой базы, а не создания новой. Новые потоки.
        InputStream myInput = null;
        OutputStream myOutput = null;
        try {
            File file = new File(DATABASE_PATH);
            if(!file.exists()){
                myInput = MyContext.getAssets().open(DATABASE_NAME);
                String outfileName = DATABASE_PATH;
                myOutput = new FileOutputStream(outfileName);
                byte [] buffer = new byte[1024];
                int length;
                while((length = myInput.read(buffer)) > 0){
                    myOutput.write(buffer, 0, length);
                }
                myOutput.flush(); // Очистка
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            Log.d("DatabaseHelper", e.getMessage());
        }
        finally {
            try{
                if(myOutput != null){
                    myOutput.close();
                }
                if(myInput != null){
                    myInput.close();
                }
            }
            catch (IOException e){
                e.printStackTrace();
                Log.d("DatabaseHelper", e.getMessage());
            }

        }
    }

    public SQLiteDatabase open()throws SQLiteException { // Для открытия
        return SQLiteDatabase.openDatabase(DATABASE_PATH, null, SQLiteDatabase.OPEN_READWRITE);
    }
}
