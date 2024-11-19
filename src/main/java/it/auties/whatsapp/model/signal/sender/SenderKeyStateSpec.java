package it.auties.whatsapp.model.signal.sender;

import it.auties.whatsapp.model.signal.sender.SenderKeyState;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SenderKeyStateSpec {
    public static byte[] encode(SenderKeyState protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, protoInputObject.id());
        outputStream.writeBytes(2, it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.encode(protoInputObject.signingKey()));
        if (protoInputObject.messageKeys() != null) {
            for (var messageKeysEntry : protoInputObject.messageKeys().entrySet()) { 
                var messageKeysOutputStream = new ProtobufOutputStream(sizeOfMessageKeys(messageKeysEntry));
                messageKeysOutputStream.writeInt32(1, messageKeysEntry.getKey());
                messageKeysOutputStream.writeBytes(2, it.auties.whatsapp.model.signal.sender.SenderMessageKeySpec.encode(messageKeysEntry.getValue()));
                outputStream.writeBytes(3, messageKeysOutputStream.toByteArray());
            }
        }
        outputStream.writeBytes(4, it.auties.whatsapp.model.signal.sender.SenderChainKeySpec.encode(protoInputObject.chainKey()));
        return outputStream.toByteArray();
    }

    public static SenderKeyState decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SenderKeyState decode(ProtobufInputStream protoInputStream) {
        int id = 0;
        it.auties.whatsapp.model.signal.keypair.SignalKeyPair signingKey = null;
        java.util.concurrent.ConcurrentHashMap<java.lang.Integer,it.auties.whatsapp.model.signal.sender.SenderMessageKey> messageKeys = new java.util.concurrent.ConcurrentHashMap();
        it.auties.whatsapp.model.signal.sender.SenderChainKey chainKey = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readInt32();
                case 2 -> signingKey = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> {
                    var messageKeysInputStream = protoInputStream.lengthDelimitedStream();
                    java.lang.Integer messageKeysKey = null;
                    it.auties.whatsapp.model.signal.sender.SenderMessageKey messageKeysValue = null;
                    while (messageKeysInputStream.readTag()) {
                        switch (messageKeysInputStream.index()) {
                            case 1 -> messageKeysKey = messageKeysInputStream.readInt32();
                            case 2 -> messageKeysValue = it.auties.whatsapp.model.signal.sender.SenderMessageKeySpec.decode(messageKeysInputStream.lengthDelimitedStream());
                        }
                    }
                    messageKeys.put(messageKeysKey, messageKeysValue);
                }
                case 4 -> chainKey = it.auties.whatsapp.model.signal.sender.SenderChainKeySpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.sender.SenderKeyState(id, signingKey, messageKeys, chainKey);
    }

    public static int sizeOf(SenderKeyState object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(id);
        var signingKey = object.signingKey();
        if (signingKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var signingKeySerializedSize = it.auties.whatsapp.model.signal.keypair.SignalKeyPairSpec.sizeOf(signingKey);
            protoSize += ProtobufOutputStream.getVarIntSize(signingKeySerializedSize);
            protoSize += signingKeySerializedSize;
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
        var chainKey = object.chainKey();
        if (chainKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            var chainKeySerializedSize = it.auties.whatsapp.model.signal.sender.SenderChainKeySpec.sizeOf(chainKey);
            protoSize += ProtobufOutputStream.getVarIntSize(chainKeySerializedSize);
            protoSize += chainKeySerializedSize;
        }
        return protoSize;
    }

    private static int sizeOfMessageKeys(java.util.Map.Entry<java.lang.Integer, it.auties.whatsapp.model.signal.sender.SenderMessageKey> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(objectMapKey);
        var messageKeysMapValue = object.getValue();
        if (messageKeysMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var messageKeysMapValueSerializedSize = it.auties.whatsapp.model.signal.sender.SenderMessageKeySpec.sizeOf(messageKeysMapValue);
            protoSize += ProtobufOutputStream.getVarIntSize(messageKeysMapValueSerializedSize);
            protoSize += messageKeysMapValueSerializedSize;
        }
        return protoSize;
    }

}
