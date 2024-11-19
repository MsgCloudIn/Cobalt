package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.AppStateSyncKeyShare;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class AppStateSyncKeyShareSpec {
    public static byte[] encode(AppStateSyncKeyShare protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.keys() != null) {
            for (var keysEntry : protoInputObject.keys()) { 
                outputStream.writeBytes(1, it.auties.whatsapp.model.sync.AppStateSyncKeySpec.encode(keysEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static AppStateSyncKeyShare decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static AppStateSyncKeyShare decode(ProtobufInputStream protoInputStream) {
        java.util.List<it.auties.whatsapp.model.sync.AppStateSyncKey> keys = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> keys.add(it.auties.whatsapp.model.sync.AppStateSyncKeySpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.AppStateSyncKeyShare(keys);
    }

    public static int sizeOf(AppStateSyncKeyShare object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var keysRepeatedField = object.keys();
        if (keysRepeatedField != null) {
            for (var keysEntry : keysRepeatedField) { 
                if (keysEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    var keysEntrySerializedSize = it.auties.whatsapp.model.sync.AppStateSyncKeySpec.sizeOf(keysEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(keysEntrySerializedSize);
                    protoSize += keysEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
