package it.auties.whatsapp.model.message.server;

import it.auties.whatsapp.model.message.server.DeviceSentMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class DeviceSentMessageSpec {
    public static byte[] encode(DeviceSentMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var destinationJid = protoInputObject.destinationJid();
        if (destinationJid != null) {
            var destinationJid0 = destinationJid.toString();
            if (destinationJid0 != null) {
                outputStream.writeString(1, destinationJid0);
            }
        }
        outputStream.writeBytes(2, it.auties.whatsapp.model.message.model.MessageContainerSpec.encode(protoInputObject.message()));
        var phash = protoInputObject.phash();
        if (phash != null) {
            var phash0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(phash);
            if (phash0 != null) {
                outputStream.writeString(3, phash0);
            }
        }
        return outputStream.toByteArray();
    }

    public static DeviceSentMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static DeviceSentMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid destinationJid = null;
        it.auties.whatsapp.model.message.model.MessageContainer message = null;
        java.util.Optional<java.lang.String> phash = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> destinationJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> message = it.auties.whatsapp.model.message.model.MessageContainerSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> phash = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.server.DeviceSentMessage(destinationJid, message, phash);
    }

    public static int sizeOf(DeviceSentMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var destinationJid = object.destinationJid();
        if (destinationJid != null) {
            var destinationJid0 = destinationJid.toString();
            if (destinationJid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(destinationJid0);
            }
        }
        var message = object.message();
        if (message != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var messageSerializedSize = it.auties.whatsapp.model.message.model.MessageContainerSpec.sizeOf(message);
            protoSize += ProtobufOutputStream.getVarIntSize(messageSerializedSize);
            protoSize += messageSerializedSize;
        }
        var phash = object.phash();
        if (phash != null) {
            var phash0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(phash);
            if (phash0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getStringSize(phash0);
            }
        }
        return protoSize;
    }

}
