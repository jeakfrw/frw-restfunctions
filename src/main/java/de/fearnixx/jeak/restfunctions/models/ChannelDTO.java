package de.fearnixx.jeak.restfunctions.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChannelDTO {

    @JsonProperty
    public int channel_id;

    @JsonProperty
    public boolean is_default;

    @JsonProperty
    public String channel_name;

    @JsonProperty
    public String channel_topic;

    @JsonProperty
    public String channel_name_normalized;

    @JsonProperty
    public boolean is_spacer;

    @JsonProperty
    public boolean is_spacer_centered;

    @JsonProperty
    public boolean is_spacer_repetitive;

    @JsonProperty
    public int client_count;

    @JsonProperty
    public int max_clients;

    @JsonProperty
    public int max_family_clients;
}
