package com.inventory.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.management.entities.Classification;
import com.inventory.management.services.ClassificationServicesInterface;

@RestController
public class ClassificationController {
	@Autowired
	private ClassificationServicesInterface clfServices;

	@GetMapping("/classification")
	public ResponseEntity<List<Classification>> getMappingClassification() {	
		List<Classification>clfList=this.clfServices.getAllClassification();
		if(clfList.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(clfList));		
	}
	@GetMapping("/classification/{id}")
	public ResponseEntity<Classification> getMappingByIdClassification(@PathVariable("id") int id) {
		Classification clf = this.clfServices.getClassificationById(id);

		if (clf == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(clf));
	}

	@PostMapping(value ="/classification",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Classification> postMappingClassification(@RequestBody Classification clf) {
		try {
			this.clfServices.addClassification(clf);
			return ResponseEntity.status(HttpStatus.CREATED).body(clf);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/classification/{id}")
	public ResponseEntity<Void> deleteMappingClassification(@PathVariable("id") int id) {
		try {
			this.clfServices.deleteClassification(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/classification/{id}")
	public ResponseEntity<Classification> putMappingClassification(@RequestBody Classification clf, @PathVariable("id") int id) {
		try {
			this.clfServices.updateClassification(clf, id);
			return ResponseEntity.of(Optional.of(clf));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
