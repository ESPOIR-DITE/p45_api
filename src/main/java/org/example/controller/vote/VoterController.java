package org.example.controller.vote;

import org.apache.commons.io.FileUtils;
import org.example.controller.Icontroller;
import org.example.domain.vote.Voter;
import org.example.factory.vote.VoterFactory;
import org.example.service.vote.VoterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("p45_api/voter/")
public class VoterController implements Icontroller<Voter,String> {

    private String fileName = Paths.get("").toAbsolutePath().toString()+"output.jpg";
    private File file_save_path = new File(fileName);

    private String fileName1 = Paths.get("").toAbsolutePath().toString()+"resized.jpg";
    private File file_read_path = new File(fileName1);

    @Autowired
    private VoterService voterService;

    @Override
    @PostMapping("create")
    public Voter create(@RequestBody Voter voter) throws IOException {
//        System.out.println("File Received: "+voter.getImage());
//        pictureWriter(voter.getImage());
//        ImageResizer.getResizedImage();
//        byte[] resised = convertToBytes();
        Voter voter1 = VoterFactory.getVoter(voter.getId(),voter.getName(),voter.getSurname(),voter.getPhoneNumber()/**,voter.getFingerPrint()**/,encodeIntoByteArray(voter.getImage()),voter.isCanVote());
        return voterService.create(voter1);
    }

    @PostMapping("update")
    @Override
    public Voter update(@RequestBody Voter voter) {
        return voterService.update(voter);
    }

    @GetMapping("read")
    @Override
    public Voter read(@RequestParam("id") String id) {
        return voterService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return voterService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<Voter> readAll() {
        return voterService.readAll();
    }

    @GetMapping("count")
    @Override
    public Long count() {
        return voterService.count();
    }

    public void pictureWriter(File file) throws IOException {
        byte[] bytes = FileUtils.readFileToByteArray(file);
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        BufferedImage bImage2 = ImageIO.read(bis);
        ImageIO.write(bImage2, "jpg", file_save_path);
        System.out.println("image created");
    }
    public byte[] convertToBytes() throws IOException {
        FileInputStream fis = new FileInputStream(file_read_path);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1; ) {
                bos.write(buf, 0, readNum); //no doubt here is 0
            }
        } catch (IOException ex) {
            System.out.println("failed to convert to byte array");
        }
        bos.close();
        fis.close();
        return bos.toByteArray();
    }

    public byte[] encodeIntoByteArray(byte[] image) {
        String encodedString = Base64.getEncoder().encodeToString(image);
        byte[] byteArrray = encodedString.getBytes();
        return byteArrray;
    }
    public String decodeIntoString(byte[] picture) {
        byte[] byteArrayPicture = Base64.getDecoder().decode(picture);
        String stringPicture = Base64.getEncoder().encodeToString(byteArrayPicture);
        return stringPicture;
    }
}
