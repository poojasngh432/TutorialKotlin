package com.example.toolsdemoapp.Interface;

import com.example.toolsdemoapp.model.ToggleableView;

public interface OnToggledListener {

    /**
     * Called when a view changes it's state.
     *
     * @param toggleableView The view which either is on/off.
     * @param isOn           The on/off state of switch, true when switch turns on.
     */
    void onSwitched(ToggleableView toggleableView, boolean isOn);
}
