package it.auties.whatsapp.model.poll;

import it.auties.whatsapp.model.poll.PollUpdateMessageMetadata;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PollUpdateMessageMetadataSpec {
    public static byte[] encode(PollUpdateMessageMetadata protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        return outputStream.toByteArray();
    }

    public static PollUpdateMessageMetadata decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PollUpdateMessageMetadata decode(ProtobufInputStream protoInputStream) {
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.poll.PollUpdateMessageMetadata();
    }

    public static int sizeOf(PollUpdateMessageMetadata object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        return protoSize;
    }

}
