package br.edu.ifpb.ads.entity;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash("doc_visao")
public class Doc {

	@Id
	private String id;

	@Indexed
	private String name;

	@Indexed
	private byte[] doc;

	public Doc() {

	}

	/**
	 * 
	 * @param name
	 * @param doc
	 */
	public Doc(String name, byte[] doc) {
		this.name = name;
		this.doc = doc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getDoc() {
		return doc;
	}

	public void setDoc(byte[] doc) {
		this.doc = doc;
	}

	@Override
	public String toString() {
		return "Doc [id=" + id + ", name=" + name + ", doc=" + Arrays.toString(doc) + "]";
	}

}
