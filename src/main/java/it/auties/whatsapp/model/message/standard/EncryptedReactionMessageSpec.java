package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.EncryptedReactionMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class EncryptedReactionMessageSpec {
    public static byte[] encode(EncryptedReactionMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(protoInputObject.targetMessageKey()));
        outputStream.writeBytes(2, protoInputObject.encPayload());
        outputStream.writeBytes(3, protoInputObject.encIv());
        return outputStream.toByteArray();
    }

    public static EncryptedReactionMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static EncryptedReactionMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.model.ChatMessageKey targetMessageKey = null;
        byte[] encPayload = null;
        byte[] encIv = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> targetMessageKey = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> encPayload = protoInputStream.readBytes();
                case 3 -> encIv = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.EncryptedReactionMessage(targetMessageKey, encPayload, encIv);
    }

    public static int sizeOf(EncryptedReactionMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var targetMessageKey = object.targetMessageKey();
        if (targetMessageKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var targetMessageKeySerializedSize = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.sizeOf(targetMessageKey);
            protoSize += ProtobufOutputStream.getVarIntSize(targetMessageKeySerializedSize);
            protoSize += targetMessageKeySerializedSize;
        }
        var encPayload = object.encPayload();
        if (encPayload != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(encPayload);
        }
        var encIv = object.encIv();
        if (encIv != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(encIv);
        }
        return protoSize;
    }

}
