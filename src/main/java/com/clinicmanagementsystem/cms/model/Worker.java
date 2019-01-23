package com.clinicmanagementsystem.cms.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@TypeAlias("worker")

public class Worker extends User{
}
