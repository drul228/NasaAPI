package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NasaInfo {
    @JsonProperty("copyright") String copyright;
    @JsonProperty("date") String date;
    @JsonProperty("explanation") String explanation;
    @JsonProperty("hdurl") String hdurl;
    @JsonProperty("media_type") String mediaType;
    @JsonProperty("service_version") String serviceVersion;
    @JsonProperty("title") String title;
    @JsonProperty("url") String url;

    @Override
    public String toString() {
        return "NasaInfo{" +
                "copyright='" + copyright + '\'' +
                ", date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", hdurl='" + hdurl + '\'' +
                ", media_type='" + mediaType + '\'' +
                ", service_version='" + serviceVersion + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setHdurl(String hdurl) {
        this.hdurl = hdurl;
    }

    public void setMedia_type(String media_type) {
        this.mediaType = media_type;
    }

    public void setService_version(String service_version) {
        this.serviceVersion = service_version;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
