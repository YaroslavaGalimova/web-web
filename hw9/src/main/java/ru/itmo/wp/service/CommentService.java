package ru.itmo.wp.service;

import org.springframework.stereotype.Service;

import ru.itmo.wp.domain.Comment;
import ru.itmo.wp.repository.CommentRepository;

@Service
public class CommentService {

    private final CommentRepository commentRepository;
    
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public Comment findById(Long id) {
        return id == null ? null : commentRepository.findById(id).orElse(null);
    }
}
