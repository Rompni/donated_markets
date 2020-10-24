package com.edu.unimagdalena.appmoviles.donated_markets;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MarketController {

    private DBHandler db;
    private Context c;

    public MarketController(Context c) {
        this.db = new DBHandler(c);
        this.c = c;
    }


    /**
     * CRUD(Create, Read, Update, Delete) Operations
     */

    // Add New Market
    public void addMarket(Market market) {
        SQLiteDatabase sql = db.getWritableDatabase();

        try {
            //Content values use KEY-VALUE pair concept
            ContentValues values = new ContentValues();
            values.put(DefDB.KEY_MARKET_ID, market.getMarketID());
            values.put(DefDB.KEY_MARKET_NEIGHBORHOOD, market.getMarketNeighborhood());
            values.put(DefDB.KEY_MARKET_HOMEADDRESS, market.getMarketHomeAddress());
            values.put(DefDB.KEY_MARKET_DATETIME, Integer.parseInt(market.getMarketDatetime()));
            values.put(DefDB.KEY_MARKET_PERSONRECEIVES, market.getMarketPersonReceives());

            long id =  sql.insert(DefDB.TABLE_MARKETS, null, values);
            sql.close();
            Toast.makeText(c, "market added " , Toast.LENGTH_LONG).show();

        } catch (Exception ex) {
            Toast.makeText(c, "Error insert market " + ex.getMessage(), Toast.LENGTH_LONG).show();
            sql.close();
        }
    }

    // Getting single market details through ID
    public Market getMarket(int marketID) {
        SQLiteDatabase sql = db.getReadableDatabase();

        Cursor cursor = sql.query(DefDB.TABLE_MARKETS,
                new String[] { DefDB.KEY_MARKET_ID, DefDB.KEY_MARKET_NEIGHBORHOOD, DefDB.KEY_MARKET_HOMEADDRESS,DefDB.KEY_MARKET_DATETIME, DefDB.KEY_MARKET_PERSONRECEIVES },
                DefDB.KEY_MARKET_ID + "=?",
                new String[] { String.valueOf(marketID) },
                null,
                null,
                null,
                null);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();

            Market market = new Market(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4));

            //Return Student
            db.close();
            return market;
        }

        db.close();
        return null;
    }

    // Getting All Markets
    public List<Market> getAllMarkets() {
        List<Market> marketList = new ArrayList<Market>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DefDB.TABLE_MARKETS;

        SQLiteDatabase sql = db.getWritableDatabase();
        Cursor cursor = sql.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Market market = new Market(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));

                marketList.add(market);
            } while (cursor.moveToNext());
        }

        // return student list
        return marketList;
    }

    // Getting All Markets by Neighborhood
    public List<Market> getAllMarketsByNeighborhood(String marketNeighborhood) {
        List<Market> marketList = new ArrayList<Market>();
        SQLiteDatabase sql = db.getWritableDatabase();

        Cursor cursor = sql.query(DefDB.TABLE_MARKETS,
                new String[] { DefDB.KEY_MARKET_ID, DefDB.KEY_MARKET_NEIGHBORHOOD,
                               DefDB.KEY_MARKET_HOMEADDRESS, "datetime("+DefDB.KEY_MARKET_DATETIME+ "", DefDB.KEY_MARKET_PERSONRECEIVES },
                DefDB.KEY_MARKET_NEIGHBORHOOD+ "=?",
                new String[] { String.valueOf(marketNeighborhood)},
                null,
                null,
                null,
                null);

        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Market market = new Market(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4));

                marketList.add(market);
            } while (cursor.moveToNext());
        }

        // return student list
        return marketList;
    }

    // Updating single market
    public int updateMarket(Market market) {
        SQLiteDatabase sql = db.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DefDB.KEY_MARKET_NEIGHBORHOOD, market.getMarketNeighborhood());
        values.put(DefDB.KEY_MARKET_HOMEADDRESS, market.getMarketHomeAddress());
        values.put(DefDB.KEY_MARKET_DATETIME, market.getMarketDatetime());
        values.put(DefDB.KEY_MARKET_PERSONRECEIVES, market.getMarketPersonReceives());

        // updating student row
        return sql.update(DefDB.TABLE_MARKETS,
                values,
                DefDB.KEY_MARKET_ID + " = ?",
                new String[] { String.valueOf(market.getMarketID())});
    }

    // Deleting single market
    public void deleteMarket(Market market) {

        SQLiteDatabase sql = db.getWritableDatabase();
        sql.delete(DefDB.TABLE_MARKETS,DefDB.KEY_MARKET_ID + " = ?",
                new String[] { String.valueOf(market.getMarketID()) });
        sql.close();
    }
}
