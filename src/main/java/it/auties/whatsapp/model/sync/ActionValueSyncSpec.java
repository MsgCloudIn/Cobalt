package it.auties.whatsapp.model.sync;

import it.auties.whatsapp.model.sync.ActionValueSync;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class ActionValueSyncSpec {
    public static byte[] encode(ActionValueSync protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        outputStream.writeInt64(1, protoInputObject.timestamp());
        var starAction = protoInputObject.starAction();
        if (starAction != null) {
            var starAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(starAction);
            if (starAction0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.action.StarActionSpec.encode(starAction0));
            }
        }
        var contactAction = protoInputObject.contactAction();
        if (contactAction != null) {
            var contactAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contactAction);
            if (contactAction0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.action.ContactActionSpec.encode(contactAction0));
            }
        }
        var muteAction = protoInputObject.muteAction();
        if (muteAction != null) {
            var muteAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(muteAction);
            if (muteAction0 != null) {
                outputStream.writeBytes(4, it.auties.whatsapp.model.action.MuteActionSpec.encode(muteAction0));
            }
        }
        var pinAction = protoInputObject.pinAction();
        if (pinAction != null) {
            var pinAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pinAction);
            if (pinAction0 != null) {
                outputStream.writeBytes(5, it.auties.whatsapp.model.action.PinActionSpec.encode(pinAction0));
            }
        }
        var quickReplyAction = protoInputObject.quickReplyAction();
        if (quickReplyAction != null) {
            var quickReplyAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quickReplyAction);
            if (quickReplyAction0 != null) {
                outputStream.writeBytes(8, it.auties.whatsapp.model.action.QuickReplyActionSpec.encode(quickReplyAction0));
            }
        }
        var recentEmojiWeightsAction = protoInputObject.recentEmojiWeightsAction();
        if (recentEmojiWeightsAction != null) {
            var recentEmojiWeightsAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(recentEmojiWeightsAction);
            if (recentEmojiWeightsAction0 != null) {
                outputStream.writeBytes(11, it.auties.whatsapp.model.action.RecentEmojiWeightsActionSpec.encode(recentEmojiWeightsAction0));
            }
        }
        var labelEditAction = protoInputObject.labelEditAction();
        if (labelEditAction != null) {
            var labelEditAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(labelEditAction);
            if (labelEditAction0 != null) {
                outputStream.writeBytes(14, it.auties.whatsapp.model.action.LabelEditActionSpec.encode(labelEditAction0));
            }
        }
        var labelAssociationAction = protoInputObject.labelAssociationAction();
        if (labelAssociationAction != null) {
            var labelAssociationAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(labelAssociationAction);
            if (labelAssociationAction0 != null) {
                outputStream.writeBytes(15, it.auties.whatsapp.model.action.LabelAssociationActionSpec.encode(labelAssociationAction0));
            }
        }
        var archiveChatAction = protoInputObject.archiveChatAction();
        if (archiveChatAction != null) {
            var archiveChatAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(archiveChatAction);
            if (archiveChatAction0 != null) {
                outputStream.writeBytes(17, it.auties.whatsapp.model.action.ArchiveChatActionSpec.encode(archiveChatAction0));
            }
        }
        var deleteMessageForMeAction = protoInputObject.deleteMessageForMeAction();
        if (deleteMessageForMeAction != null) {
            var deleteMessageForMeAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deleteMessageForMeAction);
            if (deleteMessageForMeAction0 != null) {
                outputStream.writeBytes(18, it.auties.whatsapp.model.action.DeleteMessageForMeActionSpec.encode(deleteMessageForMeAction0));
            }
        }
        var markChatAsReadAction = protoInputObject.markChatAsReadAction();
        if (markChatAsReadAction != null) {
            var markChatAsReadAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(markChatAsReadAction);
            if (markChatAsReadAction0 != null) {
                outputStream.writeBytes(20, it.auties.whatsapp.model.action.MarkChatAsReadActionSpec.encode(markChatAsReadAction0));
            }
        }
        var clearChatAction = protoInputObject.clearChatAction();
        if (clearChatAction != null) {
            var clearChatAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(clearChatAction);
            if (clearChatAction0 != null) {
                outputStream.writeBytes(21, it.auties.whatsapp.model.action.ClearChatActionSpec.encode(clearChatAction0));
            }
        }
        var deleteChatAction = protoInputObject.deleteChatAction();
        if (deleteChatAction != null) {
            var deleteChatAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deleteChatAction);
            if (deleteChatAction0 != null) {
                outputStream.writeBytes(22, it.auties.whatsapp.model.action.DeleteChatActionSpec.encode(deleteChatAction0));
            }
        }
        var favoriteStickerAction = protoInputObject.favoriteStickerAction();
        if (favoriteStickerAction != null) {
            var favoriteStickerAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(favoriteStickerAction);
            if (favoriteStickerAction0 != null) {
                outputStream.writeBytes(25, it.auties.whatsapp.model.action.StickerActionSpec.encode(favoriteStickerAction0));
            }
        }
        var androidUnsupportedActions = protoInputObject.androidUnsupportedActions();
        if (androidUnsupportedActions != null) {
            var androidUnsupportedActions0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(androidUnsupportedActions);
            if (androidUnsupportedActions0 != null) {
                outputStream.writeBytes(26, it.auties.whatsapp.model.action.AndroidUnsupportedActionsSpec.encode(androidUnsupportedActions0));
            }
        }
        var agentAction = protoInputObject.agentAction();
        if (agentAction != null) {
            var agentAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(agentAction);
            if (agentAction0 != null) {
                outputStream.writeBytes(27, it.auties.whatsapp.model.action.AgentActionSpec.encode(agentAction0));
            }
        }
        var subscriptionAction = protoInputObject.subscriptionAction();
        if (subscriptionAction != null) {
            var subscriptionAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(subscriptionAction);
            if (subscriptionAction0 != null) {
                outputStream.writeBytes(28, it.auties.whatsapp.model.action.SubscriptionActionSpec.encode(subscriptionAction0));
            }
        }
        var userStatusMuteAction = protoInputObject.userStatusMuteAction();
        if (userStatusMuteAction != null) {
            var userStatusMuteAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(userStatusMuteAction);
            if (userStatusMuteAction0 != null) {
                outputStream.writeBytes(29, it.auties.whatsapp.model.action.UserStatusMuteActionSpec.encode(userStatusMuteAction0));
            }
        }
        var timeFormatAction = protoInputObject.timeFormatAction();
        if (timeFormatAction != null) {
            var timeFormatAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(timeFormatAction);
            if (timeFormatAction0 != null) {
                outputStream.writeBytes(30, it.auties.whatsapp.model.action.TimeFormatActionSpec.encode(timeFormatAction0));
            }
        }
        var nuxAction = protoInputObject.nuxAction();
        if (nuxAction != null) {
            var nuxAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(nuxAction);
            if (nuxAction0 != null) {
                outputStream.writeBytes(31, it.auties.whatsapp.model.action.NuxActionSpec.encode(nuxAction0));
            }
        }
        var primaryVersionAction = protoInputObject.primaryVersionAction();
        if (primaryVersionAction != null) {
            var primaryVersionAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(primaryVersionAction);
            if (primaryVersionAction0 != null) {
                outputStream.writeBytes(32, it.auties.whatsapp.model.action.PrimaryVersionActionSpec.encode(primaryVersionAction0));
            }
        }
        var stickerAction = protoInputObject.stickerAction();
        if (stickerAction != null) {
            var stickerAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(stickerAction);
            if (stickerAction0 != null) {
                outputStream.writeBytes(33, it.auties.whatsapp.model.action.StickerActionSpec.encode(stickerAction0));
            }
        }
        var removeRecentStickerAction = protoInputObject.removeRecentStickerAction();
        if (removeRecentStickerAction != null) {
            var removeRecentStickerAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(removeRecentStickerAction);
            if (removeRecentStickerAction0 != null) {
                outputStream.writeBytes(34, it.auties.whatsapp.model.action.RemoveRecentStickerActionSpec.encode(removeRecentStickerAction0));
            }
        }
        var chatAssignmentAction = protoInputObject.chatAssignmentAction();
        if (chatAssignmentAction != null) {
            var chatAssignmentAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(chatAssignmentAction);
            if (chatAssignmentAction0 != null) {
                outputStream.writeBytes(35, it.auties.whatsapp.model.action.ChatAssignmentActionSpec.encode(chatAssignmentAction0));
            }
        }
        var chatAssignmentOpenedStatusAction = protoInputObject.chatAssignmentOpenedStatusAction();
        if (chatAssignmentOpenedStatusAction != null) {
            var chatAssignmentOpenedStatusAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(chatAssignmentOpenedStatusAction);
            if (chatAssignmentOpenedStatusAction0 != null) {
                outputStream.writeBytes(36, it.auties.whatsapp.model.action.ChatAssignmentOpenedStatusActionSpec.encode(chatAssignmentOpenedStatusAction0));
            }
        }
        var securityNotificationSetting = protoInputObject.securityNotificationSetting();
        if (securityNotificationSetting != null) {
            var securityNotificationSetting0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(securityNotificationSetting);
            if (securityNotificationSetting0 != null) {
                outputStream.writeBytes(6, it.auties.whatsapp.model.setting.SecurityNotificationSettingsSpec.encode(securityNotificationSetting0));
            }
        }
        var pushNameSetting = protoInputObject.pushNameSetting();
        if (pushNameSetting != null) {
            var pushNameSetting0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pushNameSetting);
            if (pushNameSetting0 != null) {
                outputStream.writeBytes(7, it.auties.whatsapp.model.setting.PushNameSettingsSpec.encode(pushNameSetting0));
            }
        }
        var localeSetting = protoInputObject.localeSetting();
        if (localeSetting != null) {
            var localeSetting0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(localeSetting);
            if (localeSetting0 != null) {
                outputStream.writeBytes(16, it.auties.whatsapp.model.setting.LocaleSettingsSpec.encode(localeSetting0));
            }
        }
        var unarchiveChatsSetting = protoInputObject.unarchiveChatsSetting();
        if (unarchiveChatsSetting != null) {
            var unarchiveChatsSetting0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(unarchiveChatsSetting);
            if (unarchiveChatsSetting0 != null) {
                outputStream.writeBytes(23, it.auties.whatsapp.model.setting.UnarchiveChatsSettingsSpec.encode(unarchiveChatsSetting0));
            }
        }
        var stickerMetadata = protoInputObject.stickerMetadata();
        if (stickerMetadata != null) {
            var stickerMetadata0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(stickerMetadata);
            if (stickerMetadata0 != null) {
                outputStream.writeBytes(10, it.auties.whatsapp.model.sync.StickerMetadataSpec.encode(stickerMetadata0));
            }
        }
        var keyExpiration = protoInputObject.keyExpiration();
        if (keyExpiration != null) {
            var keyExpiration0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(keyExpiration);
            if (keyExpiration0 != null) {
                outputStream.writeBytes(19, it.auties.whatsapp.model.sync.KeyExpirationSpec.encode(keyExpiration0));
            }
        }
        var primaryFeature = protoInputObject.primaryFeature();
        if (primaryFeature != null) {
            var primaryFeature0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(primaryFeature);
            if (primaryFeature0 != null) {
                outputStream.writeBytes(24, it.auties.whatsapp.model.sync.PrimaryFeatureSpec.encode(primaryFeature0));
            }
        }
        return outputStream.toByteArray();
    }

    public static ActionValueSync decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static ActionValueSync decode(ProtobufInputStream protoInputStream) {
        long timestamp = 0l;
        java.util.Optional<it.auties.whatsapp.model.action.StarAction> starAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.ContactAction> contactAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.MuteAction> muteAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.PinAction> pinAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.QuickReplyAction> quickReplyAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.RecentEmojiWeightsAction> recentEmojiWeightsAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.LabelEditAction> labelEditAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.LabelAssociationAction> labelAssociationAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.ArchiveChatAction> archiveChatAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.DeleteMessageForMeAction> deleteMessageForMeAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.MarkChatAsReadAction> markChatAsReadAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.ClearChatAction> clearChatAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.DeleteChatAction> deleteChatAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.StickerAction> favoriteStickerAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.AndroidUnsupportedActions> androidUnsupportedActions = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.AgentAction> agentAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.SubscriptionAction> subscriptionAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.UserStatusMuteAction> userStatusMuteAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.TimeFormatAction> timeFormatAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.NuxAction> nuxAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.PrimaryVersionAction> primaryVersionAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.StickerAction> stickerAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.RemoveRecentStickerAction> removeRecentStickerAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.ChatAssignmentAction> chatAssignmentAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.action.ChatAssignmentOpenedStatusAction> chatAssignmentOpenedStatusAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.setting.SecurityNotificationSettings> securityNotificationSetting = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.setting.PushNameSettings> pushNameSetting = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.setting.LocaleSettings> localeSetting = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.setting.UnarchiveChatsSettings> unarchiveChatsSetting = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.sync.StickerMetadata> stickerMetadata = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.sync.KeyExpiration> keyExpiration = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.sync.PrimaryFeature> primaryFeature = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> timestamp = protoInputStream.readInt64();
                case 2 -> starAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.StarActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 3 -> contactAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.ContactActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 4 -> muteAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.MuteActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 5 -> pinAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.PinActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 8 -> quickReplyAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.QuickReplyActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 11 -> recentEmojiWeightsAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.RecentEmojiWeightsActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 14 -> labelEditAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.LabelEditActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 15 -> labelAssociationAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.LabelAssociationActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 17 -> archiveChatAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.ArchiveChatActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 18 -> deleteMessageForMeAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.DeleteMessageForMeActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 20 -> markChatAsReadAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.MarkChatAsReadActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 21 -> clearChatAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.ClearChatActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 22 -> deleteChatAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.DeleteChatActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 25 -> favoriteStickerAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.StickerActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 26 -> androidUnsupportedActions = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.AndroidUnsupportedActionsSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 27 -> agentAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.AgentActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 28 -> subscriptionAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.SubscriptionActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 29 -> userStatusMuteAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.UserStatusMuteActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 30 -> timeFormatAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.TimeFormatActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 31 -> nuxAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.NuxActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 32 -> primaryVersionAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.PrimaryVersionActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 33 -> stickerAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.StickerActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 34 -> removeRecentStickerAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.RemoveRecentStickerActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 35 -> chatAssignmentAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.ChatAssignmentActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 36 -> chatAssignmentOpenedStatusAction = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.action.ChatAssignmentOpenedStatusActionSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 6 -> securityNotificationSetting = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.setting.SecurityNotificationSettingsSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 7 -> pushNameSetting = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.setting.PushNameSettingsSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 16 -> localeSetting = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.setting.LocaleSettingsSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 23 -> unarchiveChatsSetting = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.setting.UnarchiveChatsSettingsSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 10 -> stickerMetadata = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.sync.StickerMetadataSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 19 -> keyExpiration = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.sync.KeyExpirationSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 24 -> primaryFeature = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.sync.PrimaryFeatureSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.sync.ActionValueSync(timestamp, starAction, contactAction, muteAction, pinAction, quickReplyAction, recentEmojiWeightsAction, labelEditAction, labelAssociationAction, archiveChatAction, deleteMessageForMeAction, markChatAsReadAction, clearChatAction, deleteChatAction, favoriteStickerAction, androidUnsupportedActions, agentAction, subscriptionAction, userStatusMuteAction, timeFormatAction, nuxAction, primaryVersionAction, stickerAction, removeRecentStickerAction, chatAssignmentAction, chatAssignmentOpenedStatusAction, securityNotificationSetting, pushNameSetting, localeSetting, unarchiveChatsSetting, stickerMetadata, keyExpiration, primaryFeature);
    }

    public static int sizeOf(ActionValueSync object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var timestamp = object.timestamp();
        protoSize += ProtobufOutputStream.getFieldSize(1, 0);
        protoSize += ProtobufOutputStream.getVarIntSize(timestamp);
        var starAction = object.starAction();
        if (starAction != null) {
            var starAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(starAction);
            if (starAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var starAction0SerializedSize = it.auties.whatsapp.model.action.StarActionSpec.sizeOf(starAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(starAction0SerializedSize);
                protoSize += starAction0SerializedSize;
            }
        }
        var contactAction = object.contactAction();
        if (contactAction != null) {
            var contactAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contactAction);
            if (contactAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var contactAction0SerializedSize = it.auties.whatsapp.model.action.ContactActionSpec.sizeOf(contactAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(contactAction0SerializedSize);
                protoSize += contactAction0SerializedSize;
            }
        }
        var muteAction = object.muteAction();
        if (muteAction != null) {
            var muteAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(muteAction);
            if (muteAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var muteAction0SerializedSize = it.auties.whatsapp.model.action.MuteActionSpec.sizeOf(muteAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(muteAction0SerializedSize);
                protoSize += muteAction0SerializedSize;
            }
        }
        var pinAction = object.pinAction();
        if (pinAction != null) {
            var pinAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pinAction);
            if (pinAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                var pinAction0SerializedSize = it.auties.whatsapp.model.action.PinActionSpec.sizeOf(pinAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(pinAction0SerializedSize);
                protoSize += pinAction0SerializedSize;
            }
        }
        var quickReplyAction = object.quickReplyAction();
        if (quickReplyAction != null) {
            var quickReplyAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(quickReplyAction);
            if (quickReplyAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                var quickReplyAction0SerializedSize = it.auties.whatsapp.model.action.QuickReplyActionSpec.sizeOf(quickReplyAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(quickReplyAction0SerializedSize);
                protoSize += quickReplyAction0SerializedSize;
            }
        }
        var recentEmojiWeightsAction = object.recentEmojiWeightsAction();
        if (recentEmojiWeightsAction != null) {
            var recentEmojiWeightsAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(recentEmojiWeightsAction);
            if (recentEmojiWeightsAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(11, 2);
                var recentEmojiWeightsAction0SerializedSize = it.auties.whatsapp.model.action.RecentEmojiWeightsActionSpec.sizeOf(recentEmojiWeightsAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(recentEmojiWeightsAction0SerializedSize);
                protoSize += recentEmojiWeightsAction0SerializedSize;
            }
        }
        var labelEditAction = object.labelEditAction();
        if (labelEditAction != null) {
            var labelEditAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(labelEditAction);
            if (labelEditAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(14, 2);
                var labelEditAction0SerializedSize = it.auties.whatsapp.model.action.LabelEditActionSpec.sizeOf(labelEditAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(labelEditAction0SerializedSize);
                protoSize += labelEditAction0SerializedSize;
            }
        }
        var labelAssociationAction = object.labelAssociationAction();
        if (labelAssociationAction != null) {
            var labelAssociationAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(labelAssociationAction);
            if (labelAssociationAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(15, 2);
                var labelAssociationAction0SerializedSize = it.auties.whatsapp.model.action.LabelAssociationActionSpec.sizeOf(labelAssociationAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(labelAssociationAction0SerializedSize);
                protoSize += labelAssociationAction0SerializedSize;
            }
        }
        var archiveChatAction = object.archiveChatAction();
        if (archiveChatAction != null) {
            var archiveChatAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(archiveChatAction);
            if (archiveChatAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(17, 2);
                var archiveChatAction0SerializedSize = it.auties.whatsapp.model.action.ArchiveChatActionSpec.sizeOf(archiveChatAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(archiveChatAction0SerializedSize);
                protoSize += archiveChatAction0SerializedSize;
            }
        }
        var deleteMessageForMeAction = object.deleteMessageForMeAction();
        if (deleteMessageForMeAction != null) {
            var deleteMessageForMeAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deleteMessageForMeAction);
            if (deleteMessageForMeAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(18, 2);
                var deleteMessageForMeAction0SerializedSize = it.auties.whatsapp.model.action.DeleteMessageForMeActionSpec.sizeOf(deleteMessageForMeAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(deleteMessageForMeAction0SerializedSize);
                protoSize += deleteMessageForMeAction0SerializedSize;
            }
        }
        var markChatAsReadAction = object.markChatAsReadAction();
        if (markChatAsReadAction != null) {
            var markChatAsReadAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(markChatAsReadAction);
            if (markChatAsReadAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(20, 2);
                var markChatAsReadAction0SerializedSize = it.auties.whatsapp.model.action.MarkChatAsReadActionSpec.sizeOf(markChatAsReadAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(markChatAsReadAction0SerializedSize);
                protoSize += markChatAsReadAction0SerializedSize;
            }
        }
        var clearChatAction = object.clearChatAction();
        if (clearChatAction != null) {
            var clearChatAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(clearChatAction);
            if (clearChatAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(21, 2);
                var clearChatAction0SerializedSize = it.auties.whatsapp.model.action.ClearChatActionSpec.sizeOf(clearChatAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(clearChatAction0SerializedSize);
                protoSize += clearChatAction0SerializedSize;
            }
        }
        var deleteChatAction = object.deleteChatAction();
        if (deleteChatAction != null) {
            var deleteChatAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deleteChatAction);
            if (deleteChatAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(22, 2);
                var deleteChatAction0SerializedSize = it.auties.whatsapp.model.action.DeleteChatActionSpec.sizeOf(deleteChatAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(deleteChatAction0SerializedSize);
                protoSize += deleteChatAction0SerializedSize;
            }
        }
        var favoriteStickerAction = object.favoriteStickerAction();
        if (favoriteStickerAction != null) {
            var favoriteStickerAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(favoriteStickerAction);
            if (favoriteStickerAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(25, 2);
                var favoriteStickerAction0SerializedSize = it.auties.whatsapp.model.action.StickerActionSpec.sizeOf(favoriteStickerAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(favoriteStickerAction0SerializedSize);
                protoSize += favoriteStickerAction0SerializedSize;
            }
        }
        var androidUnsupportedActions = object.androidUnsupportedActions();
        if (androidUnsupportedActions != null) {
            var androidUnsupportedActions0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(androidUnsupportedActions);
            if (androidUnsupportedActions0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(26, 2);
                var androidUnsupportedActions0SerializedSize = it.auties.whatsapp.model.action.AndroidUnsupportedActionsSpec.sizeOf(androidUnsupportedActions0);
                protoSize += ProtobufOutputStream.getVarIntSize(androidUnsupportedActions0SerializedSize);
                protoSize += androidUnsupportedActions0SerializedSize;
            }
        }
        var agentAction = object.agentAction();
        if (agentAction != null) {
            var agentAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(agentAction);
            if (agentAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(27, 2);
                var agentAction0SerializedSize = it.auties.whatsapp.model.action.AgentActionSpec.sizeOf(agentAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(agentAction0SerializedSize);
                protoSize += agentAction0SerializedSize;
            }
        }
        var subscriptionAction = object.subscriptionAction();
        if (subscriptionAction != null) {
            var subscriptionAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(subscriptionAction);
            if (subscriptionAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(28, 2);
                var subscriptionAction0SerializedSize = it.auties.whatsapp.model.action.SubscriptionActionSpec.sizeOf(subscriptionAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(subscriptionAction0SerializedSize);
                protoSize += subscriptionAction0SerializedSize;
            }
        }
        var userStatusMuteAction = object.userStatusMuteAction();
        if (userStatusMuteAction != null) {
            var userStatusMuteAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(userStatusMuteAction);
            if (userStatusMuteAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(29, 2);
                var userStatusMuteAction0SerializedSize = it.auties.whatsapp.model.action.UserStatusMuteActionSpec.sizeOf(userStatusMuteAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(userStatusMuteAction0SerializedSize);
                protoSize += userStatusMuteAction0SerializedSize;
            }
        }
        var timeFormatAction = object.timeFormatAction();
        if (timeFormatAction != null) {
            var timeFormatAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(timeFormatAction);
            if (timeFormatAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(30, 2);
                var timeFormatAction0SerializedSize = it.auties.whatsapp.model.action.TimeFormatActionSpec.sizeOf(timeFormatAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(timeFormatAction0SerializedSize);
                protoSize += timeFormatAction0SerializedSize;
            }
        }
        var nuxAction = object.nuxAction();
        if (nuxAction != null) {
            var nuxAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(nuxAction);
            if (nuxAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(31, 2);
                var nuxAction0SerializedSize = it.auties.whatsapp.model.action.NuxActionSpec.sizeOf(nuxAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(nuxAction0SerializedSize);
                protoSize += nuxAction0SerializedSize;
            }
        }
        var primaryVersionAction = object.primaryVersionAction();
        if (primaryVersionAction != null) {
            var primaryVersionAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(primaryVersionAction);
            if (primaryVersionAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(32, 2);
                var primaryVersionAction0SerializedSize = it.auties.whatsapp.model.action.PrimaryVersionActionSpec.sizeOf(primaryVersionAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(primaryVersionAction0SerializedSize);
                protoSize += primaryVersionAction0SerializedSize;
            }
        }
        var stickerAction = object.stickerAction();
        if (stickerAction != null) {
            var stickerAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(stickerAction);
            if (stickerAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(33, 2);
                var stickerAction0SerializedSize = it.auties.whatsapp.model.action.StickerActionSpec.sizeOf(stickerAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(stickerAction0SerializedSize);
                protoSize += stickerAction0SerializedSize;
            }
        }
        var removeRecentStickerAction = object.removeRecentStickerAction();
        if (removeRecentStickerAction != null) {
            var removeRecentStickerAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(removeRecentStickerAction);
            if (removeRecentStickerAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(34, 2);
                var removeRecentStickerAction0SerializedSize = it.auties.whatsapp.model.action.RemoveRecentStickerActionSpec.sizeOf(removeRecentStickerAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(removeRecentStickerAction0SerializedSize);
                protoSize += removeRecentStickerAction0SerializedSize;
            }
        }
        var chatAssignmentAction = object.chatAssignmentAction();
        if (chatAssignmentAction != null) {
            var chatAssignmentAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(chatAssignmentAction);
            if (chatAssignmentAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(35, 2);
                var chatAssignmentAction0SerializedSize = it.auties.whatsapp.model.action.ChatAssignmentActionSpec.sizeOf(chatAssignmentAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(chatAssignmentAction0SerializedSize);
                protoSize += chatAssignmentAction0SerializedSize;
            }
        }
        var chatAssignmentOpenedStatusAction = object.chatAssignmentOpenedStatusAction();
        if (chatAssignmentOpenedStatusAction != null) {
            var chatAssignmentOpenedStatusAction0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(chatAssignmentOpenedStatusAction);
            if (chatAssignmentOpenedStatusAction0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(36, 2);
                var chatAssignmentOpenedStatusAction0SerializedSize = it.auties.whatsapp.model.action.ChatAssignmentOpenedStatusActionSpec.sizeOf(chatAssignmentOpenedStatusAction0);
                protoSize += ProtobufOutputStream.getVarIntSize(chatAssignmentOpenedStatusAction0SerializedSize);
                protoSize += chatAssignmentOpenedStatusAction0SerializedSize;
            }
        }
        var securityNotificationSetting = object.securityNotificationSetting();
        if (securityNotificationSetting != null) {
            var securityNotificationSetting0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(securityNotificationSetting);
            if (securityNotificationSetting0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                var securityNotificationSetting0SerializedSize = it.auties.whatsapp.model.setting.SecurityNotificationSettingsSpec.sizeOf(securityNotificationSetting0);
                protoSize += ProtobufOutputStream.getVarIntSize(securityNotificationSetting0SerializedSize);
                protoSize += securityNotificationSetting0SerializedSize;
            }
        }
        var pushNameSetting = object.pushNameSetting();
        if (pushNameSetting != null) {
            var pushNameSetting0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pushNameSetting);
            if (pushNameSetting0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                var pushNameSetting0SerializedSize = it.auties.whatsapp.model.setting.PushNameSettingsSpec.sizeOf(pushNameSetting0);
                protoSize += ProtobufOutputStream.getVarIntSize(pushNameSetting0SerializedSize);
                protoSize += pushNameSetting0SerializedSize;
            }
        }
        var localeSetting = object.localeSetting();
        if (localeSetting != null) {
            var localeSetting0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(localeSetting);
            if (localeSetting0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(16, 2);
                var localeSetting0SerializedSize = it.auties.whatsapp.model.setting.LocaleSettingsSpec.sizeOf(localeSetting0);
                protoSize += ProtobufOutputStream.getVarIntSize(localeSetting0SerializedSize);
                protoSize += localeSetting0SerializedSize;
            }
        }
        var unarchiveChatsSetting = object.unarchiveChatsSetting();
        if (unarchiveChatsSetting != null) {
            var unarchiveChatsSetting0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(unarchiveChatsSetting);
            if (unarchiveChatsSetting0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(23, 2);
                var unarchiveChatsSetting0SerializedSize = it.auties.whatsapp.model.setting.UnarchiveChatsSettingsSpec.sizeOf(unarchiveChatsSetting0);
                protoSize += ProtobufOutputStream.getVarIntSize(unarchiveChatsSetting0SerializedSize);
                protoSize += unarchiveChatsSetting0SerializedSize;
            }
        }
        var stickerMetadata = object.stickerMetadata();
        if (stickerMetadata != null) {
            var stickerMetadata0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(stickerMetadata);
            if (stickerMetadata0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(10, 2);
                var stickerMetadata0SerializedSize = it.auties.whatsapp.model.sync.StickerMetadataSpec.sizeOf(stickerMetadata0);
                protoSize += ProtobufOutputStream.getVarIntSize(stickerMetadata0SerializedSize);
                protoSize += stickerMetadata0SerializedSize;
            }
        }
        var keyExpiration = object.keyExpiration();
        if (keyExpiration != null) {
            var keyExpiration0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(keyExpiration);
            if (keyExpiration0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(19, 2);
                var keyExpiration0SerializedSize = it.auties.whatsapp.model.sync.KeyExpirationSpec.sizeOf(keyExpiration0);
                protoSize += ProtobufOutputStream.getVarIntSize(keyExpiration0SerializedSize);
                protoSize += keyExpiration0SerializedSize;
            }
        }
        var primaryFeature = object.primaryFeature();
        if (primaryFeature != null) {
            var primaryFeature0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(primaryFeature);
            if (primaryFeature0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(24, 2);
                var primaryFeature0SerializedSize = it.auties.whatsapp.model.sync.PrimaryFeatureSpec.sizeOf(primaryFeature0);
                protoSize += ProtobufOutputStream.getVarIntSize(primaryFeature0SerializedSize);
                protoSize += primaryFeature0SerializedSize;
            }
        }
        return protoSize;
    }

}
