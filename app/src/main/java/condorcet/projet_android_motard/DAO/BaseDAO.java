package condorcet.projet_android_motard.DAO;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

public class BaseDAO {

    protected Client c;
    protected URI uri;
    protected WebResource service;
    protected Gson gson;
    protected String json;
    protected ClientResponse response;
    protected int status;

    public BaseDAO(){
        System.out.println("-- new DAO --");
        try {
            c = Client.create();
            uri = UriBuilder.fromUri("https://apex.oracle.com/pls/apex/valentin_workspace").build();
            service = c.resource(uri);
            gson = new Gson();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
