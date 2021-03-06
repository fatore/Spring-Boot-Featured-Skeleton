package com.example.webservice.domains.remoteconfig.controllers;

import com.example.webservice.domains.remoteconfig.models.entities.RemoteConfig;
import com.example.webservice.exceptions.notfound.NotFoundException;
import com.example.webservice.domains.remoteconfig.services.RemoteConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/remote-config")
public class RemoteConfigController {

    @Autowired
    private final RemoteConfigService remoteConfigService;

    public RemoteConfigController(RemoteConfigService remoteConfigService) {
        this.remoteConfigService = remoteConfigService;
    }

    @GetMapping
    public List<RemoteConfig> fetchAllClientConfig(){
        return remoteConfigService.fetchAllRemoteConfigs();
    }

    @GetMapping("{id}")
    public Optional<RemoteConfig> fetchClientConfig(@PathVariable Long id){
        return remoteConfigService.fetchRemoteConfig(id);
    }

    @PostMapping()
    public RemoteConfig createClientConfig(@Valid RemoteConfig remoteConfig) {
        return remoteConfigService.createRemoteConfig(remoteConfig);
    }

    @PutMapping("{id}")
    public RemoteConfig updateClientConfig(@PathVariable Long id, @Valid RemoteConfig remoteConfig) throws NotFoundException {
        return remoteConfigService.updateRemoteConfig(id, remoteConfig);
    }

    @DeleteMapping("{id}")
    public RemoteConfig deleteClientConfig(@PathVariable Long id) throws NotFoundException {
        return remoteConfigService.deleteRemoteConfig(id);
    }

}
