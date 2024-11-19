package it.auties.whatsapp.model.poll;

import it.auties.whatsapp.model.poll.PollUpdateEncryptedMetadata;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PollUpdateEncryptedMetadataSpec {
    public static byte[] encode(PollUpdateEncryptedMetadata protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, protoInputObject.payload());
        outputStream.writeBytes(2, protoInputObject.iv());
        return outputStream.toByteArray();
    }

    public static PollUpdateEncryptedMetadata decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PollUpdateEncryptedMetadata decode(ProtobufInputStream protoInputStream) {
        byte[] payload = null;
        byte[] iv = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> payload = protoInputStream.readBytes();
                case 2 -> iv = protoInputStream.readBytes();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.poll.PollUpdateEncryptedMetadata(payload, iv);
    }

    public static int sizeOf(PollUpdateEncryptedMetadata object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var payload = object.payload();
        if (payload != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getBytesSize(payload);
        }
        var iv = object.iv();
        if (iv != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            protoSize += ProtobufOutputStream.getBytesSize(iv);
        }
        return protoSize;
    }

}
