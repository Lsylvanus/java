package com.lsylvanus.download;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * �������Ҫ������򱾵ص�ָ���ļ�ָ�����ʼд���ļ��������ص�ǰд���ļ��ĳ��ȣ��ļ�ָ�룩��
 * ����ཫ���̵߳��ã��ļ����ֳɶ�Ӧ�Ŀ�󣬽����̵߳��á�
 * ÿ���̶߳�����������������ļ������д�롣
 * @author fx-pro
 *
 */
public class SaveItemFile {

	// �洢�ļ�
	private RandomAccessFile itemFile;

	public SaveItemFile() throws IOException{
		this("", 0);
	}

	/**
	 * 
	 * @param name
	 *            �ļ�·��������
	 * @param pos
	 *            д���λ��
	 * @throws IOException
	 */
	public SaveItemFile(String name, long pos) throws IOException {
		itemFile = new RandomAccessFile(name, "rw");
		// ��ָ����posλ�ÿ�ʼд������
		itemFile.seek(pos);
	}

	/**
	 * 
	 * @param buff
	 *            ��������
	 * @param start
	 *            ��ʼλ��
	 * @param length
	 *            ����
	 * @return
	 */
	public synchronized int write(byte[] buff, int start, int length) {
		int i = -1;
		try {
			itemFile.write(buff, start, length);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}

	public void close() throws IOException {
		if (itemFile != null) {
			itemFile.close();
		}
	}
}
