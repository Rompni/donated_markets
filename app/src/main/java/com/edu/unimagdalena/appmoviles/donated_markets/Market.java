package com.edu.unimagdalena.appmoviles.donated_markets;

public class Market {

    int marketID;
    String marketNeighborhood;
    String marketHomeAddress;
    String marketDatetime;
    String marketPersonReceives;

    public Market(int marketID, String marketNeighborhood, String marketHomeAddress, String marketDatetime, String marketPersonReceives) {
        this.marketID = marketID;
        this.marketNeighborhood = marketNeighborhood;
        this.marketHomeAddress = marketHomeAddress;
        this.marketDatetime = marketDatetime;
        this.marketPersonReceives = marketPersonReceives;
    }

    public int getMarketID() {
        return marketID;
    }

    public void setMarketID(int marketID) {
        this.marketID = marketID;
    }

    public String getMarketNeighborhood() {
        return marketNeighborhood;
    }

    public void setMarketNeighborhood(String marketNeighborhood) {
        this.marketNeighborhood = marketNeighborhood;
    }

    public String getMarketHomeAddress() {
        return marketHomeAddress;
    }

    public void setMarketHomeAddress(String marketHomeAddress) {
        this.marketHomeAddress = marketHomeAddress;
    }

    public String getMarketDatetime() {
        return marketDatetime;
    }

    public void setMarketDatetime(String marketDatetime) {
        this.marketDatetime = marketDatetime;
    }

    public String getMarketPersonReceives() {
        return marketPersonReceives;
    }

    public void setMarketPersonReceives(String marketPersonReceives) {
        this.marketPersonReceives = marketPersonReceives;
    }
}
