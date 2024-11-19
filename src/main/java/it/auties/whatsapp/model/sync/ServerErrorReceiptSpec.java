package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.ServerErrorReceipt;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ServerErrorReceiptSpec {
    public static byte[] encode(ServerErrorReceipt protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.stanzaId());
        return outputStream.toByteArray();
    }

    public static ServerErrorReceipt decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ServerErrorReceipt decode(ProtobufInputStream protoInputStream) {
        java.lang.String stanzaId = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> stanzaId = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.ServerErrorReceipt(stanzaId);
    }

    public static int sizeOf(ServerErrorReceipt object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var stanzaId = object.stanzaId();
        if (stanzaId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(stanzaId);
        }
        return protoSize;
    }

}
