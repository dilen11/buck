/*
 * Copyright 2017-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.facebook.buck.distributed;

import com.facebook.buck.distributed.thrift.BuildSlaveStatus;
import com.facebook.buck.event.AbstractBuckEvent;
import com.facebook.buck.event.EventKey;

public class BuildSlaveFinishedEvent extends AbstractBuckEvent {
  private final BuildSlaveStatus status;
  private final int exitCode;

  public BuildSlaveFinishedEvent(BuildSlaveStatus status, int exitCode) {
    super(EventKey.unique());
    this.status = status;
    this.exitCode = exitCode;
  }

  public BuildSlaveStatus getBuildSlaveStatus() {
    return status;
  }

  @Override
  protected String getValueString() {
    return getEventName();
  }

  @Override
  public String getEventName() {
    return this.getClass().getName();
  }

  public int getExitCode() {
    return exitCode;
  }
}