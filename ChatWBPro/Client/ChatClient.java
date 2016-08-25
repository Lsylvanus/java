package com.lsylvanus.Client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.CompoundBorder;

public class ChatClient extends JFrame implements ActionListener {
	// ���ӵ�����˵�ip��ַ
	String ip = "127.0.0.1";
	// ���ӵ�����˵Ķ˿ں�
	int port = 8888;
	// �û���
	String userName = "�⳾";
	// 0��ʾδ���ӣ�1��ʾ������
	int type = 0;

	private JPanel contentPane;
	private JTextField clientMessage;
	private JTextField showStatus;

	private JMenuBar menuBar;
	private JMenu operateMenu;
	private JMenuItem loginItem;
	private JMenuItem logoffItem;
	private JMenuItem exitItem;
	private JMenu conMenu;
	private JMenuItem userItem;
	private JMenuItem connectItem;
	private JMenu helpMenu;
	private JMenuItem helpItem;

	private JComboBox comboBox;
	private JTextArea messageShow;
	private JCheckBox checkBox;
	private JButton userButton;
	private JButton connectButton;
	private JButton loginButton;
	private JButton logoffButton;
	private JButton exitButton;
	private JButton clientMessageButton;
	private JLabel label_2;
	private JComboBox actionlist;
	
	Socket socket;
	ObjectOutputStream output;// �����׽��������
	ObjectInputStream input;// �����׽���������

