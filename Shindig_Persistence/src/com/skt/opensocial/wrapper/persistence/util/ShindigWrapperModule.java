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
package com.skt.opensocial.wrapper.persistence.util;

import org.apache.shindig.social.core.config.SocialApiGuiceModule;
import org.apache.shindig.social.opensocial.oauth.OAuthDataStore;
import org.apache.shindig.social.opensocial.spi.ActivityService;
import org.apache.shindig.social.opensocial.spi.AppDataService;
import org.apache.shindig.social.opensocial.spi.PersonService;
import org.apache.shindig.social.sample.oauth.SampleOAuthDataStore;
import org.apache.shindig.social.sample.oauth.SampleRealm;
import org.apache.shindig.social.sample.service.SampleContainerHandler;
import com.skt.opensocial.wrapper.persistence.spi.HActivityDBService;
import com.skt.opensocial.wrapper.persistence.spi.HAppDataDBService;
import com.skt.opensocial.wrapper.persistence.spi.HPersonDBService;
import com.skt.opensocial.wrapper.persistence.service.GroupHandler;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.inject.name.Names;

/**
 * Provides bindings for sample-only implementations of social API
 * classes.  This class should never be used in production deployments,
 * but does provide a good overview of the pieces of Shindig that require
 * custom container implementations.
 */
public class ShindigWrapperModule extends SocialApiGuiceModule {

  @Override
  protected void configure() {
    super.configure();
    
    bind(String.class).annotatedWith(Names.named("shindig.canonical.json.db"))
        .toInstance("sampledata/canonicaldb.json");
    
    // the implementation of Opensocial services
    // ActivityService for Activity
    // AppDataService for Persistence
    // PersonService for Person
    bind(ActivityService.class).to(HActivityDBService.class);
    bind(AppDataService.class).to(HAppDataDBService.class);
    bind(PersonService.class).to(HPersonDBService.class);
    
    bind(OAuthDataStore.class).to(SampleOAuthDataStore.class);


    // We do this so that jsecurity realms can get access to the jsondbservice singleton
    requestStaticInjection(SampleRealm.class);
  }

  @Override
  protected Set<Object> getHandlers() {
    ImmutableSet.Builder<Object> handlers = ImmutableSet.builder();
    handlers.addAll(super.getHandlers());
    
    // Add additional handlers here
    handlers.add(SampleContainerHandler.class);
    handlers.add(GroupHandler.class);
    return handlers.build();
  }

}
