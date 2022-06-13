package com.inventory.management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.management.entities.Classification;
import com.inventory.management.helper.ClassificationHelper;
import com.inventory.management.services.ClassificationServices;

@RestController
public class ClassificationController {
	@Autowired
	private ClassificationServices clfServices;

	@GetMapping("/classification")
<<<<<<< HEAD
	public ResponseEntity<List<Classification>> handler1() {	
		List<Classification>clfList=this.clfServices.getAllClassification();
		if(clfList.size()<=0)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.of(Optional.of(clfList));		
	}
	@GetMapping("/classification/{id}")	
	public ResponseEntity<Classification> handler2(@PathVariable("id") int id) {		
		Classification clf= this.clfServices.getClassificationById(id);	
		
		if(clf == null) {
=======
	public ResponseEntity<List<Classification>> handler1() {
		List<Classification> clfList = this.clfServices.getAllClassification();

		if (clfList.size() <= 0) {
>>>>>>> 493542dbc4d927b7e58c5ef316ef9ec95cbfd84f
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(clfList));
	}

	@GetMapping("/classification/{id}")
	public ResponseEntity<Classification> handler2(@PathVariable("id") int id) {
		Classification clf = this.clfServices.getClassificationById(id);

		if (clf == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(clf));
	}

	@PostMapping("/classification")
	public ResponseEntity<Classification> handler3(@RequestBody Classification clf) {
		try {
			this.clfServices.addClassification(clf);
			return ResponseEntity.status(HttpStatus.CREATED).body(clf);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
<<<<<<< HEAD
	
=======

>>>>>>> 493542dbc4d927b7e58c5ef316ef9ec95cbfd84f
	@DeleteMapping("/classification/{id}")
	public ResponseEntity<Void> handler4(@PathVariable("id") int id) {
		try {
			this.clfServices.deleteClassification(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/classification/{id}")
	public ResponseEntity<Classification> handler5(@RequestBody Classification clf, @PathVariable("id") int id) {
		try {
			this.clfServices.updateClassification(clf, id);
			return ResponseEntity.of(Optional.of(clf));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