	ClientReceive recvThread;
	private JScrollPane messageScrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClient frame = new ChatClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatClient() {
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ChatClient.class.getResource("/image/Foobar_32px_1121452_easyicon.net.png")));
		setTitle("\u804A\u5929\u5BA4\u5BA2\u6237\u7AEF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// �رճ���ʱ�Ĳ���
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if (type == 1) {
					DisConnect();
				}
				System.exit(0);
			}
		});
		setBounds(100, 100, 493, 720);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		operateMenu = new JMenu("\u64CD\u4F5C");
		operateMenu.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		menuBar.add(operateMenu);

		loginItem = new JMenuItem("\u7528\u6237\u767B\u5F55");
		loginItem.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		operateMenu.add(loginItem);

		logoffItem = new JMenuItem("\u7528\u6237\u6CE8\u9500");
		logoffItem.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		operateMenu.add(logoffItem);

		exitItem = new JMenuItem("\u9000\u51FA");
		exitItem.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		operateMenu.add(exitItem);

		conMenu = new JMenu("\u8BBE\u7F6E");
		conMenu.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		menuBar.add(conMenu);

		userItem = new JMenuItem("\u7528\u6237\u8BBE\u7F6E");
		userItem.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		conMenu.add(userItem);

		connectItem = new JMenuItem("\u8FDE\u63A5\u8BBE\u7F6E");
		connectItem.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		conMenu.add(connectItem);

		helpMenu = new JMenu("\u5E2E\u52A9");
		helpMenu.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		menuBar.add(helpMenu);

		helpItem = new JMenuItem("\u5E2E\u52A9");
		helpItem.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		helpMenu.add(helpItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());

		JLabel label = new JLabel("\u53D1\u9001\u81F3\uFF1A");
		label.setFont(new Font("΢���ź�", Font.PLAIN, 12));

		comboBox = new JComboBox();
		comboBox.setFont(new Font("΢���ź�", Font.PLAIN, 12));

		checkBox = new JCheckBox("\u6084\u6084\u8BDD");
		checkBox.setFont(new Font("΢���ź�", Font.PLAIN, 12));

		JLabel label_1 = new JLabel("\u53D1\u9001\u6D88\u606F\uFF1A");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 12));

		clientMessage = new JTextField();
		clientMessage.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		clientMessage.setColumns(10);

		clientMessageButton = new JButton("\u53D1\u9001");
		clientMessageButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));

		showStatus = new JTextField();
		showStatus.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		showStatus.setForeground(Color.BLACK);
		showStatus.setEditable(false);
		showStatus.setColumns(10);
		
		label_2 = new JLabel("\u8868\u60C5\uFF1A");
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		
		actionlist = new JComboBox();
		actionlist.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		actionlist.addItem("΢Ц��");
		actionlist.addItem("���˵�");
		actionlist.addItem("�����");
		actionlist.addItem("������");
		actionlist.addItem("С�ĵ�");
		actionlist.addItem("������");
		actionlist.setSelectedIndex(0);
		
		messageScrollPane = new JScrollPane();
		if (messageScrollPane.isValidateRoot()) {
			messageScrollPane.revalidate();
		}
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(messageScrollPane, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 447, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addGap(1)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(actionlist, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
									.addComponent(checkBox)
									.addGap(21))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(12)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(clientMessage, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(clientMessageButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(showStatus, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(messageScrollPane, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(label))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2)
								.addComponent(actionlist, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(checkBox))))
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(clientMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(clientMessageButton))
					.addGap(18)
					.addComponent(showStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(30, Short.MAX_VALUE))
		);
		
				messageShow = new JTextArea();
				messageShow.setEditable(false);
				messageScrollPane.setViewportView(messageShow);

		userButton = new JButton("\u7528\u6237\u8BBE\u7F6E");
		userButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		connectButton = new JButton("\u8FDE\u63A5\u8BBE\u7F6E");
		connectButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		loginButton = new JButton("\u767B\u5F55");
		loginButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		logoffButton = new JButton("\u6CE8\u9500");
		logoffButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		exitButton = new JButton("\u9000\u51FA");
		exitButton.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		
		loginItem.addActionListener(this);
		logoffItem.addActionListener(this);
		exitItem.addActionListener(this);
		userItem.addActionListener(this);
		connectItem.addActionListener(this);
		helpItem.addActionListener(this);

		loginButton.addActionListener(this);
		logoffButton.addActionListener(this);
		userButton.addActionListener(this);
		connectButton.addActionListener(this);
		exitButton.addActionListener(this);
		
		clientMessage.addActionListener(this);
		clientMessageButton.addActionListener(this);
		
		loginButton.setToolTipText("���ӵ�ָ���ķ�����");
		logoffButton.setToolTipText("��������Ͽ�����");
		userButton.setToolTipText("�����û���Ϣ");
		connectButton.setToolTipText("������Ҫ���ӵ��ķ�������Ϣ");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(userButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(connectButton)
					.addGap(26)
					.addComponent(loginButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(logoffButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(exitButton)
					.addContainerGap(17, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(userButton)
						.addComponent(connectButton)
						.addComponent(loginButton)
						.addComponent(logoffButton)
						.addComponent(exitButton))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	public void init() {
		
	}

	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == userItem || obj == userButton) { // �û���Ϣ����
			// �����û���Ϣ���öԻ���
			UserConf userConf = new UserConf(this, userName);
			userConf.show();
			userName = userConf.userInputName;
		} else if (obj == connectItem || obj == connectButton) { // ���ӷ��������
			// �����������öԻ���
			ConnectConf conConf = new ConnectConf(this, ip, port);
			conConf.show();
			ip = conConf.userInputIp;
			port = conConf.userInputPort;
		} else if (obj == loginItem || obj == loginButton) { // ��¼
			Connect();
		} else if (obj == logoffItem || obj == logoffButton) { // ע��
			DisConnect();
			showStatus.setText("");
		} else if (obj == clientMessage || obj == clientMessageButton) { // ������Ϣ
			SendMessage();
			clientMessage.setText("");
		} else if (obj == exitButton || obj == exitItem) { // �˳�
			int j = JOptionPane.showConfirmDialog(this, "���Ҫ�˳���?", "�˳�", JOptionPane.YES_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (j == JOptionPane.YES_OPTION) {
				if (type == 1) {
					DisConnect();
				}
				System.exit(0);
			}
		} else if (obj == helpItem) { // �˵����еİ���
			// ���������Ի���
			Help helpDialog = new Help(this);
			helpDialog.show();
		}
	}

	/**
	 * ������Ϣ
	 */
	public void SendMessage() {
		String toSomebody = comboBox.getSelectedItem().toString();
		String status = "";
		if (checkBox.isSelected()) {
			status = "���Ļ�";
		}

		String action = actionlist.getSelectedItem().toString();
		String message = clientMessage.getText();

		if (socket.isClosed()) {
			return;
		}

		try {
			output.writeObject("������Ϣ");
			output.flush();
			output.writeObject(toSomebody);
			output.flush();
			output.writeObject(status);
			output.flush();
			output.writeObject(action);
			output.flush();
			output.writeObject(message);
			output.flush();
		} catch (Exception e) {
			//
		}
	}

	/**
	 * ��ȡ����
	 */
	private void Connect() {
		try {
			socket = new Socket(ip, port);
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(this, "�������ӵ�ָ���ķ�������\n��ȷ�����������Ƿ���ȷ��", "��ʾ", JOptionPane.DEFAULT_OPTION,
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
			output = new ObjectOutputStream(socket.getOutputStream());
			output.flush();
			input = new ObjectInputStream(socket.getInputStream());

			output.writeObject(userName);
			output.flush();

			recvThread = new ClientReceive(socket, output, input, comboBox, messageShow, showStatus);
			recvThread.start();

			loginButton.setEnabled(false);
			loginItem.setEnabled(false);
			userButton.setEnabled(false);
			userItem.setEnabled(false);
			connectButton.setEnabled(false);
			connectItem.setEnabled(false);
			logoffButton.setEnabled(true);
			logoffItem.setEnabled(true);
			clientMessage.setEnabled(true);
			messageShow.append("���ӷ����� " + ip + ":" + port + " �ɹ�...\n");
			type = 1;// ��־λ��Ϊ������
		} catch (Exception e) {
			System.out.println(e);
			return;
		}

	}

	/**
	 * �Ͽ�����,�û�����
	 */
	public void DisConnect() {
		loginButton.setEnabled(true);
		loginItem.setEnabled(true);
		userButton.setEnabled(true);
		userItem.setEnabled(true);
		connectButton.setEnabled(true);
		connectItem.setEnabled(true);
		logoffButton.setEnabled(false);
		logoffItem.setEnabled(false);
		clientMessage.setEnabled(false);

		if (socket.isClosed()) {
			return;
		}

		try {
			output.writeObject("�û�����");
			output.flush();

			input.close();
			output.close();
			socket.close();
			messageShow.append("�Ѿ���������Ͽ�����...\n");
			type = 0;// ��־λ��Ϊδ����
		} catch (Exception e) {
			//
		}
	}
}
