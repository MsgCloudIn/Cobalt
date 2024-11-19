package it.auties.whatsapp.model.companion;

import it.auties.whatsapp.model.companion.CompanionSyncKey;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class CompanionSyncKeySpec {
    public static byte[] encode(CompanionSyncKey protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var companion = protoInputObject.companion();
        if (companion != null) {
            var companion0 = companion.toString();
            if (companion0 != null) {
                outputStream.writeString(1, companion0);
            }
        }
        if (protoInputObject.keys() != null) {
            for (var keysEntry : protoInputObject.keys()) { 
                outputStream.writeBytes(2, it.auties.whatsapp.model.sync.AppStateSyncKeySpec.encode(keysEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static CompanionSyncKey decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static CompanionSyncKey decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid companion = null;
        java.util.LinkedList<it.auties.whatsapp.model.sync.AppStateSyncKey> keys = new java.util.LinkedList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> companion = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> keys.add(it.auties.whatsapp.model.sync.AppStateSyncKeySpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.companion.CompanionSyncKey(companion, keys);
    }

    public static int sizeOf(CompanionSyncKey object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var companion = object.companion();
        if (companion != null) {
            var companion0 = companion.toString();
            if (companion0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(companion0);
            }
        }
        var keysRepeatedField = object.keys();
        if (keysRepeatedField != null) {
            for (var keysEntry : keysRepeatedField) { 
                if (keysEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                    var keysEntrySerializedSize = it.auties.whatsapp.model.sync.AppStateSyncKeySpec.sizeOf(keysEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(keysEntrySerializedSize);
                    protoSize += keysEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
