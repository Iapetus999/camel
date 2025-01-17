/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.builder.endpoint.dsl;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import javax.annotation.Generated;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;

/**
 * Access the Interplanetary File System (IPFS).
 * 
 * Generated by camel build tools - do NOT edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface IPFSEndpointBuilderFactory {


    /**
     * Builder for endpoint for the IPFS component.
     */
    public interface IPFSEndpointBuilder extends EndpointProducerBuilder {
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default IPFSEndpointBuilder lazyStartProducer(boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default IPFSEndpointBuilder lazyStartProducer(String lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * The ipfs output directory.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param outdir the value to set
         * @return the dsl builder
         */
        default IPFSEndpointBuilder outdir(String outdir) {
            doSetProperty("outdir", outdir);
            return this;
        }
    }

    public interface IPFSBuilders {
        /**
         * IPFS (camel-ipfs)
         * Access the Interplanetary File System (IPFS).
         * 
         * Category: file,ipfs
         * Since: 2.23
         * Maven coordinates: org.apache.camel:camel-ipfs
         * 
         * Syntax: <code>ipfs:ipfsCmd</code>
         * 
         * Path parameter: ipfsCmd (required)
         * The ipfs command
         * There are 4 enums and the value can be one of: add, cat, get, version
         * 
         * @param path ipfsCmd
         * @return the dsl builder
         */
        default IPFSEndpointBuilder ipfs(String path) {
            return IPFSEndpointBuilderFactory.endpointBuilder("ipfs", path);
        }
        /**
         * IPFS (camel-ipfs)
         * Access the Interplanetary File System (IPFS).
         * 
         * Category: file,ipfs
         * Since: 2.23
         * Maven coordinates: org.apache.camel:camel-ipfs
         * 
         * Syntax: <code>ipfs:ipfsCmd</code>
         * 
         * Path parameter: ipfsCmd (required)
         * The ipfs command
         * There are 4 enums and the value can be one of: add, cat, get, version
         * 
         * @param componentName to use a custom component name for the endpoint
         * instead of the default name
         * @param path ipfsCmd
         * @return the dsl builder
         */
        default IPFSEndpointBuilder ipfs(String componentName, String path) {
            return IPFSEndpointBuilderFactory.endpointBuilder(componentName, path);
        }
    }
    static IPFSEndpointBuilder endpointBuilder(String componentName, String path) {
        class IPFSEndpointBuilderImpl extends AbstractEndpointBuilder implements IPFSEndpointBuilder {
            public IPFSEndpointBuilderImpl(String path) {
                super(componentName, path);
            }
        }
        return new IPFSEndpointBuilderImpl(path);
    }
}