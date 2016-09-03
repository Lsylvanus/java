package com.lsylvanus.Evm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

/**
 * 我一生都在等待 直到你闯进我的世界 我只想对你说：余生请多指教
 * 
 * @author fx-pro
 *
 */
public class WaitForYou {

	private static String my_life = "吃饭睡觉撸代码";
	private static String youself = "lsylvanus";
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static StringBuffer sb;

	public static void main(String[] args) throws InterruptedException {

		String my_birth = "1994-08-25";
		String met_you = "2010-04-08";
		try {
			long met_you_days = (sdf.parse(met_you).getTime() - sdf.parse(my_birth).getTime()) / 24 / 60 / 60 / 1000;
			while (met_you_days != 0) {
				// Thread.sleep(50);
				System.out.println(my_life + "..." + "距离与你相遇还有" + met_you_days + "天.");
				met_you_days--;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

		if (isLsylvanus() && isLsBirth()) {
			System.out.println("\n我一生都在等待...直到你闯进我的世界...我只想对你说：余生请多指教!");
		}
		/*
		 * if (PushInMyHeart()) {
		 * System.out.println("\n我一生都在等待...直到你闯进我的世界...我只想对你说：余生请多指教!"); }
		 */
	}

	public static boolean PushInMyHeart() {
		char[] arr = new char[] { 'l', 's', 'y', 'l', 'v', 'a', 'n', 'u', 's' };
		String lsylvanus = "";
		for (int i = 0; i < arr.length; i++) {
			lsylvanus = lsylvanus + arr[i];
			if (lsylvanus.equals(youself)) {
				return true;
			}
		}
		return false;
	}

	public static boolean isLsylvanus() {
		String string = "abcdefghijklmnopqrstuvwxyz";
		int count;
		String ls = "";
		while (true) {
			Random random = new Random();
			count = random.nextInt(26);
			// System.out.println(count);
			if ((count) == 11) {
				// System.out.println(count);
				ls = ls + string.charAt(count);
				// System.out.println(ls);
				break;
			}
		}
		while (true) {
			Random random = new Random();
			count = random.nextInt(26);
			if ((count) == 18) {
				ls = ls + string.charAt(count);
				// System.out.println(ls);
				break;
			}
		}
		// System.out.println(ls);
		if (ls.equals("ls")) {
			return true;
		}
		return false;
	}

	public static boolean isLsBirth() {
		int birth;
		int people = 0;
		int count = 1;
			while (true) {
				Random random = new Random();
				birth = random.nextInt(940207);// 0-940206
				people++;
				if (people == 30 * count) {
					System.out.println("");
					count++;
				}
				//Thread.sleep(30);
				System.out.print(birth + " ");
				if (birth == 940206) {
					// System.out.println(birth);
					System.out.println("\n" + people + "人中，我终于找到了你！");
					break;
				}
			}
		return true;
	}
}
