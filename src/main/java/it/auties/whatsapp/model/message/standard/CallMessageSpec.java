package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.CallMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class CallMessageSpec {
    public static byte[] encode(CallMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.key());
        outputStream.writeString(2, protoInputObject.source());
        outputStream.writeBytes(3, protoInputObject.data());
        outputStream.writeUInt32(4, protoInputObject.delay());
        return outputStream.toByteArray();
    }

    public static CallMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static CallMessage decode(ProtobufInputStream protoInputStream) {
        byte[] key = null;
        java.lang.String source = null;
        byte[] data = null;
        int delay = 0;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> key = protoInputStream.readBytes();
                case 2 -> source = protoInputStream.readString();
                case 3 -> data = protoInputStream.readBytes();
                case 4 -> delay = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.CallMessage(key, source, data, delay);
    }

    public static int sizeOf(CallMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var key = object.key();
        if (key != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(key);
        }
        var source = object.source();
        if (source != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(source);
        }
        var data = object.data();
        if (data != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            protoSize += ProtobufOutputStream.getBytesSize(data);
        }
        var delay = object.delay();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(delay);
        return protoSize;
    }

}
