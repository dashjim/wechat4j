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

    protected File file = null;
    private JSONObject jsonObject = null;
    private JSONArray jsonArray = null;

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

    /**
     * Returns the response body as file.<br>
     * Disconnects the internal HttpURLConnection silently.
     *
     * @return void
     * @throws java.io.IOException
     */
    public File asFile(File file) throws IOException {
        if (streamConsumed){
            throw new IllegalStateException("File has already been consumed.");
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                throw new IOException("File '" + file + "' exists but is a directory");
            }
            if (file.canWrite() == false) {
                throw new IOException("File '" + file + "' cannot be written to");
            }
        } else {
            File parent = file.getParentFile();
            if (parent != null) {
                if (!parent.mkdirs() && !parent.isDirectory()) {
                    throw new IOException("Directory '" + parent + "' could not be created");
                }
            }
        }
        this.file = file;

        OutputStream output = null;
        try {
            output = new FileOutputStream(this.file);

            int n = 0;
            byte[] buffer = new byte[1024<<2];
            while ((n=is.read(buffer)) != -1) {
                output.write(buffer, 0, n);
            }
            streamConsumed = true;
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException ioe) {
                // ignore
            }
            disconnect();
            return this.file;
        }
    }

    /**
     * Returns the response body as string.<br>
     * Disconnects the internal HttpURLConnection silently.
     *
     * @return void
     * @throws java.io.IOException
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

    /**
     * Returns the response body as reader.<br>
     * Disconnects the internal HttpURLConnection silently.
     *
     * @return java.io.Reader
     * @throws java.io.IOException
     */
    public Reader asReader() throws IOException{
        return new BufferedReader(new InputStreamReader(is, "utf-8"));
    }

    /**
     * Returns the response body as JSONObject.<br>
     * Disconnects the internal HttpURLConnection silently.
     *
     * @return com.wisedu.wechat4jv2.internal.json.JSONObject
     * @throws java.io.IOException
     */
    public JSONObject asJSONObject() throws IOException {
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

    /**
     * Returns the response body as JSONArray.<br>
     * Disconnects the internal HttpURLConnection silently.
     *
     * @return com.wisedu.wechat4jv2.internal.json.JSONArray
     * @throws java.io.IOException
     */
    public JSONArray asJSONArray() throws IOException{
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
