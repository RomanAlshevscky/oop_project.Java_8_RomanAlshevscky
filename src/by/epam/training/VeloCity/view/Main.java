package by.epam.training.velocity.view;


import by.epam.training.velocity.bean.Request;
import by.epam.training.velocity.bean.Response;
import by.epam.training.velocity.controller.Controller;
import by.epam.training.velocity.controller.Exception.ControllerException;
import by.epam.training.velocity.view.Exception.ViewException;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static String shopName = "velocity";
    private static Controller controller = new Controller();

    public static void main(String[] args) {
        welcomeMessage();
        try {
            String startPage = sendRequest(createRequest("RETURN_ALL_CATEGORIES"));
            System.out.print(startPage);
        } catch(ViewException ve) {
// без комментариев оставим пустой catch
            // сам себе глову пеплом посыпешь
        }
        listen();
    }

    private static void listen(){
        boolean stop = false;
        Scanner scan = new Scanner(System.in);
        while(!stop){
            String requestString = scan.nextLine();
            try {
                Request request = createRequest(requestString);
                String response = sendRequest(request);
                System.out.print(response);
            } catch(ViewException ve){

            }
        }
    }

    private static Request createRequest(String requestString) throws ViewException{
        Request request = new Request();
        request.setCommandName(parseRequestName(requestString));
        request.setParams(parseRequestArguments(requestString));
        return request;
    }

    private static String parseRequestName(String requestString) throws ViewException {
        String result = new String();
        int endIndex = requestString.indexOf(' ');
        if(endIndex == -1)
            return requestString.substring(0, requestString.length());
        else
            return requestString.substring(0, endIndex);
    }

    private static List<String> parseRequestArguments (String requestString) throws ViewException{
        List<String> args = new LinkedList<>();
        Pattern p = Pattern.compile(" [^ $]+");
        Matcher m = p.matcher(requestString);
        while (m.find()){
            String match = m.group(0);
            args.add(match.substring(1, match.length()));
        }
        return args;
    }

    private static String sendRequest(Request request) throws ViewException{
        String result = "";
        try {
            Response r = controller.doAction(request);
            if (r.getErrorStatus())
                throw new ViewException(r.getErrorMessage());
            StringBuilder sb = new StringBuilder();
            for (String s : r.getResponse())
                sb.append(s + "\n");
            result = sb.toString();
        } catch(ControllerException ce){
            result = "Command execute error, or command doesn't exists";
        }
            return result;

    }

    private static void welcomeMessage(){
        System.out.print("Welcom to " + shopName+ "!\n" +
                "Base commands: \n" +
                "  -RETURN_ALL_CATIGORIES,\n" +
                "  -ADD_CATEGORY 'category_name',\n" +
                "  -DELETE_CATEGORY 'category_name',\n" +
                "  -EDIT_CATEGORY 'old_category_name' 'new_category_name',\n" +
                "  -RETURN_CATEGORY_ITEMS 'category_name',\n" +
                "  -ADD_ITEM 'category_name' 'item_name' 'item_price' 'item_count',\n" +
                "  -DELETE_ITEM 'item_name',\n" +
                "  -EDIT_ITEM 'old_item_name' 'new_item_name' 'new_item_price' 'new_item_count',\n" +
                "  -RETURN_REPORT;\n");

    }
}


