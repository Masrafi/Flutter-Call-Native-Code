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
            var argument = call.arguments as Map<String, String>
            var message = argument["msg"];
            if (call.method=="method"){
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
