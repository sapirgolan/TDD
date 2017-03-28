package service;

import com.sap.labs.tdd.model.IBlock;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import java.util.ArrayList;
import java.util.List;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MeasurementsService.class)
public class MeasurementsServiceTest {

    @InjectMocks
    private MeasurementsService classUnderTest;

    @Mock
    private ICalculationService calculationServiceMock;


    @Before
    public void setUp() throws Exception {
        classUnderTest = PowerMockito.spy(new MeasurementsService());
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculatesRankedValue() throws Exception {
        List<IBlock> list = new ArrayList<>();
        list.add(PowerMockito.mock(IBlock.class));
        Whitebox.invokeMethod(classUnderTest, "calculateRankedValue", list, 0.3);
    }

    @Test
    public void testReturnLastRankedValue() throws Exception {
        //mocking
        List mock = PowerMockito.mock(List.class);
        PowerMockito.when(calculationServiceMock.calcRankedValue(mock)).thenReturn(8.0);

        //execution
        Whitebox.invokeMethod(classUnderTest, "calculateRankedValue",mock,  0.5);

        //assertion
        MatcherAssert.assertThat(classUnderTest.getRankedValue(0.5), Matchers.is(8.0));
    }

    @Test
    public void testSeveralRankedValueCalculations() throws Exception {
        //mocking
        List mock = PowerMockito.mock(List.class);
        PowerMockito.when(calculationServiceMock.calcRankedValue(mock)).thenReturn(8.0, 9.0);

        //execution
        Whitebox.invokeMethod(classUnderTest, "calculateRankedValue",mock,  0.5);
        Whitebox.invokeMethod(classUnderTest, "calculateRankedValue",mock,  0.3);

        //assertion
        MatcherAssert.assertThat(classUnderTest.getRankedValue(0.5), Matchers.is(8.0));
        MatcherAssert.assertThat(classUnderTest.getRankedValue(0.3), Matchers.is(9.0));
    }

    @Test
    public void testCalc() throws Exception {
        //mocking
        List mock = PowerMockito.mock(List.class);
        PowerMockito.when(calculationServiceMock.calcRankedValue(mock)).thenReturn(8.0);

        //execution
        classUnderTest.calc(mock, 0.5);

        //assertion
        MatcherAssert.assertThat(classUnderTest.getRankedValue(0.5), Matchers.is(8.0));

        PowerMockito.verifyPrivate(classUnderTest, Mockito.times(1)).invoke("calculateRankedValue", Mockito.anyList(), Mockito.anyDouble());

    }
}