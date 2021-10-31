
int pin = 13; //13 is having inbuilt LED.

void setup() {
  // put your setup code here, to run once:
   
  pinMode(13, OUTPUT); //Define a pin & its purpose

}

void loop() {
  // put your main code here, to run repeatedly:
  digitalWrite(pin, HIGH);
  delay(100);
  digitalWrite(pin, LOW);
  delay(100);
  digitalWrite(pin, HIGH);
  delay(100);
  digitalWrite(pin, LOW);
  delay(100);
  digitalWrite(pin, HIGH);
  delay(100);
  digitalWrite(pin, LOW);
  delay(3000);

}
