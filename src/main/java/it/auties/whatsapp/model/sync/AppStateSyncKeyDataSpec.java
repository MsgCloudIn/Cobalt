package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.AppStateSyncKeyData;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class AppStateSyncKeyDataSpec {
    public static byte[] encode(AppStateSyncKeyData protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.keyData());
        outputStream.writeBytes(2, it.auties.whatsapp.model.sync.AppStateSyncKeyFingerprintSpec.encode(protoInputObject.fingerprint()));
        outputStream.writeInt64(3, protoInputObject.timestamp());
        return outputStream.toByteArray();
    }

    public static AppStateSyncKeyData decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static AppStateSyncKeyData decode(ProtobufInputStream protoInputStream) {
        byte[] keyData = null;
        it.auties.whatsapp.model.sync.AppStateSyncKeyFingerprint fingerprint = null;
        java.lang.Long timestamp = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> keyData = protoInputStream.readBytes();
                case 2 -> fingerprint = it.auties.whatsapp.model.sync.AppStateSyncKeyFingerprintSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> timestamp = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.AppStateSyncKeyData(keyData, fingerprint, timestamp);
    }

    public static int sizeOf(AppStateSyncKeyData object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var keyData = object.keyData();
        if (keyData != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(keyData);
        }
        var fingerprint = object.fingerprint();
        if (fingerprint != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var fingerprintSerializedSize = it.auties.whatsapp.model.sync.AppStateSyncKeyFingerprintSpec.sizeOf(fingerprint);
            protoSize += ProtobufOutputStream.getVarIntSize(fingerprintSerializedSize);
            protoSize += fingerprintSerializedSize;
        }
        var timestamp = object.timestamp();
        if (timestamp != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(timestamp);
        }
        return protoSize;
    }

}
