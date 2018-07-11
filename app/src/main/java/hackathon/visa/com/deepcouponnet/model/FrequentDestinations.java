package hackathon.visa.com.deepcouponnet.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "FrequentDestinations"
})
public class FrequentDestinations {

    @JsonProperty("FrequentDestinations")
    private List<FrequentDestination> frequentDestinations = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("FrequentDestinations")
    public List<FrequentDestination> getFrequentDestinations() {
        return frequentDestinations;
    }

    @JsonProperty("FrequentDestinations")
    public void setFrequentDestinations(List<FrequentDestination> frequentDestinations) {
        this.frequentDestinations = frequentDestinations;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {

        String result = "";
        String dealsNearbyStr = "";

        for(FrequentDestination frequentDestination : getFrequentDestinations()) {

            if(frequentDestination != null) {
                for (DealsNearby dealsNearby : frequentDestination.getDealsNearby()) {
                    dealsNearbyStr += "\nDeal - " + dealsNearby.getDeal() +
                            "\nVendor - " + dealsNearby.getVendor() +
                            "\nDistance - " + dealsNearby.getDist() +
                            "\nCategory - " + dealsNearby.getCategory();
                }
                result += "\n" + frequentDestination.getName() + " - " + dealsNearbyStr + "\n------------\n";
            }
        }
        return result;
    }

}