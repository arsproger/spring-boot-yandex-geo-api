package com.arsen.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocoderResponse {

    @JsonProperty("response")
    private Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Response {

        @JsonProperty("GeoObjectCollection")
        private GeoObjectCollection geoObjectCollection;

        public GeoObjectCollection getGeoObjectCollection() {
            return geoObjectCollection;
        }

        public void setGeoObjectCollection(GeoObjectCollection geoObjectCollection) {
            this.geoObjectCollection = geoObjectCollection;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GeoObjectCollection {

        @JsonProperty("featureMember")
        private FeatureMember[] featureMembers;

        public FeatureMember[] getFeatureMembers() {
            return featureMembers;
        }

        public void setFeatureMembers(FeatureMember[] featureMembers) {
            this.featureMembers = featureMembers;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class FeatureMember {

        @JsonProperty("GeoObject")
        private GeoObject geoObject;

        public GeoObject getGeoObject() {
            return geoObject;
        }

        public void setGeoObject(GeoObject geoObject) {
            this.geoObject = geoObject;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GeoObject {

        @JsonProperty("metaDataProperty")
        private MetaDataProperty metaDataProperty;

        @JsonProperty("Point")
        private Point point;

        public MetaDataProperty getMetaDataProperty() {
            return metaDataProperty;
        }

        public void setMetaDataProperty(MetaDataProperty metaDataProperty) {
            this.metaDataProperty = metaDataProperty;
        }

        public Point getPoint() {
            return point;
        }

        public void setPoint(Point point) {
            this.point = point;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class MetaDataProperty {

        @JsonProperty("GeocoderMetaData")
        private GeocoderMetaData geocoderMetaData;

        public GeocoderMetaData getGeocoderMetaData() {
            return geocoderMetaData;
        }

        public void setGeocoderMetaData(GeocoderMetaData geocoderMetaData) {
            this.geocoderMetaData = geocoderMetaData;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GeocoderMetaData {

        @JsonProperty("text")
        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Point {

        @JsonProperty("pos")
        private String pos;

        public String getPos() {
            return pos;
        }

        public void setPos(String pos) {
            this.pos = pos;
        }
    }
}
