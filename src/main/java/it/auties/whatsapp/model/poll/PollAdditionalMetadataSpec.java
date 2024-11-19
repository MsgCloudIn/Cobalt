package it.auties.whatsapp.model.poll;

import it.auties.whatsapp.model.poll.PollAdditionalMetadata;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PollAdditionalMetadataSpec {
    public static byte[] encode(PollAdditionalMetadata protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBool(1, protoInputObject.pollInvalidated());
        return outputStream.toByteArray();
    }

    public static PollAdditionalMetadata decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PollAdditionalMetadata decode(ProtobufInputStream protoInputStream) {
        boolean pollInvalidated = false;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> pollInvalidated = protoInputStream.readBool();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.poll.PollAdditionalMetadata(pollInvalidated);
    }

    public static int sizeOf(PollAdditionalMetadata object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var pollInvalidated = object.pollInvalidated();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += 1;
        return protoSize;
    }

}
