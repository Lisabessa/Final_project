package ru.samsung.final_project;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

public class DatabaseAdapter {
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    public DatabaseAdapter(Context context) {
        this.databaseHelper = new DatabaseHelper(context.getApplicationContext());
    }

    public DatabaseAdapter open(){
        database = databaseHelper.open();
        return this;
    }

    public void close(){
        databaseHelper.close();
    }

    public long getCount(){
        return DatabaseUtils.queryNumEntries(database, DatabaseHelper.TABLE);
    }

    private Cursor getAllElements(){
        String [] columns = new String[]{DatabaseHelper.COLUMN_ID, DatabaseHelper.COLUMN_NAME, DatabaseHelper.COLUMN_RES_SOFTWARE,
                DatabaseHelper.COLUMN_RES_HARDWARE, DatabaseHelper.COLUMN_RES_GENVERBS, DatabaseHelper.COLUMN_RES_INTERNET,};
        return database.query(DatabaseHelper.TABLE, columns, null, null, null, null, null, null);
    }

    public long insert(User user){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.COLUMN_NAME, user.getName());
        cv.put(DatabaseHelper.COLUMN_RES_SOFTWARE, user.getResult_module_software());
        cv.put(DatabaseHelper.COLUMN_RES_HARDWARE, user.getResult_module_hardware());
        cv.put(DatabaseHelper.COLUMN_RES_GENVERBS, user.getResult_module_genverbs());
        cv.put(DatabaseHelper.COLUMN_RES_INTERNET, user.getResult_module_internet());
        return database.insert(DatabaseHelper.TABLE, null, cv);
    }

    public long delete(long userId){
        String whereClause = "_id =?";
        String []whereArgs = new String[]{String.valueOf(userId)};
        return database.delete(DatabaseHelper.TABLE, whereClause, whereArgs);
    }

    public long update(User user){
        String whereClause = DatabaseHelper.COLUMN_ID + " = "+ String.valueOf(user.getId());
        ContentValues cv = new ContentValues();

        cv.put(DatabaseHelper.COLUMN_NAME, user.getName());
        cv.put(DatabaseHelper.COLUMN_RES_SOFTWARE, user.getResult_module_software());
        cv.put(DatabaseHelper.COLUMN_RES_HARDWARE, user.getResult_module_hardware());
        cv.put(DatabaseHelper.COLUMN_RES_GENVERBS, user.getResult_module_genverbs());
        cv.put(DatabaseHelper.COLUMN_RES_INTERNET, user.getResult_module_internet());

        return database.update(DatabaseHelper.TABLE, cv, whereClause, null);

    }

    public List<User> getUsers(){
        ArrayList<User> users = new ArrayList<>();
        Cursor cursor = getAllElements();
        while(cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
            float result_module_software = cursor.getFloat(cursor.getColumnIndex(DatabaseHelper.COLUMN_RES_SOFTWARE));
            float result_module_hardware = cursor.getFloat(cursor.getColumnIndex(DatabaseHelper.COLUMN_RES_HARDWARE));
            float result_module_genverbs = cursor.getFloat(cursor.getColumnIndex(DatabaseHelper.COLUMN_RES_GENVERBS));
            float result_module_internet = cursor.getFloat(cursor.getColumnIndex(DatabaseHelper.COLUMN_RES_INTERNET));

            users.add(new User(id, name, result_module_software, result_module_hardware, result_module_genverbs, result_module_internet));

        }
        cursor.close();
        return users;
    }

    public User getUser(long id){
        User user = null;
        String query = String.format("SELECT * FROM %s WHERE %s=?", DatabaseHelper.TABLE, DatabaseHelper.COLUMN_ID); // В первую строку подставляются элементы-аргументы.
        Cursor cursor = database.rawQuery(query, new String[]{String.valueOf(id)});
        if(cursor.moveToFirst()){
            String name = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME));
            float result_module_software = cursor.getFloat(cursor.getColumnIndex(DatabaseHelper.COLUMN_RES_SOFTWARE));
            float result_module_hardware = cursor.getFloat(cursor.getColumnIndex(DatabaseHelper.COLUMN_RES_HARDWARE));
            float result_module_genverbs = cursor.getFloat(cursor.getColumnIndex(DatabaseHelper.COLUMN_RES_GENVERBS));
            float result_module_internet = cursor.getFloat(cursor.getColumnIndex(DatabaseHelper.COLUMN_RES_INTERNET));
            user = new User(id, name, result_module_software, result_module_hardware, result_module_genverbs, result_module_internet);
        }
        cursor.close();
        return user;
    }


}
