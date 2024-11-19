package it.auties.whatsapp.model.signal.sender;

import it.auties.whatsapp.model.signal.sender.SenderPreKeys;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SenderPreKeysSpec {
    public static byte[] encode(SenderPreKeys protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        if (protoInputObject.preKeys() != null) {
            for (var preKeysEntry : protoInputObject.preKeys()) { 
                var preKeys = preKeysEntry;
                if (preKeys != null) {
                    var preKeys0 = preKeys.toString();
                    if (preKeys0 != null) {
                        outputStream.writeString(1, preKeys0);
                    }
                }
            }
        }
        return outputStream.toByteArray();
    }

    public static SenderPreKeys decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SenderPreKeys decode(ProtobufInputStream protoInputStream) {
        java.util.Collection<it.auties.whatsapp.model.jid.Jid> preKeys = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newCollection();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> preKeys.add(it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.sender.SenderPreKeys(preKeys);
    }

    public static int sizeOf(SenderPreKeys object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var preKeysRepeatedField = object.preKeys();
        if (preKeysRepeatedField != null) {
            for (var preKeysEntry : preKeysRepeatedField) { 
                if (preKeysEntry != null) {
                    var preKeysEntry0 = preKeysEntry.toString();
                    if (preKeysEntry0 != null) {
                        protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                        protoSize += ProtobufOutputStream.getStringSize(preKeysEntry0);
                    }
                }
            }
        }
        return protoSize;
    }

}
