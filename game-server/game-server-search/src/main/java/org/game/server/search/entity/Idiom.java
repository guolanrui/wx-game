package org.game.server.search.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName="index",type="idiom")
public class Idiom {

	@Id
	private Integer id;
	
	@Field(type=FieldType.String)
	private String text;
	
	private String pingyin;
	
	private String explain;
	
	private String from;
	
	private String example;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getPingyin() {
		return pingyin;
	}

	public void setPingyin(String pingyin) {
		this.pingyin = pingyin;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getExample() {
		return example;
	}

	public void setExample(String example) {
		this.example = example;
	}

	public Idiom(String text, String pingyin, String explain, String from, String example) {
		super();
		this.text = text;
		this.pingyin = pingyin;
		this.explain = explain;
		this.from = from;
		this.example = example;
	}
	
	public Idiom() {}
	
}
