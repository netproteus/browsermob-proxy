package net.lightbody.bmp.proxy.http;

import static com.google.common.collect.Lists.newLinkedList;

import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpRequest;

import net.lightbody.bmp.core.har.HarCookie;
import net.lightbody.bmp.core.har.HarNameValuePair;

/**
 * A very basic cookie parser
 * @author dgomez
 *
 */
public class CookieHeadersParser {
    public List<HarCookie> getCookies(HttpRequest request) {
        List<HarCookie> cookies = newLinkedList();
        for(Header hdr : request.getHeaders("Cookie")) {
            String[] pairs = hdr.getValue().split("; ");
            for (String p : pairs) {
                CookieValue pair = nameValuePair(p);
                HarCookie cookie = new HarCookie();
                cookie.setName(pair.getName());
                cookie.setValue(pair.getValue());
                cookies.add(cookie);
            }
        }
        return cookies;
    }

    private CookieValue nameValuePair(String data) {
        int eqIdx = data.indexOf("=");
        if (eqIdx > 0) {
            String name = data.substring(0, eqIdx);
            String val = data.substring(eqIdx + 1);
            return new CookieValue(name, val);
        }
        else return new CookieValue(data, "");
    }
    
    static class CookieValue extends HarNameValuePair {

        public CookieValue(String name, String value) {
            super(name, value);
        }
        
    }
}