package gg.codie.mineonline.protocol;

import sun.net.www.protocol.http.HttpURLConnection;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

public class MineOnlineURLStreamHandler extends URLStreamHandler {
    @Override
    protected URLConnection openConnection(URL url) throws IOException {
        // Online-Mode fix
        if (url.toString().contains("/game/checkserver.jsp"))
            return new CheckServerURLConnection(url);
        else
            return new HttpURLConnection(url, null);
    }
}
