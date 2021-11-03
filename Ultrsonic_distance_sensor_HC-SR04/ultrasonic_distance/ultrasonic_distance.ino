#include <Wire.h> 
#include <LiquidCrystal_I2C.h>

// defines pins numbers
const int trigPin = 9;
const int echoPin = 10;
int distanceCm, distanceInch;
// defines variables
long duration;
int distance;

LiquidCrystal_I2C lcd(0x27,16,2);

void setup() {
pinMode(trigPin, OUTPUT); // Sets the trigPin as an Output
pinMode(echoPin, INPUT); // Sets the echoPin as an Input

lcd.init();                      // initialize the lcd 
lcd.backlight();
Serial.begin(9600); // Starts the serial communication
}
void loop() {
// Clears the trigPin
digitalWrite(trigPin, LOW);
delayMicroseconds(2);
// Sets the trigPin on HIGH state for 10 micro seconds
digitalWrite(trigPin, HIGH);
delayMicroseconds(10);
digitalWrite(trigPin, LOW);
// Reads the echoPin, returns the sound wave travel time in microseconds
duration = pulseIn(echoPin, HIGH);
// Calculating the distance
distanceCm= duration*0.034/2;
distanceInch = duration*0.0133/2;
// Prints the distance on the Serial Monitor
//Serial.print("Distance: ");
//Serial.print(distanceCm);
//Serial.print(" cm");
//Serial.println();
lcd.setCursor(0,1);
//Serial.println("Jai Ram G ki");
//lcd.print("Hello World!");
lcd.print("distance: ");
lcd.print(distanceCm);
lcd.println(" cm");
lcd.setCursor(0,0);
lcd.print("Jai Ram G ki");
delay(1000);
}
