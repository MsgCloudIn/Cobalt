package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.NewsletterMessageInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NewsletterMessageInfoSpec {
    public static byte[] encode(NewsletterMessageInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeString(1, protoInputObject.id());
        outputStream.writeInt32(2, protoInputObject.serverId());
        var timestampSeconds = protoInputObject.timestampSeconds();
        if (timestampSeconds != null) {
            var timestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(timestampSeconds);
            if (timestampSeconds0 != null) {
                outputStream.writeUInt64(3, timestampSeconds0);
            }
        }
        var views = protoInputObject.views();
        if (views != null) {
            var views0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(views);
            if (views0 != null) {
                outputStream.writeUInt64(4, views0);
            }
        }
        if (protoInputObject.reactions != null) {
            for (var reactionsEntry : protoInputObject.reactions.entrySet()) { 
                var reactionsOutputStream = new ProtobufOutputStream(sizeOfReactions(reactionsEntry));
                reactionsOutputStream.writeString(1, reactionsEntry.getKey());
                reactionsOutputStream.writeBytes(2, it.auties.whatsapp.model.newsletter.NewsletterReactionSpec.encode(reactionsEntry.getValue()));
                outputStream.writeBytes(5, reactionsOutputStream.toByteArray());
            }
        }
        outputStream.writeBytes(6, it.auties.whatsapp.model.message.model.MessageContainerSpec.encode(protoInputObject.message()));
        outputStream.writeInt32(7, it.auties.whatsapp.model.message.model.MessageStatusSpec.encode(protoInputObject.status()));
        return outputStream.toByteArray();
    }

    public static NewsletterMessageInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static NewsletterMessageInfo decode(ProtobufInputStream protoInputStream) {
        java.lang.String id = null;
        int serverId = 0;
        java.lang.Long timestampSeconds = null;
        java.lang.Long views = null;
        java.util.Map<java.lang.String,it.auties.whatsapp.model.newsletter.NewsletterReaction> reactions = it.auties.protobuf.builtin.ProtobufMapMixin.newMap();
        it.auties.whatsapp.model.message.model.MessageContainer message = null;
        it.auties.whatsapp.model.message.model.MessageStatus status = null;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> id = protoInputStream.readString();
                case 2 -> serverId = protoInputStream.readInt32();
                case 3 -> timestampSeconds = protoInputStream.readInt64();
                case 4 -> views = protoInputStream.readInt64();
                case 5 -> {
                    var reactionsInputStream = protoInputStream.lengthDelimitedStream();
                    java.lang.String reactionsKey = null;
                    it.auties.whatsapp.model.newsletter.NewsletterReaction reactionsValue = null;
                    while (reactionsInputStream.readTag()) {
                        switch (reactionsInputStream.index()) {
                            case 1 -> reactionsKey = reactionsInputStream.readString();
                            case 2 -> reactionsValue = it.auties.whatsapp.model.newsletter.NewsletterReactionSpec.decode(reactionsInputStream.lengthDelimitedStream());
                        }
                    }
                    reactions.put(reactionsKey, reactionsValue);
                }
                case 6 -> message = it.auties.whatsapp.model.message.model.MessageContainerSpec.decode(protoInputStream.lengthDelimitedStream());
                case 7 -> status = it.auties.whatsapp.model.message.model.MessageStatusSpec.decode(protoInputStream.readInt32()).orElse(null);
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.info.NewsletterMessageInfo(id, serverId, timestampSeconds, views, reactions, message, status);
    }

    public static int sizeOf(NewsletterMessageInfo object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var id = object.id();
        if (id != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            protoSize += ProtobufOutputStream.getStringSize(id);
        }
        var serverId = object.serverId();
        protoSize += ProtobufOutputStream.getFieldSize(2, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(serverId);
        var timestampSeconds = object.timestampSeconds();
        if (timestampSeconds != null) {
            var timestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(timestampSeconds);
            if (timestampSeconds0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(timestampSeconds0);
            }
        }
        var views = object.views();
        if (views != null) {
            var views0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(views);
            if (views0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(views0);
            }
        }
        var reactionsMapField = object.reactions;
        if (reactionsMapField != null) {
            for (var reactionsMapEntry : reactionsMapField.entrySet()) { 
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                var reactionsMapEntrySize = sizeOfReactions(reactionsMapEntry);
                protoSize += ProtobufOutputStream.getVarIntSize(reactionsMapEntrySize);
                protoSize += reactionsMapEntrySize;
            }
        }
        var message = object.message();
        if (message != null) {
            protoSize += ProtobufOutputStream.getFieldSize(6, 2);
            var messageSerializedSize = it.auties.whatsapp.model.message.model.MessageContainerSpec.sizeOf(message);
            protoSize += ProtobufOutputStream.getVarIntSize(messageSerializedSize);
            protoSize += messageSerializedSize;
        }
        var status = object.status();
        if (status != null) {
            protoSize += ProtobufOutputStream.getFieldSize(7, 2);
            var statusSerializedSize = it.auties.whatsapp.model.message.model.MessageStatusSpec.sizeOf(status);
            protoSize += statusSerializedSize;
        }
        return protoSize;
    }

    private static int sizeOfReactions(java.util.Map.Entry<java.lang.String, it.auties.whatsapp.model.newsletter.NewsletterReaction> object) {
        var protoSize = 0;
        var objectMapKey = object.getKey();
        protoSize += ProtobufOutputStream.getFieldSize(1, 2);
        protoSize += ProtobufOutputStream.getStringSize(objectMapKey);
        var reactionsMapValue = object.getValue();
        if (reactionsMapValue != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var reactionsMapValueSerializedSize = it.auties.whatsapp.model.newsletter.NewsletterReactionSpec.sizeOf(reactionsMapValue);
            protoSize += ProtobufOutputStream.getVarIntSize(reactionsMapValueSerializedSize);
            protoSize += reactionsMapValueSerializedSize;
        }
        return protoSize;
    }

}
