/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package org.apache.shindig.social.core.config;

import org.apache.shindig.auth.AnonymousAuthenticationHandler;
import org.apache.shindig.auth.AuthenticationHandler;
import org.apache.shindig.common.servlet.ParameterFetcher;
import org.apache.shindig.protocol.DataServiceServletFetcher;
import org.apache.shindig.protocol.conversion.BeanConverter;
import org.apache.shindig.protocol.conversion.BeanJsonConverter;
import org.apache.shindig.protocol.conversion.BeanXStreamConverter;
import org.apache.shindig.protocol.conversion.xstream.XStreamConfiguration;
import org.apache.shindig.social.core.oauth.AuthenticationHandlerProvider;
import org.apache.shindig.social.core.util.BeanXStreamAtomConverter;
import org.apache.shindig.social.core.util.xstream.XStream081Configuration;
import org.apache.shindig.social.opensocial.service.ActivityHandler;
import org.apache.shindig.social.opensocial.service.AppDataHandler;
import org.apache.shindig.social.opensocial.service.MessageHandler;
import org.apache.shindig.social.opensocial.service.PersonHandler;

import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;

/**
 * Provides social api component injection. Implementor may want to replace this module if they need
 * to replace some of the internals of the Social API, like for instance the JSON to Bean to JSON
 * converter Beans, however in general this should not be required, as most default implementations
 * have been specified with the Guice @ImplementedBy annotation.
 */
public class SocialApiGuiceModule extends AbstractModule {

  /** {@inheritDoc} */
  @Override
  protected void configure() {
    bind(ParameterFetcher.class).annotatedWith(Names.named("DataServiceServlet"))
        .to(DataServiceServletFetcher.class);

    bind(Boolean.class)
        .annotatedWith(Names.named(AnonymousAuthenticationHandler.ALLOW_UNAUTHENTICATED))
        .toInstance(Boolean.TRUE);
    bind(XStreamConfiguration.class).to(XStream081Configuration.class);
    bind(BeanConverter.class).annotatedWith(Names.named("shindig.bean.converter.xml")).to(
        BeanXStreamConverter.class);
    bind(BeanConverter.class).annotatedWith(Names.named("shindig.bean.converter.json")).to(
        BeanJsonConverter.class);
    bind(BeanConverter.class).annotatedWith(Names.named("shindig.bean.converter.atom")).to(
        BeanXStreamAtomConverter.class);

    bind(new TypeLiteral<List<AuthenticationHandler>>(){}).toProvider(
        AuthenticationHandlerProvider.class);
  
    bind(new TypeLiteral<Set<Object>>(){}).annotatedWith(Names.named("org.apache.shindig.social.handlers"))
        .toInstance(getHandlers());
    
    bind(Long.class).annotatedWith(Names.named("org.apache.shindig.serviceExpirationDurationMinutes")).toInstance(60l);
  }
  
  /**
   * Hook to provide a Set of request handlers.  Subclasses may override
   * to add or replace additional handlers.
   */
  protected Set<Object> getHandlers() {
    return ImmutableSet.<Object>of(ActivityHandler.class, AppDataHandler.class,
        PersonHandler.class, MessageHandler.class);
  }
}
