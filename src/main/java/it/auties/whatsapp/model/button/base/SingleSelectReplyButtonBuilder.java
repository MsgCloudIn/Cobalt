package it.auties.whatsapp.model.button.base;

public class SingleSelectReplyButtonBuilder {
    private java.lang.String rowId;

    public SingleSelectReplyButtonBuilder() {
        rowId = null;
    }

    public SingleSelectReplyButtonBuilder rowId(java.lang.String rowId) {
        this.rowId = rowId;
        return this;
    }

    public it.auties.whatsapp.model.button.base.SingleSelectReplyButton build() {
        return new it.auties.whatsapp.model.button.base.SingleSelectReplyButton(rowId);
    }

}
