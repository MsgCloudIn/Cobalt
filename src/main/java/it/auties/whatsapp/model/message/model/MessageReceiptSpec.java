package it.auties.whatsapp.model.message.model;

import it.auties.whatsapp.model.message.model.MessageReceipt;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class MessageReceiptSpec {
    public static byte[] encode(MessageReceipt protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var deliveredTimestampSeconds = protoInputObject.deliveredTimestampSeconds();
        if (deliveredTimestampSeconds != null) {
            var deliveredTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(deliveredTimestampSeconds);
            if (deliveredTimestampSeconds0 != null) {
                outputStream.writeInt64(2, deliveredTimestampSeconds0);
            }
        }
        var readTimestampSeconds = protoInputObject.readTimestampSeconds();
        if (readTimestampSeconds != null) {
            var readTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(readTimestampSeconds);
            if (readTimestampSeconds0 != null) {
                outputStream.writeInt64(3, readTimestampSeconds0);
            }
        }
        var playedTimestampSeconds = protoInputObject.playedTimestampSeconds();
        if (playedTimestampSeconds != null) {
            var playedTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(playedTimestampSeconds);
            if (playedTimestampSeconds0 != null) {
                outputStream.writeInt64(4, playedTimestampSeconds0);
            }
        }
        if (protoInputObject.deliveredJids() != null) {
            for (var deliveredJidsEntry : protoInputObject.deliveredJids()) { 
                var deliveredJids = deliveredJidsEntry;
                if (deliveredJids != null) {
                    var deliveredJids0 = deliveredJids.toString();
                    if (deliveredJids0 != null) {
                        outputStream.writeString(5, deliveredJids0);
                    }
                }
            }
        }
        if (protoInputObject.readJids() != null) {
            for (var readJidsEntry : protoInputObject.readJids()) { 
                var readJids = readJidsEntry;
                if (readJids != null) {
                    var readJids0 = readJids.toString();
                    if (readJids0 != null) {
                        outputStream.writeString(6, readJids0);
                    }
                }
            }
        }
        return outputStream.toByteArray();
    }

    public static MessageReceipt decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static MessageReceipt decode(ProtobufInputStream protoInputStream) {
        java.lang.Long deliveredTimestampSeconds = null;
        java.lang.Long readTimestampSeconds = null;
        java.lang.Long playedTimestampSeconds = null;
        java.util.Set<it.auties.whatsapp.model.jid.Jid> deliveredJids = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newSet();
        java.util.Set<it.auties.whatsapp.model.jid.Jid> readJids = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newSet();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 2 -> deliveredTimestampSeconds = protoInputStream.readInt64();
                case 3 -> readTimestampSeconds = protoInputStream.readInt64();
                case 4 -> playedTimestampSeconds = protoInputStream.readInt64();
                case 5 -> deliveredJids.add(it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString()));
                case 6 -> readJids.add(it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.model.MessageReceipt(deliveredTimestampSeconds, readTimestampSeconds, playedTimestampSeconds, deliveredJids, readJids);
    }

    public static int sizeOf(MessageReceipt object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var deliveredTimestampSeconds = object.deliveredTimestampSeconds();
        if (deliveredTimestampSeconds != null) {
            var deliveredTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(deliveredTimestampSeconds);
            if (deliveredTimestampSeconds0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(deliveredTimestampSeconds0);
            }
        }
        var readTimestampSeconds = object.readTimestampSeconds();
        if (readTimestampSeconds != null) {
            var readTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(readTimestampSeconds);
            if (readTimestampSeconds0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(readTimestampSeconds0);
            }
        }
        var playedTimestampSeconds = object.playedTimestampSeconds();
        if (playedTimestampSeconds != null) {
            var playedTimestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(playedTimestampSeconds);
            if (playedTimestampSeconds0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(playedTimestampSeconds0);
            }
        }
        var deliveredJidsRepeatedField = object.deliveredJids();
        if (deliveredJidsRepeatedField != null) {
            for (var deliveredJidsEntry : deliveredJidsRepeatedField) { 
                if (deliveredJidsEntry != null) {
                    var deliveredJidsEntry0 = deliveredJidsEntry.toString();
                    if (deliveredJidsEntry0 != null) {
                        protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                        protoSize += ProtobufOutputStream.getStringSize(deliveredJidsEntry0);
                    }
                }
            }
        }
        var readJidsRepeatedField = object.readJids();
        if (readJidsRepeatedField != null) {
            for (var readJidsEntry : readJidsRepeatedField) { 
                if (readJidsEntry != null) {
                    var readJidsEntry0 = readJidsEntry.toString();
                    if (readJidsEntry0 != null) {
                        protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                        protoSize += ProtobufOutputStream.getStringSize(readJidsEntry0);
                    }
                }
            }
        }
        return protoSize;
    }

}
