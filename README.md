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
         "recipientId": "TaslimD", (***ENCRYPT ***)
         "_id": "WiseN",
         "__v": 0,
         "messages": [
            {
               "_id": "5a130b5ac9b53d2d73e10952",
               "text": "Hey Whats Up", (***ENCRYPT ***)
               "sender": "WiseN",
               "time": " 12:05:29 GMT-0500 (EST)",
               "date": "October 20, 2017"
            },
            {
               "_id": "5a130c2fc9b53d2d73e10953",
               "text": "Hey, Nothing much, this API has really been kicking my ass", (***ENCRYPT ***)
               "sender": "TaslimD",
               "time": " 12:09:03 GMT-0500 (EST)",
               "date": "October 20, 2017"
            },
            {
               "_id": "5a130c70c9b53d2d73e10954",
               "text": "I bet. This homework as pretty much taken over my life. Im just trying to stay a float lol", (***ENCRYPT ***)
               "sender": "WiseN",
               "time": " 12:10:08 GMT-0500 (EST)",
               "date": "October 20, 2017"
            }
         ]
      }
   ]
}
```
<b>*** Watch this youtube video on how to process JSON Data in JAVA:</b><br /> https://www.youtube.com/watch?v=cFCgFlqF5kw <b>***</b>

1) Your wrapper function should be able to accept a string parameter, and a HashMap of type `HashMap<String, Object>`
2) Write a switch or if statement to handle the request of encrypt or decrypt
3) You should <b>return a value of type </b>`HashMap<String, Object>`<b> that looks just like the incoming argument (above)</b>
4) ALL of the methods inside of your wrapper function should be private and none-accessible outside of the class

DO NOT FOCUS ON, WE WILL REVISIT

5) Remember the purpose of your algorithm, to encrypt and decrypt data; which means you need to store the key somewhere
6) When your wrapper function is called to encrypt data, you should encrypt/Salt the array of random numbers, keep the key, and
destroy the array of random numbers. IT SHOULD NOT BE STORED IN YOUR PROGRAM
7) After you have encrypted the Array of random numbers, the salted key to decrypt the array of
random numbers should be returned inside of the hashMap under the key "saltedKey"
<hr />
The library er are using to read and write json objects is called <b>JSON.simple</b>. There are many tutorials and videos on how to use JSON.simple. A <i>simple</i> google search will help you. However, you can start here: https://www.mkyong.com/java/json-simple-example-read-and-write-json/ . The dependency for this libary has already been added to the repository.


<b>Please see the createAndPrintJSONObject()</b> function in the <b>Main class</b> file. Run it <i>(It will start the server)</i>, and look at the console output. Because I am having issues "pretty printing" the JSON object, copy and paste it into this 
website: https://jsonformatter.curiousconcept.com , you will see that it is the same as the example object.



If you have any questions please do not suffer in silence, we are here to help one another.

Thank you!
