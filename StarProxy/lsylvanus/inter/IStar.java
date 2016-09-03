package com.lsylvanus.inter;

/**
 * 明星接口，定义了一些明星的行为
 * 
 * @author fx-pro
 *
 */
public interface IStar {

	/**
	 * 参加节目
	 */
	void attendTheShow();

	/**
	 * 照顾妻子
	 */
	void loveWife();

	// ...
	
	/**
	 * 经纪人和明星在一些行为上有共同点，所以定义个共有接口
	 */
}
