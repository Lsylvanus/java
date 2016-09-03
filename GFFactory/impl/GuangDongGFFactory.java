package lsylvanus.impl;

import lsylvanus.base.BaseGF;
import lsylvanus.base.IGFFactory;
import lsylvanus.base.IGFFather;
import lsylvanus.sub.GuangDongGF;

/**
 * �����㶫���ӵĹ���
 * @author fx-pro
 *
 */
public class GuangDongGFFactory implements IGFFactory{

	@Override
	public BaseGF creatGF() {
		// TODO Auto-generated method stub
		return new GuangDongGF();
	}

	@Override
	public IGFFather createGFfather() {
		return new GuangDongGFFather();
	}

}
