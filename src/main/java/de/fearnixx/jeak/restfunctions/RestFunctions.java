package de.fearnixx.jeak.restfunctions;

import de.fearnixx.jeak.event.bot.IBotStateEvent;
import de.fearnixx.jeak.reflect.IInjectionService;
import de.fearnixx.jeak.reflect.Inject;
import de.fearnixx.jeak.reflect.JeakBotPlugin;
import de.fearnixx.jeak.reflect.Listener;
import de.fearnixx.jeak.restfunctions.controllers.ChannelController;
import de.fearnixx.jeak.restfunctions.controllers.ClientController;
import de.fearnixx.jeak.service.controller.IRestControllerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@JeakBotPlugin(id = "frw.restfunctions", builtAgainst = "1.1.0")
public class RestFunctions {

    private static final Logger logger = LoggerFactory.getLogger(RestFunctions.class);

    @Inject
    private IRestControllerService restService;

    @Inject
    private IInjectionService injectionService;

    @Listener
    public void onInitialize(IBotStateEvent.IInitializeEvent event) {
        logger.info("Plugin active. Registering controllers.");
        restService.registerController(ChannelController.class, injectionService.injectInto(new ChannelController()));
        restService.registerController(ClientController.class, injectionService.injectInto(new ClientController()));
    }
}


