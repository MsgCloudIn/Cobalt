package it.auties.whatsapp.model.message.model;

import it.auties.whatsapp.model.message.model.MessageContainer;
import it.auties.protobuf.stream.ProtobufInputStream;
import it.auties.protobuf.stream.ProtobufOutputStream;
import it.auties.protobuf.model.ProtobufWireType;

public class MessageContainerSpec {
    public static byte[] encode(MessageContainer protoInputObject) {
        if (protoInputObject == null) {
            return null;
        }
        var outputStream = new ProtobufOutputStream(sizeOf(protoInputObject));
        var textWithNoContextMessage = protoInputObject.textWithNoContextMessage();
        if (textWithNoContextMessage != null) {
            var textWithNoContextMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(textWithNoContextMessage);
            if (textWithNoContextMessage0 != null) {
                outputStream.writeString(1, textWithNoContextMessage0);
            }
        }
        var senderKeyDistributionMessage = protoInputObject.senderKeyDistributionMessage();
        if (senderKeyDistributionMessage != null) {
            var senderKeyDistributionMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(senderKeyDistributionMessage);
            if (senderKeyDistributionMessage0 != null) {
                outputStream.writeBytes(2, it.auties.whatsapp.model.message.server.SenderKeyDistributionMessageSpec.encode(senderKeyDistributionMessage0));
            }
        }
        var imageMessage = protoInputObject.imageMessage();
        if (imageMessage != null) {
            var imageMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(imageMessage);
            if (imageMessage0 != null) {
                outputStream.writeBytes(3, it.auties.whatsapp.model.message.standard.ImageMessageSpec.encode(imageMessage0));
            }
        }
        var contactMessage = protoInputObject.contactMessage();
        if (contactMessage != null) {
            var contactMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contactMessage);
            if (contactMessage0 != null) {
                outputStream.writeBytes(4, it.auties.whatsapp.model.message.standard.ContactMessageSpec.encode(contactMessage0));
            }
        }
        var locationMessage = protoInputObject.locationMessage();
        if (locationMessage != null) {
            var locationMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(locationMessage);
            if (locationMessage0 != null) {
                outputStream.writeBytes(5, it.auties.whatsapp.model.message.standard.LocationMessageSpec.encode(locationMessage0));
            }
        }
        var textMessage = protoInputObject.textMessage();
        if (textMessage != null) {
            var textMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(textMessage);
            if (textMessage0 != null) {
                outputStream.writeBytes(6, it.auties.whatsapp.model.message.standard.TextMessageSpec.encode(textMessage0));
            }
        }
        var documentMessage = protoInputObject.documentMessage();
        if (documentMessage != null) {
            var documentMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(documentMessage);
            if (documentMessage0 != null) {
                outputStream.writeBytes(7, it.auties.whatsapp.model.message.standard.DocumentMessageSpec.encode(documentMessage0));
            }
        }
        var audioMessage = protoInputObject.audioMessage();
        if (audioMessage != null) {
            var audioMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(audioMessage);
            if (audioMessage0 != null) {
                outputStream.writeBytes(8, it.auties.whatsapp.model.message.standard.AudioMessageSpec.encode(audioMessage0));
            }
        }
        var videoMessage = protoInputObject.videoMessage();
        if (videoMessage != null) {
            var videoMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(videoMessage);
            if (videoMessage0 != null) {
                outputStream.writeBytes(9, it.auties.whatsapp.model.message.standard.VideoOrGifMessageSpec.encode(videoMessage0));
            }
        }
        var callMessage = protoInputObject.callMessage();
        if (callMessage != null) {
            var callMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(callMessage);
            if (callMessage0 != null) {
                outputStream.writeBytes(10, it.auties.whatsapp.model.message.standard.CallMessageSpec.encode(callMessage0));
            }
        }
        var protocolMessage = protoInputObject.protocolMessage();
        if (protocolMessage != null) {
            var protocolMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(protocolMessage);
            if (protocolMessage0 != null) {
                outputStream.writeBytes(12, it.auties.whatsapp.model.message.server.ProtocolMessageSpec.encode(protocolMessage0));
            }
        }
        var contactsArrayMessage = protoInputObject.contactsArrayMessage();
        if (contactsArrayMessage != null) {
            var contactsArrayMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contactsArrayMessage);
            if (contactsArrayMessage0 != null) {
                outputStream.writeBytes(13, it.auties.whatsapp.model.message.standard.ContactsMessageSpec.encode(contactsArrayMessage0));
            }
        }
        var highlyStructuredMessage = protoInputObject.highlyStructuredMessage();
        if (highlyStructuredMessage != null) {
            var highlyStructuredMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(highlyStructuredMessage);
            if (highlyStructuredMessage0 != null) {
                outputStream.writeBytes(14, it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.encode(highlyStructuredMessage0));
            }
        }
        var sendPaymentMessage = protoInputObject.sendPaymentMessage();
        if (sendPaymentMessage != null) {
            var sendPaymentMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(sendPaymentMessage);
            if (sendPaymentMessage0 != null) {
                outputStream.writeBytes(16, it.auties.whatsapp.model.message.payment.SendPaymentMessageSpec.encode(sendPaymentMessage0));
            }
        }
        var liveLocationMessage = protoInputObject.liveLocationMessage();
        if (liveLocationMessage != null) {
            var liveLocationMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(liveLocationMessage);
            if (liveLocationMessage0 != null) {
                outputStream.writeBytes(18, it.auties.whatsapp.model.message.standard.LiveLocationMessageSpec.encode(liveLocationMessage0));
            }
        }
        var requestPaymentMessage = protoInputObject.requestPaymentMessage();
        if (requestPaymentMessage != null) {
            var requestPaymentMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(requestPaymentMessage);
            if (requestPaymentMessage0 != null) {
                outputStream.writeBytes(22, it.auties.whatsapp.model.message.payment.RequestPaymentMessageSpec.encode(requestPaymentMessage0));
            }
        }
        var declinePaymentRequestMessage = protoInputObject.declinePaymentRequestMessage();
        if (declinePaymentRequestMessage != null) {
            var declinePaymentRequestMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(declinePaymentRequestMessage);
            if (declinePaymentRequestMessage0 != null) {
                outputStream.writeBytes(23, it.auties.whatsapp.model.message.payment.DeclinePaymentRequestMessageSpec.encode(declinePaymentRequestMessage0));
            }
        }
        var cancelPaymentRequestMessage = protoInputObject.cancelPaymentRequestMessage();
        if (cancelPaymentRequestMessage != null) {
            var cancelPaymentRequestMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(cancelPaymentRequestMessage);
            if (cancelPaymentRequestMessage0 != null) {
                outputStream.writeBytes(24, it.auties.whatsapp.model.message.payment.CancelPaymentRequestMessageSpec.encode(cancelPaymentRequestMessage0));
            }
        }
        var templateMessage = protoInputObject.templateMessage();
        if (templateMessage != null) {
            var templateMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(templateMessage);
            if (templateMessage0 != null) {
                outputStream.writeBytes(25, it.auties.whatsapp.model.message.button.TemplateMessageSpec.encode(templateMessage0));
            }
        }
        var stickerMessage = protoInputObject.stickerMessage();
        if (stickerMessage != null) {
            var stickerMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(stickerMessage);
            if (stickerMessage0 != null) {
                outputStream.writeBytes(26, it.auties.whatsapp.model.message.standard.StickerMessageSpec.encode(stickerMessage0));
            }
        }
        var groupInviteMessage = protoInputObject.groupInviteMessage();
        if (groupInviteMessage != null) {
            var groupInviteMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(groupInviteMessage);
            if (groupInviteMessage0 != null) {
                outputStream.writeBytes(28, it.auties.whatsapp.model.message.standard.GroupInviteMessageSpec.encode(groupInviteMessage0));
            }
        }
        var templateReplyMessage = protoInputObject.templateReplyMessage();
        if (templateReplyMessage != null) {
            var templateReplyMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(templateReplyMessage);
            if (templateReplyMessage0 != null) {
                outputStream.writeBytes(29, it.auties.whatsapp.model.message.button.TemplateReplyMessageSpec.encode(templateReplyMessage0));
            }
        }
        var productMessage = protoInputObject.productMessage();
        if (productMessage != null) {
            var productMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(productMessage);
            if (productMessage0 != null) {
                outputStream.writeBytes(30, it.auties.whatsapp.model.message.standard.ProductMessageSpec.encode(productMessage0));
            }
        }
        var deviceSentMessage = protoInputObject.deviceSentMessage();
        if (deviceSentMessage != null) {
            var deviceSentMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deviceSentMessage);
            if (deviceSentMessage0 != null) {
                outputStream.writeBytes(31, it.auties.whatsapp.model.message.server.DeviceSentMessageSpec.encode(deviceSentMessage0));
            }
        }
        var deviceSyncMessage = protoInputObject.deviceSyncMessage();
        if (deviceSyncMessage != null) {
            var deviceSyncMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deviceSyncMessage);
            if (deviceSyncMessage0 != null) {
                outputStream.writeBytes(32, it.auties.whatsapp.model.message.server.DeviceSyncMessageSpec.encode(deviceSyncMessage0));
            }
        }
        var listMessage = protoInputObject.listMessage();
        if (listMessage != null) {
            var listMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(listMessage);
            if (listMessage0 != null) {
                outputStream.writeBytes(36, it.auties.whatsapp.model.message.button.ListMessageSpec.encode(listMessage0));
            }
        }
        var viewOnceMessage = protoInputObject.viewOnceMessage();
        if (viewOnceMessage != null) {
            var viewOnceMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(viewOnceMessage);
            if (viewOnceMessage0 != null) {
                outputStream.writeBytes(37, it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.encode(viewOnceMessage0));
            }
        }
        var orderMessage = protoInputObject.orderMessage();
        if (orderMessage != null) {
            var orderMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(orderMessage);
            if (orderMessage0 != null) {
                outputStream.writeBytes(38, it.auties.whatsapp.model.message.payment.PaymentOrderMessageSpec.encode(orderMessage0));
            }
        }
        var listResponseMessage = protoInputObject.listResponseMessage();
        if (listResponseMessage != null) {
            var listResponseMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(listResponseMessage);
            if (listResponseMessage0 != null) {
                outputStream.writeBytes(39, it.auties.whatsapp.model.message.button.ListResponseMessageSpec.encode(listResponseMessage0));
            }
        }
        var ephemeralMessage = protoInputObject.ephemeralMessage();
        if (ephemeralMessage != null) {
            var ephemeralMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(ephemeralMessage);
            if (ephemeralMessage0 != null) {
                outputStream.writeBytes(40, it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.encode(ephemeralMessage0));
            }
        }
        var invoiceMessage = protoInputObject.invoiceMessage();
        if (invoiceMessage != null) {
            var invoiceMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(invoiceMessage);
            if (invoiceMessage0 != null) {
                outputStream.writeBytes(41, it.auties.whatsapp.model.message.payment.PaymentInvoiceMessageSpec.encode(invoiceMessage0));
            }
        }
        var buttonsMessage = protoInputObject.buttonsMessage();
        if (buttonsMessage != null) {
            var buttonsMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(buttonsMessage);
            if (buttonsMessage0 != null) {
                outputStream.writeBytes(42, it.auties.whatsapp.model.message.button.ButtonsMessageSpec.encode(buttonsMessage0));
            }
        }
        var buttonsResponseMessage = protoInputObject.buttonsResponseMessage();
        if (buttonsResponseMessage != null) {
            var buttonsResponseMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(buttonsResponseMessage);
            if (buttonsResponseMessage0 != null) {
                outputStream.writeBytes(43, it.auties.whatsapp.model.message.button.ButtonsResponseMessageSpec.encode(buttonsResponseMessage0));
            }
        }
        var paymentInviteMessage = protoInputObject.paymentInviteMessage();
        if (paymentInviteMessage != null) {
            var paymentInviteMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(paymentInviteMessage);
            if (paymentInviteMessage0 != null) {
                outputStream.writeBytes(44, it.auties.whatsapp.model.message.payment.PaymentInviteMessageSpec.encode(paymentInviteMessage0));
            }
        }
        var interactiveMessage = protoInputObject.interactiveMessage();
        if (interactiveMessage != null) {
            var interactiveMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(interactiveMessage);
            if (interactiveMessage0 != null) {
                outputStream.writeBytes(45, it.auties.whatsapp.model.message.button.InteractiveMessageSpec.encode(interactiveMessage0));
            }
        }
        var reactionMessage = protoInputObject.reactionMessage();
        if (reactionMessage != null) {
            var reactionMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(reactionMessage);
            if (reactionMessage0 != null) {
                outputStream.writeBytes(46, it.auties.whatsapp.model.message.standard.ReactionMessageSpec.encode(reactionMessage0));
            }
        }
        var stickerSyncMessage = protoInputObject.stickerSyncMessage();
        if (stickerSyncMessage != null) {
            var stickerSyncMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(stickerSyncMessage);
            if (stickerSyncMessage0 != null) {
                outputStream.writeBytes(47, it.auties.whatsapp.model.message.server.StickerSyncRMRMessageSpec.encode(stickerSyncMessage0));
            }
        }
        var interactiveResponseMessage = protoInputObject.interactiveResponseMessage();
        if (interactiveResponseMessage != null) {
            var interactiveResponseMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(interactiveResponseMessage);
            if (interactiveResponseMessage0 != null) {
                outputStream.writeBytes(48, it.auties.whatsapp.model.message.button.InteractiveResponseMessageSpec.encode(interactiveResponseMessage0));
            }
        }
        var pollCreationMessage = protoInputObject.pollCreationMessage();
        if (pollCreationMessage != null) {
            var pollCreationMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pollCreationMessage);
            if (pollCreationMessage0 != null) {
                outputStream.writeBytes(49, it.auties.whatsapp.model.message.standard.PollCreationMessageSpec.encode(pollCreationMessage0));
            }
        }
        var pollUpdateMessage = protoInputObject.pollUpdateMessage();
        if (pollUpdateMessage != null) {
            var pollUpdateMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pollUpdateMessage);
            if (pollUpdateMessage0 != null) {
                outputStream.writeBytes(50, it.auties.whatsapp.model.message.standard.PollUpdateMessageSpec.encode(pollUpdateMessage0));
            }
        }
        var keepInChatMessage = protoInputObject.keepInChatMessage();
        if (keepInChatMessage != null) {
            var keepInChatMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(keepInChatMessage);
            if (keepInChatMessage0 != null) {
                outputStream.writeBytes(51, it.auties.whatsapp.model.message.standard.KeepInChatMessageSpec.encode(keepInChatMessage0));
            }
        }
        var documentWithCaptionMessage = protoInputObject.documentWithCaptionMessage();
        if (documentWithCaptionMessage != null) {
            var documentWithCaptionMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(documentWithCaptionMessage);
            if (documentWithCaptionMessage0 != null) {
                outputStream.writeBytes(53, it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.encode(documentWithCaptionMessage0));
            }
        }
        var requestPhoneNumberMessage = protoInputObject.requestPhoneNumberMessage();
        if (requestPhoneNumberMessage != null) {
            var requestPhoneNumberMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(requestPhoneNumberMessage);
            if (requestPhoneNumberMessage0 != null) {
                outputStream.writeBytes(54, it.auties.whatsapp.model.message.standard.RequestPhoneNumberMessageSpec.encode(requestPhoneNumberMessage0));
            }
        }
        var viewOnceV2Message = protoInputObject.viewOnceV2Message();
        if (viewOnceV2Message != null) {
            var viewOnceV2Message0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(viewOnceV2Message);
            if (viewOnceV2Message0 != null) {
                outputStream.writeBytes(55, it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.encode(viewOnceV2Message0));
            }
        }
        var encryptedReactionMessage = protoInputObject.encryptedReactionMessage();
        if (encryptedReactionMessage != null) {
            var encryptedReactionMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encryptedReactionMessage);
            if (encryptedReactionMessage0 != null) {
                outputStream.writeBytes(56, it.auties.whatsapp.model.message.standard.EncryptedReactionMessageSpec.encode(encryptedReactionMessage0));
            }
        }
        var editedMessage = protoInputObject.editedMessage();
        if (editedMessage != null) {
            var editedMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(editedMessage);
            if (editedMessage0 != null) {
                outputStream.writeBytes(58, it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.encode(editedMessage0));
            }
        }
        var viewOnceV2ExtensionMessage = protoInputObject.viewOnceV2ExtensionMessage();
        if (viewOnceV2ExtensionMessage != null) {
            var viewOnceV2ExtensionMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(viewOnceV2ExtensionMessage);
            if (viewOnceV2ExtensionMessage0 != null) {
                outputStream.writeBytes(59, it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.encode(viewOnceV2ExtensionMessage0));
            }
        }
        var newsletterAdminInviteMessage = protoInputObject.newsletterAdminInviteMessage();
        if (newsletterAdminInviteMessage != null) {
            var newsletterAdminInviteMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(newsletterAdminInviteMessage);
            if (newsletterAdminInviteMessage0 != null) {
                outputStream.writeBytes(78, it.auties.whatsapp.model.message.standard.NewsletterAdminInviteMessageSpec.encode(newsletterAdminInviteMessage0));
            }
        }
        var deviceInfo = protoInputObject.deviceInfo();
        if (deviceInfo != null) {
            var deviceInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deviceInfo);
            if (deviceInfo0 != null) {
                outputStream.writeBytes(35, it.auties.whatsapp.model.info.DeviceContextInfoSpec.encode(deviceInfo0));
            }
        }
        return outputStream.toByteArray();
    }

    public static MessageContainer decode(byte[] input) {
        if (input == null) {
            return null;
        }
        return decode(new ProtobufInputStream(input, 0, input.length));
    }

    public static MessageContainer decode(ProtobufInputStream protoInputStream) {
        java.util.Optional<java.lang.String> textWithNoContextMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.server.SenderKeyDistributionMessage> senderKeyDistributionMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.ImageMessage> imageMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.ContactMessage> contactMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.LocationMessage> locationMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.TextMessage> textMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.DocumentMessage> documentMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.AudioMessage> audioMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.VideoOrGifMessage> videoMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.CallMessage> callMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.server.ProtocolMessage> protocolMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.ContactsMessage> contactsArrayMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessage> highlyStructuredMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.payment.SendPaymentMessage> sendPaymentMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.LiveLocationMessage> liveLocationMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.payment.RequestPaymentMessage> requestPaymentMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.payment.DeclinePaymentRequestMessage> declinePaymentRequestMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.payment.CancelPaymentRequestMessage> cancelPaymentRequestMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.button.TemplateMessage> templateMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.StickerMessage> stickerMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.GroupInviteMessage> groupInviteMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.button.TemplateReplyMessage> templateReplyMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.ProductMessage> productMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.server.DeviceSentMessage> deviceSentMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.server.DeviceSyncMessage> deviceSyncMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.button.ListMessage> listMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.model.FutureMessageContainer> viewOnceMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.payment.PaymentOrderMessage> orderMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.button.ListResponseMessage> listResponseMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.model.FutureMessageContainer> ephemeralMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.payment.PaymentInvoiceMessage> invoiceMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.button.ButtonsMessage> buttonsMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.button.ButtonsResponseMessage> buttonsResponseMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.payment.PaymentInviteMessage> paymentInviteMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.button.InteractiveMessage> interactiveMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.ReactionMessage> reactionMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.server.StickerSyncRMRMessage> stickerSyncMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.button.InteractiveResponseMessage> interactiveResponseMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.PollCreationMessage> pollCreationMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.PollUpdateMessage> pollUpdateMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.KeepInChatMessage> keepInChatMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.model.FutureMessageContainer> documentWithCaptionMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.RequestPhoneNumberMessage> requestPhoneNumberMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.model.FutureMessageContainer> viewOnceV2Message = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.EncryptedReactionMessage> encryptedReactionMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.model.FutureMessageContainer> editedMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.model.FutureMessageContainer> viewOnceV2ExtensionMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.message.standard.NewsletterAdminInviteMessage> newsletterAdminInviteMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        java.util.Optional<it.auties.whatsapp.model.info.DeviceContextInfo> deviceInfo = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        while (protoInputStream.readTag()) {
            var protoFieldIndex = protoInputStream.index();
            switch (protoFieldIndex) {
                case 1 -> textWithNoContextMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(protoInputStream.readString());
                case 2 -> senderKeyDistributionMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.server.SenderKeyDistributionMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 3 -> imageMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.ImageMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 4 -> contactMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.ContactMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 5 -> locationMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.LocationMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 6 -> textMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.TextMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 7 -> documentMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.DocumentMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 8 -> audioMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.AudioMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 9 -> videoMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.VideoOrGifMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 10 -> callMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.CallMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 12 -> protocolMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.server.ProtocolMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 13 -> contactsArrayMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.ContactsMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 14 -> highlyStructuredMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 16 -> sendPaymentMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.payment.SendPaymentMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 18 -> liveLocationMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.LiveLocationMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 22 -> requestPaymentMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.payment.RequestPaymentMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 23 -> declinePaymentRequestMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.payment.DeclinePaymentRequestMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 24 -> cancelPaymentRequestMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.payment.CancelPaymentRequestMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 25 -> templateMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.button.TemplateMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 26 -> stickerMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.StickerMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 28 -> groupInviteMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.GroupInviteMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 29 -> templateReplyMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.button.TemplateReplyMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 30 -> productMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.ProductMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 31 -> deviceSentMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.server.DeviceSentMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 32 -> deviceSyncMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.server.DeviceSyncMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 36 -> listMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.button.ListMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 37 -> viewOnceMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 38 -> orderMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.payment.PaymentOrderMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 39 -> listResponseMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.button.ListResponseMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 40 -> ephemeralMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 41 -> invoiceMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.payment.PaymentInvoiceMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 42 -> buttonsMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.button.ButtonsMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 43 -> buttonsResponseMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.button.ButtonsResponseMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 44 -> paymentInviteMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.payment.PaymentInviteMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 45 -> interactiveMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.button.InteractiveMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 46 -> reactionMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.ReactionMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 47 -> stickerSyncMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.server.StickerSyncRMRMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 48 -> interactiveResponseMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.button.InteractiveResponseMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 49 -> pollCreationMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.PollCreationMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 50 -> pollUpdateMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.PollUpdateMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 51 -> keepInChatMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.KeepInChatMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 53 -> documentWithCaptionMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 54 -> requestPhoneNumberMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.RequestPhoneNumberMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 55 -> viewOnceV2Message = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 56 -> encryptedReactionMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.EncryptedReactionMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 58 -> editedMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 59 -> viewOnceV2ExtensionMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 78 -> newsletterAdminInviteMessage = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.message.standard.NewsletterAdminInviteMessageSpec.decode(protoInputStream.lengthDelimitedStream()));
                case 35 -> deviceInfo = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(it.auties.whatsapp.model.info.DeviceContextInfoSpec.decode(protoInputStream.lengthDelimitedStream()));
                default -> protoInputStream.readUnknown(false);
            }
        }
        return new it.auties.whatsapp.model.message.model.MessageContainer(textWithNoContextMessage, senderKeyDistributionMessage, imageMessage, contactMessage, locationMessage, textMessage, documentMessage, audioMessage, videoMessage, callMessage, protocolMessage, contactsArrayMessage, highlyStructuredMessage, sendPaymentMessage, liveLocationMessage, requestPaymentMessage, declinePaymentRequestMessage, cancelPaymentRequestMessage, templateMessage, stickerMessage, groupInviteMessage, templateReplyMessage, productMessage, deviceSentMessage, deviceSyncMessage, listMessage, viewOnceMessage, orderMessage, listResponseMessage, ephemeralMessage, invoiceMessage, buttonsMessage, buttonsResponseMessage, paymentInviteMessage, interactiveMessage, reactionMessage, stickerSyncMessage, interactiveResponseMessage, pollCreationMessage, pollUpdateMessage, keepInChatMessage, documentWithCaptionMessage, requestPhoneNumberMessage, viewOnceV2Message, encryptedReactionMessage, editedMessage, viewOnceV2ExtensionMessage, newsletterAdminInviteMessage, deviceInfo);
    }

    public static int sizeOf(MessageContainer object) {
        if (object == null) {
            return 0;
        }
        var protoSize = 0;
        var textWithNoContextMessage = object.textWithNoContextMessage();
        if (textWithNoContextMessage != null) {
            var textWithNoContextMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(textWithNoContextMessage);
            if (textWithNoContextMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(1, 2);
                protoSize += ProtobufOutputStream.getStringSize(textWithNoContextMessage0);
            }
        }
        var senderKeyDistributionMessage = object.senderKeyDistributionMessage();
        if (senderKeyDistributionMessage != null) {
            var senderKeyDistributionMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(senderKeyDistributionMessage);
            if (senderKeyDistributionMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(2, 2);
                var senderKeyDistributionMessage0SerializedSize = it.auties.whatsapp.model.message.server.SenderKeyDistributionMessageSpec.sizeOf(senderKeyDistributionMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(senderKeyDistributionMessage0SerializedSize);
                protoSize += senderKeyDistributionMessage0SerializedSize;
            }
        }
        var imageMessage = object.imageMessage();
        if (imageMessage != null) {
            var imageMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(imageMessage);
            if (imageMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(3, 2);
                var imageMessage0SerializedSize = it.auties.whatsapp.model.message.standard.ImageMessageSpec.sizeOf(imageMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(imageMessage0SerializedSize);
                protoSize += imageMessage0SerializedSize;
            }
        }
        var contactMessage = object.contactMessage();
        if (contactMessage != null) {
            var contactMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contactMessage);
            if (contactMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(4, 2);
                var contactMessage0SerializedSize = it.auties.whatsapp.model.message.standard.ContactMessageSpec.sizeOf(contactMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(contactMessage0SerializedSize);
                protoSize += contactMessage0SerializedSize;
            }
        }
        var locationMessage = object.locationMessage();
        if (locationMessage != null) {
            var locationMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(locationMessage);
            if (locationMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(5, 2);
                var locationMessage0SerializedSize = it.auties.whatsapp.model.message.standard.LocationMessageSpec.sizeOf(locationMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(locationMessage0SerializedSize);
                protoSize += locationMessage0SerializedSize;
            }
        }
        var textMessage = object.textMessage();
        if (textMessage != null) {
            var textMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(textMessage);
            if (textMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(6, 2);
                var textMessage0SerializedSize = it.auties.whatsapp.model.message.standard.TextMessageSpec.sizeOf(textMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(textMessage0SerializedSize);
                protoSize += textMessage0SerializedSize;
            }
        }
        var documentMessage = object.documentMessage();
        if (documentMessage != null) {
            var documentMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(documentMessage);
            if (documentMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(7, 2);
                var documentMessage0SerializedSize = it.auties.whatsapp.model.message.standard.DocumentMessageSpec.sizeOf(documentMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(documentMessage0SerializedSize);
                protoSize += documentMessage0SerializedSize;
            }
        }
        var audioMessage = object.audioMessage();
        if (audioMessage != null) {
            var audioMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(audioMessage);
            if (audioMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(8, 2);
                var audioMessage0SerializedSize = it.auties.whatsapp.model.message.standard.AudioMessageSpec.sizeOf(audioMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(audioMessage0SerializedSize);
                protoSize += audioMessage0SerializedSize;
            }
        }
        var videoMessage = object.videoMessage();
        if (videoMessage != null) {
            var videoMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(videoMessage);
            if (videoMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(9, 2);
                var videoMessage0SerializedSize = it.auties.whatsapp.model.message.standard.VideoOrGifMessageSpec.sizeOf(videoMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(videoMessage0SerializedSize);
                protoSize += videoMessage0SerializedSize;
            }
        }
        var callMessage = object.callMessage();
        if (callMessage != null) {
            var callMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(callMessage);
            if (callMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(10, 2);
                var callMessage0SerializedSize = it.auties.whatsapp.model.message.standard.CallMessageSpec.sizeOf(callMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(callMessage0SerializedSize);
                protoSize += callMessage0SerializedSize;
            }
        }
        var protocolMessage = object.protocolMessage();
        if (protocolMessage != null) {
            var protocolMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(protocolMessage);
            if (protocolMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(12, 2);
                var protocolMessage0SerializedSize = it.auties.whatsapp.model.message.server.ProtocolMessageSpec.sizeOf(protocolMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(protocolMessage0SerializedSize);
                protoSize += protocolMessage0SerializedSize;
            }
        }
        var contactsArrayMessage = object.contactsArrayMessage();
        if (contactsArrayMessage != null) {
            var contactsArrayMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(contactsArrayMessage);
            if (contactsArrayMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(13, 2);
                var contactsArrayMessage0SerializedSize = it.auties.whatsapp.model.message.standard.ContactsMessageSpec.sizeOf(contactsArrayMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(contactsArrayMessage0SerializedSize);
                protoSize += contactsArrayMessage0SerializedSize;
            }
        }
        var highlyStructuredMessage = object.highlyStructuredMessage();
        if (highlyStructuredMessage != null) {
            var highlyStructuredMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(highlyStructuredMessage);
            if (highlyStructuredMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(14, 2);
                var highlyStructuredMessage0SerializedSize = it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessageSpec.sizeOf(highlyStructuredMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(highlyStructuredMessage0SerializedSize);
                protoSize += highlyStructuredMessage0SerializedSize;
            }
        }
        var sendPaymentMessage = object.sendPaymentMessage();
        if (sendPaymentMessage != null) {
            var sendPaymentMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(sendPaymentMessage);
            if (sendPaymentMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(16, 2);
                var sendPaymentMessage0SerializedSize = it.auties.whatsapp.model.message.payment.SendPaymentMessageSpec.sizeOf(sendPaymentMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(sendPaymentMessage0SerializedSize);
                protoSize += sendPaymentMessage0SerializedSize;
            }
        }
        var liveLocationMessage = object.liveLocationMessage();
        if (liveLocationMessage != null) {
            var liveLocationMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(liveLocationMessage);
            if (liveLocationMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(18, 2);
                var liveLocationMessage0SerializedSize = it.auties.whatsapp.model.message.standard.LiveLocationMessageSpec.sizeOf(liveLocationMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(liveLocationMessage0SerializedSize);
                protoSize += liveLocationMessage0SerializedSize;
            }
        }
        var requestPaymentMessage = object.requestPaymentMessage();
        if (requestPaymentMessage != null) {
            var requestPaymentMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(requestPaymentMessage);
            if (requestPaymentMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(22, 2);
                var requestPaymentMessage0SerializedSize = it.auties.whatsapp.model.message.payment.RequestPaymentMessageSpec.sizeOf(requestPaymentMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(requestPaymentMessage0SerializedSize);
                protoSize += requestPaymentMessage0SerializedSize;
            }
        }
        var declinePaymentRequestMessage = object.declinePaymentRequestMessage();
        if (declinePaymentRequestMessage != null) {
            var declinePaymentRequestMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(declinePaymentRequestMessage);
            if (declinePaymentRequestMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(23, 2);
                var declinePaymentRequestMessage0SerializedSize = it.auties.whatsapp.model.message.payment.DeclinePaymentRequestMessageSpec.sizeOf(declinePaymentRequestMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(declinePaymentRequestMessage0SerializedSize);
                protoSize += declinePaymentRequestMessage0SerializedSize;
            }
        }
        var cancelPaymentRequestMessage = object.cancelPaymentRequestMessage();
        if (cancelPaymentRequestMessage != null) {
            var cancelPaymentRequestMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(cancelPaymentRequestMessage);
            if (cancelPaymentRequestMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(24, 2);
                var cancelPaymentRequestMessage0SerializedSize = it.auties.whatsapp.model.message.payment.CancelPaymentRequestMessageSpec.sizeOf(cancelPaymentRequestMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(cancelPaymentRequestMessage0SerializedSize);
                protoSize += cancelPaymentRequestMessage0SerializedSize;
            }
        }
        var templateMessage = object.templateMessage();
        if (templateMessage != null) {
            var templateMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(templateMessage);
            if (templateMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(25, 2);
                var templateMessage0SerializedSize = it.auties.whatsapp.model.message.button.TemplateMessageSpec.sizeOf(templateMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(templateMessage0SerializedSize);
                protoSize += templateMessage0SerializedSize;
            }
        }
        var stickerMessage = object.stickerMessage();
        if (stickerMessage != null) {
            var stickerMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(stickerMessage);
            if (stickerMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(26, 2);
                var stickerMessage0SerializedSize = it.auties.whatsapp.model.message.standard.StickerMessageSpec.sizeOf(stickerMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(stickerMessage0SerializedSize);
                protoSize += stickerMessage0SerializedSize;
            }
        }
        var groupInviteMessage = object.groupInviteMessage();
        if (groupInviteMessage != null) {
            var groupInviteMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(groupInviteMessage);
            if (groupInviteMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(28, 2);
                var groupInviteMessage0SerializedSize = it.auties.whatsapp.model.message.standard.GroupInviteMessageSpec.sizeOf(groupInviteMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(groupInviteMessage0SerializedSize);
                protoSize += groupInviteMessage0SerializedSize;
            }
        }
        var templateReplyMessage = object.templateReplyMessage();
        if (templateReplyMessage != null) {
            var templateReplyMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(templateReplyMessage);
            if (templateReplyMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(29, 2);
                var templateReplyMessage0SerializedSize = it.auties.whatsapp.model.message.button.TemplateReplyMessageSpec.sizeOf(templateReplyMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(templateReplyMessage0SerializedSize);
                protoSize += templateReplyMessage0SerializedSize;
            }
        }
        var productMessage = object.productMessage();
        if (productMessage != null) {
            var productMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(productMessage);
            if (productMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(30, 2);
                var productMessage0SerializedSize = it.auties.whatsapp.model.message.standard.ProductMessageSpec.sizeOf(productMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(productMessage0SerializedSize);
                protoSize += productMessage0SerializedSize;
            }
        }
        var deviceSentMessage = object.deviceSentMessage();
        if (deviceSentMessage != null) {
            var deviceSentMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deviceSentMessage);
            if (deviceSentMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(31, 2);
                var deviceSentMessage0SerializedSize = it.auties.whatsapp.model.message.server.DeviceSentMessageSpec.sizeOf(deviceSentMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(deviceSentMessage0SerializedSize);
                protoSize += deviceSentMessage0SerializedSize;
            }
        }
        var deviceSyncMessage = object.deviceSyncMessage();
        if (deviceSyncMessage != null) {
            var deviceSyncMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deviceSyncMessage);
            if (deviceSyncMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(32, 2);
                var deviceSyncMessage0SerializedSize = it.auties.whatsapp.model.message.server.DeviceSyncMessageSpec.sizeOf(deviceSyncMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(deviceSyncMessage0SerializedSize);
                protoSize += deviceSyncMessage0SerializedSize;
            }
        }
        var listMessage = object.listMessage();
        if (listMessage != null) {
            var listMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(listMessage);
            if (listMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(36, 2);
                var listMessage0SerializedSize = it.auties.whatsapp.model.message.button.ListMessageSpec.sizeOf(listMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(listMessage0SerializedSize);
                protoSize += listMessage0SerializedSize;
            }
        }
        var viewOnceMessage = object.viewOnceMessage();
        if (viewOnceMessage != null) {
            var viewOnceMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(viewOnceMessage);
            if (viewOnceMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(37, 2);
                var viewOnceMessage0SerializedSize = it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.sizeOf(viewOnceMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(viewOnceMessage0SerializedSize);
                protoSize += viewOnceMessage0SerializedSize;
            }
        }
        var orderMessage = object.orderMessage();
        if (orderMessage != null) {
            var orderMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(orderMessage);
            if (orderMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(38, 2);
                var orderMessage0SerializedSize = it.auties.whatsapp.model.message.payment.PaymentOrderMessageSpec.sizeOf(orderMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(orderMessage0SerializedSize);
                protoSize += orderMessage0SerializedSize;
            }
        }
        var listResponseMessage = object.listResponseMessage();
        if (listResponseMessage != null) {
            var listResponseMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(listResponseMessage);
            if (listResponseMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(39, 2);
                var listResponseMessage0SerializedSize = it.auties.whatsapp.model.message.button.ListResponseMessageSpec.sizeOf(listResponseMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(listResponseMessage0SerializedSize);
                protoSize += listResponseMessage0SerializedSize;
            }
        }
        var ephemeralMessage = object.ephemeralMessage();
        if (ephemeralMessage != null) {
            var ephemeralMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(ephemeralMessage);
            if (ephemeralMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(40, 2);
                var ephemeralMessage0SerializedSize = it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.sizeOf(ephemeralMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(ephemeralMessage0SerializedSize);
                protoSize += ephemeralMessage0SerializedSize;
            }
        }
        var invoiceMessage = object.invoiceMessage();
        if (invoiceMessage != null) {
            var invoiceMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(invoiceMessage);
            if (invoiceMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(41, 2);
                var invoiceMessage0SerializedSize = it.auties.whatsapp.model.message.payment.PaymentInvoiceMessageSpec.sizeOf(invoiceMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(invoiceMessage0SerializedSize);
                protoSize += invoiceMessage0SerializedSize;
            }
        }
        var buttonsMessage = object.buttonsMessage();
        if (buttonsMessage != null) {
            var buttonsMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(buttonsMessage);
            if (buttonsMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(42, 2);
                var buttonsMessage0SerializedSize = it.auties.whatsapp.model.message.button.ButtonsMessageSpec.sizeOf(buttonsMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(buttonsMessage0SerializedSize);
                protoSize += buttonsMessage0SerializedSize;
            }
        }
        var buttonsResponseMessage = object.buttonsResponseMessage();
        if (buttonsResponseMessage != null) {
            var buttonsResponseMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(buttonsResponseMessage);
            if (buttonsResponseMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(43, 2);
                var buttonsResponseMessage0SerializedSize = it.auties.whatsapp.model.message.button.ButtonsResponseMessageSpec.sizeOf(buttonsResponseMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(buttonsResponseMessage0SerializedSize);
                protoSize += buttonsResponseMessage0SerializedSize;
            }
        }
        var paymentInviteMessage = object.paymentInviteMessage();
        if (paymentInviteMessage != null) {
            var paymentInviteMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(paymentInviteMessage);
            if (paymentInviteMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(44, 2);
                var paymentInviteMessage0SerializedSize = it.auties.whatsapp.model.message.payment.PaymentInviteMessageSpec.sizeOf(paymentInviteMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(paymentInviteMessage0SerializedSize);
                protoSize += paymentInviteMessage0SerializedSize;
            }
        }
        var interactiveMessage = object.interactiveMessage();
        if (interactiveMessage != null) {
            var interactiveMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(interactiveMessage);
            if (interactiveMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(45, 2);
                var interactiveMessage0SerializedSize = it.auties.whatsapp.model.message.button.InteractiveMessageSpec.sizeOf(interactiveMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(interactiveMessage0SerializedSize);
                protoSize += interactiveMessage0SerializedSize;
            }
        }
        var reactionMessage = object.reactionMessage();
        if (reactionMessage != null) {
            var reactionMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(reactionMessage);
            if (reactionMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(46, 2);
                var reactionMessage0SerializedSize = it.auties.whatsapp.model.message.standard.ReactionMessageSpec.sizeOf(reactionMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(reactionMessage0SerializedSize);
                protoSize += reactionMessage0SerializedSize;
            }
        }
        var stickerSyncMessage = object.stickerSyncMessage();
        if (stickerSyncMessage != null) {
            var stickerSyncMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(stickerSyncMessage);
            if (stickerSyncMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(47, 2);
                var stickerSyncMessage0SerializedSize = it.auties.whatsapp.model.message.server.StickerSyncRMRMessageSpec.sizeOf(stickerSyncMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(stickerSyncMessage0SerializedSize);
                protoSize += stickerSyncMessage0SerializedSize;
            }
        }
        var interactiveResponseMessage = object.interactiveResponseMessage();
        if (interactiveResponseMessage != null) {
            var interactiveResponseMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(interactiveResponseMessage);
            if (interactiveResponseMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(48, 2);
                var interactiveResponseMessage0SerializedSize = it.auties.whatsapp.model.message.button.InteractiveResponseMessageSpec.sizeOf(interactiveResponseMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(interactiveResponseMessage0SerializedSize);
                protoSize += interactiveResponseMessage0SerializedSize;
            }
        }
        var pollCreationMessage = object.pollCreationMessage();
        if (pollCreationMessage != null) {
            var pollCreationMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pollCreationMessage);
            if (pollCreationMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(49, 2);
                var pollCreationMessage0SerializedSize = it.auties.whatsapp.model.message.standard.PollCreationMessageSpec.sizeOf(pollCreationMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(pollCreationMessage0SerializedSize);
                protoSize += pollCreationMessage0SerializedSize;
            }
        }
        var pollUpdateMessage = object.pollUpdateMessage();
        if (pollUpdateMessage != null) {
            var pollUpdateMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(pollUpdateMessage);
            if (pollUpdateMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(50, 2);
                var pollUpdateMessage0SerializedSize = it.auties.whatsapp.model.message.standard.PollUpdateMessageSpec.sizeOf(pollUpdateMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(pollUpdateMessage0SerializedSize);
                protoSize += pollUpdateMessage0SerializedSize;
            }
        }
        var keepInChatMessage = object.keepInChatMessage();
        if (keepInChatMessage != null) {
            var keepInChatMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(keepInChatMessage);
            if (keepInChatMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(51, 2);
                var keepInChatMessage0SerializedSize = it.auties.whatsapp.model.message.standard.KeepInChatMessageSpec.sizeOf(keepInChatMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(keepInChatMessage0SerializedSize);
                protoSize += keepInChatMessage0SerializedSize;
            }
        }
        var documentWithCaptionMessage = object.documentWithCaptionMessage();
        if (documentWithCaptionMessage != null) {
            var documentWithCaptionMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(documentWithCaptionMessage);
            if (documentWithCaptionMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(53, 2);
                var documentWithCaptionMessage0SerializedSize = it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.sizeOf(documentWithCaptionMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(documentWithCaptionMessage0SerializedSize);
                protoSize += documentWithCaptionMessage0SerializedSize;
            }
        }
        var requestPhoneNumberMessage = object.requestPhoneNumberMessage();
        if (requestPhoneNumberMessage != null) {
            var requestPhoneNumberMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(requestPhoneNumberMessage);
            if (requestPhoneNumberMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(54, 2);
                var requestPhoneNumberMessage0SerializedSize = it.auties.whatsapp.model.message.standard.RequestPhoneNumberMessageSpec.sizeOf(requestPhoneNumberMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(requestPhoneNumberMessage0SerializedSize);
                protoSize += requestPhoneNumberMessage0SerializedSize;
            }
        }
        var viewOnceV2Message = object.viewOnceV2Message();
        if (viewOnceV2Message != null) {
            var viewOnceV2Message0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(viewOnceV2Message);
            if (viewOnceV2Message0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(55, 2);
                var viewOnceV2Message0SerializedSize = it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.sizeOf(viewOnceV2Message0);
                protoSize += ProtobufOutputStream.getVarIntSize(viewOnceV2Message0SerializedSize);
                protoSize += viewOnceV2Message0SerializedSize;
            }
        }
        var encryptedReactionMessage = object.encryptedReactionMessage();
        if (encryptedReactionMessage != null) {
            var encryptedReactionMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(encryptedReactionMessage);
            if (encryptedReactionMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(56, 2);
                var encryptedReactionMessage0SerializedSize = it.auties.whatsapp.model.message.standard.EncryptedReactionMessageSpec.sizeOf(encryptedReactionMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(encryptedReactionMessage0SerializedSize);
                protoSize += encryptedReactionMessage0SerializedSize;
            }
        }
        var editedMessage = object.editedMessage();
        if (editedMessage != null) {
            var editedMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(editedMessage);
            if (editedMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(58, 2);
                var editedMessage0SerializedSize = it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.sizeOf(editedMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(editedMessage0SerializedSize);
                protoSize += editedMessage0SerializedSize;
            }
        }
        var viewOnceV2ExtensionMessage = object.viewOnceV2ExtensionMessage();
        if (viewOnceV2ExtensionMessage != null) {
            var viewOnceV2ExtensionMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(viewOnceV2ExtensionMessage);
            if (viewOnceV2ExtensionMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(59, 2);
                var viewOnceV2ExtensionMessage0SerializedSize = it.auties.whatsapp.model.message.model.FutureMessageContainerSpec.sizeOf(viewOnceV2ExtensionMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(viewOnceV2ExtensionMessage0SerializedSize);
                protoSize += viewOnceV2ExtensionMessage0SerializedSize;
            }
        }
        var newsletterAdminInviteMessage = object.newsletterAdminInviteMessage();
        if (newsletterAdminInviteMessage != null) {
            var newsletterAdminInviteMessage0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(newsletterAdminInviteMessage);
            if (newsletterAdminInviteMessage0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(78, 2);
                var newsletterAdminInviteMessage0SerializedSize = it.auties.whatsapp.model.message.standard.NewsletterAdminInviteMessageSpec.sizeOf(newsletterAdminInviteMessage0);
                protoSize += ProtobufOutputStream.getVarIntSize(newsletterAdminInviteMessage0SerializedSize);
                protoSize += newsletterAdminInviteMessage0SerializedSize;
            }
        }
        var deviceInfo = object.deviceInfo();
        if (deviceInfo != null) {
            var deviceInfo0 = it.auties.protobuf.builtin.ProtobufOptionalMixin.toNullableValue(deviceInfo);
            if (deviceInfo0 != null) {
                protoSize += ProtobufOutputStream.getFieldSize(35, 2);
                var deviceInfo0SerializedSize = it.auties.whatsapp.model.info.DeviceContextInfoSpec.sizeOf(deviceInfo0);
                protoSize += ProtobufOutputStream.getVarIntSize(deviceInfo0SerializedSize);
                protoSize += deviceInfo0SerializedSize;
            }
        }
        return protoSize;
    }

}
