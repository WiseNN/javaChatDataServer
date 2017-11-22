import java.util.HashMap;
import java.util.*;

import static spark.Spark.*;
import dataProcessing.Encryption;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;





public class Main
{
    static int num = 0;
    private static JSONObject msgObj;
    private static JSONObject privateConvoObj;

    public static void main(String[] args)
    {
        //do not touch
        port(getHerokuAssignedPort());


        Main mainClassObj = new Main();
        Encryption op1 = new Encryption();

        mainClassObj.createAndPrintJSONObject();







        //I am going to send a String, HashMap<String, String>
        get("/encodeData/:data", (req, res) -> req.params("data"));
        get("/decodeData", (req, res) -> "Decoding Data");
        get("/", (req,res) -> "Hello There Heroku for Java, nice for you to have joined us! ;)");
    }



    void createAndPrintJSONObject()
    {

        /*
        *
        *
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


        *
        * I am only adding the first message of the sample object above to the example below
        * */

        //creating the parent json object
        JSONObject parentObj = new JSONObject();
        parentObj.put("_id", "WiseNN");
        parentObj.put("_v", 4);
//      parentObj.put("privateConvos", []);       << below we are creating the objects & arays inside of key: "priavteConvos", then will
//                                             add them to the "privateConvos" key


        //first we have to create an privateConvo object to put in the privateConvo(s) array
        privateConvoObj = new JSONObject();
        privateConvoObj.put("recipientId", "TaslimD");
        privateConvoObj.put("_id", "WiseN");
        privateConvoObj.put("__v", 0);
//      privateConvosObj("messages", );        <<< creating array of messages below

        //creating the arrary for the key "messages"
        JSONArray msgsAry = new JSONArray();

        //creating the object in the array for the key "messages"
        msgObj = new JSONObject();
        msgObj.put("_id ", "5a130b5ac9b53d2d73e10952");
        msgObj.put("text", "Hey Whats Up");
        msgObj.put("sender", "WiseN");
        msgObj.put("time", " 12:05:29 GMT-0500 (EST)");
        msgObj.put("date", "October 20, 2017");

        //now adding the object to the array for key "messages"
        msgsAry.add(msgObj);

        //now creating the key: "messages" and value: array of objects, and adding messages array to privateConvos object
        privateConvoObj.put("messages", msgsAry);

        //now creating privateConvos array
        JSONArray privateConvos = new JSONArray();

        //now adding privateConvo to privateConvos array
        privateConvos.add(privateConvoObj);

        //now creating key: "privateConvos" and value: array of privateConvo objects
        //we are also adding privateConvos object to parent object
        parentObj.put("privateConvos", privateConvos);

        //print the parentObj to see output
        System.out.println(parentObj.toJSONString());


        //please note that this is possible as well (below)

//        JSONObject json = new JSONObject(jsonString); // Convert text to object
//        System.out.println(json.toString(4)); // Print it with specified indentation
    }















    static int getHerokuAssignedPort()
    {
        ProcessBuilder processBuilder = new ProcessBuilder();

        if (processBuilder.environment().get("PORT") != null) {

            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }

        return 4567;
    }



}
