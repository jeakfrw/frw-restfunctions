package de.fearnixx.jeak.restfunctions.controllers;

import de.fearnixx.jeak.reflect.Inject;
import de.fearnixx.jeak.reflect.RequestMapping;
import de.fearnixx.jeak.reflect.RestController;
import de.fearnixx.jeak.restfunctions.models.ChannelDTO;
import de.fearnixx.jeak.service.controller.RequestMethod;
import de.fearnixx.jeak.service.controller.ResponseEntity;
import de.fearnixx.jeak.teamspeak.cache.IDataCache;
import de.fearnixx.jeak.teamspeak.data.ISpacer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController(pluginId = "frw", endpoint = "/channels")
public class ChannelController {

    @Inject
    private IDataCache dataCache;

    @RequestMapping(method = RequestMethod.GET, endpoint = "/list", isSecured = false)
    public ResponseEntity<Map<String, List<ChannelDTO>>> epListChannels() {
        List<ChannelDTO> clients = dataCache.getChannels()
                .stream()
                .map(c -> {
                    final var dto = new ChannelDTO();
                    if (c.isSpacer()) {
                        dto.is_spacer = true;
                        dto.is_spacer_centered = ((ISpacer) c).isCentered();
                        dto.is_spacer_repetitive = ((ISpacer) c).isRepeated();
                        dto.channel_name_normalized = ((ISpacer) c).getStrippedName();
                    } else {
                        dto.channel_name_normalized = c.getName();
                    }
                    dto.channel_id = c.getID();
                    dto.is_default = c.isDefault();
                    dto.channel_name = c.getName();
                    dto.channel_topic = c.getTopic();
                    dto.client_count = c.getClientCount();
                    dto.max_clients = c.getMaxClientCount();
                    dto.max_family_clients = c.getMaxClientCountBelow();
                    return dto;
                }).collect(Collectors.toList());

        return new ResponseEntity<>(Map.of("channels", clients));
    }
}
