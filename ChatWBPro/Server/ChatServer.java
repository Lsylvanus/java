package com.lsylvanus.Server;

import java.awt.EventQueue;
import java.net.ServerSocket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;

public class ChatServer extends JFrame implements ActionListener {

	public static int port = 8888;
	private JPanel contentPane;
	ServerSocket serverSocket;
	UserLinkList userLinkList;

	private JMenuBar menuBar;
	private JMenu helpMenu;
	private JMenuItem helpItem;
	private JMenuItem exitItem;
	private JMenu serviceMenu;
	private JMenuItem portItem;
	private JMenuItem startItem;
	private JMenuItem stopItem;

	private JButton portSet;
	private JButton startServer;
	private JButton stopServer;
	private JButton exitButton;

	ServerListen listenThread;

	private JLabel label;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private JTextField sysMessage;
	private JButton sysMessageButton;
	private JTextField showStatus;
	private JTextArea messageShow;
	private JScrollPane messageScrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatServer frame = new ChatServer();
					frame.setVisible(true);
				} catch (Exception e) {
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatServer() {
		setFont(new Font("微软雅黑", Font.PLAIN, 12));
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ChatServer.class.getResource("/image/Foobar_32px_1121452_easyicon.net.png")));
		setTitle("\u804A\u5929\u5BA4\u670D\u52A1\u7AEF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 665);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		serviceMenu = new JMenu("\u670D\u52A1");
		serviceMenu.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		menuBar.add(serviceMenu);

		portItem = new JMenuItem("\u7AEF\u53E3\u8BBE\u7F6E");
		portItem.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		serviceMenu.add(portItem);

		startItem = new JMenuItem("\u542F\u52A8\u670D\u52A1");
		startItem.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		serviceMenu.add(startItem);

		stopItem = new JMenuItem("\u505C\u6B62\u670D\u52A1");
		stopItem.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		serviceMenu.add(stopItem);

		exitItem = new JMenuItem("\u9000\u51FA");
		exitItem.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		serviceMenu.add(exitItem);

		helpMenu = new JMenu("\u5E2E\u52A9");
		helpMenu.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		menuBar.add(helpMenu);

		helpItem = new JMenuItem("\u5E2E\u52A9");
		helpItem.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		helpMenu.add(helpItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder());

		label = new JLabel("\u53D1\u9001\u81F3\uFF1A");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 12));

		comboBox = new JComboBox();
		comboBox.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		comboBox.insertItemAt("所有人", 0);
		comboBox.setSelectedIndex(0);

		lblNewLabel = new JLabel("\u53D1\u9001\u6D88\u606F\uFF1A");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 12));

		sysMessage = new JTextField();
		sysMessage.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		sysMessage.setColumns(25);

		sysMessageButton = new JButton("\u53D1\u9001");
		sysMessageButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));

		showStatus = new JTextField(35);
		showStatus.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		showStatus.setForeground(Color.BLACK);
		showStatus.setEditable(false);
		showStatus.setColumns(25);
		
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
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addContainerGap()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(messageScrollPane, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
										.addComponent(panel, GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(label)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(8)
									.addComponent(lblNewLabel)
									.addGap(3)
									.addComponent(sysMessage, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
									.addGap(27)
									.addComponent(sysMessageButton)))
							.addGap(10))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(showStatus, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(messageScrollPane, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(14)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(sysMessage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(sysMessageButton))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(showStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
		);
		
				messageShow = new JTextArea();
				messageShow.setEditable(false);
				messageScrollPane.setViewportView(messageShow);

		portSet = new JButton("\u7AEF\u53E3\u8BBE\u7F6E");
		portSet.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		startServer = new JButton("\u5F00\u542F\u670D\u52A1");
		startServer.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		stopServer = new JButton("\u505C\u6B62\u670D\u52A1");
		stopServer.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		exitButton = new JButton("\u9000\u51FA");
		exitButton.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(portSet)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(startServer)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(stopServer)
					.addGap(44)
					.addComponent(exitButton)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(portSet)
						.addComponent(startServer)
						.addComponent(stopServer)
						.addComponent(exitButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

		portItem.addActionListener(this);
		startItem.addActionListener(this);
		stopItem.addActionListener(this);
		exitItem.addActionListener(this);
		helpItem.addActionListener(this);
		portSet.addActionListener(this);
		startServer.addActionListener(this);
		stopServer.addActionListener(this);
		exitButton.addActionListener(this);
		sysMessageButton.addActionListener(this);

		addWindowListener(new WindowAdapter() {
			
			final ChatServer this$0;
			
			public void windowClosing(WindowEvent windowevent) {
				stopService();
				System.exit(0);
			}

			{
				// super();
				this$0 = ChatServer.this;
			}
		});
	}

	/**
	 * 开启服务
	 */
	public void startService() {
		try {
			serverSocket = new ServerSocket(port, 10);
			messageShow.append((new StringBuilder()).append("服务端已经启动，在").append(port).append("端口侦听...\n").toString());
			startServer.setEnabled(false);
			startItem.setEnabled(false);
			portSet.setEnabled(false);
			portItem.setEnabled(false);
			stopServer.setEnabled(true);
			stopItem.setEnabled(true);
			sysMessage.setEnabled(true);
		} catch (Exception e) {
		}
		userLinkList = new UserLinkList();
		listenThread = new ServerListen(serverSocket, comboBox, messageShow, showStatus, userLinkList);
		listenThread.start();
	}

	/**
	 * 停止服务
	 */
	public void stopService() {
		try {
			sendStopToAll();
			listenThread.isStop = true;
			serverSocket.close();
			int i = userLinkList.getCount();
			for (int j = 0; j < i; j++) {
				Node node = userLinkList.findUser(j);
				node.input.close();
				node.output.close();
				node.socket.close();
			}

			stopServer.setEnabled(false);
			stopItem.setEnabled(false);
			startServer.setEnabled(true);
			startItem.setEnabled(true);
			portSet.setEnabled(true);
			portItem.setEnabled(true);
			sysMessage.setEnabled(false);
			messageShow.append("服务端已经关闭\n");
			comboBox.removeAllItems();
			comboBox.addItem("所有人");
		} catch (Exception e) {
		}
	}
	
	public void sendStopToAll() {
		int i = userLinkList.getCount();
		for (int j = 0; j < i;) {
			Node node = userLinkList.findUser(j);
			if (node == null) {
				j++;
			} else {
				try {
					node.output.writeObject("服务关闭");
					node.output.flush();
				} catch (Exception e) {
				}
				j++;
			}
		}

	}

	/**
	 * 群发
	 * 
	 * @param s
	 */
	public void sendMsgToAll(String s) {
		int i = userLinkList.getCount();
		for (int j = 0; j < i;) {
			Node node = userLinkList.findUser(j);
			if (node == null) {
				j++;
			} else {
				try {
					node.output.writeObject("系统信息");
					node.output.flush();
					node.output.writeObject(s);
					node.output.flush();
				} catch (Exception e) {
				}
				j++;
			}
		}
		sysMessage.setText("");
	}

	/**
	 * 服务端发送消息作为系统消息
	 */
	public void sendSystemMessage() {
		String s = comboBox.getSelectedItem().toString();
		String s1 = (new StringBuilder()).append(sysMessage.getText()).append("\n").toString();
		messageShow.append(s1);
		if (s.equalsIgnoreCase("所有人")) {
			this.sendMsgToAll(s1);
		} else {
			Node node = userLinkList.findUser(s);
			try {
				node.output.writeObject("系统信息");
				node.output.flush();
				node.output.writeObject(s1);
				node.output.flush();
			} catch (Exception e) {
			}
			sysMessage.setText("");
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();

		if (obj == startServer || obj == startItem)
			this.startService();
		else if (obj == stopServer || obj == stopItem) {
			int i = JOptionPane.showConfirmDialog(this, "真的停止服务吗?", "停止服务", 0, 3);
			if (i == 0)
				this.stopService();
		} else if (obj == portSet || obj == portItem) {
			PortConf portconf = new PortConf(this);
			portconf.show();
		} else if (obj == exitButton || obj == exitItem) {
			int j = JOptionPane.showConfirmDialog(this, "真的要退出吗?", "退出", 0, 3);
			if (j == 0) {
				this.stopService();
				System.exit(0);
			}
		} else if (obj == helpItem) {
			Help help = new Help(this);
			help.show();
		} else if (obj == sysMessage || obj == sysMessageButton)
			this.sendSystemMessage();
	}
}
