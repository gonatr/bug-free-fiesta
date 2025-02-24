@Regression @MasterProfile
Feature: Test Functionality Master Profile

  Background:
	Given User on home Page ERP system
	When User input username "raka", the password "R@ka123!" and clicks on the login button


  Scenario: cek list filter data Master Menu Device.
	When User on Dashboard, click General Master on side left Menu
	And User click Mobile User, select Master Profile
	And User click Filter
	And User click Execute Data
	Then User get results from Execute Filter Data

  @TestRun
  Scenario: User add new data Master Menu Device
	When User on Dashboard, click General Master on side left Menu
	And User click Mobile User, select Master Profile
	And User click New at Master Profile
	And User input "Code" values Master Profile
	And User input "Shortname" values Master Profile
	And User input "FullName" values Master Profile
	And User click Submit Master Profile
	Then User get Result from New Data Master Profile