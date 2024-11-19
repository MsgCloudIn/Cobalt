package it.auties.whatsapp.model.button.template.highlyStructured;

public class HighlyStructuredMessageBuilder {
    private java.lang.String namespace;
    private java.lang.String elementName;
    private java.util.List<java.lang.String> params;
    private java.util.Optional<java.lang.String> fallbackLg;
    private java.util.Optional<java.lang.String> fallbackLc;
    private java.util.List<it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredLocalizableParameter> localizableParameters;
    private java.util.Optional<java.lang.String> deterministicLg;
    private java.util.Optional<java.lang.String> deterministicLc;
    private it.auties.whatsapp.model.message.button.TemplateMessage templateMessage;

    public HighlyStructuredMessageBuilder() {
        namespace = null;
        elementName = null;
        params = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        fallbackLg = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        fallbackLc = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        localizableParameters = it.auties.protobuf.builtin.ProtobufRepeatedMixin.newList();
        deterministicLg = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        deterministicLc = it.auties.protobuf.builtin.ProtobufOptionalMixin.newOptional();
        templateMessage = null;
    }

    public HighlyStructuredMessageBuilder namespace(java.lang.String namespace) {
        this.namespace = namespace;
        return this;
    }

    public HighlyStructuredMessageBuilder elementName(java.lang.String elementName) {
        this.elementName = elementName;
        return this;
    }

    public HighlyStructuredMessageBuilder params(java.util.List<java.lang.String> params) {
        this.params = params;
        return this;
    }

    public HighlyStructuredMessageBuilder fallbackLg(java.lang.String fallbackLg) {
        this.fallbackLg = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(fallbackLg);
        return this;
    }

    public HighlyStructuredMessageBuilder fallbackLc(java.lang.String fallbackLc) {
        this.fallbackLc = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(fallbackLc);
        return this;
    }

    public HighlyStructuredMessageBuilder localizableParameters(java.util.List<it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredLocalizableParameter> localizableParameters) {
        this.localizableParameters = localizableParameters;
        return this;
    }

    public HighlyStructuredMessageBuilder deterministicLg(java.lang.String deterministicLg) {
        this.deterministicLg = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(deterministicLg);
        return this;
    }

    public HighlyStructuredMessageBuilder deterministicLc(java.lang.String deterministicLc) {
        this.deterministicLc = it.auties.protobuf.builtin.ProtobufOptionalMixin.ofOptional(deterministicLc);
        return this;
    }

    public HighlyStructuredMessageBuilder templateMessage(it.auties.whatsapp.model.message.button.TemplateMessage templateMessage) {
        this.templateMessage = templateMessage;
        return this;
    }

    public it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessage build() {
        return new it.auties.whatsapp.model.button.template.highlyStructured.HighlyStructuredMessage(namespace, elementName, params, fallbackLg, fallbackLc, localizableParameters, deterministicLg, deterministicLc, templateMessage);
    }

}
