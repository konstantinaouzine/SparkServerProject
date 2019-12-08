import com.google.gson.Gson;
import spark.Request;
import spark.Response;

import static spark.Spark.*;

public class SpartRESTfulService {
    public static void main(String[] args) {
        get("/users/:id", (Request request, Response response) -> {
            response.type("application/json");
            int id = Integer.parseInt(request.params(":id"));
            User usr_to_return = UserService.getUser(id);
            if (usr_to_return == null) {
                return new Gson().toJson(new StandardResponse(ResponseStatus.ERROR, new Gson().toJson("User not found or error in Get operation")));
            } else {
                return new Gson().toJson(new StandardResponse(ResponseStatus.SUCCESS, usr_to_return));
            }
        });

        get("/getList", (Request request, Response response) -> {
            if (UserService.usersAmount()!=0){
                response.type("application/json");
                return new Gson().toJsonTree(UserService.getAllUsers());
            }
            else
                return new Gson().toJson(new StandardResponse(ResponseStatus.ERROR, "List of users is empty"));
        });

        post("/users", (request, response) -> {
            response.type("application/json");
            User user = new Gson().fromJson(request.body(), User.class);
            System.out.println("User from request:" +
                    "\nUser id: " + user.getId() +
                    "\nUser firstname: " + user.getFirstname() +
                    "\nUser lastname: " + user.getLastname() + "\n");
            UserService.addUser(user);
            return new Gson().toJson(new StandardResponse(ResponseStatus.SUCCESS));
        });

        put("/users/:id", (request, response) -> {
            int id = Integer.parseInt(request.params(":id"));
            User user = new Gson().fromJson(request.body(), User.class);
            User usr_to_return = UserService.updateUser(id, user);
            response.type("application/json");
            if (usr_to_return == null) {
                return new Gson().toJson(new StandardResponse(ResponseStatus.ERROR, new Gson().toJson("User not found or error in Edit operation")));
            } else {
                return new Gson().toJson(new StandardResponse(ResponseStatus.SUCCESS, usr_to_return));
            }
        });

        delete("/users/delete/:id", (request, response) -> {
            int id = Integer.parseInt(request.params(":id"));
            User usr_to_delete = UserService.deleteUser(id);
            response.type("application/json");
            if (usr_to_delete == null) {
                return new Gson().toJson(new StandardResponse(ResponseStatus.ERROR, new Gson().toJson("User not found or error in Delete operation")));
            } else {
                return new Gson().toJson(new StandardResponse(ResponseStatus.SUCCESS, (usr_to_delete)));
            }
        });
    }
}
