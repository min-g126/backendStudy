package com.ohgiraffers.fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {

    @Autowired
    private ResourceLoader resourceLoader;

    @PostMapping("single-file")
    public String singleFileUpload(@RequestParam MultipartFile singleFile
            , @RequestParam String singleFileDescription
            , Model model) throws IOException {

        System.out.println("[singleFile] " + singleFile);
        System.out.println("[singleFileDescription] " + singleFileDescription);

        /* 파일 경로 지정 */
        Resource resource = resourceLoader.getResource("classpath:static/img/single");
        String filePath = null;

        if (!resource.exists()) {
            String root = "src/main/resources/static/img/single";
            File file = new File(root);
            file.mkdirs();

            filePath = file.getAbsolutePath();

        } else {
            filePath = resource.getFile().getAbsolutePath();
        }

        /* 파일 변경 처리 */
        String originFileName = singleFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedFileName = UUID.randomUUID().toString().replace("-", "")
                + ext;

        /* 파일 저장*/
        try {
            singleFile.transferTo(new File(filePath + "/" + savedFileName));
            model.addAttribute("message", "파일 업로드 성공!");
            model.addAttribute("img", "static/img/single/" + savedFileName);

        } catch (Exception e) {
            model.addAttribute("message", "파일 업로드 실패!");
        }

        return "result";
    }


    @PostMapping("multi-file")
    public String multiFileUpload(@RequestParam List<MultipartFile> multiFiles
                                  , @RequestParam String multiFilesDescription
                                  , Model model) throws IOException {

        /* 파일 저장 경로 지정 */
        Resource resource = resourceLoader.getResource("classpath:static/img/multi");
        String filePath = null;

        if (!resource.exists()) {
            String root = "src/main/resources/static/img/multi";
            File file = new File(root);
            file.mkdirs();

            filePath = file.getAbsolutePath();
        } else {
            filePath = resource.getFile().getAbsolutePath();
        }

        /* 파일에 관한 정보 저장을 위한 처리 */
        List<FileDTO> files = new ArrayList<>();

        List<String> saveFiles = new ArrayList<>();


        try {
            for(MultipartFile file  : multiFiles) {
                /* 파일명 변경 처리 */
                String originFileName = file.getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                String savedFileName = UUID.randomUUID().toString().replace("-", "")
                                        + ext;

                /* 파일 정보 등록 */
                files.add(new FileDTO(originFileName, savedFileName, filePath, multiFilesDescription));

                /* 파일 저장 */
                file.transferTo(new File(filePath + "/" + savedFileName));

                saveFiles.add("static/img/multi/" + savedFileName);
            }

            model.addAttribute("message", "파일 업로드 성공!");
            model.addAttribute("imgs", saveFiles);

        } catch (Exception e) {

            for (FileDTO file : files) {
                new File(filePath + "/" + file.getSavedFileName()).delete();
            }
            model.addAttribute("message", "파일 업로드 실패!");
        }


        return "result";
    }

}
