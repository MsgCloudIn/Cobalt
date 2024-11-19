package it.auties.whatsapp.model.message.button;

import it.auties.whatsapp.model.message.button.NativeFlowResponseMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NativeFlowResponseMessageSpec {
    public static byte[] encode(NativeFlowResponseMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.name());
        outputStream.writeString(2, protoInputObject.paramsJson());
        outputStream.writeInt32(3, protoInputObject.version());
        return outputStream.toByteArray();
    }

    public static NativeFlowResponseMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static NativeFlowResponseMessage decode(ProtobufInputStream protoInputStream) {
        java.lang.String name = null;
        java.lang.String paramsJson = null;
        int version = 0;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> name = protoInputStream.readString();
                case 2 -> paramsJson = protoInputStream.readString();
                case 3 -> version = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.button.NativeFlowResponseMessage(name, paramsJson, version);
    }

    public static int sizeOf(NativeFlowResponseMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var name = object.name();
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        var paramsJson = object.paramsJson();
        if (paramsJson != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(paramsJson);
        }
        var version = object.version();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(version);
        return protoSize;
    }

}
