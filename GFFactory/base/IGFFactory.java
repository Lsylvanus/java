package lsylvanus.base;

/**
 * 创建女朋友的接口，想要哪里的女朋友，实现这个接口就行了
 * @author fx-pro
 *
 */
public interface IGFFactory {

	BaseGF creatGF();
	
	// 增加一个创建妹子父亲的方法
	IGFFather createGFfather();
}
