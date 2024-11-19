package it.auties.whatsapp.model.info;

import it.auties.whatsapp.model.info.ContextInfo;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ContextInfoSpec {
    public static byte[] encode(ContextInfo protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var quotedMessageId = protoInputObject.quotedMessageId();
        if (quotedMessageId != null) {
            var quotedMessageId0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedMessageId);
            if (quotedMessageId0 != null) {
                outputStream.writeString(1, quotedMessageId0);
            }
        }
        var quotedMessageSenderJid = protoInputObject.quotedMessageSenderJid();
        if (quotedMessageSenderJid != null) {
            var quotedMessageSenderJid0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedMessageSenderJid);
            if (quotedMessageSenderJid0 != null) {
                var quotedMessageSenderJid1 = quotedMessageSenderJid0.toString();
                if (quotedMessageSenderJid1 != null) {
                    outputStream.writeString(2, quotedMessageSenderJid1);
                }
            }
        }
        var quotedMessage = protoInputObject.quotedMessage();
        if (quotedMessage != null) {
            var quotedMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedMessage);
            if (quotedMessage0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.message.model.MessageContainerSpec.encode(quotedMessage0));
            }
        }
        var quotedMessageChatJid = protoInputObject.quotedMessageChatJid();
        if (quotedMessageChatJid != null) {
            var quotedMessageChatJid0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedMessageChatJid);
            if (quotedMessageChatJid0 != null) {
                var quotedMessageChatJid1 = quotedMessageChatJid0.toString();
                if (quotedMessageChatJid1 != null) {
                    outputStream.writeString(4, quotedMessageChatJid1);
                }
            }
        }
        if (protoInputObject.mentions() != null) {
            for (var mentionsEntry : protoInputObject.mentions()) { 
                var mentions = mentionsEntry;
                if (mentions != null) {
                    var mentions0 = mentions.toString();
                    if (mentions0 != null) {
                        outputStream.writeString(15, mentions0);
                    }
                }
            }
        }
        var conversionSource = protoInputObject.conversionSource();
        if (conversionSource != null) {
            var conversionSource0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(conversionSource);
            if (conversionSource0 != null) {
                outputStream.writeString(18, conversionSource0);
            }
        }
        var conversionData = protoInputObject.conversionData();
        if (conversionData != null) {
            var conversionData0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(conversionData);
            if (conversionData0 != null) {
                outputStream.writeBytes(19, conversionData0);
            }
        }
        outputStream.writeUInt32(20, protoInputObject.conversionDelaySeconds());
        outputStream.writeUInt32(21, protoInputObject.forwardingScore());
        outputStream.writeBool(22, protoInputObject.forwarded());
        var quotedAd = protoInputObject.quotedAd();
        if (quotedAd != null) {
            var quotedAd0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedAd);
            if (quotedAd0 != null) {
                outputStream.writeBytes(23, it.auties.whatsapp.model.info.AdReplyInfoSpec.encode(quotedAd0));
            }
        }
        var placeholderKey = protoInputObject.placeholderKey();
        if (placeholderKey != null) {
            var placeholderKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(placeholderKey);
            if (placeholderKey0 != null) {
                outputStream.writeBytes(24, it.auties.whatsapp.model.message.model.ChatMessageKeySpec.encode(placeholderKey0));
            }
        }
        outputStream.writeUInt32(25, protoInputObject.ephemeralExpiration());
        outputStream.writeInt64(26, protoInputObject.ephemeralSettingTimestamp());
        var ephemeralSharedSecret = protoInputObject.ephemeralSharedSecret();
        if (ephemeralSharedSecret != null) {
            var ephemeralSharedSecret0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(ephemeralSharedSecret);
            if (ephemeralSharedSecret0 != null) {
                outputStream.writeBytes(27, ephemeralSharedSecret0);
            }
        }
        var externalAdReply = protoInputObject.externalAdReply();
        if (externalAdReply != null) {
            var externalAdReply0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(externalAdReply);
            if (externalAdReply0 != null) {
                outputStream.writeBytes(28, it.auties.whatsapp.model.info.ExternalAdReplyInfoSpec.encode(externalAdReply0));
            }
        }
        var entryPointConversionSource = protoInputObject.entryPointConversionSource();
        if (entryPointConversionSource != null) {
            var entryPointConversionSource0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(entryPointConversionSource);
            if (entryPointConversionSource0 != null) {
                outputStream.writeString(29, entryPointConversionSource0);
            }
        }
        var entryPointConversionApp = protoInputObject.entryPointConversionApp();
        if (entryPointConversionApp != null) {
            var entryPointConversionApp0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(entryPointConversionApp);
            if (entryPointConversionApp0 != null) {
                outputStream.writeString(30, entryPointConversionApp0);
            }
        }
        outputStream.writeUInt32(31, protoInputObject.entryPointConversionDelaySeconds());
        var disappearingMode = protoInputObject.disappearingMode();
        if (disappearingMode != null) {
            var disappearingMode0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(disappearingMode);
            if (disappearingMode0 != null) {
                outputStream.writeBytes(32, it.auties.whatsapp.model.chat.ChatDisappearSpec.encode(disappearingMode0));
            }
        }
        var actionLink = protoInputObject.actionLink();
        if (actionLink != null) {
            var actionLink0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(actionLink);
            if (actionLink0 != null) {
                outputStream.writeBytes(33, it.auties.whatsapp.model.button.base.ButtonActionLinkSpec.encode(actionLink0));
            }
        }
        var groupSubject = protoInputObject.groupSubject();
        if (groupSubject != null) {
            var groupSubject0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(groupSubject);
            if (groupSubject0 != null) {
                outputStream.writeString(34, groupSubject0);
            }
        }
        var parentGroup = protoInputObject.parentGroup();
        if (parentGroup != null) {
            var parentGroup0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(parentGroup);
            if (parentGroup0 != null) {
                var parentGroup1 = parentGroup0.toString();
                if (parentGroup1 != null) {
                    outputStream.writeString(35, parentGroup1);
                }
            }
        }
        var trustBannerType = protoInputObject.trustBannerType();
        if (trustBannerType != null) {
            var trustBannerType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(trustBannerType);
            if (trustBannerType0 != null) {
                outputStream.writeString(37, trustBannerType0);
            }
        }
        outputStream.writeUInt32(38, protoInputObject.trustBannerAction());
        return outputStream.toByteArray();
    }

    public static ContextInfo decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ContextInfo decode(ProtobufInputStream protoInputStream) {
        java.lang.String quotedMessageId = null;
        it.auties.whatsapp.model.jid.Jid quotedMessageSenderJid = null;
        it.auties.whatsapp.model.message.model.MessageContainer quotedMessage = null;
        it.auties.whatsapp.model.jid.Jid quotedMessageChatJid = null;
        java.util.List<it.auties.whatsapp.model.jid.Jid> mentions = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        java.lang.String conversionSource = null;
        byte[] conversionData = null;
        int conversionDelaySeconds = 0;
        int forwardingScore = 0;
        boolean forwarded = false;
        it.auties.whatsapp.model.info.AdReplyInfo quotedAd = null;
        it.auties.whatsapp.model.message.model.ChatMessageKey placeholderKey = null;
        int ephemeralExpiration = 0;
        long ephemeralSettingTimestamp = 0l;
        byte[] ephemeralSharedSecret = null;
        it.auties.whatsapp.model.info.ExternalAdReplyInfo externalAdReply = null;
        java.lang.String entryPointConversionSource = null;
        java.lang.String entryPointConversionApp = null;
        int entryPointConversionDelaySeconds = 0;
        it.auties.whatsapp.model.chat.ChatDisappear disappearingMode = null;
        it.auties.whatsapp.model.button.base.ButtonActionLink actionLink = null;
        java.lang.String groupSubject = null;
        it.auties.whatsapp.model.jid.Jid parentGroup = null;
        java.lang.String trustBannerType = null;
        int trustBannerAction = 0;
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> quotedMessageId = protoInputStream.readString();
                case 2 -> quotedMessageSenderJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 3 -> quotedMessage = it.auties.whatsapp.model.message.model.MessageContainerSpec.decode(protoInputStream.lengthDelimitedStream());
                case 4 -> quotedMessageChatJid = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 15 -> mentions.add(it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString()));
                case 18 -> conversionSource = protoInputStream.readString();
                case 19 -> conversionData = protoInputStream.readBytes();
                case 20 -> conversionDelaySeconds = protoInputStream.readInt32();
                case 21 -> forwardingScore = protoInputStream.readInt32();
                case 22 -> forwarded = protoInputStream.readBool();
                case 23 -> quotedAd = it.auties.whatsapp.model.info.AdReplyInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 24 -> placeholderKey = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.decode(protoInputStream.lengthDelimitedStream());
                case 25 -> ephemeralExpiration = protoInputStream.readInt32();
                case 26 -> ephemeralSettingTimestamp = protoInputStream.readInt64();
                case 27 -> ephemeralSharedSecret = protoInputStream.readBytes();
                case 28 -> externalAdReply = it.auties.whatsapp.model.info.ExternalAdReplyInfoSpec.decode(protoInputStream.lengthDelimitedStream());
                case 29 -> entryPointConversionSource = protoInputStream.readString();
                case 30 -> entryPointConversionApp = protoInputStream.readString();
                case 31 -> entryPointConversionDelaySeconds = protoInputStream.readInt32();
                case 32 -> disappearingMode = it.auties.whatsapp.model.chat.ChatDisappearSpec.decode(protoInputStream.lengthDelimitedStream());
                case 33 -> actionLink = it.auties.whatsapp.model.button.base.ButtonActionLinkSpec.decode(protoInputStream.lengthDelimitedStream());
                case 34 -> groupSubject = protoInputStream.readString();
                case 35 -> parentGroup = it.auties.whatsapp.model.jid.Jid.ofProtobuf(protoInputStream.readString());
                case 37 -> trustBannerType = protoInputStream.readString();
                case 38 -> trustBannerAction = protoInputStream.readInt32();
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.info.ContextInfo(quotedMessageId, quotedMessageSenderJid, quotedMessage, quotedMessageChatJid, mentions, conversionSource, conversionData, conversionDelaySeconds, forwardingScore, forwarded, quotedAd, placeholderKey, ephemeralExpiration, ephemeralSettingTimestamp, ephemeralSharedSecret, externalAdReply, entryPointConversionSource, entryPointConversionApp, entryPointConversionDelaySeconds, disappearingMode, actionLink, groupSubject, parentGroup, trustBannerType, trustBannerAction);
    }

    public static int sizeOf(ContextInfo object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var quotedMessageId = object.quotedMessageId();
        if (quotedMessageId != null) {
            var quotedMessageId0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedMessageId);
            if (quotedMessageId0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(quotedMessageId0);
            }
        }
        var quotedMessageSenderJid = object.quotedMessageSenderJid();
        if (quotedMessageSenderJid != null) {
            var quotedMessageSenderJid0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedMessageSenderJid);
            if (quotedMessageSenderJid0 != null) {
                var quotedMessageSenderJid1 = quotedMessageSenderJid0.toString();
                if (quotedMessageSenderJid1 != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                    protoSize += ProtobufOutputStream.getStringSize(quotedMessageSenderJid1);
                }
            }
        }
        var quotedMessage = object.quotedMessage();
        if (quotedMessage != null) {
            var quotedMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedMessage);
            if (quotedMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var quotedMessage0SerializedSize = it.auties.whatsapp.model.message.model.MessageContainerSpec.sizeOf(quotedMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(quotedMessage0SerializedSize);
                protoSize += quotedMessage0SerializedSize;
            }
        }
        var quotedMessageChatJid = object.quotedMessageChatJid();
        if (quotedMessageChatJid != null) {
            var quotedMessageChatJid0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedMessageChatJid);
            if (quotedMessageChatJid0 != null) {
                var quotedMessageChatJid1 = quotedMessageChatJid0.toString();
                if (quotedMessageChatJid1 != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                    protoSize += ProtobufOutputStream.getStringSize(quotedMessageChatJid1);
                }
            }
        }
        var mentionsRepeatedField = object.mentions();
        if (mentionsRepeatedField != null) {
            for (var mentionsEntry : mentionsRepeatedField) { 
                if (mentionsEntry != null) {
                    var mentionsEntry0 = mentionsEntry.toString();
                    if (mentionsEntry0 != null) {
                        protoSize += ProtobufOutputStream.getFieldSize(15, 2);
                        protoSize += ProtobufOutputStream.getStringSize(mentionsEntry0);
                    }
                }
            }
        }
        var conversionSource = object.conversionSource();
        if (conversionSource != null) {
            var conversionSource0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(conversionSource);
            if (conversionSource0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(18, 2);
                protoSize += ProtobufOutputStream.getStringSize(conversionSource0);
            }
        }
        var conversionData = object.conversionData();
        if (conversionData != null) {
            var conversionData0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(conversionData);
            if (conversionData0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(19, 2);
                protoSize += ProtobufOutputStream.getBytesSize(conversionData0);
            }
        }
        var conversionDelaySeconds = object.conversionDelaySeconds();
        protoSize += ProtobufOutputStream.getFieldSize(20, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(conversionDelaySeconds);
        var forwardingScore = object.forwardingScore();
        protoSize += ProtobufOutputStream.getFieldSize(21, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(forwardingScore);
        var forwarded = object.forwarded();
        protoSize += ProtobufOutputStream.getFieldSize(22, 0);
        protoSize += 1;
        var quotedAd = object.quotedAd();
        if (quotedAd != null) {
            var quotedAd0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quotedAd);
            if (quotedAd0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(23, 2);
                var quotedAd0SerializedSize = it.auties.whatsapp.model.info.AdReplyInfoSpec.sizeOf(quotedAd0);
                protoSize += ProtobufOutputStream.getVarIntSize(quotedAd0SerializedSize);
                protoSize += quotedAd0SerializedSize;
            }
        }
        var placeholderKey = object.placeholderKey();
        if (placeholderKey != null) {
            var placeholderKey0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(placeholderKey);
            if (placeholderKey0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(24, 2);
                var placeholderKey0SerializedSize = it.auties.whatsapp.model.message.model.ChatMessageKeySpec.sizeOf(placeholderKey0);
                protoSize += ProtobufOutputStream.getVarIntSize(placeholderKey0SerializedSize);
                protoSize += placeholderKey0SerializedSize;
            }
        }
        var ephemeralExpiration = object.ephemeralExpiration();
        protoSize += ProtobufOutputStream.getFieldSize(25, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(ephemeralExpiration);
        var ephemeralSettingTimestamp = object.ephemeralSettingTimestamp();
        protoSize += ProtobufOutputStream.getFieldSize(26, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(ephemeralSettingTimestamp);
        var ephemeralSharedSecret = object.ephemeralSharedSecret();
        if (ephemeralSharedSecret != null) {
            var ephemeralSharedSecret0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(ephemeralSharedSecret);
            if (ephemeralSharedSecret0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(27, 2);
                protoSize += ProtobufOutputStream.getBytesSize(ephemeralSharedSecret0);
            }
        }
        var externalAdReply = object.externalAdReply();
        if (externalAdReply != null) {
            var externalAdReply0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(externalAdReply);
            if (externalAdReply0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(28, 2);
                var externalAdReply0SerializedSize = it.auties.whatsapp.model.info.ExternalAdReplyInfoSpec.sizeOf(externalAdReply0);
                protoSize += ProtobufOutputStream.getVarIntSize(externalAdReply0SerializedSize);
                protoSize += externalAdReply0SerializedSize;
            }
        }
        var entryPointConversionSource = object.entryPointConversionSource();
        if (entryPointConversionSource != null) {
            var entryPointConversionSource0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(entryPointConversionSource);
            if (entryPointConversionSource0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(29, 2);
                protoSize += ProtobufOutputStream.getStringSize(entryPointConversionSource0);
            }
        }
        var entryPointConversionApp = object.entryPointConversionApp();
        if (entryPointConversionApp != null) {
            var entryPointConversionApp0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(entryPointConversionApp);
            if (entryPointConversionApp0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(30, 2);
                protoSize += ProtobufOutputStream.getStringSize(entryPointConversionApp0);
            }
        }
        var entryPointConversionDelaySeconds = object.entryPointConversionDelaySeconds();
        protoSize += ProtobufOutputStream.getFieldSize(31, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(entryPointConversionDelaySeconds);
        var disappearingMode = object.disappearingMode();
        if (disappearingMode != null) {
            var disappearingMode0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(disappearingMode);
            if (disappearingMode0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(32, 2);
                var disappearingMode0SerializedSize = it.auties.whatsapp.model.chat.ChatDisappearSpec.sizeOf(disappearingMode0);
                protoSize += ProtobufOutputStream.getVarIntSize(disappearingMode0SerializedSize);
                protoSize += disappearingMode0SerializedSize;
            }
        }
        var actionLink = object.actionLink();
        if (actionLink != null) {
            var actionLink0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(actionLink);
            if (actionLink0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(33, 2);
                var actionLink0SerializedSize = it.auties.whatsapp.model.button.base.ButtonActionLinkSpec.sizeOf(actionLink0);
                protoSize += ProtobufOutputStream.getVarIntSize(actionLink0SerializedSize);
                protoSize += actionLink0SerializedSize;
            }
        }
        var groupSubject = object.groupSubject();
        if (groupSubject != null) {
            var groupSubject0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(groupSubject);
            if (groupSubject0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(34, 2);
                protoSize += ProtobufOutputStream.getStringSize(groupSubject0);
            }
        }
        var parentGroup = object.parentGroup();
        if (parentGroup != null) {
            var parentGroup0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(parentGroup);
            if (parentGroup0 != null) {
                var parentGroup1 = parentGroup0.toString();
                if (parentGroup1 != null) {
                    protoSize += ProtobufOutputStream.getFieldSize(35, 2);
                    protoSize += ProtobufOutputStream.getStringSize(parentGroup1);
                }
            }
        }
        var trustBannerType = object.trustBannerType();
        if (trustBannerType != null) {
            var trustBannerType0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(trustBannerType);
            if (trustBannerType0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(37, 2);
                protoSize += ProtobufOutputStream.getStringSize(trustBannerType0);
            }
        }
        var trustBannerAction = object.trustBannerAction();
        protoSize += ProtobufOutputStream.getFieldSize(38, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(trustBannerAction);
        return protoSize;
    }

}
