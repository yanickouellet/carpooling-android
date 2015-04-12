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
 * (build: 2015-03-26 20:30:19 UTC)
 * on 2015-04-12 at 21:29:11 UTC 
 * Modify at your own risk.
 */

package none.carpooling.model;

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
public final class RunRequest extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String date;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long dayOfWeek;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String fromAddress;

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
  private java.lang.Long hour;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean matched;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key @com.google.api.client.json.JsonString
  private java.lang.Long minute;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.Boolean ponctual;

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String toAddress;

  /**
   * ProtoRPC container for GeoPt instances. Attributes: lat: Float; The latitude of the point. lon:
   * Float; The longitude of the point.
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private GeoPtMessage toCoord;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getDate() {
    return date;
  }

  /**
   * @param date date or {@code null} for none
   */
  public RunRequest setDate(java.lang.String date) {
    this.date = date;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getDayOfWeek() {
    return dayOfWeek;
  }

  /**
   * @param dayOfWeek dayOfWeek or {@code null} for none
   */
  public RunRequest setDayOfWeek(java.lang.Long dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getFromAddress() {
    return fromAddress;
  }

  /**
   * @param fromAddress fromAddress or {@code null} for none
   */
  public RunRequest setFromAddress(java.lang.String fromAddress) {
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
  public java.lang.Long getHour() {
    return hour;
  }

  /**
   * @param hour hour or {@code null} for none
   */
  public RunRequest setHour(java.lang.Long hour) {
    this.hour = hour;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getMatched() {
    return matched;
  }

  /**
   * @param matched matched or {@code null} for none
   */
  public RunRequest setMatched(java.lang.Boolean matched) {
    this.matched = matched;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Long getMinute() {
    return minute;
  }

  /**
   * @param minute minute or {@code null} for none
   */
  public RunRequest setMinute(java.lang.Long minute) {
    this.minute = minute;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.Boolean getPonctual() {
    return ponctual;
  }

  /**
   * @param ponctual ponctual or {@code null} for none
   */
  public RunRequest setPonctual(java.lang.Boolean ponctual) {
    this.ponctual = ponctual;
    return this;
  }

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getToAddress() {
    return toAddress;
  }

  /**
   * @param toAddress toAddress or {@code null} for none
   */
  public RunRequest setToAddress(java.lang.String toAddress) {
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

  @Override
  public RunRequest set(String fieldName, Object value) {
    return (RunRequest) super.set(fieldName, value);
  }

  @Override
  public RunRequest clone() {
    return (RunRequest) super.clone();
  }

}
