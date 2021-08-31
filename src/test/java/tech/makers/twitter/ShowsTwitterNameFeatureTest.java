package tech.makers.twitter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.htmlunit.webdriver.MockMvcHtmlUnitDriverBuilder;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ShowsTwitterNameFeatureTest {
    WebDriver driver;

    @BeforeEach
    void setup(WebApplicationContext context) {
        driver = MockMvcHtmlUnitDriverBuilder
                .webAppContextSetup(context)
                .build();
    }

    @Test
    public void tweetIndexShouldShowTwitterName() throws Exception {
        driver.get("http://localhost:9990/");
        assertThat(driver.findElement(By.tagName("body")).getText()).contains("Twitter");
    }

}
