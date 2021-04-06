package com.chitransh.testrun1;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    String data = "[" +
      "  {" +
      "    \"userId\": 189479835," +
      "    \"id\": 1," +
      "    \"title\": \"quidem molestiae enim\"" +
      "  }," +
      "  {" +
      "    \"userId\": 1," +
      "    \"id\": 2," +
      "    \"title\": \"sunt qui excepturi placeat culpa\"" +
      "  }," +
      "]";

//    String data2 = "[  {    \"userId\": 1,    \"id\": 1,    \"title\": \"quidem molestiae enim\"  },  {    \"userId\": 1,    \"id\": 2,    \"title\": \"sunt qui excepturi placeat culpa\"  },]";

    try {
      JSONArray array = new JSONArray(data);

      for (int i = 0; i < array.length(); i++) {
        JSONObject post = array.getJSONObject(i);

        Log.e("Post " + i, "----------------------------");
        Log.e("userId", post.getString("userId"));
        Log.e("id", post.getString("id"));
        Log.e("title", post.getString("title"));
      }
    } catch (JSONException e) {
      Log.e("Error: ", e.getMessage());
    }

  }
}