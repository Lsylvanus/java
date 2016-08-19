package com.lsylvanus.entity;

public class DownloadInfo {

	// �����ļ�url
	private String url;
	// �����ļ�����
	private String fileName;
	// �����ļ�·��
	private String filePath;
	// �ֳɶ��ٶ����أ�ÿһ����һ���߳��������
	private int splitter;
	// �����ļ�Ĭ�ϱ���·��
	private final static String FILE_PATH = "D:/MyPhotos/ThreadDownloadsTemp";
	// Ĭ�Ϸֿ������߳���
	private final static int SPLITTER_NUM = 5;

	public DownloadInfo() {
		super();
	}

	/**
	 * @param url
	 *            ���ص�ַ
	 */
	public DownloadInfo(String url) {
		this(url, null, null, SPLITTER_NUM);
	}

	/**
	 * @param url
	 *            ���ص�ַurl
	 * @param splitter
	 *            �ֳɶ��ٶλ��Ƕ��ٸ��ֳ�����
	 */
	public DownloadInfo(String url, int splitter) {
		this(url, null, null, splitter);
	}

	/**
	 * 
	 * @param url
	 *            ���ص�ַurl
	 * @param fileName
	 *            �ļ�����
	 * @param filePath
	 *            �ļ�����·��
	 * @param splitter
	 *            �ֳɶ��ٶλ��Ƕ��ٸ��ֳ�����
	 */
	public DownloadInfo(String url, String fileName, String filePath, int splitter) {
		super();
		if (url == null || "".equals(url)) {
			throw new RuntimeException("url is not null!");
		}
		this.url = url;
		this.fileName = (fileName == null || "".equals(fileName)) ? getFileName(url) : fileName;
		this.filePath = (filePath == null || "".equals(filePath)) ? FILE_PATH : filePath;
		this.splitter = (splitter < 1) ? SPLITTER_NUM : splitter;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		if (url == null || "".equals(url)) {
			throw new RuntimeException("url is not null!");
		}
		this.url = url;
	}

	public String getFileName() {
		return fileName;
	}

	/**
	 * ͨ��url����ļ�����
	 * 
	 * @param url
	 * @return
	 */
	public String getFileName(String url) {
		return url.substring(url.lastIndexOf("/") + 1, url.length());
	}

	public void setFileName(String fileName) {
		this.fileName = (fileName == null || "".equals(fileName)) ? getFileName(url) : fileName;
	}

	public int getSplitter() {
		return splitter;
	}

	public void setSplitter(int splitter) {
		this.splitter = (splitter < 1) ? SPLITTER_NUM : splitter;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = (filePath == null || "".equals(filePath)) ? FILE_PATH : filePath;
	}

	@Override
	public String toString() {
		return this.url + "#" + this.fileName + "#" + this.filePath + "#" + this.splitter;
	}
}
