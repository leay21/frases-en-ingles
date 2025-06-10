package com.ejemplo.phrases.dto;

public class TranslateRequest {
    private String Text;
    
    public TranslateRequest() {
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        this.Text = text;
    }
}
