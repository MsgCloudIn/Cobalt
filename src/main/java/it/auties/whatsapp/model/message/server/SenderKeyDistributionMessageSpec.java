package it.auties.whatsapp.model.message.server;

import it.auties.whatsapp.model.message.server.SenderKeyDistributionMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class SenderKeyDistributionMessageSpec {
    public static byte[] encode(SenderKeyDistributionMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.groupId());
        outputStream.writeBytes(2, protoInputObject.data());
        return outputStream.toByteArray();
    }

    public static SenderKeyDistributionMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static SenderKeyDistributionMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String groupId = null;
        byte[] data = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> groupId = protoInputStream.readString();
                case 2 -> data = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.server.SenderKeyDistributionMessage(groupId, data);
    }

    public static int sizeOf(SenderKeyDistributionMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var groupId = object.groupId();
        if (groupId != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(groupId);
        }
        var data = object.data();
        if (data != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(data);
        }
        return protoSize;
    }

}
