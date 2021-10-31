static int count = 0;
int x = 1;
boolean show = false;
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);

}

void loop() {
  // put your main code here, to run repeatedly:
  if(Serial.available()){
    //show = true;

    char val = Serial.read();
    Serial.print(val);
    
    count++; 

      if(Serial.read() == -1){
        x++;
        if(x>100){
          show = true;
        }
      }
  }
  
  if(!Serial.available() && count > 0){
    if(show){
      Serial.println(count);
      show = false;
      count = 0;
   }
  }

}
