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

package com.skt.opensocial.wrapper.persistence.service;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.shindig.common.util.ImmediateFuture;
import org.apache.shindig.protocol.Operation;
import org.apache.shindig.protocol.ProtocolException;
import org.apache.shindig.protocol.RequestItem;
import org.apache.shindig.protocol.Service;
import org.apache.shindig.social.sample.spi.JsonDbOpensocialService;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.Future;

import javax.servlet.http.HttpServletResponse;

import com.google.inject.Inject;

@Service(name = "samplehandler", path = "/{type}/{doevil}")
public class SampleHandler {

  private final JsonDbOpensocialService service;

  @Inject
  public SampleHandler(JsonDbOpensocialService dbService) {
    this.service = dbService;
  }

  /**
   * We don't distinguish between put and post for these urls.
   */
  @Operation(httpMethods = "PUT")
  public Future<?> update(RequestItem request) throws ProtocolException {
    return create(request);
  }

  /**
   * Handles /samplehandler/setstate and /samplehandler/setevilness/{doevil}. TODO(doll): 
   */
  @Operation(httpMethods = "POST")
  public Future<?> create(RequestItem request) throws ProtocolException {
    String type = request.getParameter("type");
    if (type.equals("setstate")) {
      try {
    	  throw new ProtocolException(HttpServletResponse.SC_NOT_IMPLEMENTED,
          "-------------------------------------------- Test Succeed : /smaplehandler/setstate --------------------------------------");
      } catch (Exception e) {
        throw new ProtocolException(HttpServletResponse.SC_BAD_REQUEST,
            "The json state file was not valid json", e);
      }
    } else if (type.equals("setevilness")) {
    	throw new ProtocolException(HttpServletResponse.SC_NOT_IMPLEMENTED,
        "-------------------------------------------- Test Succeed : /smaplehandler/setevilness --------------------------------------");
    }

    return ImmediateFuture.newInstance(null);
  }

  /**
   * Handles /samplehandler/dumpstate
   */
  @Operation(httpMethods = "GET")
  public Future<?> get(RequestItem request) {
	  throw new ProtocolException(HttpServletResponse.SC_NOT_IMPLEMENTED,
      "-------------------------------------------- Test Succeed : /smaplehandler/dumplstate --------------------------------------");
  }


}
