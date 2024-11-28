package ru.itmo.wp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ru.itmo.wp.domain.Notice;
import ru.itmo.wp.repository.NoticeRepository;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public void addNotice(Notice notice) {
        noticeRepository.save(notice);
    }

    public Notice findById(Long id) {
        return id == null ? null : noticeRepository.findById(id).orElse(null);
    }

    public List<Notice> findAll() {
        return noticeRepository.findAllByOrderByCreationTime();
    }
}
