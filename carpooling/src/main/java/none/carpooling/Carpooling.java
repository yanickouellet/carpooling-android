/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2015-05-05 20:00:12 UTC)
 * on 2015-05-17 at 20:17:59 UTC 
 * Modify at your own risk.
 */

package none.carpooling;

/**
 * Service definition for Carpooling (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link none.carpooling.CarpoolingRequestInitializer} to initialize global parameters via its
 * {@link none.carpooling.Carpooling.Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Carpooling extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.20.0 of the carpooling library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://polar-office-91214.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "carpooling/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link none.carpooling.Carpooling.Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Carpooling(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Carpooling(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * An accessor for creating requests from the Match collection.
   *
   * <p>The typical use is:</p>
   * <pre>
   *   {@code Carpooling carpooling = new Carpooling(...);}
   *   {@code Carpooling.Match.List request = carpooling.match().list(parameters ...)}
   * </pre>
   *
   * @return the resource collection
   */
  public Match match() {
    return new Match();
  }

  /**
   * The "match" collection of methods.
   */
  public class Match {

    /**
     * Create a request for the method "match.list".
     *
     * This request holds the parameters needed by the carpooling server.  After setting any optional
     * parameters, call the {@link none.carpooling.Carpooling.Match.List#execute()} method to invoke the remote operation.
     *
     * @return the request
     */
    public List list() throws java.io.IOException {
      List result = new List();
      initialize(result);
      return result;
    }

    public class List extends CarpoolingRequest<none.carpooling.model.MatchCollection> {

      private static final String REST_PATH = "matches";

      /**
       * Create a request for the method "match.list".
       *
       * This request holds the parameters needed by the the carpooling server.  After setting any
       * optional parameters, call the {@link none.carpooling.Carpooling.Match.List#execute()} method to invoke the remote operation. <p>
       * {@link none.carpooling.Carpooling.Match.List#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @since 1.13
       */
      protected List() {
        super(Carpooling.this, "GET", REST_PATH, null, none.carpooling.model.MatchCollection.class);
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public List setAlt(String alt) {
        return (List) super.setAlt(alt);
      }

      @Override
      public List setFields(String fields) {
        return (List) super.setFields(fields);
      }

      @Override
      public List setKey(String key) {
        return (List) super.setKey(key);
      }

      @Override
      public List setOauthToken(String oauthToken) {
        return (List) super.setOauthToken(oauthToken);
      }

      @Override
      public List setPrettyPrint(Boolean prettyPrint) {
        return (List) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public List setQuotaUser(String quotaUser) {
        return (List) super.setQuotaUser(quotaUser);
      }

      @Override
      public List setUserIp(String userIp) {
        return (List) super.setUserIp(userIp);
      }

      @Override
      public List set(String parameterName, Object value) {
        return (List) super.set(parameterName, value);
      }
    }

  }

  /**
   * An accessor for creating requests from the Runoffer collection.
   *
   * <p>The typical use is:</p>
   * <pre>
   *   {@code Carpooling carpooling = new Carpooling(...);}
   *   {@code Carpooling.Runoffer.List request = carpooling.runoffer().list(parameters ...)}
   * </pre>
   *
   * @return the resource collection
   */
  public Runoffer runoffer() {
    return new Runoffer();
  }

  /**
   * The "runoffer" collection of methods.
   */
  public class Runoffer {

    /**
     * Create a request for the method "runoffer.insert".
     *
     * This request holds the parameters needed by the carpooling server.  After setting any optional
     * parameters, call the {@link none.carpooling.Carpooling.Runoffer.Insert#execute()} method to invoke the remote operation.
     *
     * @param content the {@link none.carpooling.model.RunOffer}
     * @return the request
     */
    public Insert insert(none.carpooling.model.RunOffer content) throws java.io.IOException {
      Insert result = new Insert(content);
      initialize(result);
      return result;
    }

    public class Insert extends CarpoolingRequest<none.carpooling.model.RunOffer> {

      private static final String REST_PATH = "offers";

      /**
       * Create a request for the method "runoffer.insert".
       *
       * This request holds the parameters needed by the the carpooling server.  After setting any
       * optional parameters, call the {@link none.carpooling.Carpooling.Runoffer.Insert#execute()} method to invoke the remote operation.
       * <p> {@link
       * none.carpooling.Carpooling.Runoffer.Insert#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
       * be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param content the {@link none.carpooling.model.RunOffer}
       * @since 1.13
       */
      protected Insert(none.carpooling.model.RunOffer content) {
        super(Carpooling.this, "POST", REST_PATH, content, none.carpooling.model.RunOffer.class);
      }

      @Override
      public Insert setAlt(String alt) {
        return (Insert) super.setAlt(alt);
      }

      @Override
      public Insert setFields(String fields) {
        return (Insert) super.setFields(fields);
      }

      @Override
      public Insert setKey(String key) {
        return (Insert) super.setKey(key);
      }

      @Override
      public Insert setOauthToken(String oauthToken) {
        return (Insert) super.setOauthToken(oauthToken);
      }

      @Override
      public Insert setPrettyPrint(Boolean prettyPrint) {
        return (Insert) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public Insert setQuotaUser(String quotaUser) {
        return (Insert) super.setQuotaUser(quotaUser);
      }

      @Override
      public Insert setUserIp(String userIp) {
        return (Insert) super.setUserIp(userIp);
      }

      @Override
      public Insert set(String parameterName, Object value) {
        return (Insert) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "runoffer.list".
     *
     * This request holds the parameters needed by the carpooling server.  After setting any optional
     * parameters, call the {@link none.carpooling.Carpooling.Runoffer.List#execute()} method to invoke the remote operation.
     *
     * @return the request
     */
    public List list() throws java.io.IOException {
      List result = new List();
      initialize(result);
      return result;
    }

    public class List extends CarpoolingRequest<none.carpooling.model.RunOfferCollection> {

      private static final String REST_PATH = "offer";

      /**
       * Create a request for the method "runoffer.list".
       *
       * This request holds the parameters needed by the the carpooling server.  After setting any
       * optional parameters, call the {@link none.carpooling.Carpooling.Runoffer.List#execute()} method to invoke the remote operation. <p>
       * {@link none.carpooling.Carpooling.Runoffer.List#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @since 1.13
       */
      protected List() {
        super(Carpooling.this, "GET", REST_PATH, null, none.carpooling.model.RunOfferCollection.class);
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public List setAlt(String alt) {
        return (List) super.setAlt(alt);
      }

      @Override
      public List setFields(String fields) {
        return (List) super.setFields(fields);
      }

      @Override
      public List setKey(String key) {
        return (List) super.setKey(key);
      }

      @Override
      public List setOauthToken(String oauthToken) {
        return (List) super.setOauthToken(oauthToken);
      }

      @Override
      public List setPrettyPrint(Boolean prettyPrint) {
        return (List) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public List setQuotaUser(String quotaUser) {
        return (List) super.setQuotaUser(quotaUser);
      }

      @Override
      public List setUserIp(String userIp) {
        return (List) super.setUserIp(userIp);
      }

      @Override
      public List set(String parameterName, Object value) {
        return (List) super.set(parameterName, value);
      }
    }

  }

  /**
   * An accessor for creating requests from the Runrequest collection.
   *
   * <p>The typical use is:</p>
   * <pre>
   *   {@code Carpooling carpooling = new Carpooling(...);}
   *   {@code Carpooling.Runrequest.List request = carpooling.runrequest().list(parameters ...)}
   * </pre>
   *
   * @return the resource collection
   */
  public Runrequest runrequest() {
    return new Runrequest();
  }

  /**
   * The "runrequest" collection of methods.
   */
  public class Runrequest {

    /**
     * Create a request for the method "runrequest.insert".
     *
     * This request holds the parameters needed by the carpooling server.  After setting any optional
     * parameters, call the {@link none.carpooling.Carpooling.Runrequest.Insert#execute()} method to invoke the remote operation.
     *
     * @param content the {@link none.carpooling.model.RunRequest}
     * @return the request
     */
    public Insert insert(none.carpooling.model.RunRequest content) throws java.io.IOException {
      Insert result = new Insert(content);
      initialize(result);
      return result;
    }

    public class Insert extends CarpoolingRequest<none.carpooling.model.RunRequest> {

      private static final String REST_PATH = "request";

      /**
       * Create a request for the method "runrequest.insert".
       *
       * This request holds the parameters needed by the the carpooling server.  After setting any
       * optional parameters, call the {@link none.carpooling.Carpooling.Runrequest.Insert#execute()} method to invoke the remote operation.
       * <p> {@link
       * none.carpooling.Carpooling.Runrequest.Insert#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)} must
       * be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @param content the {@link none.carpooling.model.RunRequest}
       * @since 1.13
       */
      protected Insert(none.carpooling.model.RunRequest content) {
        super(Carpooling.this, "POST", REST_PATH, content, none.carpooling.model.RunRequest.class);
      }

      @Override
      public Insert setAlt(String alt) {
        return (Insert) super.setAlt(alt);
      }

      @Override
      public Insert setFields(String fields) {
        return (Insert) super.setFields(fields);
      }

      @Override
      public Insert setKey(String key) {
        return (Insert) super.setKey(key);
      }

      @Override
      public Insert setOauthToken(String oauthToken) {
        return (Insert) super.setOauthToken(oauthToken);
      }

      @Override
      public Insert setPrettyPrint(Boolean prettyPrint) {
        return (Insert) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public Insert setQuotaUser(String quotaUser) {
        return (Insert) super.setQuotaUser(quotaUser);
      }

      @Override
      public Insert setUserIp(String userIp) {
        return (Insert) super.setUserIp(userIp);
      }

      @Override
      public Insert set(String parameterName, Object value) {
        return (Insert) super.set(parameterName, value);
      }
    }
    /**
     * Create a request for the method "runrequest.list".
     *
     * This request holds the parameters needed by the carpooling server.  After setting any optional
     * parameters, call the {@link none.carpooling.Carpooling.Runrequest.List#execute()} method to invoke the remote operation.
     *
     * @return the request
     */
    public List list() throws java.io.IOException {
      List result = new List();
      initialize(result);
      return result;
    }

    public class List extends CarpoolingRequest<none.carpooling.model.RunRequestCollection> {

      private static final String REST_PATH = "requests";

      /**
       * Create a request for the method "runrequest.list".
       *
       * This request holds the parameters needed by the the carpooling server.  After setting any
       * optional parameters, call the {@link none.carpooling.Carpooling.Runrequest.List#execute()} method to invoke the remote operation. <p>
       * {@link none.carpooling.Carpooling.Runrequest.List#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
       * must be called to initialize this instance immediately after invoking the constructor. </p>
       *
       * @since 1.13
       */
      protected List() {
        super(Carpooling.this, "GET", REST_PATH, null, none.carpooling.model.RunRequestCollection.class);
      }

      @Override
      public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
        return super.executeUsingHead();
      }

      @Override
      public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
        return super.buildHttpRequestUsingHead();
      }

      @Override
      public List setAlt(String alt) {
        return (List) super.setAlt(alt);
      }

      @Override
      public List setFields(String fields) {
        return (List) super.setFields(fields);
      }

      @Override
      public List setKey(String key) {
        return (List) super.setKey(key);
      }

      @Override
      public List setOauthToken(String oauthToken) {
        return (List) super.setOauthToken(oauthToken);
      }

      @Override
      public List setPrettyPrint(Boolean prettyPrint) {
        return (List) super.setPrettyPrint(prettyPrint);
      }

      @Override
      public List setQuotaUser(String quotaUser) {
        return (List) super.setQuotaUser(quotaUser);
      }

      @Override
      public List setUserIp(String userIp) {
        return (List) super.setUserIp(userIp);
      }

      @Override
      public List set(String parameterName, Object value) {
        return (List) super.set(parameterName, value);
      }
    }

  }

  /**
   * Builder for {@link none.carpooling.Carpooling}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link none.carpooling.Carpooling}. */
    @Override
    public Carpooling build() {
      return new Carpooling(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link none.carpooling.CarpoolingRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setCarpoolingRequestInitializer(
        CarpoolingRequestInitializer carpoolingRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(carpoolingRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
