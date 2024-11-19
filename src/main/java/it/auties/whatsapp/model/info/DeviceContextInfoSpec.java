package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.DeviceContextInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class DeviceContextInfoSpec {
    public static byte[] encode(DeviceContextInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var deviceListMetadata = protoInputObject.deviceListMetadata();
        if (deviceListMetadata != null) {
            var deviceListMetadata0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deviceListMetadata);
            if (deviceListMetadata0 != null) {
                outputStream.writeBytes(1, it.auties.whatsapp.model.sync.DeviceListMetadataSpec.encode(deviceListMetadata0));
            }
        }
        outputStream.writeInt32(2, protoInputObject.deviceListMetadataVersion());
        var paddingBytes = protoInputObject.paddingBytes();
        if (paddingBytes != null) {
            var paddingBytes0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(paddingBytes);
            if (paddingBytes0 != null) {
                outputStream.writeBytes(4, paddingBytes0);
            }
        }
        var messageSecret = protoInputObject.messageSecret();
        if (messageSecret != null) {
            var messageSecret0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(messageSecret);
            if (messageSecret0 != null) {
                outputStream.writeBytes(3, messageSecret0);
            }
        }
        return outputStream.toByteArray();
    }

    public static DeviceContextInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static DeviceContextInfo decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.sync.DeviceListMetadata deviceListMetadata = null;
        int deviceListMetadataVersion = 0;
        byte[] paddingBytes = null;
        byte[] messageSecret = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> deviceListMetadata = it.auties.whatsapp.model.sync.DeviceListMetadataSpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> deviceListMetadataVersion = protoInputStream.readInt32();
                case 4 -> paddingBytes = protoInputStream.readBytes();
                case 3 -> messageSecret = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.info.DeviceContextInfo(deviceListMetadata, deviceListMetadataVersion, paddingBytes, messageSecret);
    }

    public static int sizeOf(DeviceContextInfo object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var deviceListMetadata = object.deviceListMetadata();
        if (deviceListMetadata != null) {
            var deviceListMetadata0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deviceListMetadata);
            if (deviceListMetadata0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                var deviceListMetadata0SerializedSize = it.auties.whatsapp.model.sync.DeviceListMetadataSpec.sizeOf(deviceListMetadata0);
                protoSize += ProtobufOutputStream.getVarIntSize(deviceListMetadata0SerializedSize);
                protoSize += deviceListMetadata0SerializedSize;
            }
        }
        var deviceListMetadataVersion = object.deviceListMetadataVersion();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(deviceListMetadataVersion);
        var paddingBytes = object.paddingBytes();
        if (paddingBytes != null) {
            var paddingBytes0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(paddingBytes);
            if (paddingBytes0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                protoSize += ProtobufOutputStream.getBytesSize(paddingBytes0);
            }
        }
        var messageSecret = object.messageSecret();
        if (messageSecret != null) {
            var messageSecret0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(messageSecret);
            if (messageSecret0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getBytesSize(messageSecret0);
            }
        }
        return protoSize;
    }

}
