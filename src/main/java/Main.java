import static spark.Spark.*;

import dataProcessing.Encryption3;
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
        Encryption3 op1 = new Encryption3();









        //I am going to send a String, HashMap<String, String>
        get("/encodeData/:data", (req, res) -> "Encoding Data...");
        get("/decodeData/:data", (req, res) -> "Decoding Data....");
        get("/", (req,res) -> "Hello There Heroku for Java, nice for you to have joined us! ;)");
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
