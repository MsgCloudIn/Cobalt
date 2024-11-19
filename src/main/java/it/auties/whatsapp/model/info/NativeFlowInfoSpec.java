package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.NativeFlowInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NativeFlowInfoSpec {
    public static byte[] encode(NativeFlowInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.name());
        outputStream.writeString(2, protoInputObject.parameters());
        return outputStream.toByteArray();
    }

    public static NativeFlowInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static NativeFlowInfo decode(ProtobufInputStream protoInputStream) {
        java.lang.String name = null;
        java.lang.String parameters = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> name = protoInputStream.readString();
                case 2 -> parameters = protoInputStream.readString();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.info.NativeFlowInfo(name, parameters);
    }

    public static int sizeOf(NativeFlowInfo object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var name = object.name();
        if (name != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(name);
        }
        var parameters = object.parameters();
        if (parameters != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getStringSize(parameters);
        }
        return protoSize;
    }

}
