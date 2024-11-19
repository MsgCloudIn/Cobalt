package it.auties.whatsapp.model.setting;

import it.auties.whatsapp.model.setting.EphemeralSettings;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class EphemeralSettingsSpec {
    public static byte[] encode(EphemeralSettings protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeFixed32(1, protoInputObject.duration());
        outputStream.writeFixed64(2, protoInputObject.timestampSeconds());
        return outputStream.toByteArray();
    }

    public static EphemeralSettings decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static EphemeralSettings decode(ProtobufInputStream protoInputStream) {
        int duration = 0;
        long timestampSeconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> duration = protoInputStream.readFixed32();
                case 2 -> timestampSeconds = protoInputStream.readFixed64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.setting.EphemeralSettings(duration, timestampSeconds);
    }

    public static int sizeOf(EphemeralSettings object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var duration = object.duration();
        protoSize += ProtobufOutputStream.getFieldSize(1, 5);
        protoSize += 4;
        var timestampSeconds = object.timestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(2, 1);
        protoSize += 8;
        return protoSize;
    }

}
