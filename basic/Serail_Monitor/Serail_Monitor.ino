//A program to run first Serial Monitor program

/*

Serial Communication in Arduino 
=====================================
Arduino uses tx and rx pins to use serial communication.
Serial communication follows UART protocols to read/ write by serial devices.

*/

void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600); //Means 9600 Bits per second(bits) speed will be used to communicate between Arduino & device. - A mandatory code to begin serial communication 
  

}

void loop() {
  // put your main code here, to run repeatedly:

  if(Serial.available()){
    char val = Serial.read();
    Serial.print(val);
      
  }

}
