package it.auties.whatsapp.model.button.interactive;

import it.auties.whatsapp.model.button.interactive.InteractiveShop;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class InteractiveShopSpec {
    public static byte[] encode(InteractiveShop protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.id());
        outputStream.writeInt32(2, it.auties.whatsapp.model.button.interactive.InteractiveShopSurfaceTypeSpec.encode(protoInputObject.surfaceType()));
        outputStream.writeInt32(3, protoInputObject.version());
        return outputStream.toByteArray();
    }

    public static InteractiveShop decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static InteractiveShop decode(ProtobufInputStream protoInputStream) {
        java.lang.String id = null;
        it.auties.whatsapp.model.button.interactive.InteractiveShop.SurfaceType surfaceType = null;
        int version = 0;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readString();
                case 2 -> surfaceType = it.auties.whatsapp.model.button.interactive.InteractiveShopSurfaceTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 3 -> version = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.interactive.InteractiveShop(id, surfaceType, version);
    }

    public static int sizeOf(InteractiveShop object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var surfaceType = object.surfaceType();
        if (surfaceType != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var surfaceTypeSerializedSize = it.auties.whatsapp.model.button.interactive.InteractiveShopSurfaceTypeSpec.sizeOf(surfaceType);
            protoSize += surfaceTypeSerializedSize;
        }
        var version = object.version();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(version);
        return protoSize;
    }

}
