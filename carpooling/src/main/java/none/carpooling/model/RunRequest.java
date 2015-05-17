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
 * on 2015-05-17 at 14:15:56 UTC 
 * Modify at your own risk.
 */

package none.carpooling.model;

import java.io.Serializable;

/**
 * Model definition for RunRequest.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the carpooling. For a detailed explanation see:
 * <a href="http://code.google.com/p/google-http-java-client/wiki/JSON">http://code.google.com/p/google-http-java-client/wiki/JSON</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class RunRequest extends com.google.api.client.json.GenericJson implements Serializable {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String date;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private Long dayOfWeek;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String fromAddress;

  /**
   * ProtoRPC container for GeoPt instances. Attributes: lat: Float; The latitude of the point. lon:
   * Float; The longitude of the point.
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private GeoPtMessage fromCoord;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private Long hour;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Boolean matched;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private Long minute;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private Boolean ponctual;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private String toAddress;

  /**
   * ProtoRPC container for GeoPt instances. Attributes: lat: Float; The latitude of the point. lon:
   * Float; The longitude of the point.
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private GeoPtMessage toCoord;

  /**
   * ProtoRPC container for users.User objects. Attributes: email: String; The email of the user.
   * auth_domain: String; The auth domain of the user. user_id: String; The user ID.
   * federated_identity: String; The federated identity of the user.
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private UserMessage user;

  /**
   * @return value or {@code null} for none
   */
  public String getDate() {
    return date;
  }

  /**
   * @param date date or {@code null} for none
   */
  public RunRequest setDate(String date) {
    this.date = date;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Long getDayOfWeek() {
    return dayOfWeek;
  }

  /**
   * @param dayOfWeek dayOfWeek or {@code null} for none
   */
  public RunRequest setDayOfWeek(Long dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public String getFromAddress() {
    return fromAddress;
  }

  /**
   * @param fromAddress fromAddress or {@code null} for none
   */
  public RunRequest setFromAddress(String fromAddress) {
    this.fromAddress = fromAddress;
    return this;
  }

  /**
   * ProtoRPC container for GeoPt instances. Attributes: lat: Float; The latitude of the point. lon:
   * Float; The longitude of the point.
   * @return value or {@code null} for none
   */
  public GeoPtMessage getFromCoord() {
    return fromCoord;
  }

  /**
   * ProtoRPC container for GeoPt instances. Attributes: lat: Float; The latitude of the point. lon:
   * Float; The longitude of the point.
   * @param fromCoord fromCoord or {@code null} for none
   */
  public RunRequest setFromCoord(GeoPtMessage fromCoord) {
    this.fromCoord = fromCoord;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Long getHour() {
    return hour;
  }

  /**
   * @param hour hour or {@code null} for none
   */
  public RunRequest setHour(Long hour) {
    this.hour = hour;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Boolean getMatched() {
    return matched;
  }

  /**
   * @param matched matched or {@code null} for none
   */
  public RunRequest setMatched(Boolean matched) {
    this.matched = matched;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Long getMinute() {
    return minute;
  }

  /**
   * @param minute minute or {@code null} for none
   */
  public RunRequest setMinute(Long minute) {
    this.minute = minute;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public Boolean getPonctual() {
    return ponctual;
  }

  /**
   * @param ponctual ponctual or {@code null} for none
   */
  public RunRequest setPonctual(Boolean ponctual) {
    this.ponctual = ponctual;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public String getToAddress() {
    return toAddress;
  }

  /**
   * @param toAddress toAddress or {@code null} for none
   */
  public RunRequest setToAddress(String toAddress) {
    this.toAddress = toAddress;
    return this;
  }

  /**
   * ProtoRPC container for GeoPt instances. Attributes: lat: Float; The latitude of the point. lon:
   * Float; The longitude of the point.
   * @return value or {@code null} for none
   */
  public GeoPtMessage getToCoord() {
    return toCoord;
  }

  /**
   * ProtoRPC container for GeoPt instances. Attributes: lat: Float; The latitude of the point. lon:
   * Float; The longitude of the point.
   * @param toCoord toCoord or {@code null} for none
   */
  public RunRequest setToCoord(GeoPtMessage toCoord) {
    this.toCoord = toCoord;
    return this;
  }

  /**
   * ProtoRPC container for users.User objects. Attributes: email: String; The email of the user.
   * auth_domain: String; The auth domain of the user. user_id: String; The user ID.
   * federated_identity: String; The federated identity of the user.
   * @return value or {@code null} for none
   */
  public UserMessage getUser() {
    return user;
  }

  /**
   * ProtoRPC container for users.User objects. Attributes: email: String; The email of the user.
   * auth_domain: String; The auth domain of the user. user_id: String; The user ID.
   * federated_identity: String; The federated identity of the user.
   * @param user user or {@code null} for none
   */
  public RunRequest setUser(UserMessage user) {
    this.user = user;
    return this;
  }

  @Override
  public RunRequest set(String fieldName, Object value) {
    return (RunRequest) super.set(fieldName, value);
  }

  @Override
  public RunRequest clone() {
    return (RunRequest) super.clone();
  }

}
