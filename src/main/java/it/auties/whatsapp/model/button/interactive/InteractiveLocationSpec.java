package it.auties.whatsapp.model.button.interactive;

import it.auties.whatsapp.model.button.interactive.InteractiveLocation;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class InteractiveLocationSpec {
    public static byte[] encode(InteractiveLocation protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeDouble(1, protoInputObject.latitude());
        outputStream.writeDouble(2, protoInputObject.longitude());
        outputStream.writeString(3, protoInputObject.name());
        return outputStream.toByteArray();
    }

    public static InteractiveLocation decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static InteractiveLocation decode(ProtobufInputStream protoInputStream) {
        double latitude = 0d;
        double longitude = 0d;
        java.lang.String name = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> latitude = protoInputStream.readDouble();
                case 2 -> longitude = protoInputStream.readDouble();
                case 3 -> name = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.interactive.InteractiveLocation(latitude, longitude, name);
    }

    public static int sizeOf(InteractiveLocation object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var latitude = object.latitude();
        protoSize += ProtobufOutputStream.getFieldSize(1, 1);
        protoSize += 8;
        var longitude = object.longitude();
        protoSize += ProtobufOutputStream.getFieldSize(2, 1);
        protoSize += 8;
        var name = object.name();
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        return protoSize;
    }

}
