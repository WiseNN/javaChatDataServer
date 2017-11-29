package youtube;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.*;
public class Encryption3 {


	/*
	 * This function ranz generates random integers based on the length of a text
	 */
	private static int[]ranz(String mystr){
		int [] randNum = new int[mystr.length()];
		for (int i = 0; i < randNum.length; i++){
			randNum[i] = (int)(Math.random()*26+1);
		}
		return randNum;
	}
	
	/*
	 * This function encrypt encrypts any given message.
	 */

	
	private static String encrypt(String plainText, int[]shiftNum){
		String cipherText = "";
		int length = plainText.length();
		
		for(int i = 0; i<length; i++){
			int shift = shiftNum[i];
			char ch = plainText.charAt(i);
			if(Character.isLetter(ch)){
				if(Character.isLowerCase(ch)){
					char c = (char)(ch+shift);
					if(c>'z'){
						cipherText += (char)(ch - (26-shift));
					}
					else{
						cipherText += c;
					}
				}
				else if(Character.isUpperCase(ch)){
					char c = (char)(ch+shift);
					if(c>'Z'){
						cipherText += (char)(ch - (26-shift));
					}
					else{
						cipherText += c;
					}
				}
			}
			else{
				cipherText += ch;
			}
		}
		return cipherText;
	}
	/*
	 * This function decrypt decrypts any encrypted message.
	 */
	private static String decrypt(String plainText, int[]shiftNum){
		String cipherText = "";
		int length = plainText.length();
		for(int i = 0; i<length; i++){
			int shift = shiftNum[i];
			char ch = plainText.charAt(i);
			if(Character.isLetter(ch)){
				if(Character.isLowerCase(ch)){
					char c = (char)(ch-shift);
					if(c<'a'){
						cipherText += (char)(ch + (26-shift));
					}
					else{
						cipherText += c;
					}
				}
				else if(Character.isUpperCase(ch)){
					char c = (char)(ch-shift);
					if(c<'A'){
						cipherText += (char)(ch + (26-shift));
					}
					else{
						cipherText += c;
					}
				}
			}
			else{
				cipherText += ch;
			}
		}
		return cipherText;
	}
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
	
	
	
	public static void main(String[]args)
	{
		
		//creating the object in the array for the key "messages"
        JSONObject msgObj = new JSONObject();
        msgObj.put("_id ", "5a130b5ac9b53d2d73e10952");
        msgObj.put("text", "Hey Whats Up");
        msgObj.put("sender", "WiseN");
        msgObj.put("time", " 12:05:29 GMT-0500 (EST)");
        msgObj.put("date", "October 20, 2017");
        //////////////////////////////////////////////////////////
        JSONObject msgObj2 = new JSONObject();
        msgObj2.put("_id ", "5a130b5ac9b53d2d73e10952");
        msgObj2.put("text", "Hey, Nothing much, this API has really been kicking my ass");
        msgObj2.put("sender", "WiseN");
        msgObj2.put("time", " 12:05:29 GMT-0500 (EST)");
        msgObj2.put("date", "October 20, 2017");
        
      //creating the array for the key "messages"
        JSONArray msgArray = new JSONArray();
        msgArray.put(msgObj);
        msgArray.put(msgObj2);
        
		//Create an privateConvo object to put in the privateConvo(s) array
        JSONObject privateConvoObj = new JSONObject();
        privateConvoObj.put("recipientId", "TaslimD");
        privateConvoObj.put("_id", "WiseN");
        privateConvoObj.put("__v", 0);
        privateConvoObj.put("messages", msgArray); 

     // create a json array convArray
        JSONArray convoArray = new JSONArray();
        
     // adding the privateConvoObj to the covoArray
        convoArray.put(privateConvoObj);
        
     // adding values to the parent object
		JSONObject parentObj = new JSONObject();
        parentObj.put("_id", "WiseN");
        parentObj.put("_v", 4);
        parentObj.put("privateConvos",convoArray);
//        JSONObject suck  = wrapper(parentObj);
//        System.out.println(suck);
        wrapper(parentObj);
	}
        
