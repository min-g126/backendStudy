package com.ohgiraffers.fileupload;

public class FileDTO {

    private String originFileName;

    private String savedFileName;

    private String filePath;

    private String fileDescription;


    public FileDTO() {
    }

    public FileDTO(String originFileName, String savedFileName, String filePath, String fileDescription) {
        this.originFileName = originFileName;
        this.savedFileName = savedFileName;
        this.filePath = filePath;
        this.fileDescription = fileDescription;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public String getSavedFileName() {
        return savedFileName;
    }

    public void setSavedFileName(String savedFileName) {
        this.savedFileName = savedFileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileDescription() {
        return fileDescription;
    }

    public void setFileDescription(String fileDescription) {
        this.fileDescription = fileDescription;
    }

    @Override
    public String toString() {
        return "FileDTO{" +
                "originFileName='" + originFileName + '\'' +
                ", savedFileName='" + savedFileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                '}';
    }
}
