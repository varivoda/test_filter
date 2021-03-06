package com.wrike.adaptor.tools;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

import java.util.HashSet;
import java.util.Set;

public class ExecutionRecorder implements TestExecutionListener {

    private final Set<String> finishedTests = new HashSet<>();
    private final Set<String> skippedTests = new HashSet<>();

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult ) {
        boolean isTest = testIdentifier.isTest();
        if(isTest) {
            finishedTests.add(testIdentifier.getDisplayName());
        }
    }

    @Override
    public void executionSkipped(TestIdentifier testIdentifier, String reason) {
        boolean isTest = testIdentifier.isTest();
        if(isTest) {
            skippedTests.add(testIdentifier.getDisplayName());
        }
    }

    public Set<String> getFinishedTestNames() {
        return finishedTests;
    }

    public Set<String> getSkippedTestsNames() {
        return skippedTests;
    }
}
