package com.example.ping_meteo.Controller.lieux;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LieuxViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public LieuxViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}