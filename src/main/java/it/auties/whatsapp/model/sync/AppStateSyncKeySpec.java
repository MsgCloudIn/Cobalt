package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.AppStateSyncKey;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class AppStateSyncKeySpec {
    public static byte[] encode(AppStateSyncKey protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.sync.AppStateSyncKeyIdSpec.encode(protoInputObject.keyId()));
        outputStream.writeBytes(2, it.auties.whatsapp.model.sync.AppStateSyncKeyDataSpec.encode(protoInputObject.keyData()));
        return outputStream.toByteArray();
    }

    public static AppStateSyncKey decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static AppStateSyncKey decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.sync.AppStateSyncKeyId keyId = null;
        it.auties.whatsapp.model.sync.AppStateSyncKeyData keyData = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> keyId = it.auties.whatsapp.model.sync.AppStateSyncKeyIdSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> keyData = it.auties.whatsapp.model.sync.AppStateSyncKeyDataSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.AppStateSyncKey(keyId, keyData);
    }

    public static int sizeOf(AppStateSyncKey object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var keyId = object.keyId();
        if (keyId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var keyIdSerializedSize = it.auties.whatsapp.model.sync.AppStateSyncKeyIdSpec.sizeOf(keyId);
            protoSize += ProtobufOutputStream.getVarIntSize(keyIdSerializedSize);
            protoSize += keyIdSerializedSize;
        }
        var keyData = object.keyData();
        if (keyData != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var keyDataSerializedSize = it.auties.whatsapp.model.sync.AppStateSyncKeyDataSpec.sizeOf(keyData);
            protoSize += ProtobufOutputStream.getVarIntSize(keyDataSerializedSize);
            protoSize += keyDataSerializedSize;
        }
        return protoSize;
    }

}
