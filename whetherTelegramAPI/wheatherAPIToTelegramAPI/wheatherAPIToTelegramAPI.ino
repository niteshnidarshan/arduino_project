#include <WiFi.h>
#include <HTTPClient.h>
#include <ArduinoJson.h>

const char* ssid = "JioFiber-XCC3a";
const char* password = "abcde@nidarshan";
//const char* apiKey = "2972c934abb7cda204f2a3395949a21f";

//Json parse configuration
  const size_t bufferSize = JSON_OBJECT_SIZE(1024); // Adjust the size accordingly
  DynamicJsonDocument jsonDoc(bufferSize);

void setup() {
  Serial.begin(115200);

  // Connect to Wi-Fi
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");

  // Fetch weather data
  getWeatherData();
}

void loop() {
  // Your code here
}

void getWeatherData() {
  HTTPClient http;

  // Your weather API URL
  String url = "https://api.openweathermap.org/data/2.5/weather?lat=25.5433817&lon=87.5690417&appid=2972c934abb7cda204f2a3395949a21f&units=metric";

  http.begin(url);

  int httpCode = http.GET();

  if (httpCode > 0) {
    if (httpCode == HTTP_CODE_OK) {
      String payload = http.getString();
      //Serial.println("Weather Data:");
      //Serial.println(payload);

      //JSON response parsing
      DeserializationError jsonError = deserializeJson(jsonDoc, payload);

      if (jsonError) {
        Serial.print(F("deserializeJson() failed: "));
        Serial.println(jsonError.c_str());
        return;
      }

      String location = jsonDoc["name"];
      String temp = jsonDoc["main"]["temp"];
      String humidity = jsonDoc["main"]["humidity"];

      String degreeSymbol = "\u2103";
      String negativeCubicMeterSymbol = "g.m\u207B\u00B3";
      //const char* value2 = jsonDoc["key2"];

      String message = "**Weather in "+location+"** %0A%0ATemp: "+temp+degreeSymbol+" %0AHumidity: "+humidity+negativeCubicMeterSymbol+" %0A%0AThank you!%0AJai Ram G Ki!!";
      Serial.println(message);

      //send to telegram
      String telegramUrl = "https://api.telegram.org/bot6333265379:AAGcg1_Q3liMvYDFlH7p-yx2-bYZTeoAwpg/sendMessage?chat_id=-952060841&text="+message;
      http.begin(telegramUrl);
      int httpCode1 = http.GET();

      if (httpCode1 > 0) {
        if (httpCode1 == HTTP_CODE_OK) {
          Serial.println("Message sent!");
        }
      } else {
        Serial.printf("HTTP request failed for Telegram, error: %s\n", http.errorToString(httpCode1).c_str());
      }
      
    }
  } else {
    Serial.printf("HTTP request failed, error: %s\n", http.errorToString(httpCode).c_str());
  }

  http.end();
}
