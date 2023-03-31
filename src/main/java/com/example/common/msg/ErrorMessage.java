package com.example.common.msg;

import java.util.List;
import java.util.Map;

import com.example.common.util.LogUtil;

public class ErrorMessage extends Message {

	public ErrorMessage() {
		super();
	}

	public void writeLog(LogUtil logUtil) {

		logUtil.errorUrl();

		StringBuilder sb = new StringBuilder();

		Map<String, String> globalMsgMap = this.getGlobalMsg();
		for (Map.Entry<String, String> globalMsgEntry : globalMsgMap.entrySet()) {
			writeGlobalMsg(logUtil, sb, globalMsgEntry.getValue());
		}

		List<String> globalOrderedMsgList = this.getGlobalOrderedMsg();
		for (String globalOrderedMsg : globalOrderedMsgList) {
			writeGlobalMsg(logUtil, sb, globalOrderedMsg);
		}

		Map<String, Map<String, String>> fieldMsgAllMap = this.getFieldMsg();
		for (Map.Entry<String, Map<String, String>> fieldMsgAllEntry : fieldMsgAllMap.entrySet()) {
			for (Map.Entry<String, String> fieldMsg : fieldMsgAllEntry.getValue().entrySet()) {
				writeFieldMsg(logUtil, sb, fieldMsgAllEntry.getKey(), fieldMsg.getValue());
			}
		}

		Map<String, List<String>> fieldMsgOrderedMap = this.getFieldOrderedMsg();
		for (Map.Entry<String, List<String>> fieldMsgOrderedEntry : fieldMsgOrderedMap.entrySet()) {
			for (String fieldMsg : fieldMsgOrderedEntry.getValue()) {
				writeFieldMsg(logUtil, sb, fieldMsgOrderedEntry.getKey(), fieldMsg);
			}
		}

	}
	
	protected StringBuilder getErrorMsg(StringBuilder sb, String value) {
		sb.append("[msg]");
		sb.append(value);
		return sb;
	}

	protected StringBuilder getErrorMsg(StringBuilder sb, String key, String value) {
		sb.append("[key]");
		sb.append(key);
		sb.append("[msg]");
		sb.append(value);
		return sb;
	}

	protected void writeGlobalMsg(LogUtil logUtil, StringBuilder sb, String value) {
		sb.delete(0, sb.length());
		sb.append("[error][global]");
		getErrorMsg(sb, value);
		logUtil.error(sb.toString());
	}

	protected void writeFieldMsg(LogUtil logUtil, StringBuilder sb, String key, String value) {
		sb.delete(0, sb.length());
		sb.append("[error][field]");
		getErrorMsg(sb, key, value);
		logUtil.error(sb.toString());
	}

}
