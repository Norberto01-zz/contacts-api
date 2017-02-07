package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Contact;
import models.ContactStore;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import java.util.Set;
import util.Util;
/**
 * Created by Developers on 2/7/2017.
 */
public class ContactController extends Controller {
    public Result create() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest(Util.createResponse("Expecting Json data", false));
        }
        Contact contact = ContactStore.getInstance().addContact(Json.fromJson(json, Contact.class));
        JsonNode jsonObject = Json.toJson(contact);
        return created(Util.createResponse(jsonObject, true));
    }

    public Result update() {
        JsonNode json = request().body().asJson();
        if (json == null) {
            return badRequest(Util.createResponse("Expecting Json data", false));
        }
        Contact contact = ContactStore.getInstance().updateContact(Json.fromJson(json, Contact.class));
        if (contact == null) {
            return notFound(Util.createResponse("Contact not found", false));
        }

        JsonNode jsonObject = Json.toJson(contact);
        return ok(Util.createResponse(jsonObject, true));
    }

    public Result retrieve(int id) {
        if (ContactStore.getInstance().getContact(id) == null) {
            return notFound(Util.createResponse("Contact with id:" + id + " not found", false));
        }
        JsonNode jsonObjects = Json.toJson(ContactStore.getInstance().getContact(id));
        return ok(Util.createResponse(jsonObjects, true));
    }

    public Result listContacts() {
        Set<Contact> result = ContactStore.getInstance().getAllContacts();
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(Util.createResponse(jsonData, true));

    }

    public Result delete(int id) {
        if (!ContactStore.getInstance().deleteContact(id)) {
            return notFound(Util.createResponse("Contact with id:" + id + " not found", false));
        }
        return ok(Util.createResponse("Contact with id:" + id + " deleted", true));
    }
}
