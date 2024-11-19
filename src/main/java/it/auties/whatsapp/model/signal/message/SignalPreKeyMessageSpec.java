package it.auties.whatsapp.model.signal.message;

import it.auties.whatsapp.model.signal.message.SignalPreKeyMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SignalPreKeyMessageSpec {
    public static byte[] encode(SignalPreKeyMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeUInt32(1, protoInputObject.preKeyId());
        outputStream.writeBytes(2, protoInputObject.baseKey());
        outputStream.writeBytes(3, protoInputObject.identityKey());
        outputStream.writeBytes(4, protoInputObject.serializedSignalMessage());
        outputStream.writeUInt32(5, protoInputObject.registrationId());
        outputStream.writeUInt32(6, protoInputObject.signedPreKeyId());
        return outputStream.toByteArray();
    }

    public static SignalPreKeyMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SignalPreKeyMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.Integer preKeyId = null;
        byte[] baseKey = null;
        byte[] identityKey = null;
        byte[] serializedSignalMessage = null;
        java.lang.Integer registrationId = null;
        java.lang.Integer signedPreKeyId = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> preKeyId = protoInputStream.readInt32();
                case 2 -> baseKey = protoInputStream.readBytes();
                case 3 -> identityKey = protoInputStream.readBytes();
                case 4 -> serializedSignalMessage = protoInputStream.readBytes();
                case 5 -> registrationId = protoInputStream.readInt32();
                case 6 -> signedPreKeyId = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.message.SignalPreKeyMessage(preKeyId, baseKey, identityKey, serializedSignalMessage, registrationId, signedPreKeyId);
    }

    public static int sizeOf(SignalPreKeyMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var preKeyId = object.preKeyId();
        if (preKeyId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(preKeyId);
        }
        var baseKey = object.baseKey();
        if (baseKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(baseKey);
        }
        var identityKey = object.identityKey();
        if (identityKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(identityKey);
        }
        var serializedSignalMessage = object.serializedSignalMessage();
        if (serializedSignalMessage != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            protoSize += ProtobufOutputStream.getBytesSize(serializedSignalMessage);
        }
        var registrationId = object.registrationId();
        if (registrationId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(registrationId);
        }
        var signedPreKeyId = object.signedPreKeyId();
        if (signedPreKeyId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(signedPreKeyId);
        }
        return protoSize;
    }

}
