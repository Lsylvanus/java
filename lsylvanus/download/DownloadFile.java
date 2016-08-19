package com.lsylvanus.download;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import com.lsylvanus.util.LogUtils;

/**
 * �������Ҫ����ɵ����̵߳��ļ����أ���ͨ��URLConnection��ȡָ��url����Դ��Ϣ��
 * Ȼ����InputStream��ȡ�ļ����ݣ�Ȼ����õ���SaveItemFile�࣬�򱾵�д�뵱ǰҪ��ȡ�Ŀ�����ݡ�
 * @author fx-pro
 *
 */
public class DownloadFile extends Thread {

	// �����ļ�url
	private String url;
	// �����ļ���ʼλ��
	private long startPos;
	// �����ļ�����λ��
	private long endPos;
	// �߳�id
	private int threadId;

	// �����Ƿ����
	private boolean isDownloadOver = false;
	private SaveItemFile itemFile;
	private static final int BUFF_LENGTH = 1024 * 8;

	public DownloadFile(String url, String name, long startPos, long endPos, int threadId) throws IOException {
		super();
		this.url = url;
		this.startPos = startPos;
		this.endPos = endPos;
		this.threadId = threadId;
		// �ֿ�����д���ļ�����
		this.itemFile = new SaveItemFile(name, startPos);
	}

	@Override
	public void run() {
		while (endPos > startPos && !isDownloadOver) {
			try {
				URL url = new URL(this.url);
				HttpURLConnection con = (HttpURLConnection) url.openConnection();

				// �������ӳ�ʱʱ��Ϊ60000ms
				con.setConnectTimeout(60000);
				// ���ö�ȡ���ݳ�ʱʱ��Ϊ10000ms
				con.setReadTimeout(10000);

				setHeader(con);

				String property = "bytes=" + startPos + "-";
				con.setRequestProperty("RANGE", property);

				// ���log��Ϣ
				LogUtils.log("��ʼ " + threadId + "��" + property + endPos);
				// printHeader(conn);

				// ��ȡ�ļ�����������ȡ�ļ�����
				InputStream is = con.getInputStream();

				byte[] buff = new byte[BUFF_LENGTH];
				int length = -1;
				LogUtils.log("#start#Thread: " + threadId + ", startPos: " + startPos + ", endPos: " + endPos);
				while ((length = is.read(buff)) > 0 && startPos < endPos && !isDownloadOver) {
					// д���ļ����ݣ��������д��ĳ���
					startPos += itemFile.write(buff, 0, length);
				}
				LogUtils.log("#over#Thread: " + threadId + ", startPos: " + startPos + ", endPos: " + endPos);
				LogUtils.log("Thread " + threadId + " is execute over!");
				this.isDownloadOver = true;
			}catch (MalformedURLException e) {
                e.printStackTrace();
            }catch (IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if (itemFile!=null) {
						itemFile.close();
					}
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
		
		if (endPos < startPos && !isDownloadOver) {
            LogUtils.log("Thread " + threadId  + " startPos > endPos, not need download file !");
            this.isDownloadOver = true;
        }
        if (endPos == startPos && !isDownloadOver) {
            LogUtils.log("Thread " + threadId  + " startPos = endPos, not need download file !");
            this.isDownloadOver = true;
        }
	}

	/**
	 * ��ӡ�����ļ�ͷ����Ϣ
	 * @param con
	 */
	public static void printHeader(URLConnection con) {
        int i = 1;
        while (true) {
            String header = con.getHeaderFieldKey(i);
            i++;
            if (header != null) {
                LogUtils.info(header + ":" + con.getHeaderField(i));
            } else {
                break;
            }
        }
    }
	
	/**
	 * ����URLConnection��ͷ����Ϣ��αװ������Ϣ
	 * @param con
	 */
	public static void setHeader(URLConnection con) {
		con.setRequestProperty("User-Agent", "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.3) Gecko/2008092510 Ubuntu/8.04 (hardy) Firefox/3.0.3");
		con.setRequestProperty("Accept-Language", "en-us,en;q=0.7,zh-cn;q=0.3");
		con.setRequestProperty("Accept-Encoding", "utf-8");
		con.setRequestProperty("Accept-Charset", "ISO-8859-1,utf-8;q=0.7,*;q=0.7");
		con.setRequestProperty("Keep-Alive", "300");
		con.setRequestProperty("connnection", "keep-alive");
		con.setRequestProperty("If-Modified-Since", "Mon, 15 Aug 2016 17:00:05 GMT");
		con.setRequestProperty("If-None-Match", "\"1261d8-4290-df64d224\"");
		con.setRequestProperty("Cache-conntrol", "max-age=0");
		con.setRequestProperty("Referer", "http://www.baidu.com");
    }
    
    public boolean isDownloadOver() {
        return isDownloadOver;
    }
    
    public long getStartPos() {
        return startPos;
    }
 
    public long getEndPos() {
        return endPos;
    }
}
