package test;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class Stepdefs {
  private int illPeopleNumber;
  private String decision;
  private boolean quarantineIsOver = false;

  @Given("number of ill people is {int}")
  public void setNumberOfIllPeople(int illPeople) {
    illPeopleNumber = illPeople;
  }

  @Given("quarantine is over")
  public void setQuarantineIsOver() {
    quarantineIsOver = true;
  }

  @When("I ask whether it's quarantine is over")
  public void askToOverQuarantine() {
    if (illPeopleNumber < 11 && illPeopleNumber > 0) decision = "Quarantine is over!";
    else if (illPeopleNumber > 11) decision = "Quarantine is going on!";
  }

  @When("I ask whether i can go to cinema")
  public void goToCinema() {
    if (quarantineIsOver) decision = "Yes, you can!";
  }

  @Then("^I should be told '(.*?)'$")
  public void verifyDecision(String decision) {
    Assert.assertEquals(this.decision, decision);
  }
}
