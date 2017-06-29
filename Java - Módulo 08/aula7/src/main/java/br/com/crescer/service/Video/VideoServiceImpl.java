/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.service.Video;

import br.com.crescer.entity.Video;
import br.com.crescer.repository.VideoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author jpedr
 */
@Service
public class VideoServiceImpl implements VideoService{
    @Autowired
    VideoRepository videoRepository;
    
    @Override
    public Video save(Video video) {
        return videoRepository.save(video);
    }

    @Override
    public void delete(Video video) {
        videoRepository.delete(video);
    }

    @Override
    public Video findOne(Long id) {
        return videoRepository.findOne(id);          
    }

    @Override
    public List<Video> findAll() {
        return (List<Video>) videoRepository.findAll();
    }

    @Override
    public Page<Video> findPage(int page, int size) {
        return videoRepository.findAll(new PageRequest(page, size));
    }
}
