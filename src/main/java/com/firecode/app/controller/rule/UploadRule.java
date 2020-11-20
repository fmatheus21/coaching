package com.firecode.app.controller.rule;

import com.firecode.app.controller.util.AppUtil;
import com.firecode.app.controller.util.FormatLocalDatetUtil;
import com.firecode.app.controller.util.PathUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import net.coobird.thumbnailator.Thumbnails;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadRule {

    public String saveFileSingle(PathUtil pathUtil, MultipartFile multipartFile, String path, int number, int width,
            int height, boolean update) throws NoSuchElementException {
        String uploadDirectory = pathUtil.localPath() + pathUtil.getPathStatic() + path;
        long name = FormatLocalDatetUtil.returnsMillisecondsOfDateTime();
        String fileName = String.valueOf(name);
        AppUtil.createDirectoy(uploadDirectory);

        File file = fileRename(uploadDirectory, fileName + number, false, pathUtil.getExtensionImage());

        fileName = fileName + number;
        this.dataSaver(multipartFile, file, width, height);
        return fileName + pathUtil.getExtensionImage();

    }

    private File fileRename(String dir, String name, boolean update, String extension) {
        File convertedFile = null;
        if (update == true) { // Se for uma atualizacao
            convertedFile = new File(dir + name);
        } else if (update == false) { // Se nao for uma atualizacao
            convertedFile = new File(dir + name + extension);
        }
        AppUtil.deleteFile(convertedFile);
        return convertedFile;
    }

    private void dataSaver(MultipartFile multipartFile, File file, int width, int height) {

        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
        }
        if (fileOutputStream != null) {
            try {
                fileOutputStream.write(multipartFile.getBytes());
                this.generate(file, file, width, height);
            } catch (IOException e) {
            }
        }
        try {
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        } catch (IOException e) {
        }

    }

    private void generate(File origin, File dest, int width, int height) throws IOException {
        Thumbnails.of(origin).size(width, height).outputFormat("png").toFile(dest);
    }

}
