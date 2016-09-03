package lsylvanus.impl;

import lsylvanus.base.BaseGF;
import lsylvanus.base.IGFFactory;
import lsylvanus.base.IGFFather;
import lsylvanus.sub.ShenZhenGF;

/**
 * �����������ӵĹ���
 * @author fx-pro
 *
 */
public class ShenZhenGFFactory implements IGFFactory{

	@Override
	public BaseGF creatGF() {
		// TODO Auto-generated method stub
		return new ShenZhenGF();
	}

	@Override
	public IGFFather createGFfather() {
		return new ShenZhenGFFather();
	}
}
