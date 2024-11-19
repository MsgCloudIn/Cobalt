package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.PrimaryFeature;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PrimaryFeatureSpec {
    public static byte[] encode(PrimaryFeature protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.flags() != null) {
            for (var flagsEntry : protoInputObject.flags()) { 
                outputStream.writeString(1, flagsEntry);
            }
        }
        return outputStream.toByteArray();
    }

    public static PrimaryFeature decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PrimaryFeature decode(ProtobufInputStream protoInputStream) {
        java.util.List<java.lang.String> flags = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> flags.add(protoInputStream.readString());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.PrimaryFeature(flags);
    }

    public static int sizeOf(PrimaryFeature object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var flagsRepeatedField = object.flags();
        if (flagsRepeatedField != null) {
            for (var flagsEntry : flagsRepeatedField) { 
                if (flagsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    protoSize += ProtobufOutputStream.getStringSize(flagsEntry);
                }
            }
        }
        return protoSize;
    }

}
