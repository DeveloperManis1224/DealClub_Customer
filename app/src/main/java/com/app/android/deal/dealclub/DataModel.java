package com.app.android.deal.dealclub;

class DataModel {
    String _shopName,_shopOffer,_shopAddress,_shopTiming,_shopPhone;

    public DataModel(String _shopName, String _shopOffer, String _shopAddress, String _shopTiming, String _shopPhone) {
        this._shopName = _shopName;
        this._shopOffer = _shopOffer;
        this._shopAddress = _shopAddress;
        this._shopTiming = _shopTiming;
        this._shopPhone = _shopPhone;
    }

    public String get_shopName() {
        return _shopName;
    }

    public void set_shopName(String _shopName) {
        this._shopName = _shopName;
    }

    public String get_shopOffer() {
        return _shopOffer;
    }

    public void set_shopOffer(String _shopOffer) {
        this._shopOffer = _shopOffer;
    }

    public String get_shopAddress() {
        return _shopAddress;
    }

    public void set_shopAddress(String _shopAddress) {
        this._shopAddress = _shopAddress;
    }

    public String get_shopTiming() {
        return _shopTiming;
    }

    public void set_shopTiming(String _shopTiming) {
        this._shopTiming = _shopTiming;
    }

    public String get_shopPhone() {
        return _shopPhone;
    }

    public void set_shopPhone(String _shopPhone) {
        this._shopPhone = _shopPhone;
    }
}
