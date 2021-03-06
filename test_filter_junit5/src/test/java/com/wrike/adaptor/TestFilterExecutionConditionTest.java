package com.wrike.adaptor;

import com.wrike.adaptor.tools.DummyTests;
import com.wrike.adaptor.tools.ExecutionRecorder;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static com.wrike.adaptor.tools.TestUtil.executeTestsForClass;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by Ivan Varivoda 06/03/2021
 */
class TestFilterExecutionConditionTest {

    @Test
    void e1Andf1Test() {
        System.setProperty("test.filter", "{epic:e1}&{feature:f1}");
        ExecutionRecorder results = executeTestsForClass(DummyTests.class);
        Set<String> displayNames = results.getFinishedTestNames();
        assertEquals(1, displayNames.size(), "# finished tests " + displayNames);
        assertTrue(displayNames.contains("e1f1s1()"));
    }

}
