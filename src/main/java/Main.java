import static spark.Spark.*;

import dataProcessing.Encryption3;
//import org.json.JSONObject;
//import org.json.simple.*;
//import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.*;



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










        //I am going to send a String, HashMap<String, String>
        get("/encryptData", (req, res) -> {



            //get quary params
            String strObj = (String)req.queryParams("dataObj");
            String doWhat = (String)req.queryParams("doWhat");

            //create JSON Object for input Object
            JSONObject obj = new JSONObject(strObj);

            System.out.println("See request query: "+strObj);
            System.out.println("See request query converted object: "+obj);

            //create encryption object and encrypt data
            Encryption3 op1 = new Encryption3();
            JSONObject returnObj = op1.wrapper(obj, "encrypt");

            System.out.println("RETURNED OBJECT GRAND FUCKING FINALE!!! : "+returnObj.toString(3));


            return returnObj;
        });
        get("/decryptData/:data", (req, res) -> {

            //get quary params
            String strObj = (String)req.queryParams("dataObj");
            String doWhat = (String)req.queryParams("doWhat");



            //create JSON Object for input Object
            JSONObject obj = new JSONObject(strObj);

            System.out.println("See request query: "+strObj);
            System.out.println("See request query converted object: "+obj);

            //create decryption object and decrypt data
            Encryption3 op1 = new Encryption3();
            JSONObject returnObj = op1.wrapper(obj, doWhat);

            System.out.println("RETURNED OBJECT GRAND FUCKING FINALE!!! : "+returnObj.toString(3));

            return returnObj;
        });
        get("/", (req,res) -> "Hello There Heroku for Java, nice of you to have joined us! ;)");
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
