package org.jghill.timelinevisualizersourcestestsuite;

import org.jghill.timelinevisualizersources.*;
import org.jghill.timelinevisualizersourcesgui.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A testing suite for the Sources module.
 * 
 * @author JGHill
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
    SPARQLEndpointTest.class,
    SourceCollectionTest.class,
    SourceTableModelTest.class
})
public class SourcesTestSuite {}