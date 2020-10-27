package com.edu.unimagdalena.appmoviles.donated_markets;

public class DefDB {


    public static final int DATABASE_VERSION = 1;
    public  static final String DATABASE_NAME = "donatedMarkets";
    // table name
    public  static final String TABLE_MARKETS = "markets";
    // Market Table Columns names
    public  static final String KEY_MARKET_ID = "marketID";
    public  static final String KEY_MARKET_NEIGHBORHOOD = "marketNeighborhood";
    public  static final String KEY_MARKET_HOMEADDRESS = "marketHomeAddress";
    public  static final String KEY_MARKET_DATETIME = "marketDatetime";
    public  static final String KEY_MARKET_PERSONRECEIVES = "marketPersonReceives";

    //Query to create table
    public static final String CREATE_STUDENTS_TABLE = "CREATE TABLE IF NOT EXISTS "
            + TABLE_MARKETS+ "("
            + KEY_MARKET_ID + " INTEGER (10) PRIMARY KEY, "
            + KEY_MARKET_NEIGHBORHOOD+ " TEXT, "
            + KEY_MARKET_HOMEADDRESS + " TEXT,"
            + KEY_MARKET_DATETIME + " LONG,"
            + KEY_MARKET_PERSONRECEIVES + " TEXT"
            + ")";
}
