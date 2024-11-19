package it.auties.whatsapp.model.button.base;

import it.auties.whatsapp.model.button.base.SingleSelectReplyButton;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SingleSelectReplyButtonSpec {
    public static byte[] encode(SingleSelectReplyButton protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.rowId());
        return outputStream.toByteArray();
    }

    public static SingleSelectReplyButton decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SingleSelectReplyButton decode(ProtobufInputStream protoInputStream) {
        java.lang.String rowId = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> rowId = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.base.SingleSelectReplyButton(rowId);
    }

    public static int sizeOf(SingleSelectReplyButton object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var rowId = object.rowId();
        if (rowId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(rowId);
        }
        return protoSize;
    }

}
