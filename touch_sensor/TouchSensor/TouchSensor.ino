void setup() {
  // put your setup code here, to run once:
  pinMode(2, INPUT);
  Serial.begin(9600);

}

void loop() {
  // put your main code here, to run repeatedly:
  if(digitalRead(2) == HIGH){
    Serial.print("Sensor Touched 1st!");
  }
  Serial.print(digitalRead(2));

}
