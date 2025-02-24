@Regression @MasterProfile
Feature: Test Functionality Master Profile

  Background:
	Given User on home Page ERP system
	When User input username "raka", the password "R@ka123!" and clicks on the login button

  @TS001 @TC001
  Scenario: cek list filter data Master Menu Device.
	When User on Dashboard, click General Master on side left Menu
	And User click Filter
	And User click Execute Data
	Then User get results from Execute Filter Data