/*
 * Copyright 2017 LinkedIn Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package azkaban.execapp;

import azkaban.metrics.MetricsUtility;
import com.codahale.metrics.MetricRegistry;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * This class ExecMetrics is in charge of collecting metrics from executors.
 */
@Singleton
public class ExecMetrics {

  private final MetricRegistry registry;

  @Inject
  ExecMetrics(final MetricRegistry registry) {
    this.registry = registry;
    setupStaticMetrics();
  }

  public void setupStaticMetrics() {

  }

  public void addFlowRunnerManagerMetrics(final FlowRunnerManager flowRunnerManager) {
    MetricsUtility
        .addGauge("EXEC-NumRunningFlows", this.registry, flowRunnerManager::getNumRunningFlows);
    MetricsUtility
        .addGauge("EXEC-NumQueuedFlows", this.registry, flowRunnerManager::getNumQueuedFlows);
  }
}