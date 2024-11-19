package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.DeviceIdentity;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class DeviceIdentitySpec {
    public static byte[] encode(DeviceIdentity protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeUInt32(1, protoInputObject.rawId());
        outputStream.writeUInt64(2, protoInputObject.timestamp());
        outputStream.writeUInt32(3, protoInputObject.keyIndex());
        return outputStream.toByteArray();
    }

    public static DeviceIdentity decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static DeviceIdentity decode(ProtobufInputStream protoInputStream) {
        int rawId = 0;
        long timestamp = 0l;
        int keyIndex = 0;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> rawId = protoInputStream.readInt32();
                case 2 -> timestamp = protoInputStream.readInt64();
                case 3 -> keyIndex = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.DeviceIdentity(rawId, timestamp, keyIndex);
    }

    public static int sizeOf(DeviceIdentity object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var rawId = object.rawId();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(rawId);
        var timestamp = object.timestamp();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(timestamp);
        var keyIndex = object.keyIndex();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(keyIndex);
        return protoSize;
    }

}
