package de.fearnixx.jeak.restfunctions.controllers;

import de.fearnixx.jeak.reflect.Inject;
import de.fearnixx.jeak.reflect.RequestMapping;
import de.fearnixx.jeak.reflect.RestController;
import de.fearnixx.jeak.restfunctions.models.ClientDTO;
import de.fearnixx.jeak.service.controller.RequestMethod;
import de.fearnixx.jeak.service.controller.ResponseEntity;
import de.fearnixx.jeak.teamspeak.cache.IDataCache;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController(pluginId = "frw", endpoint = "/clients")
public class ClientController {

    @Inject
    private IDataCache dataCache;

    @RequestMapping(method = RequestMethod.GET, endpoint = "/list", isSecured = false)
    public ResponseEntity<Map<String, List<ClientDTO>>> epListClients() {
        List<ClientDTO> clients = dataCache.getClients()
                .stream()
                .map(c -> {
                    final var dto = new ClientDTO();
                    dto.client_unique_id = c.getClientUniqueID();
                    dto.client_nickname = c.getNickName();
                    dto.client_is_channel_commander = c.isCommander();
                    dto.client_is_priority_talker = c.isPrioTalker();
                    dto.channel_id = c.getChannelID();
                    dto.client_id = c.getClientID();
                    return dto;
                }).collect(Collectors.toList());

        return new ResponseEntity<>(Map.of("clients", clients));
    }
}
