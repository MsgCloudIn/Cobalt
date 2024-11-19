package it.auties.whatsapp.model.newsletter;

import it.auties.whatsapp.model.newsletter.Newsletter;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class NewsletterSpec {
    public static byte[] encode(Newsletter protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var jid = protoInputObject.jid();
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                outputStream.writeString(1, jid0);
            }
        }
        var state = protoInputObject.state();
        if (state != null) {
            var state0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(state);
            if (state0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.newsletter.NewsletterStateSpec.encode(state0));
            }
        }
        outputStream.writeBytes(3, it.auties.whatsapp.model.newsletter.NewsletterMetadataSpec.encode(protoInputObject.metadata()));
        var viewerMetadata = protoInputObject.viewerMetadata();
        if (viewerMetadata != null) {
            var viewerMetadata0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(viewerMetadata);
            if (viewerMetadata0 != null) {
                outputStream.writeBytes(4, it.auties.whatsapp.model.newsletter.NewsletterViewerMetadataSpec.encode(viewerMetadata0));
            }
        }
        if (protoInputObject.messages() != null) {
            for (var messagesEntry : protoInputObject.messages()) { 
                outputStream.writeBytes(5, it.auties.whatsapp.model.info.NewsletterMessageInfoSpec.encode(messagesEntry));
            }
        }
        return outputStream.toByteArray();
    }

    public static Newsletter decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static Newsletter decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.jid.Jid jid = null;
        it.auties.whatsapp.model.newsletter.NewsletterState state = null;
        it.auties.whatsapp.model.newsletter.NewsletterMetadata metadata = null;
        it.auties.whatsapp.model.newsletter.NewsletterViewerMetadata viewerMetadata = null;
        it.auties.whatsapp.util.ConcurrentLinkedSet<it.auties.whatsapp.model.info.NewsletterMessageInfo> messages = new it.auties.whatsapp.util.ConcurrentLinkedSet();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> jid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 2 -> state = it.auties.whatsapp.model.newsletter.NewsletterStateSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> metadata = it.auties.whatsapp.model.newsletter.NewsletterMetadataSpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> viewerMetadata = it.auties.whatsapp.model.newsletter.NewsletterViewerMetadataSpec.decode(protoInputStream.lengthDelimitedStream());
                case 5 -> messages.add(it.auties.whatsapp.model.info.NewsletterMessageInfoSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.newsletter.Newsletter(jid, state, metadata, viewerMetadata, messages);
    }

    public static int sizeOf(Newsletter object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var jid = object.jid();
        if (jid != null) {
            var jid0 = jid.toString();
            if (jid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(jid0);
            }
        }
        var state = object.state();
        if (state != null) {
            var state0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(state);
            if (state0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var state0SerializedSize = it.auties.whatsapp.model.newsletter.NewsletterStateSpec.sizeOf(state0);
                protoSize += ProtobufOutputStream.getVarIntSize(state0SerializedSize);
                protoSize += state0SerializedSize;
            }
        }
        var metadata = object.metadata();
        if (metadata != null) {
            protoSize += ProtobufOutputStream.getFieldSize(3, 2);
            var metadataSerializedSize = it.auties.whatsapp.model.newsletter.NewsletterMetadataSpec.sizeOf(metadata);
            protoSize += ProtobufOutputStream.getVarIntSize(metadataSerializedSize);
            protoSize += metadataSerializedSize;
        }
        var viewerMetadata = object.viewerMetadata();
        if (viewerMetadata != null) {
            var viewerMetadata0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(viewerMetadata);
            if (viewerMetadata0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var viewerMetadata0SerializedSize = it.auties.whatsapp.model.newsletter.NewsletterViewerMetadataSpec.sizeOf(viewerMetadata0);
                protoSize += ProtobufOutputStream.getVarIntSize(viewerMetadata0SerializedSize);
                protoSize += viewerMetadata0SerializedSize;
            }
        }
        var messagesRepeatedField = object.messages();
        if (messagesRepeatedField != null) {
            for (var messagesEntry : messagesRepeatedField) { 
                if (messagesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                    var messagesEntrySerializedSize = it.auties.whatsapp.model.info.NewsletterMessageInfoSpec.sizeOf(messagesEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(messagesEntrySerializedSize);
                    protoSize += messagesEntrySerializedSize;
                }
            }
        }
        return protoSize;
    }

}
