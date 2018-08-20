package com.aries.tutorial;

import com.aries.extension.data.BatchData;
import com.aries.extension.data.batch.MetricsDataAsInstance;
import com.aries.extension.handler.BatchHandler;
import com.aries.extension.util.PropertyUtil;

public class InstanceMetricsBatch implements BatchHandler {
    @Override
    public boolean preHandle(long batchTime) {
        // TODO: Adding pre-processing code
        return true;
    }

    @Override
    public void process(BatchData[] batchData) {
        System.out.println("[InstanceMetricsBatch] - " +
                PropertyUtil.getValue("instance_metrics_batch", "subject", "Unknown subject"));

        for(int i = 0; i < batchData.length; i++) {
            MetricsDataAsInstance data = (MetricsDataAsInstance) batchData[i];

            System.out.println("Domain ID : " + data.domainId);
            System.out.println("Instance Name : " + data.instanceName);
            System.out.println("Call Count : " + data.serviceCount);
            System.out.println("Max TPS : " + data.maxTps);
            System.out.println("Active Service : " + data.activeService);
            System.out.println("Error Count : " + data.errorCount + "\n");
        }
    }
}
