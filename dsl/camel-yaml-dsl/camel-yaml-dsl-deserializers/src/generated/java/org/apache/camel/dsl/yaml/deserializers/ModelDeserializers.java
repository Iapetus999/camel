package org.apache.camel.dsl.yaml.deserializers;

import java.lang.Override;
import java.lang.String;
import org.apache.camel.dsl.yaml.common.YamlDeserializerBase;
import org.apache.camel.dsl.yaml.common.YamlDeserializerSupport;
import org.apache.camel.model.AggregateDefinition;
import org.apache.camel.model.BeanDefinition;
import org.apache.camel.model.CatchDefinition;
import org.apache.camel.model.ChoiceDefinition;
import org.apache.camel.model.CircuitBreakerDefinition;
import org.apache.camel.model.ClaimCheckDefinition;
import org.apache.camel.model.ContextScanDefinition;
import org.apache.camel.model.ConvertBodyDefinition;
import org.apache.camel.model.DataFormatDefinition;
import org.apache.camel.model.DelayDefinition;
import org.apache.camel.model.DescriptionDefinition;
import org.apache.camel.model.DynamicRouterDefinition;
import org.apache.camel.model.EnrichDefinition;
import org.apache.camel.model.FaultToleranceConfigurationDefinition;
import org.apache.camel.model.FilterDefinition;
import org.apache.camel.model.FinallyDefinition;
import org.apache.camel.model.GlobalOptionDefinition;
import org.apache.camel.model.GlobalOptionsDefinition;
import org.apache.camel.model.HystrixConfigurationDefinition;
import org.apache.camel.model.IdempotentConsumerDefinition;
import org.apache.camel.model.InOnlyDefinition;
import org.apache.camel.model.InOutDefinition;
import org.apache.camel.model.InputTypeDefinition;
import org.apache.camel.model.InterceptDefinition;
import org.apache.camel.model.InterceptFromDefinition;
import org.apache.camel.model.InterceptSendToEndpointDefinition;
import org.apache.camel.model.LoadBalanceDefinition;
import org.apache.camel.model.LoadBalancerDefinition;
import org.apache.camel.model.LogDefinition;
import org.apache.camel.model.LoopDefinition;
import org.apache.camel.model.MarshalDefinition;
import org.apache.camel.model.MulticastDefinition;
import org.apache.camel.model.OnCompletionDefinition;
import org.apache.camel.model.OnExceptionDefinition;
import org.apache.camel.model.OnFallbackDefinition;
import org.apache.camel.model.OptimisticLockRetryPolicyDefinition;
import org.apache.camel.model.OtherwiseDefinition;
import org.apache.camel.model.OutputDefinition;
import org.apache.camel.model.OutputTypeDefinition;
import org.apache.camel.model.PackageScanDefinition;
import org.apache.camel.model.PipelineDefinition;
import org.apache.camel.model.PolicyDefinition;
import org.apache.camel.model.PollEnrichDefinition;
import org.apache.camel.model.ProcessDefinition;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.PropertyDefinition;
import org.apache.camel.model.RecipientListDefinition;
import org.apache.camel.model.RedeliveryPolicyDefinition;
import org.apache.camel.model.RemoveHeaderDefinition;
import org.apache.camel.model.RemoveHeadersDefinition;
import org.apache.camel.model.RemovePropertiesDefinition;
import org.apache.camel.model.RemovePropertyDefinition;
import org.apache.camel.model.ResequenceDefinition;
import org.apache.camel.model.Resilience4jConfigurationDefinition;
import org.apache.camel.model.RestContextRefDefinition;
import org.apache.camel.model.RollbackDefinition;
import org.apache.camel.model.RouteBuilderDefinition;
import org.apache.camel.model.RouteContextRefDefinition;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.RouteTemplateContextRefDefinition;
import org.apache.camel.model.RouteTemplateDefinition;
import org.apache.camel.model.RouteTemplateParameterDefinition;
import org.apache.camel.model.RouteTemplatesDefinition;
import org.apache.camel.model.RoutesDefinition;
import org.apache.camel.model.RoutingSlipDefinition;
import org.apache.camel.model.SagaDefinition;
import org.apache.camel.model.SamplingDefinition;
import org.apache.camel.model.ScriptDefinition;
import org.apache.camel.model.SetBodyDefinition;
import org.apache.camel.model.SetExchangePatternDefinition;
import org.apache.camel.model.SetHeaderDefinition;
import org.apache.camel.model.SetPropertyDefinition;
import org.apache.camel.model.SortDefinition;
import org.apache.camel.model.SplitDefinition;
import org.apache.camel.model.StepDefinition;
import org.apache.camel.model.StopDefinition;
import org.apache.camel.model.ThreadPoolProfileDefinition;
import org.apache.camel.model.ThreadsDefinition;
import org.apache.camel.model.ThrottleDefinition;
import org.apache.camel.model.ThrowExceptionDefinition;
import org.apache.camel.model.ToDefinition;
import org.apache.camel.model.ToDynamicDefinition;
import org.apache.camel.model.TransactedDefinition;
import org.apache.camel.model.TransformDefinition;
import org.apache.camel.model.TryDefinition;
import org.apache.camel.model.UnmarshalDefinition;
import org.apache.camel.model.ValidateDefinition;
import org.apache.camel.model.WhenDefinition;
import org.apache.camel.model.WhenSkipSendToEndpointDefinition;
import org.apache.camel.model.WireTapDefinition;
import org.apache.camel.model.cloud.BlacklistServiceCallServiceFilterConfiguration;
import org.apache.camel.model.cloud.CachingServiceCallServiceDiscoveryConfiguration;
import org.apache.camel.model.cloud.CombinedServiceCallServiceDiscoveryConfiguration;
import org.apache.camel.model.cloud.CombinedServiceCallServiceFilterConfiguration;
import org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration;
import org.apache.camel.model.cloud.CustomServiceCallServiceFilterConfiguration;
import org.apache.camel.model.cloud.DefaultServiceCallServiceLoadBalancerConfiguration;
import org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration;
import org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration;
import org.apache.camel.model.cloud.HealthyServiceCallServiceFilterConfiguration;
import org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration;
import org.apache.camel.model.cloud.PassThroughServiceCallServiceFilterConfiguration;
import org.apache.camel.model.cloud.RibbonServiceCallServiceLoadBalancerConfiguration;
import org.apache.camel.model.cloud.ServiceCallConfigurationDefinition;
import org.apache.camel.model.cloud.ServiceCallDefinition;
import org.apache.camel.model.cloud.ServiceCallExpressionConfiguration;
import org.apache.camel.model.cloud.ServiceCallServiceChooserConfiguration;
import org.apache.camel.model.cloud.ServiceCallServiceDiscoveryConfiguration;
import org.apache.camel.model.cloud.ServiceCallServiceFilterConfiguration;
import org.apache.camel.model.cloud.ServiceCallServiceLoadBalancerConfiguration;
import org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration;
import org.apache.camel.model.cloud.ZooKeeperServiceCallServiceDiscoveryConfiguration;
import org.apache.camel.model.config.BatchResequencerConfig;
import org.apache.camel.model.config.StreamResequencerConfig;
import org.apache.camel.model.dataformat.ASN1DataFormat;
import org.apache.camel.model.dataformat.Any23DataFormat;
import org.apache.camel.model.dataformat.AvroDataFormat;
import org.apache.camel.model.dataformat.BarcodeDataFormat;
import org.apache.camel.model.dataformat.Base64DataFormat;
import org.apache.camel.model.dataformat.BeanioDataFormat;
import org.apache.camel.model.dataformat.BindyDataFormat;
import org.apache.camel.model.dataformat.CBORDataFormat;
import org.apache.camel.model.dataformat.CryptoDataFormat;
import org.apache.camel.model.dataformat.CsvDataFormat;
import org.apache.camel.model.dataformat.CustomDataFormat;
import org.apache.camel.model.dataformat.DataFormatsDefinition;
import org.apache.camel.model.dataformat.FhirJsonDataFormat;
import org.apache.camel.model.dataformat.FhirXmlDataFormat;
import org.apache.camel.model.dataformat.FlatpackDataFormat;
import org.apache.camel.model.dataformat.GrokDataFormat;
import org.apache.camel.model.dataformat.GzipDataFormat;
import org.apache.camel.model.dataformat.HL7DataFormat;
import org.apache.camel.model.dataformat.IcalDataFormat;
import org.apache.camel.model.dataformat.JacksonXMLDataFormat;
import org.apache.camel.model.dataformat.JaxbDataFormat;
import org.apache.camel.model.dataformat.JsonApiDataFormat;
import org.apache.camel.model.dataformat.JsonDataFormat;
import org.apache.camel.model.dataformat.LZFDataFormat;
import org.apache.camel.model.dataformat.MimeMultipartDataFormat;
import org.apache.camel.model.dataformat.PGPDataFormat;
import org.apache.camel.model.dataformat.ProtobufDataFormat;
import org.apache.camel.model.dataformat.RssDataFormat;
import org.apache.camel.model.dataformat.SoapJaxbDataFormat;
import org.apache.camel.model.dataformat.SyslogDataFormat;
import org.apache.camel.model.dataformat.TarFileDataFormat;
import org.apache.camel.model.dataformat.ThriftDataFormat;
import org.apache.camel.model.dataformat.TidyMarkupDataFormat;
import org.apache.camel.model.dataformat.UniVocityCsvDataFormat;
import org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat;
import org.apache.camel.model.dataformat.UniVocityHeader;
import org.apache.camel.model.dataformat.UniVocityTsvDataFormat;
import org.apache.camel.model.dataformat.XMLSecurityDataFormat;
import org.apache.camel.model.dataformat.XStreamDataFormat;
import org.apache.camel.model.dataformat.XmlRpcDataFormat;
import org.apache.camel.model.dataformat.YAMLDataFormat;
import org.apache.camel.model.dataformat.YAMLTypeFilterDefinition;
import org.apache.camel.model.dataformat.ZipDeflaterDataFormat;
import org.apache.camel.model.dataformat.ZipFileDataFormat;
import org.apache.camel.model.language.CSimpleExpression;
import org.apache.camel.model.language.ConstantExpression;
import org.apache.camel.model.language.DatasonnetExpression;
import org.apache.camel.model.language.ExchangePropertyExpression;
import org.apache.camel.model.language.ExpressionDefinition;
import org.apache.camel.model.language.GroovyExpression;
import org.apache.camel.model.language.HeaderExpression;
import org.apache.camel.model.language.Hl7TerserExpression;
import org.apache.camel.model.language.JoorExpression;
import org.apache.camel.model.language.JsonPathExpression;
import org.apache.camel.model.language.LanguageExpression;
import org.apache.camel.model.language.MethodCallExpression;
import org.apache.camel.model.language.MvelExpression;
import org.apache.camel.model.language.OgnlExpression;
import org.apache.camel.model.language.RefExpression;
import org.apache.camel.model.language.SimpleExpression;
import org.apache.camel.model.language.SpELExpression;
import org.apache.camel.model.language.TokenizerExpression;
import org.apache.camel.model.language.XMLTokenizerExpression;
import org.apache.camel.model.language.XPathExpression;
import org.apache.camel.model.language.XQueryExpression;
import org.apache.camel.model.loadbalancer.CustomLoadBalancerDefinition;
import org.apache.camel.model.loadbalancer.FailoverLoadBalancerDefinition;
import org.apache.camel.model.loadbalancer.RandomLoadBalancerDefinition;
import org.apache.camel.model.loadbalancer.RoundRobinLoadBalancerDefinition;
import org.apache.camel.model.loadbalancer.StickyLoadBalancerDefinition;
import org.apache.camel.model.loadbalancer.TopicLoadBalancerDefinition;
import org.apache.camel.model.loadbalancer.WeightedLoadBalancerDefinition;
import org.apache.camel.model.rest.DeleteVerbDefinition;
import org.apache.camel.model.rest.GetVerbDefinition;
import org.apache.camel.model.rest.HeadVerbDefinition;
import org.apache.camel.model.rest.PatchVerbDefinition;
import org.apache.camel.model.rest.PostVerbDefinition;
import org.apache.camel.model.rest.PutVerbDefinition;
import org.apache.camel.model.rest.RestBindingDefinition;
import org.apache.camel.model.rest.RestConfigurationDefinition;
import org.apache.camel.model.rest.RestDefinition;
import org.apache.camel.model.rest.RestOperationParamDefinition;
import org.apache.camel.model.rest.RestOperationResponseHeaderDefinition;
import org.apache.camel.model.rest.RestOperationResponseMsgDefinition;
import org.apache.camel.model.rest.RestPropertyDefinition;
import org.apache.camel.model.rest.RestSecuritiesDefinition;
import org.apache.camel.model.rest.RestSecurityApiKey;
import org.apache.camel.model.rest.RestSecurityBasicAuth;
import org.apache.camel.model.rest.RestSecurityOAuth2;
import org.apache.camel.model.rest.RestsDefinition;
import org.apache.camel.model.rest.SecurityDefinition;
import org.apache.camel.model.rest.VerbDefinition;
import org.apache.camel.model.transformer.CustomTransformerDefinition;
import org.apache.camel.model.transformer.DataFormatTransformerDefinition;
import org.apache.camel.model.transformer.EndpointTransformerDefinition;
import org.apache.camel.model.transformer.TransformersDefinition;
import org.apache.camel.model.validator.CustomValidatorDefinition;
import org.apache.camel.model.validator.EndpointValidatorDefinition;
import org.apache.camel.model.validator.PredicateValidatorDefinition;
import org.apache.camel.model.validator.ValidatorsDefinition;
import org.apache.camel.spi.annotations.YamlIn;
import org.apache.camel.spi.annotations.YamlProperty;
import org.apache.camel.spi.annotations.YamlType;
import org.snakeyaml.engine.v2.nodes.MappingNode;
import org.snakeyaml.engine.v2.nodes.Node;

public final class ModelDeserializers extends YamlDeserializerSupport {
    private ModelDeserializers() {
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.dataformat.ASN1DataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "asn1",
            properties = {
                    @YamlProperty(name = "clazz-name", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "using-iterator", type = "boolean")
            }
    )
    public static class ASN1DataFormatDeserializer extends YamlDeserializerBase<ASN1DataFormat> {
        public ASN1DataFormatDeserializer() {
            super(ASN1DataFormat.class);
        }

        @Override
        protected ASN1DataFormat newInstance() {
            return new ASN1DataFormat();
        }

        @Override
        protected ASN1DataFormat newInstance(String value) {
            return new ASN1DataFormat(value);
        }

        @Override
        protected boolean setProperty(ASN1DataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "clazz-name": {
                    String val = asText(node);
                    target.setClazzName(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "using-iterator": {
                    String val = asText(node);
                    target.setUsingIterator(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.AggregateDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "aggregate",
            properties = {
                    @YamlProperty(name = "aggregate-controller-ref", type = "string"),
                    @YamlProperty(name = "aggregation-repository-ref", type = "string"),
                    @YamlProperty(name = "close-correlation-key-on-completion", type = "number"),
                    @YamlProperty(name = "complete-all-on-stop", type = "boolean"),
                    @YamlProperty(name = "completion-from-batch-consumer", type = "boolean"),
                    @YamlProperty(name = "completion-interval", type = "string"),
                    @YamlProperty(name = "completion-on-new-correlation-group", type = "boolean"),
                    @YamlProperty(name = "completion-predicate", type = "object:org.apache.camel.model.ExpressionSubElementDefinition"),
                    @YamlProperty(name = "completion-size", type = "number"),
                    @YamlProperty(name = "completion-size-expression", type = "object:org.apache.camel.model.ExpressionSubElementDefinition"),
                    @YamlProperty(name = "completion-timeout", type = "string"),
                    @YamlProperty(name = "completion-timeout-checker-interval", type = "string"),
                    @YamlProperty(name = "completion-timeout-expression", type = "object:org.apache.camel.model.ExpressionSubElementDefinition"),
                    @YamlProperty(name = "correlation-expression", type = "object:org.apache.camel.model.ExpressionSubElementDefinition"),
                    @YamlProperty(name = "discard-on-aggregation-failure", type = "boolean"),
                    @YamlProperty(name = "discard-on-completion-timeout", type = "boolean"),
                    @YamlProperty(name = "eager-check-completion", type = "boolean"),
                    @YamlProperty(name = "executor-service-ref", type = "string"),
                    @YamlProperty(name = "force-completion-on-stop", type = "boolean"),
                    @YamlProperty(name = "ignore-invalid-correlation-keys", type = "boolean"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "optimistic-lock-retry-policy", type = "object:org.apache.camel.model.OptimisticLockRetryPolicyDefinition"),
                    @YamlProperty(name = "optimistic-locking", type = "boolean"),
                    @YamlProperty(name = "parallel-processing", type = "boolean"),
                    @YamlProperty(name = "strategy-method-allow-null", type = "boolean"),
                    @YamlProperty(name = "strategy-method-name", type = "string"),
                    @YamlProperty(name = "strategy-ref", type = "string"),
                    @YamlProperty(name = "timeout-checker-executor-service-ref", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class AggregateDefinitionDeserializer extends YamlDeserializerBase<AggregateDefinition> {
        public AggregateDefinitionDeserializer() {
            super(AggregateDefinition.class);
        }

        @Override
        protected AggregateDefinition newInstance() {
            return new AggregateDefinition();
        }

        @Override
        protected boolean setProperty(AggregateDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "aggregate-controller-ref": {
                    String val = asText(node);
                    target.setAggregateControllerRef(val);
                    break;
                }
                case "aggregation-repository-ref": {
                    String val = asText(node);
                    target.setAggregationRepositoryRef(val);
                    break;
                }
                case "close-correlation-key-on-completion": {
                    String val = asText(node);
                    target.setCloseCorrelationKeyOnCompletion(val);
                    break;
                }
                case "complete-all-on-stop": {
                    String val = asText(node);
                    target.setCompleteAllOnStop(val);
                    break;
                }
                case "completion-from-batch-consumer": {
                    String val = asText(node);
                    target.setCompletionFromBatchConsumer(val);
                    break;
                }
                case "completion-interval": {
                    String val = asText(node);
                    target.setCompletionInterval(val);
                    break;
                }
                case "completion-on-new-correlation-group": {
                    String val = asText(node);
                    target.setCompletionOnNewCorrelationGroup(val);
                    break;
                }
                case "completion-predicate": {
                    org.apache.camel.model.ExpressionSubElementDefinition val = asType(node, org.apache.camel.model.ExpressionSubElementDefinition.class);
                    target.setCompletionPredicate(val);
                    break;
                }
                case "completion-size": {
                    String val = asText(node);
                    target.setCompletionSize(val);
                    break;
                }
                case "completion-size-expression": {
                    org.apache.camel.model.ExpressionSubElementDefinition val = asType(node, org.apache.camel.model.ExpressionSubElementDefinition.class);
                    target.setCompletionSizeExpression(val);
                    break;
                }
                case "completion-timeout": {
                    String val = asText(node);
                    target.setCompletionTimeout(val);
                    break;
                }
                case "completion-timeout-checker-interval": {
                    String val = asText(node);
                    target.setCompletionTimeoutCheckerInterval(val);
                    break;
                }
                case "completion-timeout-expression": {
                    org.apache.camel.model.ExpressionSubElementDefinition val = asType(node, org.apache.camel.model.ExpressionSubElementDefinition.class);
                    target.setCompletionTimeoutExpression(val);
                    break;
                }
                case "correlation-expression": {
                    org.apache.camel.model.ExpressionSubElementDefinition val = asType(node, org.apache.camel.model.ExpressionSubElementDefinition.class);
                    target.setCorrelationExpression(val);
                    break;
                }
                case "discard-on-aggregation-failure": {
                    String val = asText(node);
                    target.setDiscardOnAggregationFailure(val);
                    break;
                }
                case "discard-on-completion-timeout": {
                    String val = asText(node);
                    target.setDiscardOnCompletionTimeout(val);
                    break;
                }
                case "eager-check-completion": {
                    String val = asText(node);
                    target.setEagerCheckCompletion(val);
                    break;
                }
                case "executor-service-ref": {
                    String val = asText(node);
                    target.setExecutorServiceRef(val);
                    break;
                }
                case "force-completion-on-stop": {
                    String val = asText(node);
                    target.setForceCompletionOnStop(val);
                    break;
                }
                case "ignore-invalid-correlation-keys": {
                    String val = asText(node);
                    target.setIgnoreInvalidCorrelationKeys(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "optimistic-lock-retry-policy": {
                    org.apache.camel.model.OptimisticLockRetryPolicyDefinition val = asType(node, org.apache.camel.model.OptimisticLockRetryPolicyDefinition.class);
                    target.setOptimisticLockRetryPolicyDefinition(val);
                    break;
                }
                case "optimistic-locking": {
                    String val = asText(node);
                    target.setOptimisticLocking(val);
                    break;
                }
                case "parallel-processing": {
                    String val = asText(node);
                    target.setParallelProcessing(val);
                    break;
                }
                case "strategy-method-allow-null": {
                    String val = asText(node);
                    target.setStrategyMethodAllowNull(val);
                    break;
                }
                case "strategy-method-name": {
                    String val = asText(node);
                    target.setStrategyMethodName(val);
                    break;
                }
                case "strategy-ref": {
                    String val = asText(node);
                    target.setStrategyRef(val);
                    break;
                }
                case "timeout-checker-executor-service-ref": {
                    String val = asText(node);
                    target.setTimeoutCheckerExecutorServiceRef(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.dataformat.Any23DataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "any23",
            properties = {
                    @YamlProperty(name = "base-uri", type = "string"),
                    @YamlProperty(name = "configuration", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "extractors", type = "array:string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "output-format", type = "string")
            }
    )
    public static class Any23DataFormatDeserializer extends YamlDeserializerBase<Any23DataFormat> {
        public Any23DataFormatDeserializer() {
            super(Any23DataFormat.class);
        }

        @Override
        protected Any23DataFormat newInstance() {
            return new Any23DataFormat();
        }

        @Override
        protected Any23DataFormat newInstance(String value) {
            return new Any23DataFormat(value);
        }

        @Override
        protected boolean setProperty(Any23DataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "base-uri": {
                    String val = asText(node);
                    target.setBaseURI(val);
                    break;
                }
                case "configuration": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setConfiguration(val);
                    break;
                }
                case "extractors": {
                    java.util.List<String> val = asStringList(node);
                    target.setExtractors(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "output-format": {
                    String val = asText(node);
                    target.setOutputFormat(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.dataformat.AvroDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "avro",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "instance-class-name", type = "string")
            }
    )
    public static class AvroDataFormatDeserializer extends YamlDeserializerBase<AvroDataFormat> {
        public AvroDataFormatDeserializer() {
            super(AvroDataFormat.class);
        }

        @Override
        protected AvroDataFormat newInstance() {
            return new AvroDataFormat();
        }

        @Override
        protected AvroDataFormat newInstance(String value) {
            return new AvroDataFormat(value);
        }

        @Override
        protected boolean setProperty(AvroDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "instance-class-name": {
                    String val = asText(node);
                    target.setInstanceClassName(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.BarcodeDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "barcode",
            properties = {
                    @YamlProperty(name = "barcode-format", type = "string"),
                    @YamlProperty(name = "height", type = "number"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "image-type", type = "string"),
                    @YamlProperty(name = "width", type = "number")
            }
    )
    public static class BarcodeDataFormatDeserializer extends YamlDeserializerBase<BarcodeDataFormat> {
        public BarcodeDataFormatDeserializer() {
            super(BarcodeDataFormat.class);
        }

        @Override
        protected BarcodeDataFormat newInstance() {
            return new BarcodeDataFormat();
        }

        @Override
        protected boolean setProperty(BarcodeDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "barcode-format": {
                    String val = asText(node);
                    target.setBarcodeFormat(val);
                    break;
                }
                case "height": {
                    String val = asText(node);
                    target.setHeight(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "image-type": {
                    String val = asText(node);
                    target.setImageType(val);
                    break;
                }
                case "width": {
                    String val = asText(node);
                    target.setWidth(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.Base64DataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "base64",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "line-length", type = "number"),
                    @YamlProperty(name = "line-separator", type = "string"),
                    @YamlProperty(name = "url-safe", type = "boolean")
            }
    )
    public static class Base64DataFormatDeserializer extends YamlDeserializerBase<Base64DataFormat> {
        public Base64DataFormatDeserializer() {
            super(Base64DataFormat.class);
        }

        @Override
        protected Base64DataFormat newInstance() {
            return new Base64DataFormat();
        }

        @Override
        protected boolean setProperty(Base64DataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "line-length": {
                    String val = asText(node);
                    target.setLineLength(val);
                    break;
                }
                case "line-separator": {
                    String val = asText(node);
                    target.setLineSeparator(val);
                    break;
                }
                case "url-safe": {
                    String val = asText(node);
                    target.setUrlSafe(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.config.BatchResequencerConfig.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "batch-config",
            properties = {
                    @YamlProperty(name = "allow-duplicates", type = "boolean"),
                    @YamlProperty(name = "batch-size", type = "number"),
                    @YamlProperty(name = "batch-timeout", type = "string"),
                    @YamlProperty(name = "ignore-invalid-exchanges", type = "boolean"),
                    @YamlProperty(name = "reverse", type = "boolean")
            }
    )
    public static class BatchResequencerConfigDeserializer extends YamlDeserializerBase<BatchResequencerConfig> {
        public BatchResequencerConfigDeserializer() {
            super(BatchResequencerConfig.class);
        }

        @Override
        protected BatchResequencerConfig newInstance() {
            return new BatchResequencerConfig();
        }

        @Override
        protected boolean setProperty(BatchResequencerConfig target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-duplicates": {
                    String val = asText(node);
                    target.setAllowDuplicates(val);
                    break;
                }
                case "batch-size": {
                    String val = asText(node);
                    target.setBatchSize(val);
                    break;
                }
                case "batch-timeout": {
                    String val = asText(node);
                    target.setBatchTimeout(val);
                    break;
                }
                case "ignore-invalid-exchanges": {
                    String val = asText(node);
                    target.setIgnoreInvalidExchanges(val);
                    break;
                }
                case "reverse": {
                    String val = asText(node);
                    target.setReverse(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.BeanDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "bean",
            properties = {
                    @YamlProperty(name = "bean-type", type = "string"),
                    @YamlProperty(name = "cache", type = "boolean"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "method", type = "string"),
                    @YamlProperty(name = "ref", type = "string"),
                    @YamlProperty(name = "scope", type = "string")
            }
    )
    public static class BeanDefinitionDeserializer extends YamlDeserializerBase<BeanDefinition> {
        public BeanDefinitionDeserializer() {
            super(BeanDefinition.class);
        }

        @Override
        protected BeanDefinition newInstance() {
            return new BeanDefinition();
        }

        @Override
        protected BeanDefinition newInstance(String value) {
            return new BeanDefinition(value);
        }

        @Override
        protected boolean setProperty(BeanDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "bean-type": {
                    String val = asText(node);
                    target.setBeanType(val);
                    break;
                }
                case "cache": {
                    String val = asText(node);
                    target.setCache(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "method": {
                    String val = asText(node);
                    target.setMethod(val);
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                case "scope": {
                    String val = asText(node);
                    target.setScope(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.BeanioDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "beanio",
            properties = {
                    @YamlProperty(name = "bean-reader-error-handler-type", type = "string"),
                    @YamlProperty(name = "encoding", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "ignore-invalid-records", type = "boolean"),
                    @YamlProperty(name = "ignore-unexpected-records", type = "boolean"),
                    @YamlProperty(name = "ignore-unidentified-records", type = "boolean"),
                    @YamlProperty(name = "mapping", type = "string"),
                    @YamlProperty(name = "stream-name", type = "string"),
                    @YamlProperty(name = "unmarshal-single-object", type = "boolean")
            }
    )
    public static class BeanioDataFormatDeserializer extends YamlDeserializerBase<BeanioDataFormat> {
        public BeanioDataFormatDeserializer() {
            super(BeanioDataFormat.class);
        }

        @Override
        protected BeanioDataFormat newInstance() {
            return new BeanioDataFormat();
        }

        @Override
        protected boolean setProperty(BeanioDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "bean-reader-error-handler-type": {
                    String val = asText(node);
                    target.setBeanReaderErrorHandlerType(val);
                    break;
                }
                case "encoding": {
                    String val = asText(node);
                    target.setEncoding(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "ignore-invalid-records": {
                    String val = asText(node);
                    target.setIgnoreInvalidRecords(val);
                    break;
                }
                case "ignore-unexpected-records": {
                    String val = asText(node);
                    target.setIgnoreUnexpectedRecords(val);
                    break;
                }
                case "ignore-unidentified-records": {
                    String val = asText(node);
                    target.setIgnoreUnidentifiedRecords(val);
                    break;
                }
                case "mapping": {
                    String val = asText(node);
                    target.setMapping(val);
                    break;
                }
                case "stream-name": {
                    String val = asText(node);
                    target.setStreamName(val);
                    break;
                }
                case "unmarshal-single-object": {
                    String val = asText(node);
                    target.setUnmarshalSingleObject(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.BindyDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "bindy",
            properties = {
                    @YamlProperty(name = "allow-empty-stream", type = "boolean"),
                    @YamlProperty(name = "class-type", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "locale", type = "string"),
                    @YamlProperty(name = "type", type = "string", required = true),
                    @YamlProperty(name = "unwrap-single-instance", type = "boolean")
            }
    )
    public static class BindyDataFormatDeserializer extends YamlDeserializerBase<BindyDataFormat> {
        public BindyDataFormatDeserializer() {
            super(BindyDataFormat.class);
        }

        @Override
        protected BindyDataFormat newInstance() {
            return new BindyDataFormat();
        }

        @Override
        protected boolean setProperty(BindyDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-empty-stream": {
                    String val = asText(node);
                    target.setAllowEmptyStream(val);
                    break;
                }
                case "class-type": {
                    String val = asText(node);
                    target.setClassType(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "locale": {
                    String val = asText(node);
                    target.setLocale(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                case "unwrap-single-instance": {
                    String val = asText(node);
                    target.setUnwrapSingleInstance(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.BlacklistServiceCallServiceFilterConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "blacklist-service-filter",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "servers", type = "array:string")
            }
    )
    public static class BlacklistServiceCallServiceFilterConfigurationDeserializer extends YamlDeserializerBase<BlacklistServiceCallServiceFilterConfiguration> {
        public BlacklistServiceCallServiceFilterConfigurationDeserializer() {
            super(BlacklistServiceCallServiceFilterConfiguration.class);
        }

        @Override
        protected BlacklistServiceCallServiceFilterConfiguration newInstance() {
            return new BlacklistServiceCallServiceFilterConfiguration();
        }

        @Override
        protected boolean setProperty(BlacklistServiceCallServiceFilterConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                case "servers": {
                    java.util.List<String> val = asStringList(node);
                    target.setServers(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.CBORDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "cbor",
            properties = {
                    @YamlProperty(name = "allow-jms-type", type = "boolean"),
                    @YamlProperty(name = "allow-unmarshall-type", type = "boolean"),
                    @YamlProperty(name = "collection-type-name", type = "string"),
                    @YamlProperty(name = "disable-features", type = "string"),
                    @YamlProperty(name = "enable-features", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "object-mapper", type = "string"),
                    @YamlProperty(name = "pretty-print", type = "boolean"),
                    @YamlProperty(name = "unmarshal-type-name", type = "string"),
                    @YamlProperty(name = "use-default-object-mapper", type = "boolean"),
                    @YamlProperty(name = "use-list", type = "boolean")
            }
    )
    public static class CBORDataFormatDeserializer extends YamlDeserializerBase<CBORDataFormat> {
        public CBORDataFormatDeserializer() {
            super(CBORDataFormat.class);
        }

        @Override
        protected CBORDataFormat newInstance() {
            return new CBORDataFormat();
        }

        @Override
        protected boolean setProperty(CBORDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-jms-type": {
                    String val = asText(node);
                    target.setAllowJmsType(val);
                    break;
                }
                case "allow-unmarshall-type": {
                    String val = asText(node);
                    target.setAllowUnmarshallType(val);
                    break;
                }
                case "collection-type-name": {
                    String val = asText(node);
                    target.setCollectionTypeName(val);
                    break;
                }
                case "disable-features": {
                    String val = asText(node);
                    target.setDisableFeatures(val);
                    break;
                }
                case "enable-features": {
                    String val = asText(node);
                    target.setEnableFeatures(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "object-mapper": {
                    String val = asText(node);
                    target.setObjectMapper(val);
                    break;
                }
                case "pretty-print": {
                    String val = asText(node);
                    target.setPrettyPrint(val);
                    break;
                }
                case "unmarshal-type-name": {
                    String val = asText(node);
                    target.setUnmarshalTypeName(val);
                    break;
                }
                case "use-default-object-mapper": {
                    String val = asText(node);
                    target.setUseDefaultObjectMapper(val);
                    break;
                }
                case "use-list": {
                    String val = asText(node);
                    target.setUseList(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.CSimpleExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "csimple",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "result-type", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class CSimpleExpressionDeserializer extends YamlDeserializerBase<CSimpleExpression> {
        public CSimpleExpressionDeserializer() {
            super(CSimpleExpression.class);
        }

        @Override
        protected CSimpleExpression newInstance() {
            return new CSimpleExpression();
        }

        @Override
        protected CSimpleExpression newInstance(String value) {
            return new CSimpleExpression(value);
        }

        @Override
        protected boolean setProperty(CSimpleExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "result-type": {
                    String val = asText(node);
                    target.setResultTypeName(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.CachingServiceCallServiceDiscoveryConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "caching-service-discovery",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "consul-service-discovery", type = "object:org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "dns-service-discovery", type = "object:org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "etcd-service-discovery", type = "object:org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "kubernetes-service-discovery", type = "object:org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "combined-service-discovery", type = "object:org.apache.camel.model.cloud.CombinedServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "static-service-discovery", type = "object:org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "timeout", type = "number"),
                    @YamlProperty(name = "units", type = "string")
            }
    )
    public static class CachingServiceCallServiceDiscoveryConfigurationDeserializer extends YamlDeserializerBase<CachingServiceCallServiceDiscoveryConfiguration> {
        public CachingServiceCallServiceDiscoveryConfigurationDeserializer() {
            super(CachingServiceCallServiceDiscoveryConfiguration.class);
        }

        @Override
        protected CachingServiceCallServiceDiscoveryConfiguration newInstance() {
            return new CachingServiceCallServiceDiscoveryConfiguration();
        }

        @Override
        protected boolean setProperty(CachingServiceCallServiceDiscoveryConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                case "service-discovery-configuration": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "consul-service-discovery": {
                    org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "dns-service-discovery": {
                    org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "etcd-service-discovery": {
                    org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "kubernetes-service-discovery": {
                    org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "combined-service-discovery": {
                    org.apache.camel.model.cloud.CombinedServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.CombinedServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "static-service-discovery": {
                    org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "timeout": {
                    String val = asText(node);
                    target.setTimeout(val);
                    break;
                }
                case "units": {
                    String val = asText(node);
                    target.setUnits(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.CatchDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "do-catch",
            properties = {
                    @YamlProperty(name = "exception", type = "array:string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "on-when", type = "object:org.apache.camel.model.WhenDefinition"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class CatchDefinitionDeserializer extends YamlDeserializerBase<CatchDefinition> {
        public CatchDefinitionDeserializer() {
            super(CatchDefinition.class);
        }

        @Override
        protected CatchDefinition newInstance() {
            return new CatchDefinition();
        }

        @Override
        protected boolean setProperty(CatchDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "exception": {
                    java.util.List<String> val = asStringList(node);
                    target.setExceptions(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "on-when": {
                    org.apache.camel.model.WhenDefinition val = asType(node, org.apache.camel.model.WhenDefinition.class);
                    target.setOnWhen(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.ChoiceDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "choice",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "otherwise", type = "object:org.apache.camel.model.OtherwiseDefinition"),
                    @YamlProperty(name = "when-clauses", type = "array:org.apache.camel.model.WhenDefinition"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class ChoiceDefinitionDeserializer extends YamlDeserializerBase<ChoiceDefinition> {
        public ChoiceDefinitionDeserializer() {
            super(ChoiceDefinition.class);
        }

        @Override
        protected ChoiceDefinition newInstance() {
            return new ChoiceDefinition();
        }

        @Override
        protected boolean setProperty(ChoiceDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "otherwise": {
                    org.apache.camel.model.OtherwiseDefinition val = asType(node, org.apache.camel.model.OtherwiseDefinition.class);
                    target.setOtherwise(val);
                    break;
                }
                case "when": {
                    java.util.List<org.apache.camel.model.WhenDefinition> val = asFlatList(node, org.apache.camel.model.WhenDefinition.class);
                    target.setWhenClauses(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.CircuitBreakerDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "circuit-breaker",
            properties = {
                    @YamlProperty(name = "configuration-ref", type = "string"),
                    @YamlProperty(name = "fault-tolerance-configuration", type = "object:org.apache.camel.model.FaultToleranceConfigurationDefinition"),
                    @YamlProperty(name = "hystrix-configuration", type = "object:org.apache.camel.model.HystrixConfigurationDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "on-fallback", type = "object:org.apache.camel.model.OnFallbackDefinition"),
                    @YamlProperty(name = "resilience4j-configuration", type = "object:org.apache.camel.model.Resilience4jConfigurationDefinition"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class CircuitBreakerDefinitionDeserializer extends YamlDeserializerBase<CircuitBreakerDefinition> {
        public CircuitBreakerDefinitionDeserializer() {
            super(CircuitBreakerDefinition.class);
        }

        @Override
        protected CircuitBreakerDefinition newInstance() {
            return new CircuitBreakerDefinition();
        }

        @Override
        protected boolean setProperty(CircuitBreakerDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "configuration-ref": {
                    String val = asText(node);
                    target.setConfigurationRef(val);
                    break;
                }
                case "fault-tolerance-configuration": {
                    org.apache.camel.model.FaultToleranceConfigurationDefinition val = asType(node, org.apache.camel.model.FaultToleranceConfigurationDefinition.class);
                    target.setFaultToleranceConfiguration(val);
                    break;
                }
                case "hystrix-configuration": {
                    org.apache.camel.model.HystrixConfigurationDefinition val = asType(node, org.apache.camel.model.HystrixConfigurationDefinition.class);
                    target.setHystrixConfiguration(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "on-fallback": {
                    org.apache.camel.model.OnFallbackDefinition val = asType(node, org.apache.camel.model.OnFallbackDefinition.class);
                    target.setOnFallback(val);
                    break;
                }
                case "resilience4j-configuration": {
                    org.apache.camel.model.Resilience4jConfigurationDefinition val = asType(node, org.apache.camel.model.Resilience4jConfigurationDefinition.class);
                    target.setResilience4jConfiguration(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.ClaimCheckDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "claim-check",
            properties = {
                    @YamlProperty(name = "strategy-method-name", type = "string"),
                    @YamlProperty(name = "strategy-ref", type = "string"),
                    @YamlProperty(name = "filter", type = "string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "key", type = "string"),
                    @YamlProperty(name = "operation", type = "string")
            }
    )
    public static class ClaimCheckDefinitionDeserializer extends YamlDeserializerBase<ClaimCheckDefinition> {
        public ClaimCheckDefinitionDeserializer() {
            super(ClaimCheckDefinition.class);
        }

        @Override
        protected ClaimCheckDefinition newInstance() {
            return new ClaimCheckDefinition();
        }

        @Override
        protected boolean setProperty(ClaimCheckDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "strategy-method-name": {
                    String val = asText(node);
                    target.setAggregationStrategyMethodName(val);
                    break;
                }
                case "strategy-ref": {
                    String val = asText(node);
                    target.setAggregationStrategyRef(val);
                    break;
                }
                case "filter": {
                    String val = asText(node);
                    target.setFilter(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "key": {
                    String val = asText(node);
                    target.setKey(val);
                    break;
                }
                case "operation": {
                    String val = asText(node);
                    target.setOperation(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.CombinedServiceCallServiceDiscoveryConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "combined-service-discovery",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "consul-service-discovery", type = "object:org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "dns-service-discovery", type = "object:org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "etcd-service-discovery", type = "object:org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "kubernetes-service-discovery", type = "object:org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "static-service-discovery", type = "object:org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "caching-service-discovery", type = "object:org.apache.camel.model.cloud.CachingServiceCallServiceDiscoveryConfiguration")
            }
    )
    public static class CombinedServiceCallServiceDiscoveryConfigurationDeserializer extends YamlDeserializerBase<CombinedServiceCallServiceDiscoveryConfiguration> {
        public CombinedServiceCallServiceDiscoveryConfigurationDeserializer() {
            super(CombinedServiceCallServiceDiscoveryConfiguration.class);
        }

        @Override
        protected CombinedServiceCallServiceDiscoveryConfiguration newInstance() {
            return new CombinedServiceCallServiceDiscoveryConfiguration();
        }

        @Override
        protected boolean setProperty(CombinedServiceCallServiceDiscoveryConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                case "service-discovery-configurations": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "consul-service-discovery": {
                    org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration.class);
                    java.util.List<org.apache.camel.model.cloud.ServiceCallServiceDiscoveryConfiguration> existing = target.getServiceDiscoveryConfigurations();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setServiceDiscoveryConfigurations(existing);
                    break;
                }
                case "dns-service-discovery": {
                    org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration.class);
                    java.util.List<org.apache.camel.model.cloud.ServiceCallServiceDiscoveryConfiguration> existing = target.getServiceDiscoveryConfigurations();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setServiceDiscoveryConfigurations(existing);
                    break;
                }
                case "etcd-service-discovery": {
                    org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration.class);
                    java.util.List<org.apache.camel.model.cloud.ServiceCallServiceDiscoveryConfiguration> existing = target.getServiceDiscoveryConfigurations();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setServiceDiscoveryConfigurations(existing);
                    break;
                }
                case "kubernetes-service-discovery": {
                    org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration.class);
                    java.util.List<org.apache.camel.model.cloud.ServiceCallServiceDiscoveryConfiguration> existing = target.getServiceDiscoveryConfigurations();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setServiceDiscoveryConfigurations(existing);
                    break;
                }
                case "static-service-discovery": {
                    org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration.class);
                    java.util.List<org.apache.camel.model.cloud.ServiceCallServiceDiscoveryConfiguration> existing = target.getServiceDiscoveryConfigurations();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setServiceDiscoveryConfigurations(existing);
                    break;
                }
                case "caching-service-discovery": {
                    org.apache.camel.model.cloud.CachingServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.CachingServiceCallServiceDiscoveryConfiguration.class);
                    java.util.List<org.apache.camel.model.cloud.ServiceCallServiceDiscoveryConfiguration> existing = target.getServiceDiscoveryConfigurations();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setServiceDiscoveryConfigurations(existing);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.CombinedServiceCallServiceFilterConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "combined-service-filter",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "blacklist-service-filter", type = "object:org.apache.camel.model.cloud.BlacklistServiceCallServiceFilterConfiguration"),
                    @YamlProperty(name = "custom-service-filter", type = "object:org.apache.camel.model.cloud.CustomServiceCallServiceFilterConfiguration"),
                    @YamlProperty(name = "healthy-service-filter", type = "object:org.apache.camel.model.cloud.HealthyServiceCallServiceFilterConfiguration"),
                    @YamlProperty(name = "pass-through-service-filter", type = "object:org.apache.camel.model.cloud.PassThroughServiceCallServiceFilterConfiguration")
            }
    )
    public static class CombinedServiceCallServiceFilterConfigurationDeserializer extends YamlDeserializerBase<CombinedServiceCallServiceFilterConfiguration> {
        public CombinedServiceCallServiceFilterConfigurationDeserializer() {
            super(CombinedServiceCallServiceFilterConfiguration.class);
        }

        @Override
        protected CombinedServiceCallServiceFilterConfiguration newInstance() {
            return new CombinedServiceCallServiceFilterConfiguration();
        }

        @Override
        protected boolean setProperty(CombinedServiceCallServiceFilterConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                case "service-filter-configurations": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "blacklist-service-filter": {
                    org.apache.camel.model.cloud.BlacklistServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.BlacklistServiceCallServiceFilterConfiguration.class);
                    java.util.List<org.apache.camel.model.cloud.ServiceCallServiceFilterConfiguration> existing = target.getServiceFilterConfigurations();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setServiceFilterConfigurations(existing);
                    break;
                }
                case "custom-service-filter": {
                    org.apache.camel.model.cloud.CustomServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.CustomServiceCallServiceFilterConfiguration.class);
                    java.util.List<org.apache.camel.model.cloud.ServiceCallServiceFilterConfiguration> existing = target.getServiceFilterConfigurations();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setServiceFilterConfigurations(existing);
                    break;
                }
                case "healthy-service-filter": {
                    org.apache.camel.model.cloud.HealthyServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.HealthyServiceCallServiceFilterConfiguration.class);
                    java.util.List<org.apache.camel.model.cloud.ServiceCallServiceFilterConfiguration> existing = target.getServiceFilterConfigurations();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setServiceFilterConfigurations(existing);
                    break;
                }
                case "pass-through-service-filter": {
                    org.apache.camel.model.cloud.PassThroughServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.PassThroughServiceCallServiceFilterConfiguration.class);
                    java.util.List<org.apache.camel.model.cloud.ServiceCallServiceFilterConfiguration> existing = target.getServiceFilterConfigurations();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setServiceFilterConfigurations(existing);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.ConstantExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "constant",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class ConstantExpressionDeserializer extends YamlDeserializerBase<ConstantExpression> {
        public ConstantExpressionDeserializer() {
            super(ConstantExpression.class);
        }

        @Override
        protected ConstantExpression newInstance() {
            return new ConstantExpression();
        }

        @Override
        protected ConstantExpression newInstance(String value) {
            return new ConstantExpression(value);
        }

        @Override
        protected boolean setProperty(ConstantExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "consul-service-discovery",
            properties = {
                    @YamlProperty(name = "acl-token", type = "string"),
                    @YamlProperty(name = "block-seconds", type = "number"),
                    @YamlProperty(name = "connect-timeout-millis", type = "number"),
                    @YamlProperty(name = "datacenter", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "password", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "read-timeout-millis", type = "number"),
                    @YamlProperty(name = "url", type = "string"),
                    @YamlProperty(name = "user-name", type = "string"),
                    @YamlProperty(name = "write-timeout-millis", type = "number")
            }
    )
    public static class ConsulServiceCallServiceDiscoveryConfigurationDeserializer extends YamlDeserializerBase<ConsulServiceCallServiceDiscoveryConfiguration> {
        public ConsulServiceCallServiceDiscoveryConfigurationDeserializer() {
            super(ConsulServiceCallServiceDiscoveryConfiguration.class);
        }

        @Override
        protected ConsulServiceCallServiceDiscoveryConfiguration newInstance() {
            return new ConsulServiceCallServiceDiscoveryConfiguration();
        }

        @Override
        protected boolean setProperty(ConsulServiceCallServiceDiscoveryConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "acl-token": {
                    String val = asText(node);
                    target.setAclToken(val);
                    break;
                }
                case "block-seconds": {
                    String val = asText(node);
                    target.setBlockSeconds(val);
                    break;
                }
                case "connect-timeout-millis": {
                    String val = asText(node);
                    target.setConnectTimeoutMillis(val);
                    break;
                }
                case "datacenter": {
                    String val = asText(node);
                    target.setDatacenter(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "password": {
                    String val = asText(node);
                    target.setPassword(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                case "read-timeout-millis": {
                    String val = asText(node);
                    target.setReadTimeoutMillis(val);
                    break;
                }
                case "url": {
                    String val = asText(node);
                    target.setUrl(val);
                    break;
                }
                case "user-name": {
                    String val = asText(node);
                    target.setUserName(val);
                    break;
                }
                case "write-timeout-millis": {
                    String val = asText(node);
                    target.setWriteTimeoutMillis(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.ContextScanDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "context-scan",
            properties = {
                    @YamlProperty(name = "excludes", type = "array:string"),
                    @YamlProperty(name = "include-non-singletons", type = "boolean"),
                    @YamlProperty(name = "includes", type = "array:string")
            }
    )
    public static class ContextScanDefinitionDeserializer extends YamlDeserializerBase<ContextScanDefinition> {
        public ContextScanDefinitionDeserializer() {
            super(ContextScanDefinition.class);
        }

        @Override
        protected ContextScanDefinition newInstance() {
            return new ContextScanDefinition();
        }

        @Override
        protected boolean setProperty(ContextScanDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "excludes": {
                    java.util.List<String> val = asStringList(node);
                    target.setExcludes(val);
                    break;
                }
                case "include-non-singletons": {
                    String val = asText(node);
                    target.setIncludeNonSingletons(val);
                    break;
                }
                case "includes": {
                    java.util.List<String> val = asStringList(node);
                    target.setIncludes(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.ConvertBodyDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "convert-body-to",
            properties = {
                    @YamlProperty(name = "charset", type = "string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "type", type = "string")
            }
    )
    public static class ConvertBodyDefinitionDeserializer extends YamlDeserializerBase<ConvertBodyDefinition> {
        public ConvertBodyDefinitionDeserializer() {
            super(ConvertBodyDefinition.class);
        }

        @Override
        protected ConvertBodyDefinition newInstance() {
            return new ConvertBodyDefinition();
        }

        @Override
        protected ConvertBodyDefinition newInstance(String value) {
            return new ConvertBodyDefinition(value);
        }

        @Override
        protected boolean setProperty(ConvertBodyDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "charset": {
                    String val = asText(node);
                    target.setCharset(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.CryptoDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "crypto",
            properties = {
                    @YamlProperty(name = "algorithm", type = "string"),
                    @YamlProperty(name = "algorithm-parameter-ref", type = "string"),
                    @YamlProperty(name = "buffersize", type = "number"),
                    @YamlProperty(name = "crypto-provider", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "init-vector-ref", type = "string"),
                    @YamlProperty(name = "inline", type = "boolean"),
                    @YamlProperty(name = "key-ref", type = "string"),
                    @YamlProperty(name = "mac-algorithm", type = "string"),
                    @YamlProperty(name = "should-append-hmac", type = "boolean")
            }
    )
    public static class CryptoDataFormatDeserializer extends YamlDeserializerBase<CryptoDataFormat> {
        public CryptoDataFormatDeserializer() {
            super(CryptoDataFormat.class);
        }

        @Override
        protected CryptoDataFormat newInstance() {
            return new CryptoDataFormat();
        }

        @Override
        protected boolean setProperty(CryptoDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "algorithm": {
                    String val = asText(node);
                    target.setAlgorithm(val);
                    break;
                }
                case "algorithm-parameter-ref": {
                    String val = asText(node);
                    target.setAlgorithmParameterRef(val);
                    break;
                }
                case "buffersize": {
                    String val = asText(node);
                    target.setBuffersize(val);
                    break;
                }
                case "crypto-provider": {
                    String val = asText(node);
                    target.setCryptoProvider(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "init-vector-ref": {
                    String val = asText(node);
                    target.setInitVectorRef(val);
                    break;
                }
                case "inline": {
                    String val = asText(node);
                    target.setInline(val);
                    break;
                }
                case "key-ref": {
                    String val = asText(node);
                    target.setKeyRef(val);
                    break;
                }
                case "mac-algorithm": {
                    String val = asText(node);
                    target.setMacAlgorithm(val);
                    break;
                }
                case "should-append-hmac": {
                    String val = asText(node);
                    target.setShouldAppendHMAC(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.dataformat.CsvDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "csv",
            properties = {
                    @YamlProperty(name = "allow-missing-column-names", type = "boolean"),
                    @YamlProperty(name = "comment-marker", type = "string"),
                    @YamlProperty(name = "comment-marker-disabled", type = "boolean"),
                    @YamlProperty(name = "delimiter", type = "string"),
                    @YamlProperty(name = "escape", type = "string"),
                    @YamlProperty(name = "escape-disabled", type = "boolean"),
                    @YamlProperty(name = "format-name", type = "string"),
                    @YamlProperty(name = "format-ref", type = "string"),
                    @YamlProperty(name = "header", type = "array:string"),
                    @YamlProperty(name = "header-disabled", type = "boolean"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "ignore-empty-lines", type = "boolean"),
                    @YamlProperty(name = "ignore-header-case", type = "boolean"),
                    @YamlProperty(name = "ignore-surrounding-spaces", type = "boolean"),
                    @YamlProperty(name = "lazy-load", type = "boolean"),
                    @YamlProperty(name = "marshaller-factory-ref", type = "string"),
                    @YamlProperty(name = "null-string", type = "string"),
                    @YamlProperty(name = "null-string-disabled", type = "boolean"),
                    @YamlProperty(name = "quote", type = "string"),
                    @YamlProperty(name = "quote-disabled", type = "boolean"),
                    @YamlProperty(name = "quote-mode", type = "string"),
                    @YamlProperty(name = "record-converter-ref", type = "string"),
                    @YamlProperty(name = "record-separator", type = "string"),
                    @YamlProperty(name = "record-separator-disabled", type = "string"),
                    @YamlProperty(name = "skip-header-record", type = "boolean"),
                    @YamlProperty(name = "trailing-delimiter", type = "boolean"),
                    @YamlProperty(name = "trim", type = "boolean"),
                    @YamlProperty(name = "use-maps", type = "boolean"),
                    @YamlProperty(name = "use-ordered-maps", type = "boolean")
            }
    )
    public static class CsvDataFormatDeserializer extends YamlDeserializerBase<CsvDataFormat> {
        public CsvDataFormatDeserializer() {
            super(CsvDataFormat.class);
        }

        @Override
        protected CsvDataFormat newInstance() {
            return new CsvDataFormat();
        }

        @Override
        protected CsvDataFormat newInstance(String value) {
            return new CsvDataFormat(value);
        }

        @Override
        protected boolean setProperty(CsvDataFormat target, String propertyKey, String propertyName,
                Node node) {
            switch(propertyKey) {
                case "allow-missing-column-names": {
                    String val = asText(node);
                    target.setAllowMissingColumnNames(val);
                    break;
                }
                case "comment-marker": {
                    String val = asText(node);
                    target.setCommentMarker(val);
                    break;
                }
                case "comment-marker-disabled": {
                    String val = asText(node);
                    target.setCommentMarkerDisabled(val);
                    break;
                }
                case "delimiter": {
                    String val = asText(node);
                    target.setDelimiter(val);
                    break;
                }
                case "escape": {
                    String val = asText(node);
                    target.setEscape(val);
                    break;
                }
                case "escape-disabled": {
                    String val = asText(node);
                    target.setEscapeDisabled(val);
                    break;
                }
                case "format-name": {
                    String val = asText(node);
                    target.setFormatName(val);
                    break;
                }
                case "format-ref": {
                    String val = asText(node);
                    target.setFormatRef(val);
                    break;
                }
                case "header": {
                    java.util.List<String> val = asStringList(node);
                    target.setHeader(val);
                    break;
                }
                case "header-disabled": {
                    String val = asText(node);
                    target.setHeaderDisabled(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "ignore-empty-lines": {
                    String val = asText(node);
                    target.setIgnoreEmptyLines(val);
                    break;
                }
                case "ignore-header-case": {
                    String val = asText(node);
                    target.setIgnoreHeaderCase(val);
                    break;
                }
                case "ignore-surrounding-spaces": {
                    String val = asText(node);
                    target.setIgnoreSurroundingSpaces(val);
                    break;
                }
                case "lazy-load": {
                    String val = asText(node);
                    target.setLazyLoad(val);
                    break;
                }
                case "marshaller-factory-ref": {
                    String val = asText(node);
                    target.setMarshallerFactoryRef(val);
                    break;
                }
                case "null-string": {
                    String val = asText(node);
                    target.setNullString(val);
                    break;
                }
                case "null-string-disabled": {
                    String val = asText(node);
                    target.setNullStringDisabled(val);
                    break;
                }
                case "quote": {
                    String val = asText(node);
                    target.setQuote(val);
                    break;
                }
                case "quote-disabled": {
                    String val = asText(node);
                    target.setQuoteDisabled(val);
                    break;
                }
                case "quote-mode": {
                    String val = asText(node);
                    target.setQuoteMode(val);
                    break;
                }
                case "record-converter-ref": {
                    String val = asText(node);
                    target.setRecordConverterRef(val);
                    break;
                }
                case "record-separator": {
                    String val = asText(node);
                    target.setRecordSeparator(val);
                    break;
                }
                case "record-separator-disabled": {
                    String val = asText(node);
                    target.setRecordSeparatorDisabled(val);
                    break;
                }
                case "skip-header-record": {
                    String val = asText(node);
                    target.setSkipHeaderRecord(val);
                    break;
                }
                case "trailing-delimiter": {
                    String val = asText(node);
                    target.setTrailingDelimiter(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                case "use-maps": {
                    String val = asText(node);
                    target.setUseMaps(val);
                    break;
                }
                case "use-ordered-maps": {
                    String val = asText(node);
                    target.setUseOrderedMaps(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.dataformat.CustomDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "custom-data-format",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "ref", type = "string")
            }
    )
    public static class CustomDataFormatDeserializer extends YamlDeserializerBase<CustomDataFormat> {
        public CustomDataFormatDeserializer() {
            super(CustomDataFormat.class);
        }

        @Override
        protected CustomDataFormat newInstance() {
            return new CustomDataFormat();
        }

        @Override
        protected CustomDataFormat newInstance(String value) {
            return new CustomDataFormat(value);
        }

        @Override
        protected boolean setProperty(CustomDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.loadbalancer.CustomLoadBalancerDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "custom-load-balancer",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "ref", type = "string")
            }
    )
    public static class CustomLoadBalancerDefinitionDeserializer extends YamlDeserializerBase<CustomLoadBalancerDefinition> {
        public CustomLoadBalancerDefinitionDeserializer() {
            super(CustomLoadBalancerDefinition.class);
        }

        @Override
        protected CustomLoadBalancerDefinition newInstance() {
            return new CustomLoadBalancerDefinition();
        }

        @Override
        protected CustomLoadBalancerDefinition newInstance(String value) {
            return new CustomLoadBalancerDefinition(value);
        }

        @Override
        protected boolean setProperty(CustomLoadBalancerDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.CustomServiceCallServiceFilterConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "custom-service-filter",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "ref", type = "string")
            }
    )
    public static class CustomServiceCallServiceFilterConfigurationDeserializer extends YamlDeserializerBase<CustomServiceCallServiceFilterConfiguration> {
        public CustomServiceCallServiceFilterConfigurationDeserializer() {
            super(CustomServiceCallServiceFilterConfiguration.class);
        }

        @Override
        protected CustomServiceCallServiceFilterConfiguration newInstance() {
            return new CustomServiceCallServiceFilterConfiguration();
        }

        @Override
        protected boolean setProperty(CustomServiceCallServiceFilterConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setServiceFilterRef(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.transformer.CustomTransformerDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            properties = {
                    @YamlProperty(name = "class-name", type = "string"),
                    @YamlProperty(name = "from-type", type = "string"),
                    @YamlProperty(name = "ref", type = "string"),
                    @YamlProperty(name = "scheme", type = "string"),
                    @YamlProperty(name = "to-type", type = "string")
            }
    )
    public static class CustomTransformerDefinitionDeserializer extends YamlDeserializerBase<CustomTransformerDefinition> {
        public CustomTransformerDefinitionDeserializer() {
            super(CustomTransformerDefinition.class);
        }

        @Override
        protected CustomTransformerDefinition newInstance() {
            return new CustomTransformerDefinition();
        }

        @Override
        protected boolean setProperty(CustomTransformerDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "class-name": {
                    String val = asText(node);
                    target.setClassName(val);
                    break;
                }
                case "from-type": {
                    String val = asText(node);
                    target.setFromType(val);
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                case "scheme": {
                    String val = asText(node);
                    target.setScheme(val);
                    break;
                }
                case "to-type": {
                    String val = asText(node);
                    target.setToType(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.validator.CustomValidatorDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            properties = {
                    @YamlProperty(name = "class-name", type = "string"),
                    @YamlProperty(name = "ref", type = "string"),
                    @YamlProperty(name = "type", type = "string")
            }
    )
    public static class CustomValidatorDefinitionDeserializer extends YamlDeserializerBase<CustomValidatorDefinition> {
        public CustomValidatorDefinitionDeserializer() {
            super(CustomValidatorDefinition.class);
        }

        @Override
        protected CustomValidatorDefinition newInstance() {
            return new CustomValidatorDefinition();
        }

        @Override
        protected boolean setProperty(CustomValidatorDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "class-name": {
                    String val = asText(node);
                    target.setClassName(val);
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.DataFormatDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            properties = @YamlProperty(name = "id", type = "string")
    )
    public static class DataFormatDefinitionDeserializer extends YamlDeserializerBase<DataFormatDefinition> {
        public DataFormatDefinitionDeserializer() {
            super(DataFormatDefinition.class);
        }

        @Override
        protected DataFormatDefinition newInstance() {
            return new DataFormatDefinition();
        }

        @Override
        protected boolean setProperty(DataFormatDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.transformer.DataFormatTransformerDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            properties = {
                    @YamlProperty(name = "any23", type = "object:org.apache.camel.model.dataformat.Any23DataFormat"),
                    @YamlProperty(name = "asn1", type = "object:org.apache.camel.model.dataformat.ASN1DataFormat"),
                    @YamlProperty(name = "avro", type = "object:org.apache.camel.model.dataformat.AvroDataFormat"),
                    @YamlProperty(name = "barcode", type = "object:org.apache.camel.model.dataformat.BarcodeDataFormat"),
                    @YamlProperty(name = "base64", type = "object:org.apache.camel.model.dataformat.Base64DataFormat"),
                    @YamlProperty(name = "beanio", type = "object:org.apache.camel.model.dataformat.BeanioDataFormat"),
                    @YamlProperty(name = "bindy", type = "object:org.apache.camel.model.dataformat.BindyDataFormat"),
                    @YamlProperty(name = "cbor", type = "object:org.apache.camel.model.dataformat.CBORDataFormat"),
                    @YamlProperty(name = "crypto", type = "object:org.apache.camel.model.dataformat.CryptoDataFormat"),
                    @YamlProperty(name = "csv", type = "object:org.apache.camel.model.dataformat.CsvDataFormat"),
                    @YamlProperty(name = "custom", type = "object:org.apache.camel.model.dataformat.CustomDataFormat"),
                    @YamlProperty(name = "fhir-json", type = "object:org.apache.camel.model.dataformat.FhirJsonDataFormat"),
                    @YamlProperty(name = "fhir-xml", type = "object:org.apache.camel.model.dataformat.FhirXmlDataFormat"),
                    @YamlProperty(name = "flatpack", type = "object:org.apache.camel.model.dataformat.FlatpackDataFormat"),
                    @YamlProperty(name = "grok", type = "object:org.apache.camel.model.dataformat.GrokDataFormat"),
                    @YamlProperty(name = "gzip", type = "object:org.apache.camel.model.dataformat.GzipDataFormat"),
                    @YamlProperty(name = "hl7", type = "object:org.apache.camel.model.dataformat.HL7DataFormat"),
                    @YamlProperty(name = "ical", type = "object:org.apache.camel.model.dataformat.IcalDataFormat"),
                    @YamlProperty(name = "jacksonxml", type = "object:org.apache.camel.model.dataformat.JacksonXMLDataFormat"),
                    @YamlProperty(name = "jaxb", type = "object:org.apache.camel.model.dataformat.JaxbDataFormat"),
                    @YamlProperty(name = "json", type = "object:org.apache.camel.model.dataformat.JsonDataFormat"),
                    @YamlProperty(name = "json-api", type = "object:org.apache.camel.model.dataformat.JsonApiDataFormat"),
                    @YamlProperty(name = "lzf", type = "object:org.apache.camel.model.dataformat.LZFDataFormat"),
                    @YamlProperty(name = "mime-multipart", type = "object:org.apache.camel.model.dataformat.MimeMultipartDataFormat"),
                    @YamlProperty(name = "protobuf", type = "object:org.apache.camel.model.dataformat.ProtobufDataFormat"),
                    @YamlProperty(name = "rss", type = "object:org.apache.camel.model.dataformat.RssDataFormat"),
                    @YamlProperty(name = "secure-xml", type = "object:org.apache.camel.model.dataformat.XMLSecurityDataFormat"),
                    @YamlProperty(name = "soapjaxb", type = "object:org.apache.camel.model.dataformat.SoapJaxbDataFormat"),
                    @YamlProperty(name = "syslog", type = "object:org.apache.camel.model.dataformat.SyslogDataFormat"),
                    @YamlProperty(name = "tarfile", type = "object:org.apache.camel.model.dataformat.TarFileDataFormat"),
                    @YamlProperty(name = "thrift", type = "object:org.apache.camel.model.dataformat.ThriftDataFormat"),
                    @YamlProperty(name = "tidy-markup", type = "object:org.apache.camel.model.dataformat.TidyMarkupDataFormat"),
                    @YamlProperty(name = "univocity-csv", type = "object:org.apache.camel.model.dataformat.UniVocityCsvDataFormat"),
                    @YamlProperty(name = "univocity-fixed", type = "object:org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat"),
                    @YamlProperty(name = "univocity-tsv", type = "object:org.apache.camel.model.dataformat.UniVocityTsvDataFormat"),
                    @YamlProperty(name = "xmlrpc", type = "object:org.apache.camel.model.dataformat.XmlRpcDataFormat"),
                    @YamlProperty(name = "xstream", type = "object:org.apache.camel.model.dataformat.XStreamDataFormat"),
                    @YamlProperty(name = "pgp", type = "object:org.apache.camel.model.dataformat.PGPDataFormat"),
                    @YamlProperty(name = "yaml", type = "object:org.apache.camel.model.dataformat.YAMLDataFormat"),
                    @YamlProperty(name = "zip", type = "object:org.apache.camel.model.dataformat.ZipDeflaterDataFormat"),
                    @YamlProperty(name = "zipfile", type = "object:org.apache.camel.model.dataformat.ZipFileDataFormat"),
                    @YamlProperty(name = "from-type", type = "string"),
                    @YamlProperty(name = "ref", type = "string"),
                    @YamlProperty(name = "scheme", type = "string"),
                    @YamlProperty(name = "to-type", type = "string")
            }
    )
    public static class DataFormatTransformerDefinitionDeserializer extends YamlDeserializerBase<DataFormatTransformerDefinition> {
        public DataFormatTransformerDefinitionDeserializer() {
            super(DataFormatTransformerDefinition.class);
        }

        @Override
        protected DataFormatTransformerDefinition newInstance() {
            return new DataFormatTransformerDefinition();
        }

        @Override
        protected boolean setProperty(DataFormatTransformerDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "data-format-type": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "any23": {
                    org.apache.camel.model.dataformat.Any23DataFormat val = asType(node, org.apache.camel.model.dataformat.Any23DataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "asn1": {
                    org.apache.camel.model.dataformat.ASN1DataFormat val = asType(node, org.apache.camel.model.dataformat.ASN1DataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "avro": {
                    org.apache.camel.model.dataformat.AvroDataFormat val = asType(node, org.apache.camel.model.dataformat.AvroDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "barcode": {
                    org.apache.camel.model.dataformat.BarcodeDataFormat val = asType(node, org.apache.camel.model.dataformat.BarcodeDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "base64": {
                    org.apache.camel.model.dataformat.Base64DataFormat val = asType(node, org.apache.camel.model.dataformat.Base64DataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "beanio": {
                    org.apache.camel.model.dataformat.BeanioDataFormat val = asType(node, org.apache.camel.model.dataformat.BeanioDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "bindy": {
                    org.apache.camel.model.dataformat.BindyDataFormat val = asType(node, org.apache.camel.model.dataformat.BindyDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "cbor": {
                    org.apache.camel.model.dataformat.CBORDataFormat val = asType(node, org.apache.camel.model.dataformat.CBORDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "crypto": {
                    org.apache.camel.model.dataformat.CryptoDataFormat val = asType(node, org.apache.camel.model.dataformat.CryptoDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "csv": {
                    org.apache.camel.model.dataformat.CsvDataFormat val = asType(node, org.apache.camel.model.dataformat.CsvDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "custom": {
                    org.apache.camel.model.dataformat.CustomDataFormat val = asType(node, org.apache.camel.model.dataformat.CustomDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "fhir-json": {
                    org.apache.camel.model.dataformat.FhirJsonDataFormat val = asType(node, org.apache.camel.model.dataformat.FhirJsonDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "fhir-xml": {
                    org.apache.camel.model.dataformat.FhirXmlDataFormat val = asType(node, org.apache.camel.model.dataformat.FhirXmlDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "flatpack": {
                    org.apache.camel.model.dataformat.FlatpackDataFormat val = asType(node, org.apache.camel.model.dataformat.FlatpackDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "grok": {
                    org.apache.camel.model.dataformat.GrokDataFormat val = asType(node, org.apache.camel.model.dataformat.GrokDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "gzip": {
                    org.apache.camel.model.dataformat.GzipDataFormat val = asType(node, org.apache.camel.model.dataformat.GzipDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "hl7": {
                    org.apache.camel.model.dataformat.HL7DataFormat val = asType(node, org.apache.camel.model.dataformat.HL7DataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "ical": {
                    org.apache.camel.model.dataformat.IcalDataFormat val = asType(node, org.apache.camel.model.dataformat.IcalDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "jacksonxml": {
                    org.apache.camel.model.dataformat.JacksonXMLDataFormat val = asType(node, org.apache.camel.model.dataformat.JacksonXMLDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "jaxb": {
                    org.apache.camel.model.dataformat.JaxbDataFormat val = asType(node, org.apache.camel.model.dataformat.JaxbDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "json": {
                    org.apache.camel.model.dataformat.JsonDataFormat val = asType(node, org.apache.camel.model.dataformat.JsonDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "json-api": {
                    org.apache.camel.model.dataformat.JsonApiDataFormat val = asType(node, org.apache.camel.model.dataformat.JsonApiDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "lzf": {
                    org.apache.camel.model.dataformat.LZFDataFormat val = asType(node, org.apache.camel.model.dataformat.LZFDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "mime-multipart": {
                    org.apache.camel.model.dataformat.MimeMultipartDataFormat val = asType(node, org.apache.camel.model.dataformat.MimeMultipartDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "protobuf": {
                    org.apache.camel.model.dataformat.ProtobufDataFormat val = asType(node, org.apache.camel.model.dataformat.ProtobufDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "rss": {
                    org.apache.camel.model.dataformat.RssDataFormat val = asType(node, org.apache.camel.model.dataformat.RssDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "secure-xml": {
                    org.apache.camel.model.dataformat.XMLSecurityDataFormat val = asType(node, org.apache.camel.model.dataformat.XMLSecurityDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "soapjaxb": {
                    org.apache.camel.model.dataformat.SoapJaxbDataFormat val = asType(node, org.apache.camel.model.dataformat.SoapJaxbDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "syslog": {
                    org.apache.camel.model.dataformat.SyslogDataFormat val = asType(node, org.apache.camel.model.dataformat.SyslogDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "tarfile": {
                    org.apache.camel.model.dataformat.TarFileDataFormat val = asType(node, org.apache.camel.model.dataformat.TarFileDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "thrift": {
                    org.apache.camel.model.dataformat.ThriftDataFormat val = asType(node, org.apache.camel.model.dataformat.ThriftDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "tidy-markup": {
                    org.apache.camel.model.dataformat.TidyMarkupDataFormat val = asType(node, org.apache.camel.model.dataformat.TidyMarkupDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "univocity-csv": {
                    org.apache.camel.model.dataformat.UniVocityCsvDataFormat val = asType(node, org.apache.camel.model.dataformat.UniVocityCsvDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "univocity-fixed": {
                    org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat val = asType(node, org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "univocity-tsv": {
                    org.apache.camel.model.dataformat.UniVocityTsvDataFormat val = asType(node, org.apache.camel.model.dataformat.UniVocityTsvDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "xmlrpc": {
                    org.apache.camel.model.dataformat.XmlRpcDataFormat val = asType(node, org.apache.camel.model.dataformat.XmlRpcDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "xstream": {
                    org.apache.camel.model.dataformat.XStreamDataFormat val = asType(node, org.apache.camel.model.dataformat.XStreamDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "pgp": {
                    org.apache.camel.model.dataformat.PGPDataFormat val = asType(node, org.apache.camel.model.dataformat.PGPDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "yaml": {
                    org.apache.camel.model.dataformat.YAMLDataFormat val = asType(node, org.apache.camel.model.dataformat.YAMLDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "zip": {
                    org.apache.camel.model.dataformat.ZipDeflaterDataFormat val = asType(node, org.apache.camel.model.dataformat.ZipDeflaterDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "zipfile": {
                    org.apache.camel.model.dataformat.ZipFileDataFormat val = asType(node, org.apache.camel.model.dataformat.ZipFileDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "from-type": {
                    String val = asText(node);
                    target.setFromType(val);
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                case "scheme": {
                    String val = asText(node);
                    target.setScheme(val);
                    break;
                }
                case "to-type": {
                    String val = asText(node);
                    target.setToType(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.DataFormatsDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "data-formats",
            properties = {
                    @YamlProperty(name = "any23", type = "object:org.apache.camel.model.dataformat.Any23DataFormat"),
                    @YamlProperty(name = "asn1", type = "object:org.apache.camel.model.dataformat.ASN1DataFormat"),
                    @YamlProperty(name = "avro", type = "object:org.apache.camel.model.dataformat.AvroDataFormat"),
                    @YamlProperty(name = "barcode", type = "object:org.apache.camel.model.dataformat.BarcodeDataFormat"),
                    @YamlProperty(name = "base64", type = "object:org.apache.camel.model.dataformat.Base64DataFormat"),
                    @YamlProperty(name = "beanio", type = "object:org.apache.camel.model.dataformat.BeanioDataFormat"),
                    @YamlProperty(name = "bindy", type = "object:org.apache.camel.model.dataformat.BindyDataFormat"),
                    @YamlProperty(name = "cbor", type = "object:org.apache.camel.model.dataformat.CBORDataFormat"),
                    @YamlProperty(name = "crypto", type = "object:org.apache.camel.model.dataformat.CryptoDataFormat"),
                    @YamlProperty(name = "csv", type = "object:org.apache.camel.model.dataformat.CsvDataFormat"),
                    @YamlProperty(name = "custom", type = "object:org.apache.camel.model.dataformat.CustomDataFormat"),
                    @YamlProperty(name = "fhir-json", type = "object:org.apache.camel.model.dataformat.FhirJsonDataFormat"),
                    @YamlProperty(name = "fhir-xml", type = "object:org.apache.camel.model.dataformat.FhirXmlDataFormat"),
                    @YamlProperty(name = "flatpack", type = "object:org.apache.camel.model.dataformat.FlatpackDataFormat"),
                    @YamlProperty(name = "grok", type = "object:org.apache.camel.model.dataformat.GrokDataFormat"),
                    @YamlProperty(name = "gzip", type = "object:org.apache.camel.model.dataformat.GzipDataFormat"),
                    @YamlProperty(name = "hl7", type = "object:org.apache.camel.model.dataformat.HL7DataFormat"),
                    @YamlProperty(name = "ical", type = "object:org.apache.camel.model.dataformat.IcalDataFormat"),
                    @YamlProperty(name = "jacksonxml", type = "object:org.apache.camel.model.dataformat.JacksonXMLDataFormat"),
                    @YamlProperty(name = "jaxb", type = "object:org.apache.camel.model.dataformat.JaxbDataFormat"),
                    @YamlProperty(name = "json", type = "object:org.apache.camel.model.dataformat.JsonDataFormat"),
                    @YamlProperty(name = "json-api", type = "object:org.apache.camel.model.dataformat.JsonApiDataFormat"),
                    @YamlProperty(name = "lzf", type = "object:org.apache.camel.model.dataformat.LZFDataFormat"),
                    @YamlProperty(name = "mime-multipart", type = "object:org.apache.camel.model.dataformat.MimeMultipartDataFormat"),
                    @YamlProperty(name = "protobuf", type = "object:org.apache.camel.model.dataformat.ProtobufDataFormat"),
                    @YamlProperty(name = "rss", type = "object:org.apache.camel.model.dataformat.RssDataFormat"),
                    @YamlProperty(name = "secure-xml", type = "object:org.apache.camel.model.dataformat.XMLSecurityDataFormat"),
                    @YamlProperty(name = "soapjaxb", type = "object:org.apache.camel.model.dataformat.SoapJaxbDataFormat"),
                    @YamlProperty(name = "syslog", type = "object:org.apache.camel.model.dataformat.SyslogDataFormat"),
                    @YamlProperty(name = "tarfile", type = "object:org.apache.camel.model.dataformat.TarFileDataFormat"),
                    @YamlProperty(name = "thrift", type = "object:org.apache.camel.model.dataformat.ThriftDataFormat"),
                    @YamlProperty(name = "tidy-markup", type = "object:org.apache.camel.model.dataformat.TidyMarkupDataFormat"),
                    @YamlProperty(name = "univocity-csv", type = "object:org.apache.camel.model.dataformat.UniVocityCsvDataFormat"),
                    @YamlProperty(name = "univocity-fixed", type = "object:org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat"),
                    @YamlProperty(name = "univocity-tsv", type = "object:org.apache.camel.model.dataformat.UniVocityTsvDataFormat"),
                    @YamlProperty(name = "xmlrpc", type = "object:org.apache.camel.model.dataformat.XmlRpcDataFormat"),
                    @YamlProperty(name = "xstream", type = "object:org.apache.camel.model.dataformat.XStreamDataFormat"),
                    @YamlProperty(name = "pgp", type = "object:org.apache.camel.model.dataformat.PGPDataFormat"),
                    @YamlProperty(name = "yaml", type = "object:org.apache.camel.model.dataformat.YAMLDataFormat"),
                    @YamlProperty(name = "zip", type = "object:org.apache.camel.model.dataformat.ZipDeflaterDataFormat"),
                    @YamlProperty(name = "zipfile", type = "object:org.apache.camel.model.dataformat.ZipFileDataFormat")
            }
    )
    public static class DataFormatsDefinitionDeserializer extends YamlDeserializerBase<DataFormatsDefinition> {
        public DataFormatsDefinitionDeserializer() {
            super(DataFormatsDefinition.class);
        }

        @Override
        protected DataFormatsDefinition newInstance() {
            return new DataFormatsDefinition();
        }

        @Override
        protected boolean setProperty(DataFormatsDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "data-formats": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "any23": {
                    org.apache.camel.model.dataformat.Any23DataFormat val = asType(node, org.apache.camel.model.dataformat.Any23DataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "asn1": {
                    org.apache.camel.model.dataformat.ASN1DataFormat val = asType(node, org.apache.camel.model.dataformat.ASN1DataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "avro": {
                    org.apache.camel.model.dataformat.AvroDataFormat val = asType(node, org.apache.camel.model.dataformat.AvroDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "barcode": {
                    org.apache.camel.model.dataformat.BarcodeDataFormat val = asType(node, org.apache.camel.model.dataformat.BarcodeDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "base64": {
                    org.apache.camel.model.dataformat.Base64DataFormat val = asType(node, org.apache.camel.model.dataformat.Base64DataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "beanio": {
                    org.apache.camel.model.dataformat.BeanioDataFormat val = asType(node, org.apache.camel.model.dataformat.BeanioDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "bindy": {
                    org.apache.camel.model.dataformat.BindyDataFormat val = asType(node, org.apache.camel.model.dataformat.BindyDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "cbor": {
                    org.apache.camel.model.dataformat.CBORDataFormat val = asType(node, org.apache.camel.model.dataformat.CBORDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "crypto": {
                    org.apache.camel.model.dataformat.CryptoDataFormat val = asType(node, org.apache.camel.model.dataformat.CryptoDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "csv": {
                    org.apache.camel.model.dataformat.CsvDataFormat val = asType(node, org.apache.camel.model.dataformat.CsvDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "custom": {
                    org.apache.camel.model.dataformat.CustomDataFormat val = asType(node, org.apache.camel.model.dataformat.CustomDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "fhir-json": {
                    org.apache.camel.model.dataformat.FhirJsonDataFormat val = asType(node, org.apache.camel.model.dataformat.FhirJsonDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "fhir-xml": {
                    org.apache.camel.model.dataformat.FhirXmlDataFormat val = asType(node, org.apache.camel.model.dataformat.FhirXmlDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "flatpack": {
                    org.apache.camel.model.dataformat.FlatpackDataFormat val = asType(node, org.apache.camel.model.dataformat.FlatpackDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "grok": {
                    org.apache.camel.model.dataformat.GrokDataFormat val = asType(node, org.apache.camel.model.dataformat.GrokDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "gzip": {
                    org.apache.camel.model.dataformat.GzipDataFormat val = asType(node, org.apache.camel.model.dataformat.GzipDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "hl7": {
                    org.apache.camel.model.dataformat.HL7DataFormat val = asType(node, org.apache.camel.model.dataformat.HL7DataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "ical": {
                    org.apache.camel.model.dataformat.IcalDataFormat val = asType(node, org.apache.camel.model.dataformat.IcalDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "jacksonxml": {
                    org.apache.camel.model.dataformat.JacksonXMLDataFormat val = asType(node, org.apache.camel.model.dataformat.JacksonXMLDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "jaxb": {
                    org.apache.camel.model.dataformat.JaxbDataFormat val = asType(node, org.apache.camel.model.dataformat.JaxbDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "json": {
                    org.apache.camel.model.dataformat.JsonDataFormat val = asType(node, org.apache.camel.model.dataformat.JsonDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "json-api": {
                    org.apache.camel.model.dataformat.JsonApiDataFormat val = asType(node, org.apache.camel.model.dataformat.JsonApiDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "lzf": {
                    org.apache.camel.model.dataformat.LZFDataFormat val = asType(node, org.apache.camel.model.dataformat.LZFDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "mime-multipart": {
                    org.apache.camel.model.dataformat.MimeMultipartDataFormat val = asType(node, org.apache.camel.model.dataformat.MimeMultipartDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "protobuf": {
                    org.apache.camel.model.dataformat.ProtobufDataFormat val = asType(node, org.apache.camel.model.dataformat.ProtobufDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "rss": {
                    org.apache.camel.model.dataformat.RssDataFormat val = asType(node, org.apache.camel.model.dataformat.RssDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "secure-xml": {
                    org.apache.camel.model.dataformat.XMLSecurityDataFormat val = asType(node, org.apache.camel.model.dataformat.XMLSecurityDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "soapjaxb": {
                    org.apache.camel.model.dataformat.SoapJaxbDataFormat val = asType(node, org.apache.camel.model.dataformat.SoapJaxbDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "syslog": {
                    org.apache.camel.model.dataformat.SyslogDataFormat val = asType(node, org.apache.camel.model.dataformat.SyslogDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "tarfile": {
                    org.apache.camel.model.dataformat.TarFileDataFormat val = asType(node, org.apache.camel.model.dataformat.TarFileDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "thrift": {
                    org.apache.camel.model.dataformat.ThriftDataFormat val = asType(node, org.apache.camel.model.dataformat.ThriftDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "tidy-markup": {
                    org.apache.camel.model.dataformat.TidyMarkupDataFormat val = asType(node, org.apache.camel.model.dataformat.TidyMarkupDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "univocity-csv": {
                    org.apache.camel.model.dataformat.UniVocityCsvDataFormat val = asType(node, org.apache.camel.model.dataformat.UniVocityCsvDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "univocity-fixed": {
                    org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat val = asType(node, org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "univocity-tsv": {
                    org.apache.camel.model.dataformat.UniVocityTsvDataFormat val = asType(node, org.apache.camel.model.dataformat.UniVocityTsvDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "xmlrpc": {
                    org.apache.camel.model.dataformat.XmlRpcDataFormat val = asType(node, org.apache.camel.model.dataformat.XmlRpcDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "xstream": {
                    org.apache.camel.model.dataformat.XStreamDataFormat val = asType(node, org.apache.camel.model.dataformat.XStreamDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "pgp": {
                    org.apache.camel.model.dataformat.PGPDataFormat val = asType(node, org.apache.camel.model.dataformat.PGPDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "yaml": {
                    org.apache.camel.model.dataformat.YAMLDataFormat val = asType(node, org.apache.camel.model.dataformat.YAMLDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "zip": {
                    org.apache.camel.model.dataformat.ZipDeflaterDataFormat val = asType(node, org.apache.camel.model.dataformat.ZipDeflaterDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                case "zipfile": {
                    org.apache.camel.model.dataformat.ZipFileDataFormat val = asType(node, org.apache.camel.model.dataformat.ZipFileDataFormat.class);
                    java.util.List<org.apache.camel.model.DataFormatDefinition> existing = target.getDataFormats();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setDataFormats(existing);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.DatasonnetExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "datasonnet",
            properties = {
                    @YamlProperty(name = "body-media-type", type = "string"),
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "output-media-type", type = "string"),
                    @YamlProperty(name = "result-type", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class DatasonnetExpressionDeserializer extends YamlDeserializerBase<DatasonnetExpression> {
        public DatasonnetExpressionDeserializer() {
            super(DatasonnetExpression.class);
        }

        @Override
        protected DatasonnetExpression newInstance() {
            return new DatasonnetExpression();
        }

        @Override
        protected DatasonnetExpression newInstance(String value) {
            return new DatasonnetExpression(value);
        }

        @Override
        protected boolean setProperty(DatasonnetExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "body-media-type": {
                    String val = asText(node);
                    target.setBodyMediaType(val);
                    break;
                }
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "output-media-type": {
                    String val = asText(node);
                    target.setOutputMediaType(val);
                    break;
                }
                case "result-type": {
                    String val = asText(node);
                    target.setResultTypeName(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.DefaultServiceCallServiceLoadBalancerConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "default-load-balancer",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition")
            }
    )
    public static class DefaultServiceCallServiceLoadBalancerConfigurationDeserializer extends YamlDeserializerBase<DefaultServiceCallServiceLoadBalancerConfiguration> {
        public DefaultServiceCallServiceLoadBalancerConfigurationDeserializer() {
            super(DefaultServiceCallServiceLoadBalancerConfiguration.class);
        }

        @Override
        protected DefaultServiceCallServiceLoadBalancerConfiguration newInstance() {
            return new DefaultServiceCallServiceLoadBalancerConfiguration();
        }

        @Override
        protected boolean setProperty(DefaultServiceCallServiceLoadBalancerConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.DelayDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "delay",
            properties = {
                    @YamlProperty(name = "async-delayed", type = "boolean"),
                    @YamlProperty(name = "caller-runs-when-rejected", type = "boolean"),
                    @YamlProperty(name = "executor-service-ref", type = "string"),
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class DelayDefinitionDeserializer extends YamlDeserializerBase<DelayDefinition> {
        public DelayDefinitionDeserializer() {
            super(DelayDefinition.class);
        }

        @Override
        protected DelayDefinition newInstance() {
            return new DelayDefinition();
        }

        @Override
        protected boolean setProperty(DelayDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "async-delayed": {
                    String val = asText(node);
                    target.setAsyncDelayed(val);
                    break;
                }
                case "caller-runs-when-rejected": {
                    String val = asText(node);
                    target.setCallerRunsWhenRejected(val);
                    break;
                }
                case "executor-service-ref": {
                    String val = asText(node);
                    target.setExecutorServiceRef(val);
                    break;
                }
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.DeleteVerbDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "delete",
            properties = {
                    @YamlProperty(name = "api-docs", type = "string"),
                    @YamlProperty(name = "binding-mode", type = "string"),
                    @YamlProperty(name = "client-request-validation", type = "string"),
                    @YamlProperty(name = "consumes", type = "string"),
                    @YamlProperty(name = "enable-cors", type = "string"),
                    @YamlProperty(name = "method", type = "string"),
                    @YamlProperty(name = "out-type", type = "string"),
                    @YamlProperty(name = "params", type = "array:org.apache.camel.model.rest.RestOperationParamDefinition"),
                    @YamlProperty(name = "produces", type = "string"),
                    @YamlProperty(name = "response-msgs", type = "array:org.apache.camel.model.rest.RestOperationResponseMsgDefinition"),
                    @YamlProperty(name = "route-id", type = "string"),
                    @YamlProperty(name = "security", type = "array:org.apache.camel.model.rest.SecurityDefinition"),
                    @YamlProperty(name = "skip-binding-on-error-code", type = "string"),
                    @YamlProperty(name = "to", type = "object:org.apache.camel.model.ToDefinition"),
                    @YamlProperty(name = "to-d", type = "object:org.apache.camel.model.ToDynamicDefinition"),
                    @YamlProperty(name = "route", type = "object:org.apache.camel.model.RouteDefinition"),
                    @YamlProperty(name = "type", type = "string"),
                    @YamlProperty(name = "uri", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class DeleteVerbDefinitionDeserializer extends YamlDeserializerBase<DeleteVerbDefinition> {
        public DeleteVerbDefinitionDeserializer() {
            super(DeleteVerbDefinition.class);
        }

        @Override
        protected DeleteVerbDefinition newInstance() {
            return new DeleteVerbDefinition();
        }

        @Override
        protected boolean setProperty(DeleteVerbDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "api-docs": {
                    String val = asText(node);
                    target.setApiDocs(val);
                    break;
                }
                case "binding-mode": {
                    String val = asText(node);
                    target.setBindingMode(val);
                    break;
                }
                case "client-request-validation": {
                    String val = asText(node);
                    target.setClientRequestValidation(val);
                    break;
                }
                case "consumes": {
                    String val = asText(node);
                    target.setConsumes(val);
                    break;
                }
                case "enable-cors": {
                    String val = asText(node);
                    target.setEnableCORS(val);
                    break;
                }
                case "method": {
                    String val = asText(node);
                    target.setMethod(val);
                    break;
                }
                case "out-type": {
                    String val = asText(node);
                    target.setOutType(val);
                    break;
                }
                case "param": {
                    java.util.List<org.apache.camel.model.rest.RestOperationParamDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationParamDefinition.class);
                    target.setParams(val);
                    break;
                }
                case "produces": {
                    String val = asText(node);
                    target.setProduces(val);
                    break;
                }
                case "response-message": {
                    java.util.List<org.apache.camel.model.rest.RestOperationResponseMsgDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationResponseMsgDefinition.class);
                    target.setResponseMsgs(val);
                    break;
                }
                case "route-id": {
                    String val = asText(node);
                    target.setRouteId(val);
                    break;
                }
                case "security": {
                    java.util.List<org.apache.camel.model.rest.SecurityDefinition> val = asFlatList(node, org.apache.camel.model.rest.SecurityDefinition.class);
                    target.setSecurity(val);
                    break;
                }
                case "skip-binding-on-error-code": {
                    String val = asText(node);
                    target.setSkipBindingOnErrorCode(val);
                    break;
                }
                case "to-or-route": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "to": {
                    org.apache.camel.model.ToDefinition val = asType(node, org.apache.camel.model.ToDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "to-d": {
                    org.apache.camel.model.ToDynamicDefinition val = asType(node, org.apache.camel.model.ToDynamicDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "route": {
                    org.apache.camel.model.RouteDefinition val = asType(node, org.apache.camel.model.RouteDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.DescriptionDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "description",
            properties = {
                    @YamlProperty(name = "lang", type = "string"),
                    @YamlProperty(name = "text", type = "string")
            }
    )
    public static class DescriptionDefinitionDeserializer extends YamlDeserializerBase<DescriptionDefinition> {
        public DescriptionDefinitionDeserializer() {
            super(DescriptionDefinition.class);
        }

        @Override
        protected DescriptionDefinition newInstance() {
            return new DescriptionDefinition();
        }

        @Override
        protected boolean setProperty(DescriptionDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "lang": {
                    String val = asText(node);
                    target.setLang(val);
                    break;
                }
                case "text": {
                    String val = asText(node);
                    target.setText(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "dns-service-discovery",
            properties = {
                    @YamlProperty(name = "domain", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "proto", type = "string")
            }
    )
    public static class DnsServiceCallServiceDiscoveryConfigurationDeserializer extends YamlDeserializerBase<DnsServiceCallServiceDiscoveryConfiguration> {
        public DnsServiceCallServiceDiscoveryConfigurationDeserializer() {
            super(DnsServiceCallServiceDiscoveryConfiguration.class);
        }

        @Override
        protected DnsServiceCallServiceDiscoveryConfiguration newInstance() {
            return new DnsServiceCallServiceDiscoveryConfiguration();
        }

        @Override
        protected boolean setProperty(DnsServiceCallServiceDiscoveryConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "domain": {
                    String val = asText(node);
                    target.setDomain(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                case "proto": {
                    String val = asText(node);
                    target.setProto(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.DynamicRouterDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "dynamic-router",
            properties = {
                    @YamlProperty(name = "cache-size", type = "number"),
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "ignore-invalid-endpoints", type = "string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "uri-delimiter", type = "string"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class DynamicRouterDefinitionDeserializer extends YamlDeserializerBase<DynamicRouterDefinition> {
        public DynamicRouterDefinitionDeserializer() {
            super(DynamicRouterDefinition.class);
        }

        @Override
        protected DynamicRouterDefinition newInstance() {
            return new DynamicRouterDefinition();
        }

        @Override
        protected boolean setProperty(DynamicRouterDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "cache-size": {
                    String val = asText(node);
                    target.setCacheSize(val);
                    break;
                }
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "ignore-invalid-endpoints": {
                    String val = asText(node);
                    target.setIgnoreInvalidEndpoints(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "uri-delimiter": {
                    String val = asText(node);
                    target.setUriDelimiter(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.transformer.EndpointTransformerDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            properties = {
                    @YamlProperty(name = "from-type", type = "string"),
                    @YamlProperty(name = "ref", type = "string"),
                    @YamlProperty(name = "scheme", type = "string"),
                    @YamlProperty(name = "to-type", type = "string"),
                    @YamlProperty(name = "uri", type = "string")
            }
    )
    public static class EndpointTransformerDefinitionDeserializer extends YamlDeserializerBase<EndpointTransformerDefinition> {
        public EndpointTransformerDefinitionDeserializer() {
            super(EndpointTransformerDefinition.class);
        }

        @Override
        protected EndpointTransformerDefinition newInstance() {
            return new EndpointTransformerDefinition();
        }

        @Override
        protected boolean setProperty(EndpointTransformerDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "from-type": {
                    String val = asText(node);
                    target.setFromType(val);
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                case "scheme": {
                    String val = asText(node);
                    target.setScheme(val);
                    break;
                }
                case "to-type": {
                    String val = asText(node);
                    target.setToType(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.validator.EndpointValidatorDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            properties = {
                    @YamlProperty(name = "ref", type = "string"),
                    @YamlProperty(name = "type", type = "string"),
                    @YamlProperty(name = "uri", type = "string")
            }
    )
    public static class EndpointValidatorDefinitionDeserializer extends YamlDeserializerBase<EndpointValidatorDefinition> {
        public EndpointValidatorDefinitionDeserializer() {
            super(EndpointValidatorDefinition.class);
        }

        @Override
        protected EndpointValidatorDefinition newInstance() {
            return new EndpointValidatorDefinition();
        }

        @Override
        protected boolean setProperty(EndpointValidatorDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.EnrichDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "enrich",
            properties = {
                    @YamlProperty(name = "aggregate-on-exception", type = "boolean"),
                    @YamlProperty(name = "strategy-method-allow-null", type = "string"),
                    @YamlProperty(name = "strategy-method-name", type = "string"),
                    @YamlProperty(name = "strategy-ref", type = "string"),
                    @YamlProperty(name = "cache-size", type = "number"),
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "ignore-invalid-endpoint", type = "boolean"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "share-unit-of-work", type = "boolean"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class EnrichDefinitionDeserializer extends YamlDeserializerBase<EnrichDefinition> {
        public EnrichDefinitionDeserializer() {
            super(EnrichDefinition.class);
        }

        @Override
        protected EnrichDefinition newInstance() {
            return new EnrichDefinition();
        }

        @Override
        protected boolean setProperty(EnrichDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "aggregate-on-exception": {
                    String val = asText(node);
                    target.setAggregateOnException(val);
                    break;
                }
                case "strategy-method-allow-null": {
                    String val = asText(node);
                    target.setAggregationStrategyMethodAllowNull(val);
                    break;
                }
                case "strategy-method-name": {
                    String val = asText(node);
                    target.setAggregationStrategyMethodName(val);
                    break;
                }
                case "strategy-ref": {
                    String val = asText(node);
                    target.setAggregationStrategyRef(val);
                    break;
                }
                case "cache-size": {
                    String val = asText(node);
                    target.setCacheSize(val);
                    break;
                }
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "ignore-invalid-endpoint": {
                    String val = asText(node);
                    target.setIgnoreInvalidEndpoint(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "share-unit-of-work": {
                    String val = asText(node);
                    target.setShareUnitOfWork(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "etcd-service-discovery",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "password", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "service-path", type = "string"),
                    @YamlProperty(name = "timeout", type = "number"),
                    @YamlProperty(name = "type", type = "string"),
                    @YamlProperty(name = "uris", type = "string"),
                    @YamlProperty(name = "user-name", type = "string")
            }
    )
    public static class EtcdServiceCallServiceDiscoveryConfigurationDeserializer extends YamlDeserializerBase<EtcdServiceCallServiceDiscoveryConfiguration> {
        public EtcdServiceCallServiceDiscoveryConfigurationDeserializer() {
            super(EtcdServiceCallServiceDiscoveryConfiguration.class);
        }

        @Override
        protected EtcdServiceCallServiceDiscoveryConfiguration newInstance() {
            return new EtcdServiceCallServiceDiscoveryConfiguration();
        }

        @Override
        protected boolean setProperty(EtcdServiceCallServiceDiscoveryConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "password": {
                    String val = asText(node);
                    target.setPassword(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                case "service-path": {
                    String val = asText(node);
                    target.setServicePath(val);
                    break;
                }
                case "timeout": {
                    String val = asText(node);
                    target.setTimeout(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                case "uris": {
                    String val = asText(node);
                    target.setUris(val);
                    break;
                }
                case "user-name": {
                    String val = asText(node);
                    target.setUserName(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.ExchangePropertyExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "exchange-property",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class ExchangePropertyExpressionDeserializer extends YamlDeserializerBase<ExchangePropertyExpression> {
        public ExchangePropertyExpressionDeserializer() {
            super(ExchangePropertyExpression.class);
        }

        @Override
        protected ExchangePropertyExpression newInstance() {
            return new ExchangePropertyExpression();
        }

        @Override
        protected ExchangePropertyExpression newInstance(String value) {
            return new ExchangePropertyExpression(value);
        }

        @Override
        protected boolean setProperty(ExchangePropertyExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.loadbalancer.FailoverLoadBalancerDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "failover",
            properties = {
                    @YamlProperty(name = "exception", type = "array:string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "maximum-failover-attempts", type = "string"),
                    @YamlProperty(name = "round-robin", type = "string"),
                    @YamlProperty(name = "sticky", type = "string")
            }
    )
    public static class FailoverLoadBalancerDefinitionDeserializer extends YamlDeserializerBase<FailoverLoadBalancerDefinition> {
        public FailoverLoadBalancerDefinitionDeserializer() {
            super(FailoverLoadBalancerDefinition.class);
        }

        @Override
        protected FailoverLoadBalancerDefinition newInstance() {
            return new FailoverLoadBalancerDefinition();
        }

        @Override
        protected boolean setProperty(FailoverLoadBalancerDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "exception": {
                    java.util.List<String> val = asStringList(node);
                    target.setExceptions(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "maximum-failover-attempts": {
                    String val = asText(node);
                    target.setMaximumFailoverAttempts(val);
                    break;
                }
                case "round-robin": {
                    String val = asText(node);
                    target.setRoundRobin(val);
                    break;
                }
                case "sticky": {
                    String val = asText(node);
                    target.setSticky(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.FaultToleranceConfigurationDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "fault-tolerance-configuration",
            properties = {
                    @YamlProperty(name = "bulkhead-enabled", type = "boolean"),
                    @YamlProperty(name = "bulkhead-executor-service-ref", type = "string"),
                    @YamlProperty(name = "bulkhead-max-concurrent-calls", type = "number"),
                    @YamlProperty(name = "bulkhead-waiting-task-queue", type = "number"),
                    @YamlProperty(name = "circuit-breaker-ref", type = "string"),
                    @YamlProperty(name = "delay", type = "string"),
                    @YamlProperty(name = "failure-ratio", type = "number"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "request-volume-threshold", type = "number"),
                    @YamlProperty(name = "success-threshold", type = "number"),
                    @YamlProperty(name = "timeout-duration", type = "string"),
                    @YamlProperty(name = "timeout-enabled", type = "boolean"),
                    @YamlProperty(name = "timeout-pool-size", type = "number"),
                    @YamlProperty(name = "timeout-scheduled-executor-service-ref", type = "string")
            }
    )
    public static class FaultToleranceConfigurationDefinitionDeserializer extends YamlDeserializerBase<FaultToleranceConfigurationDefinition> {
        public FaultToleranceConfigurationDefinitionDeserializer() {
            super(FaultToleranceConfigurationDefinition.class);
        }

        @Override
        protected FaultToleranceConfigurationDefinition newInstance() {
            return new FaultToleranceConfigurationDefinition();
        }

        @Override
        protected boolean setProperty(FaultToleranceConfigurationDefinition target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "bulkhead-enabled": {
                    String val = asText(node);
                    target.setBulkheadEnabled(val);
                    break;
                }
                case "bulkhead-executor-service-ref": {
                    String val = asText(node);
                    target.setBulkheadExecutorServiceRef(val);
                    break;
                }
                case "bulkhead-max-concurrent-calls": {
                    String val = asText(node);
                    target.setBulkheadMaxConcurrentCalls(val);
                    break;
                }
                case "bulkhead-waiting-task-queue": {
                    String val = asText(node);
                    target.setBulkheadWaitingTaskQueue(val);
                    break;
                }
                case "circuit-breaker-ref": {
                    String val = asText(node);
                    target.setCircuitBreakerRef(val);
                    break;
                }
                case "delay": {
                    String val = asText(node);
                    target.setDelay(val);
                    break;
                }
                case "failure-ratio": {
                    String val = asText(node);
                    target.setFailureRatio(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "request-volume-threshold": {
                    String val = asText(node);
                    target.setRequestVolumeThreshold(val);
                    break;
                }
                case "success-threshold": {
                    String val = asText(node);
                    target.setSuccessThreshold(val);
                    break;
                }
                case "timeout-duration": {
                    String val = asText(node);
                    target.setTimeoutDuration(val);
                    break;
                }
                case "timeout-enabled": {
                    String val = asText(node);
                    target.setTimeoutEnabled(val);
                    break;
                }
                case "timeout-pool-size": {
                    String val = asText(node);
                    target.setTimeoutPoolSize(val);
                    break;
                }
                case "timeout-scheduled-executor-service-ref": {
                    String val = asText(node);
                    target.setTimeoutScheduledExecutorServiceRef(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.FhirJsonDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "fhir-json",
            properties = {
                    @YamlProperty(name = "content-type-header", type = "boolean"),
                    @YamlProperty(name = "dont-encode-elements", type = "array:string"),
                    @YamlProperty(name = "dont-strip-versions-from-references-at-paths", type = "array:string"),
                    @YamlProperty(name = "encode-elements", type = "array:string"),
                    @YamlProperty(name = "encode-elements-applies-to-child-resources-only", type = "boolean"),
                    @YamlProperty(name = "fhir-version", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "omit-resource-id", type = "boolean"),
                    @YamlProperty(name = "override-resource-id-with-bundle-entry-full-url", type = "boolean"),
                    @YamlProperty(name = "pretty-print", type = "boolean"),
                    @YamlProperty(name = "server-base-url", type = "string"),
                    @YamlProperty(name = "strip-versions-from-references", type = "boolean"),
                    @YamlProperty(name = "summary-mode", type = "boolean"),
                    @YamlProperty(name = "suppress-narratives", type = "boolean")
            }
    )
    public static class FhirJsonDataFormatDeserializer extends YamlDeserializerBase<FhirJsonDataFormat> {
        public FhirJsonDataFormatDeserializer() {
            super(FhirJsonDataFormat.class);
        }

        @Override
        protected FhirJsonDataFormat newInstance() {
            return new FhirJsonDataFormat();
        }

        @Override
        protected boolean setProperty(FhirJsonDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "content-type-header": {
                    String val = asText(node);
                    target.setContentTypeHeader(val);
                    break;
                }
                case "dont-encode-elements": {
                    java.util.Set<String> val = asStringSet(node);
                    target.setDontEncodeElements(val);
                    break;
                }
                case "dont-strip-versions-from-references-at-paths": {
                    java.util.List<String> val = asStringList(node);
                    target.setDontStripVersionsFromReferencesAtPaths(val);
                    break;
                }
                case "encode-elements": {
                    java.util.Set<String> val = asStringSet(node);
                    target.setEncodeElements(val);
                    break;
                }
                case "encode-elements-applies-to-child-resources-only": {
                    String val = asText(node);
                    target.setEncodeElementsAppliesToChildResourcesOnly(val);
                    break;
                }
                case "fhir-version": {
                    String val = asText(node);
                    target.setFhirVersion(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "omit-resource-id": {
                    String val = asText(node);
                    target.setOmitResourceId(val);
                    break;
                }
                case "override-resource-id-with-bundle-entry-full-url": {
                    String val = asText(node);
                    target.setOverrideResourceIdWithBundleEntryFullUrl(val);
                    break;
                }
                case "pretty-print": {
                    String val = asText(node);
                    target.setPrettyPrint(val);
                    break;
                }
                case "server-base-url": {
                    String val = asText(node);
                    target.setServerBaseUrl(val);
                    break;
                }
                case "strip-versions-from-references": {
                    String val = asText(node);
                    target.setStripVersionsFromReferences(val);
                    break;
                }
                case "summary-mode": {
                    String val = asText(node);
                    target.setSummaryMode(val);
                    break;
                }
                case "suppress-narratives": {
                    String val = asText(node);
                    target.setSuppressNarratives(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.FhirXmlDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "fhir-xml",
            properties = {
                    @YamlProperty(name = "content-type-header", type = "boolean"),
                    @YamlProperty(name = "dont-encode-elements", type = "array:string"),
                    @YamlProperty(name = "dont-strip-versions-from-references-at-paths", type = "array:string"),
                    @YamlProperty(name = "encode-elements", type = "array:string"),
                    @YamlProperty(name = "encode-elements-applies-to-child-resources-only", type = "boolean"),
                    @YamlProperty(name = "fhir-version", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "omit-resource-id", type = "boolean"),
                    @YamlProperty(name = "override-resource-id-with-bundle-entry-full-url", type = "boolean"),
                    @YamlProperty(name = "pretty-print", type = "boolean"),
                    @YamlProperty(name = "server-base-url", type = "string"),
                    @YamlProperty(name = "strip-versions-from-references", type = "boolean"),
                    @YamlProperty(name = "summary-mode", type = "boolean"),
                    @YamlProperty(name = "suppress-narratives", type = "boolean")
            }
    )
    public static class FhirXmlDataFormatDeserializer extends YamlDeserializerBase<FhirXmlDataFormat> {
        public FhirXmlDataFormatDeserializer() {
            super(FhirXmlDataFormat.class);
        }

        @Override
        protected FhirXmlDataFormat newInstance() {
            return new FhirXmlDataFormat();
        }

        @Override
        protected boolean setProperty(FhirXmlDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "content-type-header": {
                    String val = asText(node);
                    target.setContentTypeHeader(val);
                    break;
                }
                case "dont-encode-elements": {
                    java.util.Set<String> val = asStringSet(node);
                    target.setDontEncodeElements(val);
                    break;
                }
                case "dont-strip-versions-from-references-at-paths": {
                    java.util.List<String> val = asStringList(node);
                    target.setDontStripVersionsFromReferencesAtPaths(val);
                    break;
                }
                case "encode-elements": {
                    java.util.Set<String> val = asStringSet(node);
                    target.setEncodeElements(val);
                    break;
                }
                case "encode-elements-applies-to-child-resources-only": {
                    String val = asText(node);
                    target.setEncodeElementsAppliesToChildResourcesOnly(val);
                    break;
                }
                case "fhir-version": {
                    String val = asText(node);
                    target.setFhirVersion(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "omit-resource-id": {
                    String val = asText(node);
                    target.setOmitResourceId(val);
                    break;
                }
                case "override-resource-id-with-bundle-entry-full-url": {
                    String val = asText(node);
                    target.setOverrideResourceIdWithBundleEntryFullUrl(val);
                    break;
                }
                case "pretty-print": {
                    String val = asText(node);
                    target.setPrettyPrint(val);
                    break;
                }
                case "server-base-url": {
                    String val = asText(node);
                    target.setServerBaseUrl(val);
                    break;
                }
                case "strip-versions-from-references": {
                    String val = asText(node);
                    target.setStripVersionsFromReferences(val);
                    break;
                }
                case "summary-mode": {
                    String val = asText(node);
                    target.setSummaryMode(val);
                    break;
                }
                case "suppress-narratives": {
                    String val = asText(node);
                    target.setSuppressNarratives(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.FilterDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "filter",
            properties = {
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class FilterDefinitionDeserializer extends YamlDeserializerBase<FilterDefinition> {
        public FilterDefinitionDeserializer() {
            super(FilterDefinition.class);
        }

        @Override
        protected FilterDefinition newInstance() {
            return new FilterDefinition();
        }

        @Override
        protected boolean setProperty(FilterDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.FinallyDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "do-finally",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class FinallyDefinitionDeserializer extends YamlDeserializerBase<FinallyDefinition> {
        public FinallyDefinitionDeserializer() {
            super(FinallyDefinition.class);
        }

        @Override
        protected FinallyDefinition newInstance() {
            return new FinallyDefinition();
        }

        @Override
        protected boolean setProperty(FinallyDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.FlatpackDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "flatpack",
            properties = {
                    @YamlProperty(name = "allow-short-lines", type = "boolean"),
                    @YamlProperty(name = "definition", type = "string"),
                    @YamlProperty(name = "delimiter", type = "string"),
                    @YamlProperty(name = "fixed", type = "boolean"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "ignore-extra-columns", type = "boolean"),
                    @YamlProperty(name = "ignore-first-record", type = "boolean"),
                    @YamlProperty(name = "parser-factory-ref", type = "string"),
                    @YamlProperty(name = "text-qualifier", type = "string")
            }
    )
    public static class FlatpackDataFormatDeserializer extends YamlDeserializerBase<FlatpackDataFormat> {
        public FlatpackDataFormatDeserializer() {
            super(FlatpackDataFormat.class);
        }

        @Override
        protected FlatpackDataFormat newInstance() {
            return new FlatpackDataFormat();
        }

        @Override
        protected boolean setProperty(FlatpackDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-short-lines": {
                    String val = asText(node);
                    target.setAllowShortLines(val);
                    break;
                }
                case "definition": {
                    String val = asText(node);
                    target.setDefinition(val);
                    break;
                }
                case "delimiter": {
                    String val = asText(node);
                    target.setDelimiter(val);
                    break;
                }
                case "fixed": {
                    String val = asText(node);
                    target.setFixed(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "ignore-extra-columns": {
                    String val = asText(node);
                    target.setIgnoreExtraColumns(val);
                    break;
                }
                case "ignore-first-record": {
                    String val = asText(node);
                    target.setIgnoreFirstRecord(val);
                    break;
                }
                case "parser-factory-ref": {
                    String val = asText(node);
                    target.setParserFactoryRef(val);
                    break;
                }
                case "text-qualifier": {
                    String val = asText(node);
                    target.setTextQualifier(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.GetVerbDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "get",
            properties = {
                    @YamlProperty(name = "api-docs", type = "string"),
                    @YamlProperty(name = "binding-mode", type = "string"),
                    @YamlProperty(name = "client-request-validation", type = "string"),
                    @YamlProperty(name = "consumes", type = "string"),
                    @YamlProperty(name = "enable-cors", type = "string"),
                    @YamlProperty(name = "method", type = "string"),
                    @YamlProperty(name = "out-type", type = "string"),
                    @YamlProperty(name = "params", type = "array:org.apache.camel.model.rest.RestOperationParamDefinition"),
                    @YamlProperty(name = "produces", type = "string"),
                    @YamlProperty(name = "response-msgs", type = "array:org.apache.camel.model.rest.RestOperationResponseMsgDefinition"),
                    @YamlProperty(name = "route-id", type = "string"),
                    @YamlProperty(name = "security", type = "array:org.apache.camel.model.rest.SecurityDefinition"),
                    @YamlProperty(name = "skip-binding-on-error-code", type = "string"),
                    @YamlProperty(name = "to", type = "object:org.apache.camel.model.ToDefinition"),
                    @YamlProperty(name = "to-d", type = "object:org.apache.camel.model.ToDynamicDefinition"),
                    @YamlProperty(name = "route", type = "object:org.apache.camel.model.RouteDefinition"),
                    @YamlProperty(name = "type", type = "string"),
                    @YamlProperty(name = "uri", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class GetVerbDefinitionDeserializer extends YamlDeserializerBase<GetVerbDefinition> {
        public GetVerbDefinitionDeserializer() {
            super(GetVerbDefinition.class);
        }

        @Override
        protected GetVerbDefinition newInstance() {
            return new GetVerbDefinition();
        }

        @Override
        protected boolean setProperty(GetVerbDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "api-docs": {
                    String val = asText(node);
                    target.setApiDocs(val);
                    break;
                }
                case "binding-mode": {
                    String val = asText(node);
                    target.setBindingMode(val);
                    break;
                }
                case "client-request-validation": {
                    String val = asText(node);
                    target.setClientRequestValidation(val);
                    break;
                }
                case "consumes": {
                    String val = asText(node);
                    target.setConsumes(val);
                    break;
                }
                case "enable-cors": {
                    String val = asText(node);
                    target.setEnableCORS(val);
                    break;
                }
                case "method": {
                    String val = asText(node);
                    target.setMethod(val);
                    break;
                }
                case "out-type": {
                    String val = asText(node);
                    target.setOutType(val);
                    break;
                }
                case "param": {
                    java.util.List<org.apache.camel.model.rest.RestOperationParamDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationParamDefinition.class);
                    target.setParams(val);
                    break;
                }
                case "produces": {
                    String val = asText(node);
                    target.setProduces(val);
                    break;
                }
                case "response-message": {
                    java.util.List<org.apache.camel.model.rest.RestOperationResponseMsgDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationResponseMsgDefinition.class);
                    target.setResponseMsgs(val);
                    break;
                }
                case "route-id": {
                    String val = asText(node);
                    target.setRouteId(val);
                    break;
                }
                case "security": {
                    java.util.List<org.apache.camel.model.rest.SecurityDefinition> val = asFlatList(node, org.apache.camel.model.rest.SecurityDefinition.class);
                    target.setSecurity(val);
                    break;
                }
                case "skip-binding-on-error-code": {
                    String val = asText(node);
                    target.setSkipBindingOnErrorCode(val);
                    break;
                }
                case "to-or-route": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "to": {
                    org.apache.camel.model.ToDefinition val = asType(node, org.apache.camel.model.ToDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "to-d": {
                    org.apache.camel.model.ToDynamicDefinition val = asType(node, org.apache.camel.model.ToDynamicDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "route": {
                    org.apache.camel.model.RouteDefinition val = asType(node, org.apache.camel.model.RouteDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.GlobalOptionDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "global-option",
            properties = {
                    @YamlProperty(name = "key", type = "string"),
                    @YamlProperty(name = "value", type = "string")
            }
    )
    public static class GlobalOptionDefinitionDeserializer extends YamlDeserializerBase<GlobalOptionDefinition> {
        public GlobalOptionDefinitionDeserializer() {
            super(GlobalOptionDefinition.class);
        }

        @Override
        protected GlobalOptionDefinition newInstance() {
            return new GlobalOptionDefinition();
        }

        @Override
        protected boolean setProperty(GlobalOptionDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "key": {
                    String val = asText(node);
                    target.setKey(val);
                    break;
                }
                case "value": {
                    String val = asText(node);
                    target.setValue(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.GlobalOptionsDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "global-options",
            properties = @YamlProperty(name = "global-option", type = "array:org.apache.camel.model.GlobalOptionDefinition")
    )
    public static class GlobalOptionsDefinitionDeserializer extends YamlDeserializerBase<GlobalOptionsDefinition> {
        public GlobalOptionsDefinitionDeserializer() {
            super(GlobalOptionsDefinition.class);
        }

        @Override
        protected GlobalOptionsDefinition newInstance() {
            return new GlobalOptionsDefinition();
        }

        @Override
        protected boolean setProperty(GlobalOptionsDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "global-option": {
                    java.util.List<org.apache.camel.model.GlobalOptionDefinition> val = asFlatList(node, org.apache.camel.model.GlobalOptionDefinition.class);
                    target.setGlobalOptions(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.GrokDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "grok",
            properties = {
                    @YamlProperty(name = "allow-multiple-matches-per-line", type = "boolean"),
                    @YamlProperty(name = "flattened", type = "boolean"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "named-only", type = "boolean"),
                    @YamlProperty(name = "pattern", type = "string")
            }
    )
    public static class GrokDataFormatDeserializer extends YamlDeserializerBase<GrokDataFormat> {
        public GrokDataFormatDeserializer() {
            super(GrokDataFormat.class);
        }

        @Override
        protected GrokDataFormat newInstance() {
            return new GrokDataFormat();
        }

        @Override
        protected boolean setProperty(GrokDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-multiple-matches-per-line": {
                    String val = asText(node);
                    target.setAllowMultipleMatchesPerLine(val);
                    break;
                }
                case "flattened": {
                    String val = asText(node);
                    target.setFlattened(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "named-only": {
                    String val = asText(node);
                    target.setNamedOnly(val);
                    break;
                }
                case "pattern": {
                    String val = asText(node);
                    target.setPattern(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.GroovyExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "groovy",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class GroovyExpressionDeserializer extends YamlDeserializerBase<GroovyExpression> {
        public GroovyExpressionDeserializer() {
            super(GroovyExpression.class);
        }

        @Override
        protected GroovyExpression newInstance() {
            return new GroovyExpression();
        }

        @Override
        protected GroovyExpression newInstance(String value) {
            return new GroovyExpression(value);
        }

        @Override
        protected boolean setProperty(GroovyExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.GzipDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "gzipdeflater",
            properties = @YamlProperty(name = "id", type = "string")
    )
    public static class GzipDataFormatDeserializer extends YamlDeserializerBase<GzipDataFormat> {
        public GzipDataFormatDeserializer() {
            super(GzipDataFormat.class);
        }

        @Override
        protected GzipDataFormat newInstance() {
            return new GzipDataFormat();
        }

        @Override
        protected boolean setProperty(GzipDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.HL7DataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "hl7",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "validate", type = "boolean")
            }
    )
    public static class HL7DataFormatDeserializer extends YamlDeserializerBase<HL7DataFormat> {
        public HL7DataFormatDeserializer() {
            super(HL7DataFormat.class);
        }

        @Override
        protected HL7DataFormat newInstance() {
            return new HL7DataFormat();
        }

        @Override
        protected boolean setProperty(HL7DataFormat target, String propertyKey, String propertyName,
                Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "validate": {
                    String val = asText(node);
                    target.setValidate(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.HeadVerbDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "head",
            properties = {
                    @YamlProperty(name = "api-docs", type = "string"),
                    @YamlProperty(name = "binding-mode", type = "string"),
                    @YamlProperty(name = "client-request-validation", type = "string"),
                    @YamlProperty(name = "consumes", type = "string"),
                    @YamlProperty(name = "enable-cors", type = "string"),
                    @YamlProperty(name = "method", type = "string"),
                    @YamlProperty(name = "out-type", type = "string"),
                    @YamlProperty(name = "params", type = "array:org.apache.camel.model.rest.RestOperationParamDefinition"),
                    @YamlProperty(name = "produces", type = "string"),
                    @YamlProperty(name = "response-msgs", type = "array:org.apache.camel.model.rest.RestOperationResponseMsgDefinition"),
                    @YamlProperty(name = "route-id", type = "string"),
                    @YamlProperty(name = "security", type = "array:org.apache.camel.model.rest.SecurityDefinition"),
                    @YamlProperty(name = "skip-binding-on-error-code", type = "string"),
                    @YamlProperty(name = "to", type = "object:org.apache.camel.model.ToDefinition"),
                    @YamlProperty(name = "to-d", type = "object:org.apache.camel.model.ToDynamicDefinition"),
                    @YamlProperty(name = "route", type = "object:org.apache.camel.model.RouteDefinition"),
                    @YamlProperty(name = "type", type = "string"),
                    @YamlProperty(name = "uri", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class HeadVerbDefinitionDeserializer extends YamlDeserializerBase<HeadVerbDefinition> {
        public HeadVerbDefinitionDeserializer() {
            super(HeadVerbDefinition.class);
        }

        @Override
        protected HeadVerbDefinition newInstance() {
            return new HeadVerbDefinition();
        }

        @Override
        protected boolean setProperty(HeadVerbDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "api-docs": {
                    String val = asText(node);
                    target.setApiDocs(val);
                    break;
                }
                case "binding-mode": {
                    String val = asText(node);
                    target.setBindingMode(val);
                    break;
                }
                case "client-request-validation": {
                    String val = asText(node);
                    target.setClientRequestValidation(val);
                    break;
                }
                case "consumes": {
                    String val = asText(node);
                    target.setConsumes(val);
                    break;
                }
                case "enable-cors": {
                    String val = asText(node);
                    target.setEnableCORS(val);
                    break;
                }
                case "method": {
                    String val = asText(node);
                    target.setMethod(val);
                    break;
                }
                case "out-type": {
                    String val = asText(node);
                    target.setOutType(val);
                    break;
                }
                case "param": {
                    java.util.List<org.apache.camel.model.rest.RestOperationParamDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationParamDefinition.class);
                    target.setParams(val);
                    break;
                }
                case "produces": {
                    String val = asText(node);
                    target.setProduces(val);
                    break;
                }
                case "response-message": {
                    java.util.List<org.apache.camel.model.rest.RestOperationResponseMsgDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationResponseMsgDefinition.class);
                    target.setResponseMsgs(val);
                    break;
                }
                case "route-id": {
                    String val = asText(node);
                    target.setRouteId(val);
                    break;
                }
                case "security": {
                    java.util.List<org.apache.camel.model.rest.SecurityDefinition> val = asFlatList(node, org.apache.camel.model.rest.SecurityDefinition.class);
                    target.setSecurity(val);
                    break;
                }
                case "skip-binding-on-error-code": {
                    String val = asText(node);
                    target.setSkipBindingOnErrorCode(val);
                    break;
                }
                case "to-or-route": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "to": {
                    org.apache.camel.model.ToDefinition val = asType(node, org.apache.camel.model.ToDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "to-d": {
                    org.apache.camel.model.ToDynamicDefinition val = asType(node, org.apache.camel.model.ToDynamicDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "route": {
                    org.apache.camel.model.RouteDefinition val = asType(node, org.apache.camel.model.RouteDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.HeaderExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "header",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class HeaderExpressionDeserializer extends YamlDeserializerBase<HeaderExpression> {
        public HeaderExpressionDeserializer() {
            super(HeaderExpression.class);
        }

        @Override
        protected HeaderExpression newInstance() {
            return new HeaderExpression();
        }

        @Override
        protected HeaderExpression newInstance(String value) {
            return new HeaderExpression(value);
        }

        @Override
        protected boolean setProperty(HeaderExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.HealthyServiceCallServiceFilterConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "healthy-service-filter",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition")
            }
    )
    public static class HealthyServiceCallServiceFilterConfigurationDeserializer extends YamlDeserializerBase<HealthyServiceCallServiceFilterConfiguration> {
        public HealthyServiceCallServiceFilterConfigurationDeserializer() {
            super(HealthyServiceCallServiceFilterConfiguration.class);
        }

        @Override
        protected HealthyServiceCallServiceFilterConfiguration newInstance() {
            return new HealthyServiceCallServiceFilterConfiguration();
        }

        @Override
        protected boolean setProperty(HealthyServiceCallServiceFilterConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.Hl7TerserExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "hl7terser",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class Hl7TerserExpressionDeserializer extends YamlDeserializerBase<Hl7TerserExpression> {
        public Hl7TerserExpressionDeserializer() {
            super(Hl7TerserExpression.class);
        }

        @Override
        protected Hl7TerserExpression newInstance() {
            return new Hl7TerserExpression();
        }

        @Override
        protected Hl7TerserExpression newInstance(String value) {
            return new Hl7TerserExpression(value);
        }

        @Override
        protected boolean setProperty(Hl7TerserExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.HystrixConfigurationDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "hystrix-configuration",
            properties = {
                    @YamlProperty(name = "allow-maximum-size-to-diverge-from-core-size", type = "boolean"),
                    @YamlProperty(name = "circuit-breaker-enabled", type = "boolean"),
                    @YamlProperty(name = "circuit-breaker-error-threshold-percentage", type = "number"),
                    @YamlProperty(name = "circuit-breaker-force-closed", type = "boolean"),
                    @YamlProperty(name = "circuit-breaker-force-open", type = "boolean"),
                    @YamlProperty(name = "circuit-breaker-request-volume-threshold", type = "number"),
                    @YamlProperty(name = "circuit-breaker-sleep-window-in-milliseconds", type = "number"),
                    @YamlProperty(name = "core-pool-size", type = "number"),
                    @YamlProperty(name = "execution-isolation-semaphore-max-concurrent-requests", type = "number"),
                    @YamlProperty(name = "execution-isolation-strategy", type = "string"),
                    @YamlProperty(name = "execution-isolation-thread-interrupt-on-timeout", type = "boolean"),
                    @YamlProperty(name = "execution-timeout-enabled", type = "boolean"),
                    @YamlProperty(name = "execution-timeout-in-milliseconds", type = "number"),
                    @YamlProperty(name = "fallback-enabled", type = "boolean"),
                    @YamlProperty(name = "fallback-isolation-semaphore-max-concurrent-requests", type = "number"),
                    @YamlProperty(name = "group-key", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "keep-alive-time", type = "number"),
                    @YamlProperty(name = "max-queue-size", type = "number"),
                    @YamlProperty(name = "maximum-size", type = "number"),
                    @YamlProperty(name = "metrics-health-snapshot-interval-in-milliseconds", type = "number"),
                    @YamlProperty(name = "metrics-rolling-percentile-bucket-size", type = "number"),
                    @YamlProperty(name = "metrics-rolling-percentile-enabled", type = "boolean"),
                    @YamlProperty(name = "metrics-rolling-percentile-window-buckets", type = "number"),
                    @YamlProperty(name = "metrics-rolling-percentile-window-in-milliseconds", type = "number"),
                    @YamlProperty(name = "metrics-rolling-statistical-window-buckets", type = "number"),
                    @YamlProperty(name = "metrics-rolling-statistical-window-in-milliseconds", type = "number"),
                    @YamlProperty(name = "queue-size-rejection-threshold", type = "number"),
                    @YamlProperty(name = "request-log-enabled", type = "boolean"),
                    @YamlProperty(name = "thread-pool-key", type = "string"),
                    @YamlProperty(name = "thread-pool-rolling-number-statistical-window-buckets", type = "number"),
                    @YamlProperty(name = "thread-pool-rolling-number-statistical-window-in-milliseconds", type = "number")
            }
    )
    public static class HystrixConfigurationDefinitionDeserializer extends YamlDeserializerBase<HystrixConfigurationDefinition> {
        public HystrixConfigurationDefinitionDeserializer() {
            super(HystrixConfigurationDefinition.class);
        }

        @Override
        protected HystrixConfigurationDefinition newInstance() {
            return new HystrixConfigurationDefinition();
        }

        @Override
        protected boolean setProperty(HystrixConfigurationDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-maximum-size-to-diverge-from-core-size": {
                    String val = asText(node);
                    target.setAllowMaximumSizeToDivergeFromCoreSize(val);
                    break;
                }
                case "circuit-breaker-enabled": {
                    String val = asText(node);
                    target.setCircuitBreakerEnabled(val);
                    break;
                }
                case "circuit-breaker-error-threshold-percentage": {
                    String val = asText(node);
                    target.setCircuitBreakerErrorThresholdPercentage(val);
                    break;
                }
                case "circuit-breaker-force-closed": {
                    String val = asText(node);
                    target.setCircuitBreakerForceClosed(val);
                    break;
                }
                case "circuit-breaker-force-open": {
                    String val = asText(node);
                    target.setCircuitBreakerForceOpen(val);
                    break;
                }
                case "circuit-breaker-request-volume-threshold": {
                    String val = asText(node);
                    target.setCircuitBreakerRequestVolumeThreshold(val);
                    break;
                }
                case "circuit-breaker-sleep-window-in-milliseconds": {
                    String val = asText(node);
                    target.setCircuitBreakerSleepWindowInMilliseconds(val);
                    break;
                }
                case "core-pool-size": {
                    String val = asText(node);
                    target.setCorePoolSize(val);
                    break;
                }
                case "execution-isolation-semaphore-max-concurrent-requests": {
                    String val = asText(node);
                    target.setExecutionIsolationSemaphoreMaxConcurrentRequests(val);
                    break;
                }
                case "execution-isolation-strategy": {
                    String val = asText(node);
                    target.setExecutionIsolationStrategy(val);
                    break;
                }
                case "execution-isolation-thread-interrupt-on-timeout": {
                    String val = asText(node);
                    target.setExecutionIsolationThreadInterruptOnTimeout(val);
                    break;
                }
                case "execution-timeout-enabled": {
                    String val = asText(node);
                    target.setExecutionTimeoutEnabled(val);
                    break;
                }
                case "execution-timeout-in-milliseconds": {
                    String val = asText(node);
                    target.setExecutionTimeoutInMilliseconds(val);
                    break;
                }
                case "fallback-enabled": {
                    String val = asText(node);
                    target.setFallbackEnabled(val);
                    break;
                }
                case "fallback-isolation-semaphore-max-concurrent-requests": {
                    String val = asText(node);
                    target.setFallbackIsolationSemaphoreMaxConcurrentRequests(val);
                    break;
                }
                case "group-key": {
                    String val = asText(node);
                    target.setGroupKey(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "keep-alive-time": {
                    String val = asText(node);
                    target.setKeepAliveTime(val);
                    break;
                }
                case "max-queue-size": {
                    String val = asText(node);
                    target.setMaxQueueSize(val);
                    break;
                }
                case "maximum-size": {
                    String val = asText(node);
                    target.setMaximumSize(val);
                    break;
                }
                case "metrics-health-snapshot-interval-in-milliseconds": {
                    String val = asText(node);
                    target.setMetricsHealthSnapshotIntervalInMilliseconds(val);
                    break;
                }
                case "metrics-rolling-percentile-bucket-size": {
                    String val = asText(node);
                    target.setMetricsRollingPercentileBucketSize(val);
                    break;
                }
                case "metrics-rolling-percentile-enabled": {
                    String val = asText(node);
                    target.setMetricsRollingPercentileEnabled(val);
                    break;
                }
                case "metrics-rolling-percentile-window-buckets": {
                    String val = asText(node);
                    target.setMetricsRollingPercentileWindowBuckets(val);
                    break;
                }
                case "metrics-rolling-percentile-window-in-milliseconds": {
                    String val = asText(node);
                    target.setMetricsRollingPercentileWindowInMilliseconds(val);
                    break;
                }
                case "metrics-rolling-statistical-window-buckets": {
                    String val = asText(node);
                    target.setMetricsRollingStatisticalWindowBuckets(val);
                    break;
                }
                case "metrics-rolling-statistical-window-in-milliseconds": {
                    String val = asText(node);
                    target.setMetricsRollingStatisticalWindowInMilliseconds(val);
                    break;
                }
                case "queue-size-rejection-threshold": {
                    String val = asText(node);
                    target.setQueueSizeRejectionThreshold(val);
                    break;
                }
                case "request-log-enabled": {
                    String val = asText(node);
                    target.setRequestLogEnabled(val);
                    break;
                }
                case "thread-pool-key": {
                    String val = asText(node);
                    target.setThreadPoolKey(val);
                    break;
                }
                case "thread-pool-rolling-number-statistical-window-buckets": {
                    String val = asText(node);
                    target.setThreadPoolRollingNumberStatisticalWindowBuckets(val);
                    break;
                }
                case "thread-pool-rolling-number-statistical-window-in-milliseconds": {
                    String val = asText(node);
                    target.setThreadPoolRollingNumberStatisticalWindowInMilliseconds(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.IcalDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "ical",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "validating", type = "boolean")
            }
    )
    public static class IcalDataFormatDeserializer extends YamlDeserializerBase<IcalDataFormat> {
        public IcalDataFormatDeserializer() {
            super(IcalDataFormat.class);
        }

        @Override
        protected IcalDataFormat newInstance() {
            return new IcalDataFormat();
        }

        @Override
        protected boolean setProperty(IcalDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "validating": {
                    String val = asText(node);
                    target.setValidating(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.IdempotentConsumerDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "idempotent-consumer",
            properties = {
                    @YamlProperty(name = "completion-eager", type = "string"),
                    @YamlProperty(name = "eager", type = "boolean"),
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "message-id-repository-ref", type = "string"),
                    @YamlProperty(name = "remove-on-failure", type = "boolean"),
                    @YamlProperty(name = "skip-duplicate", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class IdempotentConsumerDefinitionDeserializer extends YamlDeserializerBase<IdempotentConsumerDefinition> {
        public IdempotentConsumerDefinitionDeserializer() {
            super(IdempotentConsumerDefinition.class);
        }

        @Override
        protected IdempotentConsumerDefinition newInstance() {
            return new IdempotentConsumerDefinition();
        }

        @Override
        protected boolean setProperty(IdempotentConsumerDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "completion-eager": {
                    String val = asText(node);
                    target.setCompletionEager(val);
                    break;
                }
                case "eager": {
                    String val = asText(node);
                    target.setEager(val);
                    break;
                }
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "message-id-repository-ref": {
                    String val = asText(node);
                    target.setMessageIdRepositoryRef(val);
                    break;
                }
                case "remove-on-failure": {
                    String val = asText(node);
                    target.setRemoveOnFailure(val);
                    break;
                }
                case "skip-duplicate": {
                    String val = asText(node);
                    target.setSkipDuplicate(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.InOnlyDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "in-only",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "uri", type = "string", required = true)
            }
    )
    public static class InOnlyDefinitionDeserializer extends YamlDeserializerBase<InOnlyDefinition> {
        public InOnlyDefinitionDeserializer() {
            super(InOnlyDefinition.class);
        }

        @Override
        protected InOnlyDefinition newInstance() {
            return new InOnlyDefinition();
        }

        @Override
        protected InOnlyDefinition newInstance(String value) {
            return new InOnlyDefinition(value);
        }

        @Override
        protected boolean setProperty(InOnlyDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.InOutDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "in-out",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "uri", type = "string", required = true)
            }
    )
    public static class InOutDefinitionDeserializer extends YamlDeserializerBase<InOutDefinition> {
        public InOutDefinitionDeserializer() {
            super(InOutDefinition.class);
        }

        @Override
        protected InOutDefinition newInstance() {
            return new InOutDefinition();
        }

        @Override
        protected InOutDefinition newInstance(String value) {
            return new InOutDefinition(value);
        }

        @Override
        protected boolean setProperty(InOutDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.InputTypeDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "input-type",
            properties = {
                    @YamlProperty(name = "urn", type = "string", required = true),
                    @YamlProperty(name = "validate", type = "boolean")
            }
    )
    public static class InputTypeDefinitionDeserializer extends YamlDeserializerBase<InputTypeDefinition> {
        public InputTypeDefinitionDeserializer() {
            super(InputTypeDefinition.class);
        }

        @Override
        protected InputTypeDefinition newInstance() {
            return new InputTypeDefinition();
        }

        @Override
        protected boolean setProperty(InputTypeDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "urn": {
                    String val = asText(node);
                    target.setUrn(val);
                    break;
                }
                case "validate": {
                    String val = asText(node);
                    target.setValidate(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.InterceptDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "intercept",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class InterceptDefinitionDeserializer extends YamlDeserializerBase<InterceptDefinition> {
        public InterceptDefinitionDeserializer() {
            super(InterceptDefinition.class);
        }

        @Override
        protected InterceptDefinition newInstance() {
            return new InterceptDefinition();
        }

        @Override
        protected boolean setProperty(InterceptDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.InterceptFromDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "intercept-from",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "uri", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class InterceptFromDefinitionDeserializer extends YamlDeserializerBase<InterceptFromDefinition> {
        public InterceptFromDefinitionDeserializer() {
            super(InterceptFromDefinition.class);
        }

        @Override
        protected InterceptFromDefinition newInstance() {
            return new InterceptFromDefinition();
        }

        @Override
        protected InterceptFromDefinition newInstance(String value) {
            return new InterceptFromDefinition(value);
        }

        @Override
        protected boolean setProperty(InterceptFromDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.InterceptSendToEndpointDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "intercept-send-to-endpoint",
            properties = {
                    @YamlProperty(name = "after-uri", type = "string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "skip-send-to-original-endpoint", type = "string"),
                    @YamlProperty(name = "uri", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class InterceptSendToEndpointDefinitionDeserializer extends YamlDeserializerBase<InterceptSendToEndpointDefinition> {
        public InterceptSendToEndpointDefinitionDeserializer() {
            super(InterceptSendToEndpointDefinition.class);
        }

        @Override
        protected InterceptSendToEndpointDefinition newInstance() {
            return new InterceptSendToEndpointDefinition();
        }

        @Override
        protected InterceptSendToEndpointDefinition newInstance(String value) {
            return new InterceptSendToEndpointDefinition(value);
        }

        @Override
        protected boolean setProperty(InterceptSendToEndpointDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "after-uri": {
                    String val = asText(node);
                    target.setAfterUri(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "skip-send-to-original-endpoint": {
                    String val = asText(node);
                    target.setSkipSendToOriginalEndpoint(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.JacksonXMLDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "jacksonxml",
            properties = {
                    @YamlProperty(name = "allow-jms-type", type = "boolean"),
                    @YamlProperty(name = "allow-unmarshall-type", type = "boolean"),
                    @YamlProperty(name = "collection-type-name", type = "string"),
                    @YamlProperty(name = "content-type-header", type = "boolean"),
                    @YamlProperty(name = "disable-features", type = "string"),
                    @YamlProperty(name = "enable-features", type = "string"),
                    @YamlProperty(name = "enable-jaxb-annotation-module", type = "boolean"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "include", type = "string"),
                    @YamlProperty(name = "json-view-type-name", type = "string"),
                    @YamlProperty(name = "module-class-names", type = "string"),
                    @YamlProperty(name = "module-refs", type = "string"),
                    @YamlProperty(name = "pretty-print", type = "boolean"),
                    @YamlProperty(name = "unmarshal-type-name", type = "string"),
                    @YamlProperty(name = "use-list", type = "boolean"),
                    @YamlProperty(name = "xml-mapper", type = "string")
            }
    )
    public static class JacksonXMLDataFormatDeserializer extends YamlDeserializerBase<JacksonXMLDataFormat> {
        public JacksonXMLDataFormatDeserializer() {
            super(JacksonXMLDataFormat.class);
        }

        @Override
        protected JacksonXMLDataFormat newInstance() {
            return new JacksonXMLDataFormat();
        }

        @Override
        protected boolean setProperty(JacksonXMLDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-jms-type": {
                    String val = asText(node);
                    target.setAllowJmsType(val);
                    break;
                }
                case "allow-unmarshall-type": {
                    String val = asText(node);
                    target.setAllowUnmarshallType(val);
                    break;
                }
                case "collection-type-name": {
                    String val = asText(node);
                    target.setCollectionTypeName(val);
                    break;
                }
                case "content-type-header": {
                    String val = asText(node);
                    target.setContentTypeHeader(val);
                    break;
                }
                case "disable-features": {
                    String val = asText(node);
                    target.setDisableFeatures(val);
                    break;
                }
                case "enable-features": {
                    String val = asText(node);
                    target.setEnableFeatures(val);
                    break;
                }
                case "enable-jaxb-annotation-module": {
                    String val = asText(node);
                    target.setEnableJaxbAnnotationModule(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "include": {
                    String val = asText(node);
                    target.setInclude(val);
                    break;
                }
                case "json-view-type-name": {
                    String val = asText(node);
                    target.setJsonViewTypeName(val);
                    break;
                }
                case "module-class-names": {
                    String val = asText(node);
                    target.setModuleClassNames(val);
                    break;
                }
                case "module-refs": {
                    String val = asText(node);
                    target.setModuleRefs(val);
                    break;
                }
                case "pretty-print": {
                    String val = asText(node);
                    target.setPrettyPrint(val);
                    break;
                }
                case "unmarshal-type-name": {
                    String val = asText(node);
                    target.setUnmarshalTypeName(val);
                    break;
                }
                case "use-list": {
                    String val = asText(node);
                    target.setUseList(val);
                    break;
                }
                case "xml-mapper": {
                    String val = asText(node);
                    target.setXmlMapper(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.JaxbDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "jaxb",
            properties = {
                    @YamlProperty(name = "content-type-header", type = "boolean"),
                    @YamlProperty(name = "context-path", type = "string"),
                    @YamlProperty(name = "context-path-is-class-name", type = "boolean"),
                    @YamlProperty(name = "encoding", type = "string"),
                    @YamlProperty(name = "filter-non-xml-chars", type = "boolean"),
                    @YamlProperty(name = "fragment", type = "boolean"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "ignore-jaxb-element", type = "boolean"),
                    @YamlProperty(name = "jaxb-provider-properties", type = "string"),
                    @YamlProperty(name = "must-be-jaxb-element", type = "boolean"),
                    @YamlProperty(name = "namespace-prefix-ref", type = "string"),
                    @YamlProperty(name = "no-namespace-schema-location", type = "string"),
                    @YamlProperty(name = "object-factory", type = "boolean"),
                    @YamlProperty(name = "part-class", type = "string"),
                    @YamlProperty(name = "part-namespace", type = "string"),
                    @YamlProperty(name = "pretty-print", type = "boolean"),
                    @YamlProperty(name = "schema", type = "string"),
                    @YamlProperty(name = "schema-location", type = "string"),
                    @YamlProperty(name = "schema-severity-level", type = "number"),
                    @YamlProperty(name = "xml-stream-writer-wrapper", type = "string")
            }
    )
    public static class JaxbDataFormatDeserializer extends YamlDeserializerBase<JaxbDataFormat> {
        public JaxbDataFormatDeserializer() {
            super(JaxbDataFormat.class);
        }

        @Override
        protected JaxbDataFormat newInstance() {
            return new JaxbDataFormat();
        }

        @Override
        protected boolean setProperty(JaxbDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "content-type-header": {
                    String val = asText(node);
                    target.setContentTypeHeader(val);
                    break;
                }
                case "context-path": {
                    String val = asText(node);
                    target.setContextPath(val);
                    break;
                }
                case "context-path-is-class-name": {
                    String val = asText(node);
                    target.setContextPathIsClassName(val);
                    break;
                }
                case "encoding": {
                    String val = asText(node);
                    target.setEncoding(val);
                    break;
                }
                case "filter-non-xml-chars": {
                    String val = asText(node);
                    target.setFilterNonXmlChars(val);
                    break;
                }
                case "fragment": {
                    String val = asText(node);
                    target.setFragment(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "ignore-jaxb-element": {
                    String val = asText(node);
                    target.setIgnoreJAXBElement(val);
                    break;
                }
                case "jaxb-provider-properties": {
                    String val = asText(node);
                    target.setJaxbProviderProperties(val);
                    break;
                }
                case "must-be-jaxb-element": {
                    String val = asText(node);
                    target.setMustBeJAXBElement(val);
                    break;
                }
                case "namespace-prefix-ref": {
                    String val = asText(node);
                    target.setNamespacePrefixRef(val);
                    break;
                }
                case "no-namespace-schema-location": {
                    String val = asText(node);
                    target.setNoNamespaceSchemaLocation(val);
                    break;
                }
                case "object-factory": {
                    String val = asText(node);
                    target.setObjectFactory(val);
                    break;
                }
                case "part-class": {
                    String val = asText(node);
                    target.setPartClass(val);
                    break;
                }
                case "part-namespace": {
                    String val = asText(node);
                    target.setPartNamespace(val);
                    break;
                }
                case "pretty-print": {
                    String val = asText(node);
                    target.setPrettyPrint(val);
                    break;
                }
                case "schema": {
                    String val = asText(node);
                    target.setSchema(val);
                    break;
                }
                case "schema-location": {
                    String val = asText(node);
                    target.setSchemaLocation(val);
                    break;
                }
                case "schema-severity-level": {
                    String val = asText(node);
                    target.setSchemaSeverityLevel(val);
                    break;
                }
                case "xml-stream-writer-wrapper": {
                    String val = asText(node);
                    target.setXmlStreamWriterWrapper(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.JoorExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "joor",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "pre-compile", type = "boolean"),
                    @YamlProperty(name = "result-type", type = "string"),
                    @YamlProperty(name = "single-quotes", type = "boolean"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class JoorExpressionDeserializer extends YamlDeserializerBase<JoorExpression> {
        public JoorExpressionDeserializer() {
            super(JoorExpression.class);
        }

        @Override
        protected JoorExpression newInstance() {
            return new JoorExpression();
        }

        @Override
        protected JoorExpression newInstance(String value) {
            return new JoorExpression(value);
        }

        @Override
        protected boolean setProperty(JoorExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "pre-compile": {
                    String val = asText(node);
                    target.setPreCompile(val);
                    break;
                }
                case "result-type": {
                    String val = asText(node);
                    target.setResultTypeName(val);
                    break;
                }
                case "single-quotes": {
                    String val = asText(node);
                    target.setSingleQuotes(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.JsonApiDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "json-api",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "main-format-type", type = "string")
            }
    )
    public static class JsonApiDataFormatDeserializer extends YamlDeserializerBase<JsonApiDataFormat> {
        public JsonApiDataFormatDeserializer() {
            super(JsonApiDataFormat.class);
        }

        @Override
        protected JsonApiDataFormat newInstance() {
            return new JsonApiDataFormat();
        }

        @Override
        protected boolean setProperty(JsonApiDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "data-format-types": {
                    java.lang.Class<?>[] val = asClassArray(node);
                    target.setDataFormatTypes(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "main-format-type": {
                    java.lang.Class<?> val = asClass(node);
                    target.setMainFormatType(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.JsonDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "json",
            properties = {
                    @YamlProperty(name = "allow-jms-type", type = "boolean"),
                    @YamlProperty(name = "allow-unmarshall-type", type = "boolean"),
                    @YamlProperty(name = "auto-discover-object-mapper", type = "boolean"),
                    @YamlProperty(name = "collection-type-name", type = "string"),
                    @YamlProperty(name = "content-type-header", type = "boolean"),
                    @YamlProperty(name = "disable-features", type = "string"),
                    @YamlProperty(name = "drop-root-node", type = "boolean"),
                    @YamlProperty(name = "enable-features", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "include", type = "string"),
                    @YamlProperty(name = "json-view-type-name", type = "string"),
                    @YamlProperty(name = "library", type = "enum:Fastjson,Gson,Jackson,Johnzon,Jsonb,XStream"),
                    @YamlProperty(name = "module-class-names", type = "string"),
                    @YamlProperty(name = "module-refs", type = "string"),
                    @YamlProperty(name = "object-mapper", type = "string"),
                    @YamlProperty(name = "permissions", type = "string"),
                    @YamlProperty(name = "pretty-print", type = "boolean"),
                    @YamlProperty(name = "timezone", type = "string"),
                    @YamlProperty(name = "unmarshal-type-name", type = "string"),
                    @YamlProperty(name = "use-default-object-mapper", type = "boolean"),
                    @YamlProperty(name = "use-list", type = "boolean")
            }
    )
    public static class JsonDataFormatDeserializer extends YamlDeserializerBase<JsonDataFormat> {
        public JsonDataFormatDeserializer() {
            super(JsonDataFormat.class);
        }

        @Override
        protected JsonDataFormat newInstance() {
            return new JsonDataFormat();
        }

        @Override
        protected boolean setProperty(JsonDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-jms-type": {
                    String val = asText(node);
                    target.setAllowJmsType(val);
                    break;
                }
                case "allow-unmarshall-type": {
                    String val = asText(node);
                    target.setAllowUnmarshallType(val);
                    break;
                }
                case "auto-discover-object-mapper": {
                    String val = asText(node);
                    target.setAutoDiscoverObjectMapper(val);
                    break;
                }
                case "collection-type-name": {
                    String val = asText(node);
                    target.setCollectionTypeName(val);
                    break;
                }
                case "content-type-header": {
                    String val = asText(node);
                    target.setContentTypeHeader(val);
                    break;
                }
                case "disable-features": {
                    String val = asText(node);
                    target.setDisableFeatures(val);
                    break;
                }
                case "drop-root-node": {
                    String val = asText(node);
                    target.setDropRootNode(val);
                    break;
                }
                case "enable-features": {
                    String val = asText(node);
                    target.setEnableFeatures(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "include": {
                    String val = asText(node);
                    target.setInclude(val);
                    break;
                }
                case "json-view-type-name": {
                    String val = asText(node);
                    target.setJsonViewTypeName(val);
                    break;
                }
                case "library": {
                    target.setLibrary(org.apache.camel.model.dataformat.JsonLibrary.valueOf(asText(node)));
                    break;
                }
                case "module-class-names": {
                    String val = asText(node);
                    target.setModuleClassNames(val);
                    break;
                }
                case "module-refs": {
                    String val = asText(node);
                    target.setModuleRefs(val);
                    break;
                }
                case "object-mapper": {
                    String val = asText(node);
                    target.setObjectMapper(val);
                    break;
                }
                case "permissions": {
                    String val = asText(node);
                    target.setPermissions(val);
                    break;
                }
                case "pretty-print": {
                    String val = asText(node);
                    target.setPrettyPrint(val);
                    break;
                }
                case "timezone": {
                    String val = asText(node);
                    target.setTimezone(val);
                    break;
                }
                case "unmarshal-type-name": {
                    String val = asText(node);
                    target.setUnmarshalTypeName(val);
                    break;
                }
                case "use-default-object-mapper": {
                    String val = asText(node);
                    target.setUseDefaultObjectMapper(val);
                    break;
                }
                case "use-list": {
                    String val = asText(node);
                    target.setUseList(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.JsonPathExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "jsonpath",
            properties = {
                    @YamlProperty(name = "allow-easy-predicate", type = "boolean"),
                    @YamlProperty(name = "allow-simple", type = "boolean"),
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "header-name", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "option", type = "string"),
                    @YamlProperty(name = "result-type", type = "string"),
                    @YamlProperty(name = "suppress-exceptions", type = "boolean"),
                    @YamlProperty(name = "trim", type = "boolean"),
                    @YamlProperty(name = "write-as-string", type = "boolean")
            }
    )
    public static class JsonPathExpressionDeserializer extends YamlDeserializerBase<JsonPathExpression> {
        public JsonPathExpressionDeserializer() {
            super(JsonPathExpression.class);
        }

        @Override
        protected JsonPathExpression newInstance() {
            return new JsonPathExpression();
        }

        @Override
        protected JsonPathExpression newInstance(String value) {
            return new JsonPathExpression(value);
        }

        @Override
        protected boolean setProperty(JsonPathExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-easy-predicate": {
                    String val = asText(node);
                    target.setAllowEasyPredicate(val);
                    break;
                }
                case "allow-simple": {
                    String val = asText(node);
                    target.setAllowSimple(val);
                    break;
                }
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "header-name": {
                    String val = asText(node);
                    target.setHeaderName(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "option": {
                    String val = asText(node);
                    target.setOption(val);
                    break;
                }
                case "result-type": {
                    String val = asText(node);
                    target.setResultTypeName(val);
                    break;
                }
                case "suppress-exceptions": {
                    String val = asText(node);
                    target.setSuppressExceptions(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                case "write-as-string": {
                    String val = asText(node);
                    target.setWriteAsString(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "kubernetes-service-discovery",
            properties = {
                    @YamlProperty(name = "api-version", type = "string"),
                    @YamlProperty(name = "ca-cert-data", type = "string"),
                    @YamlProperty(name = "ca-cert-file", type = "string"),
                    @YamlProperty(name = "client-cert-data", type = "string"),
                    @YamlProperty(name = "client-cert-file", type = "string"),
                    @YamlProperty(name = "client-key-algo", type = "string"),
                    @YamlProperty(name = "client-key-data", type = "string"),
                    @YamlProperty(name = "client-key-file", type = "string"),
                    @YamlProperty(name = "client-key-passphrase", type = "string"),
                    @YamlProperty(name = "dns-domain", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "lookup", type = "string"),
                    @YamlProperty(name = "master-url", type = "string"),
                    @YamlProperty(name = "namespace", type = "string"),
                    @YamlProperty(name = "oauth-token", type = "string"),
                    @YamlProperty(name = "password", type = "string"),
                    @YamlProperty(name = "port-name", type = "string"),
                    @YamlProperty(name = "port-protocol", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "trust-certs", type = "boolean"),
                    @YamlProperty(name = "username", type = "string")
            }
    )
    public static class KubernetesServiceCallServiceDiscoveryConfigurationDeserializer extends YamlDeserializerBase<KubernetesServiceCallServiceDiscoveryConfiguration> {
        public KubernetesServiceCallServiceDiscoveryConfigurationDeserializer() {
            super(KubernetesServiceCallServiceDiscoveryConfiguration.class);
        }

        @Override
        protected KubernetesServiceCallServiceDiscoveryConfiguration newInstance() {
            return new KubernetesServiceCallServiceDiscoveryConfiguration();
        }

        @Override
        protected boolean setProperty(KubernetesServiceCallServiceDiscoveryConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "api-version": {
                    String val = asText(node);
                    target.setApiVersion(val);
                    break;
                }
                case "ca-cert-data": {
                    String val = asText(node);
                    target.setCaCertData(val);
                    break;
                }
                case "ca-cert-file": {
                    String val = asText(node);
                    target.setCaCertFile(val);
                    break;
                }
                case "client-cert-data": {
                    String val = asText(node);
                    target.setClientCertData(val);
                    break;
                }
                case "client-cert-file": {
                    String val = asText(node);
                    target.setClientCertFile(val);
                    break;
                }
                case "client-key-algo": {
                    String val = asText(node);
                    target.setClientKeyAlgo(val);
                    break;
                }
                case "client-key-data": {
                    String val = asText(node);
                    target.setClientKeyData(val);
                    break;
                }
                case "client-key-file": {
                    String val = asText(node);
                    target.setClientKeyFile(val);
                    break;
                }
                case "client-key-passphrase": {
                    String val = asText(node);
                    target.setClientKeyPassphrase(val);
                    break;
                }
                case "dns-domain": {
                    String val = asText(node);
                    target.setDnsDomain(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "lookup": {
                    String val = asText(node);
                    target.setLookup(val);
                    break;
                }
                case "master-url": {
                    String val = asText(node);
                    target.setMasterUrl(val);
                    break;
                }
                case "namespace": {
                    String val = asText(node);
                    target.setNamespace(val);
                    break;
                }
                case "oauth-token": {
                    String val = asText(node);
                    target.setOauthToken(val);
                    break;
                }
                case "password": {
                    String val = asText(node);
                    target.setPassword(val);
                    break;
                }
                case "port-name": {
                    String val = asText(node);
                    target.setPortName(val);
                    break;
                }
                case "port-protocol": {
                    String val = asText(node);
                    target.setPortProtocol(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                case "trust-certs": {
                    String val = asText(node);
                    target.setTrustCerts(val);
                    break;
                }
                case "username": {
                    String val = asText(node);
                    target.setUsername(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.LZFDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "lzf",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "using-parallel-compression", type = "boolean")
            }
    )
    public static class LZFDataFormatDeserializer extends YamlDeserializerBase<LZFDataFormat> {
        public LZFDataFormatDeserializer() {
            super(LZFDataFormat.class);
        }

        @Override
        protected LZFDataFormat newInstance() {
            return new LZFDataFormat();
        }

        @Override
        protected boolean setProperty(LZFDataFormat target, String propertyKey, String propertyName,
                Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "using-parallel-compression": {
                    String val = asText(node);
                    target.setUsingParallelCompression(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.language.LanguageExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "language",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "language", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class LanguageExpressionDeserializer extends YamlDeserializerBase<LanguageExpression> {
        public LanguageExpressionDeserializer() {
            super(LanguageExpression.class);
        }

        @Override
        protected LanguageExpression newInstance() {
            return new LanguageExpression();
        }

        @Override
        protected boolean setProperty(LanguageExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "language": {
                    String val = asText(node);
                    target.setLanguage(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.LoadBalanceDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "load-balance",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "failover", type = "object:org.apache.camel.model.loadbalancer.FailoverLoadBalancerDefinition"),
                    @YamlProperty(name = "random", type = "object:org.apache.camel.model.loadbalancer.RandomLoadBalancerDefinition"),
                    @YamlProperty(name = "custom-load-balancer", type = "object:org.apache.camel.model.loadbalancer.CustomLoadBalancerDefinition"),
                    @YamlProperty(name = "round-robin", type = "object:org.apache.camel.model.loadbalancer.RoundRobinLoadBalancerDefinition"),
                    @YamlProperty(name = "sticky", type = "object:org.apache.camel.model.loadbalancer.StickyLoadBalancerDefinition"),
                    @YamlProperty(name = "topic", type = "object:org.apache.camel.model.loadbalancer.TopicLoadBalancerDefinition"),
                    @YamlProperty(name = "weighted", type = "object:org.apache.camel.model.loadbalancer.WeightedLoadBalancerDefinition"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class LoadBalanceDefinitionDeserializer extends YamlDeserializerBase<LoadBalanceDefinition> {
        public LoadBalanceDefinitionDeserializer() {
            super(LoadBalanceDefinition.class);
        }

        @Override
        protected LoadBalanceDefinition newInstance() {
            return new LoadBalanceDefinition();
        }

        @Override
        protected boolean setProperty(LoadBalanceDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "load-balancer-type": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "failover": {
                    org.apache.camel.model.loadbalancer.FailoverLoadBalancerDefinition val = asType(node, org.apache.camel.model.loadbalancer.FailoverLoadBalancerDefinition.class);
                    target.setLoadBalancerType(val);
                    break;
                }
                case "random": {
                    org.apache.camel.model.loadbalancer.RandomLoadBalancerDefinition val = asType(node, org.apache.camel.model.loadbalancer.RandomLoadBalancerDefinition.class);
                    target.setLoadBalancerType(val);
                    break;
                }
                case "custom-load-balancer": {
                    org.apache.camel.model.loadbalancer.CustomLoadBalancerDefinition val = asType(node, org.apache.camel.model.loadbalancer.CustomLoadBalancerDefinition.class);
                    target.setLoadBalancerType(val);
                    break;
                }
                case "round-robin": {
                    org.apache.camel.model.loadbalancer.RoundRobinLoadBalancerDefinition val = asType(node, org.apache.camel.model.loadbalancer.RoundRobinLoadBalancerDefinition.class);
                    target.setLoadBalancerType(val);
                    break;
                }
                case "sticky": {
                    org.apache.camel.model.loadbalancer.StickyLoadBalancerDefinition val = asType(node, org.apache.camel.model.loadbalancer.StickyLoadBalancerDefinition.class);
                    target.setLoadBalancerType(val);
                    break;
                }
                case "topic": {
                    org.apache.camel.model.loadbalancer.TopicLoadBalancerDefinition val = asType(node, org.apache.camel.model.loadbalancer.TopicLoadBalancerDefinition.class);
                    target.setLoadBalancerType(val);
                    break;
                }
                case "weighted": {
                    org.apache.camel.model.loadbalancer.WeightedLoadBalancerDefinition val = asType(node, org.apache.camel.model.loadbalancer.WeightedLoadBalancerDefinition.class);
                    target.setLoadBalancerType(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.LoadBalancerDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            properties = @YamlProperty(name = "id", type = "string")
    )
    public static class LoadBalancerDefinitionDeserializer extends YamlDeserializerBase<LoadBalancerDefinition> {
        public LoadBalancerDefinitionDeserializer() {
            super(LoadBalancerDefinition.class);
        }

        @Override
        protected LoadBalancerDefinition newInstance() {
            return new LoadBalancerDefinition();
        }

        @Override
        protected boolean setProperty(LoadBalancerDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.LogDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "log",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "log-name", type = "string"),
                    @YamlProperty(name = "logger-ref", type = "string"),
                    @YamlProperty(name = "logging-level", type = "string"),
                    @YamlProperty(name = "marker", type = "string"),
                    @YamlProperty(name = "message", type = "string")
            }
    )
    public static class LogDefinitionDeserializer extends YamlDeserializerBase<LogDefinition> {
        public LogDefinitionDeserializer() {
            super(LogDefinition.class);
        }

        @Override
        protected LogDefinition newInstance() {
            return new LogDefinition();
        }

        @Override
        protected LogDefinition newInstance(String value) {
            return new LogDefinition(value);
        }

        @Override
        protected boolean setProperty(LogDefinition target, String propertyKey, String propertyName,
                Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "log-name": {
                    String val = asText(node);
                    target.setLogName(val);
                    break;
                }
                case "logger-ref": {
                    String val = asText(node);
                    target.setLoggerRef(val);
                    break;
                }
                case "logging-level": {
                    String val = asText(node);
                    target.setLoggingLevel(val);
                    break;
                }
                case "marker": {
                    String val = asText(node);
                    target.setMarker(val);
                    break;
                }
                case "message": {
                    String val = asText(node);
                    target.setMessage(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.LoopDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "loop",
            properties = {
                    @YamlProperty(name = "break-on-shutdown", type = "boolean"),
                    @YamlProperty(name = "copy", type = "boolean"),
                    @YamlProperty(name = "do-while", type = "boolean"),
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class LoopDefinitionDeserializer extends YamlDeserializerBase<LoopDefinition> {
        public LoopDefinitionDeserializer() {
            super(LoopDefinition.class);
        }

        @Override
        protected LoopDefinition newInstance() {
            return new LoopDefinition();
        }

        @Override
        protected boolean setProperty(LoopDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "break-on-shutdown": {
                    String val = asText(node);
                    target.setBreakOnShutdown(val);
                    break;
                }
                case "copy": {
                    String val = asText(node);
                    target.setCopy(val);
                    break;
                }
                case "do-while": {
                    String val = asText(node);
                    target.setDoWhile(val);
                    break;
                }
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.MarshalDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "marshal",
            properties = {
                    @YamlProperty(name = "any23", type = "object:org.apache.camel.model.dataformat.Any23DataFormat"),
                    @YamlProperty(name = "asn1", type = "object:org.apache.camel.model.dataformat.ASN1DataFormat"),
                    @YamlProperty(name = "avro", type = "object:org.apache.camel.model.dataformat.AvroDataFormat"),
                    @YamlProperty(name = "barcode", type = "object:org.apache.camel.model.dataformat.BarcodeDataFormat"),
                    @YamlProperty(name = "base64", type = "object:org.apache.camel.model.dataformat.Base64DataFormat"),
                    @YamlProperty(name = "beanio", type = "object:org.apache.camel.model.dataformat.BeanioDataFormat"),
                    @YamlProperty(name = "bindy", type = "object:org.apache.camel.model.dataformat.BindyDataFormat"),
                    @YamlProperty(name = "cbor", type = "object:org.apache.camel.model.dataformat.CBORDataFormat"),
                    @YamlProperty(name = "crypto", type = "object:org.apache.camel.model.dataformat.CryptoDataFormat"),
                    @YamlProperty(name = "csv", type = "object:org.apache.camel.model.dataformat.CsvDataFormat"),
                    @YamlProperty(name = "custom", type = "object:org.apache.camel.model.dataformat.CustomDataFormat"),
                    @YamlProperty(name = "fhir-json", type = "object:org.apache.camel.model.dataformat.FhirJsonDataFormat"),
                    @YamlProperty(name = "fhir-xml", type = "object:org.apache.camel.model.dataformat.FhirXmlDataFormat"),
                    @YamlProperty(name = "flatpack", type = "object:org.apache.camel.model.dataformat.FlatpackDataFormat"),
                    @YamlProperty(name = "grok", type = "object:org.apache.camel.model.dataformat.GrokDataFormat"),
                    @YamlProperty(name = "gzip", type = "object:org.apache.camel.model.dataformat.GzipDataFormat"),
                    @YamlProperty(name = "hl7", type = "object:org.apache.camel.model.dataformat.HL7DataFormat"),
                    @YamlProperty(name = "ical", type = "object:org.apache.camel.model.dataformat.IcalDataFormat"),
                    @YamlProperty(name = "jacksonxml", type = "object:org.apache.camel.model.dataformat.JacksonXMLDataFormat"),
                    @YamlProperty(name = "jaxb", type = "object:org.apache.camel.model.dataformat.JaxbDataFormat"),
                    @YamlProperty(name = "json", type = "object:org.apache.camel.model.dataformat.JsonDataFormat"),
                    @YamlProperty(name = "json-api", type = "object:org.apache.camel.model.dataformat.JsonApiDataFormat"),
                    @YamlProperty(name = "lzf", type = "object:org.apache.camel.model.dataformat.LZFDataFormat"),
                    @YamlProperty(name = "mime-multipart", type = "object:org.apache.camel.model.dataformat.MimeMultipartDataFormat"),
                    @YamlProperty(name = "protobuf", type = "object:org.apache.camel.model.dataformat.ProtobufDataFormat"),
                    @YamlProperty(name = "rss", type = "object:org.apache.camel.model.dataformat.RssDataFormat"),
                    @YamlProperty(name = "secure-xml", type = "object:org.apache.camel.model.dataformat.XMLSecurityDataFormat"),
                    @YamlProperty(name = "soapjaxb", type = "object:org.apache.camel.model.dataformat.SoapJaxbDataFormat"),
                    @YamlProperty(name = "syslog", type = "object:org.apache.camel.model.dataformat.SyslogDataFormat"),
                    @YamlProperty(name = "tarfile", type = "object:org.apache.camel.model.dataformat.TarFileDataFormat"),
                    @YamlProperty(name = "thrift", type = "object:org.apache.camel.model.dataformat.ThriftDataFormat"),
                    @YamlProperty(name = "tidy-markup", type = "object:org.apache.camel.model.dataformat.TidyMarkupDataFormat"),
                    @YamlProperty(name = "univocity-csv", type = "object:org.apache.camel.model.dataformat.UniVocityCsvDataFormat"),
                    @YamlProperty(name = "univocity-fixed", type = "object:org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat"),
                    @YamlProperty(name = "univocity-tsv", type = "object:org.apache.camel.model.dataformat.UniVocityTsvDataFormat"),
                    @YamlProperty(name = "xmlrpc", type = "object:org.apache.camel.model.dataformat.XmlRpcDataFormat"),
                    @YamlProperty(name = "xstream", type = "object:org.apache.camel.model.dataformat.XStreamDataFormat"),
                    @YamlProperty(name = "pgp", type = "object:org.apache.camel.model.dataformat.PGPDataFormat"),
                    @YamlProperty(name = "yaml", type = "object:org.apache.camel.model.dataformat.YAMLDataFormat"),
                    @YamlProperty(name = "zip", type = "object:org.apache.camel.model.dataformat.ZipDeflaterDataFormat"),
                    @YamlProperty(name = "zipfile", type = "object:org.apache.camel.model.dataformat.ZipFileDataFormat"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean")
            }
    )
    public static class MarshalDefinitionDeserializer extends YamlDeserializerBase<MarshalDefinition> {
        public MarshalDefinitionDeserializer() {
            super(MarshalDefinition.class);
        }

        @Override
        protected MarshalDefinition newInstance() {
            return new MarshalDefinition();
        }

        @Override
        protected boolean setProperty(MarshalDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "data-format-type": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "any23": {
                    org.apache.camel.model.dataformat.Any23DataFormat val = asType(node, org.apache.camel.model.dataformat.Any23DataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "asn1": {
                    org.apache.camel.model.dataformat.ASN1DataFormat val = asType(node, org.apache.camel.model.dataformat.ASN1DataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "avro": {
                    org.apache.camel.model.dataformat.AvroDataFormat val = asType(node, org.apache.camel.model.dataformat.AvroDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "barcode": {
                    org.apache.camel.model.dataformat.BarcodeDataFormat val = asType(node, org.apache.camel.model.dataformat.BarcodeDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "base64": {
                    org.apache.camel.model.dataformat.Base64DataFormat val = asType(node, org.apache.camel.model.dataformat.Base64DataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "beanio": {
                    org.apache.camel.model.dataformat.BeanioDataFormat val = asType(node, org.apache.camel.model.dataformat.BeanioDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "bindy": {
                    org.apache.camel.model.dataformat.BindyDataFormat val = asType(node, org.apache.camel.model.dataformat.BindyDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "cbor": {
                    org.apache.camel.model.dataformat.CBORDataFormat val = asType(node, org.apache.camel.model.dataformat.CBORDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "crypto": {
                    org.apache.camel.model.dataformat.CryptoDataFormat val = asType(node, org.apache.camel.model.dataformat.CryptoDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "csv": {
                    org.apache.camel.model.dataformat.CsvDataFormat val = asType(node, org.apache.camel.model.dataformat.CsvDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "custom": {
                    org.apache.camel.model.dataformat.CustomDataFormat val = asType(node, org.apache.camel.model.dataformat.CustomDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "fhir-json": {
                    org.apache.camel.model.dataformat.FhirJsonDataFormat val = asType(node, org.apache.camel.model.dataformat.FhirJsonDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "fhir-xml": {
                    org.apache.camel.model.dataformat.FhirXmlDataFormat val = asType(node, org.apache.camel.model.dataformat.FhirXmlDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "flatpack": {
                    org.apache.camel.model.dataformat.FlatpackDataFormat val = asType(node, org.apache.camel.model.dataformat.FlatpackDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "grok": {
                    org.apache.camel.model.dataformat.GrokDataFormat val = asType(node, org.apache.camel.model.dataformat.GrokDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "gzip": {
                    org.apache.camel.model.dataformat.GzipDataFormat val = asType(node, org.apache.camel.model.dataformat.GzipDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "hl7": {
                    org.apache.camel.model.dataformat.HL7DataFormat val = asType(node, org.apache.camel.model.dataformat.HL7DataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "ical": {
                    org.apache.camel.model.dataformat.IcalDataFormat val = asType(node, org.apache.camel.model.dataformat.IcalDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "jacksonxml": {
                    org.apache.camel.model.dataformat.JacksonXMLDataFormat val = asType(node, org.apache.camel.model.dataformat.JacksonXMLDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "jaxb": {
                    org.apache.camel.model.dataformat.JaxbDataFormat val = asType(node, org.apache.camel.model.dataformat.JaxbDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "json": {
                    org.apache.camel.model.dataformat.JsonDataFormat val = asType(node, org.apache.camel.model.dataformat.JsonDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "json-api": {
                    org.apache.camel.model.dataformat.JsonApiDataFormat val = asType(node, org.apache.camel.model.dataformat.JsonApiDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "lzf": {
                    org.apache.camel.model.dataformat.LZFDataFormat val = asType(node, org.apache.camel.model.dataformat.LZFDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "mime-multipart": {
                    org.apache.camel.model.dataformat.MimeMultipartDataFormat val = asType(node, org.apache.camel.model.dataformat.MimeMultipartDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "protobuf": {
                    org.apache.camel.model.dataformat.ProtobufDataFormat val = asType(node, org.apache.camel.model.dataformat.ProtobufDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "rss": {
                    org.apache.camel.model.dataformat.RssDataFormat val = asType(node, org.apache.camel.model.dataformat.RssDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "secure-xml": {
                    org.apache.camel.model.dataformat.XMLSecurityDataFormat val = asType(node, org.apache.camel.model.dataformat.XMLSecurityDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "soapjaxb": {
                    org.apache.camel.model.dataformat.SoapJaxbDataFormat val = asType(node, org.apache.camel.model.dataformat.SoapJaxbDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "syslog": {
                    org.apache.camel.model.dataformat.SyslogDataFormat val = asType(node, org.apache.camel.model.dataformat.SyslogDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "tarfile": {
                    org.apache.camel.model.dataformat.TarFileDataFormat val = asType(node, org.apache.camel.model.dataformat.TarFileDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "thrift": {
                    org.apache.camel.model.dataformat.ThriftDataFormat val = asType(node, org.apache.camel.model.dataformat.ThriftDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "tidy-markup": {
                    org.apache.camel.model.dataformat.TidyMarkupDataFormat val = asType(node, org.apache.camel.model.dataformat.TidyMarkupDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "univocity-csv": {
                    org.apache.camel.model.dataformat.UniVocityCsvDataFormat val = asType(node, org.apache.camel.model.dataformat.UniVocityCsvDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "univocity-fixed": {
                    org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat val = asType(node, org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "univocity-tsv": {
                    org.apache.camel.model.dataformat.UniVocityTsvDataFormat val = asType(node, org.apache.camel.model.dataformat.UniVocityTsvDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "xmlrpc": {
                    org.apache.camel.model.dataformat.XmlRpcDataFormat val = asType(node, org.apache.camel.model.dataformat.XmlRpcDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "xstream": {
                    org.apache.camel.model.dataformat.XStreamDataFormat val = asType(node, org.apache.camel.model.dataformat.XStreamDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "pgp": {
                    org.apache.camel.model.dataformat.PGPDataFormat val = asType(node, org.apache.camel.model.dataformat.PGPDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "yaml": {
                    org.apache.camel.model.dataformat.YAMLDataFormat val = asType(node, org.apache.camel.model.dataformat.YAMLDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "zip": {
                    org.apache.camel.model.dataformat.ZipDeflaterDataFormat val = asType(node, org.apache.camel.model.dataformat.ZipDeflaterDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "zipfile": {
                    org.apache.camel.model.dataformat.ZipFileDataFormat val = asType(node, org.apache.camel.model.dataformat.ZipFileDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.MethodCallExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "method",
            properties = {
                    @YamlProperty(name = "bean-type", type = "string"),
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "method", type = "string"),
                    @YamlProperty(name = "ref", type = "string"),
                    @YamlProperty(name = "scope", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class MethodCallExpressionDeserializer extends YamlDeserializerBase<MethodCallExpression> {
        public MethodCallExpressionDeserializer() {
            super(MethodCallExpression.class);
        }

        @Override
        protected MethodCallExpression newInstance() {
            return new MethodCallExpression();
        }

        @Override
        protected MethodCallExpression newInstance(String value) {
            return new MethodCallExpression(value);
        }

        @Override
        protected boolean setProperty(MethodCallExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "bean-type": {
                    String val = asText(node);
                    target.setBeanTypeName(val);
                    break;
                }
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "method": {
                    String val = asText(node);
                    target.setMethod(val);
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                case "scope": {
                    String val = asText(node);
                    target.setScope(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.MimeMultipartDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "mime-multipart",
            properties = {
                    @YamlProperty(name = "binary-content", type = "boolean"),
                    @YamlProperty(name = "headers-inline", type = "boolean"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "include-headers", type = "string"),
                    @YamlProperty(name = "multipart-sub-type", type = "string"),
                    @YamlProperty(name = "multipart-without-attachment", type = "boolean")
            }
    )
    public static class MimeMultipartDataFormatDeserializer extends YamlDeserializerBase<MimeMultipartDataFormat> {
        public MimeMultipartDataFormatDeserializer() {
            super(MimeMultipartDataFormat.class);
        }

        @Override
        protected MimeMultipartDataFormat newInstance() {
            return new MimeMultipartDataFormat();
        }

        @Override
        protected boolean setProperty(MimeMultipartDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "binary-content": {
                    String val = asText(node);
                    target.setBinaryContent(val);
                    break;
                }
                case "headers-inline": {
                    String val = asText(node);
                    target.setHeadersInline(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "include-headers": {
                    String val = asText(node);
                    target.setIncludeHeaders(val);
                    break;
                }
                case "multipart-sub-type": {
                    String val = asText(node);
                    target.setMultipartSubType(val);
                    break;
                }
                case "multipart-without-attachment": {
                    String val = asText(node);
                    target.setMultipartWithoutAttachment(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.MulticastDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "multicast",
            properties = {
                    @YamlProperty(name = "executor-service-ref", type = "string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "on-prepare-ref", type = "string"),
                    @YamlProperty(name = "parallel-aggregate", type = "boolean"),
                    @YamlProperty(name = "parallel-processing", type = "boolean"),
                    @YamlProperty(name = "share-unit-of-work", type = "boolean"),
                    @YamlProperty(name = "stop-on-aggregate-exception", type = "boolean"),
                    @YamlProperty(name = "stop-on-exception", type = "boolean"),
                    @YamlProperty(name = "strategy-method-allow-null", type = "boolean"),
                    @YamlProperty(name = "strategy-method-name", type = "string"),
                    @YamlProperty(name = "strategy-ref", type = "string"),
                    @YamlProperty(name = "streaming", type = "boolean"),
                    @YamlProperty(name = "timeout", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class MulticastDefinitionDeserializer extends YamlDeserializerBase<MulticastDefinition> {
        public MulticastDefinitionDeserializer() {
            super(MulticastDefinition.class);
        }

        @Override
        protected MulticastDefinition newInstance() {
            return new MulticastDefinition();
        }

        @Override
        protected boolean setProperty(MulticastDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "executor-service-ref": {
                    String val = asText(node);
                    target.setExecutorServiceRef(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "on-prepare-ref": {
                    String val = asText(node);
                    target.setOnPrepareRef(val);
                    break;
                }
                case "parallel-aggregate": {
                    String val = asText(node);
                    target.setParallelAggregate(val);
                    break;
                }
                case "parallel-processing": {
                    String val = asText(node);
                    target.setParallelProcessing(val);
                    break;
                }
                case "share-unit-of-work": {
                    String val = asText(node);
                    target.setShareUnitOfWork(val);
                    break;
                }
                case "stop-on-aggregate-exception": {
                    String val = asText(node);
                    target.setStopOnAggregateException(val);
                    break;
                }
                case "stop-on-exception": {
                    String val = asText(node);
                    target.setStopOnException(val);
                    break;
                }
                case "strategy-method-allow-null": {
                    String val = asText(node);
                    target.setStrategyMethodAllowNull(val);
                    break;
                }
                case "strategy-method-name": {
                    String val = asText(node);
                    target.setStrategyMethodName(val);
                    break;
                }
                case "strategy-ref": {
                    String val = asText(node);
                    target.setStrategyRef(val);
                    break;
                }
                case "streaming": {
                    String val = asText(node);
                    target.setStreaming(val);
                    break;
                }
                case "timeout": {
                    String val = asText(node);
                    target.setTimeout(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.MvelExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "mvel",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class MvelExpressionDeserializer extends YamlDeserializerBase<MvelExpression> {
        public MvelExpressionDeserializer() {
            super(MvelExpression.class);
        }

        @Override
        protected MvelExpression newInstance() {
            return new MvelExpression();
        }

        @Override
        protected MvelExpression newInstance(String value) {
            return new MvelExpression(value);
        }

        @Override
        protected boolean setProperty(MvelExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.OgnlExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "ognl",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class OgnlExpressionDeserializer extends YamlDeserializerBase<OgnlExpression> {
        public OgnlExpressionDeserializer() {
            super(OgnlExpression.class);
        }

        @Override
        protected OgnlExpression newInstance() {
            return new OgnlExpression();
        }

        @Override
        protected OgnlExpression newInstance(String value) {
            return new OgnlExpression(value);
        }

        @Override
        protected boolean setProperty(OgnlExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.OnCompletionDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "on-completion",
            properties = {
                    @YamlProperty(name = "executor-service-ref", type = "string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "mode", type = "string"),
                    @YamlProperty(name = "on-complete-only", type = "boolean"),
                    @YamlProperty(name = "on-failure-only", type = "boolean"),
                    @YamlProperty(name = "on-when", type = "object:org.apache.camel.model.WhenDefinition"),
                    @YamlProperty(name = "parallel-processing", type = "boolean"),
                    @YamlProperty(name = "use-original-message", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class OnCompletionDefinitionDeserializer extends YamlDeserializerBase<OnCompletionDefinition> {
        public OnCompletionDefinitionDeserializer() {
            super(OnCompletionDefinition.class);
        }

        @Override
        protected OnCompletionDefinition newInstance() {
            return new OnCompletionDefinition();
        }

        @Override
        protected boolean setProperty(OnCompletionDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "executor-service-ref": {
                    String val = asText(node);
                    target.setExecutorServiceRef(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "mode": {
                    String val = asText(node);
                    target.setMode(val);
                    break;
                }
                case "on-complete-only": {
                    String val = asText(node);
                    target.setOnCompleteOnly(val);
                    break;
                }
                case "on-failure-only": {
                    String val = asText(node);
                    target.setOnFailureOnly(val);
                    break;
                }
                case "on-when": {
                    org.apache.camel.model.WhenDefinition val = asType(node, org.apache.camel.model.WhenDefinition.class);
                    target.setOnWhen(val);
                    break;
                }
                case "parallel-processing": {
                    String val = asText(node);
                    target.setParallelProcessing(val);
                    break;
                }
                case "use-original-message": {
                    String val = asText(node);
                    target.setUseOriginalMessage(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlIn
    @YamlType(
            types = org.apache.camel.model.OnExceptionDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "on-exception",
            properties = {
                    @YamlProperty(name = "continued", type = "object:org.apache.camel.model.ExpressionSubElementDefinition"),
                    @YamlProperty(name = "exception", type = "array:string"),
                    @YamlProperty(name = "handled", type = "object:org.apache.camel.model.ExpressionSubElementDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "on-exception-occurred-ref", type = "string"),
                    @YamlProperty(name = "on-redelivery-ref", type = "string"),
                    @YamlProperty(name = "on-when", type = "object:org.apache.camel.model.WhenDefinition"),
                    @YamlProperty(name = "redelivery-policy-ref", type = "string"),
                    @YamlProperty(name = "redelivery-policy", type = "object:org.apache.camel.model.RedeliveryPolicyDefinition"),
                    @YamlProperty(name = "retry-while", type = "object:org.apache.camel.model.ExpressionSubElementDefinition"),
                    @YamlProperty(name = "use-original-body", type = "boolean"),
                    @YamlProperty(name = "use-original-message", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class OnExceptionDefinitionDeserializer extends YamlDeserializerBase<OnExceptionDefinition> {
        public OnExceptionDefinitionDeserializer() {
            super(OnExceptionDefinition.class);
        }

        @Override
        protected OnExceptionDefinition newInstance() {
            return new OnExceptionDefinition();
        }

        @Override
        protected boolean setProperty(OnExceptionDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "continued": {
                    org.apache.camel.model.ExpressionSubElementDefinition val = asType(node, org.apache.camel.model.ExpressionSubElementDefinition.class);
                    target.setContinued(val);
                    break;
                }
                case "exception": {
                    java.util.List<String> val = asStringList(node);
                    target.setExceptions(val);
                    break;
                }
                case "handled": {
                    org.apache.camel.model.ExpressionSubElementDefinition val = asType(node, org.apache.camel.model.ExpressionSubElementDefinition.class);
                    target.setHandled(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "on-exception-occurred-ref": {
                    String val = asText(node);
                    target.setOnExceptionOccurredRef(val);
                    break;
                }
                case "on-redelivery-ref": {
                    String val = asText(node);
                    target.setOnRedeliveryRef(val);
                    break;
                }
                case "on-when": {
                    org.apache.camel.model.WhenDefinition val = asType(node, org.apache.camel.model.WhenDefinition.class);
                    target.setOnWhen(val);
                    break;
                }
                case "redelivery-policy-ref": {
                    String val = asText(node);
                    target.setRedeliveryPolicyRef(val);
                    break;
                }
                case "redelivery-policy": {
                    org.apache.camel.model.RedeliveryPolicyDefinition val = asType(node, org.apache.camel.model.RedeliveryPolicyDefinition.class);
                    target.setRedeliveryPolicyType(val);
                    break;
                }
                case "retry-while": {
                    org.apache.camel.model.ExpressionSubElementDefinition val = asType(node, org.apache.camel.model.ExpressionSubElementDefinition.class);
                    target.setRetryWhile(val);
                    break;
                }
                case "use-original-body": {
                    String val = asText(node);
                    target.setUseOriginalBody(val);
                    break;
                }
                case "use-original-message": {
                    String val = asText(node);
                    target.setUseOriginalMessage(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.OnFallbackDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "on-fallback",
            properties = {
                    @YamlProperty(name = "fallback-via-network", type = "boolean"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class OnFallbackDefinitionDeserializer extends YamlDeserializerBase<OnFallbackDefinition> {
        public OnFallbackDefinitionDeserializer() {
            super(OnFallbackDefinition.class);
        }

        @Override
        protected OnFallbackDefinition newInstance() {
            return new OnFallbackDefinition();
        }

        @Override
        protected boolean setProperty(OnFallbackDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "fallback-via-network": {
                    String val = asText(node);
                    target.setFallbackViaNetwork(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.OptimisticLockRetryPolicyDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "optimistic-lock-retry-policy",
            properties = {
                    @YamlProperty(name = "exponential-back-off", type = "boolean"),
                    @YamlProperty(name = "maximum-retries", type = "number"),
                    @YamlProperty(name = "maximum-retry-delay", type = "string"),
                    @YamlProperty(name = "random-back-off", type = "boolean"),
                    @YamlProperty(name = "retry-delay", type = "string")
            }
    )
    public static class OptimisticLockRetryPolicyDefinitionDeserializer extends YamlDeserializerBase<OptimisticLockRetryPolicyDefinition> {
        public OptimisticLockRetryPolicyDefinitionDeserializer() {
            super(OptimisticLockRetryPolicyDefinition.class);
        }

        @Override
        protected OptimisticLockRetryPolicyDefinition newInstance() {
            return new OptimisticLockRetryPolicyDefinition();
        }

        @Override
        protected boolean setProperty(OptimisticLockRetryPolicyDefinition target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "exponential-back-off": {
                    String val = asText(node);
                    target.setExponentialBackOff(val);
                    break;
                }
                case "maximum-retries": {
                    String val = asText(node);
                    target.setMaximumRetries(val);
                    break;
                }
                case "maximum-retry-delay": {
                    String val = asText(node);
                    target.setMaximumRetryDelay(val);
                    break;
                }
                case "random-back-off": {
                    String val = asText(node);
                    target.setRandomBackOff(val);
                    break;
                }
                case "retry-delay": {
                    String val = asText(node);
                    target.setRetryDelay(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.OtherwiseDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "otherwise",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class OtherwiseDefinitionDeserializer extends YamlDeserializerBase<OtherwiseDefinition> {
        public OtherwiseDefinitionDeserializer() {
            super(OtherwiseDefinition.class);
        }

        @Override
        protected OtherwiseDefinition newInstance() {
            return new OtherwiseDefinition();
        }

        @Override
        protected boolean setProperty(OtherwiseDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.OutputDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class OutputDefinitionDeserializer extends YamlDeserializerBase<OutputDefinition> {
        public OutputDefinitionDeserializer() {
            super(OutputDefinition.class);
        }

        @Override
        protected OutputDefinition newInstance() {
            return new OutputDefinition();
        }

        @Override
        protected boolean setProperty(OutputDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.OutputTypeDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "output-type",
            properties = {
                    @YamlProperty(name = "urn", type = "string", required = true),
                    @YamlProperty(name = "validate", type = "boolean")
            }
    )
    public static class OutputTypeDefinitionDeserializer extends YamlDeserializerBase<OutputTypeDefinition> {
        public OutputTypeDefinitionDeserializer() {
            super(OutputTypeDefinition.class);
        }

        @Override
        protected OutputTypeDefinition newInstance() {
            return new OutputTypeDefinition();
        }

        @Override
        protected boolean setProperty(OutputTypeDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "urn": {
                    String val = asText(node);
                    target.setUrn(val);
                    break;
                }
                case "validate": {
                    String val = asText(node);
                    target.setValidate(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.PGPDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "pgp",
            properties = {
                    @YamlProperty(name = "algorithm", type = "number"),
                    @YamlProperty(name = "armored", type = "boolean"),
                    @YamlProperty(name = "compression-algorithm", type = "number"),
                    @YamlProperty(name = "hash-algorithm", type = "number"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "integrity", type = "boolean"),
                    @YamlProperty(name = "key-file-name", type = "string"),
                    @YamlProperty(name = "key-userid", type = "string"),
                    @YamlProperty(name = "password", type = "string"),
                    @YamlProperty(name = "provider", type = "string"),
                    @YamlProperty(name = "signature-key-file-name", type = "string"),
                    @YamlProperty(name = "signature-key-ring", type = "string"),
                    @YamlProperty(name = "signature-key-userid", type = "string"),
                    @YamlProperty(name = "signature-password", type = "string"),
                    @YamlProperty(name = "signature-verification-option", type = "string")
            }
    )
    public static class PGPDataFormatDeserializer extends YamlDeserializerBase<PGPDataFormat> {
        public PGPDataFormatDeserializer() {
            super(PGPDataFormat.class);
        }

        @Override
        protected PGPDataFormat newInstance() {
            return new PGPDataFormat();
        }

        @Override
        protected boolean setProperty(PGPDataFormat target, String propertyKey, String propertyName,
                Node node) {
            switch(propertyKey) {
                case "algorithm": {
                    String val = asText(node);
                    target.setAlgorithm(val);
                    break;
                }
                case "armored": {
                    String val = asText(node);
                    target.setArmored(val);
                    break;
                }
                case "compression-algorithm": {
                    String val = asText(node);
                    target.setCompressionAlgorithm(val);
                    break;
                }
                case "hash-algorithm": {
                    String val = asText(node);
                    target.setHashAlgorithm(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "integrity": {
                    String val = asText(node);
                    target.setIntegrity(val);
                    break;
                }
                case "key-file-name": {
                    String val = asText(node);
                    target.setKeyFileName(val);
                    break;
                }
                case "key-userid": {
                    String val = asText(node);
                    target.setKeyUserid(val);
                    break;
                }
                case "password": {
                    String val = asText(node);
                    target.setPassword(val);
                    break;
                }
                case "provider": {
                    String val = asText(node);
                    target.setProvider(val);
                    break;
                }
                case "signature-key-file-name": {
                    String val = asText(node);
                    target.setSignatureKeyFileName(val);
                    break;
                }
                case "signature-key-ring": {
                    String val = asText(node);
                    target.setSignatureKeyRing(val);
                    break;
                }
                case "signature-key-userid": {
                    String val = asText(node);
                    target.setSignatureKeyUserid(val);
                    break;
                }
                case "signature-password": {
                    String val = asText(node);
                    target.setSignaturePassword(val);
                    break;
                }
                case "signature-verification-option": {
                    String val = asText(node);
                    target.setSignatureVerificationOption(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.PackageScanDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "package-scan",
            properties = {
                    @YamlProperty(name = "excludes", type = "array:string"),
                    @YamlProperty(name = "includes", type = "array:string"),
                    @YamlProperty(name = "package", type = "array:string")
            }
    )
    public static class PackageScanDefinitionDeserializer extends YamlDeserializerBase<PackageScanDefinition> {
        public PackageScanDefinitionDeserializer() {
            super(PackageScanDefinition.class);
        }

        @Override
        protected PackageScanDefinition newInstance() {
            return new PackageScanDefinition();
        }

        @Override
        protected boolean setProperty(PackageScanDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "excludes": {
                    java.util.List<String> val = asStringList(node);
                    target.setExcludes(val);
                    break;
                }
                case "includes": {
                    java.util.List<String> val = asStringList(node);
                    target.setIncludes(val);
                    break;
                }
                case "package": {
                    java.util.List<String> val = asStringList(node);
                    target.setPackages(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.PassThroughServiceCallServiceFilterConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "pass-through-service-filter",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition")
            }
    )
    public static class PassThroughServiceCallServiceFilterConfigurationDeserializer extends YamlDeserializerBase<PassThroughServiceCallServiceFilterConfiguration> {
        public PassThroughServiceCallServiceFilterConfigurationDeserializer() {
            super(PassThroughServiceCallServiceFilterConfiguration.class);
        }

        @Override
        protected PassThroughServiceCallServiceFilterConfiguration newInstance() {
            return new PassThroughServiceCallServiceFilterConfiguration();
        }

        @Override
        protected boolean setProperty(PassThroughServiceCallServiceFilterConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.PatchVerbDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "patch",
            properties = {
                    @YamlProperty(name = "api-docs", type = "string"),
                    @YamlProperty(name = "binding-mode", type = "string"),
                    @YamlProperty(name = "client-request-validation", type = "string"),
                    @YamlProperty(name = "consumes", type = "string"),
                    @YamlProperty(name = "enable-cors", type = "string"),
                    @YamlProperty(name = "method", type = "string"),
                    @YamlProperty(name = "out-type", type = "string"),
                    @YamlProperty(name = "params", type = "array:org.apache.camel.model.rest.RestOperationParamDefinition"),
                    @YamlProperty(name = "produces", type = "string"),
                    @YamlProperty(name = "response-msgs", type = "array:org.apache.camel.model.rest.RestOperationResponseMsgDefinition"),
                    @YamlProperty(name = "route-id", type = "string"),
                    @YamlProperty(name = "security", type = "array:org.apache.camel.model.rest.SecurityDefinition"),
                    @YamlProperty(name = "skip-binding-on-error-code", type = "string"),
                    @YamlProperty(name = "to", type = "object:org.apache.camel.model.ToDefinition"),
                    @YamlProperty(name = "to-d", type = "object:org.apache.camel.model.ToDynamicDefinition"),
                    @YamlProperty(name = "route", type = "object:org.apache.camel.model.RouteDefinition"),
                    @YamlProperty(name = "type", type = "string"),
                    @YamlProperty(name = "uri", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class PatchVerbDefinitionDeserializer extends YamlDeserializerBase<PatchVerbDefinition> {
        public PatchVerbDefinitionDeserializer() {
            super(PatchVerbDefinition.class);
        }

        @Override
        protected PatchVerbDefinition newInstance() {
            return new PatchVerbDefinition();
        }

        @Override
        protected boolean setProperty(PatchVerbDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "api-docs": {
                    String val = asText(node);
                    target.setApiDocs(val);
                    break;
                }
                case "binding-mode": {
                    String val = asText(node);
                    target.setBindingMode(val);
                    break;
                }
                case "client-request-validation": {
                    String val = asText(node);
                    target.setClientRequestValidation(val);
                    break;
                }
                case "consumes": {
                    String val = asText(node);
                    target.setConsumes(val);
                    break;
                }
                case "enable-cors": {
                    String val = asText(node);
                    target.setEnableCORS(val);
                    break;
                }
                case "method": {
                    String val = asText(node);
                    target.setMethod(val);
                    break;
                }
                case "out-type": {
                    String val = asText(node);
                    target.setOutType(val);
                    break;
                }
                case "param": {
                    java.util.List<org.apache.camel.model.rest.RestOperationParamDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationParamDefinition.class);
                    target.setParams(val);
                    break;
                }
                case "produces": {
                    String val = asText(node);
                    target.setProduces(val);
                    break;
                }
                case "response-message": {
                    java.util.List<org.apache.camel.model.rest.RestOperationResponseMsgDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationResponseMsgDefinition.class);
                    target.setResponseMsgs(val);
                    break;
                }
                case "route-id": {
                    String val = asText(node);
                    target.setRouteId(val);
                    break;
                }
                case "security": {
                    java.util.List<org.apache.camel.model.rest.SecurityDefinition> val = asFlatList(node, org.apache.camel.model.rest.SecurityDefinition.class);
                    target.setSecurity(val);
                    break;
                }
                case "skip-binding-on-error-code": {
                    String val = asText(node);
                    target.setSkipBindingOnErrorCode(val);
                    break;
                }
                case "to-or-route": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "to": {
                    org.apache.camel.model.ToDefinition val = asType(node, org.apache.camel.model.ToDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "to-d": {
                    org.apache.camel.model.ToDynamicDefinition val = asType(node, org.apache.camel.model.ToDynamicDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "route": {
                    org.apache.camel.model.RouteDefinition val = asType(node, org.apache.camel.model.RouteDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.PipelineDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "pipeline",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class PipelineDefinitionDeserializer extends YamlDeserializerBase<PipelineDefinition> {
        public PipelineDefinitionDeserializer() {
            super(PipelineDefinition.class);
        }

        @Override
        protected PipelineDefinition newInstance() {
            return new PipelineDefinition();
        }

        @Override
        protected boolean setProperty(PipelineDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.PolicyDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "policy",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "ref", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class PolicyDefinitionDeserializer extends YamlDeserializerBase<PolicyDefinition> {
        public PolicyDefinitionDeserializer() {
            super(PolicyDefinition.class);
        }

        @Override
        protected PolicyDefinition newInstance() {
            return new PolicyDefinition();
        }

        @Override
        protected boolean setProperty(PolicyDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.PollEnrichDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "poll-enrich",
            properties = {
                    @YamlProperty(name = "aggregate-on-exception", type = "boolean"),
                    @YamlProperty(name = "strategy-method-allow-null", type = "boolean"),
                    @YamlProperty(name = "strategy-method-name", type = "string"),
                    @YamlProperty(name = "strategy-ref", type = "string"),
                    @YamlProperty(name = "cache-size", type = "number"),
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "ignore-invalid-endpoint", type = "number"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "timeout", type = "string"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class PollEnrichDefinitionDeserializer extends YamlDeserializerBase<PollEnrichDefinition> {
        public PollEnrichDefinitionDeserializer() {
            super(PollEnrichDefinition.class);
        }

        @Override
        protected PollEnrichDefinition newInstance() {
            return new PollEnrichDefinition();
        }

        @Override
        protected boolean setProperty(PollEnrichDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "aggregate-on-exception": {
                    String val = asText(node);
                    target.setAggregateOnException(val);
                    break;
                }
                case "strategy-method-allow-null": {
                    String val = asText(node);
                    target.setAggregationStrategyMethodAllowNull(val);
                    break;
                }
                case "strategy-method-name": {
                    String val = asText(node);
                    target.setAggregationStrategyMethodName(val);
                    break;
                }
                case "strategy-ref": {
                    String val = asText(node);
                    target.setAggregationStrategyRef(val);
                    break;
                }
                case "cache-size": {
                    String val = asText(node);
                    target.setCacheSize(val);
                    break;
                }
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "ignore-invalid-endpoint": {
                    String val = asText(node);
                    target.setIgnoreInvalidEndpoint(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "timeout": {
                    String val = asText(node);
                    target.setTimeout(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.PostVerbDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "post",
            properties = {
                    @YamlProperty(name = "api-docs", type = "string"),
                    @YamlProperty(name = "binding-mode", type = "string"),
                    @YamlProperty(name = "client-request-validation", type = "string"),
                    @YamlProperty(name = "consumes", type = "string"),
                    @YamlProperty(name = "enable-cors", type = "string"),
                    @YamlProperty(name = "method", type = "string"),
                    @YamlProperty(name = "out-type", type = "string"),
                    @YamlProperty(name = "params", type = "array:org.apache.camel.model.rest.RestOperationParamDefinition"),
                    @YamlProperty(name = "produces", type = "string"),
                    @YamlProperty(name = "response-msgs", type = "array:org.apache.camel.model.rest.RestOperationResponseMsgDefinition"),
                    @YamlProperty(name = "route-id", type = "string"),
                    @YamlProperty(name = "security", type = "array:org.apache.camel.model.rest.SecurityDefinition"),
                    @YamlProperty(name = "skip-binding-on-error-code", type = "string"),
                    @YamlProperty(name = "to", type = "object:org.apache.camel.model.ToDefinition"),
                    @YamlProperty(name = "to-d", type = "object:org.apache.camel.model.ToDynamicDefinition"),
                    @YamlProperty(name = "route", type = "object:org.apache.camel.model.RouteDefinition"),
                    @YamlProperty(name = "type", type = "string"),
                    @YamlProperty(name = "uri", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class PostVerbDefinitionDeserializer extends YamlDeserializerBase<PostVerbDefinition> {
        public PostVerbDefinitionDeserializer() {
            super(PostVerbDefinition.class);
        }

        @Override
        protected PostVerbDefinition newInstance() {
            return new PostVerbDefinition();
        }

        @Override
        protected boolean setProperty(PostVerbDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "api-docs": {
                    String val = asText(node);
                    target.setApiDocs(val);
                    break;
                }
                case "binding-mode": {
                    String val = asText(node);
                    target.setBindingMode(val);
                    break;
                }
                case "client-request-validation": {
                    String val = asText(node);
                    target.setClientRequestValidation(val);
                    break;
                }
                case "consumes": {
                    String val = asText(node);
                    target.setConsumes(val);
                    break;
                }
                case "enable-cors": {
                    String val = asText(node);
                    target.setEnableCORS(val);
                    break;
                }
                case "method": {
                    String val = asText(node);
                    target.setMethod(val);
                    break;
                }
                case "out-type": {
                    String val = asText(node);
                    target.setOutType(val);
                    break;
                }
                case "param": {
                    java.util.List<org.apache.camel.model.rest.RestOperationParamDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationParamDefinition.class);
                    target.setParams(val);
                    break;
                }
                case "produces": {
                    String val = asText(node);
                    target.setProduces(val);
                    break;
                }
                case "response-message": {
                    java.util.List<org.apache.camel.model.rest.RestOperationResponseMsgDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationResponseMsgDefinition.class);
                    target.setResponseMsgs(val);
                    break;
                }
                case "route-id": {
                    String val = asText(node);
                    target.setRouteId(val);
                    break;
                }
                case "security": {
                    java.util.List<org.apache.camel.model.rest.SecurityDefinition> val = asFlatList(node, org.apache.camel.model.rest.SecurityDefinition.class);
                    target.setSecurity(val);
                    break;
                }
                case "skip-binding-on-error-code": {
                    String val = asText(node);
                    target.setSkipBindingOnErrorCode(val);
                    break;
                }
                case "to-or-route": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "to": {
                    org.apache.camel.model.ToDefinition val = asType(node, org.apache.camel.model.ToDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "to-d": {
                    org.apache.camel.model.ToDynamicDefinition val = asType(node, org.apache.camel.model.ToDynamicDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "route": {
                    org.apache.camel.model.RouteDefinition val = asType(node, org.apache.camel.model.RouteDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.validator.PredicateValidatorDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            properties = {
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "type", type = "string")
            }
    )
    public static class PredicateValidatorDefinitionDeserializer extends YamlDeserializerBase<PredicateValidatorDefinition> {
        public PredicateValidatorDefinitionDeserializer() {
            super(PredicateValidatorDefinition.class);
        }

        @Override
        protected PredicateValidatorDefinition newInstance() {
            return new PredicateValidatorDefinition();
        }

        @Override
        protected boolean setProperty(PredicateValidatorDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.ProcessDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "process",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "ref", type = "string")
            }
    )
    public static class ProcessDefinitionDeserializer extends YamlDeserializerBase<ProcessDefinition> {
        public ProcessDefinitionDeserializer() {
            super(ProcessDefinition.class);
        }

        @Override
        protected ProcessDefinition newInstance() {
            return new ProcessDefinition();
        }

        @Override
        protected boolean setProperty(ProcessDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.PropertyDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "property",
            properties = {
                    @YamlProperty(name = "key", type = "string"),
                    @YamlProperty(name = "value", type = "string")
            }
    )
    public static class PropertyDefinitionDeserializer extends YamlDeserializerBase<PropertyDefinition> {
        public PropertyDefinitionDeserializer() {
            super(PropertyDefinition.class);
        }

        @Override
        protected PropertyDefinition newInstance() {
            return new PropertyDefinition();
        }

        @Override
        protected boolean setProperty(PropertyDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "key": {
                    String val = asText(node);
                    target.setKey(val);
                    break;
                }
                case "value": {
                    String val = asText(node);
                    target.setValue(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.dataformat.ProtobufDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "protobuf",
            properties = {
                    @YamlProperty(name = "content-type-format", type = "string"),
                    @YamlProperty(name = "content-type-header", type = "boolean"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "instance-class", type = "string")
            }
    )
    public static class ProtobufDataFormatDeserializer extends YamlDeserializerBase<ProtobufDataFormat> {
        public ProtobufDataFormatDeserializer() {
            super(ProtobufDataFormat.class);
        }

        @Override
        protected ProtobufDataFormat newInstance() {
            return new ProtobufDataFormat();
        }

        @Override
        protected ProtobufDataFormat newInstance(String value) {
            return new ProtobufDataFormat(value);
        }

        @Override
        protected boolean setProperty(ProtobufDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "content-type-format": {
                    String val = asText(node);
                    target.setContentTypeFormat(val);
                    break;
                }
                case "content-type-header": {
                    String val = asText(node);
                    target.setContentTypeHeader(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "instance-class": {
                    String val = asText(node);
                    target.setInstanceClass(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.PutVerbDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "put",
            properties = {
                    @YamlProperty(name = "api-docs", type = "string"),
                    @YamlProperty(name = "binding-mode", type = "string"),
                    @YamlProperty(name = "client-request-validation", type = "string"),
                    @YamlProperty(name = "consumes", type = "string"),
                    @YamlProperty(name = "enable-cors", type = "string"),
                    @YamlProperty(name = "method", type = "string"),
                    @YamlProperty(name = "out-type", type = "string"),
                    @YamlProperty(name = "params", type = "array:org.apache.camel.model.rest.RestOperationParamDefinition"),
                    @YamlProperty(name = "produces", type = "string"),
                    @YamlProperty(name = "response-msgs", type = "array:org.apache.camel.model.rest.RestOperationResponseMsgDefinition"),
                    @YamlProperty(name = "route-id", type = "string"),
                    @YamlProperty(name = "security", type = "array:org.apache.camel.model.rest.SecurityDefinition"),
                    @YamlProperty(name = "skip-binding-on-error-code", type = "string"),
                    @YamlProperty(name = "to", type = "object:org.apache.camel.model.ToDefinition"),
                    @YamlProperty(name = "to-d", type = "object:org.apache.camel.model.ToDynamicDefinition"),
                    @YamlProperty(name = "route", type = "object:org.apache.camel.model.RouteDefinition"),
                    @YamlProperty(name = "type", type = "string"),
                    @YamlProperty(name = "uri", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class PutVerbDefinitionDeserializer extends YamlDeserializerBase<PutVerbDefinition> {
        public PutVerbDefinitionDeserializer() {
            super(PutVerbDefinition.class);
        }

        @Override
        protected PutVerbDefinition newInstance() {
            return new PutVerbDefinition();
        }

        @Override
        protected boolean setProperty(PutVerbDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "api-docs": {
                    String val = asText(node);
                    target.setApiDocs(val);
                    break;
                }
                case "binding-mode": {
                    String val = asText(node);
                    target.setBindingMode(val);
                    break;
                }
                case "client-request-validation": {
                    String val = asText(node);
                    target.setClientRequestValidation(val);
                    break;
                }
                case "consumes": {
                    String val = asText(node);
                    target.setConsumes(val);
                    break;
                }
                case "enable-cors": {
                    String val = asText(node);
                    target.setEnableCORS(val);
                    break;
                }
                case "method": {
                    String val = asText(node);
                    target.setMethod(val);
                    break;
                }
                case "out-type": {
                    String val = asText(node);
                    target.setOutType(val);
                    break;
                }
                case "param": {
                    java.util.List<org.apache.camel.model.rest.RestOperationParamDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationParamDefinition.class);
                    target.setParams(val);
                    break;
                }
                case "produces": {
                    String val = asText(node);
                    target.setProduces(val);
                    break;
                }
                case "response-message": {
                    java.util.List<org.apache.camel.model.rest.RestOperationResponseMsgDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationResponseMsgDefinition.class);
                    target.setResponseMsgs(val);
                    break;
                }
                case "route-id": {
                    String val = asText(node);
                    target.setRouteId(val);
                    break;
                }
                case "security": {
                    java.util.List<org.apache.camel.model.rest.SecurityDefinition> val = asFlatList(node, org.apache.camel.model.rest.SecurityDefinition.class);
                    target.setSecurity(val);
                    break;
                }
                case "skip-binding-on-error-code": {
                    String val = asText(node);
                    target.setSkipBindingOnErrorCode(val);
                    break;
                }
                case "to-or-route": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "to": {
                    org.apache.camel.model.ToDefinition val = asType(node, org.apache.camel.model.ToDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "to-d": {
                    org.apache.camel.model.ToDynamicDefinition val = asType(node, org.apache.camel.model.ToDynamicDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "route": {
                    org.apache.camel.model.RouteDefinition val = asType(node, org.apache.camel.model.RouteDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.loadbalancer.RandomLoadBalancerDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "random",
            properties = @YamlProperty(name = "id", type = "string")
    )
    public static class RandomLoadBalancerDefinitionDeserializer extends YamlDeserializerBase<RandomLoadBalancerDefinition> {
        public RandomLoadBalancerDefinitionDeserializer() {
            super(RandomLoadBalancerDefinition.class);
        }

        @Override
        protected RandomLoadBalancerDefinition newInstance() {
            return new RandomLoadBalancerDefinition();
        }

        @Override
        protected boolean setProperty(RandomLoadBalancerDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.RecipientListDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "recipient-list",
            properties = {
                    @YamlProperty(name = "cache-size", type = "number"),
                    @YamlProperty(name = "delimiter", type = "string"),
                    @YamlProperty(name = "executor-service-ref", type = "string"),
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "ignore-invalid-endpoints", type = "boolean"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "on-prepare-ref", type = "string"),
                    @YamlProperty(name = "parallel-aggregate", type = "boolean"),
                    @YamlProperty(name = "parallel-processing", type = "boolean"),
                    @YamlProperty(name = "share-unit-of-work", type = "boolean"),
                    @YamlProperty(name = "stop-on-aggregate-exception", type = "boolean"),
                    @YamlProperty(name = "stop-on-exception", type = "boolean"),
                    @YamlProperty(name = "strategy-method-allow-null", type = "boolean"),
                    @YamlProperty(name = "strategy-method-name", type = "string"),
                    @YamlProperty(name = "strategy-ref", type = "string"),
                    @YamlProperty(name = "streaming", type = "boolean"),
                    @YamlProperty(name = "timeout", type = "string"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class RecipientListDefinitionDeserializer extends YamlDeserializerBase<RecipientListDefinition> {
        public RecipientListDefinitionDeserializer() {
            super(RecipientListDefinition.class);
        }

        @Override
        protected RecipientListDefinition newInstance() {
            return new RecipientListDefinition();
        }

        @Override
        protected boolean setProperty(RecipientListDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "cache-size": {
                    String val = asText(node);
                    target.setCacheSize(val);
                    break;
                }
                case "delimiter": {
                    String val = asText(node);
                    target.setDelimiter(val);
                    break;
                }
                case "executor-service-ref": {
                    String val = asText(node);
                    target.setExecutorServiceRef(val);
                    break;
                }
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "ignore-invalid-endpoints": {
                    String val = asText(node);
                    target.setIgnoreInvalidEndpoints(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "on-prepare-ref": {
                    String val = asText(node);
                    target.setOnPrepareRef(val);
                    break;
                }
                case "parallel-aggregate": {
                    String val = asText(node);
                    target.setParallelAggregate(val);
                    break;
                }
                case "parallel-processing": {
                    String val = asText(node);
                    target.setParallelProcessing(val);
                    break;
                }
                case "share-unit-of-work": {
                    String val = asText(node);
                    target.setShareUnitOfWork(val);
                    break;
                }
                case "stop-on-aggregate-exception": {
                    String val = asText(node);
                    target.setStopOnAggregateException(val);
                    break;
                }
                case "stop-on-exception": {
                    String val = asText(node);
                    target.setStopOnException(val);
                    break;
                }
                case "strategy-method-allow-null": {
                    String val = asText(node);
                    target.setStrategyMethodAllowNull(val);
                    break;
                }
                case "strategy-method-name": {
                    String val = asText(node);
                    target.setStrategyMethodName(val);
                    break;
                }
                case "strategy-ref": {
                    String val = asText(node);
                    target.setStrategyRef(val);
                    break;
                }
                case "streaming": {
                    String val = asText(node);
                    target.setStreaming(val);
                    break;
                }
                case "timeout": {
                    String val = asText(node);
                    target.setTimeout(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.RedeliveryPolicyDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "redelivery-policy",
            properties = {
                    @YamlProperty(name = "allow-redelivery-while-stopping", type = "boolean"),
                    @YamlProperty(name = "async-delayed-redelivery", type = "boolean"),
                    @YamlProperty(name = "back-off-multiplier", type = "number"),
                    @YamlProperty(name = "collision-avoidance-factor", type = "number"),
                    @YamlProperty(name = "delay-pattern", type = "string"),
                    @YamlProperty(name = "disable-redelivery", type = "boolean"),
                    @YamlProperty(name = "exchange-formatter-ref", type = "string"),
                    @YamlProperty(name = "log-continued", type = "boolean"),
                    @YamlProperty(name = "log-exhausted", type = "boolean"),
                    @YamlProperty(name = "log-exhausted-message-body", type = "boolean"),
                    @YamlProperty(name = "log-exhausted-message-history", type = "boolean"),
                    @YamlProperty(name = "log-handled", type = "boolean"),
                    @YamlProperty(name = "log-new-exception", type = "boolean"),
                    @YamlProperty(name = "log-retry-attempted", type = "boolean"),
                    @YamlProperty(name = "log-retry-stack-trace", type = "boolean"),
                    @YamlProperty(name = "log-stack-trace", type = "boolean"),
                    @YamlProperty(name = "maximum-redeliveries", type = "number"),
                    @YamlProperty(name = "maximum-redelivery-delay", type = "string"),
                    @YamlProperty(name = "redelivery-delay", type = "string"),
                    @YamlProperty(name = "retries-exhausted-log-level", type = "string"),
                    @YamlProperty(name = "retry-attempted-log-interval", type = "number"),
                    @YamlProperty(name = "retry-attempted-log-level", type = "string"),
                    @YamlProperty(name = "use-collision-avoidance", type = "boolean"),
                    @YamlProperty(name = "use-exponential-back-off", type = "boolean")
            }
    )
    public static class RedeliveryPolicyDefinitionDeserializer extends YamlDeserializerBase<RedeliveryPolicyDefinition> {
        public RedeliveryPolicyDefinitionDeserializer() {
            super(RedeliveryPolicyDefinition.class);
        }

        @Override
        protected RedeliveryPolicyDefinition newInstance() {
            return new RedeliveryPolicyDefinition();
        }

        @Override
        protected boolean setProperty(RedeliveryPolicyDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-redelivery-while-stopping": {
                    String val = asText(node);
                    target.setAllowRedeliveryWhileStopping(val);
                    break;
                }
                case "async-delayed-redelivery": {
                    String val = asText(node);
                    target.setAsyncDelayedRedelivery(val);
                    break;
                }
                case "back-off-multiplier": {
                    String val = asText(node);
                    target.setBackOffMultiplier(val);
                    break;
                }
                case "collision-avoidance-factor": {
                    String val = asText(node);
                    target.setCollisionAvoidanceFactor(val);
                    break;
                }
                case "delay-pattern": {
                    String val = asText(node);
                    target.setDelayPattern(val);
                    break;
                }
                case "disable-redelivery": {
                    String val = asText(node);
                    target.setDisableRedelivery(val);
                    break;
                }
                case "exchange-formatter-ref": {
                    String val = asText(node);
                    target.setExchangeFormatterRef(val);
                    break;
                }
                case "log-continued": {
                    String val = asText(node);
                    target.setLogContinued(val);
                    break;
                }
                case "log-exhausted": {
                    String val = asText(node);
                    target.setLogExhausted(val);
                    break;
                }
                case "log-exhausted-message-body": {
                    String val = asText(node);
                    target.setLogExhaustedMessageBody(val);
                    break;
                }
                case "log-exhausted-message-history": {
                    String val = asText(node);
                    target.setLogExhaustedMessageHistory(val);
                    break;
                }
                case "log-handled": {
                    String val = asText(node);
                    target.setLogHandled(val);
                    break;
                }
                case "log-new-exception": {
                    String val = asText(node);
                    target.setLogNewException(val);
                    break;
                }
                case "log-retry-attempted": {
                    String val = asText(node);
                    target.setLogRetryAttempted(val);
                    break;
                }
                case "log-retry-stack-trace": {
                    String val = asText(node);
                    target.setLogRetryStackTrace(val);
                    break;
                }
                case "log-stack-trace": {
                    String val = asText(node);
                    target.setLogStackTrace(val);
                    break;
                }
                case "maximum-redeliveries": {
                    String val = asText(node);
                    target.setMaximumRedeliveries(val);
                    break;
                }
                case "maximum-redelivery-delay": {
                    String val = asText(node);
                    target.setMaximumRedeliveryDelay(val);
                    break;
                }
                case "redelivery-delay": {
                    String val = asText(node);
                    target.setRedeliveryDelay(val);
                    break;
                }
                case "retries-exhausted-log-level": {
                    String val = asText(node);
                    target.setRetriesExhaustedLogLevel(val);
                    break;
                }
                case "retry-attempted-log-interval": {
                    String val = asText(node);
                    target.setRetryAttemptedLogInterval(val);
                    break;
                }
                case "retry-attempted-log-level": {
                    String val = asText(node);
                    target.setRetryAttemptedLogLevel(val);
                    break;
                }
                case "use-collision-avoidance": {
                    String val = asText(node);
                    target.setUseCollisionAvoidance(val);
                    break;
                }
                case "use-exponential-back-off": {
                    String val = asText(node);
                    target.setUseExponentialBackOff(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.RefExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "ref",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class RefExpressionDeserializer extends YamlDeserializerBase<RefExpression> {
        public RefExpressionDeserializer() {
            super(RefExpression.class);
        }

        @Override
        protected RefExpression newInstance() {
            return new RefExpression();
        }

        @Override
        protected RefExpression newInstance(String value) {
            return new RefExpression(value);
        }

        @Override
        protected boolean setProperty(RefExpression target, String propertyKey, String propertyName,
                Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.RemoveHeaderDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "remove-header",
            properties = {
                    @YamlProperty(name = "header-name", type = "string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean")
            }
    )
    public static class RemoveHeaderDefinitionDeserializer extends YamlDeserializerBase<RemoveHeaderDefinition> {
        public RemoveHeaderDefinitionDeserializer() {
            super(RemoveHeaderDefinition.class);
        }

        @Override
        protected RemoveHeaderDefinition newInstance() {
            return new RemoveHeaderDefinition();
        }

        @Override
        protected RemoveHeaderDefinition newInstance(String value) {
            return new RemoveHeaderDefinition(value);
        }

        @Override
        protected boolean setProperty(RemoveHeaderDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "header-name": {
                    String val = asText(node);
                    target.setHeaderName(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.RemoveHeadersDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "remove-headers",
            properties = {
                    @YamlProperty(name = "exclude-pattern", type = "string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "pattern", type = "string")
            }
    )
    public static class RemoveHeadersDefinitionDeserializer extends YamlDeserializerBase<RemoveHeadersDefinition> {
        public RemoveHeadersDefinitionDeserializer() {
            super(RemoveHeadersDefinition.class);
        }

        @Override
        protected RemoveHeadersDefinition newInstance() {
            return new RemoveHeadersDefinition();
        }

        @Override
        protected RemoveHeadersDefinition newInstance(String value) {
            return new RemoveHeadersDefinition(value);
        }

        @Override
        protected boolean setProperty(RemoveHeadersDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "exclude-pattern": {
                    String val = asText(node);
                    target.setExcludePattern(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "pattern": {
                    String val = asText(node);
                    target.setPattern(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.RemovePropertiesDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "remove-properties",
            properties = {
                    @YamlProperty(name = "exclude-pattern", type = "string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "pattern", type = "string")
            }
    )
    public static class RemovePropertiesDefinitionDeserializer extends YamlDeserializerBase<RemovePropertiesDefinition> {
        public RemovePropertiesDefinitionDeserializer() {
            super(RemovePropertiesDefinition.class);
        }

        @Override
        protected RemovePropertiesDefinition newInstance() {
            return new RemovePropertiesDefinition();
        }

        @Override
        protected RemovePropertiesDefinition newInstance(String value) {
            return new RemovePropertiesDefinition(value);
        }

        @Override
        protected boolean setProperty(RemovePropertiesDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "exclude-pattern": {
                    String val = asText(node);
                    target.setExcludePattern(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "pattern": {
                    String val = asText(node);
                    target.setPattern(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.RemovePropertyDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "remove-property",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "property-name", type = "string")
            }
    )
    public static class RemovePropertyDefinitionDeserializer extends YamlDeserializerBase<RemovePropertyDefinition> {
        public RemovePropertyDefinitionDeserializer() {
            super(RemovePropertyDefinition.class);
        }

        @Override
        protected RemovePropertyDefinition newInstance() {
            return new RemovePropertyDefinition();
        }

        @Override
        protected RemovePropertyDefinition newInstance(String value) {
            return new RemovePropertyDefinition(value);
        }

        @Override
        protected boolean setProperty(RemovePropertyDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "property-name": {
                    String val = asText(node);
                    target.setPropertyName(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.ResequenceDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "resequence",
            properties = {
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition", required = true),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "batch-config", type = "object:org.apache.camel.model.config.BatchResequencerConfig"),
                    @YamlProperty(name = "stream-config", type = "object:org.apache.camel.model.config.StreamResequencerConfig"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class ResequenceDefinitionDeserializer extends YamlDeserializerBase<ResequenceDefinition> {
        public ResequenceDefinitionDeserializer() {
            super(ResequenceDefinition.class);
        }

        @Override
        protected ResequenceDefinition newInstance() {
            return new ResequenceDefinition();
        }

        @Override
        protected boolean setProperty(ResequenceDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "resequencer-config": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "batch-config": {
                    org.apache.camel.model.config.BatchResequencerConfig val = asType(node, org.apache.camel.model.config.BatchResequencerConfig.class);
                    target.setResequencerConfig(val);
                    break;
                }
                case "stream-config": {
                    org.apache.camel.model.config.StreamResequencerConfig val = asType(node, org.apache.camel.model.config.StreamResequencerConfig.class);
                    target.setResequencerConfig(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.Resilience4jConfigurationDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "resilience4j-configuration",
            properties = {
                    @YamlProperty(name = "automatic-transition-from-open-to-half-open-enabled", type = "boolean"),
                    @YamlProperty(name = "circuit-breaker-ref", type = "string"),
                    @YamlProperty(name = "config-ref", type = "string"),
                    @YamlProperty(name = "failure-rate-threshold", type = "number"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "minimum-number-of-calls", type = "number"),
                    @YamlProperty(name = "permitted-number-of-calls-in-half-open-state", type = "number"),
                    @YamlProperty(name = "sliding-window-size", type = "number"),
                    @YamlProperty(name = "sliding-window-type", type = "string"),
                    @YamlProperty(name = "slow-call-duration-threshold", type = "number"),
                    @YamlProperty(name = "slow-call-rate-threshold", type = "number"),
                    @YamlProperty(name = "wait-duration-in-open-state", type = "number"),
                    @YamlProperty(name = "writable-stack-trace-enabled", type = "boolean")
            }
    )
    public static class Resilience4jConfigurationDefinitionDeserializer extends YamlDeserializerBase<Resilience4jConfigurationDefinition> {
        public Resilience4jConfigurationDefinitionDeserializer() {
            super(Resilience4jConfigurationDefinition.class);
        }

        @Override
        protected Resilience4jConfigurationDefinition newInstance() {
            return new Resilience4jConfigurationDefinition();
        }

        @Override
        protected boolean setProperty(Resilience4jConfigurationDefinition target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "automatic-transition-from-open-to-half-open-enabled": {
                    String val = asText(node);
                    target.setAutomaticTransitionFromOpenToHalfOpenEnabled(val);
                    break;
                }
                case "circuit-breaker-ref": {
                    String val = asText(node);
                    target.setCircuitBreakerRef(val);
                    break;
                }
                case "config-ref": {
                    String val = asText(node);
                    target.setConfigRef(val);
                    break;
                }
                case "failure-rate-threshold": {
                    String val = asText(node);
                    target.setFailureRateThreshold(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "minimum-number-of-calls": {
                    String val = asText(node);
                    target.setMinimumNumberOfCalls(val);
                    break;
                }
                case "permitted-number-of-calls-in-half-open-state": {
                    String val = asText(node);
                    target.setPermittedNumberOfCallsInHalfOpenState(val);
                    break;
                }
                case "sliding-window-size": {
                    String val = asText(node);
                    target.setSlidingWindowSize(val);
                    break;
                }
                case "sliding-window-type": {
                    String val = asText(node);
                    target.setSlidingWindowType(val);
                    break;
                }
                case "slow-call-duration-threshold": {
                    String val = asText(node);
                    target.setSlowCallDurationThreshold(val);
                    break;
                }
                case "slow-call-rate-threshold": {
                    String val = asText(node);
                    target.setSlowCallRateThreshold(val);
                    break;
                }
                case "wait-duration-in-open-state": {
                    String val = asText(node);
                    target.setWaitDurationInOpenState(val);
                    break;
                }
                case "writable-stack-trace-enabled": {
                    String val = asText(node);
                    target.setWritableStackTraceEnabled(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.RestBindingDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "rest-binding",
            properties = {
                    @YamlProperty(name = "binding-mode", type = "string"),
                    @YamlProperty(name = "client-request-validation", type = "string"),
                    @YamlProperty(name = "component", type = "string"),
                    @YamlProperty(name = "consumes", type = "string"),
                    @YamlProperty(name = "enable-cors", type = "string"),
                    @YamlProperty(name = "out-type", type = "string"),
                    @YamlProperty(name = "produces", type = "string"),
                    @YamlProperty(name = "skip-binding-on-error-code", type = "string"),
                    @YamlProperty(name = "type", type = "string")
            }
    )
    public static class RestBindingDefinitionDeserializer extends YamlDeserializerBase<RestBindingDefinition> {
        public RestBindingDefinitionDeserializer() {
            super(RestBindingDefinition.class);
        }

        @Override
        protected RestBindingDefinition newInstance() {
            return new RestBindingDefinition();
        }

        @Override
        protected boolean setProperty(RestBindingDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "binding-mode": {
                    String val = asText(node);
                    target.setBindingMode(val);
                    break;
                }
                case "client-request-validation": {
                    String val = asText(node);
                    target.setClientRequestValidation(val);
                    break;
                }
                case "component": {
                    String val = asText(node);
                    target.setComponent(val);
                    break;
                }
                case "consumes": {
                    String val = asText(node);
                    target.setConsumes(val);
                    break;
                }
                case "enable-cors": {
                    String val = asText(node);
                    target.setEnableCORS(val);
                    break;
                }
                case "out-type": {
                    String val = asText(node);
                    target.setOutType(val);
                    break;
                }
                case "produces": {
                    String val = asText(node);
                    target.setProduces(val);
                    break;
                }
                case "skip-binding-on-error-code": {
                    String val = asText(node);
                    target.setSkipBindingOnErrorCode(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.RestConfigurationDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "rest-configuration",
            properties = {
                    @YamlProperty(name = "api-component", type = "string"),
                    @YamlProperty(name = "api-context-id-pattern", type = "string"),
                    @YamlProperty(name = "api-context-listing", type = "boolean"),
                    @YamlProperty(name = "api-context-path", type = "string"),
                    @YamlProperty(name = "api-context-route-id", type = "string"),
                    @YamlProperty(name = "api-host", type = "string"),
                    @YamlProperty(name = "api-property", type = "array:org.apache.camel.model.rest.RestPropertyDefinition"),
                    @YamlProperty(name = "api-vendor-extension", type = "boolean"),
                    @YamlProperty(name = "binding-mode", type = "enum:auto,json,json_xml,off,xml"),
                    @YamlProperty(name = "client-request-validation", type = "boolean"),
                    @YamlProperty(name = "component", type = "string"),
                    @YamlProperty(name = "component-property", type = "array:org.apache.camel.model.rest.RestPropertyDefinition"),
                    @YamlProperty(name = "consumer-property", type = "array:org.apache.camel.model.rest.RestPropertyDefinition"),
                    @YamlProperty(name = "context-path", type = "string"),
                    @YamlProperty(name = "cors-headers", type = "array:org.apache.camel.model.rest.RestPropertyDefinition"),
                    @YamlProperty(name = "data-format-property", type = "array:org.apache.camel.model.rest.RestPropertyDefinition"),
                    @YamlProperty(name = "enable-cors", type = "boolean"),
                    @YamlProperty(name = "endpoint-property", type = "array:org.apache.camel.model.rest.RestPropertyDefinition"),
                    @YamlProperty(name = "host", type = "string"),
                    @YamlProperty(name = "host-name-resolver", type = "enum:allLocalIp,localHostName,localIp"),
                    @YamlProperty(name = "json-data-format", type = "string"),
                    @YamlProperty(name = "port", type = "string"),
                    @YamlProperty(name = "producer-api-doc", type = "string"),
                    @YamlProperty(name = "producer-component", type = "string"),
                    @YamlProperty(name = "scheme", type = "string"),
                    @YamlProperty(name = "skip-binding-on-error-code", type = "boolean"),
                    @YamlProperty(name = "use-x-forward-headers", type = "boolean"),
                    @YamlProperty(name = "xml-data-format", type = "string")
            }
    )
    public static class RestConfigurationDefinitionDeserializer extends YamlDeserializerBase<RestConfigurationDefinition> {
        public RestConfigurationDefinitionDeserializer() {
            super(RestConfigurationDefinition.class);
        }

        @Override
        protected RestConfigurationDefinition newInstance() {
            return new RestConfigurationDefinition();
        }

        @Override
        protected boolean setProperty(RestConfigurationDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "api-component": {
                    String val = asText(node);
                    target.setApiComponent(val);
                    break;
                }
                case "api-context-id-pattern": {
                    String val = asText(node);
                    target.setApiContextIdPattern(val);
                    break;
                }
                case "api-context-listing": {
                    String val = asText(node);
                    target.setApiContextListing(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "api-context-path": {
                    String val = asText(node);
                    target.setApiContextPath(val);
                    break;
                }
                case "api-context-route-id": {
                    String val = asText(node);
                    target.setApiContextRouteId(val);
                    break;
                }
                case "api-host": {
                    String val = asText(node);
                    target.setApiHost(val);
                    break;
                }
                case "api-property": {
                    java.util.List<org.apache.camel.model.rest.RestPropertyDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestPropertyDefinition.class);
                    target.setApiProperties(val);
                    break;
                }
                case "api-vendor-extension": {
                    String val = asText(node);
                    target.setApiVendorExtension(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "binding-mode": {
                    target.setBindingMode(org.apache.camel.model.rest.RestBindingMode.valueOf(asText(node)));
                    break;
                }
                case "client-request-validation": {
                    String val = asText(node);
                    target.setClientRequestValidation(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "component": {
                    String val = asText(node);
                    target.setComponent(val);
                    break;
                }
                case "component-property": {
                    java.util.List<org.apache.camel.model.rest.RestPropertyDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestPropertyDefinition.class);
                    target.setComponentProperties(val);
                    break;
                }
                case "consumer-property": {
                    java.util.List<org.apache.camel.model.rest.RestPropertyDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestPropertyDefinition.class);
                    target.setConsumerProperties(val);
                    break;
                }
                case "context-path": {
                    String val = asText(node);
                    target.setContextPath(val);
                    break;
                }
                case "cors-headers": {
                    java.util.List<org.apache.camel.model.rest.RestPropertyDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestPropertyDefinition.class);
                    target.setCorsHeaders(val);
                    break;
                }
                case "data-format-property": {
                    java.util.List<org.apache.camel.model.rest.RestPropertyDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestPropertyDefinition.class);
                    target.setDataFormatProperties(val);
                    break;
                }
                case "enable-cors": {
                    String val = asText(node);
                    target.setEnableCORS(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "endpoint-property": {
                    java.util.List<org.apache.camel.model.rest.RestPropertyDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestPropertyDefinition.class);
                    target.setEndpointProperties(val);
                    break;
                }
                case "host": {
                    String val = asText(node);
                    target.setHost(val);
                    break;
                }
                case "host-name-resolver": {
                    target.setHostNameResolver(org.apache.camel.model.rest.RestHostNameResolver.valueOf(asText(node)));
                    break;
                }
                case "json-data-format": {
                    String val = asText(node);
                    target.setJsonDataFormat(val);
                    break;
                }
                case "port": {
                    String val = asText(node);
                    target.setPort(val);
                    break;
                }
                case "producer-api-doc": {
                    String val = asText(node);
                    target.setProducerApiDoc(val);
                    break;
                }
                case "producer-component": {
                    String val = asText(node);
                    target.setProducerComponent(val);
                    break;
                }
                case "scheme": {
                    String val = asText(node);
                    target.setScheme(val);
                    break;
                }
                case "skip-binding-on-error-code": {
                    String val = asText(node);
                    target.setSkipBindingOnErrorCode(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "use-x-forward-headers": {
                    String val = asText(node);
                    target.setUseXForwardHeaders(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "xml-data-format": {
                    String val = asText(node);
                    target.setXmlDataFormat(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.RestContextRefDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "rest-context-ref",
            properties = @YamlProperty(name = "ref", type = "string")
    )
    public static class RestContextRefDefinitionDeserializer extends YamlDeserializerBase<RestContextRefDefinition> {
        public RestContextRefDefinitionDeserializer() {
            super(RestContextRefDefinition.class);
        }

        @Override
        protected RestContextRefDefinition newInstance() {
            return new RestContextRefDefinition();
        }

        @Override
        protected boolean setProperty(RestContextRefDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlIn
    @YamlType(
            types = org.apache.camel.model.rest.RestDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "rest",
            properties = {
                    @YamlProperty(name = "api-docs", type = "string"),
                    @YamlProperty(name = "binding-mode", type = "string"),
                    @YamlProperty(name = "client-request-validation", type = "string"),
                    @YamlProperty(name = "consumes", type = "string"),
                    @YamlProperty(name = "enable-cors", type = "string"),
                    @YamlProperty(name = "path", type = "string"),
                    @YamlProperty(name = "produces", type = "string"),
                    @YamlProperty(name = "security-definitions", type = "object:org.apache.camel.model.rest.RestSecuritiesDefinition"),
                    @YamlProperty(name = "skip-binding-on-error-code", type = "string"),
                    @YamlProperty(name = "tag", type = "string"),
                    @YamlProperty(name = "verbs", type = "array:org.apache.camel.model.rest.VerbDefinition")
            }
    )
    public static class RestDefinitionDeserializer extends YamlDeserializerBase<RestDefinition> {
        public RestDefinitionDeserializer() {
            super(RestDefinition.class);
        }

        @Override
        protected RestDefinition newInstance() {
            return new RestDefinition();
        }

        @Override
        protected boolean setProperty(RestDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "api-docs": {
                    String val = asText(node);
                    target.setApiDocs(val);
                    break;
                }
                case "binding-mode": {
                    String val = asText(node);
                    target.setBindingMode(val);
                    break;
                }
                case "client-request-validation": {
                    String val = asText(node);
                    target.setClientRequestValidation(val);
                    break;
                }
                case "consumes": {
                    String val = asText(node);
                    target.setConsumes(val);
                    break;
                }
                case "enable-cors": {
                    String val = asText(node);
                    target.setEnableCORS(val);
                    break;
                }
                case "path": {
                    String val = asText(node);
                    target.setPath(val);
                    break;
                }
                case "produces": {
                    String val = asText(node);
                    target.setProduces(val);
                    break;
                }
                case "security-definitions": {
                    org.apache.camel.model.rest.RestSecuritiesDefinition val = asType(node, org.apache.camel.model.rest.RestSecuritiesDefinition.class);
                    target.setSecurityDefinitions(val);
                    break;
                }
                case "skip-binding-on-error-code": {
                    String val = asText(node);
                    target.setSkipBindingOnErrorCode(val);
                    break;
                }
                case "tag": {
                    String val = asText(node);
                    target.setTag(val);
                    break;
                }
                case "verb": {
                    java.util.List<org.apache.camel.model.rest.VerbDefinition> val = asFlatList(node, org.apache.camel.model.rest.VerbDefinition.class);
                    target.setVerbs(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.RestOperationParamDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "param",
            properties = {
                    @YamlProperty(name = "value", type = "array:string"),
                    @YamlProperty(name = "array-type", type = "string"),
                    @YamlProperty(name = "collection-format", type = "enum:csv,multi,pipes,ssv,tsv"),
                    @YamlProperty(name = "data-format", type = "string"),
                    @YamlProperty(name = "data-type", type = "string"),
                    @YamlProperty(name = "default-value", type = "string"),
                    @YamlProperty(name = "description", type = "string"),
                    @YamlProperty(name = "examples", type = "array:org.apache.camel.model.rest.RestPropertyDefinition"),
                    @YamlProperty(name = "name", type = "string"),
                    @YamlProperty(name = "required", type = "boolean"),
                    @YamlProperty(name = "type", type = "enum:body,formData,header,path,query")
            }
    )
    public static class RestOperationParamDefinitionDeserializer extends YamlDeserializerBase<RestOperationParamDefinition> {
        public RestOperationParamDefinitionDeserializer() {
            super(RestOperationParamDefinition.class);
        }

        @Override
        protected RestOperationParamDefinition newInstance() {
            return new RestOperationParamDefinition();
        }

        @Override
        protected boolean setProperty(RestOperationParamDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "value": {
                    java.util.List<String> val = asStringList(node);
                    target.setAllowableValues(val);
                    break;
                }
                case "array-type": {
                    String val = asText(node);
                    target.setArrayType(val);
                    break;
                }
                case "collection-format": {
                    target.setCollectionFormat(org.apache.camel.model.rest.CollectionFormat.valueOf(asText(node)));
                    break;
                }
                case "data-format": {
                    String val = asText(node);
                    target.setDataFormat(val);
                    break;
                }
                case "data-type": {
                    String val = asText(node);
                    target.setDataType(val);
                    break;
                }
                case "default-value": {
                    String val = asText(node);
                    target.setDefaultValue(val);
                    break;
                }
                case "description": {
                    String val = asText(node);
                    target.setDescription(val);
                    break;
                }
                case "examples": {
                    java.util.List<org.apache.camel.model.rest.RestPropertyDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestPropertyDefinition.class);
                    target.setExamples(val);
                    break;
                }
                case "name": {
                    String val = asText(node);
                    target.setName(val);
                    break;
                }
                case "required": {
                    String val = asText(node);
                    target.setRequired(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "type": {
                    target.setType(org.apache.camel.model.rest.RestParamType.valueOf(asText(node)));
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.RestOperationResponseHeaderDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "response-header",
            properties = {
                    @YamlProperty(name = "value", type = "array:string"),
                    @YamlProperty(name = "array-type", type = "string"),
                    @YamlProperty(name = "collection-format", type = "enum:csv,multi,pipes,ssv,tsv"),
                    @YamlProperty(name = "data-format", type = "string"),
                    @YamlProperty(name = "data-type", type = "string"),
                    @YamlProperty(name = "description", type = "string"),
                    @YamlProperty(name = "example", type = "string"),
                    @YamlProperty(name = "name", type = "string")
            }
    )
    public static class RestOperationResponseHeaderDefinitionDeserializer extends YamlDeserializerBase<RestOperationResponseHeaderDefinition> {
        public RestOperationResponseHeaderDefinitionDeserializer() {
            super(RestOperationResponseHeaderDefinition.class);
        }

        @Override
        protected RestOperationResponseHeaderDefinition newInstance() {
            return new RestOperationResponseHeaderDefinition();
        }

        @Override
        protected boolean setProperty(RestOperationResponseHeaderDefinition target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "value": {
                    java.util.List<String> val = asStringList(node);
                    target.setAllowableValues(val);
                    break;
                }
                case "array-type": {
                    String val = asText(node);
                    target.setArrayType(val);
                    break;
                }
                case "collection-format": {
                    target.setCollectionFormat(org.apache.camel.model.rest.CollectionFormat.valueOf(asText(node)));
                    break;
                }
                case "data-format": {
                    String val = asText(node);
                    target.setDataFormat(val);
                    break;
                }
                case "data-type": {
                    String val = asText(node);
                    target.setDataType(val);
                    break;
                }
                case "description": {
                    String val = asText(node);
                    target.setDescription(val);
                    break;
                }
                case "example": {
                    String val = asText(node);
                    target.setExample(val);
                    break;
                }
                case "name": {
                    String val = asText(node);
                    target.setName(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.RestOperationResponseMsgDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "response-message",
            properties = {
                    @YamlProperty(name = "code", type = "string"),
                    @YamlProperty(name = "examples", type = "array:org.apache.camel.model.rest.RestPropertyDefinition"),
                    @YamlProperty(name = "header", type = "array:org.apache.camel.model.rest.RestOperationResponseHeaderDefinition"),
                    @YamlProperty(name = "message", type = "string"),
                    @YamlProperty(name = "response-model", type = "string")
            }
    )
    public static class RestOperationResponseMsgDefinitionDeserializer extends YamlDeserializerBase<RestOperationResponseMsgDefinition> {
        public RestOperationResponseMsgDefinitionDeserializer() {
            super(RestOperationResponseMsgDefinition.class);
        }

        @Override
        protected RestOperationResponseMsgDefinition newInstance() {
            return new RestOperationResponseMsgDefinition();
        }

        @Override
        protected boolean setProperty(RestOperationResponseMsgDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "code": {
                    String val = asText(node);
                    target.setCode(val);
                    break;
                }
                case "examples": {
                    java.util.List<org.apache.camel.model.rest.RestPropertyDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestPropertyDefinition.class);
                    target.setExamples(val);
                    break;
                }
                case "header": {
                    java.util.List<org.apache.camel.model.rest.RestOperationResponseHeaderDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationResponseHeaderDefinition.class);
                    target.setHeaders(val);
                    break;
                }
                case "message": {
                    String val = asText(node);
                    target.setMessage(val);
                    break;
                }
                case "response-model": {
                    String val = asText(node);
                    target.setResponseModel(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.RestPropertyDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "rest-property",
            properties = {
                    @YamlProperty(name = "key", type = "string"),
                    @YamlProperty(name = "value", type = "string")
            }
    )
    public static class RestPropertyDefinitionDeserializer extends YamlDeserializerBase<RestPropertyDefinition> {
        public RestPropertyDefinitionDeserializer() {
            super(RestPropertyDefinition.class);
        }

        @Override
        protected RestPropertyDefinition newInstance() {
            return new RestPropertyDefinition();
        }

        @Override
        protected boolean setProperty(RestPropertyDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "key": {
                    String val = asText(node);
                    target.setKey(val);
                    break;
                }
                case "value": {
                    String val = asText(node);
                    target.setValue(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.RestSecuritiesDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "security-definitions",
            properties = {
                    @YamlProperty(name = "api-key", type = "object:org.apache.camel.model.rest.RestSecurityApiKey"),
                    @YamlProperty(name = "basic-auth", type = "object:org.apache.camel.model.rest.RestSecurityBasicAuth"),
                    @YamlProperty(name = "oauth2", type = "object:org.apache.camel.model.rest.RestSecurityOAuth2")
            }
    )
    public static class RestSecuritiesDefinitionDeserializer extends YamlDeserializerBase<RestSecuritiesDefinition> {
        public RestSecuritiesDefinitionDeserializer() {
            super(RestSecuritiesDefinition.class);
        }

        @Override
        protected RestSecuritiesDefinition newInstance() {
            return new RestSecuritiesDefinition();
        }

        @Override
        protected boolean setProperty(RestSecuritiesDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "security-definitions": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "api-key": {
                    org.apache.camel.model.rest.RestSecurityApiKey val = asType(node, org.apache.camel.model.rest.RestSecurityApiKey.class);
                    java.util.List<org.apache.camel.model.rest.RestSecurityDefinition> existing = target.getSecurityDefinitions();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setSecurityDefinitions(existing);
                    break;
                }
                case "basic-auth": {
                    org.apache.camel.model.rest.RestSecurityBasicAuth val = asType(node, org.apache.camel.model.rest.RestSecurityBasicAuth.class);
                    java.util.List<org.apache.camel.model.rest.RestSecurityDefinition> existing = target.getSecurityDefinitions();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setSecurityDefinitions(existing);
                    break;
                }
                case "oauth2": {
                    org.apache.camel.model.rest.RestSecurityOAuth2 val = asType(node, org.apache.camel.model.rest.RestSecurityOAuth2.class);
                    java.util.List<org.apache.camel.model.rest.RestSecurityDefinition> existing = target.getSecurityDefinitions();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setSecurityDefinitions(existing);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.RestSecurityApiKey.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "api-key",
            properties = {
                    @YamlProperty(name = "description", type = "string"),
                    @YamlProperty(name = "in-header", type = "boolean"),
                    @YamlProperty(name = "in-query", type = "boolean"),
                    @YamlProperty(name = "key", type = "string", required = true),
                    @YamlProperty(name = "name", type = "string", required = true)
            }
    )
    public static class RestSecurityApiKeyDeserializer extends YamlDeserializerBase<RestSecurityApiKey> {
        public RestSecurityApiKeyDeserializer() {
            super(RestSecurityApiKey.class);
        }

        @Override
        protected RestSecurityApiKey newInstance() {
            return new RestSecurityApiKey();
        }

        @Override
        protected boolean setProperty(RestSecurityApiKey target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "description": {
                    String val = asText(node);
                    target.setDescription(val);
                    break;
                }
                case "in-header": {
                    String val = asText(node);
                    target.setInHeader(val);
                    break;
                }
                case "in-query": {
                    String val = asText(node);
                    target.setInQuery(val);
                    break;
                }
                case "key": {
                    String val = asText(node);
                    target.setKey(val);
                    break;
                }
                case "name": {
                    String val = asText(node);
                    target.setName(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.RestSecurityBasicAuth.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "basic-auth",
            properties = {
                    @YamlProperty(name = "description", type = "string"),
                    @YamlProperty(name = "key", type = "string", required = true)
            }
    )
    public static class RestSecurityBasicAuthDeserializer extends YamlDeserializerBase<RestSecurityBasicAuth> {
        public RestSecurityBasicAuthDeserializer() {
            super(RestSecurityBasicAuth.class);
        }

        @Override
        protected RestSecurityBasicAuth newInstance() {
            return new RestSecurityBasicAuth();
        }

        @Override
        protected boolean setProperty(RestSecurityBasicAuth target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "description": {
                    String val = asText(node);
                    target.setDescription(val);
                    break;
                }
                case "key": {
                    String val = asText(node);
                    target.setKey(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.RestSecurityOAuth2.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "oauth2",
            properties = {
                    @YamlProperty(name = "authorization-url", type = "string"),
                    @YamlProperty(name = "description", type = "string"),
                    @YamlProperty(name = "flow", type = "string"),
                    @YamlProperty(name = "key", type = "string", required = true),
                    @YamlProperty(name = "scopes", type = "array:org.apache.camel.model.rest.RestPropertyDefinition"),
                    @YamlProperty(name = "token-url", type = "string")
            }
    )
    public static class RestSecurityOAuth2Deserializer extends YamlDeserializerBase<RestSecurityOAuth2> {
        public RestSecurityOAuth2Deserializer() {
            super(RestSecurityOAuth2.class);
        }

        @Override
        protected RestSecurityOAuth2 newInstance() {
            return new RestSecurityOAuth2();
        }

        @Override
        protected boolean setProperty(RestSecurityOAuth2 target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "authorization-url": {
                    String val = asText(node);
                    target.setAuthorizationUrl(val);
                    break;
                }
                case "description": {
                    String val = asText(node);
                    target.setDescription(val);
                    break;
                }
                case "flow": {
                    String val = asText(node);
                    target.setFlow(val);
                    break;
                }
                case "key": {
                    String val = asText(node);
                    target.setKey(val);
                    break;
                }
                case "scopes": {
                    java.util.List<org.apache.camel.model.rest.RestPropertyDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestPropertyDefinition.class);
                    target.setScopes(val);
                    break;
                }
                case "token-url": {
                    String val = asText(node);
                    target.setTokenUrl(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.RestsDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "rests",
            properties = @YamlProperty(name = "rests", type = "array:org.apache.camel.model.rest.RestDefinition")
    )
    public static class RestsDefinitionDeserializer extends YamlDeserializerBase<RestsDefinition> {
        public RestsDefinitionDeserializer() {
            super(RestsDefinition.class);
        }

        @Override
        protected RestsDefinition newInstance() {
            return new RestsDefinition();
        }

        @Override
        protected boolean setProperty(RestsDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "rest": {
                    java.util.List<org.apache.camel.model.rest.RestDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestDefinition.class);
                    target.setRests(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.RibbonServiceCallServiceLoadBalancerConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "ribbon-load-balancer",
            properties = {
                    @YamlProperty(name = "client-name", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "namespace", type = "string"),
                    @YamlProperty(name = "password", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "username", type = "string")
            }
    )
    public static class RibbonServiceCallServiceLoadBalancerConfigurationDeserializer extends YamlDeserializerBase<RibbonServiceCallServiceLoadBalancerConfiguration> {
        public RibbonServiceCallServiceLoadBalancerConfigurationDeserializer() {
            super(RibbonServiceCallServiceLoadBalancerConfiguration.class);
        }

        @Override
        protected RibbonServiceCallServiceLoadBalancerConfiguration newInstance() {
            return new RibbonServiceCallServiceLoadBalancerConfiguration();
        }

        @Override
        protected boolean setProperty(RibbonServiceCallServiceLoadBalancerConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "client-name": {
                    String val = asText(node);
                    target.setClientName(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "namespace": {
                    String val = asText(node);
                    target.setNamespace(val);
                    break;
                }
                case "password": {
                    String val = asText(node);
                    target.setPassword(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                case "username": {
                    String val = asText(node);
                    target.setUsername(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.RollbackDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "rollback",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "mark-rollback-only", type = "boolean"),
                    @YamlProperty(name = "mark-rollback-only-last", type = "boolean"),
                    @YamlProperty(name = "message", type = "string")
            }
    )
    public static class RollbackDefinitionDeserializer extends YamlDeserializerBase<RollbackDefinition> {
        public RollbackDefinitionDeserializer() {
            super(RollbackDefinition.class);
        }

        @Override
        protected RollbackDefinition newInstance() {
            return new RollbackDefinition();
        }

        @Override
        protected RollbackDefinition newInstance(String value) {
            return new RollbackDefinition(value);
        }

        @Override
        protected boolean setProperty(RollbackDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "mark-rollback-only": {
                    String val = asText(node);
                    target.setMarkRollbackOnly(val);
                    break;
                }
                case "mark-rollback-only-last": {
                    String val = asText(node);
                    target.setMarkRollbackOnlyLast(val);
                    break;
                }
                case "message": {
                    String val = asText(node);
                    target.setMessage(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.loadbalancer.RoundRobinLoadBalancerDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "round-robin",
            properties = @YamlProperty(name = "id", type = "string")
    )
    public static class RoundRobinLoadBalancerDefinitionDeserializer extends YamlDeserializerBase<RoundRobinLoadBalancerDefinition> {
        public RoundRobinLoadBalancerDefinitionDeserializer() {
            super(RoundRobinLoadBalancerDefinition.class);
        }

        @Override
        protected RoundRobinLoadBalancerDefinition newInstance() {
            return new RoundRobinLoadBalancerDefinition();
        }

        @Override
        protected boolean setProperty(RoundRobinLoadBalancerDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.RouteBuilderDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "route-builder",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "ref", type = "string")
            }
    )
    public static class RouteBuilderDefinitionDeserializer extends YamlDeserializerBase<RouteBuilderDefinition> {
        public RouteBuilderDefinitionDeserializer() {
            super(RouteBuilderDefinition.class);
        }

        @Override
        protected RouteBuilderDefinition newInstance() {
            return new RouteBuilderDefinition();
        }

        @Override
        protected RouteBuilderDefinition newInstance(String value) {
            return new RouteBuilderDefinition(value);
        }

        @Override
        protected boolean setProperty(RouteBuilderDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.RouteContextRefDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "route-context-ref",
            properties = @YamlProperty(name = "ref", type = "string")
    )
    public static class RouteContextRefDefinitionDeserializer extends YamlDeserializerBase<RouteContextRefDefinition> {
        public RouteContextRefDefinitionDeserializer() {
            super(RouteContextRefDefinition.class);
        }

        @Override
        protected RouteContextRefDefinition newInstance() {
            return new RouteContextRefDefinition();
        }

        @Override
        protected boolean setProperty(RouteContextRefDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.RouteDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "route",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class RouteDefinitionDeserializer extends YamlDeserializerBase<RouteDefinition> {
        public RouteDefinitionDeserializer() {
            super(RouteDefinition.class);
        }

        @Override
        protected RouteDefinition newInstance() {
            return new RouteDefinition();
        }

        @Override
        protected RouteDefinition newInstance(String value) {
            return new RouteDefinition(value);
        }

        @Override
        protected boolean setProperty(RouteDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.RouteTemplateContextRefDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "route-template-context-ref",
            properties = @YamlProperty(name = "ref", type = "string")
    )
    public static class RouteTemplateContextRefDefinitionDeserializer extends YamlDeserializerBase<RouteTemplateContextRefDefinition> {
        public RouteTemplateContextRefDefinitionDeserializer() {
            super(RouteTemplateContextRefDefinition.class);
        }

        @Override
        protected RouteTemplateContextRefDefinition newInstance() {
            return new RouteTemplateContextRefDefinition();
        }

        @Override
        protected boolean setProperty(RouteTemplateContextRefDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.RouteTemplateDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "route-template",
            properties = {
                    @YamlProperty(name = "route", type = "object:org.apache.camel.model.RouteDefinition"),
                    @YamlProperty(name = "template-parameter", type = "array:org.apache.camel.model.RouteTemplateParameterDefinition")
            }
    )
    public static class RouteTemplateDefinitionDeserializer extends YamlDeserializerBase<RouteTemplateDefinition> {
        public RouteTemplateDefinitionDeserializer() {
            super(RouteTemplateDefinition.class);
        }

        @Override
        protected RouteTemplateDefinition newInstance() {
            return new RouteTemplateDefinition();
        }

        @Override
        protected boolean setProperty(RouteTemplateDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "route": {
                    org.apache.camel.model.RouteDefinition val = asType(node, org.apache.camel.model.RouteDefinition.class);
                    target.setRoute(val);
                    break;
                }
                case "template-parameter": {
                    java.util.List<org.apache.camel.model.RouteTemplateParameterDefinition> val = asFlatList(node, org.apache.camel.model.RouteTemplateParameterDefinition.class);
                    target.setTemplateParameters(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.RouteTemplateParameterDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "template-parameter",
            properties = {
                    @YamlProperty(name = "default-value", type = "string"),
                    @YamlProperty(name = "description", type = "string"),
                    @YamlProperty(name = "name", type = "string")
            }
    )
    public static class RouteTemplateParameterDefinitionDeserializer extends YamlDeserializerBase<RouteTemplateParameterDefinition> {
        public RouteTemplateParameterDefinitionDeserializer() {
            super(RouteTemplateParameterDefinition.class);
        }

        @Override
        protected RouteTemplateParameterDefinition newInstance() {
            return new RouteTemplateParameterDefinition();
        }

        @Override
        protected boolean setProperty(RouteTemplateParameterDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "default-value": {
                    String val = asText(node);
                    target.setDefaultValue(val);
                    break;
                }
                case "description": {
                    String val = asText(node);
                    target.setDescription(val);
                    break;
                }
                case "name": {
                    String val = asText(node);
                    target.setName(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.RouteTemplatesDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "route-templates",
            properties = @YamlProperty(name = "route-templates", type = "array:org.apache.camel.model.RouteTemplateDefinition")
    )
    public static class RouteTemplatesDefinitionDeserializer extends YamlDeserializerBase<RouteTemplatesDefinition> {
        public RouteTemplatesDefinitionDeserializer() {
            super(RouteTemplatesDefinition.class);
        }

        @Override
        protected RouteTemplatesDefinition newInstance() {
            return new RouteTemplatesDefinition();
        }

        @Override
        protected boolean setProperty(RouteTemplatesDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "route-template": {
                    java.util.List<org.apache.camel.model.RouteTemplateDefinition> val = asFlatList(node, org.apache.camel.model.RouteTemplateDefinition.class);
                    target.setRouteTemplates(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.RoutesDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "routes",
            properties = @YamlProperty(name = "routes", type = "array:org.apache.camel.model.RouteDefinition")
    )
    public static class RoutesDefinitionDeserializer extends YamlDeserializerBase<RoutesDefinition> {
        public RoutesDefinitionDeserializer() {
            super(RoutesDefinition.class);
        }

        @Override
        protected RoutesDefinition newInstance() {
            return new RoutesDefinition();
        }

        @Override
        protected boolean setProperty(RoutesDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "route": {
                    java.util.List<org.apache.camel.model.RouteDefinition> val = asFlatList(node, org.apache.camel.model.RouteDefinition.class);
                    target.setRoutes(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.RoutingSlipDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "routing-slip",
            properties = {
                    @YamlProperty(name = "cache-size", type = "number"),
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "ignore-invalid-endpoints", type = "boolean"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "uri-delimiter", type = "string"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class RoutingSlipDefinitionDeserializer extends YamlDeserializerBase<RoutingSlipDefinition> {
        public RoutingSlipDefinitionDeserializer() {
            super(RoutingSlipDefinition.class);
        }

        @Override
        protected RoutingSlipDefinition newInstance() {
            return new RoutingSlipDefinition();
        }

        @Override
        protected RoutingSlipDefinition newInstance(String value) {
            return new RoutingSlipDefinition(value);
        }

        @Override
        protected boolean setProperty(RoutingSlipDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "cache-size": {
                    String val = asText(node);
                    target.setCacheSize(val);
                    break;
                }
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "ignore-invalid-endpoints": {
                    String val = asText(node);
                    target.setIgnoreInvalidEndpoints(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "uri-delimiter": {
                    String val = asText(node);
                    target.setUriDelimiter(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.RssDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "rss",
            properties = @YamlProperty(name = "id", type = "string")
    )
    public static class RssDataFormatDeserializer extends YamlDeserializerBase<RssDataFormat> {
        public RssDataFormatDeserializer() {
            super(RssDataFormat.class);
        }

        @Override
        protected RssDataFormat newInstance() {
            return new RssDataFormat();
        }

        @Override
        protected boolean setProperty(RssDataFormat target, String propertyKey, String propertyName,
                Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.SagaDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "saga",
            properties = {
                    @YamlProperty(name = "compensation", type = "object:org.apache.camel.model.SagaActionUriDefinition"),
                    @YamlProperty(name = "completion", type = "object:org.apache.camel.model.SagaActionUriDefinition"),
                    @YamlProperty(name = "completion-mode", type = "string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "option", type = "array:org.apache.camel.model.SagaOptionDefinition"),
                    @YamlProperty(name = "propagation", type = "string"),
                    @YamlProperty(name = "saga-service-ref", type = "string"),
                    @YamlProperty(name = "timeout", type = "string"),
                    @YamlProperty(name = "timeout-in-milliseconds", type = "number"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class SagaDefinitionDeserializer extends YamlDeserializerBase<SagaDefinition> {
        public SagaDefinitionDeserializer() {
            super(SagaDefinition.class);
        }

        @Override
        protected SagaDefinition newInstance() {
            return new SagaDefinition();
        }

        @Override
        protected boolean setProperty(SagaDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "compensation": {
                    org.apache.camel.model.SagaActionUriDefinition val = asType(node, org.apache.camel.model.SagaActionUriDefinition.class);
                    target.setCompensation(val);
                    break;
                }
                case "completion": {
                    org.apache.camel.model.SagaActionUriDefinition val = asType(node, org.apache.camel.model.SagaActionUriDefinition.class);
                    target.setCompletion(val);
                    break;
                }
                case "completion-mode": {
                    String val = asText(node);
                    target.setCompletionMode(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "option": {
                    java.util.List<org.apache.camel.model.SagaOptionDefinition> val = asFlatList(node, org.apache.camel.model.SagaOptionDefinition.class);
                    target.setOptions(val);
                    break;
                }
                case "propagation": {
                    String val = asText(node);
                    target.setPropagation(val);
                    break;
                }
                case "saga-service-ref": {
                    String val = asText(node);
                    target.setSagaServiceRef(val);
                    break;
                }
                case "timeout": {
                    String val = asText(node);
                    target.setTimeout(val);
                    break;
                }
                case "timeout-in-milliseconds": {
                    String val = asText(node);
                    target.setTimeoutInMilliseconds(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.SamplingDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "sample",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "message-frequency", type = "number"),
                    @YamlProperty(name = "sample-period", type = "string"),
                    @YamlProperty(name = "units", type = "string")
            }
    )
    public static class SamplingDefinitionDeserializer extends YamlDeserializerBase<SamplingDefinition> {
        public SamplingDefinitionDeserializer() {
            super(SamplingDefinition.class);
        }

        @Override
        protected SamplingDefinition newInstance() {
            return new SamplingDefinition();
        }

        @Override
        protected boolean setProperty(SamplingDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "message-frequency": {
                    String val = asText(node);
                    target.setMessageFrequency(val);
                    break;
                }
                case "sample-period": {
                    String val = asText(node);
                    target.setSamplePeriod(val);
                    break;
                }
                case "units": {
                    String val = asText(node);
                    target.setUnits(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.ScriptDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "script",
            properties = {
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class ScriptDefinitionDeserializer extends YamlDeserializerBase<ScriptDefinition> {
        public ScriptDefinitionDeserializer() {
            super(ScriptDefinition.class);
        }

        @Override
        protected ScriptDefinition newInstance() {
            return new ScriptDefinition();
        }

        @Override
        protected boolean setProperty(ScriptDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.SecurityDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "security",
            properties = {
                    @YamlProperty(name = "key", type = "string", required = true),
                    @YamlProperty(name = "scopes", type = "string")
            }
    )
    public static class SecurityDefinitionDeserializer extends YamlDeserializerBase<SecurityDefinition> {
        public SecurityDefinitionDeserializer() {
            super(SecurityDefinition.class);
        }

        @Override
        protected SecurityDefinition newInstance() {
            return new SecurityDefinition();
        }

        @Override
        protected boolean setProperty(SecurityDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "key": {
                    String val = asText(node);
                    target.setKey(val);
                    break;
                }
                case "scopes": {
                    String val = asText(node);
                    target.setScopes(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.ServiceCallConfigurationDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "service-call-configuration",
            properties = {
                    @YamlProperty(name = "component", type = "string"),
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.cloud.ServiceCallExpressionConfiguration"),
                    @YamlProperty(name = "expression-ref", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "ribbon-load-balancer", type = "object:org.apache.camel.model.cloud.RibbonServiceCallServiceLoadBalancerConfiguration"),
                    @YamlProperty(name = "default-load-balancer", type = "object:org.apache.camel.model.cloud.DefaultServiceCallServiceLoadBalancerConfiguration"),
                    @YamlProperty(name = "load-balancer-ref", type = "string"),
                    @YamlProperty(name = "pattern", type = "string"),
                    @YamlProperty(name = "service-chooser-ref", type = "string"),
                    @YamlProperty(name = "caching-service-discovery", type = "object:org.apache.camel.model.cloud.CachingServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "combined-service-discovery", type = "object:org.apache.camel.model.cloud.CombinedServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "consul-service-discovery", type = "object:org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "dns-service-discovery", type = "object:org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "etcd-service-discovery", type = "object:org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "kubernetes-service-discovery", type = "object:org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "static-service-discovery", type = "object:org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "zookeeper-service-discovery", type = "object:org.apache.camel.model.cloud.ZooKeeperServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "service-discovery-ref", type = "string"),
                    @YamlProperty(name = "blacklist-service-filter", type = "object:org.apache.camel.model.cloud.BlacklistServiceCallServiceFilterConfiguration"),
                    @YamlProperty(name = "combined-service-filter", type = "object:org.apache.camel.model.cloud.CombinedServiceCallServiceFilterConfiguration"),
                    @YamlProperty(name = "custom-service-filter", type = "object:org.apache.camel.model.cloud.CustomServiceCallServiceFilterConfiguration"),
                    @YamlProperty(name = "healthy-service-filter", type = "object:org.apache.camel.model.cloud.HealthyServiceCallServiceFilterConfiguration"),
                    @YamlProperty(name = "pass-through-service-filter", type = "object:org.apache.camel.model.cloud.PassThroughServiceCallServiceFilterConfiguration"),
                    @YamlProperty(name = "service-filter-ref", type = "string"),
                    @YamlProperty(name = "uri", type = "string")
            }
    )
    public static class ServiceCallConfigurationDefinitionDeserializer extends YamlDeserializerBase<ServiceCallConfigurationDefinition> {
        public ServiceCallConfigurationDefinitionDeserializer() {
            super(ServiceCallConfigurationDefinition.class);
        }

        @Override
        protected ServiceCallConfigurationDefinition newInstance() {
            return new ServiceCallConfigurationDefinition();
        }

        @Override
        protected boolean setProperty(ServiceCallConfigurationDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "component": {
                    String val = asText(node);
                    target.setComponent(val);
                    break;
                }
                case "expression": {
                    org.apache.camel.model.cloud.ServiceCallExpressionConfiguration val = asType(node, org.apache.camel.model.cloud.ServiceCallExpressionConfiguration.class);
                    target.setExpressionConfiguration(val);
                    break;
                }
                case "expression-ref": {
                    String val = asText(node);
                    target.setExpressionRef(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "load-balancer-configuration": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "ribbon-load-balancer": {
                    org.apache.camel.model.cloud.RibbonServiceCallServiceLoadBalancerConfiguration val = asType(node, org.apache.camel.model.cloud.RibbonServiceCallServiceLoadBalancerConfiguration.class);
                    target.setLoadBalancerConfiguration(val);
                    break;
                }
                case "default-load-balancer": {
                    org.apache.camel.model.cloud.DefaultServiceCallServiceLoadBalancerConfiguration val = asType(node, org.apache.camel.model.cloud.DefaultServiceCallServiceLoadBalancerConfiguration.class);
                    target.setLoadBalancerConfiguration(val);
                    break;
                }
                case "load-balancer-ref": {
                    String val = asText(node);
                    target.setLoadBalancerRef(val);
                    break;
                }
                case "pattern": {
                    String val = asText(node);
                    target.setPattern(val);
                    break;
                }
                case "service-chooser-ref": {
                    String val = asText(node);
                    target.setServiceChooserRef(val);
                    break;
                }
                case "service-discovery-configuration": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "caching-service-discovery": {
                    org.apache.camel.model.cloud.CachingServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.CachingServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "combined-service-discovery": {
                    org.apache.camel.model.cloud.CombinedServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.CombinedServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "consul-service-discovery": {
                    org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "dns-service-discovery": {
                    org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "etcd-service-discovery": {
                    org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "kubernetes-service-discovery": {
                    org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "static-service-discovery": {
                    org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "zookeeper-service-discovery": {
                    org.apache.camel.model.cloud.ZooKeeperServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.ZooKeeperServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "service-discovery-ref": {
                    String val = asText(node);
                    target.setServiceDiscoveryRef(val);
                    break;
                }
                case "service-filter-configuration": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "blacklist-service-filter": {
                    org.apache.camel.model.cloud.BlacklistServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.BlacklistServiceCallServiceFilterConfiguration.class);
                    target.setServiceFilterConfiguration(val);
                    break;
                }
                case "combined-service-filter": {
                    org.apache.camel.model.cloud.CombinedServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.CombinedServiceCallServiceFilterConfiguration.class);
                    target.setServiceFilterConfiguration(val);
                    break;
                }
                case "custom-service-filter": {
                    org.apache.camel.model.cloud.CustomServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.CustomServiceCallServiceFilterConfiguration.class);
                    target.setServiceFilterConfiguration(val);
                    break;
                }
                case "healthy-service-filter": {
                    org.apache.camel.model.cloud.HealthyServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.HealthyServiceCallServiceFilterConfiguration.class);
                    target.setServiceFilterConfiguration(val);
                    break;
                }
                case "pass-through-service-filter": {
                    org.apache.camel.model.cloud.PassThroughServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.PassThroughServiceCallServiceFilterConfiguration.class);
                    target.setServiceFilterConfiguration(val);
                    break;
                }
                case "service-filter-ref": {
                    String val = asText(node);
                    target.setServiceFilterRef(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.cloud.ServiceCallDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "service-call",
            properties = {
                    @YamlProperty(name = "component", type = "string"),
                    @YamlProperty(name = "configuration-ref", type = "string"),
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.cloud.ServiceCallExpressionConfiguration"),
                    @YamlProperty(name = "expression-ref", type = "string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "ribbon-load-balancer", type = "object:org.apache.camel.model.cloud.RibbonServiceCallServiceLoadBalancerConfiguration"),
                    @YamlProperty(name = "default-load-balancer", type = "object:org.apache.camel.model.cloud.DefaultServiceCallServiceLoadBalancerConfiguration"),
                    @YamlProperty(name = "load-balancer-ref", type = "string"),
                    @YamlProperty(name = "name", type = "string", required = true),
                    @YamlProperty(name = "pattern", type = "string"),
                    @YamlProperty(name = "service-chooser-ref", type = "string"),
                    @YamlProperty(name = "caching-service-discovery", type = "object:org.apache.camel.model.cloud.CachingServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "combined-service-discovery", type = "object:org.apache.camel.model.cloud.CombinedServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "consul-service-discovery", type = "object:org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "dns-service-discovery", type = "object:org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "etcd-service-discovery", type = "object:org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "kubernetes-service-discovery", type = "object:org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "static-service-discovery", type = "object:org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "zookeeper-service-discovery", type = "object:org.apache.camel.model.cloud.ZooKeeperServiceCallServiceDiscoveryConfiguration"),
                    @YamlProperty(name = "service-discovery-ref", type = "string"),
                    @YamlProperty(name = "blacklist-service-filter", type = "object:org.apache.camel.model.cloud.BlacklistServiceCallServiceFilterConfiguration"),
                    @YamlProperty(name = "combined-service-filter", type = "object:org.apache.camel.model.cloud.CombinedServiceCallServiceFilterConfiguration"),
                    @YamlProperty(name = "custom-service-filter", type = "object:org.apache.camel.model.cloud.CustomServiceCallServiceFilterConfiguration"),
                    @YamlProperty(name = "healthy-service-filter", type = "object:org.apache.camel.model.cloud.HealthyServiceCallServiceFilterConfiguration"),
                    @YamlProperty(name = "pass-through-service-filter", type = "object:org.apache.camel.model.cloud.PassThroughServiceCallServiceFilterConfiguration"),
                    @YamlProperty(name = "service-filter-ref", type = "string"),
                    @YamlProperty(name = "uri", type = "string")
            }
    )
    public static class ServiceCallDefinitionDeserializer extends YamlDeserializerBase<ServiceCallDefinition> {
        public ServiceCallDefinitionDeserializer() {
            super(ServiceCallDefinition.class);
        }

        @Override
        protected ServiceCallDefinition newInstance() {
            return new ServiceCallDefinition();
        }

        @Override
        protected ServiceCallDefinition newInstance(String value) {
            return new ServiceCallDefinition(value);
        }

        @Override
        protected boolean setProperty(ServiceCallDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "component": {
                    String val = asText(node);
                    target.setComponent(val);
                    break;
                }
                case "configuration-ref": {
                    String val = asText(node);
                    target.setConfigurationRef(val);
                    break;
                }
                case "expression": {
                    org.apache.camel.model.cloud.ServiceCallExpressionConfiguration val = asType(node, org.apache.camel.model.cloud.ServiceCallExpressionConfiguration.class);
                    target.setExpressionConfiguration(val);
                    break;
                }
                case "expression-ref": {
                    String val = asText(node);
                    target.setExpressionRef(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "load-balancer-configuration": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "ribbon-load-balancer": {
                    org.apache.camel.model.cloud.RibbonServiceCallServiceLoadBalancerConfiguration val = asType(node, org.apache.camel.model.cloud.RibbonServiceCallServiceLoadBalancerConfiguration.class);
                    target.setLoadBalancerConfiguration(val);
                    break;
                }
                case "default-load-balancer": {
                    org.apache.camel.model.cloud.DefaultServiceCallServiceLoadBalancerConfiguration val = asType(node, org.apache.camel.model.cloud.DefaultServiceCallServiceLoadBalancerConfiguration.class);
                    target.setLoadBalancerConfiguration(val);
                    break;
                }
                case "load-balancer-ref": {
                    String val = asText(node);
                    target.setLoadBalancerRef(val);
                    break;
                }
                case "name": {
                    String val = asText(node);
                    target.setName(val);
                    break;
                }
                case "pattern": {
                    String val = asText(node);
                    target.setPattern(val);
                    break;
                }
                case "service-chooser-ref": {
                    String val = asText(node);
                    target.setServiceChooserRef(val);
                    break;
                }
                case "service-discovery-configuration": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "caching-service-discovery": {
                    org.apache.camel.model.cloud.CachingServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.CachingServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "combined-service-discovery": {
                    org.apache.camel.model.cloud.CombinedServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.CombinedServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "consul-service-discovery": {
                    org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.ConsulServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "dns-service-discovery": {
                    org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.DnsServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "etcd-service-discovery": {
                    org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.EtcdServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "kubernetes-service-discovery": {
                    org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.KubernetesServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "static-service-discovery": {
                    org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "zookeeper-service-discovery": {
                    org.apache.camel.model.cloud.ZooKeeperServiceCallServiceDiscoveryConfiguration val = asType(node, org.apache.camel.model.cloud.ZooKeeperServiceCallServiceDiscoveryConfiguration.class);
                    target.setServiceDiscoveryConfiguration(val);
                    break;
                }
                case "service-discovery-ref": {
                    String val = asText(node);
                    target.setServiceDiscoveryRef(val);
                    break;
                }
                case "service-filter-configuration": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "blacklist-service-filter": {
                    org.apache.camel.model.cloud.BlacklistServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.BlacklistServiceCallServiceFilterConfiguration.class);
                    target.setServiceFilterConfiguration(val);
                    break;
                }
                case "combined-service-filter": {
                    org.apache.camel.model.cloud.CombinedServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.CombinedServiceCallServiceFilterConfiguration.class);
                    target.setServiceFilterConfiguration(val);
                    break;
                }
                case "custom-service-filter": {
                    org.apache.camel.model.cloud.CustomServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.CustomServiceCallServiceFilterConfiguration.class);
                    target.setServiceFilterConfiguration(val);
                    break;
                }
                case "healthy-service-filter": {
                    org.apache.camel.model.cloud.HealthyServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.HealthyServiceCallServiceFilterConfiguration.class);
                    target.setServiceFilterConfiguration(val);
                    break;
                }
                case "pass-through-service-filter": {
                    org.apache.camel.model.cloud.PassThroughServiceCallServiceFilterConfiguration val = asType(node, org.apache.camel.model.cloud.PassThroughServiceCallServiceFilterConfiguration.class);
                    target.setServiceFilterConfiguration(val);
                    break;
                }
                case "service-filter-ref": {
                    String val = asText(node);
                    target.setServiceFilterRef(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.ServiceCallExpressionConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "service-expression",
            properties = {
                    @YamlProperty(name = "expression-type", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "host-header", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "port-header", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition")
            }
    )
    public static class ServiceCallExpressionConfigurationDeserializer extends YamlDeserializerBase<ServiceCallExpressionConfiguration> {
        public ServiceCallExpressionConfigurationDeserializer() {
            super(ServiceCallExpressionConfiguration.class);
        }

        @Override
        protected ServiceCallExpressionConfiguration newInstance() {
            return new ServiceCallExpressionConfiguration();
        }

        @Override
        protected boolean setProperty(ServiceCallExpressionConfiguration target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression-type": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpressionType(val);
                    break;
                }
                case "host-header": {
                    String val = asText(node);
                    target.setHostHeader(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "port-header": {
                    String val = asText(node);
                    target.setPortHeader(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.ServiceCallServiceChooserConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "service-chooser-configuration",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition")
            }
    )
    public static class ServiceCallServiceChooserConfigurationDeserializer extends YamlDeserializerBase<ServiceCallServiceChooserConfiguration> {
        public ServiceCallServiceChooserConfigurationDeserializer() {
            super(ServiceCallServiceChooserConfiguration.class);
        }

        @Override
        protected ServiceCallServiceChooserConfiguration newInstance() {
            return new ServiceCallServiceChooserConfiguration();
        }

        @Override
        protected boolean setProperty(ServiceCallServiceChooserConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.ServiceCallServiceDiscoveryConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "service-discovery-configuration",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition")
            }
    )
    public static class ServiceCallServiceDiscoveryConfigurationDeserializer extends YamlDeserializerBase<ServiceCallServiceDiscoveryConfiguration> {
        public ServiceCallServiceDiscoveryConfigurationDeserializer() {
            super(ServiceCallServiceDiscoveryConfiguration.class);
        }

        @Override
        protected ServiceCallServiceDiscoveryConfiguration newInstance() {
            return new ServiceCallServiceDiscoveryConfiguration();
        }

        @Override
        protected boolean setProperty(ServiceCallServiceDiscoveryConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.ServiceCallServiceFilterConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "service-filter-configuration",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition")
            }
    )
    public static class ServiceCallServiceFilterConfigurationDeserializer extends YamlDeserializerBase<ServiceCallServiceFilterConfiguration> {
        public ServiceCallServiceFilterConfigurationDeserializer() {
            super(ServiceCallServiceFilterConfiguration.class);
        }

        @Override
        protected ServiceCallServiceFilterConfiguration newInstance() {
            return new ServiceCallServiceFilterConfiguration();
        }

        @Override
        protected boolean setProperty(ServiceCallServiceFilterConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.ServiceCallServiceLoadBalancerConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "load-balancer-configuration",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition")
            }
    )
    public static class ServiceCallServiceLoadBalancerConfigurationDeserializer extends YamlDeserializerBase<ServiceCallServiceLoadBalancerConfiguration> {
        public ServiceCallServiceLoadBalancerConfigurationDeserializer() {
            super(ServiceCallServiceLoadBalancerConfiguration.class);
        }

        @Override
        protected ServiceCallServiceLoadBalancerConfiguration newInstance() {
            return new ServiceCallServiceLoadBalancerConfiguration();
        }

        @Override
        protected boolean setProperty(ServiceCallServiceLoadBalancerConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.SetBodyDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "set-body",
            properties = {
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class SetBodyDefinitionDeserializer extends YamlDeserializerBase<SetBodyDefinition> {
        public SetBodyDefinitionDeserializer() {
            super(SetBodyDefinition.class);
        }

        @Override
        protected SetBodyDefinition newInstance() {
            return new SetBodyDefinition();
        }

        @Override
        protected boolean setProperty(SetBodyDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.SetExchangePatternDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "set-exchange-pattern",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "pattern", type = "string", required = true)
            }
    )
    public static class SetExchangePatternDefinitionDeserializer extends YamlDeserializerBase<SetExchangePatternDefinition> {
        public SetExchangePatternDefinitionDeserializer() {
            super(SetExchangePatternDefinition.class);
        }

        @Override
        protected SetExchangePatternDefinition newInstance() {
            return new SetExchangePatternDefinition();
        }

        @Override
        protected SetExchangePatternDefinition newInstance(String value) {
            return new SetExchangePatternDefinition(value);
        }

        @Override
        protected boolean setProperty(SetExchangePatternDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "pattern": {
                    String val = asText(node);
                    target.setPattern(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.SetHeaderDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "set-header",
            properties = {
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "name", type = "string"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class SetHeaderDefinitionDeserializer extends YamlDeserializerBase<SetHeaderDefinition> {
        public SetHeaderDefinitionDeserializer() {
            super(SetHeaderDefinition.class);
        }

        @Override
        protected SetHeaderDefinition newInstance() {
            return new SetHeaderDefinition();
        }

        @Override
        protected boolean setProperty(SetHeaderDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "name": {
                    String val = asText(node);
                    target.setName(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.SetPropertyDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "set-property",
            properties = {
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "name", type = "string"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class SetPropertyDefinitionDeserializer extends YamlDeserializerBase<SetPropertyDefinition> {
        public SetPropertyDefinitionDeserializer() {
            super(SetPropertyDefinition.class);
        }

        @Override
        protected SetPropertyDefinition newInstance() {
            return new SetPropertyDefinition();
        }

        @Override
        protected boolean setProperty(SetPropertyDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "name": {
                    String val = asText(node);
                    target.setName(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.SimpleExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "simple",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "result-type", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class SimpleExpressionDeserializer extends YamlDeserializerBase<SimpleExpression> {
        public SimpleExpressionDeserializer() {
            super(SimpleExpression.class);
        }

        @Override
        protected SimpleExpression newInstance() {
            return new SimpleExpression();
        }

        @Override
        protected SimpleExpression newInstance(String value) {
            return new SimpleExpression(value);
        }

        @Override
        protected boolean setProperty(SimpleExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "result-type": {
                    String val = asText(node);
                    target.setResultTypeName(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.dataformat.SoapJaxbDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "soapjaxb",
            properties = {
                    @YamlProperty(name = "context-path", type = "string"),
                    @YamlProperty(name = "element-name-strategy-ref", type = "string"),
                    @YamlProperty(name = "encoding", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "namespace-prefix-ref", type = "string"),
                    @YamlProperty(name = "schema", type = "string"),
                    @YamlProperty(name = "version", type = "string")
            }
    )
    public static class SoapJaxbDataFormatDeserializer extends YamlDeserializerBase<SoapJaxbDataFormat> {
        public SoapJaxbDataFormatDeserializer() {
            super(SoapJaxbDataFormat.class);
        }

        @Override
        protected SoapJaxbDataFormat newInstance() {
            return new SoapJaxbDataFormat();
        }

        @Override
        protected SoapJaxbDataFormat newInstance(String value) {
            return new SoapJaxbDataFormat(value);
        }

        @Override
        protected boolean setProperty(SoapJaxbDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "context-path": {
                    String val = asText(node);
                    target.setContextPath(val);
                    break;
                }
                case "element-name-strategy-ref": {
                    String val = asText(node);
                    target.setElementNameStrategyRef(val);
                    break;
                }
                case "encoding": {
                    String val = asText(node);
                    target.setEncoding(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "namespace-prefix-ref": {
                    String val = asText(node);
                    target.setNamespacePrefixRef(val);
                    break;
                }
                case "schema": {
                    String val = asText(node);
                    target.setSchema(val);
                    break;
                }
                case "version": {
                    String val = asText(node);
                    target.setVersion(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.SortDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "sort",
            properties = {
                    @YamlProperty(name = "comparator-ref", type = "string"),
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class SortDefinitionDeserializer extends YamlDeserializerBase<SortDefinition> {
        public SortDefinitionDeserializer() {
            super(SortDefinition.class);
        }

        @Override
        protected SortDefinition newInstance() {
            return new SortDefinition();
        }

        @Override
        protected boolean setProperty(SortDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "comparator-ref": {
                    String val = asText(node);
                    target.setComparatorRef(val);
                    break;
                }
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.SpELExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "spel",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class SpELExpressionDeserializer extends YamlDeserializerBase<SpELExpression> {
        public SpELExpressionDeserializer() {
            super(SpELExpression.class);
        }

        @Override
        protected SpELExpression newInstance() {
            return new SpELExpression();
        }

        @Override
        protected SpELExpression newInstance(String value) {
            return new SpELExpression(value);
        }

        @Override
        protected boolean setProperty(SpELExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.SplitDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "split",
            properties = {
                    @YamlProperty(name = "delimiter", type = "string"),
                    @YamlProperty(name = "executor-service-ref", type = "string"),
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "on-prepare-ref", type = "string"),
                    @YamlProperty(name = "parallel-aggregate", type = "boolean"),
                    @YamlProperty(name = "parallel-processing", type = "boolean"),
                    @YamlProperty(name = "share-unit-of-work", type = "boolean"),
                    @YamlProperty(name = "stop-on-aggregate-exception", type = "boolean"),
                    @YamlProperty(name = "stop-on-exception", type = "boolean"),
                    @YamlProperty(name = "strategy-method-allow-null", type = "boolean"),
                    @YamlProperty(name = "strategy-method-name", type = "string"),
                    @YamlProperty(name = "strategy-ref", type = "string"),
                    @YamlProperty(name = "streaming", type = "boolean"),
                    @YamlProperty(name = "timeout", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class SplitDefinitionDeserializer extends YamlDeserializerBase<SplitDefinition> {
        public SplitDefinitionDeserializer() {
            super(SplitDefinition.class);
        }

        @Override
        protected SplitDefinition newInstance() {
            return new SplitDefinition();
        }

        @Override
        protected boolean setProperty(SplitDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "delimiter": {
                    String val = asText(node);
                    target.setDelimiter(val);
                    break;
                }
                case "executor-service-ref": {
                    String val = asText(node);
                    target.setExecutorServiceRef(val);
                    break;
                }
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "on-prepare-ref": {
                    String val = asText(node);
                    target.setOnPrepareRef(val);
                    break;
                }
                case "parallel-aggregate": {
                    String val = asText(node);
                    target.setParallelAggregate(val);
                    break;
                }
                case "parallel-processing": {
                    String val = asText(node);
                    target.setParallelProcessing(val);
                    break;
                }
                case "share-unit-of-work": {
                    String val = asText(node);
                    target.setShareUnitOfWork(val);
                    break;
                }
                case "stop-on-aggregate-exception": {
                    String val = asText(node);
                    target.setStopOnAggregateException(val);
                    break;
                }
                case "stop-on-exception": {
                    String val = asText(node);
                    target.setStopOnException(val);
                    break;
                }
                case "strategy-method-allow-null": {
                    String val = asText(node);
                    target.setStrategyMethodAllowNull(val);
                    break;
                }
                case "strategy-method-name": {
                    String val = asText(node);
                    target.setStrategyMethodName(val);
                    break;
                }
                case "strategy-ref": {
                    String val = asText(node);
                    target.setStrategyRef(val);
                    break;
                }
                case "streaming": {
                    String val = asText(node);
                    target.setStreaming(val);
                    break;
                }
                case "timeout": {
                    String val = asText(node);
                    target.setTimeout(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.StaticServiceCallServiceDiscoveryConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "static-service-discovery",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "servers", type = "array:string")
            }
    )
    public static class StaticServiceCallServiceDiscoveryConfigurationDeserializer extends YamlDeserializerBase<StaticServiceCallServiceDiscoveryConfiguration> {
        public StaticServiceCallServiceDiscoveryConfigurationDeserializer() {
            super(StaticServiceCallServiceDiscoveryConfiguration.class);
        }

        @Override
        protected StaticServiceCallServiceDiscoveryConfiguration newInstance() {
            return new StaticServiceCallServiceDiscoveryConfiguration();
        }

        @Override
        protected boolean setProperty(StaticServiceCallServiceDiscoveryConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                case "servers": {
                    java.util.List<String> val = asStringList(node);
                    target.setServers(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.StepDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "step",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class StepDefinitionDeserializer extends YamlDeserializerBase<StepDefinition> {
        public StepDefinitionDeserializer() {
            super(StepDefinition.class);
        }

        @Override
        protected StepDefinition newInstance() {
            return new StepDefinition();
        }

        @Override
        protected boolean setProperty(StepDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.loadbalancer.StickyLoadBalancerDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "sticky",
            properties = {
                    @YamlProperty(name = "correlation-expression", type = "object:org.apache.camel.model.ExpressionSubElementDefinition"),
                    @YamlProperty(name = "id", type = "string")
            }
    )
    public static class StickyLoadBalancerDefinitionDeserializer extends YamlDeserializerBase<StickyLoadBalancerDefinition> {
        public StickyLoadBalancerDefinitionDeserializer() {
            super(StickyLoadBalancerDefinition.class);
        }

        @Override
        protected StickyLoadBalancerDefinition newInstance() {
            return new StickyLoadBalancerDefinition();
        }

        @Override
        protected boolean setProperty(StickyLoadBalancerDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "correlation-expression": {
                    org.apache.camel.model.ExpressionSubElementDefinition val = asType(node, org.apache.camel.model.ExpressionSubElementDefinition.class);
                    target.setCorrelationExpression(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.StopDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "stop",
            properties = @YamlProperty(name = "inherit-error-handler", type = "boolean")
    )
    public static class StopDefinitionDeserializer extends YamlDeserializerBase<StopDefinition> {
        public StopDefinitionDeserializer() {
            super(StopDefinition.class);
        }

        @Override
        protected StopDefinition newInstance() {
            return new StopDefinition();
        }

        @Override
        protected boolean setProperty(StopDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.config.StreamResequencerConfig.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "stream-config",
            properties = {
                    @YamlProperty(name = "capacity", type = "number"),
                    @YamlProperty(name = "comparator-ref", type = "string"),
                    @YamlProperty(name = "delivery-attempt-interval", type = "string"),
                    @YamlProperty(name = "ignore-invalid-exchanges", type = "boolean"),
                    @YamlProperty(name = "reject-old", type = "boolean"),
                    @YamlProperty(name = "timeout", type = "string")
            }
    )
    public static class StreamResequencerConfigDeserializer extends YamlDeserializerBase<StreamResequencerConfig> {
        public StreamResequencerConfigDeserializer() {
            super(StreamResequencerConfig.class);
        }

        @Override
        protected StreamResequencerConfig newInstance() {
            return new StreamResequencerConfig();
        }

        @Override
        protected boolean setProperty(StreamResequencerConfig target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "capacity": {
                    String val = asText(node);
                    target.setCapacity(val);
                    break;
                }
                case "comparator-ref": {
                    String val = asText(node);
                    target.setComparatorRef(val);
                    break;
                }
                case "delivery-attempt-interval": {
                    String val = asText(node);
                    target.setDeliveryAttemptInterval(val);
                    break;
                }
                case "ignore-invalid-exchanges": {
                    String val = asText(node);
                    target.setIgnoreInvalidExchanges(val);
                    break;
                }
                case "reject-old": {
                    String val = asText(node);
                    target.setRejectOld(val);
                    break;
                }
                case "timeout": {
                    String val = asText(node);
                    target.setTimeout(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.SyslogDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "syslog",
            properties = @YamlProperty(name = "id", type = "string")
    )
    public static class SyslogDataFormatDeserializer extends YamlDeserializerBase<SyslogDataFormat> {
        public SyslogDataFormatDeserializer() {
            super(SyslogDataFormat.class);
        }

        @Override
        protected SyslogDataFormat newInstance() {
            return new SyslogDataFormat();
        }

        @Override
        protected boolean setProperty(SyslogDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.TarFileDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "tarfile",
            properties = {
                    @YamlProperty(name = "allow-empty-directory", type = "boolean"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "max-decompressed-size", type = "number"),
                    @YamlProperty(name = "preserve-path-elements", type = "boolean"),
                    @YamlProperty(name = "using-iterator", type = "boolean")
            }
    )
    public static class TarFileDataFormatDeserializer extends YamlDeserializerBase<TarFileDataFormat> {
        public TarFileDataFormatDeserializer() {
            super(TarFileDataFormat.class);
        }

        @Override
        protected TarFileDataFormat newInstance() {
            return new TarFileDataFormat();
        }

        @Override
        protected boolean setProperty(TarFileDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-empty-directory": {
                    String val = asText(node);
                    target.setAllowEmptyDirectory(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "max-decompressed-size": {
                    String val = asText(node);
                    target.setMaxDecompressedSize(val);
                    break;
                }
                case "preserve-path-elements": {
                    String val = asText(node);
                    target.setPreservePathElements(val);
                    break;
                }
                case "using-iterator": {
                    String val = asText(node);
                    target.setUsingIterator(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.ThreadPoolProfileDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "thread-pool-profile",
            properties = {
                    @YamlProperty(name = "allow-core-thread-time-out", type = "boolean"),
                    @YamlProperty(name = "default-profile", type = "boolean"),
                    @YamlProperty(name = "keep-alive-time", type = "number"),
                    @YamlProperty(name = "max-pool-size", type = "number"),
                    @YamlProperty(name = "max-queue-size", type = "number"),
                    @YamlProperty(name = "pool-size", type = "number"),
                    @YamlProperty(name = "rejected-policy", type = "string"),
                    @YamlProperty(name = "time-unit", type = "string")
            }
    )
    public static class ThreadPoolProfileDefinitionDeserializer extends YamlDeserializerBase<ThreadPoolProfileDefinition> {
        public ThreadPoolProfileDefinitionDeserializer() {
            super(ThreadPoolProfileDefinition.class);
        }

        @Override
        protected ThreadPoolProfileDefinition newInstance() {
            return new ThreadPoolProfileDefinition();
        }

        @Override
        protected boolean setProperty(ThreadPoolProfileDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-core-thread-time-out": {
                    String val = asText(node);
                    target.setAllowCoreThreadTimeOut(val);
                    break;
                }
                case "default-profile": {
                    String val = asText(node);
                    target.setDefaultProfile(val);
                    break;
                }
                case "keep-alive-time": {
                    String val = asText(node);
                    target.setKeepAliveTime(val);
                    break;
                }
                case "max-pool-size": {
                    String val = asText(node);
                    target.setMaxPoolSize(val);
                    break;
                }
                case "max-queue-size": {
                    String val = asText(node);
                    target.setMaxQueueSize(val);
                    break;
                }
                case "pool-size": {
                    String val = asText(node);
                    target.setPoolSize(val);
                    break;
                }
                case "rejected-policy": {
                    String val = asText(node);
                    target.setRejectedPolicy(val);
                    break;
                }
                case "time-unit": {
                    String val = asText(node);
                    target.setTimeUnit(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.ThreadsDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "threads",
            properties = {
                    @YamlProperty(name = "allow-core-thread-time-out", type = "boolean"),
                    @YamlProperty(name = "caller-runs-when-rejected", type = "string"),
                    @YamlProperty(name = "executor-service-ref", type = "string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "keep-alive-time", type = "number"),
                    @YamlProperty(name = "max-pool-size", type = "number"),
                    @YamlProperty(name = "max-queue-size", type = "number"),
                    @YamlProperty(name = "pool-size", type = "number"),
                    @YamlProperty(name = "rejected-policy", type = "string"),
                    @YamlProperty(name = "thread-name", type = "string"),
                    @YamlProperty(name = "time-unit", type = "string")
            }
    )
    public static class ThreadsDefinitionDeserializer extends YamlDeserializerBase<ThreadsDefinition> {
        public ThreadsDefinitionDeserializer() {
            super(ThreadsDefinition.class);
        }

        @Override
        protected ThreadsDefinition newInstance() {
            return new ThreadsDefinition();
        }

        @Override
        protected boolean setProperty(ThreadsDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-core-thread-time-out": {
                    String val = asText(node);
                    target.setAllowCoreThreadTimeOut(val);
                    break;
                }
                case "caller-runs-when-rejected": {
                    String val = asText(node);
                    target.setCallerRunsWhenRejected(val);
                    break;
                }
                case "executor-service-ref": {
                    String val = asText(node);
                    target.setExecutorServiceRef(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "keep-alive-time": {
                    String val = asText(node);
                    target.setKeepAliveTime(val);
                    break;
                }
                case "max-pool-size": {
                    String val = asText(node);
                    target.setMaxPoolSize(val);
                    break;
                }
                case "max-queue-size": {
                    String val = asText(node);
                    target.setMaxQueueSize(val);
                    break;
                }
                case "pool-size": {
                    String val = asText(node);
                    target.setPoolSize(val);
                    break;
                }
                case "rejected-policy": {
                    String val = asText(node);
                    target.setRejectedPolicy(val);
                    break;
                }
                case "thread-name": {
                    String val = asText(node);
                    target.setThreadName(val);
                    break;
                }
                case "time-unit": {
                    String val = asText(node);
                    target.setTimeUnit(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.dataformat.ThriftDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "thrift",
            properties = {
                    @YamlProperty(name = "content-type-format", type = "string"),
                    @YamlProperty(name = "content-type-header", type = "boolean"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "instance-class", type = "string")
            }
    )
    public static class ThriftDataFormatDeserializer extends YamlDeserializerBase<ThriftDataFormat> {
        public ThriftDataFormatDeserializer() {
            super(ThriftDataFormat.class);
        }

        @Override
        protected ThriftDataFormat newInstance() {
            return new ThriftDataFormat();
        }

        @Override
        protected ThriftDataFormat newInstance(String value) {
            return new ThriftDataFormat(value);
        }

        @Override
        protected boolean setProperty(ThriftDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "content-type-format": {
                    String val = asText(node);
                    target.setContentTypeFormat(val);
                    break;
                }
                case "content-type-header": {
                    String val = asText(node);
                    target.setContentTypeHeader(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "instance-class": {
                    String val = asText(node);
                    target.setInstanceClass(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.ThrottleDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "throttle",
            properties = {
                    @YamlProperty(name = "async-delayed", type = "boolean"),
                    @YamlProperty(name = "caller-runs-when-rejected", type = "boolean"),
                    @YamlProperty(name = "correlation-expression", type = "object:org.apache.camel.model.ExpressionSubElementDefinition"),
                    @YamlProperty(name = "executor-service-ref", type = "string"),
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "reject-execution", type = "boolean"),
                    @YamlProperty(name = "time-period-millis", type = "string"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class ThrottleDefinitionDeserializer extends YamlDeserializerBase<ThrottleDefinition> {
        public ThrottleDefinitionDeserializer() {
            super(ThrottleDefinition.class);
        }

        @Override
        protected ThrottleDefinition newInstance() {
            return new ThrottleDefinition();
        }

        @Override
        protected boolean setProperty(ThrottleDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "async-delayed": {
                    String val = asText(node);
                    target.setAsyncDelayed(val);
                    break;
                }
                case "caller-runs-when-rejected": {
                    String val = asText(node);
                    target.setCallerRunsWhenRejected(val);
                    break;
                }
                case "correlation-expression": {
                    org.apache.camel.model.ExpressionSubElementDefinition val = asType(node, org.apache.camel.model.ExpressionSubElementDefinition.class);
                    target.setCorrelationExpression(val);
                    break;
                }
                case "executor-service-ref": {
                    String val = asText(node);
                    target.setExecutorServiceRef(val);
                    break;
                }
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "reject-execution": {
                    String val = asText(node);
                    target.setRejectExecution(val);
                    break;
                }
                case "time-period-millis": {
                    String val = asText(node);
                    target.setTimePeriodMillis(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.ThrowExceptionDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "throw-exception",
            properties = {
                    @YamlProperty(name = "exception-type", type = "string"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "message", type = "string"),
                    @YamlProperty(name = "ref", type = "string")
            }
    )
    public static class ThrowExceptionDefinitionDeserializer extends YamlDeserializerBase<ThrowExceptionDefinition> {
        public ThrowExceptionDefinitionDeserializer() {
            super(ThrowExceptionDefinition.class);
        }

        @Override
        protected ThrowExceptionDefinition newInstance() {
            return new ThrowExceptionDefinition();
        }

        @Override
        protected boolean setProperty(ThrowExceptionDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "exception-type": {
                    String val = asText(node);
                    target.setExceptionType(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "message": {
                    String val = asText(node);
                    target.setMessage(val);
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.TidyMarkupDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "tidy-markup",
            properties = {
                    @YamlProperty(name = "data-object-type", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "omit-xml-declaration", type = "boolean")
            }
    )
    public static class TidyMarkupDataFormatDeserializer extends YamlDeserializerBase<TidyMarkupDataFormat> {
        public TidyMarkupDataFormatDeserializer() {
            super(TidyMarkupDataFormat.class);
        }

        @Override
        protected TidyMarkupDataFormat newInstance() {
            return new TidyMarkupDataFormat();
        }

        @Override
        protected boolean setProperty(TidyMarkupDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "data-object-type": {
                    String val = asText(node);
                    target.setDataObjectTypeName(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "omit-xml-declaration": {
                    String val = asText(node);
                    target.setOmitXmlDeclaration(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.ToDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "to",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "pattern", type = "string"),
                    @YamlProperty(name = "uri", type = "string", required = true)
            }
    )
    public static class ToDefinitionDeserializer extends YamlDeserializerBase<ToDefinition> {
        public ToDefinitionDeserializer() {
            super(ToDefinition.class);
        }

        @Override
        protected ToDefinition newInstance() {
            return new ToDefinition();
        }

        @Override
        protected ToDefinition newInstance(String value) {
            return new ToDefinition(value);
        }

        @Override
        protected boolean setProperty(ToDefinition target, String propertyKey, String propertyName,
                Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "pattern": {
                    String val = asText(node);
                    target.setPattern(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.ToDynamicDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "to-d",
            properties = {
                    @YamlProperty(name = "allow-optimised-components", type = "boolean"),
                    @YamlProperty(name = "auto-start-components", type = "boolean"),
                    @YamlProperty(name = "cache-size", type = "number"),
                    @YamlProperty(name = "ignore-invalid-endpoint", type = "boolean"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "pattern", type = "string"),
                    @YamlProperty(name = "uri", type = "string", required = true)
            }
    )
    public static class ToDynamicDefinitionDeserializer extends YamlDeserializerBase<ToDynamicDefinition> {
        public ToDynamicDefinitionDeserializer() {
            super(ToDynamicDefinition.class);
        }

        @Override
        protected ToDynamicDefinition newInstance() {
            return new ToDynamicDefinition();
        }

        @Override
        protected ToDynamicDefinition newInstance(String value) {
            return new ToDynamicDefinition(value);
        }

        @Override
        protected boolean setProperty(ToDynamicDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-optimised-components": {
                    String val = asText(node);
                    target.setAllowOptimisedComponents(val);
                    break;
                }
                case "auto-start-components": {
                    String val = asText(node);
                    target.setAutoStartComponents(val);
                    break;
                }
                case "cache-size": {
                    String val = asText(node);
                    target.setCacheSize(val);
                    break;
                }
                case "ignore-invalid-endpoint": {
                    String val = asText(node);
                    target.setIgnoreInvalidEndpoint(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "pattern": {
                    String val = asText(node);
                    target.setPattern(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.TokenizerExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "tokenize",
            properties = {
                    @YamlProperty(name = "end-token", type = "string"),
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "group", type = "string"),
                    @YamlProperty(name = "group-delimiter", type = "string"),
                    @YamlProperty(name = "header-name", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "include-tokens", type = "boolean"),
                    @YamlProperty(name = "inherit-namespace-tag-name", type = "string"),
                    @YamlProperty(name = "regex", type = "boolean"),
                    @YamlProperty(name = "skip-first", type = "boolean"),
                    @YamlProperty(name = "token", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean"),
                    @YamlProperty(name = "xml", type = "boolean")
            }
    )
    public static class TokenizerExpressionDeserializer extends YamlDeserializerBase<TokenizerExpression> {
        public TokenizerExpressionDeserializer() {
            super(TokenizerExpression.class);
        }

        @Override
        protected TokenizerExpression newInstance() {
            return new TokenizerExpression();
        }

        @Override
        protected TokenizerExpression newInstance(String value) {
            return new TokenizerExpression(value);
        }

        @Override
        protected boolean setProperty(TokenizerExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "end-token": {
                    String val = asText(node);
                    target.setEndToken(val);
                    break;
                }
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "group": {
                    String val = asText(node);
                    target.setGroup(val);
                    break;
                }
                case "group-delimiter": {
                    String val = asText(node);
                    target.setGroupDelimiter(val);
                    break;
                }
                case "header-name": {
                    String val = asText(node);
                    target.setHeaderName(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "include-tokens": {
                    String val = asText(node);
                    target.setIncludeTokens(val);
                    break;
                }
                case "inherit-namespace-tag-name": {
                    String val = asText(node);
                    target.setInheritNamespaceTagName(val);
                    break;
                }
                case "regex": {
                    String val = asText(node);
                    target.setRegex(val);
                    break;
                }
                case "skip-first": {
                    String val = asText(node);
                    target.setSkipFirst(val);
                    break;
                }
                case "token": {
                    String val = asText(node);
                    target.setToken(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                case "xml": {
                    String val = asText(node);
                    target.setXml(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.loadbalancer.TopicLoadBalancerDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "topic",
            properties = @YamlProperty(name = "id", type = "string")
    )
    public static class TopicLoadBalancerDefinitionDeserializer extends YamlDeserializerBase<TopicLoadBalancerDefinition> {
        public TopicLoadBalancerDefinitionDeserializer() {
            super(TopicLoadBalancerDefinition.class);
        }

        @Override
        protected TopicLoadBalancerDefinition newInstance() {
            return new TopicLoadBalancerDefinition();
        }

        @Override
        protected boolean setProperty(TopicLoadBalancerDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.TransactedDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "transacted",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "ref", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class TransactedDefinitionDeserializer extends YamlDeserializerBase<TransactedDefinition> {
        public TransactedDefinitionDeserializer() {
            super(TransactedDefinition.class);
        }

        @Override
        protected TransactedDefinition newInstance() {
            return new TransactedDefinition();
        }

        @Override
        protected boolean setProperty(TransactedDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "ref": {
                    String val = asText(node);
                    target.setRef(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.TransformDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "transform",
            properties = {
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class TransformDefinitionDeserializer extends YamlDeserializerBase<TransformDefinition> {
        public TransformDefinitionDeserializer() {
            super(TransformDefinition.class);
        }

        @Override
        protected TransformDefinition newInstance() {
            return new TransformDefinition();
        }

        @Override
        protected boolean setProperty(TransformDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.transformer.TransformersDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "transformers",
            properties = {
                    @YamlProperty(name = "data-format-transformer", type = "object:org.apache.camel.model.transformer.DataFormatTransformerDefinition"),
                    @YamlProperty(name = "endpoint-transformer", type = "object:org.apache.camel.model.transformer.EndpointTransformerDefinition"),
                    @YamlProperty(name = "custom-transformer", type = "object:org.apache.camel.model.transformer.CustomTransformerDefinition")
            }
    )
    public static class TransformersDefinitionDeserializer extends YamlDeserializerBase<TransformersDefinition> {
        public TransformersDefinitionDeserializer() {
            super(TransformersDefinition.class);
        }

        @Override
        protected TransformersDefinition newInstance() {
            return new TransformersDefinition();
        }

        @Override
        protected boolean setProperty(TransformersDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "transformers": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "data-format-transformer": {
                    org.apache.camel.model.transformer.DataFormatTransformerDefinition val = asType(node, org.apache.camel.model.transformer.DataFormatTransformerDefinition.class);
                    java.util.List<org.apache.camel.model.transformer.TransformerDefinition> existing = target.getTransformers();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setTransformers(existing);
                    break;
                }
                case "endpoint-transformer": {
                    org.apache.camel.model.transformer.EndpointTransformerDefinition val = asType(node, org.apache.camel.model.transformer.EndpointTransformerDefinition.class);
                    java.util.List<org.apache.camel.model.transformer.TransformerDefinition> existing = target.getTransformers();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setTransformers(existing);
                    break;
                }
                case "custom-transformer": {
                    org.apache.camel.model.transformer.CustomTransformerDefinition val = asType(node, org.apache.camel.model.transformer.CustomTransformerDefinition.class);
                    java.util.List<org.apache.camel.model.transformer.TransformerDefinition> existing = target.getTransformers();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setTransformers(existing);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.TryDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "do-try",
            properties = {
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class TryDefinitionDeserializer extends YamlDeserializerBase<TryDefinition> {
        public TryDefinitionDeserializer() {
            super(TryDefinition.class);
        }

        @Override
        protected TryDefinition newInstance() {
            return new TryDefinition();
        }

        @Override
        protected boolean setProperty(TryDefinition target, String propertyKey, String propertyName,
                Node node) {
            switch(propertyKey) {
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.UniVocityCsvDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "univocity-csv",
            properties = {
                    @YamlProperty(name = "as-map", type = "boolean"),
                    @YamlProperty(name = "comment", type = "string"),
                    @YamlProperty(name = "delimiter", type = "string"),
                    @YamlProperty(name = "empty-value", type = "string"),
                    @YamlProperty(name = "header-extraction-enabled", type = "boolean"),
                    @YamlProperty(name = "headers", type = "array:org.apache.camel.model.dataformat.UniVocityHeader"),
                    @YamlProperty(name = "headers-disabled", type = "boolean"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "ignore-leading-whitespaces", type = "boolean"),
                    @YamlProperty(name = "ignore-trailing-whitespaces", type = "boolean"),
                    @YamlProperty(name = "lazy-load", type = "boolean"),
                    @YamlProperty(name = "line-separator", type = "string"),
                    @YamlProperty(name = "normalized-line-separator", type = "string"),
                    @YamlProperty(name = "null-value", type = "string"),
                    @YamlProperty(name = "number-of-records-to-read", type = "number"),
                    @YamlProperty(name = "quote", type = "string"),
                    @YamlProperty(name = "quote-all-fields", type = "boolean"),
                    @YamlProperty(name = "quote-escape", type = "string"),
                    @YamlProperty(name = "skip-empty-lines", type = "boolean")
            }
    )
    public static class UniVocityCsvDataFormatDeserializer extends YamlDeserializerBase<UniVocityCsvDataFormat> {
        public UniVocityCsvDataFormatDeserializer() {
            super(UniVocityCsvDataFormat.class);
        }

        @Override
        protected UniVocityCsvDataFormat newInstance() {
            return new UniVocityCsvDataFormat();
        }

        @Override
        protected boolean setProperty(UniVocityCsvDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "as-map": {
                    String val = asText(node);
                    target.setAsMap(val);
                    break;
                }
                case "comment": {
                    String val = asText(node);
                    target.setComment(val);
                    break;
                }
                case "delimiter": {
                    String val = asText(node);
                    target.setDelimiter(val);
                    break;
                }
                case "empty-value": {
                    String val = asText(node);
                    target.setEmptyValue(val);
                    break;
                }
                case "header-extraction-enabled": {
                    String val = asText(node);
                    target.setHeaderExtractionEnabled(val);
                    break;
                }
                case "univocity-header": {
                    java.util.List<org.apache.camel.model.dataformat.UniVocityHeader> val = asFlatList(node, org.apache.camel.model.dataformat.UniVocityHeader.class);
                    target.setHeaders(val);
                    break;
                }
                case "headers-disabled": {
                    String val = asText(node);
                    target.setHeadersDisabled(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "ignore-leading-whitespaces": {
                    String val = asText(node);
                    target.setIgnoreLeadingWhitespaces(val);
                    break;
                }
                case "ignore-trailing-whitespaces": {
                    String val = asText(node);
                    target.setIgnoreTrailingWhitespaces(val);
                    break;
                }
                case "lazy-load": {
                    String val = asText(node);
                    target.setLazyLoad(val);
                    break;
                }
                case "line-separator": {
                    String val = asText(node);
                    target.setLineSeparator(val);
                    break;
                }
                case "normalized-line-separator": {
                    String val = asText(node);
                    target.setNormalizedLineSeparator(val);
                    break;
                }
                case "null-value": {
                    String val = asText(node);
                    target.setNullValue(val);
                    break;
                }
                case "number-of-records-to-read": {
                    String val = asText(node);
                    target.setNumberOfRecordsToRead(val);
                    break;
                }
                case "quote": {
                    String val = asText(node);
                    target.setQuote(val);
                    break;
                }
                case "quote-all-fields": {
                    String val = asText(node);
                    target.setQuoteAllFields(val);
                    break;
                }
                case "quote-escape": {
                    String val = asText(node);
                    target.setQuoteEscape(val);
                    break;
                }
                case "skip-empty-lines": {
                    String val = asText(node);
                    target.setSkipEmptyLines(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "univocity-fixed",
            properties = {
                    @YamlProperty(name = "as-map", type = "boolean"),
                    @YamlProperty(name = "comment", type = "string"),
                    @YamlProperty(name = "empty-value", type = "string"),
                    @YamlProperty(name = "header-extraction-enabled", type = "boolean"),
                    @YamlProperty(name = "headers", type = "array:org.apache.camel.model.dataformat.UniVocityHeader"),
                    @YamlProperty(name = "headers-disabled", type = "boolean"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "ignore-leading-whitespaces", type = "boolean"),
                    @YamlProperty(name = "ignore-trailing-whitespaces", type = "boolean"),
                    @YamlProperty(name = "lazy-load", type = "boolean"),
                    @YamlProperty(name = "line-separator", type = "string"),
                    @YamlProperty(name = "normalized-line-separator", type = "string"),
                    @YamlProperty(name = "null-value", type = "string"),
                    @YamlProperty(name = "number-of-records-to-read", type = "number"),
                    @YamlProperty(name = "padding", type = "string"),
                    @YamlProperty(name = "record-ends-on-newline", type = "boolean"),
                    @YamlProperty(name = "skip-empty-lines", type = "boolean"),
                    @YamlProperty(name = "skip-trailing-chars-until-newline", type = "boolean")
            }
    )
    public static class UniVocityFixedWidthDataFormatDeserializer extends YamlDeserializerBase<UniVocityFixedWidthDataFormat> {
        public UniVocityFixedWidthDataFormatDeserializer() {
            super(UniVocityFixedWidthDataFormat.class);
        }

        @Override
        protected UniVocityFixedWidthDataFormat newInstance() {
            return new UniVocityFixedWidthDataFormat();
        }

        @Override
        protected boolean setProperty(UniVocityFixedWidthDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "as-map": {
                    String val = asText(node);
                    target.setAsMap(val);
                    break;
                }
                case "comment": {
                    String val = asText(node);
                    target.setComment(val);
                    break;
                }
                case "empty-value": {
                    String val = asText(node);
                    target.setEmptyValue(val);
                    break;
                }
                case "header-extraction-enabled": {
                    String val = asText(node);
                    target.setHeaderExtractionEnabled(val);
                    break;
                }
                case "univocity-header": {
                    java.util.List<org.apache.camel.model.dataformat.UniVocityHeader> val = asFlatList(node, org.apache.camel.model.dataformat.UniVocityHeader.class);
                    target.setHeaders(val);
                    break;
                }
                case "headers-disabled": {
                    String val = asText(node);
                    target.setHeadersDisabled(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "ignore-leading-whitespaces": {
                    String val = asText(node);
                    target.setIgnoreLeadingWhitespaces(val);
                    break;
                }
                case "ignore-trailing-whitespaces": {
                    String val = asText(node);
                    target.setIgnoreTrailingWhitespaces(val);
                    break;
                }
                case "lazy-load": {
                    String val = asText(node);
                    target.setLazyLoad(val);
                    break;
                }
                case "line-separator": {
                    String val = asText(node);
                    target.setLineSeparator(val);
                    break;
                }
                case "normalized-line-separator": {
                    String val = asText(node);
                    target.setNormalizedLineSeparator(val);
                    break;
                }
                case "null-value": {
                    String val = asText(node);
                    target.setNullValue(val);
                    break;
                }
                case "number-of-records-to-read": {
                    String val = asText(node);
                    target.setNumberOfRecordsToRead(val);
                    break;
                }
                case "padding": {
                    String val = asText(node);
                    target.setPadding(val);
                    break;
                }
                case "record-ends-on-newline": {
                    String val = asText(node);
                    target.setRecordEndsOnNewline(val);
                    break;
                }
                case "skip-empty-lines": {
                    String val = asText(node);
                    target.setSkipEmptyLines(val);
                    break;
                }
                case "skip-trailing-chars-until-newline": {
                    String val = asText(node);
                    target.setSkipTrailingCharsUntilNewline(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.UniVocityHeader.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "univocity-header",
            properties = {
                    @YamlProperty(name = "length", type = "string"),
                    @YamlProperty(name = "name", type = "string")
            }
    )
    public static class UniVocityHeaderDeserializer extends YamlDeserializerBase<UniVocityHeader> {
        public UniVocityHeaderDeserializer() {
            super(UniVocityHeader.class);
        }

        @Override
        protected UniVocityHeader newInstance() {
            return new UniVocityHeader();
        }

        @Override
        protected boolean setProperty(UniVocityHeader target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "length": {
                    String val = asText(node);
                    target.setLength(val);
                    break;
                }
                case "name": {
                    String val = asText(node);
                    target.setName(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.UniVocityTsvDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "univocity-tsv",
            properties = {
                    @YamlProperty(name = "as-map", type = "boolean"),
                    @YamlProperty(name = "comment", type = "string"),
                    @YamlProperty(name = "empty-value", type = "string"),
                    @YamlProperty(name = "escape-char", type = "string"),
                    @YamlProperty(name = "header-extraction-enabled", type = "boolean"),
                    @YamlProperty(name = "headers", type = "array:org.apache.camel.model.dataformat.UniVocityHeader"),
                    @YamlProperty(name = "headers-disabled", type = "boolean"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "ignore-leading-whitespaces", type = "boolean"),
                    @YamlProperty(name = "ignore-trailing-whitespaces", type = "boolean"),
                    @YamlProperty(name = "lazy-load", type = "boolean"),
                    @YamlProperty(name = "line-separator", type = "string"),
                    @YamlProperty(name = "normalized-line-separator", type = "string"),
                    @YamlProperty(name = "null-value", type = "string"),
                    @YamlProperty(name = "number-of-records-to-read", type = "number"),
                    @YamlProperty(name = "skip-empty-lines", type = "boolean")
            }
    )
    public static class UniVocityTsvDataFormatDeserializer extends YamlDeserializerBase<UniVocityTsvDataFormat> {
        public UniVocityTsvDataFormatDeserializer() {
            super(UniVocityTsvDataFormat.class);
        }

        @Override
        protected UniVocityTsvDataFormat newInstance() {
            return new UniVocityTsvDataFormat();
        }

        @Override
        protected boolean setProperty(UniVocityTsvDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "as-map": {
                    String val = asText(node);
                    target.setAsMap(val);
                    break;
                }
                case "comment": {
                    String val = asText(node);
                    target.setComment(val);
                    break;
                }
                case "empty-value": {
                    String val = asText(node);
                    target.setEmptyValue(val);
                    break;
                }
                case "escape-char": {
                    String val = asText(node);
                    target.setEscapeChar(val);
                    break;
                }
                case "header-extraction-enabled": {
                    String val = asText(node);
                    target.setHeaderExtractionEnabled(val);
                    break;
                }
                case "univocity-header": {
                    java.util.List<org.apache.camel.model.dataformat.UniVocityHeader> val = asFlatList(node, org.apache.camel.model.dataformat.UniVocityHeader.class);
                    target.setHeaders(val);
                    break;
                }
                case "headers-disabled": {
                    String val = asText(node);
                    target.setHeadersDisabled(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "ignore-leading-whitespaces": {
                    String val = asText(node);
                    target.setIgnoreLeadingWhitespaces(val);
                    break;
                }
                case "ignore-trailing-whitespaces": {
                    String val = asText(node);
                    target.setIgnoreTrailingWhitespaces(val);
                    break;
                }
                case "lazy-load": {
                    String val = asText(node);
                    target.setLazyLoad(val);
                    break;
                }
                case "line-separator": {
                    String val = asText(node);
                    target.setLineSeparator(val);
                    break;
                }
                case "normalized-line-separator": {
                    String val = asText(node);
                    target.setNormalizedLineSeparator(val);
                    break;
                }
                case "null-value": {
                    String val = asText(node);
                    target.setNullValue(val);
                    break;
                }
                case "number-of-records-to-read": {
                    String val = asText(node);
                    target.setNumberOfRecordsToRead(val);
                    break;
                }
                case "skip-empty-lines": {
                    String val = asText(node);
                    target.setSkipEmptyLines(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.UnmarshalDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "unmarshal",
            properties = {
                    @YamlProperty(name = "any23", type = "object:org.apache.camel.model.dataformat.Any23DataFormat"),
                    @YamlProperty(name = "asn1", type = "object:org.apache.camel.model.dataformat.ASN1DataFormat"),
                    @YamlProperty(name = "avro", type = "object:org.apache.camel.model.dataformat.AvroDataFormat"),
                    @YamlProperty(name = "barcode", type = "object:org.apache.camel.model.dataformat.BarcodeDataFormat"),
                    @YamlProperty(name = "base64", type = "object:org.apache.camel.model.dataformat.Base64DataFormat"),
                    @YamlProperty(name = "beanio", type = "object:org.apache.camel.model.dataformat.BeanioDataFormat"),
                    @YamlProperty(name = "bindy", type = "object:org.apache.camel.model.dataformat.BindyDataFormat"),
                    @YamlProperty(name = "cbor", type = "object:org.apache.camel.model.dataformat.CBORDataFormat"),
                    @YamlProperty(name = "crypto", type = "object:org.apache.camel.model.dataformat.CryptoDataFormat"),
                    @YamlProperty(name = "csv", type = "object:org.apache.camel.model.dataformat.CsvDataFormat"),
                    @YamlProperty(name = "custom", type = "object:org.apache.camel.model.dataformat.CustomDataFormat"),
                    @YamlProperty(name = "fhir-json", type = "object:org.apache.camel.model.dataformat.FhirJsonDataFormat"),
                    @YamlProperty(name = "fhir-xml", type = "object:org.apache.camel.model.dataformat.FhirXmlDataFormat"),
                    @YamlProperty(name = "flatpack", type = "object:org.apache.camel.model.dataformat.FlatpackDataFormat"),
                    @YamlProperty(name = "grok", type = "object:org.apache.camel.model.dataformat.GrokDataFormat"),
                    @YamlProperty(name = "gzip", type = "object:org.apache.camel.model.dataformat.GzipDataFormat"),
                    @YamlProperty(name = "hl7", type = "object:org.apache.camel.model.dataformat.HL7DataFormat"),
                    @YamlProperty(name = "ical", type = "object:org.apache.camel.model.dataformat.IcalDataFormat"),
                    @YamlProperty(name = "jacksonxml", type = "object:org.apache.camel.model.dataformat.JacksonXMLDataFormat"),
                    @YamlProperty(name = "jaxb", type = "object:org.apache.camel.model.dataformat.JaxbDataFormat"),
                    @YamlProperty(name = "json", type = "object:org.apache.camel.model.dataformat.JsonDataFormat"),
                    @YamlProperty(name = "json-api", type = "object:org.apache.camel.model.dataformat.JsonApiDataFormat"),
                    @YamlProperty(name = "lzf", type = "object:org.apache.camel.model.dataformat.LZFDataFormat"),
                    @YamlProperty(name = "mime-multipart", type = "object:org.apache.camel.model.dataformat.MimeMultipartDataFormat"),
                    @YamlProperty(name = "protobuf", type = "object:org.apache.camel.model.dataformat.ProtobufDataFormat"),
                    @YamlProperty(name = "rss", type = "object:org.apache.camel.model.dataformat.RssDataFormat"),
                    @YamlProperty(name = "secure-xml", type = "object:org.apache.camel.model.dataformat.XMLSecurityDataFormat"),
                    @YamlProperty(name = "soapjaxb", type = "object:org.apache.camel.model.dataformat.SoapJaxbDataFormat"),
                    @YamlProperty(name = "syslog", type = "object:org.apache.camel.model.dataformat.SyslogDataFormat"),
                    @YamlProperty(name = "tarfile", type = "object:org.apache.camel.model.dataformat.TarFileDataFormat"),
                    @YamlProperty(name = "thrift", type = "object:org.apache.camel.model.dataformat.ThriftDataFormat"),
                    @YamlProperty(name = "tidy-markup", type = "object:org.apache.camel.model.dataformat.TidyMarkupDataFormat"),
                    @YamlProperty(name = "univocity-csv", type = "object:org.apache.camel.model.dataformat.UniVocityCsvDataFormat"),
                    @YamlProperty(name = "univocity-fixed", type = "object:org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat"),
                    @YamlProperty(name = "univocity-tsv", type = "object:org.apache.camel.model.dataformat.UniVocityTsvDataFormat"),
                    @YamlProperty(name = "xmlrpc", type = "object:org.apache.camel.model.dataformat.XmlRpcDataFormat"),
                    @YamlProperty(name = "xstream", type = "object:org.apache.camel.model.dataformat.XStreamDataFormat"),
                    @YamlProperty(name = "pgp", type = "object:org.apache.camel.model.dataformat.PGPDataFormat"),
                    @YamlProperty(name = "yaml", type = "object:org.apache.camel.model.dataformat.YAMLDataFormat"),
                    @YamlProperty(name = "zip", type = "object:org.apache.camel.model.dataformat.ZipDeflaterDataFormat"),
                    @YamlProperty(name = "zipfile", type = "object:org.apache.camel.model.dataformat.ZipFileDataFormat"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean")
            }
    )
    public static class UnmarshalDefinitionDeserializer extends YamlDeserializerBase<UnmarshalDefinition> {
        public UnmarshalDefinitionDeserializer() {
            super(UnmarshalDefinition.class);
        }

        @Override
        protected UnmarshalDefinition newInstance() {
            return new UnmarshalDefinition();
        }

        @Override
        protected boolean setProperty(UnmarshalDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "data-format-type": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "any23": {
                    org.apache.camel.model.dataformat.Any23DataFormat val = asType(node, org.apache.camel.model.dataformat.Any23DataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "asn1": {
                    org.apache.camel.model.dataformat.ASN1DataFormat val = asType(node, org.apache.camel.model.dataformat.ASN1DataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "avro": {
                    org.apache.camel.model.dataformat.AvroDataFormat val = asType(node, org.apache.camel.model.dataformat.AvroDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "barcode": {
                    org.apache.camel.model.dataformat.BarcodeDataFormat val = asType(node, org.apache.camel.model.dataformat.BarcodeDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "base64": {
                    org.apache.camel.model.dataformat.Base64DataFormat val = asType(node, org.apache.camel.model.dataformat.Base64DataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "beanio": {
                    org.apache.camel.model.dataformat.BeanioDataFormat val = asType(node, org.apache.camel.model.dataformat.BeanioDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "bindy": {
                    org.apache.camel.model.dataformat.BindyDataFormat val = asType(node, org.apache.camel.model.dataformat.BindyDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "cbor": {
                    org.apache.camel.model.dataformat.CBORDataFormat val = asType(node, org.apache.camel.model.dataformat.CBORDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "crypto": {
                    org.apache.camel.model.dataformat.CryptoDataFormat val = asType(node, org.apache.camel.model.dataformat.CryptoDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "csv": {
                    org.apache.camel.model.dataformat.CsvDataFormat val = asType(node, org.apache.camel.model.dataformat.CsvDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "custom": {
                    org.apache.camel.model.dataformat.CustomDataFormat val = asType(node, org.apache.camel.model.dataformat.CustomDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "fhir-json": {
                    org.apache.camel.model.dataformat.FhirJsonDataFormat val = asType(node, org.apache.camel.model.dataformat.FhirJsonDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "fhir-xml": {
                    org.apache.camel.model.dataformat.FhirXmlDataFormat val = asType(node, org.apache.camel.model.dataformat.FhirXmlDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "flatpack": {
                    org.apache.camel.model.dataformat.FlatpackDataFormat val = asType(node, org.apache.camel.model.dataformat.FlatpackDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "grok": {
                    org.apache.camel.model.dataformat.GrokDataFormat val = asType(node, org.apache.camel.model.dataformat.GrokDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "gzip": {
                    org.apache.camel.model.dataformat.GzipDataFormat val = asType(node, org.apache.camel.model.dataformat.GzipDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "hl7": {
                    org.apache.camel.model.dataformat.HL7DataFormat val = asType(node, org.apache.camel.model.dataformat.HL7DataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "ical": {
                    org.apache.camel.model.dataformat.IcalDataFormat val = asType(node, org.apache.camel.model.dataformat.IcalDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "jacksonxml": {
                    org.apache.camel.model.dataformat.JacksonXMLDataFormat val = asType(node, org.apache.camel.model.dataformat.JacksonXMLDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "jaxb": {
                    org.apache.camel.model.dataformat.JaxbDataFormat val = asType(node, org.apache.camel.model.dataformat.JaxbDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "json": {
                    org.apache.camel.model.dataformat.JsonDataFormat val = asType(node, org.apache.camel.model.dataformat.JsonDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "json-api": {
                    org.apache.camel.model.dataformat.JsonApiDataFormat val = asType(node, org.apache.camel.model.dataformat.JsonApiDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "lzf": {
                    org.apache.camel.model.dataformat.LZFDataFormat val = asType(node, org.apache.camel.model.dataformat.LZFDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "mime-multipart": {
                    org.apache.camel.model.dataformat.MimeMultipartDataFormat val = asType(node, org.apache.camel.model.dataformat.MimeMultipartDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "protobuf": {
                    org.apache.camel.model.dataformat.ProtobufDataFormat val = asType(node, org.apache.camel.model.dataformat.ProtobufDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "rss": {
                    org.apache.camel.model.dataformat.RssDataFormat val = asType(node, org.apache.camel.model.dataformat.RssDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "secure-xml": {
                    org.apache.camel.model.dataformat.XMLSecurityDataFormat val = asType(node, org.apache.camel.model.dataformat.XMLSecurityDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "soapjaxb": {
                    org.apache.camel.model.dataformat.SoapJaxbDataFormat val = asType(node, org.apache.camel.model.dataformat.SoapJaxbDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "syslog": {
                    org.apache.camel.model.dataformat.SyslogDataFormat val = asType(node, org.apache.camel.model.dataformat.SyslogDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "tarfile": {
                    org.apache.camel.model.dataformat.TarFileDataFormat val = asType(node, org.apache.camel.model.dataformat.TarFileDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "thrift": {
                    org.apache.camel.model.dataformat.ThriftDataFormat val = asType(node, org.apache.camel.model.dataformat.ThriftDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "tidy-markup": {
                    org.apache.camel.model.dataformat.TidyMarkupDataFormat val = asType(node, org.apache.camel.model.dataformat.TidyMarkupDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "univocity-csv": {
                    org.apache.camel.model.dataformat.UniVocityCsvDataFormat val = asType(node, org.apache.camel.model.dataformat.UniVocityCsvDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "univocity-fixed": {
                    org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat val = asType(node, org.apache.camel.model.dataformat.UniVocityFixedWidthDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "univocity-tsv": {
                    org.apache.camel.model.dataformat.UniVocityTsvDataFormat val = asType(node, org.apache.camel.model.dataformat.UniVocityTsvDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "xmlrpc": {
                    org.apache.camel.model.dataformat.XmlRpcDataFormat val = asType(node, org.apache.camel.model.dataformat.XmlRpcDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "xstream": {
                    org.apache.camel.model.dataformat.XStreamDataFormat val = asType(node, org.apache.camel.model.dataformat.XStreamDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "pgp": {
                    org.apache.camel.model.dataformat.PGPDataFormat val = asType(node, org.apache.camel.model.dataformat.PGPDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "yaml": {
                    org.apache.camel.model.dataformat.YAMLDataFormat val = asType(node, org.apache.camel.model.dataformat.YAMLDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "zip": {
                    org.apache.camel.model.dataformat.ZipDeflaterDataFormat val = asType(node, org.apache.camel.model.dataformat.ZipDeflaterDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "zipfile": {
                    org.apache.camel.model.dataformat.ZipFileDataFormat val = asType(node, org.apache.camel.model.dataformat.ZipFileDataFormat.class);
                    target.setDataFormatType(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.ValidateDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "validate",
            properties = {
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class ValidateDefinitionDeserializer extends YamlDeserializerBase<ValidateDefinition> {
        public ValidateDefinitionDeserializer() {
            super(ValidateDefinition.class);
        }

        @Override
        protected ValidateDefinition newInstance() {
            return new ValidateDefinition();
        }

        @Override
        protected boolean setProperty(ValidateDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.validator.ValidatorsDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "validators",
            properties = {
                    @YamlProperty(name = "endpoint-validator", type = "object:org.apache.camel.model.validator.EndpointValidatorDefinition"),
                    @YamlProperty(name = "predicate-validator", type = "object:org.apache.camel.model.validator.PredicateValidatorDefinition"),
                    @YamlProperty(name = "custom-validator", type = "object:org.apache.camel.model.validator.CustomValidatorDefinition")
            }
    )
    public static class ValidatorsDefinitionDeserializer extends YamlDeserializerBase<ValidatorsDefinition> {
        public ValidatorsDefinitionDeserializer() {
            super(ValidatorsDefinition.class);
        }

        @Override
        protected ValidatorsDefinition newInstance() {
            return new ValidatorsDefinition();
        }

        @Override
        protected boolean setProperty(ValidatorsDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "validators": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "endpoint-validator": {
                    org.apache.camel.model.validator.EndpointValidatorDefinition val = asType(node, org.apache.camel.model.validator.EndpointValidatorDefinition.class);
                    java.util.List<org.apache.camel.model.validator.ValidatorDefinition> existing = target.getValidators();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setValidators(existing);
                    break;
                }
                case "predicate-validator": {
                    org.apache.camel.model.validator.PredicateValidatorDefinition val = asType(node, org.apache.camel.model.validator.PredicateValidatorDefinition.class);
                    java.util.List<org.apache.camel.model.validator.ValidatorDefinition> existing = target.getValidators();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setValidators(existing);
                    break;
                }
                case "custom-validator": {
                    org.apache.camel.model.validator.CustomValidatorDefinition val = asType(node, org.apache.camel.model.validator.CustomValidatorDefinition.class);
                    java.util.List<org.apache.camel.model.validator.ValidatorDefinition> existing = target.getValidators();
                    if (existing == null) {
                        existing = new java.util.ArrayList<>();
                    }
                    existing.add(val);
                    target.setValidators(existing);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.rest.VerbDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "verb",
            properties = {
                    @YamlProperty(name = "api-docs", type = "string"),
                    @YamlProperty(name = "binding-mode", type = "string"),
                    @YamlProperty(name = "client-request-validation", type = "string"),
                    @YamlProperty(name = "consumes", type = "string"),
                    @YamlProperty(name = "enable-cors", type = "string"),
                    @YamlProperty(name = "method", type = "string"),
                    @YamlProperty(name = "out-type", type = "string"),
                    @YamlProperty(name = "params", type = "array:org.apache.camel.model.rest.RestOperationParamDefinition"),
                    @YamlProperty(name = "produces", type = "string"),
                    @YamlProperty(name = "response-msgs", type = "array:org.apache.camel.model.rest.RestOperationResponseMsgDefinition"),
                    @YamlProperty(name = "route-id", type = "string"),
                    @YamlProperty(name = "security", type = "array:org.apache.camel.model.rest.SecurityDefinition"),
                    @YamlProperty(name = "skip-binding-on-error-code", type = "string"),
                    @YamlProperty(name = "to", type = "object:org.apache.camel.model.ToDefinition"),
                    @YamlProperty(name = "to-d", type = "object:org.apache.camel.model.ToDynamicDefinition"),
                    @YamlProperty(name = "route", type = "object:org.apache.camel.model.RouteDefinition"),
                    @YamlProperty(name = "type", type = "string"),
                    @YamlProperty(name = "uri", type = "string"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition")
            }
    )
    public static class VerbDefinitionDeserializer extends YamlDeserializerBase<VerbDefinition> {
        public VerbDefinitionDeserializer() {
            super(VerbDefinition.class);
        }

        @Override
        protected VerbDefinition newInstance() {
            return new VerbDefinition();
        }

        @Override
        protected boolean setProperty(VerbDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "api-docs": {
                    String val = asText(node);
                    target.setApiDocs(val);
                    break;
                }
                case "binding-mode": {
                    String val = asText(node);
                    target.setBindingMode(val);
                    break;
                }
                case "client-request-validation": {
                    String val = asText(node);
                    target.setClientRequestValidation(val);
                    break;
                }
                case "consumes": {
                    String val = asText(node);
                    target.setConsumes(val);
                    break;
                }
                case "enable-cors": {
                    String val = asText(node);
                    target.setEnableCORS(val);
                    break;
                }
                case "method": {
                    String val = asText(node);
                    target.setMethod(val);
                    break;
                }
                case "out-type": {
                    String val = asText(node);
                    target.setOutType(val);
                    break;
                }
                case "param": {
                    java.util.List<org.apache.camel.model.rest.RestOperationParamDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationParamDefinition.class);
                    target.setParams(val);
                    break;
                }
                case "produces": {
                    String val = asText(node);
                    target.setProduces(val);
                    break;
                }
                case "response-message": {
                    java.util.List<org.apache.camel.model.rest.RestOperationResponseMsgDefinition> val = asFlatList(node, org.apache.camel.model.rest.RestOperationResponseMsgDefinition.class);
                    target.setResponseMsgs(val);
                    break;
                }
                case "route-id": {
                    String val = asText(node);
                    target.setRouteId(val);
                    break;
                }
                case "security": {
                    java.util.List<org.apache.camel.model.rest.SecurityDefinition> val = asFlatList(node, org.apache.camel.model.rest.SecurityDefinition.class);
                    target.setSecurity(val);
                    break;
                }
                case "skip-binding-on-error-code": {
                    String val = asText(node);
                    target.setSkipBindingOnErrorCode(val);
                    break;
                }
                case "to-or-route": {
                    MappingNode val = asMappingNode(node);
                    setProperties(target, val);
                    break;
                }
                case "to": {
                    org.apache.camel.model.ToDefinition val = asType(node, org.apache.camel.model.ToDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "to-d": {
                    org.apache.camel.model.ToDynamicDefinition val = asType(node, org.apache.camel.model.ToDynamicDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "route": {
                    org.apache.camel.model.RouteDefinition val = asType(node, org.apache.camel.model.RouteDefinition.class);
                    target.setToOrRoute(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.loadbalancer.WeightedLoadBalancerDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "weighted",
            properties = {
                    @YamlProperty(name = "distribution-ratio", type = "string"),
                    @YamlProperty(name = "distribution-ratio-delimiter", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "round-robin", type = "string")
            }
    )
    public static class WeightedLoadBalancerDefinitionDeserializer extends YamlDeserializerBase<WeightedLoadBalancerDefinition> {
        public WeightedLoadBalancerDefinitionDeserializer() {
            super(WeightedLoadBalancerDefinition.class);
        }

        @Override
        protected WeightedLoadBalancerDefinition newInstance() {
            return new WeightedLoadBalancerDefinition();
        }

        @Override
        protected boolean setProperty(WeightedLoadBalancerDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "distribution-ratio": {
                    String val = asText(node);
                    target.setDistributionRatio(val);
                    break;
                }
                case "distribution-ratio-delimiter": {
                    String val = asText(node);
                    target.setDistributionRatioDelimiter(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "round-robin": {
                    String val = asText(node);
                    target.setRoundRobin(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.WhenDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "when",
            properties = {
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class WhenDefinitionDeserializer extends YamlDeserializerBase<WhenDefinition> {
        public WhenDefinitionDeserializer() {
            super(WhenDefinition.class);
        }

        @Override
        protected WhenDefinition newInstance() {
            return new WhenDefinition();
        }

        @Override
        protected boolean setProperty(WhenDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.WhenSkipSendToEndpointDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "when-skip-send-to-endpoint",
            properties = {
                    @YamlProperty(name = "expression", type = "object:org.apache.camel.model.language.ExpressionDefinition"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "steps", type = "array:org.apache.camel.model.ProcessorDefinition"),
                    @YamlProperty(name = "__extends", type = "object:org.apache.camel.model.language.ExpressionDefinition")
            }
    )
    public static class WhenSkipSendToEndpointDefinitionDeserializer extends YamlDeserializerBase<WhenSkipSendToEndpointDefinition> {
        public WhenSkipSendToEndpointDefinitionDeserializer() {
            super(WhenSkipSendToEndpointDefinition.class);
        }

        @Override
        protected WhenSkipSendToEndpointDefinition newInstance() {
            return new WhenSkipSendToEndpointDefinition();
        }

        @Override
        protected boolean setProperty(WhenSkipSendToEndpointDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    org.apache.camel.model.language.ExpressionDefinition val = asType(node, org.apache.camel.model.language.ExpressionDefinition.class);
                    target.setExpression(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "steps": {
                    for (ProcessorDefinition<?> definition: asFlatList(node, ProcessorDefinition.class)) {
                        target.addOutput(definition);
                    }
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.WireTapDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "wire-tap",
            properties = {
                    @YamlProperty(name = "allow-optimised-components", type = "boolean"),
                    @YamlProperty(name = "auto-start-components", type = "boolean"),
                    @YamlProperty(name = "cache-size", type = "number"),
                    @YamlProperty(name = "copy", type = "boolean"),
                    @YamlProperty(name = "dynamic-uri", type = "boolean"),
                    @YamlProperty(name = "executor-service-ref", type = "string"),
                    @YamlProperty(name = "headers", type = "array:org.apache.camel.model.SetHeaderDefinition"),
                    @YamlProperty(name = "ignore-invalid-endpoint", type = "boolean"),
                    @YamlProperty(name = "inherit-error-handler", type = "boolean"),
                    @YamlProperty(name = "body", type = "object:org.apache.camel.model.ExpressionSubElementDefinition"),
                    @YamlProperty(name = "processor-ref", type = "string"),
                    @YamlProperty(name = "on-prepare-ref", type = "string"),
                    @YamlProperty(name = "pattern", type = "string"),
                    @YamlProperty(name = "uri", type = "string", required = true)
            }
    )
    public static class WireTapDefinitionDeserializer extends YamlDeserializerBase<WireTapDefinition> {
        public WireTapDefinitionDeserializer() {
            super(WireTapDefinition.class);
        }

        @Override
        protected WireTapDefinition newInstance() {
            return new WireTapDefinition();
        }

        @Override
        protected boolean setProperty(WireTapDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-optimised-components": {
                    String val = asText(node);
                    target.setAllowOptimisedComponents(val);
                    break;
                }
                case "auto-start-components": {
                    String val = asText(node);
                    target.setAutoStartComponents(val);
                    break;
                }
                case "cache-size": {
                    String val = asText(node);
                    target.setCacheSize(val);
                    break;
                }
                case "copy": {
                    String val = asText(node);
                    target.setCopy(val);
                    break;
                }
                case "dynamic-uri": {
                    String val = asText(node);
                    target.setDynamicUri(val);
                    break;
                }
                case "executor-service-ref": {
                    String val = asText(node);
                    target.setExecutorServiceRef(val);
                    break;
                }
                case "set-header": {
                    java.util.List<org.apache.camel.model.SetHeaderDefinition> val = asFlatList(node, org.apache.camel.model.SetHeaderDefinition.class);
                    target.setHeaders(val);
                    break;
                }
                case "ignore-invalid-endpoint": {
                    String val = asText(node);
                    target.setIgnoreInvalidEndpoint(val);
                    break;
                }
                case "inherit-error-handler": {
                    String val = asText(node);
                    target.setInheritErrorHandler(java.lang.Boolean.valueOf(val));
                    break;
                }
                case "body": {
                    org.apache.camel.model.ExpressionSubElementDefinition val = asType(node, org.apache.camel.model.ExpressionSubElementDefinition.class);
                    target.setNewExchangeExpression(val);
                    break;
                }
                case "processor-ref": {
                    String val = asText(node);
                    target.setNewExchangeProcessorRef(val);
                    break;
                }
                case "on-prepare-ref": {
                    String val = asText(node);
                    target.setOnPrepareRef(val);
                    break;
                }
                case "pattern": {
                    String val = asText(node);
                    target.setPattern(val);
                    break;
                }
                case "uri": {
                    String val = asText(node);
                    target.setUri(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.XMLSecurityDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "secure-xml",
            properties = {
                    @YamlProperty(name = "add-key-value-for-encrypted-key", type = "boolean"),
                    @YamlProperty(name = "digest-algorithm", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "key-cipher-algorithm", type = "string"),
                    @YamlProperty(name = "key-or-trust-store-parameters-ref", type = "string"),
                    @YamlProperty(name = "key-password", type = "string"),
                    @YamlProperty(name = "mgf-algorithm", type = "string"),
                    @YamlProperty(name = "pass-phrase", type = "string"),
                    @YamlProperty(name = "pass-phrase-byte", type = "string", format = "binary"),
                    @YamlProperty(name = "recipient-key-alias", type = "string"),
                    @YamlProperty(name = "secure-tag", type = "string"),
                    @YamlProperty(name = "secure-tag-contents", type = "boolean"),
                    @YamlProperty(name = "xml-cipher-algorithm", type = "string")
            }
    )
    public static class XMLSecurityDataFormatDeserializer extends YamlDeserializerBase<XMLSecurityDataFormat> {
        public XMLSecurityDataFormatDeserializer() {
            super(XMLSecurityDataFormat.class);
        }

        @Override
        protected XMLSecurityDataFormat newInstance() {
            return new XMLSecurityDataFormat();
        }

        @Override
        protected boolean setProperty(XMLSecurityDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "add-key-value-for-encrypted-key": {
                    String val = asText(node);
                    target.setAddKeyValueForEncryptedKey(val);
                    break;
                }
                case "digest-algorithm": {
                    String val = asText(node);
                    target.setDigestAlgorithm(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "key-cipher-algorithm": {
                    String val = asText(node);
                    target.setKeyCipherAlgorithm(val);
                    break;
                }
                case "key-or-trust-store-parameters-ref": {
                    String val = asText(node);
                    target.setKeyOrTrustStoreParametersRef(val);
                    break;
                }
                case "key-password": {
                    String val = asText(node);
                    target.setKeyPassword(val);
                    break;
                }
                case "mgf-algorithm": {
                    String val = asText(node);
                    target.setMgfAlgorithm(val);
                    break;
                }
                case "pass-phrase": {
                    String val = asText(node);
                    target.setPassPhrase(val);
                    break;
                }
                case "pass-phrase-byte": {
                    byte[] val = asByteArray(node);
                    target.setPassPhraseByte(val);
                    break;
                }
                case "recipient-key-alias": {
                    String val = asText(node);
                    target.setRecipientKeyAlias(val);
                    break;
                }
                case "secure-tag": {
                    String val = asText(node);
                    target.setSecureTag(val);
                    break;
                }
                case "secure-tag-contents": {
                    String val = asText(node);
                    target.setSecureTagContents(val);
                    break;
                }
                case "xml-cipher-algorithm": {
                    String val = asText(node);
                    target.setXmlCipherAlgorithm(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.XMLTokenizerExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "xtokenize",
            properties = {
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "group", type = "number"),
                    @YamlProperty(name = "header-name", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "mode", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class XMLTokenizerExpressionDeserializer extends YamlDeserializerBase<XMLTokenizerExpression> {
        public XMLTokenizerExpressionDeserializer() {
            super(XMLTokenizerExpression.class);
        }

        @Override
        protected XMLTokenizerExpression newInstance() {
            return new XMLTokenizerExpression();
        }

        @Override
        protected XMLTokenizerExpression newInstance(String value) {
            return new XMLTokenizerExpression(value);
        }

        @Override
        protected boolean setProperty(XMLTokenizerExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "group": {
                    String val = asText(node);
                    target.setGroup(val);
                    break;
                }
                case "header-name": {
                    String val = asText(node);
                    target.setHeaderName(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "mode": {
                    String val = asText(node);
                    target.setMode(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.XPathExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "xpath",
            properties = {
                    @YamlProperty(name = "document-type", type = "string"),
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "factory-ref", type = "string"),
                    @YamlProperty(name = "header-name", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "log-namespaces", type = "boolean"),
                    @YamlProperty(name = "object-model", type = "string"),
                    @YamlProperty(name = "pre-compile", type = "boolean"),
                    @YamlProperty(name = "result-type", type = "string"),
                    @YamlProperty(name = "saxon", type = "boolean"),
                    @YamlProperty(name = "thread-safety", type = "boolean"),
                    @YamlProperty(name = "trim", type = "boolean")
            }
    )
    public static class XPathExpressionDeserializer extends YamlDeserializerBase<XPathExpression> {
        public XPathExpressionDeserializer() {
            super(XPathExpression.class);
        }

        @Override
        protected XPathExpression newInstance() {
            return new XPathExpression();
        }

        @Override
        protected XPathExpression newInstance(String value) {
            return new XPathExpression(value);
        }

        @Override
        protected boolean setProperty(XPathExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "document-type": {
                    String val = asText(node);
                    target.setDocumentTypeName(val);
                    break;
                }
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "factory-ref": {
                    String val = asText(node);
                    target.setFactoryRef(val);
                    break;
                }
                case "header-name": {
                    String val = asText(node);
                    target.setHeaderName(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "log-namespaces": {
                    String val = asText(node);
                    target.setLogNamespaces(val);
                    break;
                }
                case "object-model": {
                    String val = asText(node);
                    target.setObjectModel(val);
                    break;
                }
                case "pre-compile": {
                    String val = asText(node);
                    target.setPreCompile(val);
                    break;
                }
                case "result-type": {
                    String val = asText(node);
                    target.setResultTypeName(val);
                    break;
                }
                case "saxon": {
                    String val = asText(node);
                    target.setSaxon(val);
                    break;
                }
                case "thread-safety": {
                    String val = asText(node);
                    target.setThreadSafety(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.language.XQueryExpression.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "xquery",
            properties = {
                    @YamlProperty(name = "configuration-ref", type = "string"),
                    @YamlProperty(name = "expression", type = "string", required = true),
                    @YamlProperty(name = "header-name", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "trim", type = "boolean"),
                    @YamlProperty(name = "type", type = "string")
            }
    )
    public static class XQueryExpressionDeserializer extends YamlDeserializerBase<XQueryExpression> {
        public XQueryExpressionDeserializer() {
            super(XQueryExpression.class);
        }

        @Override
        protected XQueryExpression newInstance() {
            return new XQueryExpression();
        }

        @Override
        protected XQueryExpression newInstance(String value) {
            return new XQueryExpression(value);
        }

        @Override
        protected boolean setProperty(XQueryExpression target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "configuration-ref": {
                    String val = asText(node);
                    target.setConfigurationRef(val);
                    break;
                }
                case "expression": {
                    String val = asText(node);
                    target.setExpression(val);
                    break;
                }
                case "header-name": {
                    String val = asText(node);
                    target.setHeaderName(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "trim": {
                    String val = asText(node);
                    target.setTrim(val);
                    break;
                }
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                default: {
                    ExpressionDefinition ed = target.getExpressionType();
                    if (ed != null) {
                        throw new org.apache.camel.dsl.yaml.common.exception.UnsupportedFieldException(propertyName, "an expression has already been configured (" + ed + ")");
                    }
                    ed = ExpressionDeserializers.constructExpressionType(propertyKey, node);
                    if (ed != null) {
                        target.setExpressionType(ed);
                    } else {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @YamlType(
            inline = true,
            types = org.apache.camel.model.dataformat.XStreamDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "xstream",
            properties = {
                    @YamlProperty(name = "aliases", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "content-type-header", type = "boolean"),
                    @YamlProperty(name = "converters", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "driver", type = "string"),
                    @YamlProperty(name = "driver-ref", type = "string"),
                    @YamlProperty(name = "encoding", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "implicit-collections", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "mode", type = "string"),
                    @YamlProperty(name = "omit-fields", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "permissions", type = "string")
            }
    )
    public static class XStreamDataFormatDeserializer extends YamlDeserializerBase<XStreamDataFormat> {
        public XStreamDataFormatDeserializer() {
            super(XStreamDataFormat.class);
        }

        @Override
        protected XStreamDataFormat newInstance() {
            return new XStreamDataFormat();
        }

        @Override
        protected XStreamDataFormat newInstance(String value) {
            return new XStreamDataFormat(value);
        }

        @Override
        protected boolean setProperty(XStreamDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "aliases": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setAliases(val);
                    break;
                }
                case "content-type-header": {
                    String val = asText(node);
                    target.setContentTypeHeader(val);
                    break;
                }
                case "converters": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setConverters(val);
                    break;
                }
                case "driver": {
                    String val = asText(node);
                    target.setDriver(val);
                    break;
                }
                case "driver-ref": {
                    String val = asText(node);
                    target.setDriverRef(val);
                    break;
                }
                case "encoding": {
                    String val = asText(node);
                    target.setEncoding(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "implicit-collections": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setImplicitCollections(val);
                    break;
                }
                case "mode": {
                    String val = asText(node);
                    target.setMode(val);
                    break;
                }
                case "omit-fields": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setOmitFields(val);
                    break;
                }
                case "permissions": {
                    String val = asText(node);
                    target.setPermissions(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.XmlRpcDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "xmlrpc",
            properties = {
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "request", type = "boolean")
            }
    )
    public static class XmlRpcDataFormatDeserializer extends YamlDeserializerBase<XmlRpcDataFormat> {
        public XmlRpcDataFormatDeserializer() {
            super(XmlRpcDataFormat.class);
        }

        @Override
        protected XmlRpcDataFormat newInstance() {
            return new XmlRpcDataFormat();
        }

        @Override
        protected boolean setProperty(XmlRpcDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "request": {
                    String val = asText(node);
                    target.setRequest(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.YAMLDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "yaml",
            properties = {
                    @YamlProperty(name = "allow-any-type", type = "boolean"),
                    @YamlProperty(name = "allow-recursive-keys", type = "boolean"),
                    @YamlProperty(name = "constructor", type = "string"),
                    @YamlProperty(name = "dumper-options", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "library", type = "enum:SnakeYAML"),
                    @YamlProperty(name = "max-aliases-for-collections", type = "number"),
                    @YamlProperty(name = "pretty-flow", type = "boolean"),
                    @YamlProperty(name = "representer", type = "string"),
                    @YamlProperty(name = "resolver", type = "string"),
                    @YamlProperty(name = "type-filter", type = "array:org.apache.camel.model.dataformat.YAMLTypeFilterDefinition"),
                    @YamlProperty(name = "unmarshal-type-name", type = "string"),
                    @YamlProperty(name = "use-application-context-class-loader", type = "boolean")
            }
    )
    public static class YAMLDataFormatDeserializer extends YamlDeserializerBase<YAMLDataFormat> {
        public YAMLDataFormatDeserializer() {
            super(YAMLDataFormat.class);
        }

        @Override
        protected YAMLDataFormat newInstance() {
            return new YAMLDataFormat();
        }

        @Override
        protected boolean setProperty(YAMLDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-any-type": {
                    String val = asText(node);
                    target.setAllowAnyType(val);
                    break;
                }
                case "allow-recursive-keys": {
                    String val = asText(node);
                    target.setAllowRecursiveKeys(val);
                    break;
                }
                case "constructor": {
                    String val = asText(node);
                    target.setConstructor(val);
                    break;
                }
                case "dumper-options": {
                    String val = asText(node);
                    target.setDumperOptions(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "library": {
                    target.setLibrary(org.apache.camel.model.dataformat.YAMLLibrary.valueOf(asText(node)));
                    break;
                }
                case "max-aliases-for-collections": {
                    String val = asText(node);
                    target.setMaxAliasesForCollections(val);
                    break;
                }
                case "pretty-flow": {
                    String val = asText(node);
                    target.setPrettyFlow(val);
                    break;
                }
                case "representer": {
                    String val = asText(node);
                    target.setRepresenter(val);
                    break;
                }
                case "resolver": {
                    String val = asText(node);
                    target.setResolver(val);
                    break;
                }
                case "type-filter": {
                    java.util.List<org.apache.camel.model.dataformat.YAMLTypeFilterDefinition> val = asFlatList(node, org.apache.camel.model.dataformat.YAMLTypeFilterDefinition.class);
                    target.setTypeFilters(val);
                    break;
                }
                case "unmarshal-type-name": {
                    String val = asText(node);
                    target.setUnmarshalTypeName(val);
                    break;
                }
                case "use-application-context-class-loader": {
                    String val = asText(node);
                    target.setUseApplicationContextClassLoader(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.YAMLTypeFilterDefinition.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "type-filter",
            properties = {
                    @YamlProperty(name = "type", type = "string"),
                    @YamlProperty(name = "value", type = "string")
            }
    )
    public static class YAMLTypeFilterDefinitionDeserializer extends YamlDeserializerBase<YAMLTypeFilterDefinition> {
        public YAMLTypeFilterDefinitionDeserializer() {
            super(YAMLTypeFilterDefinition.class);
        }

        @Override
        protected YAMLTypeFilterDefinition newInstance() {
            return new YAMLTypeFilterDefinition();
        }

        @Override
        protected boolean setProperty(YAMLTypeFilterDefinition target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "type": {
                    String val = asText(node);
                    target.setType(val);
                    break;
                }
                case "value": {
                    String val = asText(node);
                    target.setValue(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.ZipDeflaterDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "zipdeflater",
            properties = {
                    @YamlProperty(name = "compression-level", type = "number"),
                    @YamlProperty(name = "id", type = "string")
            }
    )
    public static class ZipDeflaterDataFormatDeserializer extends YamlDeserializerBase<ZipDeflaterDataFormat> {
        public ZipDeflaterDataFormatDeserializer() {
            super(ZipDeflaterDataFormat.class);
        }

        @Override
        protected ZipDeflaterDataFormat newInstance() {
            return new ZipDeflaterDataFormat();
        }

        @Override
        protected boolean setProperty(ZipDeflaterDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "compression-level": {
                    String val = asText(node);
                    target.setCompressionLevel(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.dataformat.ZipFileDataFormat.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "zipfile",
            properties = {
                    @YamlProperty(name = "allow-empty-directory", type = "boolean"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "max-decompressed-size", type = "number"),
                    @YamlProperty(name = "preserve-path-elements", type = "boolean"),
                    @YamlProperty(name = "using-iterator", type = "boolean")
            }
    )
    public static class ZipFileDataFormatDeserializer extends YamlDeserializerBase<ZipFileDataFormat> {
        public ZipFileDataFormatDeserializer() {
            super(ZipFileDataFormat.class);
        }

        @Override
        protected ZipFileDataFormat newInstance() {
            return new ZipFileDataFormat();
        }

        @Override
        protected boolean setProperty(ZipFileDataFormat target, String propertyKey,
                String propertyName, Node node) {
            switch(propertyKey) {
                case "allow-empty-directory": {
                    String val = asText(node);
                    target.setAllowEmptyDirectory(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "max-decompressed-size": {
                    String val = asText(node);
                    target.setMaxDecompressedSize(val);
                    break;
                }
                case "preserve-path-elements": {
                    String val = asText(node);
                    target.setPreservePathElements(val);
                    break;
                }
                case "using-iterator": {
                    String val = asText(node);
                    target.setUsingIterator(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }

    @YamlType(
            types = org.apache.camel.model.cloud.ZooKeeperServiceCallServiceDiscoveryConfiguration.class,
            order = org.apache.camel.dsl.yaml.common.YamlDeserializerResolver.ORDER_LOWEST - 1,
            nodes = "zookeeper-service-discovery",
            properties = {
                    @YamlProperty(name = "base-path", type = "string"),
                    @YamlProperty(name = "connection-timeout", type = "string"),
                    @YamlProperty(name = "id", type = "string"),
                    @YamlProperty(name = "namespace", type = "string"),
                    @YamlProperty(name = "nodes", type = "string"),
                    @YamlProperty(name = "properties", type = "array:org.apache.camel.model.PropertyDefinition"),
                    @YamlProperty(name = "reconnect-base-sleep-time", type = "string"),
                    @YamlProperty(name = "reconnect-max-retries", type = "string"),
                    @YamlProperty(name = "reconnect-max-sleep-time", type = "string"),
                    @YamlProperty(name = "session-timeout", type = "string")
            }
    )
    public static class ZooKeeperServiceCallServiceDiscoveryConfigurationDeserializer extends YamlDeserializerBase<ZooKeeperServiceCallServiceDiscoveryConfiguration> {
        public ZooKeeperServiceCallServiceDiscoveryConfigurationDeserializer() {
            super(ZooKeeperServiceCallServiceDiscoveryConfiguration.class);
        }

        @Override
        protected ZooKeeperServiceCallServiceDiscoveryConfiguration newInstance() {
            return new ZooKeeperServiceCallServiceDiscoveryConfiguration();
        }

        @Override
        protected boolean setProperty(ZooKeeperServiceCallServiceDiscoveryConfiguration target,
                String propertyKey, String propertyName, Node node) {
            switch(propertyKey) {
                case "base-path": {
                    String val = asText(node);
                    target.setBasePath(val);
                    break;
                }
                case "connection-timeout": {
                    String val = asText(node);
                    target.setConnectionTimeout(val);
                    break;
                }
                case "id": {
                    String val = asText(node);
                    target.setId(val);
                    break;
                }
                case "namespace": {
                    String val = asText(node);
                    target.setNamespace(val);
                    break;
                }
                case "nodes": {
                    String val = asText(node);
                    target.setNodes(val);
                    break;
                }
                case "properties": {
                    java.util.List<org.apache.camel.model.PropertyDefinition> val = asFlatList(node, org.apache.camel.model.PropertyDefinition.class);
                    target.setProperties(val);
                    break;
                }
                case "reconnect-base-sleep-time": {
                    String val = asText(node);
                    target.setReconnectBaseSleepTime(val);
                    break;
                }
                case "reconnect-max-retries": {
                    String val = asText(node);
                    target.setReconnectMaxRetries(val);
                    break;
                }
                case "reconnect-max-sleep-time": {
                    String val = asText(node);
                    target.setReconnectMaxSleepTime(val);
                    break;
                }
                case "session-timeout": {
                    String val = asText(node);
                    target.setSessionTimeout(val);
                    break;
                }
                default: {
                    return false;
                }
            }
            return true;
        }
    }
}
