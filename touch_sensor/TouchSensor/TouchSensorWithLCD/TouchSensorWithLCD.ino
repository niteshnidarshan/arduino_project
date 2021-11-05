#include <Wire.h> 
#include <LiquidCrystal_I2C.h>
/**
Touch sensor response Print on 16x2 display.
*/
LiquidCrystal_I2C lcd(0x27,16,2);  // set the LCD address to 0x27 for a 16 chars and 2 line display

void setup() {
  // put your setup code here, to run once:
  
  lcd.init();                      // initialize the lcd 
  lcd.backlight(); 
  lcd.clear();
  lcd.home();
  
  pinMode(2, INPUT); //Touch sensor 1st.
  pinMode(4, INPUT); //Touch sensor 2nd.
  

}

void loop() {
  // put your main code here, to run repeatedly:
  if(digitalRead(2) == HIGH) {
    lcd.clear();
    lcd.print("1st sensor!");
  }

  if(digitalRead(4) == HIGH) {
    lcd.clear();
    lcd.print("2nd sensor!");
  }
}
