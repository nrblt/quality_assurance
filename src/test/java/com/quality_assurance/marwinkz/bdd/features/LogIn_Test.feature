@Authorization
Feature: Login Action

@LogIn
Scenario Outline:Successful Login with Valid Credentials
  Given user is on home page
  When user navigate to log in page
  When user navigate to email tab
  And user enters email <email>
  And user enters password <password>
  And user clicks login button

Examples:
  | email        | password |
  | zhermuhanbetov@gmail.com | Qwerty123! |

#@LogOut
#Scenario Outline: Successful LogOut after log in
#  Given user is on home page
#  When user navigate to log in page
#  And user enters email <email>
#  And user enters password <password>
#  And user clicks login button
#  And user clicks log out button
#  Then user name is displayed
#
#    Examples:
#      | email        | password |
#      | zhermuhanbetov@gmail.com | Qwerty123! |