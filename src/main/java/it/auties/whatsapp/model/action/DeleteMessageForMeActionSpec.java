package it.auties.whatsapp.model.action;

import it.auties.whatsapp.model.action.DeleteMessageForMeAction;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class DeleteMessageForMeActionSpec {
    public static byte[] encode(DeleteMessageForMeAction protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.deleteMedia());
        outputStream.writeInt64(2, protoInputObject.messageTimestampSeconds());
        return outputStream.toByteArray();
    }

    public static DeleteMessageForMeAction decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static DeleteMessageForMeAction decode(ProtobufInputStream protoInputStream) {
        boolean deleteMedia = false;
        long messageTimestampSeconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> deleteMedia = protoInputStream.readBool();
                case 2 -> messageTimestampSeconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.action.DeleteMessageForMeAction(deleteMedia, messageTimestampSeconds);
    }

    public static int sizeOf(DeleteMessageForMeAction object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var deleteMedia = object.deleteMedia();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        var messageTimestampSeconds = object.messageTimestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(messageTimestampSeconds);
        return protoSize;
    }

}
