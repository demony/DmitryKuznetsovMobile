package dataproviders;

import org.testng.annotations.DataProvider;

public class WebDataProvider {
    @DataProvider(name = "searchStringsForGoogle")
    public Object[][] searchParamsForGoogle() {
        return new Object[][] {
            {"search_string_EPAM", "EPAM", "EPAM"},
        };
    }
}
