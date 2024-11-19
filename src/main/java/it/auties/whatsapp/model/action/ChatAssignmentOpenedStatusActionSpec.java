package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.ChatAssignmentOpenedStatusAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ChatAssignmentOpenedStatusActionSpec {
    public static byte[] encode(ChatAssignmentOpenedStatusAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.chatOpened());
        return outputStream.toByteArray();
    }

    public static ChatAssignmentOpenedStatusAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ChatAssignmentOpenedStatusAction decode(ProtobufInputStream protoInputStream) {
        boolean chatOpened = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> chatOpened = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.ChatAssignmentOpenedStatusAction(chatOpened);
    }

    public static int sizeOf(ChatAssignmentOpenedStatusAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var chatOpened = object.chatOpened();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        return protoSize;
    }

}
