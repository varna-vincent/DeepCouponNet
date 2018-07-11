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
        "Vendor",
        "Dist",
        "Category"
})
public class DealsNearby {

    @JsonProperty("Deal")
    private String deal;
    @JsonProperty("Vendor")
    private String vendor;
    @JsonProperty("Dist")
    private Integer dist;
    @JsonProperty("Category")
    private String category;
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

    @JsonProperty("Vendor")
    public String getVendor() {
        return vendor;
    }

    @JsonProperty("Vendor")
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @JsonProperty("Dist")
    public Integer getDist() {
        return dist;
    }

    @JsonProperty("Dist")
    public void setDist(Integer dist) {
        this.dist = dist;
    }

    @JsonProperty("Category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("Category")
    public void setCategory(String category) {
        this.category = category;
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