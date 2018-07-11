package hackathon.visa.com.deepcouponnet.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Deal",
        "Category",
        "Dist",
        "AwayFrom",
        "Vendor"
})
public class DealsNearby {

    @JsonProperty("Deal")
    private String deal;
    @JsonProperty("Category")
    private String category;
    @JsonProperty("Dist")
    private Integer dist;
    @JsonProperty("AwayFrom")
    private String awayFrom;
    @JsonProperty("Vendor")
    private String vendor;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Deal")
    public String getDeal() {
        return deal;
    }

    @JsonProperty("Deal")
    public void setDeal(String deal) {
        this.deal = deal;
    }

    @JsonProperty("Category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("Category")
    public void setCategory(String category) {
        this.category = category;
    }

    @JsonProperty("Dist")
    public Integer getDist() {
        return dist;
    }

    @JsonProperty("Dist")
    public void setDist(Integer dist) {
        this.dist = dist;
    }

    @JsonProperty("AwayFrom")
    public String getAwayFrom() {
        return awayFrom;
    }

    @JsonProperty("AwayFrom")
    public void setAwayFrom(String awayFrom) {
        this.awayFrom = awayFrom;
    }

    @JsonProperty("Vendor")
    public String getVendor() {
        return vendor;
    }

    @JsonProperty("Vendor")
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}