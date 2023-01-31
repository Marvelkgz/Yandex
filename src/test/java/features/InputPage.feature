@Smoke
Feature:  Yandex input and send message

  Background:Verify message
Given Go to login page

    Scenario: Positive: in Yandex mail send me message and verify
      Given Open the main site mail
      Then Write message "Marsbek00000"
      And Click button send
      When Refresh page
      Then Verify unread messages
      And Verify message "Marsbek00000"

