package com.example.pingmeteo.Controller.lieux;

import androidx.lifecycle.*;

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