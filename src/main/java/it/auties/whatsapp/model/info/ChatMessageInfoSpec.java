package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.ChatMessageInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ChatMessageInfoSpec {
    public static byte[] encode(ChatMessageInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeBytes(1, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(protoInputObject.key()));
        outputStream.writeBytes(2, it.auties.whatsapp.model.message.model.MessageContainerSpec.encode(protoInputObject.message()));
        var timestampSeconds = protoInputObject.timestampSeconds();
        if (timestampSeconds != null) {
            var timestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(timestampSeconds);
            if (timestampSeconds0 != null) {
                outputStream.writeUInt64(3, timestampSeconds0);
            }
        }
        outputStream.writeInt32(4, it.auties.whatsapp.model.message.model.MessageStatusSpec.encode(protoInputObject.status()));
        var senderJid = protoInputObject.senderJid();
        if (senderJid != null) {
            var senderJid0 = senderJid.toString();
            if (senderJid0 != null) {
                outputStream.writeString(5, senderJid0);
            }
        }
        outputStream.writeUInt64(6, protoInputObject.messageC2STimestamp());
        outputStream.writeBool(16, protoInputObject.ignore());
        outputStream.writeBool(17, protoInputObject.starred());
        outputStream.writeBool(18, protoInputObject.broadcast());
        var pushName = protoInputObject.pushName();
        if (pushName != null) {
            var pushName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pushName);
            if (pushName0 != null) {
                outputStream.writeString(19, pushName0);
            }
        }
        var mediaCiphertextSha256 = protoInputObject.mediaCiphertextSha256();
        if (mediaCiphertextSha256 != null) {
            var mediaCiphertextSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaCiphertextSha256);
            if (mediaCiphertextSha2560 != null) {
                outputStream.writeBytes(20, mediaCiphertextSha2560);
            }
        }
        outputStream.writeBool(21, protoInputObject.multicast());
        outputStream.writeBool(22, protoInputObject.urlText());
        outputStream.writeBool(23, protoInputObject.urlNumber());
        var stubType = protoInputObject.stubType();
        if (stubType != null) {
            var stubType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(stubType);
            if (stubType0 != null) {
                outputStream.writeInt32(24, it.auties.whatsapp.model.info.ChatMessageInfoStubTypeSpec.encode(stubType0));
            }
        }
        outputStream.writeBool(25, protoInputObject.clearMedia());
        if (protoInputObject.stubParameters() != null) {
            for (var stubParametersEntry : protoInputObject.stubParameters()) { 
                outputStream.writeString(26, stubParametersEntry);
            }
        }
        outputStream.writeUInt32(27, protoInputObject.duration());
        if (protoInputObject.labels() != null) {
            for (var labelsEntry : protoInputObject.labels()) { 
                outputStream.writeString(28, labelsEntry);
            }
        }
        var paymentInfo = protoInputObject.paymentInfo();
        if (paymentInfo != null) {
            var paymentInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(paymentInfo);
            if (paymentInfo0 != null) {
                outputStream.writeBytes(29, it.auties.whatsapp.model.info.PaymentInfoSpec.encode(paymentInfo0));
            }
        }
        var finalLiveLocation = protoInputObject.finalLiveLocation();
        if (finalLiveLocation != null) {
            var finalLiveLocation0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(finalLiveLocation);
            if (finalLiveLocation0 != null) {
                outputStream.writeBytes(30, it.auties.whatsapp.model.message.standard.LiveLocationMessageSpec.encode(finalLiveLocation0));
            }
        }
        var quotedPaymentInfo = protoInputObject.quotedPaymentInfo();
        if (quotedPaymentInfo != null) {
            var quotedPaymentInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedPaymentInfo);
            if (quotedPaymentInfo0 != null) {
                outputStream.writeBytes(31, it.auties.whatsapp.model.info.PaymentInfoSpec.encode(quotedPaymentInfo0));
            }
        }
        outputStream.writeUInt64(32, protoInputObject.ephemeralStartTimestamp());
        outputStream.writeUInt32(33, protoInputObject.ephemeralDuration());
        outputStream.writeBool(34, protoInputObject.enableEphemeral());
        outputStream.writeBool(35, protoInputObject.ephemeralOutOfSync());
        var businessPrivacyStatus = protoInputObject.businessPrivacyStatus();
        if (businessPrivacyStatus != null) {
            var businessPrivacyStatus0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(businessPrivacyStatus);
            if (businessPrivacyStatus0 != null) {
                outputStream.writeInt32(36, it.auties.whatsapp.model.business.BusinessPrivacyStatusSpec.encode(businessPrivacyStatus0));
            }
        }
        var businessVerifiedName = protoInputObject.businessVerifiedName();
        if (businessVerifiedName != null) {
            var businessVerifiedName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(businessVerifiedName);
            if (businessVerifiedName0 != null) {
                outputStream.writeString(37, businessVerifiedName0);
            }
        }
        var mediaData = protoInputObject.mediaData();
        if (mediaData != null) {
            var mediaData0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaData);
            if (mediaData0 != null) {
                outputStream.writeBytes(38, it.auties.whatsapp.model.media.MediaDataSpec.encode(mediaData0));
            }
        }
        var photoChange = protoInputObject.photoChange();
        if (photoChange != null) {
            var photoChange0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(photoChange);
            if (photoChange0 != null) {
                outputStream.writeBytes(39, it.auties.whatsapp.model.sync.PhotoChangeSpec.encode(photoChange0));
            }
        }
        outputStream.writeBytes(40, it.auties.whatsapp.model.message.model.MessageReceiptSpec.encode(protoInputObject.receipt()));
        if (protoInputObject.reactions() != null) {
            for (var reactionsEntry : protoInputObject.reactions()) { 
                outputStream.writeBytes(41, it.auties.whatsapp.model.message.standard.ReactionMessageSpec.encode(reactionsEntry));
            }
        }
        var quotedStickerData = protoInputObject.quotedStickerData();
        if (quotedStickerData != null) {
            var quotedStickerData0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedStickerData);
            if (quotedStickerData0 != null) {
                outputStream.writeBytes(42, it.auties.whatsapp.model.media.MediaDataSpec.encode(quotedStickerData0));
            }
        }
        outputStream.writeBytes(43, protoInputObject.futureProofData());
        var psaStatus = protoInputObject.psaStatus();
        if (psaStatus != null) {
            var psaStatus0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(psaStatus);
            if (psaStatus0 != null) {
                outputStream.writeBytes(44, it.auties.whatsapp.model.message.model.PublicServiceAnnouncementStatusSpec.encode(psaStatus0));
            }
        }
        if (protoInputObject.pollUpdates() != null) {
            for (var pollUpdatesEntry : protoInputObject.pollUpdates()) { 
                outputStream.writeBytes(45, it.auties.whatsapp.model.poll.PollUpdateSpec.encode(pollUpdatesEntry));
            }
        }
        var pollAdditionalMetadata = protoInputObject.pollAdditionalMetadata();
        if (pollAdditionalMetadata != null) {
            var pollAdditionalMetadata0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pollAdditionalMetadata);
            if (pollAdditionalMetadata0 != null) {
                outputStream.writeBytes(46, it.auties.whatsapp.model.poll.PollAdditionalMetadataSpec.encode(pollAdditionalMetadata0));
            }
        }
        var agentId = protoInputObject.agentId();
        if (agentId != null) {
            var agentId0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(agentId);
            if (agentId0 != null) {
                outputStream.writeString(47, agentId0);
            }
        }
        outputStream.writeBool(48, protoInputObject.statusAlreadyViewed());
        var messageSecret = protoInputObject.messageSecret();
        if (messageSecret != null) {
            var messageSecret0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(messageSecret);
            if (messageSecret0 != null) {
                outputStream.writeBytes(49, messageSecret0);
            }
        }
        var keepInChat = protoInputObject.keepInChat();
        if (keepInChat != null) {
            var keepInChat0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(keepInChat);
            if (keepInChat0 != null) {
                outputStream.writeBytes(50, it.auties.whatsapp.model.message.model.KeepInChatSpec.encode(keepInChat0));
            }
        }
        var originalSender = protoInputObject.originalSender();
        if (originalSender != null) {
            var originalSender0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(originalSender);
            if (originalSender0 != null) {
                var originalSender1 = originalSender0.toString();
                if (originalSender1 != null) {
                    outputStream.writeString(51, originalSender1);
                }
            }
        }
        outputStream.writeUInt64(52, protoInputObject.revokeTimestampSeconds());
        return outputStream.toByteArray();
    }

    public static ChatMessageInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ChatMessageInfo decode(ProtobufInputStream protoInputStream) {
        it.auties.whatsapp.model.message.model.ChatMessageKey key = null;
        it.auties.whatsapp.model.message.model.MessageContainer message = null;
        long timestampSeconds = 0l;
        it.auties.whatsapp.model.message.model.MessageStatus status = null;
        it.auties.whatsapp.model.jid.Jid senderJid = null;
        long messageC2STimestamp = 0l;
        boolean ignore = false;
        boolean starred = false;
        boolean broadcast = false;
        java.lang.String pushName = null;
        byte[] mediaCiphertextSha256 = null;
        boolean multicast = false;
        boolean urlText = false;
        boolean urlNumber = false;
        it.auties.whatsapp.model.info.ChatMessageInfo.StubType stubType = null;
        boolean clearMedia = false;
        java.util.List<java.lang.String> stubParameters = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        int duration = 0;
        java.util.List<java.lang.String> labels = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        it.auties.whatsapp.model.info.PaymentInfo paymentInfo = null;
        it.auties.whatsapp.model.message.standard.LiveLocationMessage finalLiveLocation = null;
        it.auties.whatsapp.model.info.PaymentInfo quotedPaymentInfo = null;
        long ephemeralStartTimestamp = 0l;
        int ephemeralDuration = 0;
        boolean enableEphemeral = false;
        boolean ephemeralOutOfSync = false;
        it.auties.whatsapp.model.business.BusinessPrivacyStatus businessPrivacyStatus = null;
        java.lang.String businessVerifiedName = null;
        it.auties.whatsapp.model.media.MediaData mediaData = null;
        it.auties.whatsapp.model.sync.PhotoChange photoChange = null;
        it.auties.whatsapp.model.message.model.MessageReceipt receipt = null;
        java.util.List<it.auties.whatsapp.model.message.standard.ReactionMessage> reactions = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        it.auties.whatsapp.model.media.MediaData quotedStickerData = null;
        byte[] futureProofData = null;
        it.auties.whatsapp.model.message.model.PublicServiceAnnouncementStatus psaStatus = null;
        java.util.List<it.auties.whatsapp.model.poll.PollUpdate> pollUpdates = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        it.auties.whatsapp.model.poll.PollAdditionalMetadata pollAdditionalMetadata = null;
        java.lang.String agentId = null;
        boolean statusAlreadyViewed = false;
        byte[] messageSecret = null;
        it.auties.whatsapp.model.message.model.KeepInChat keepInChat = null;
        it.auties.whatsapp.model.jid.Jid originalSender = null;
        long revokeTimestampSeconds = 0l;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> key = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream());
                case 2 -> message = it.auties.whatsapp.model.message.model.MessageContainerSpec.decode(protoInputStream.lengthDelimitedStream());
                case 3 -> timestampSeconds = protoInputStream.readInt64();
                case 4 -> status = it.auties.whatsapp.model.message.model.MessageStatusSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 5 -> senderJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 6 -> messageC2STimestamp = protoInputStream.readInt64();
                case 16 -> ignore = protoInputStream.readBool();
                case 17 -> starred = protoInputStream.readBool();
                case 18 -> broadcast = protoInputStream.readBool();
                case 19 -> pushName = protoInputStream.readString();
                case 20 -> mediaCiphertextSha256 = protoInputStream.readBytes();
                case 21 -> multicast = protoInputStream.readBool();
                case 22 -> urlText = protoInputStream.readBool();
                case 23 -> urlNumber = protoInputStream.readBool();
                case 24 -> stubType = it.auties.whatsapp.model.info.ChatMessageInfoStubTypeSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 25 -> clearMedia = protoInputStream.readBool();
                case 26 -> stubParameters.add(protoInputStream.readString());
                case 27 -> duration = protoInputStream.readInt32();
                case 28 -> labels.add(protoInputStream.readString());
                case 29 -> paymentInfo = it.auties.whatsapp.model.info.PaymentInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 30 -> finalLiveLocation = it.auties.whatsapp.model.message.standard.LiveLocationMessageSpec.decode(protoInputStream.lengthDelimitedStream());
                case 31 -> quotedPaymentInfo = it.auties.whatsapp.model.info.PaymentInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 32 -> ephemeralStartTimestamp = protoInputStream.readInt64();
                case 33 -> ephemeralDuration = protoInputStream.readInt32();
                case 34 -> enableEphemeral = protoInputStream.readBool();
                case 35 -> ephemeralOutOfSync = protoInputStream.readBool();
                case 36 -> businessPrivacyStatus = it.auties.whatsapp.model.business.BusinessPrivacyStatusSpec.decode(protoInputStream.readInt32()).orElse(null);
                case 37 -> businessVerifiedName = protoInputStream.readString();
                case 38 -> mediaData = it.auties.whatsapp.model.media.MediaDataSpec.decode(protoInputStream.lengthDelimitedStream());
                case 39 -> photoChange = it.auties.whatsapp.model.sync.PhotoChangeSpec.decode(protoInputStream.lengthDelimitedStream());
                case 40 -> receipt = it.auties.whatsapp.model.message.model.MessageReceiptSpec.decode(protoInputStream.lengthDelimitedStream());
                case 41 -> reactions.add(it.auties.whatsapp.model.message.standard.ReactionMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 42 -> quotedStickerData = it.auties.whatsapp.model.media.MediaDataSpec.decode(protoInputStream.lengthDelimitedStream());
                case 43 -> futureProofData = protoInputStream.readBytes();
                case 44 -> psaStatus = it.auties.whatsapp.model.message.model.PublicServiceAnnouncementStatusSpec.decode(protoInputStream.lengthDelimitedStream());
                case 45 -> pollUpdates.add(it.auties.whatsapp.model.poll.PollUpdateSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 46 -> pollAdditionalMetadata = it.auties.whatsapp.model.poll.PollAdditionalMetadataSpec.decode(protoInputStream.lengthDelimitedStream());
                case 47 -> agentId = protoInputStream.readString();
                case 48 -> statusAlreadyViewed = protoInputStream.readBool();
                case 49 -> messageSecret = protoInputStream.readBytes();
                case 50 -> keepInChat = it.auties.whatsapp.model.message.model.KeepInChatSpec.decode(protoInputStream.lengthDelimitedStream());
                case 51 -> originalSender = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 52 -> revokeTimestampSeconds = protoInputStream.readInt64();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.info.ChatMessageInfo(key, message, timestampSeconds, status, senderJid, messageC2STimestamp, ignore, starred, broadcast, pushName, mediaCiphertextSha256, multicast, urlText, urlNumber, stubType, clearMedia, stubParameters, duration, labels, paymentInfo, finalLiveLocation, quotedPaymentInfo, ephemeralStartTimestamp, ephemeralDuration, enableEphemeral, ephemeralOutOfSync, businessPrivacyStatus, businessVerifiedName, mediaData, photoChange, receipt, reactions, quotedStickerData, futureProofData, psaStatus, pollUpdates, pollAdditionalMetadata, agentId, statusAlreadyViewed, messageSecret, keepInChat, originalSender, revokeTimestampSeconds);
    }

    public static int sizeOf(ChatMessageInfo object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var key = object.key();
        if (key != null) {
            protoSize += ProtobufOutputStream.getFieldSize(1, 2);
            var keySerializedSize = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.sizeOf(key);
            protoSize += ProtobufOutputStream.getVarIntSize(keySerializedSize);
            protoSize += keySerializedSize;
        }
        var message = object.message();
        if (message != null) {
            protoSize += ProtobufOutputStream.getFieldSize(2, 2);
            var messageSerializedSize = it.auties.whatsapp.model.message.model.MessageContainerSpec.sizeOf(message);
            protoSize += ProtobufOutputStream.getVarIntSize(messageSerializedSize);
            protoSize += messageSerializedSize;
        }
        var timestampSeconds = object.timestampSeconds();
        if (timestampSeconds != null) {
            var timestampSeconds0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableLong(timestampSeconds);
            if (timestampSeconds0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 0);
                protoSize += ProtobufOutputStream.getVarIntSize(timestampSeconds0);
            }
        }
        var status = object.status();
        if (status != null) {
            protoSize += ProtobufOutputStream.getFieldSize(4, 2);
            var statusSerializedSize = it.auties.whatsapp.model.message.model.MessageStatusSpec.sizeOf(status);
            protoSize += statusSerializedSize;
        }
        var senderJid = object.senderJid();
        if (senderJid != null) {
            var senderJid0 = senderJid.toString();
            if (senderJid0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                protoSize += ProtobufOutputStream.getStringSize(senderJid0);
            }
        }
        var messageC2STimestamp = object.messageC2STimestamp();
        protoSize += ProtobufOutputStream.getFieldSize(6, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(messageC2STimestamp);
        var ignore = object.ignore();
        protoSize += ProtobufOutputStream.getFieldSize(16, 0);
        protoSize += 1;
        var starred = object.starred();
        protoSize += ProtobufOutputStream.getFieldSize(17, 0);
        protoSize += 1;
        var broadcast = object.broadcast();
        protoSize += ProtobufOutputStream.getFieldSize(18, 0);
        protoSize += 1;
        var pushName = object.pushName();
        if (pushName != null) {
            var pushName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pushName);
            if (pushName0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(19, 2);
                protoSize += ProtobufOutputStream.getStringSize(pushName0);
            }
        }
        var mediaCiphertextSha256 = object.mediaCiphertextSha256();
        if (mediaCiphertextSha256 != null) {
            var mediaCiphertextSha2560 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaCiphertextSha256);
            if (mediaCiphertextSha2560 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(20, 2);
                protoSize += ProtobufOutputStream.getBytesSize(mediaCiphertextSha2560);
            }
        }
        var multicast = object.multicast();
        protoSize += ProtobufOutputStream.getFieldSize(21, 0);
        protoSize += 1;
        var urlText = object.urlText();
        protoSize += ProtobufOutputStream.getFieldSize(22, 0);
        protoSize += 1;
        var urlNumber = object.urlNumber();
        protoSize += ProtobufOutputStream.getFieldSize(23, 0);
        protoSize += 1;
        var stubType = object.stubType();
        if (stubType != null) {
            var stubType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(stubType);
            if (stubType0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(24, 2);
                var stubType0SerializedSize = it.auties.whatsapp.model.info.ChatMessageInfoStubTypeSpec.sizeOf(stubType0);
                protoSize += stubType0SerializedSize;
            }
        }
        var clearMedia = object.clearMedia();
        protoSize += ProtobufOutputStream.getFieldSize(25, 0);
        protoSize += 1;
        var stubParametersRepeatedField = object.stubParameters();
        if (stubParametersRepeatedField != null) {
            for (var stubParametersEntry : stubParametersRepeatedField) { 
                if (stubParametersEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(26, 2);
                    protoSize += ProtobufOutputStream.getStringSize(stubParametersEntry);
                }
            }
        }
        var duration = object.duration();
        protoSize += ProtobufOutputStream.getFieldSize(27, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(duration);
        var labelsRepeatedField = object.labels();
        if (labelsRepeatedField != null) {
            for (var labelsEntry : labelsRepeatedField) { 
                if (labelsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(28, 2);
                    protoSize += ProtobufOutputStream.getStringSize(labelsEntry);
                }
            }
        }
        var paymentInfo = object.paymentInfo();
        if (paymentInfo != null) {
            var paymentInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(paymentInfo);
            if (paymentInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(29, 2);
                var paymentInfo0SerializedSize = it.auties.whatsapp.model.info.PaymentInfoSpec.sizeOf(paymentInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(paymentInfo0SerializedSize);
                protoSize += paymentInfo0SerializedSize;
            }
        }
        var finalLiveLocation = object.finalLiveLocation();
        if (finalLiveLocation != null) {
            var finalLiveLocation0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(finalLiveLocation);
            if (finalLiveLocation0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(30, 2);
                var finalLiveLocation0SerializedSize = it.auties.whatsapp.model.message.standard.LiveLocationMessageSpec.sizeOf(finalLiveLocation0);
                protoSize += ProtobufOutputStream.getVarIntSize(finalLiveLocation0SerializedSize);
                protoSize += finalLiveLocation0SerializedSize;
            }
        }
        var quotedPaymentInfo = object.quotedPaymentInfo();
        if (quotedPaymentInfo != null) {
            var quotedPaymentInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedPaymentInfo);
            if (quotedPaymentInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(31, 2);
                var quotedPaymentInfo0SerializedSize = it.auties.whatsapp.model.info.PaymentInfoSpec.sizeOf(quotedPaymentInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(quotedPaymentInfo0SerializedSize);
                protoSize += quotedPaymentInfo0SerializedSize;
            }
        }
        var ephemeralStartTimestamp = object.ephemeralStartTimestamp();
        protoSize += ProtobufOutputStream.getFieldSize(32, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(ephemeralStartTimestamp);
        var ephemeralDuration = object.ephemeralDuration();
        protoSize += ProtobufOutputStream.getFieldSize(33, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(ephemeralDuration);
        var enableEphemeral = object.enableEphemeral();
        protoSize += ProtobufOutputStream.getFieldSize(34, 0);
        protoSize += 1;
        var ephemeralOutOfSync = object.ephemeralOutOfSync();
        protoSize += ProtobufOutputStream.getFieldSize(35, 0);
        protoSize += 1;
        var businessPrivacyStatus = object.businessPrivacyStatus();
        if (businessPrivacyStatus != null) {
            var businessPrivacyStatus0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(businessPrivacyStatus);
            if (businessPrivacyStatus0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(36, 2);
                var businessPrivacyStatus0SerializedSize = it.auties.whatsapp.model.business.BusinessPrivacyStatusSpec.sizeOf(businessPrivacyStatus0);
                protoSize += businessPrivacyStatus0SerializedSize;
            }
        }
        var businessVerifiedName = object.businessVerifiedName();
        if (businessVerifiedName != null) {
            var businessVerifiedName0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(businessVerifiedName);
            if (businessVerifiedName0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(37, 2);
                protoSize += ProtobufOutputStream.getStringSize(businessVerifiedName0);
            }
        }
        var mediaData = object.mediaData();
        if (mediaData != null) {
            var mediaData0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(mediaData);
            if (mediaData0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(38, 2);
                var mediaData0SerializedSize = it.auties.whatsapp.model.media.MediaDataSpec.sizeOf(mediaData0);
                protoSize += ProtobufOutputStream.getVarIntSize(mediaData0SerializedSize);
                protoSize += mediaData0SerializedSize;
            }
        }
        var photoChange = object.photoChange();
        if (photoChange != null) {
            var photoChange0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(photoChange);
            if (photoChange0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(39, 2);
                var photoChange0SerializedSize = it.auties.whatsapp.model.sync.PhotoChangeSpec.sizeOf(photoChange0);
                protoSize += ProtobufOutputStream.getVarIntSize(photoChange0SerializedSize);
                protoSize += photoChange0SerializedSize;
            }
        }
        var receipt = object.receipt();
        if (receipt != null) {
            protoSize += ProtobufOutputStream.getFieldSize(40, 2);
            var receiptSerializedSize = it.auties.whatsapp.model.message.model.MessageReceiptSpec.sizeOf(receipt);
            protoSize += ProtobufOutputStream.getVarIntSize(receiptSerializedSize);
            protoSize += receiptSerializedSize;
        }
        var reactionsRepeatedField = object.reactions();
        if (reactionsRepeatedField != null) {
            for (var reactionsEntry : reactionsRepeatedField) { 
                if (reactionsEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(41, 2);
                    var reactionsEntrySerializedSize = it.auties.whatsapp.model.message.standard.ReactionMessageSpec.sizeOf(reactionsEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(reactionsEntrySerializedSize);
                    protoSize += reactionsEntrySerializedSize;
                }
            }
        }
        var quotedStickerData = object.quotedStickerData();
        if (quotedStickerData != null) {
            var quotedStickerData0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedStickerData);
            if (quotedStickerData0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(42, 2);
                var quotedStickerData0SerializedSize = it.auties.whatsapp.model.media.MediaDataSpec.sizeOf(quotedStickerData0);
                protoSize += ProtobufOutputStream.getVarIntSize(quotedStickerData0SerializedSize);
                protoSize += quotedStickerData0SerializedSize;
            }
        }
        var futureProofData = object.futureProofData();
        if (futureProofData != null) {
            protoSize += ProtobufOutputStream.getFieldSize(43, 2);
            protoSize += ProtobufOutputStream.getBytesSize(futureProofData);
        }
        var psaStatus = object.psaStatus();
        if (psaStatus != null) {
            var psaStatus0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(psaStatus);
            if (psaStatus0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(44, 2);
                var psaStatus0SerializedSize = it.auties.whatsapp.model.message.model.PublicServiceAnnouncementStatusSpec.sizeOf(psaStatus0);
                protoSize += ProtobufOutputStream.getVarIntSize(psaStatus0SerializedSize);
                protoSize += psaStatus0SerializedSize;
            }
        }
        var pollUpdatesRepeatedField = object.pollUpdates();
        if (pollUpdatesRepeatedField != null) {
            for (var pollUpdatesEntry : pollUpdatesRepeatedField) { 
                if (pollUpdatesEntry != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(45, 2);
                    var pollUpdatesEntrySerializedSize = it.auties.whatsapp.model.poll.PollUpdateSpec.sizeOf(pollUpdatesEntry);
                    protoSize += ProtobufOutputStream.getVarIntSize(pollUpdatesEntrySerializedSize);
                    protoSize += pollUpdatesEntrySerializedSize;
                }
            }
        }
        var pollAdditionalMetadata = object.pollAdditionalMetadata();
        if (pollAdditionalMetadata != null) {
            var pollAdditionalMetadata0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pollAdditionalMetadata);
            if (pollAdditionalMetadata0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(46, 2);
                var pollAdditionalMetadata0SerializedSize = it.auties.whatsapp.model.poll.PollAdditionalMetadataSpec.sizeOf(pollAdditionalMetadata0);
                protoSize += ProtobufOutputStream.getVarIntSize(pollAdditionalMetadata0SerializedSize);
                protoSize += pollAdditionalMetadata0SerializedSize;
            }
        }
        var agentId = object.agentId();
        if (agentId != null) {
            var agentId0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(agentId);
            if (agentId0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(47, 2);
                protoSize += ProtobufOutputStream.getStringSize(agentId0);
            }
        }
        var statusAlreadyViewed = object.statusAlreadyViewed();
        protoSize += ProtobufOutputStream.getFieldSize(48, 0);
        protoSize += 1;
        var messageSecret = object.messageSecret();
        if (messageSecret != null) {
            var messageSecret0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(messageSecret);
            if (messageSecret0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(49, 2);
                protoSize += ProtobufOutputStream.getBytesSize(messageSecret0);
            }
        }
        var keepInChat = object.keepInChat();
        if (keepInChat != null) {
            var keepInChat0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(keepInChat);
            if (keepInChat0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(50, 2);
                var keepInChat0SerializedSize = it.auties.whatsapp.model.message.model.KeepInChatSpec.sizeOf(keepInChat0);
                protoSize += ProtobufOutputStream.getVarIntSize(keepInChat0SerializedSize);
                protoSize += keepInChat0SerializedSize;
            }
        }
        var originalSender = object.originalSender();
        if (originalSender != null) {
            var originalSender0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(originalSender);
            if (originalSender0 != null) {
                var originalSender1 = originalSender0.toString();
                if (originalSender1 != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(51, 2);
                    protoSize += ProtobufOutputStream.getStringSize(originalSender1);
                }
            }
        }
        var revokeTimestampSeconds = object.revokeTimestampSeconds();
        protoSize += ProtobufOutputStream.getFieldSize(52, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(revokeTimestampSeconds);
        return protoSize;
    }

}
