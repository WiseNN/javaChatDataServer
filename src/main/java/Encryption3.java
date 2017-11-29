import java.util.ArrayList;
import java.util.Arrays;

import org.json.*;

public class Encryption3
{


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

		Encryption3 op1 = new Encryption3();

		op1.wrapper(parentObj, "encrypt", null);
	}
        
       void wrapper(JSONObject parentObj, String doWhat, ArrayList<Integer> randonNumsAryFromClient)
       {
//       {   String[] both = (String[])ArrayUtils.addAll(first, second);
       
       

       
       
    	  //create arrayList for randomNumbers if encrypting
    	   ArrayList<Integer> randomNumsAry = new ArrayList<Integer>();

    	   //create increment counter for indexes of randomNumsAryFromClient
		   int clientNumsAryCounter = 0;

    	   //get length of privateConvos
    	   int lengthOfPrivateConvos = parentObj.getJSONArray("privateConvos").length();
    	   
    	   //iterate over every convo in the array of private convos
    	   for(int i=0;i<lengthOfPrivateConvos;i++)
    	   {
    		   //get recipientId from parent Object (param)
    		   String recipientId = parentObj.getJSONArray("privateConvos").getJSONObject(i).getString("recipientId");

			   //if we want to encrypt and we dont have a random numbers array from the client, we will encrypt
			   if( doWhat.equals("encrypt") && randonNumsAryFromClient == null)
			   {

				   //get random number array for recipientId
				   int[] randomNumAryForRecipientId = ranz(recipientId);

				   //iterate over the array of random numbers for recipientId, and add each elm to randomNumsAry
					for(int e=0;e<randomNumAryForRecipientId.length;e++)
					{
						//adding random numbers from the random numbers array for recipientId to randomNumsAry
						randomNumsAry.add(randomNumAryForRecipientId[e]);

					}
				   System.out.println("randomNumsArray: "+randomNumsAry.toString()+" recipientId RandomNumsAry: "+Arrays.toString(randomNumAryForRecipientId));


					 //encrypt the recipientId
					   String encryptedRecipientId = encrypt(recipientId, randomNumAryForRecipientId);

					   System.out.println("encrypted RecipientId: "+encryptedRecipientId);

					   //set the encrypted RecipientId to the new value of the recipientId key in the parentObj
				       parentObj.getJSONArray("privateConvos").getJSONObject(i).put("recipientId", encryptedRecipientId);

				       System.out.println("printed object afer recipientId encryption: "+parentObj.toString(3));


    		   }//if we want to decrypt and we have a random numbers array from the client, we will decrypt
    		   else if(doWhat.equals("decrypt") && randonNumsAryFromClient != null)
    		   {
    			   
    			  
    			   //get random numbers from randomNumsAry for recipientId & store in int variable
    			    int recipientIdLength = recipientId.length();

				   //pass length of returned array, and the client array to generate a short array of nums representing the recipientId
				   int[] decryptAryForRecipientId = arrayGen(recipientIdLength, randonNumsAryFromClient);

    			   //decrypt the recipientId
        		   String decryptedRecipientId = decrypt(recipientId, decryptAryForRecipientId);

        		   System.out.println("decrypted recipientId: "+decryptedRecipientId);

				   //set the decrypted RecipientId to the new value of the recipientId key in the parentObj
				   parentObj.getJSONArray("privateConvos").getJSONObject(i).put("recipientId", decryptAryForRecipientId);

				   System.out.println("printed object afer recipientId decryption: "+parentObj.toString(3));
    		   }
    		   
    		   
    		   //get the array of messages from the parent Object (param)
    		   JSONArray msgsAry = parentObj.getJSONArray("privateConvos").getJSONObject(i).getJSONArray("messages");
    		   
    		   //iterate over messages array of message JSON Objects
    		   for(int k=0;k<msgsAry.length();k++)
    		   {
    			   
    			    //get one message object, and access text in JSON object
    			    String oneMsg = msgsAry.getJSONObject(k).getString("text");


				   //if we want to encrypt and we dont have a random numbers array from the client, we will encrypt
				   if( doWhat.equals("encrypt") && randonNumsAryFromClient == null)
				   {

					   //generate random array of numbers for one message
					   int[] randomNumAryForOneMsg = ranz(oneMsg);

					   //iterate over the array of random numbers for one message, and add each elm to randomNumsAry
					   for (int e = 0; e < randomNumAryForOneMsg.length; e++) {

						   //adding random numbers from the random numbers array for one message to randomNumsAry (for all msgs)
						   randomNumsAry.add(randomNumAryForOneMsg[e]);
					   }

					   System.out.println("randomNumsArray: " + randomNumsAry.toString() + " random nums array for one message: " + Arrays.toString(randomNumAryForOneMsg));

					   //send random array of numbers for message, and text from message to encrypt function, store encrypted text
					   String encryptedOneMsgText = encrypt(oneMsg, randomNumAryForOneMsg);

					   //print the encrypted one message text
					   System.out.println("encrypted OneMsg: "+encryptedOneMsgText);

					   //set the encrypted one message object's text key's value in parentObj to the new value of the encryptedOneMsgText
					   parentObj.getJSONArray("privateConvos").getJSONObject(i).getJSONArray("messages").getJSONObject(k).put("text", encryptedOneMsgText);

					   System.out.println("printed object afer OneMesgText encryption: "+parentObj.toString(3));
				   }
				   else if(doWhat.equals("decrypt") && randonNumsAryFromClient != null)
				   {
					   //get random numbers from randomNumsAry for one message & store in int variable
					   int oneMsgLength = oneMsg.length();

					   //pass length of returned array, and the client array to generate a short array of nums representing the one message
					   int[] decryptAryForOneMsgText = arrayGen(oneMsgLength, randonNumsAryFromClient);

					   //decrypt the one message
					   String decryptedOneMsgText = decrypt(recipientId, decryptAryForOneMsgText);

					   //print the decrypted one message text
					   System.out.println("decrypted OneMsgText: "+decryptedOneMsgText);

					   //set the decrypted one message object's text key's value in parentObj to the new value of the decryptedOneMsgText
					   parentObj.getJSONArray("privateConvos").getJSONObject(i).getJSONArray("messages").getJSONObject(k).put("text", decryptedOneMsgText);


				   }

    
    			    
    		   }
    		   
    		   
    		   
    		   
    	   }
    	   
//    	   // copy json object to new json object
//    	   JSONObject copy = new JSONObject(parentObj, JSONObject.getNames(parentObj));
//
//
//
//    	   //Get the convoArray
//    	   JSONArray cArray = copy.getJSONArray("privateConvos"); // [{}]
//
//
//    	   for(int i = 0; i < cArray.length(); i++)
//    	   {
//    		   JSONObject aPrivateConvo = cArray.getJSONObject(i);
//    		   JSONArray Messages = aPrivateConvo.getJSONArray("messages");
//
//    		    // Iterate over the json object in json array messages
//    		   for (int j = 0; j < Messages.length();j++)
//    		   {
//    			   JSONObject aMessage = Messages.getJSONObject(j);
//    			   String text = aMessage.getString("text");
//    			   int [] randomNumText = ranz(text);
//    			   String encryptedText = encrypt(text,randomNumText);
//
//    		   }
//    	   }
//
////    	   return copy;
       }
//
       private int[] arrayGen(int strLength, ArrayList<Integer> clientAry)
	   {
	   		//create decryption array of one encrypted string length
	   		int[] oneStrDecryptAry = new int[strLength];

	   		//map clientAry elements to decryption array
	   		for(int i=0;i<strLength;i++)
			{
				//remove and return the Integer removed from the client's randomNumsAryFromClient & store in decrypAry for one string
				oneStrDecryptAry[i] = clientAry.remove(i);

			}

	   	return oneStrDecryptAry;
	   }

}
