/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.controller.Video;

import br.com.crescer.entity.Video;
import br.com.crescer.service.Video.VideoServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jpedr
 */
@RestController
@RequestMapping("/video")
public class VideoControllerImpl implements VideoController{
    @Autowired
    VideoServiceImpl videoService;
    Video video;
    
    @Override
    @PostMapping(value = "/save")
    public Video save(@RequestBody Video video) {
        return videoService.save(video);
    }

    @Override
    @PutMapping(value = "/delete")
    public void delete(@RequestBody Video video) {
        videoService.delete(video);
    }

    @Override
    @GetMapping(value = "/findOne/{id}")
    public Video findOne(@PathVariable Long id) {
        return videoService.findOne(id);
    }

    @Override
    @GetMapping(value = "/findAll")
    public List<Video> findAll() {
        return videoService.findAll();
    }

    @Override
    @GetMapping(value = "/findPage/{page}/{size}")
    public Page<Video> findPage(@PathVariable int page, @PathVariable int size) {
        return videoService.findPage(page,size);
    }
}
