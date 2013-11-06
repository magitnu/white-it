package ch.hsr.intte.whiteit.entities;

import java.util.UUID;

public abstract class BaseEntity {
	private UUID id;
	
	public BaseEntity() {
		id = UUID.randomUUID();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
