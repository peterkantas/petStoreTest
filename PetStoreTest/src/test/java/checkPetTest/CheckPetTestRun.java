package checkPetTest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/CheckPet.feature"},
        glue = {"checkPetTest","common","newPetTest"},
        stepNotifications = true
)

public class CheckPetTestRun {
}
