package com.aries.tutorial;

import com.aries.extension.data.BatchData;
import com.aries.extension.data.batch.ApplicationServiceData;
import com.aries.extension.handler.BatchHandler;
import com.aries.extension.util.PropertyUtil;

public class ApplicationServiceBatch implements BatchHandler {
    @Override
    public boolean preHandle(long batchTime) {
        // TODO: Adding pre-processing code
        return true;
    }

    @Override
    public void process(BatchData[] batchData) {
        System.out.println("[ApplicationServiceBatch] - " +
                PropertyUtil.getValue("application_service_batch", "subject", "Unknown subject"));

        for(int i = 0; i < batchData.length; i++) {
            ApplicationServiceData data = (ApplicationServiceData) batchData[i];

            System.out.println("Domain ID : " + data.domainId);
            System.out.println("Domain Name : " + data.domainName);
            System.out.println("Instance Name : " + data.instanceName);
            System.out.println("Application Name : " + data.applicationName);
            System.out.println("Call Count : " + data.callCount);
            System.out.println("Failure Count : " + data.failureCount);
        }
    }
}
