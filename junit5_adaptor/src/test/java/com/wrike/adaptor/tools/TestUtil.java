package com.wrike.adaptor.tools;

import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class TestUtil {

    public static ExecutionRecorder executeTestsForClass(Class<?> testClass) {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectClass(testClass))
                .build();
        Launcher launcher = LauncherFactory.create();

        ExecutionRecorder listener = new ExecutionRecorder();
        launcher.registerTestExecutionListeners(listener);

        launcher.execute(request);
        return listener;
    }

}
