package com.utilisateur.controleur;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.utilisateur.model.DemandeProf;
import com.utilisateur.model.NotifDemandes;
import com.utilisateur.model.Professionnel;
import com.utilisateur.model.Role;
import com.utilisateur.service.DemandeProfService;
import com.utilisateur.service.NotifDemandesService;
import com.utilisateur.service.ProfessionnelService;
import com.utilisateur.service.RoleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("utilisateur/professionnels")
public class ProfessionnelController {

	@Autowired
	private ProfessionnelService s;
	@Autowired
	private DemandeProfService sd;
	
	@Autowired
	private NotifDemandesService ns;
	
	@Autowired
	private RoleService sr;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Value("${file.upload-dir}")
	String FILE_DIRECTORY;
	
	@GetMapping("/")
	public List<Professionnel> getAllUsers(){
		
		return s.professionnels();
	}
	@GetMapping("/postuler/")
	public List<DemandeProf> listDemande() {
	     List<DemandeProf> list=sd.DemandeProf();
		Collections.sort(list=sd.DemandeProf(), new SortbyNum());
		return list;
	}
	@PostMapping("/postuler/")
	public DemandeProf postuler(@RequestBody DemandeProf user) {
		NotifDemandes notification  = new NotifDemandes(user.toString()); 
		 ns.addNotifDemandes(notification);
		DemandeProf d= sd.addDemandeProf(user);	
		 return d;
	}
	@PostMapping("/joindrecv/{id}")
	public void joindrecv(@PathVariable Long id,@RequestParam("file") MultipartFile file) {
		 String filename = file.getOriginalFilename();
			String modidiedFileName= FilenameUtils.getBaseName(filename)+"_"+System.currentTimeMillis()+".pdf";
		DemandeProf user = sd.getDemandeProfById(id);
		user.setCv(modidiedFileName);
		sd.updateDemandeProf(user);
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
	}
	@PutMapping("/postuler/{id}")
	public ResponseEntity<DemandeProf> updateDemande(@PathVariable Long id, @RequestBody DemandeProf userDetails) {
		DemandeProf user = sd.getDemandeProfById(id);
	user.setEmail("");
		user.setTraitee(userDetails.getTraitee());
		
		
		sd.updateDemandeProf(user); 
		return ResponseEntity.ok(user);
	}
	@DeleteMapping("/postuler/{id}")
	public ResponseEntity<Map<String, Boolean>> SuppDemande(@RequestBody long id) {
		DemandeProf user = sd.getDemandeProfById(id);
		
		sd.deleteDemandeProf(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	@PostMapping("/")
	public Professionnel createUser(@RequestBody Professionnel user) {
		user.setPass(encoder.encode("professionnel"));
		
		Set<Role> roles = new HashSet<Role>();
		Role r = new Role();
		r =sr.getRoleById(3L);
		roles.add(r);
		user.setRoles(roles);
		
		 s.addProfessionnel(user);
		 return user;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Professionnel> getUserById(@PathVariable Long id) {
		Professionnel user = s.getProfessionnelById(id);
		return ResponseEntity.ok(user);
	}
	@GetMapping("/postuler/{id}")
	public ResponseEntity<DemandeProf> getDemandeProfById(@PathVariable Long id) {
		DemandeProf user = sd.getDemandeProfById(id);
		
		return ResponseEntity.ok(user);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Professionnel> updateUser(@PathVariable Long id, @RequestBody Professionnel userDetails){
		Professionnel user = s.getProfessionnelById(id);
		//user.setPass(encoder.encode(user.getPass()));

		user.setNom(userDetails.getNom());
		user.setPrenom(userDetails.getPrenom());
		user.setEmail(userDetails.getEmail());

		user.setTelephone(userDetails.getTelephone());
		user.setPhoto(userDetails.getPhoto());
		//user.setRoles(userDetails.getRoles());
		
		s.updateProfessionnel(user);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteProfessionnel(@PathVariable Long id){
		Professionnel user = s.getProfessionnelById(id);
		
		s.deleteProfessionnel(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	class SortbyNum implements Comparator<DemandeProf>
	{
	    

		@Override
		public int compare(DemandeProf o1, DemandeProf o2) {
			// TODO Auto-generated method stub
			return (int) -(o1.getUser_id() - o2.getUser_id());
		}
	}
}
