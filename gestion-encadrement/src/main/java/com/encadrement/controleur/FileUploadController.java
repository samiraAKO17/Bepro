package com.encadrement.controleur;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.encadrement.model.Semaine;
import com.encadrement.model.Stage;
import com.encadrement.service.SemaineService;
import com.encadrement.service.StageService;
import com.encadrement.util.Constant;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gestStages")
public class FileUploadController {
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	
	@Autowired
	SemaineService s;
	@Autowired
	StageService stg;
	@PostMapping("/upload/tds/{semaine_id}")
	public String fileUpload(@RequestParam("file") MultipartFile file, @PathVariable Long semaine_id) throws IOException{
		Semaine semaine = s.getSemaineById(semaine_id);	
		String filename = file.getOriginalFilename();
		String modidiedFileName= FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+"."+FilenameUtils.getExtension(filename);

		
					semaine.setTravail(modidiedFileName);


		s.updateSemaine(semaine);
		boolean isExist = new File(FILE_DIRECTORY).exists();
		if(!isExist) {
			new File (FILE_DIRECTORY).mkdir();
		}
		File serverfile= new File(FILE_DIRECTORY+modidiedFileName);
		try {
			FileUtils.writeByteArrayToFile(serverfile, file.getBytes());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return modidiedFileName;
	}
	@PostMapping("/upload/rapport/{stage_id}")
	public String RapportUpload(@RequestParam("file") MultipartFile file,@PathVariable Long stage_id) throws IOException{
		Stage stage =stg.getStageById(stage_id);
		String filename = file.getOriginalFilename();
		String modidiedFileName= FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+".pdf";
		stage.setRapport(modidiedFileName);
		stg.updateStage(stage);
		boolean isExist = new File(Constant.Rapport).exists();
		if(!isExist) {
			new File (Constant.Rapport).mkdir();
		}
		File serverfile= new File(Constant.Rapport+modidiedFileName);
		try {
			FileUtils.writeByteArrayToFile(serverfile, file.getBytes());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return modidiedFileName;
	}
	@PostMapping("/upload/presentation/{stage_id}")
	public String fileUploadPresentation(@RequestParam("file") MultipartFile file,@PathVariable Long stage_id) throws IOException{
		Stage stage=stg.getStageById(stage_id);
		String filename = file.getOriginalFilename();
		String modidiedFileName= FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+".pdf";
		stage.setPresentation(modidiedFileName);
		stg.updateStage(stage);
		boolean isExist = new File(Constant.PRESENTATION).exists();
		if(!isExist) {
			new File (Constant.PRESENTATION).mkdir();
		}
		File serverfile= new File(Constant.PRESENTATION+modidiedFileName);
		try {
			FileUtils.writeByteArrayToFile(serverfile, file.getBytes());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return modidiedFileName;
	}
	
}
