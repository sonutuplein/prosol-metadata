package com.code.tuplein.metadata.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonEntity {
	private String packageName;
	private String packageLabel;
	private String packageDescription;
	private String modifiedBy;
	private Boolean isDeprecated;
	private Integer version;
}
