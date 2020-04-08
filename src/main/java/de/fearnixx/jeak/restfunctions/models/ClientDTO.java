package de.fearnixx.jeak.restfunctions.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientDTO {

    @JsonProperty
    public String client_unique_id;

    @JsonProperty
    public String client_nickname;

    @JsonProperty
    public int client_id;

    @JsonProperty
    public int channel_id;

    @JsonProperty
    public boolean client_is_priority_talker;

    @JsonProperty
    public boolean client_is_channel_commander;
}
