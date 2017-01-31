package org.funjala.automation.web.common.api;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.Properties;

import io.restassured.response.Response;
import org.funjala.automation.web.common.objectReader.ReadObject;


/**
 * Created by RoyRodriguez on 12/23/2016.
 */
public class RestAssured {
  private Properties configurationObj;
  private String url;
  private String token;
  private String keyToken;
  private String proxyAddress;
  private int proxyPort;

  public RestAssured() throws IOException {
    ReadObject object = new ReadObject();
    configurationObj = object.getObjectRepository();

    url = configurationObj.getProperty("urlApi");
    token = configurationObj.getProperty("token");
    keyToken = configurationObj.getProperty("keyToken");
    proxyAddress = configurationObj.getProperty("proxy");
    proxyPort = Integer.parseInt(configurationObj.getProperty("port"));

  }

  public Response get(String endPoint) {
    String finalUrl = url + "/" + endPoint;
    Response response = given().proxy(proxyAddress, proxyPort).header(keyToken, token).get(finalUrl);
    return response;
  }

  public Response delete(String endPoint) {
    String finalUrl = url + "/" + endPoint;
    Response response = given().proxy(proxyAddress, proxyPort).header(keyToken, token).delete(finalUrl);
    return response;
  }

}