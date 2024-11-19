package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.AppStateSyncKeyRequest;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class AppStateSyncKeyRequestSpec {
    public static byte[] encode(AppStateSyncKeyRequest protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.keyIds() != null) {
            for (var keyIdsEntry : protoInputObject.keyIds()) { 
                outputStream.writeBytes(1, it.auties.whatsapp.model.sync.AppStateSyncKeyIdSpec.encode(keyIdsEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static AppStateSyncKeyRequest decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static AppStateSyncKeyRequest decode(ProtobufInputStream protoInputStream) {
        java.util.List<it.auties.whatsapp.model.sync.AppStateSyncKeyId> keyIds = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> keyIds.add(it.auties.whatsapp.model.sync.AppStateSyncKeyIdSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.AppStateSyncKeyRequest(keyIds);
    }

    public static int sizeOf(AppStateSyncKeyRequest object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var keyIdsRepeatedField = object.keyIds();
        if (keyIdsRepeatedField != null) {
            for (var keyIdsEntry : keyIdsRepeatedField) { 
                if (keyIdsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                    var keyIdsEntrySerializedSize = it.auties.whatsapp.model.sync.AppStateSyncKeyIdSpec.sizeOf(keyIdsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(keyIdsEntrySerializedSize);
                    protoSize += keyIdsEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