       static void wrapper(JSONObject parentObj, String doWhat)
       {
//       {   String[] both = (String[])ArrayUtils.addAll(first, second);
       
       
       
       
       
    	  //create arrayList for randomNumbers
    	   ArrayList<Integer> randomNumsAry = new ArrayList<Integer>();

    	   //get length of privateConvos
    	   int lengthOfPrivateConvos = parentObj.getJSONArray("privateConvos").length();
    	   
    	   //iterate over every convo in the array of private convos
    	   for(int i=0;i<lengthOfPrivateConvos;i++)
    	   {
    		   //get recipientId from parent Object (param)
    		   String recipientId = parentObj.getJSONArray("privateConvos").getJSONObject(i).getString("recipientId");
    		   
    		   //get random number array for recipientId
    		   int[] randomNumAryForRecipientId = ranz(recipientId);
    		   
    		   //iterate over the array of random numbers for recipientId, and add each elm to randomNumsAry
			    for(int e=0;e<randomNumAryForRecipientId.length;e++)
			    {
			    	//adding random numbers from the random numbers array for recipientId to randomNumsAry 
			    	randomNumsAry.add(randomNumAryForRecipientId[e]);
			    	
			    }
    		   System.out.println("randomNumsArray: "+randomNumsAry.toString()+" recipientId RandomNumsAry: "+Arrays.toString(randomNumAryForRecipientId));
    		   
    		  
    		   if( doWhat.equals("encrypt"))
    		   {
    			 //encrypt the recipientId
        		   String encryptedRecipientId = encrypt(recipientId, randomNumAryForRecipientId);   
    		   }
    		   else if(doWhat.equals("decrypt"))
    		   {
    			   
    			  
    			   //get random numbers from randomNumsAry for recipientId
    			    recipientId.length();  //STOPPING POINT!!!
    			    
    			   //decrypt the recipientId
        		   String decryptedRecipientId = decrypt(recipientId, randomNumAryForRecipientId);   
    		   }
    		   
    		   
    		   //get the array of messages from the parent Object (param)
    		   JSONArray msgsAry = parentObj.getJSONArray("privateConvos").getJSONObject(i).getJSONArray("messages");
    		   
    		   //iterate over messages array of message JSON Objects
    		   for(int k=0;k<msgsAry.length();k++)
    		   {
    			   
    			    //get one message object, and access text in JSON object
    			    String oneMsg = msgsAry.getJSONObject(k).getString("text");
    			    
    			    //generate random array of numbers for one message
    			    int[] randomNumAryForOneMsg = ranz(oneMsg);
    			    
    			    //iterate over the array of random numbers for one message, and add each elm to randomNumsAry
    			    for(int e=0;e<randomNumAryForOneMsg.length;e++)
    			    {
    			    	//adding random numbers from the random numbers array for one message to randomNumsAry (for all msgs)
    			    	randomNumsAry.add(randomNumAryForOneMsg[e]);
    			    }
    			    
    			    System.out.println("randomNumsArray: "+randomNumsAry.toString()+" random nums array for one message: "+Arrays.toString(randomNumAryForOneMsg));
    			    
    			    //send random array of numbers for message, and text from message to encrypt function, store encrypted text
    			    String encryptedText = encrypt(oneMsg, randomNumAryForOneMsg);
    
    			    
    		   }
    		   
    		   
    		   
    		   
    	   }
    	   
    	   // copy json object to new json object
    	   JSONObject copy = new JSONObject(parentObj, JSONObject.getNames(parentObj));
    	   
    	   
    	   
    	   //Get the convoArray
    	   JSONArray cArray = copy.getJSONArray("privateConvos"); // [{}]
    	   
    	  
    	   for(int i = 0; i < cArray.length(); i++)
    	   {
    		   JSONObject aPrivateConvo = cArray.getJSONObject(i);
    		   JSONArray Messages = aPrivateConvo.getJSONArray("messages");
    		   
    		    // Iterate over the json object in json array messages
    		   for (int j = 0; j < Messages.length();j++)
    		   {
    			   JSONObject aMessage = Messages.getJSONObject(j);
    			   String text = aMessage.getString("text");
    			   int [] randomNumText = ranz(text);
    			   String encryptedText = encrypt(text,randomNumText);
    			   
    		   }
    	   }
    	   
//    	   return copy;
       }
}
