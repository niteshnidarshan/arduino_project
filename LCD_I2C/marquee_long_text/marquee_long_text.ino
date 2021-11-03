/*
 * Displays text with marquee
 */
#include <Wire.h> 
#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27,20,4);  // set the LCD address to 0x27 for a 16 chars and 2 line display
int numRows = 2;
int numCols = 16;
void setup()
{
  lcd.init();                      // initialize the lcd 
  lcd.backlight(); 
}

void loop()
{
  lcd.clear();

  for(byte i=0; i<15; i++){
    lcd.setCursor(2,0);
    lcd.print("Jai Ram G ki");
    lcd.setCursor(15-i, 1);
    lcd.print("Hello World!   "); //make it total 15 charcter.
    delay(700);
  }
  
  /*marquee("Jai Ram G ki ............");
  delay(1000);
  lcd.clear();*/
  
}

/*void marquee(char *text)
{
  int length = strlen(text);
  if(length < numCols)
    lcd.print(text);
  else
  {
    int pos;
    for(pos = 0; pos < numCols; pos++)
      lcd.print(text[pos]);
    delay(1000);
    while(pos < length)
    {
      lcd.scrollDisplayLeft();
      lcd.print(text[pos]);
      pos = pos + 1;
      delay(500);  
    }  
  }
}*/
