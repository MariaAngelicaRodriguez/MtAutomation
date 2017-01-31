$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("infoEmployeePersonalInformation.feature");
formatter.feature({
  "line": 2,
  "name": "Validate Employee Personal Information",
  "description": "This scenario should validate  Employee Personal Information displayed on\r\nthe widget retrieved from Open ERP",
  "id": "validate-employee-personal-information",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@EmployeePI"
    }
  ]
});
formatter.before({
  "duration": 140246400,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Verify the employee personal imformation in the info widget",
  "description": "",
  "id": "validate-employee-personal-information;verify-the-employee-personal-imformation-in-the-info-widget",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "I am at Mach2 Webpage",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "I set Username as \"angelica.rodriguez@fundacion-jala.org\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I set Password as \"At24062406\" and press Submit button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I add new Board to the Group",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "I click on Widget Button at the top menubar",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I click on \"Info\" Icon inside the Widget options",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I select \"Open ERP\" service Icon.",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I select \"Employees Personal Information\" on Open ERP",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I click on Divisions Combobox and select \"Outsourcing\"",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "I click save button",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "I should see the first Employee Personal Information by \"Division\": \"Outsourcing\"",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I should have the same result using Open ERP web page to search Employee Personal Information for \"Jose Andres Fleitas Casas\" as Employee",
  "keyword": "Then "
});
formatter.match({
  "location": "InfoEmployeePersonalInformation.iAmOnMachWebpage()"
});
formatter.result({
  "duration": 7712634900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "angelica.rodriguez@fundacion-jala.org",
      "offset": 19
    }
  ],
  "location": "InfoEmployeePersonalInformation.iFillUsernameOrMailTextfieldAs(String)"
});
formatter.result({
  "duration": 331066900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "At24062406",
      "offset": 19
    }
  ],
  "location": "InfoEmployeePersonalInformation.iFillPasswordTextfieldAsAndPressSubmitButton(String)"
});
formatter.result({
  "duration": 179827500,
  "status": "passed"
});
formatter.match({
  "location": "InfoEmployeePersonalInformation.iHaveBoardCreated()"
});
formatter.result({
  "duration": 774789200,
  "status": "passed"
});
formatter.match({
  "location": "InfoEmployeePersonalInformation.iClickOnWidgetButtonAtTheTopMenubar()"
});
formatter.result({
  "duration": 2106599000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Info",
      "offset": 12
    }
  ],
  "location": "InfoEmployeePersonalInformation.iClickOnIconInsideTheWidgetOptions(String)"
});
formatter.result({
  "duration": 2087294400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Open ERP",
      "offset": 10
    }
  ],
  "location": "InfoEmployeePersonalInformation.iSelectServiceIcon(String)"
});
formatter.result({
  "duration": 231460100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Employees Personal Information",
      "offset": 10
    }
  ],
  "location": "InfoEmployeePersonalInformation.iSelectOptionOfOpenERP(String)"
});
formatter.result({
  "duration": 258808700,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Outsourcing",
      "offset": 42
    }
  ],
  "location": "InfoEmployeePersonalInformation.i_click_on_Divisions_combobox_and_select(String)"
});
formatter.result({
  "duration": 1062417200,
  "status": "passed"
});
formatter.match({
  "location": "InfoEmployeePersonalInformation.iClickOnSaveButton()"
});
formatter.result({
  "duration": 2234783900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Division",
      "offset": 57
    },
    {
      "val": "Outsourcing",
      "offset": 69
    }
  ],
  "location": "InfoEmployeePersonalInformation.i_should_see_the_first_Employee_Personal_Information_by_Outsourcing(String,String)"
});
formatter.result({
  "duration": 25250645900,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Jose Andres Fleitas Casas",
      "offset": 99
    }
  ],
  "location": "InfoEmployeePersonalInformation.i_should_have_the_same_result_using_Open_ERP_web_page_to_search_Division(String)"
});
formatter.result({
  "duration": 127569143000,
  "status": "passed"
});
formatter.after({
  "duration": 2775400,
  "status": "passed"
});
});