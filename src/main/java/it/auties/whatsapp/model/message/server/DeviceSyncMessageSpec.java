package it.auties.whatsapp.model.message.server;

import it.auties.whatsapp.model.message.server.DeviceSyncMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class DeviceSyncMessageSpec {
    public static byte[] encode(DeviceSyncMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.serializedXmlBytes());
        return outputStream.toByteArray();
    }

    public static DeviceSyncMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static DeviceSyncMessage decode(ProtobufInputStream protoInputStream) {
        byte[] serializedXmlBytes = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> serializedXmlBytes = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.server.DeviceSyncMessage(serializedXmlBytes);
    }

    public static int sizeOf(DeviceSyncMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var serializedXmlBytes = object.serializedXmlBytes();
        if (serializedXmlBytes != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(serializedXmlBytes);
        }
        return protoSize;
    }

}
