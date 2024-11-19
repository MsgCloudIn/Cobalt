package it.auties.whatsapp.model.poll;

import it.auties.whatsapp.model.poll.PollUpdate;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PollUpdateSpec {
    public static byte[] encode(PollUpdate protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(protoInputObject.pollUpdateMessageKey()));
        outputStream.writeBytes(2, it.auties.whatsapp.model.poll.PollUpdateEncryptedOptionsSpec.encode(protoInputObject.vote()));
        outputStream.writeInt64(3, protoInputObject.senderTimestampMilliseconds());
        return outputStream.toByteArray();
    }

    public static PollUpdate decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PollUpdate decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.model.ChatMessageKey pollUpdateMessageKey = null;
        it.auties.whatsapp.model.poll.PollUpdateEncryptedOptions vote = null;
        long senderTimestampMilliseconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> pollUpdateMessageKey = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> vote = it.auties.whatsapp.model.poll.PollUpdateEncryptedOptionsSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> senderTimestampMilliseconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.poll.PollUpdate(pollUpdateMessageKey, vote, senderTimestampMilliseconds);
    }

    public static int sizeOf(PollUpdate object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var pollUpdateMessageKey = object.pollUpdateMessageKey();
        if (pollUpdateMessageKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var pollUpdateMessageKeySerializedSize = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.sizeOf(pollUpdateMessageKey);
            protoSize += ProtobufOutputStream.getVarIntSize(pollUpdateMessageKeySerializedSize);
            protoSize += pollUpdateMessageKeySerializedSize;
        }
        var vote = object.vote();
        if (vote != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var voteSerializedSize = it.auties.whatsapp.model.poll.PollUpdateEncryptedOptionsSpec.sizeOf(vote);
            protoSize += ProtobufOutputStream.getVarIntSize(voteSerializedSize);
            protoSize += voteSerializedSize;
        }
        var senderTimestampMilliseconds = object.senderTimestampMilliseconds();
        protoSize += ProtobufOutputStream.getFieldSize(3, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(senderTimestampMilliseconds);
        return protoSize;
    }

}
