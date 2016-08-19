package com.lsylvanus.util;

import com.lsylvanus.download.BatchDownloadFile;
import com.lsylvanus.entity.DownloadInfo;

public class DownloadUtils {

	public static void download(String url) {
		DownloadInfo bean = new DownloadInfo(url);
		LogUtils.info(bean);
		BatchDownloadFile down = new BatchDownloadFile(bean);
		new Thread(down).start();
	}

	public static void download(String url, int threadNum) {
		DownloadInfo bean = new DownloadInfo(url, threadNum);
		LogUtils.info(bean);
		BatchDownloadFile down = new BatchDownloadFile(bean);
		new Thread(down).start();
	}

	public static void download(String url, String fileName, String filePath, int threadNum) {
		DownloadInfo bean = new DownloadInfo(url, fileName, filePath, threadNum);
		LogUtils.info(bean);
		BatchDownloadFile down = new BatchDownloadFile(bean);
		new Thread(down).start();
	}
}
