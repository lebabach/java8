package asyn;

import java.util.List;

public class Mail {

	public static List<String> sendMessage(List<String> notifies) {
		notifies.forEach(x -> System.out.println("system 1: sent to " + x.toString()));
		return notifies;
	}
	public static List<String> sendMessage2(List<String> notifies) {
		notifies.forEach(x -> System.out.println("system 2: sent to " + x.toString()));
		return notifies;
	}

	public static void notifyMessage(List<String> notifies) {
		notifies.forEach(x -> System.out.println("notified to " + x.toString()));
	}
}
