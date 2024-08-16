/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.seatunnel.app.controller;

import org.apache.seatunnel.app.common.Result;
import org.apache.seatunnel.app.domain.request.job.JobCreateReq;
import org.apache.seatunnel.app.service.IJobService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.annotation.Resource;

@RestController
@RequestMapping("/seatunnel/api/v1/job")
public class JobController {

    @Resource private IJobService jobCRUDService;

    @PostMapping("/create")
    @ApiOperation(
            value =
                    "Create a job, In jobDAG for inputPluginId and targetPluginId use the plugin names instead of ids.",
            httpMethod = "POST")
    public Result<Long> createJob(
            @ApiParam(value = "userId", required = true) @RequestAttribute("userId") Integer userId,
            @RequestBody JobCreateReq jobCreateRequest)
            throws JsonProcessingException {
        return Result.success(jobCRUDService.createJob(userId, jobCreateRequest));
    }
}