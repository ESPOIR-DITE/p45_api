package org.example.controller.user;

import org.example.controller.Icontroller;
import org.example.domain.user.Party;
import org.example.factory.candidate.PartyFactory;
import org.example.service.user.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("p45_api/party/")
public class PartyController implements Icontroller<Party,String> {
    private String fileName = Paths.get("").toAbsolutePath().toString()+"output.jpg";
    private File file_save_path = new File(fileName);

    private String fileName1 = Paths.get("").toAbsolutePath().toString()+"resized.jpg";
    private File file_read_path = new File(fileName1);

    @Autowired
    private PartyService partyService;

    @Override
//    public Party create(Party party){
//        return null;
//    }

    @PostMapping("create")
    public Party create(@RequestBody Party party) throws IOException {
//        System.out.println(party.getFlag());
//        pictureWriter(party.getFlag());
//        ImageResizer.getResizedImage();
//        byte[] resised = convertToBytes();

        Party party1 = PartyFactory.getParty(party.getName(),party.getAbbreviation(),encodeIntoByteArray(party.getFlag()));
        return partyService.create(party1);
    }

    @PostMapping("update")
    @Override
    public Party update(@RequestBody Party party) {
        Party party1 = PartyFactory.getPartyUpdate(party.getId(),party.getName(),party.getAbbreviation(),encodeIntoByteArray(party.getFlag()));
        return partyService.update(party1);
    }

    @GetMapping("readWith")
    public Party readWithAbbreviation(@RequestParam("abv") String abv) {
        return partyService.readWithAbv(abv);
    }

    @GetMapping("deleteWith")
    public Boolean deleteWithAbbreviation(@RequestParam("abv") String abv) {
        return partyService.deleteWithAbv(abv);
    }

    @GetMapping("read")
    @Override
    public Party read(@RequestParam("id") String id) {
        return partyService.read(id);
    }

    @GetMapping("delete")
    @Override
    public Boolean delete(@RequestParam("id") String id) {
        return partyService.delete(id);
    }

    @GetMapping("reads")
    @Override
    public List<Party> readAll() {
        return partyService.readAll();
    }

    @GetMapping("count")
    @Override
    public Long count() {
        return partyService.count();
    }


    public void pictureWriter(byte[] bytes) throws IOException {
//        byte[] bytes = FileUtils.readFileToByteArray(file);
//        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
//        BufferedImage bImage2 = ImageIO.read(bis);
//        ImageIO.write(bImage2, "jpg", file_save_path);
//        System.out.println("image created");
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
