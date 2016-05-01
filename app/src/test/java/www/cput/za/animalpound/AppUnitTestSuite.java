package www.cput.za.animalpound;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import www.cput.za.animalpound.factories.animal.AnimalFactory;
import www.cput.za.animalpound.factories.animal.AnimalHealthFactory;
import www.cput.za.animalpound.factories.animal.AnimalRecordFactory;

/**
 * Created by Game330 on 2016-04-29.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AnimalHealthFactory.class,
        AnimalFactory.class,
        AnimalRecordFactory.class,})
public class AppUnitTestSuite {}