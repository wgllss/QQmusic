/**
 * 
 */
package com.qq.atar.qqmusic.enums;

/**
 *****************************************************************************************************************************************************************************
 * 文件类型
 * @author :Atar
 * @createTime:2014-10-2上午11:09:53
 * @version:1.0.0
 * @modifyTime:
 * @modifyAuthor:
 * @description:
 *****************************************************************************************************************************************************************************
 */
public enum EnumFileType {
	/* 文字 */
	TEXT_TYPE(0),
	/* 图片 */
	IMAGE_TYPE(1),
	/* 语音 */
	AUDIO_TYPE(2);

	private int value;

	public int getValue() {
		return value;
	}

	EnumFileType(int value) {
		this.value = value;
	}
}
