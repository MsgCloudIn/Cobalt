package it.auties.whatsapp.model.message.standard;

import it.auties.whatsapp.model.message.standard.PollUpdateMessage;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class PollUpdateMessageSpec {
    public static byte[] encode(PollUpdateMessage protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(protoInputObject.pollCreationMessageKey()));
        var encryptedMetadata = protoInputObject.encryptedMetadata();
        if (encryptedMetadata != null) {
            var encryptedMetadata0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encryptedMetadata);
            if (encryptedMetadata0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.poll.PollUpdateEncryptedMetadataSpec.encode(encryptedMetadata0));
            }
        }
        var metadata = protoInputObject.metadata();
        if (metadata != null) {
            var metadata0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(metadata);
            if (metadata0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.poll.PollUpdateMessageMetadataSpec.encode(metadata0));
            }
        }
        outputStream.writeInt64(4, protoInputObject.senderTimestampMilliseconds());
        var voter = protoInputObject.voter();
        if (voter != null) {
            var voter0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(voter);
            if (voter0 != null) {
                var voter1 = voter0.toString();
                if (voter1 != null) {
                    outputStream.writeString(999, voter1);
                }
            }
        }
        var pollCreationMessage = protoInputObject.pollCreationMessage();
        if (pollCreationMessage != null) {
            var pollCreationMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pollCreationMessage);
            if (pollCreationMessage0 != null) {
                outputStream.writeBytes(1000, it.auties.whatsapp.model.message.standard.PollCreationMessageSpec.encode(pollCreationMessage0));
            }
        }
        if (protoInputObject.votes() != null) {
            for (var votesEntry : protoInputObject.votes()) { 
                outputStream.writeBytes(1001, it.auties.whatsapp.model.poll.PollOptionSpec.encode(votesEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static PollUpdateMessage decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static PollUpdateMessage decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.model.ChatMessageKey pollCreationMessageKey = null;
        it.auties.whatsapp.model.poll.PollUpdateEncryptedMetadata encryptedMetadata = null;
        it.auties.whatsapp.model.poll.PollUpdateMessageMetadata metadata = null;
        long senderTimestampMilliseconds = 0l;
        it.auties.whatsapp.model.jid.Jid voter = null;
        it.auties.whatsapp.model.message.standard.PollCreationMessage pollCreationMessage = null;
        java.util.List<it.auties.whatsapp.model.poll.PollOption> votes = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> pollCreationMessageKey = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> encryptedMetadata = it.auties.whatsapp.model.poll.PollUpdateEncryptedMetadataSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> metadata = it.auties.whatsapp.model.poll.PollUpdateMessageMetadataSpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> senderTimestampMilliseconds = protoInputStream.readInt64();
                case 999 -> voter = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 1000 -> pollCreationMessage = it.auties.whatsapp.model.message.standard.PollCreationMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 1001 -> votes.add(it.auties.whatsapp.model.poll.PollOptionSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.standard.PollUpdateMessage(pollCreationMessageKey, encryptedMetadata, metadata, senderTimestampMilliseconds, voter, pollCreationMessage, votes);
    }

    public static int sizeOf(PollUpdateMessage object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var pollCreationMessageKey = object.pollCreationMessageKey();
        if (pollCreationMessageKey != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var pollCreationMessageKeySerializedSize = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.sizeOf(pollCreationMessageKey);
            protoSize += ProtobufOutputStream.getVarIntSize(pollCreationMessageKeySerializedSize);
            protoSize += pollCreationMessageKeySerializedSize;
        }
        var encryptedMetadata = object.encryptedMetadata();
        if (encryptedMetadata != null) {
            var encryptedMetadata0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encryptedMetadata);
            if (encryptedMetadata0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var encryptedMetadata0SerializedSize = it.auties.whatsapp.model.poll.PollUpdateEncryptedMetadataSpec.sizeOf(encryptedMetadata0);
                protoSize += ProtobufOutputStream.getVarIntSize(encryptedMetadata0SerializedSize);
                protoSize += encryptedMetadata0SerializedSize;
            }
        }
        var metadata = object.metadata();
        if (metadata != null) {
            var metadata0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(metadata);
            if (metadata0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var metadata0SerializedSize = it.auties.whatsapp.model.poll.PollUpdateMessageMetadataSpec.sizeOf(metadata0);
                protoSize += ProtobufOutputStream.getVarIntSize(metadata0SerializedSize);
                protoSize += metadata0SerializedSize;
            }
        }
        var senderTimestampMilliseconds = object.senderTimestampMilliseconds();
        protoSize += ProtobufOutputStream.getFieldSize(4, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(senderTimestampMilliseconds);
        var voter = object.voter();
        if (voter != null) {
            var voter0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(voter);
            if (voter0 != null) {
                var voter1 = voter0.toString();
                if (voter1 != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(999, 2);
                    protoSize += ProtobufOutputStream.getStringSize(voter1);
                }
            }
        }
        var pollCreationMessage = object.pollCreationMessage();
        if (pollCreationMessage != null) {
            var pollCreationMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pollCreationMessage);
            if (pollCreationMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1000, 2);
                var pollCreationMessage0SerializedSize = it.auties.whatsapp.model.message.standard.PollCreationMessageSpec.sizeOf(pollCreationMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(pollCreationMessage0SerializedSize);
                protoSize += pollCreationMessage0SerializedSize;
            }
        }
        var votesRepeatedField = object.votes();
        if (votesRepeatedField != null) {
            for (var votesEntry : votesRepeatedField) { 
                if (votesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(1001, 2);
                    var votesEntrySerializedSize = it.auties.whatsapp.model.poll.PollOptionSpec.sizeOf(votesEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(votesEntrySerializedSize);
                    protoSize += votesEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
