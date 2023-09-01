/*
 * Displays text with marquee
 */
#include <Wire.h> 
#include <LiquidCrystal_I2C.h>

LiquidCrystal_I2C lcd(0x27,16,2);  // set the LCD address to 0x27 for a 16 chars and 2 line display
//Connect SDA to A4 of arduino and SCL to A5 of arduino
// The additional white space is intentional to make things legible and look nice.
String str = "       This is Nitesh nidarshan from Bihar...              ";
int i = 0;
int strLength;
String toShow;
void setup()
{
  lcd.init();                      // initialize the lcd 
  lcd.backlight(); 
  strLength = str.length();
  lcd.clear();
  lcd.home();
}

void loop()
{
  //lcd.home();
  lcd.setCursor(0,0);
  lcd.print("Jai Ram G ki!" );

  lcd.setCursor(0,1);
  // Get 16 characters so that we can display on the LCD
  toShow = str.substring(i,i+16);
  
  // print the number of seconds since reset:
  lcd.print(toShow);

  i = i + 2;

  // We have to reset i after there is less text displayed.
  if(i>(strLength-16)) {
    i = 0;
  }

  delay(500);
} 
