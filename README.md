# javaChatDataServer

This is a Java Server used for intensive CPU Data Manipulation. This is a client server, and will take requests from the API built in the: csc2720_Project repository.  All group members responsible for constructing algorithms to aggregate the data model, please clone this repository. 

<b>The Following code block is reffering to changes that need to be made in the DataProcessing/Encryption.java file</b>


<ul>Changes:</ul>



The caller is going to call your function like this (data types are in arguments):
    
    Encryption op1 = new Encryption();
		HashMap<String , Object> returnValue =	op1.wrapperFunc(String , HashMap<String, Object>);
		
Example <b>HashMap</b> parameter: 
```
{
   "_id": "WiseN",
   "__v": 4,
   "privateConvos": [
      {
         "recipientId": "TaslimD", (encrypt)
         "_id": "WiseN",
         "__v": 0,
         "messages": [
            {
               "_id": "5a130b5ac9b53d2d73e10952",
               "text": "Hey Whats Up", (encrypt)
               "sender": "WiseN",
               "time": " 12:05:29 GMT-0500 (EST)",
               "date": "October 20, 2017"
            },
            {
               "_id": "5a130c2fc9b53d2d73e10953",
               "text": "Hey, Nothing much, this API has really been kicking my ass", (encrypt)
               "sender": "TaslimD",
               "time": " 12:09:03 GMT-0500 (EST)",
               "date": "October 20, 2017"
            },
            {
               "_id": "5a130c70c9b53d2d73e10954",
               "text": "I bet. This homework as pretty much taken over my life. Im just trying to stay a float lol", (encrypt)
               "sender": "WiseN",
               "time": " 12:10:08 GMT-0500 (EST)",
               "date": "October 20, 2017"
            }
         ]
      }
   ]
}
```

1) Your wrapper function should be able to accept a string parameter, and a HashMap of type <String, Object>
2) Write a switch or if statement to handle the request of encrypt or decrypt
3) You should return a value of type HashMap<String, Object>
4) ALL of the methods inside of your wrapper function should be private and none-accessible outside of the class

DO NOT FOCUS ON, WE WILL REVISIT

5) Remember the purpose of your algorithm, to encrypt and decrypt data; which means you need to store the key somewhere
6) When your wrapper function is called to encrypt data, you should encrypt/Salt the array of random numbers, keep the key, and
destroy the array of random numbers. IT SHOULD NOT BE STORED IN YOUR PROGRAM
7) After you have encrypted the Array of random numbers, the salted key to decrypt the array of
random numbers should be returned inside of the hashMap under the key "saltedKey"


If you have any questions please do not suffer in silence, we are here to help one another.

Thank you!
