package UIX;

import dao.ParamRequest;
import org.junit.Assert;
import org.junit.Test;

public class MainFrameTest {

    @Test
    public void prepareParamRequestTest() {
        String[] rightTestString = {"Свердлов", "Григорьев Вячеслав", "123"};
        String[] wrongTestString = {"Свердлов23", "Григорьев Вячеслав 34", "&Сергей", "Ddfdf", "Иванов 23"};
        ParamRequest paramRequest;
        for (String nextString : rightTestString) {
            paramRequest = MainFrame.prepareParamRequest(nextString);
            Assert.assertNotNull(paramRequest);
        }
        for (String nextString : wrongTestString) {
            paramRequest = MainFrame.prepareParamRequest(nextString);
            Assert.assertNull(paramRequest);
        }
    }
}