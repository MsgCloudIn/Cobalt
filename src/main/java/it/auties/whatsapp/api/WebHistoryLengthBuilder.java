package it.auties.whatsapp.api;

public class WebHistoryLengthBuilder {
    private int size;

    public WebHistoryLengthBuilder() {
        size = 0;
    }

    public WebHistoryLengthBuilder size(int size) {
        this.size = size;
        return this;
    }

    public it.auties.whatsapp.api.WebHistoryLength build() {
        return new it.auties.whatsapp.api.WebHistoryLength(size);
    }

}
