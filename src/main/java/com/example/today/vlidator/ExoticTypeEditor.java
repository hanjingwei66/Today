// converts string representation to ExoticType object
package com.example.today.vlidator;

import com.example.today.impl.ByeHotSwappableImpl;
import com.example.today.impl.HotSwappableImpl;

import java.beans.PropertyEditorSupport;

public class ExoticTypeEditor extends PropertyEditorSupport {

    public void setAsText(String text) {
        setValue(new ByeHotSwappableImpl());
    }
}