package com.example.pingmeteo.Controller.seuils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SeuilsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SeuilsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}