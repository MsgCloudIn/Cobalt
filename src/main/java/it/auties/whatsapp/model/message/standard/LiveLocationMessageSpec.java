package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.LiveLocationMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class LiveLocationMessageSpec {
    public static byte[] encode(LiveLocationMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeDouble(1, protoInputObject.latitude());
        outputStream.writeDouble(2, protoInputObject.longitude());
        outputStream.writeUInt32(3, protoInputObject.accuracy());
        outputStream.writeFloat(4, protoInputObject.speed());
        outputStream.writeUInt32(5, protoInputObject.magneticNorthOffset());
        var caption = protoInputObject.caption();
        if (caption != null) {
            var caption0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(caption);
            if (caption0 != null) {
                outputStream.writeString(6, caption0);
            }
        }
        outputStream.writeUInt64(7, protoInputObject.sequenceNumber());
        outputStream.writeUInt32(8, protoInputObject.timeOffset());
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

    public static LiveLocationMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static LiveLocationMessage decode(ProtobufInputStream protoInputStream) {
        double latitude = 0d;
        double longitude = 0d;
        int accuracy = 0;
        float speed = 0f;
        int magneticNorthOffset = 0;
        java.lang.String caption = null;
        long sequenceNumber = 0l;
        int timeOffset = 0;
        byte[] thumbnail = null;
        it.auties.whatsapp.model.info.ContextInfo contextInfo = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> latitude = protoInputStream.readDouble();
                case 2 -> longitude = protoInputStream.readDouble();
                case 3 -> accuracy = protoInputStream.readInt32();
                case 4 -> speed = protoInputStream.readFloat();
                case 5 -> magneticNorthOffset = protoInputStream.readInt32();
                case 6 -> caption = protoInputStream.readString();
                case 7 -> sequenceNumber = protoInputStream.readInt64();
                case 8 -> timeOffset = protoInputStream.readInt32();
                case 16 -> thumbnail = protoInputStream.readBytes();
                case 17 -> contextInfo = it.auties.whatsapp.model.info.ContextInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.LiveLocationMessage(latitude, longitude, accuracy, speed, magneticNorthOffset, caption, sequenceNumber, timeOffset, thumbnail, contextInfo);
    }

    public static int sizeOf(LiveLocationMessage object) {
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
        var accuracy = object.accuracy();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(accuracy);
        var speed = object.speed();
        protoSize += ProtobufOutputStream.getFieldSize(4, 5);
        protoSize += 4;
        var magneticNorthOffset = object.magneticNorthOffset();
        protoSize += ProtobufOutputStream.getFieldSize(5, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(magneticNorthOffset);
        var caption = object.caption();
        if (caption != null) {
            var caption0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(caption);
            if (caption0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                protoSize += ProtobufOutputStream.getStringSize(caption0);
            }
        }
        var sequenceNumber = object.sequenceNumber();
        protoSize += ProtobufOutputStream.getFieldSize(7, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(sequenceNumber);
        var timeOffset = object.timeOffset();
        protoSize += ProtobufOutputStream.getFieldSize(8, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(timeOffset);
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
