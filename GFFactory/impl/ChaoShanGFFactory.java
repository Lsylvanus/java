package lsylvanus.impl;

import lsylvanus.base.BaseGF;
import lsylvanus.base.IGFFactory;
import lsylvanus.base.IGFFather;
import lsylvanus.sub.ChaoShanGF;

/**
 * �����������ӵĹ���
 * 
 * @author fx-pro
 *
 */
public class ChaoShanGFFactory implements IGFFactory {

	@Override
	public BaseGF creatGF() {
		return new ChaoShanGF();
	}

	@Override
	public IGFFather createGFfather() {
		return new ChaoShanGFFather();
	}

}
