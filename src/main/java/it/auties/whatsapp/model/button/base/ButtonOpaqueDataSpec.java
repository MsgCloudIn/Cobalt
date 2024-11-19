package it.auties.whatsapp.model.button.base;

import it.auties.whatsapp.model.button.base.ButtonOpaqueData;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ButtonOpaqueDataSpec {
    public static byte[] encode(ButtonOpaqueData protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var body = protoInputObject.body();
        if (body != null) {
            var body0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(body);
            if (body0 != null) {
                outputStream.writeString(1, body0);
            }
        }
        var caption = protoInputObject.caption();
        if (caption != null) {
            var caption0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(caption);
            if (caption0 != null) {
                outputStream.writeString(3, caption0);
            }
        }
        outputStream.writeDouble(5, protoInputObject.longitude());
        outputStream.writeDouble(7, protoInputObject.latitude());
        outputStream.writeInt32(8, protoInputObject.paymentAmount1000());
        var paymentNote = protoInputObject.paymentNote();
        if (paymentNote != null) {
            var paymentNote0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(paymentNote);
            if (paymentNote0 != null) {
                outputStream.writeString(9, paymentNote0);
            }
        }
        var canonicalUrl = protoInputObject.canonicalUrl();
        if (canonicalUrl != null) {
            var canonicalUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(canonicalUrl);
            if (canonicalUrl0 != null) {
                outputStream.writeString(10, canonicalUrl0);
            }
        }
        var matchedText = protoInputObject.matchedText();
        if (matchedText != null) {
            var matchedText0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(matchedText);
            if (matchedText0 != null) {
                outputStream.writeString(11, matchedText0);
            }
        }
        var title = protoInputObject.title();
        if (title != null) {
            var title0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(title);
            if (title0 != null) {
                outputStream.writeString(12, title0);
            }
        }
        var description = protoInputObject.description();
        if (description != null) {
            var description0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(description);
            if (description0 != null) {
                outputStream.writeString(13, description0);
            }
        }
        outputStream.writeBool(6, protoInputObject.isLive());
        var futureProofBuffer = protoInputObject.futureProofBuffer();
        if (futureProofBuffer != null) {
            var futureProofBuffer0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(futureProofBuffer);
            if (futureProofBuffer0 != null) {
                outputStream.writeBytes(14, futureProofBuffer0);
            }
        }
        var clientUrl = protoInputObject.clientUrl();
        if (clientUrl != null) {
            var clientUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(clientUrl);
            if (clientUrl0 != null) {
                outputStream.writeString(15, clientUrl0);
            }
        }
        var loc = protoInputObject.loc();
        if (loc != null) {
            var loc0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(loc);
            if (loc0 != null) {
                outputStream.writeString(16, loc0);
            }
        }
        var pollName = protoInputObject.pollName();
        if (pollName != null) {
            var pollName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pollName);
            if (pollName0 != null) {
                outputStream.writeString(17, pollName0);
            }
        }
        if (protoInputObject.pollOptions() != null) {
            for (var pollOptionsEntry : protoInputObject.pollOptions()) { 
                outputStream.writeBytes(18, it.auties.whatsapp.model.poll.PollOptionSpec.encode(pollOptionsEntry));
            }
        }
        outputStream.writeUInt32(20, protoInputObject.pollSelectableOptionsCount());
        var messageSecret = protoInputObject.messageSecret();
        if (messageSecret != null) {
            var messageSecret0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(messageSecret);
            if (messageSecret0 != null) {
                outputStream.writeBytes(21, messageSecret0);
            }
        }
        var originalSelfAuthor = protoInputObject.originalSelfAuthor();
        if (originalSelfAuthor != null) {
            var originalSelfAuthor0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(originalSelfAuthor);
            if (originalSelfAuthor0 != null) {
                outputStream.writeString(51, originalSelfAuthor0);
            }
        }
        outputStream.writeInt64(22, protoInputObject.senderTimestampMs());
        var pollUpdateParentKey = protoInputObject.pollUpdateParentKey();
        if (pollUpdateParentKey != null) {
            var pollUpdateParentKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pollUpdateParentKey);
            if (pollUpdateParentKey0 != null) {
                outputStream.writeString(23, pollUpdateParentKey0);
            }
        }
        var encPollVote = protoInputObject.encPollVote();
        if (encPollVote != null) {
            var encPollVote0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encPollVote);
            if (encPollVote0 != null) {
                outputStream.writeBytes(24, it.auties.whatsapp.model.poll.PollUpdateEncryptedMetadataSpec.encode(encPollVote0));
            }
        }
        var encReactionTargetMessageKey = protoInputObject.encReactionTargetMessageKey();
        if (encReactionTargetMessageKey != null) {
            var encReactionTargetMessageKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encReactionTargetMessageKey);
            if (encReactionTargetMessageKey0 != null) {
                outputStream.writeString(25, encReactionTargetMessageKey0);
            }
        }
        var encReactionEncPayload = protoInputObject.encReactionEncPayload();
        if (encReactionEncPayload != null) {
            var encReactionEncPayload0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encReactionEncPayload);
            if (encReactionEncPayload0 != null) {
                outputStream.writeBytes(26, encReactionEncPayload0);
            }
        }
        var encReactionEncIv = protoInputObject.encReactionEncIv();
        if (encReactionEncIv != null) {
            var encReactionEncIv0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encReactionEncIv);
            if (encReactionEncIv0 != null) {
                outputStream.writeBytes(27, encReactionEncIv0);
            }
        }
        return outputStream.toByteArray();
    }

    public static ButtonOpaqueData decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ButtonOpaqueData decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<java.lang.String> body = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> caption = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        double longitude = 0d;
        double latitude = 0d;
        int paymentAmount1000 = 0;
        java.util.Optional<java.lang.String> paymentNote = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> canonicalUrl = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> matchedText = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> title = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> description = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        boolean isLive = false;
        java.util.Optional<byte[]> futureProofBuffer = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> clientUrl = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> loc = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> pollName = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.List<it.auties.whatsapp.model.poll.PollOption> pollOptions = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        int pollSelectableOptionsCount = 0;
        java.util.Optional<byte[]> messageSecret = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> originalSelfAuthor = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        long senderTimestampMs = 0l;
        java.util.Optional<java.lang.String> pollUpdateParentKey = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.poll.PollUpdateEncryptedMetadata> encPollVote = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<java.lang.String> encReactionTargetMessageKey = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<byte[]> encReactionEncPayload = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<byte[]> encReactionEncIv = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> body = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 3 -> caption = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 5 -> longitude = protoInputStream.readDouble();
                case 7 -> latitude = protoInputStream.readDouble();
                case 8 -> paymentAmount1000 = protoInputStream.readInt32();
                case 9 -> paymentNote = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 10 -> canonicalUrl = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 11 -> matchedText = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 12 -> title = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 13 -> description = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 6 -> isLive = protoInputStream.readBool();
                case 14 -> futureProofBuffer = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readBytes());
                case 15 -> clientUrl = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 16 -> loc = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 17 -> pollName = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 18 -> pollOptions.add(it.auties.whatsapp.model.poll.PollOptionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 20 -> pollSelectableOptionsCount = protoInputStream.readInt32();
                case 21 -> messageSecret = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readBytes());
                case 51 -> originalSelfAuthor = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 22 -> senderTimestampMs = protoInputStream.readInt64();
                case 23 -> pollUpdateParentKey = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 24 -> encPollVote = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.poll.PollUpdateEncryptedMetadataSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 25 -> encReactionTargetMessageKey = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 26 -> encReactionEncPayload = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readBytes());
                case 27 -> encReactionEncIv = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readBytes());
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.button.base.ButtonOpaqueData(body, caption, longitude, latitude, paymentAmount1000, paymentNote, canonicalUrl, matchedText, title, description, isLive, futureProofBuffer, clientUrl, loc, pollName, pollOptions, pollSelectableOptionsCount, messageSecret, originalSelfAuthor, senderTimestampMs, pollUpdateParentKey, encPollVote, encReactionTargetMessageKey, encReactionEncPayload, encReactionEncIv);
    }

    public static int sizeOf(ButtonOpaqueData object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var body = object.body();
        if (body != null) {
            var body0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(body);
            if (body0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(body0);
            }
        }
        var caption = object.caption();
        if (caption != null) {
            var caption0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(caption);
            if (caption0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                protoSize += ProtobufOutputStream.getStringSize(caption0);
            }
        }
        var longitude = object.longitude();
        protoSize += ProtobufOutputStream.getFieldSize(5, 1);
        protoSize += 8;
        var latitude = object.latitude();
        protoSize += ProtobufOutputStream.getFieldSize(7, 1);
        protoSize += 8;
        var paymentAmount1000 = object.paymentAmount1000();
        protoSize += ProtobufOutputStream.getFieldSize(8, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(paymentAmount1000);
        var paymentNote = object.paymentNote();
        if (paymentNote != null) {
            var paymentNote0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(paymentNote);
            if (paymentNote0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(9, 2);
                protoSize += ProtobufOutputStream.getStringSize(paymentNote0);
            }
        }
        var canonicalUrl = object.canonicalUrl();
        if (canonicalUrl != null) {
            var canonicalUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(canonicalUrl);
            if (canonicalUrl0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(10, 2);
                protoSize += ProtobufOutputStream.getStringSize(canonicalUrl0);
            }
        }
        var matchedText = object.matchedText();
        if (matchedText != null) {
            var matchedText0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(matchedText);
            if (matchedText0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(11, 2);
                protoSize += ProtobufOutputStream.getStringSize(matchedText0);
            }
        }
        var title = object.title();
        if (title != null) {
            var title0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(title);
            if (title0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(12, 2);
                protoSize += ProtobufOutputStream.getStringSize(title0);
            }
        }
        var description = object.description();
        if (description != null) {
            var description0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(description);
            if (description0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(13, 2);
                protoSize += ProtobufOutputStream.getStringSize(description0);
            }
        }
        var isLive = object.isLive();
        protoSize += ProtobufOutputStream.getFieldSize(6, 0);
        protoSize += 1;
        var futureProofBuffer = object.futureProofBuffer();
        if (futureProofBuffer != null) {
            var futureProofBuffer0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(futureProofBuffer);
            if (futureProofBuffer0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(14, 2);
                protoSize += ProtobufOutputStream.getBytesSize(futureProofBuffer0);
            }
        }
        var clientUrl = object.clientUrl();
        if (clientUrl != null) {
            var clientUrl0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(clientUrl);
            if (clientUrl0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(15, 2);
                protoSize += ProtobufOutputStream.getStringSize(clientUrl0);
            }
        }
        var loc = object.loc();
        if (loc != null) {
            var loc0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(loc);
            if (loc0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(16, 2);
                protoSize += ProtobufOutputStream.getStringSize(loc0);
            }
        }
        var pollName = object.pollName();
        if (pollName != null) {
            var pollName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pollName);
            if (pollName0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(17, 2);
                protoSize += ProtobufOutputStream.getStringSize(pollName0);
            }
        }
        var pollOptionsRepeatedField = object.pollOptions();
        if (pollOptionsRepeatedField != null) {
            for (var pollOptionsEntry : pollOptionsRepeatedField) { 
                if (pollOptionsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(18, 2);
                    var pollOptionsEntrySerializedSize = it.auties.whatsapp.model.poll.PollOptionSpec.sizeOf(pollOptionsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(pollOptionsEntrySerializedSize);
                    protoSize += pollOptionsEntrySerializedSize;
                }
            }
        }
        var pollSelectableOptionsCount = object.pollSelectableOptionsCount();
        protoSize += ProtobufOutputStream.getFieldSize(20, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(pollSelectableOptionsCount);
        var messageSecret = object.messageSecret();
        if (messageSecret != null) {
            var messageSecret0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(messageSecret);
            if (messageSecret0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(21, 2);
                protoSize += ProtobufOutputStream.getBytesSize(messageSecret0);
            }
        }
        var originalSelfAuthor = object.originalSelfAuthor();
        if (originalSelfAuthor != null) {
            var originalSelfAuthor0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(originalSelfAuthor);
            if (originalSelfAuthor0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(51, 2);
                protoSize += ProtobufOutputStream.getStringSize(originalSelfAuthor0);
            }
        }
        var senderTimestampMs = object.senderTimestampMs();
        protoSize += ProtobufOutputStream.getFieldSize(22, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(senderTimestampMs);
        var pollUpdateParentKey = object.pollUpdateParentKey();
        if (pollUpdateParentKey != null) {
            var pollUpdateParentKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pollUpdateParentKey);
            if (pollUpdateParentKey0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(23, 2);
                protoSize += ProtobufOutputStream.getStringSize(pollUpdateParentKey0);
            }
        }
        var encPollVote = object.encPollVote();
        if (encPollVote != null) {
            var encPollVote0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encPollVote);
            if (encPollVote0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(24, 2);
                var encPollVote0SerializedSize = it.auties.whatsapp.model.poll.PollUpdateEncryptedMetadataSpec.sizeOf(encPollVote0);
                protoSize += ProtobufOutputStream.getVarIntSize(encPollVote0SerializedSize);
                protoSize += encPollVote0SerializedSize;
            }
        }
        var encReactionTargetMessageKey = object.encReactionTargetMessageKey();
        if (encReactionTargetMessageKey != null) {
            var encReactionTargetMessageKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encReactionTargetMessageKey);
            if (encReactionTargetMessageKey0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(25, 2);
                protoSize += ProtobufOutputStream.getStringSize(encReactionTargetMessageKey0);
            }
        }
        var encReactionEncPayload = object.encReactionEncPayload();
        if (encReactionEncPayload != null) {
            var encReactionEncPayload0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encReactionEncPayload);
            if (encReactionEncPayload0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(26, 2);
                protoSize += ProtobufOutputStream.getBytesSize(encReactionEncPayload0);
            }
        }
        var encReactionEncIv = object.encReactionEncIv();
        if (encReactionEncIv != null) {
            var encReactionEncIv0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encReactionEncIv);
            if (encReactionEncIv0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(27, 2);
                protoSize += ProtobufOutputStream.getBytesSize(encReactionEncIv0);
            }
        }
        return protoSize;
    }

}
