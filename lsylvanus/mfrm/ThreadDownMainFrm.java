package com.lsylvanus.mfrm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.lsylvanus.util.DownloadUtils;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadDownMainFrm extends JFrame {

	private JPanel contentPane;
	private JTextField p_url_txf;
	private JTextField p_fname_txf;
	private JTextField p_pname_txf;
	private final ButtonGroup Jbg_splitters = new ButtonGroup();

	private JRadioButton Jrbtn_splitter_1;
	private JRadioButton Jrbtn_splitter_2;
	private JRadioButton Jrbtn_splitter_3;
	private JRadioButton Jrbtn_splitter_4;
	private JRadioButton Jrbtn_splitter_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadDownMainFrm frame = new ThreadDownMainFrm();
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
	public ThreadDownMainFrm() {
		setTitle("\u591A\u7EBF\u7A0B\u4E0B\u8F7D\u6D4B\u8BD5");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("\u4E0B\u8F7D\u5730\u5740\uFF1A");

		JLabel label = new JLabel("\u6587\u4EF6\u540D\u79F0\uFF1A");

		JLabel label_1 = new JLabel("\u4E0B\u8F7D\u76EE\u5F55\uFF1A");

		JLabel label_2 = new JLabel("\u7EBF\u7A0B\u6570\uFF1A");

		p_url_txf = new JTextField();
		p_url_txf.setColumns(10);

		p_fname_txf = new JTextField();
		p_fname_txf.setColumns(10);

		p_pname_txf = new JTextField();
		p_pname_txf.setColumns(10);

		Jrbtn_splitter_1 = new JRadioButton("1");
		Jbg_splitters.add(Jrbtn_splitter_1);

		Jrbtn_splitter_2 = new JRadioButton("2");
		Jbg_splitters.add(Jrbtn_splitter_2);

		Jrbtn_splitter_3 = new JRadioButton("3");
		Jbg_splitters.add(Jrbtn_splitter_3);

		Jrbtn_splitter_4 = new JRadioButton("4");
		Jbg_splitters.add(Jrbtn_splitter_4);

		Jrbtn_splitter_5 = new JRadioButton("5");
		Jrbtn_splitter_5.setSelected(true);
		Jbg_splitters.add(Jrbtn_splitter_5);

		JButton btn_commit = new JButton("\u4E0B\u8F7D");
		btn_commit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DownLoadActionPerformed(e);
			}
		});

		JButton btn_exit = new JButton("\u9000\u51FA");
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExitMainFrmActionPerformed(e);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(lblNewLabel).addGap(18)
								.addComponent(p_url_txf, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup().addComponent(label).addGap(18).addComponent(
								p_fname_txf, GroupLayout.PREFERRED_SIZE, 389, GroupLayout.PREFERRED_SIZE))
						.addGroup(
								gl_contentPane.createSequentialGroup()
										.addComponent(
												label_1)
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(p_pname_txf, GroupLayout.PREFERRED_SIZE, 388,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(Jrbtn_splitter_1).addGap(41)
														.addComponent(Jrbtn_splitter_2).addGap(49)
														.addComponent(Jrbtn_splitter_3)
														.addPreferredGap(ComponentPlacement.RELATED, 139,
																Short.MAX_VALUE)
														.addComponent(Jrbtn_splitter_5).addGap(36)))))
				.addContainerGap(57, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(151, Short.MAX_VALUE)
										.addComponent(btn_commit).addGap(93).addComponent(btn_exit))
								.addGroup(Alignment.LEADING,
										gl_contentPane.createSequentialGroup().addGap(14).addComponent(label_2)
												.addPreferredGap(ComponentPlacement.RELATED, 265, Short.MAX_VALUE)
												.addComponent(Jrbtn_splitter_4)))
						.addGap(176)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(45)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNewLabel).addComponent(
						p_url_txf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(31)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label).addComponent(
						p_fname_txf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(31)
				.addGroup(
						gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(label_1)
								.addComponent(p_pname_txf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
				.addGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPane.createSequentialGroup().addGap(30)
												.addComponent(
														label_2))
								.addGroup(gl_contentPane.createSequentialGroup().addGap(35)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(Jrbtn_splitter_3).addComponent(Jrbtn_splitter_4)
												.addComponent(Jrbtn_splitter_5).addComponent(Jrbtn_splitter_2)
												.addComponent(Jrbtn_splitter_1))))
				.addPreferredGap(ComponentPlacement.RELATED, 23, Short.MAX_VALUE).addGroup(gl_contentPane
						.createParallelGroup(Alignment.BASELINE).addComponent(btn_commit).addComponent(btn_exit))
				.addGap(22)));
		contentPane.setLayout(gl_contentPane);
	}

	private void ExitMainFrmActionPerformed(ActionEvent e) {
		System.exit(0);
	}

	private void DownLoadActionPerformed(ActionEvent e) {
		/*if (this.p_url_txf.equals("")) {
			System.err.println("url is null!");
		}else if (this.p_fname_txf.equals("")) {
			System.err.println("fileName is null!");
		}else if (this.p_pname_txf.equals("")) {
			System.err.println("filePath is null!");
		}*/
		
		String url = this.p_url_txf.getText();
		String fileName = this.p_fname_txf.getText();
		String filePath = this.p_pname_txf.getText();
		
		int splitter_num = 0;
		
		if (this.Jrbtn_splitter_1.isSelected()) {
			splitter_num = 1;
		}else if (this.Jrbtn_splitter_2.isSelected()) {
			splitter_num = 2;
		}else if (this.Jrbtn_splitter_3.isSelected()) {
			splitter_num = 3;
		}else if (this.Jrbtn_splitter_4.isSelected()) {
			splitter_num = 4;
		}else if (this.Jrbtn_splitter_5.isSelected()) {
			splitter_num = 5;
		}
		
		DownloadUtils.download(url, fileName, filePath, splitter_num);
	}
}
