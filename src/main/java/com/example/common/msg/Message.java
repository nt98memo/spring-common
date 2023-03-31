package com.example.common.msg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Message {

	protected Map<String, String> globalMsg = new HashMap<String, String>();
	protected Map<String, Map<String, String>> fieldMsg = new HashMap<String, Map<String, String>>();

	protected List<String> globalOrderedMsg = new ArrayList<String>();
	protected Map<String, List<String>> fieldOrderedMsg = new HashMap<String, List<String>>();

	public Message() {
	}

	public static Message createMsg() {
		return new Message();
	}

	public Message setGlobalMsg(String msg) {
		this.globalMsg.put(msg, msg);
		return this;
	}

	public Message addGlobalMsg(String msg) {
		this.globalOrderedMsg.add(msg);
		return this;
	}

	public synchronized Message setFieldMsg(String field, String msg) {
		if (!this.fieldMsg.containsKey(field)) {
			this.fieldMsg.put(field, new HashMap<String, String>());
		}
		this.fieldMsg.get(field).put(msg, msg);
		return this;
	}

	public synchronized Message addFieldMsg(String field, String msg) {
		if (!this.fieldOrderedMsg.containsKey(field)) {
			this.fieldOrderedMsg.put(field, new ArrayList< String>());
		}
		this.fieldOrderedMsg.get(field).add(msg);
		return this;
	}

	public Map<String, String> getGlobalMsg() {
		return globalMsg;
	}

	public List<String> getGlobalOrderedMsg() {
		return globalOrderedMsg;
	}

	public Map<String, Map<String, String>> getFieldMsg() {
		return fieldMsg;
	}

	public Map<String, List<String>> getFieldOrderedMsg() {
		return fieldOrderedMsg;
	}

}
