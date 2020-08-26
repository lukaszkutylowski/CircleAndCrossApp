# **CircleAndCrossApp**

This is an application which is a simple version of circle and cross game executed in command.

## Used technologies:
* Java SE
* Resuing methods
* JUnit 4
* OOP
* Maven

## Description

*CircleAndCross* class is a execution class with main method. Class contains reference do *AppService* class. Structure of this application is that *CircleAndCross* class calls methods from *AppService* class and next *AppService* class calls methods from *PrintService* class.
This class contains necessary fields: String[][] fields with information about actual status of game, and some MESSAGE Strings. Necessary variables are transfered to next method.
In first step, *service.showGame()* is executed. It shows welcome message with info *Pierwszy gracz: O czy X ?*. 
In second step user enter "X" or "O" from keyboard - *service.choosePlayer()* method call. Value is saved in *playerOorX* variable.

*Image shows first part CircleAndCross class*
![alt text](/.readmeimages/image1.jpg)

In while loop application is executed as far as some player is winner or result of game is draw. 
In first step application shows which player is actual - *service.startGame()* method. *service.setCoordinate()* enables get from user coordinates of field which should be fill "X" or "O". In method *service.setColumnAndRow()* this functionality is executed.
*AppService.checkDraw()* is a method which check fields to tell that game status is draw or not. If method return true while loop is break.
*service.checkWin()* is a method which check fields to tell that some player is winner or not. If method return true, in first step application show winner and while loop is break.
If game is not end, in last step actual player is changed - *service.nextPlayer()* method.

*Image shows second part CircleAndCross class*
![alt text](/.readmeimages/image2.jpg)

*AppService* class contains service methods which realized logical functionalities.
*showGame()* method calls *PrintService.printGame()* method which shows welcome message.
*choosePlayer()* method enabled get information about first player "X" or "O" which is enter from keyboard. This functionality is executed in *getScannerInput()* method. Result of this method is saved in *choose* variable. In while loop *if* conditions check that enter value is "X" or "O" and save to playerOorX variable - if not match then while loop is not break.
*startGame()* method calls *PrintService.printGame()* method with information about actual player.

*Image shows AppService class with showGame(), choosePlayer(), startGame() methods*
![alt text](/.readmeimages/image3.jpg)

*service.setCoordinate()* enables get from user coordinates of field which should be fill "X" or "O". This method can get coordinate of row or column. This functionality is regulated by boolean *row* variable. If is true, *PrintService.printMessageRow()* is called, if false - then *PrintService.printMessageColumn()*. Next method get value from keyboard *getScannerInput()* and this value is parsed to Integer and is returned. 
*service.setColumnAndRow()* take String[][] fields, actual player and coordinates and this information enables save actual status of game in String tab.

*Image shows AppService class with setCoordinate(), setColumnAndRow() methods*
![alt text](/.readmeimages/image4.jpg)

*checkDraw()* method check actual status of game (String tab) by searching any " " (emply field) in tab. When some field in tab is empty, draw is false and method is end. When draw is true, *PrintService.printGame()* is called and program show info about draw.

*Image shows checkDraw() method from AppService class*
![alt text](/.readmeimages/image5.jpg)

*checkWin()* method duty is check that some player is winner. This functionality is realized in private method *checkRowColumnDiagonal()*. This method return true if actual player is winner and false if is not.

*Image shows checkWin() method from AppService class*
![alt text](/.readmeimages/image6.jpg)

*checkRowColumnDiagonal()* method searching win set of "X" or "O" in String tab.
This method store f11, f12, ..., f33 String variables and that corresponds with coordinates fields[0][0], fields[0][1], ..., fields[2][2].
In boolean[] check is saved results of 8 calls of check3fields() method. Three calls of this method check win in all rows, next three in all columns and last dwo in diagonal of tab. This method return true or false. If any of result is true then win is true - in this situation actual player is winner.

*Image shows checkColumnRowDiagonal() method from AppService class*
![alt text](/.readmeimages/image7.jpg)

*check3fields()* method check that in one line of three fields of tab (row, column or diagonal) is the same value "X" or "O" and check that fields is not empty " ". In this situation return true.

*Image shows check3fields() private method from AppService class*
![alt text](/.readmeimages/image8.jpg)

*showWinner()* method called *PrintService.printGame()* method which shows information about that actual player is winner.
*nextPlayer()* method change player - if actual is "X" then next is "O". When actual is "O" then next is "X".
*getScannerInput()* method realized get value from keyboard with use Scanner class. Value is saved to String and this variable is returned.

*Image shows showWinner(), nextPlayer(), getScannerInput() methods from AppService class*
![alt text](/.readmeimages/image9.jpg)

*PrintService* class enables show info about actual status of game and helpful messages during game.
*printGame()* realized different duties and it is depend on transferred variables: String[][] fields - actual status of game, and message variable with actual step of game (actual player, win, draw etc.).
*printMessageColumn()* and *printMessageRow()* method is used in *setCoordinate()* method to show information about actual coordinate (row or column).

*Image shows PrintService class methods*
![alt text](/.readmeimages/image10.jpg)

*Example execution of CrossAndCircle application:*
*In first step application give question about first player "X" or "O". User enter "X".*
![alt text](/.readmeimages/image11.jpg)

*In second step user enter coordinates of row and column eg. (1,1) and that corresponds with field[0][0].*
![alt text](/.readmeimages/image12.jpg)

*Actual status is saved at field[0][0] and show in console at (1,1).*
![alt text](/.readmeimages/image13.jpg)

*When some column, row or diagonal contains the same sign "X" or "O" actual player is winner - in this situation "X" is winner.*
![alt text](/.readmeimages/image14.jpg)
