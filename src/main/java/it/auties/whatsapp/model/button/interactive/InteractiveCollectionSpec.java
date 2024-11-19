package it.auties.whatsapp.model.button.interactive;

import it.auties.whatsapp.model.button.interactive.InteractiveCollection;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class InteractiveCollectionSpec {
    public static byte[] encode(InteractiveCollection protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var business = protoInputObject.business();
        if (business != null) {
            var business0 = business.toString();
            if (business0 != null) {
                outputStream.writeString(1, business0);
            }
        }
        outputStream.writeString(2, protoInputObject.id());
        outputStream.writeInt32(3, protoInputObject.version());
        return outputStream.toByteArray();
    }

    public static InteractiveCollection decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static InteractiveCollection decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid business = null;
        java.lang.String id = null;
        int version = 0;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> business = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> id = protoInputStream.readString();
                case 3 -> version = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.interactive.InteractiveCollection(business, id, version);
    }

    public static int sizeOf(InteractiveCollection object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var business = object.business();
        if (business != null) {
            var business0 = business.toString();
            if (business0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(business0);
            }
        }
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var version = object.version();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(version);
        return protoSize;
    }

}
