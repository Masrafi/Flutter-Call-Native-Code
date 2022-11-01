import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class MyHomePage extends StatefulWidget {
  const MyHomePage({Key? key}) : super(key: key);

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  String _message = 'unknown message';
  static const channel = MethodChannel('com.example.phonenumber');
  // Future showToast() async {  //for show toast
  //   final int show = await channel.invokeMethod('method',
  //       <String, String>{'msg': "This is message from Flutter to Native"});
  // }

  Future _getMessage() async {
    //for show text
    String messageFromNativeCode;
    try {
      messageFromNativeCode = await channel.invokeMethod('method');
    } on PlatformException catch (e) {
      messageFromNativeCode = 'Faild to get message: ${e.message}';
    }
    setState(() {
      _message = messageFromNativeCode;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              _message,
              style: const TextStyle(
                fontSize: 20,
              ),
            ),
            const SizedBox(
              height: 20,
            ),
            ElevatedButton(
              onPressed: () {
                //showToast();
                _getMessage();
              },
              child: const Text("Show"),
            )
          ],
        ),
      ),
    );
  }
}
