package io.projects.URLShortnerAPI.dao;

public class URLShortnerRequest {
    private String url;

    public URLShortnerRequest() {
    }

    public URLShortnerRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "URLShortnerRequest{" +
                "url='" + url + '\'' +
                '}';
    }
}
