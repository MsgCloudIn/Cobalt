package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.LocationMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class LocationMessageSpec {
    public static byte[] encode(LocationMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeDouble(1, protoInputObject.latitude());
        outputStream.writeDouble(2, protoInputObject.longitude());
        var name = protoInputObject.name();
        if (name != null) {
            var name0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(name);
            if (name0 != null) {
                outputStream.writeString(3, name0);
            }
        }
        var address = protoInputObject.address();
        if (address != null) {
            var address0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(address);
            if (address0 != null) {
                outputStream.writeString(4, address0);
            }
        }
        var url = protoInputObject.url();
        if (url != null) {
            var url0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(url);
            if (url0 != null) {
                outputStream.writeString(5, url0);
            }
        }
        outputStream.writeBool(6, protoInputObject.live());
        outputStream.writeUInt32(7, protoInputObject.accuracy());
        outputStream.writeFloat(8, protoInputObject.speed());
        outputStream.writeUInt32(9, protoInputObject.magneticNorthOffset());
        var caption = protoInputObject.caption();
        if (caption != null) {
            var caption0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(caption);
            if (caption0 != null) {
                outputStream.writeString(11, caption0);
            }
        }
        var thumbnail = protoInputObject.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                outputStream.writeBytes(16, thumbnail0);
            }
        }
        var contextInfo = protoInputObject.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                outputStream.writeBytes(17, it.auties.whatsapp.model.info.ContextInfoSpec.encode(contextInfo0));
            }
        }
        return outputStream.toByteArray();
    }

    public static LocationMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static LocationMessage decode(ProtobufInputStream protoInputStream) {
        double latitude = 0d;
        double longitude = 0d;
        java.lang.String name = null;
        java.lang.String address = null;
        java.lang.String url = null;
        boolean live = false;
        int accuracy = 0;
        float speed = 0f;
        int magneticNorthOffset = 0;
        java.lang.String caption = null;
        byte[] thumbnail = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> latitude = protoInputStream.readDouble();
                case 2 -> longitude = protoInputStream.readDouble();
                case 3 -> name = protoInputStream.readString();
                case 4 -> address = protoInputStream.readString();
                case 5 -> url = protoInputStream.readString();
                case 6 -> live = protoInputStream.readBool();
                case 7 -> accuracy = protoInputStream.readInt32();
                case 8 -> speed = protoInputStream.readFloat();
                case 9 -> magneticNorthOffset = protoInputStream.readInt32();
                case 11 -> caption = protoInputStream.readString();
                case 16 -> thumbnail = protoInputStream.readBytes();
                case 17 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.LocationMessage(latitude, longitude, name, address, url, live, accuracy, speed, magneticNorthOffset, caption, thumbnail, contextInfo);
    }

    public static int sizeOf(LocationMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var latitude = object.latitude();
        protoSize += ProtobufOutputStream.getFieldSize(1, 1);
        protoSize += 8;
        var longitude = object.longitude();
        protoSize += ProtobufOutputStream.getFieldSize(2, 1);
        protoSize += 8;
        var name = object.name();
        if (name != null) {
            var name0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(name);
            if (name0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getStringSize(name0);
            }
        }
        var address = object.address();
        if (address != null) {
            var address0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(address);
            if (address0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                protoSize += ProtobufOutputStream.getStringSize(address0);
            }
        }
        var url = object.url();
        if (url != null) {
            var url0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(url);
            if (url0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                protoSize += ProtobufOutputStream.getStringSize(url0);
            }
        }
        var live = object.live();
        protoSize += ProtobufOutputStream.getFieldSize(6, 0);
        protoSize += 1;
        var accuracy = object.accuracy();
        protoSize += ProtobufOutputStream.getFieldSize(7, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(accuracy);
        var speed = object.speed();
        protoSize += ProtobufOutputStream.getFieldSize(8, 5);
        protoSize += 4;
        var magneticNorthOffset = object.magneticNorthOffset();
        protoSize += ProtobufOutputStream.getFieldSize(9, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(magneticNorthOffset);
        var caption = object.caption();
        if (caption != null) {
            var caption0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(caption);
            if (caption0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(11, 2);
                protoSize += ProtobufOutputStream.getStringSize(caption0);
            }
        }
        var thumbnail = object.thumbnail();
        if (thumbnail != null) {
            var thumbnail0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(thumbnail);
            if (thumbnail0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(16, 2);
                protoSize += ProtobufOutputStream.getBytesSize(thumbnail0);
            }
        }
        var contextInfo = object.contextInfo();
        if (contextInfo != null) {
            var contextInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contextInfo);
            if (contextInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(17, 2);
                var contextInfo0SerializedSize = it.auties.whatsapp.model.info.ContextInfoSpec.sizeOf(contextInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(contextInfo0SerializedSize);
                protoSize += contextInfo0SerializedSize;
            }
        }
        return protoSize;
    }

}
