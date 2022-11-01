package com.example.phonenumber

import android.widget.Toast
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel

class MainActivity: FlutterActivity() {

    private val CHANNEL="com.example.phonenumber";
    private lateinit var channel:MethodChannel

    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)

        channel= MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL);
        channel.setMethodCallHandler { call, result ->
//            var argument = call.arguments as Map<String, String>  //for show toast
//            var message = argument["msg"];
//            if (call.method == "method") {
//                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//            }
            if (call.method=="method"){  //this is for show text
                val messageText= getMesaager();
                if(messageText.isNotEmpty()) {
                    result.success(messageText);
                }else{
                    result.error("MASRAFI", "This error message from kotlin code", null);
                }
            }
      }
            }

    private  fun getMesaager(): String {
        return "This message from Kotlin Code"
    }
}