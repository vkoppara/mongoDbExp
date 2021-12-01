package com.db.mongo.exp.model;

import java.time.LocalDateTime;
import java.util.UUID;

import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Identity {

	@NonNull
	private String identityId;
	@NonNull
	private String issuer;
	private LocalDateTime issueDate;
	private LocalDateTime expiryDate;
}
