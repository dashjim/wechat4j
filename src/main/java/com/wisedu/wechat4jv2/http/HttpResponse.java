package com.wisedu.wechat4jv2.http;

import com.wisedu.wechat4jv2.conf.ConfigurationContext;
import com.wisedu.wechat4jv2.conf.HttpClientConfiguration;
import com.wisedu.wechat4jv2.internal.json.JSONArray;
import com.wisedu.wechat4jv2.internal.json.JSONObject;
import com.wisedu.wechat4jv2.internal.json.JSONTokener;

import java.io.*;
import java.util.List;
import java.util.Map;

public abstract class HttpResponse {
    protected final HttpClientConfiguration conf;
    protected int statusCode;
    protected String responseAsString;
    protected InputStream is;
    private boolean streamConsumed = false;

    private JSONObject jsonObject;
    private JSONArray jsonArray;

    public HttpResponse(){
        this.conf = ConfigurationContext.getInstance();
    }

    public HttpResponse(HttpClientConfiguration conf){
        this.conf = conf;
    }

    public int getStatusCode(){
        return statusCode;
    }

    public abstract String getResponseHeader(String name);

    public abstract Map<String, List<String>> getResponseHeaderFields();

    /**
     * Returns the response stream.<br>
     * This method cannot be called after calling asString() or asDcoument()<br>
     * It is suggested to call disconnect() after consuming the stream.
     * <p/>
     * Disconnects the internal HttpURLConnection silently.
     *
     * @return response body stream
     * @see #disconnect()
     */
    public InputStream asStream(){
        if (streamConsumed){
            throw new IllegalStateException("Stream has already been consumed.");
        }
        return is;
    }

    public void asFile(File file) {
        if (streamConsumed){
            throw new IllegalStateException("File has already been consumed.");
        }
        disconnect();
    }

    /**
     * Returns the response body as string.<br>
     * Disconnects the internal HttpURLConnection silently.
     *
     * @return response body
     * @throws com.wisedu.wechat4j.WechatException
     */
    public String asString() throws IOException{
        if (responseAsString == null){
            BufferedReader reader = null;
            InputStream stream = null;
            try {
                stream = asStream();
                if (stream == null){
                    return null;
                }

                String line = null;
                StringBuffer sb = new StringBuffer();
                reader = new BufferedReader(new InputStreamReader(stream, "utf-8"));
                while ((line=reader.readLine()) != null){
                    sb.append(line + "\n");
                }
                responseAsString = sb.toString();
                streamConsumed = true;
            } catch (IOException ioe){
                throw new IOException("asString failed", ioe);
            } finally {
                if (stream != null){
                    try {
                        stream.close();
                    } catch (IOException ioe){
                    }
                }
                if (reader != null){
                    try {
                        reader.close();
                    } catch (IOException ioe){
                    }
                }
                disconnect();
            }
        }
        return responseAsString;
    }

    public Reader asReader(){
        try {
            return new BufferedReader(new InputStreamReader(is, "utf-8"));
        } catch (IOException ioe){
        }
        return null;
    }

    public JSONObject asJSONObject() {
        if (jsonObject == null){
            Reader reader = null;
            try {
                if (responseAsString == null){
                    reader = asReader();
                    jsonObject = new JSONObject(new JSONTokener(reader));
                } else {
                    jsonObject = new JSONObject(responseAsString);
                }
            }  finally {
                if (reader != null){
                    try {
                        reader.close();
                    } catch (IOException ioe){
                    }
                }
                disconnect();
            }
        }
        return jsonObject;
    }

    public JSONArray asJSONArray() {
        if (jsonArray == null){
            Reader reader = null;
            try {
                if (responseAsString == null) {
                    reader = asReader();
                    jsonArray = new JSONArray(new JSONTokener(reader));
                } else {
                    jsonArray = new JSONArray(responseAsString);
                }
            } finally {
                if (reader != null){
                    try {
                        reader.close();
                    } catch (IOException ioe){
                    }
                }
                disconnect();
            }
        }
        return jsonArray;
    }

    public abstract void disconnect();

    @Override public String toString(){
        return "HttpResponse"
                + "{"
                + "statusCode=" + statusCode + ","
                + "responseAsString=" + "\'" + responseAsString + "\',"
                + "is=" + is + ","
                + "streamConsumed=" + streamConsumed + ","
                + "}";
    }
}
