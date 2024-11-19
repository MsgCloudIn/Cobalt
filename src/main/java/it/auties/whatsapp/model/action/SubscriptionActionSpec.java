package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.SubscriptionAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SubscriptionActionSpec {
    public static byte[] encode(SubscriptionAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.deactivated());
        outputStream.writeBool(2, protoInputObject.autoRenewing());
        outputStream.writeInt64(3, protoInputObject.expirationDateSeconds());
        return outputStream.toByteArray();
    }

    public static SubscriptionAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SubscriptionAction decode(ProtobufInputStream protoInputStream) {
        boolean deactivated = false;
        boolean autoRenewing = false;
        long expirationDateSeconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> deactivated = protoInputStream.readBool();
                case 2 -> autoRenewing = protoInputStream.readBool();
                case 3 -> expirationDateSeconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.SubscriptionAction(deactivated, autoRenewing, expirationDateSeconds);
    }

    public static int sizeOf(SubscriptionAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var deactivated = object.deactivated();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        var autoRenewing = object.autoRenewing();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += 1;
        var expirationDateSeconds = object.expirationDateSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(expirationDateSeconds);
        return protoSize;
    }

}
