package it.auties.whatsapp.model.signal.auth;

import it.auties.whatsapp.model.signal.auth.Version;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class VersionSpec {
    public static byte[] encode(Version protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeUInt32(1, protoInputObject.primary());
        outputStream.writeUInt32(2, protoInputObject.secondary());
        outputStream.writeUInt32(3, protoInputObject.tertiary());
        outputStream.writeUInt32(4, protoInputObject.quaternary());
        outputStream.writeUInt32(5, protoInputObject.quinary());
        return outputStream.toByteArray();
    }

    public static Version decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static Version decode(ProtobufInputStream protoInputStream) {
        java.lang.Integer primary = null;
        java.lang.Integer secondary = null;
        java.lang.Integer tertiary = null;
        java.lang.Integer quaternary = null;
        java.lang.Integer quinary = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> primary = protoInputStream.readInt32();
                case 2 -> secondary = protoInputStream.readInt32();
                case 3 -> tertiary = protoInputStream.readInt32();
                case 4 -> quaternary = protoInputStream.readInt32();
                case 5 -> quinary = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.signal.auth.Version(primary, secondary, tertiary, quaternary, quinary);
    }

    public static int sizeOf(Version object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var primary = object.primary();
        if (primary != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(primary);
        }
        var secondary = object.secondary();
        if (secondary != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(secondary);
        }
        var tertiary = object.tertiary();
        if (tertiary != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(tertiary);
        }
        var quaternary = object.quaternary();
        if (quaternary != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(quaternary);
        }
        var quinary = object.quinary();
        if (quinary != null) {
            protoSize += ProtobufOutputStream.getFieldSize(5, 0);
            protoSize += ProtobufOutputStream.getVarIntSize(quinary);
        }
        return protoSize;
    }

}
