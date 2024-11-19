package it.auties.whatsapp.model.signal.session;

import it.auties.whatsapp.model.signal.session.SessionChain;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SessionChainSpec {
    public static byte[] encode(SessionChain protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var counter = protoInputObject.counter();
        if (counter != null) {
            var counter0 = it.auties.protobuf.builtin.ProtobufAtomicMixin.toInt(counter);
            outputStream.writeInt32(1, counter0);
        }
        var key = protoInputObject.key();
        if (key != null) {
            var key0 = it.auties.protobuf.builtin.ProtobufAtomicMixin.toValue(key);
            if (key0 != null) {
                outputStream.writeBytes(2, key0);
            }
        }
        if (protoInputObject.messageKeys() != null) {
            for (var messageKeysEntry : protoInputObject.messageKeys().entrySet()) { 
                var messageKeysOutputStream = new ProtobufOutputStream(sizeOfMessageKeys(messageKeysEntry));
                messageKeysOutputStream.writeInt32(1, messageKeysEntry.getKey());
                messageKeysOutputStream.writeBytes(2, messageKeysEntry.getValue());
                outputStream.writeBytes(3, messageKeysOutputStream.toByteArray());
            }
        }
        return outputStream.toByteArray();
    }

    public static SessionChain decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SessionChain decode(ProtobufInputStream protoInputStream) {
        java.util.concurrent.atomic.AtomicInteger counter = it.auties.protobuf.builtin.ProtobufAtomicMixin.newAtomicInt();
        java.util.concurrent.atomic.AtomicReference<byte[]> key = it.auties.protobuf.builtin.ProtobufAtomicMixin.newAtomicReference();
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer,byte[]> messageKeys = new java.util.concurrent.ConcurrentHashMap();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> counter = it.auties.protobuf.builtin.ProtobufAtomicMixin.ofAtomic(protoInputStream.readInt32());
                case 2 -> key = it.auties.protobuf.builtin.ProtobufAtomicMixin.ofAtomic(protoInputStream.readBytes());
                case 3 -> {
                    var messageKeysInputStream = protoInputStream.lengthDelimitedStream();
                    java.lang.Integer messageKeysKey = null;
                    byte[] messageKeysValue = null;
                    while (messageKeysInputStream.readTag()) {
                        switch (messageKeysInputStream.index()) {
                            case 1 -> messageKeysKey = messageKeysInputStream.readInt32();
                            case 2 -> messageKeysValue = messageKeysInputStream.readBytes();
                        }
                    }
                    messageKeys.put(messageKeysKey, messageKeysValue);
                }
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.session.SessionChain(counter, key, messageKeys);
    }

    public static int sizeOf(SessionChain object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var counter = object.counter();
        if (counter != null) {
            var counter0 = it.auties.protobuf.builtin.ProtobufAtomicMixin.toInt(counter);
            protoSize += ProtobufOutputStream.getFieldSize(1, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(counter0);
        }
        var key = object.key();
        if (key != null) {
            var key0 = it.auties.protobuf.builtin.ProtobufAtomicMixin.toValue(key);
            if (key0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                protoSize += ProtobufOutputStream.getBytesSize(key0);
            }
        }
        var messageKeysMapField = object.messageKeys();
        if (messageKeysMapField != null) {
            for (var messageKeysMapEntry : messageKeysMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var messageKeysMapEntrySize = sizeOfMessageKeys(messageKeysMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(messageKeysMapEntrySize);
                protoSize += messageKeysMapEntrySize;
            }
        }
        return protoSize;
    }

    private static int sizeOfMessageKeys(java.util.Map.Entry<java.lang.Integer, byte[]> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(objectMapKey);
        var messageKeysMapValue = object.getValue();
        if (messageKeysMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(messageKeysMapValue);
        }
        return protoSize;
    }

}
