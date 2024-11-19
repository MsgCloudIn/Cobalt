package it.auties.whatsapp.model.chat;

import it.auties.whatsapp.model.chat.ChatDisappear;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ChatDisappearSpec {
    public static byte[] encode(ChatDisappear protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt32(1, it.auties.whatsapp.model.chat.ChatDisappearInitiatorSpec.encode(protoInputObject.initiator()));
        return outputStream.toByteArray();
    }

    public static ChatDisappear decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ChatDisappear decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.chat.ChatDisappear.Initiator initiator = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> initiator = it.auties.whatsapp.model.chat.ChatDisappearInitiatorSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.chat.ChatDisappear(initiator);
    }

    public static int sizeOf(ChatDisappear object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var initiator = object.initiator();
        if (initiator != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var initiatorSerializedSize = it.auties.whatsapp.model.chat.ChatDisappearInitiatorSpec.sizeOf(initiator);
            protoSize += initiatorSerializedSize;
        }
        return protoSize;
    }

}
