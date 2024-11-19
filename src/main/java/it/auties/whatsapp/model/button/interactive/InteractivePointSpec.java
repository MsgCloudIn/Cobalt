package it.auties.whatsapp.model.button.interactive;

import it.auties.whatsapp.model.button.interactive.InteractivePoint;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class InteractivePointSpec {
    public static byte[] encode(InteractivePoint protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, protoInputObject.xDeprecated());
        outputStream.writeInt32(2, protoInputObject.yDeprecated());
        outputStream.writeDouble(3, protoInputObject.x());
        outputStream.writeDouble(4, protoInputObject.y());
        return outputStream.toByteArray();
    }

    public static InteractivePoint decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static InteractivePoint decode(ProtobufInputStream protoInputStream) {
        int xDeprecated = 0;
        int yDeprecated = 0;
        double x = 0d;
        double y = 0d;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> xDeprecated = protoInputStream.readInt32();
                case 2 -> yDeprecated = protoInputStream.readInt32();
                case 3 -> x = protoInputStream.readDouble();
                case 4 -> y = protoInputStream.readDouble();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.interactive.InteractivePoint(xDeprecated, yDeprecated, x, y);
    }

    public static int sizeOf(InteractivePoint object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var xDeprecated = object.xDeprecated();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(xDeprecated);
        var yDeprecated = object.yDeprecated();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(yDeprecated);
        var x = object.x();
        protoSize += ProtobufOutputStream.getFieldSize(3, 1);
        protoSize += 8;
        var y = object.y();
        protoSize += ProtobufOutputStream.getFieldSize(4, 1);
        protoSize += 8;
        return protoSize;
    }

}
