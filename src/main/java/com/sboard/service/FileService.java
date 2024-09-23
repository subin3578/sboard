package com.sboard.service;

import com.sboard.dto.ArticleDTO;
import com.sboard.dto.FileDTO;
import com.sboard.repository.FileRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Log4j2
@RequiredArgsConstructor
@Service
public class FileService {

    private final FileRepository fileRepository;

    @Value("${spring.servlet.multipart.location}")
    private String uploadPath;

    public void uploadFile(ArticleDTO articleDTO) {

        // 파일 업로드 시스템 경로 구하기
        String path = new File(uploadPath).getAbsolutePath();

        // 파일 정보 객체 가져오기
        List<MultipartFile> files = articleDTO.getFiles();

        for(MultipartFile file : files) {

            if(!file.isEmpty()){
                String oName = file.getOriginalFilename();
                String ext = oName.substring(oName.lastIndexOf("."));
                String sName = UUID.randomUUID().toString() + ext;

                // 파일 저장
                try {
                    file.transferTo(new File(path, sName));
                } catch (IOException e) {
                    log.error(e);
                }
            }
        }
    }

    public void downloadFile(){

    }

    public void insertFile(FileDTO fileDTO) {

    }
    public FileDTO selectFile(int fno){
        return null;
    }
    public List<FileDTO> selectFileAll(){
        return null;
    }
    public void updateFile(FileDTO fileDTO){}
    public void deleteFile(int fno){}

}
