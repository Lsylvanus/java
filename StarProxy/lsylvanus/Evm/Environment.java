package com.lsylvanus.Evm;

import com.lsylvanus.model.Agent;
import com.lsylvanus.model.Star;

/**
 * 外界环境，一般都是通过经纪人来接触明星
 * 调用方法如何通过经纪人访问明星
 * @author fx-pro
 *
 */
public class Environment {

	public static void main(String[] args) {
		// 王宝强，一个可爱/淳朴的明星
		Star baoqiang = new Star("王宝强");
		// 有个经纪人叫宋吉吉
		Agent songJJ = new Agent(baoqiang, false);
		songJJ.attendTheShow();
		songJJ.loveWife();
		
		/**
		 * 可以看出代理的主要作用是方法增强，它可以在不“惊动”被代理类的情况下修改被代理类的行为。
		 * 这有助于系统解耦。
		 * 这里代理类和被代理类属于静态代理。
		 */
	}
}
