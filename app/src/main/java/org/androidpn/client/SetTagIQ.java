package org.androidpn.client;

import org.jivesoftware.smack.packet.IQ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huweiqiang on 16-11-30.
 */

public class SetTagIQ extends IQ {
    private String username;
    private List<String> tags = new ArrayList<>();

    @Override
    public String getChildElementXML() {
        StringBuilder buf = new StringBuilder();
        buf.append("<").
                append("settags").
                append(" xmlns=\"").
                append("androidpn:iq:settags").
                append("\">");
        if (username != null) {
            buf.append("<username>").append(username).append("</username>");
        }

        if (!tags.isEmpty()) {
            buf.append("<tags>");
            boolean needSeparate = false;
            for (String tag : tags) {
                if (needSeparate) {
                    buf.append(",");
                }
                buf.append(tag);
                needSeparate = true;
            }

            buf.append("</tags>");
        }
        buf.append("</").append("settags").append("> ");
        return buf.toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
